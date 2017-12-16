package com.manriqueweb.thetvdbclient.services;

import com.manriqueweb.thetvdbclient.entities.BasicCredentials;
import com.manriqueweb.thetvdbclient.entities.TokenResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface TheTvDBClientAuthentication {
	
    String PATH_LOGIN = "login";

    @POST(PATH_LOGIN)
    Call<TokenResponse> login(@Body BasicCredentials basicCredentials);

    @GET("refresh_token")
    Call<TokenResponse> refreshToken();
    
}
