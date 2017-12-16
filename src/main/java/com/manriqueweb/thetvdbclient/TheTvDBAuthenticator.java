package com.manriqueweb.thetvdbclient;

import java.io.IOException;

import com.manriqueweb.thetvdbclient.entities.TokenResponse;
import com.manriqueweb.thetvdbclient.services.TheTvDBClientAuthentication;

import okhttp3.Authenticator;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;
import retrofit2.Call;


public class TheTvDBAuthenticator implements Authenticator {
	
    public static final String PATH_LOGIN = "/" + TheTvDBClientAuthentication.PATH_LOGIN;
    private TheTvDBClient theTvDBClient;

    public TheTvDBAuthenticator(TheTvDBClient theTvDBClient) {
        this.theTvDBClient = theTvDBClient;
    }

    @Override
    public Request authenticate(Route route, Response response) throws IOException {
        return handleRequest(response, theTvDBClient);
    }

    /**
     * @param response {@link #authenticate(Route, Response)}.
     * @param theTvDBClient {@link TheTvdbClient} instance to use API key from and to set the updated JSON web token on.
     * @return Null if no auth is possible, else a request with updated authorization header.
     */
    public static Request handleRequest(Response response, TheTvDBClient theTvDBClient) throws IOException {
        String path = response.request().url().encodedPath();
        if (PATH_LOGIN.equals(path)) {
            return null;
        }
        if (responseCount(response) >= 2) {
            return null;
        }

        Call<TokenResponse> loginCall = theTvDBClient.authentication().login(theTvDBClient.getBasicCredentials());
        retrofit2.Response<TokenResponse> loginResponse = loginCall.execute();
        if (!loginResponse.isSuccessful()) {
            return null;
        }

        String jsonWebToken = loginResponse.body().getToken();
        theTvDBClient.jsonWebToken(jsonWebToken);

        return response.request().newBuilder()
                .header(TheTvDBClient.HEADER_AUTHORIZATION, "Bearer" + " " + jsonWebToken)
                .build();
    }

    private static int responseCount(Response response) {
        int result = 1;
        while ((response = response.priorResponse()) != null) {
            result++;
        }
        return result;
    }

}
