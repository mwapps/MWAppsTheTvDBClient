package com.manriqueweb.thetvdbclient.services;

import com.manriqueweb.thetvdbclient.entities.UpdatesResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Updates {

    @GET("updated/query")
    Call<UpdatesResponse> updates(@Query("fromTime") Long fromTime, @Query("toTime") Long toTime);
}
