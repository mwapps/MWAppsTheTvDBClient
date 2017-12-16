/**
 * 
 */
package com.manriqueweb.thetvdbclient;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

/**
 * @author omar
 *
 */
public class TheTvDBClientInterceptor implements Interceptor {
	
	private TheTvDBClient theTvDBClient;

	/**
	 * 
	 */
	public TheTvDBClientInterceptor(TheTvDBClient theTvDBClient) {
		this.theTvDBClient = theTvDBClient;
	}

	/* (non-Javadoc)
	 * @see okhttp3.Interceptor#intercept(okhttp3.Interceptor.Chain)
	 */
	@Override
	public Response intercept(Chain chain) throws IOException {
		return handleIntercept(chain, jsonWebToken());
	}
	
    public static Response handleIntercept(Chain chain, String jsonWebToken) throws IOException {
        Request request = chain.request();
        if (!TheTvDBClient.API_HOST.equals(request.url().host())) {

            return chain.proceed(request);
        }

        Request.Builder builder = request.newBuilder();

        builder.header(TheTvDBClient.HEADER_ACCEPT, "application/vnd.theTvDBClient.v" + TheTvDBClient.API_VERSION);

        if (hasNoAuthorizationHeader(request) && jsonWebTokenIsNotEmpty(jsonWebToken)) {
            builder.header(TheTvDBClient.HEADER_AUTHORIZATION, "Bearer" + " " + jsonWebToken);
        }
        return chain.proceed(builder.build());
    }

    public String jsonWebToken() {
        return theTvDBClient.jsonWebToken();
    }

    private static boolean hasNoAuthorizationHeader(Request request) {
        return request.header(TheTvDBClient.HEADER_AUTHORIZATION) == null;
    }

    private static boolean jsonWebTokenIsNotEmpty(String jsonWebToken) {
        return jsonWebToken != null && jsonWebToken.length() != 0;
    }

}
