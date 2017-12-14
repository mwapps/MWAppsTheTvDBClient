package com.manriqueweb.thetvdbclient;

import com.manriqueweb.thetvdbclient.entities.BasicCredentials;
import com.manriqueweb.thetvdbclient.services.SearchSeries;
import com.manriqueweb.thetvdbclient.services.TheTvDBClientAuthentication;
import com.manriqueweb.thetvdbclient.services.Updates;
import com.manriqueweb.thetvdbclient.services.Serie;
import com.manriqueweb.thetvdbclient.services.EpisodeDetail;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;;

public class TheTvDBClient {
    public static final String API_HOST = "api.thetvdb.com";
    public static final String API_URL = "https://" + API_HOST + "/";
    public static final String API_VERSION = "2.1.2";

    public static final String HEADER_ACCEPT = "Accept";
    public static final String HEADER_ACCEPT_LANGUAGE = "Accept-Language";
    public static final String HEADER_AUTHORIZATION = "Authorization";

    private OkHttpClient okHttpClient;
    private Retrofit retrofit;

    private BasicCredentials basicCredentials;
    private String currentJsonWebToken;

    public TheTvDBClient(BasicCredentials basicCredentials) {
        this.basicCredentials = basicCredentials;
    }

    public BasicCredentials getBasicCredentials() {
		return basicCredentials;
	}


	public void setBasicCredentials(BasicCredentials basicCredentials) {
		this.basicCredentials = basicCredentials;
	}


	public String jsonWebToken() {
        return currentJsonWebToken;
    }

    public void jsonWebToken(String value) {
        this.currentJsonWebToken = value;
    }

    private Retrofit.Builder retrofitBuilder() {
        return new Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(JacksonConverterFactory.create())
                .client(okHttpClient());
    }

    private synchronized OkHttpClient okHttpClient() {
        if (okHttpClient == null) {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            setOkHttpClientDefaults(builder);
            okHttpClient = builder.build();
        }
        return okHttpClient;
    }

    private void setOkHttpClientDefaults(OkHttpClient.Builder builder) {
        builder.addNetworkInterceptor(new TheTvDBClientInterceptor(this))
                .authenticator(new TheTvDBAuthenticator(this));
    }

    private Retrofit getRetrofit() {
        if (retrofit == null) {
            retrofit = retrofitBuilder().build();
        }
        return retrofit;
    }

    /**
     * Get and refresh the JWT token.
     */
    public TheTvDBClientAuthentication authentication() {
        return getRetrofit().create(TheTvDBClientAuthentication.class);
    }

    /**
     * Retrieve the updates from series.
     */
    public Updates updates() {
        return getRetrofit().create(Updates.class);
    }

    /**
     * Search series by name, imdbID or zap2itId.
     */
    public SearchSeries search() {
        return getRetrofit().create(SearchSeries.class);
    }

    /**
     * Get Serie entity
     */
    public Serie serie() {
        return getRetrofit().create(Serie.class);
    }

    /**
     * Get Episode entity
     */
    public EpisodeDetail EpisodeDetail() {
        return getRetrofit().create(EpisodeDetail.class);
    }
}
