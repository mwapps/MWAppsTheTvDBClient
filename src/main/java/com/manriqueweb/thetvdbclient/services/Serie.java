package com.manriqueweb.thetvdbclient.services;

import com.manriqueweb.thetvdbclient.TheTvDBClient;
import com.manriqueweb.thetvdbclient.entities.ActorResponse;
import com.manriqueweb.thetvdbclient.entities.EpisodeResponse;
import com.manriqueweb.thetvdbclient.entities.SerieByIdResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Serie {

	@GET("series/{id}")
	Call<SerieByIdResponse> serie(@Path("id") int id, @Header(TheTvDBClient.HEADER_ACCEPT_LANGUAGE) String language);

	@GET("series/{id}/actors")
	Call<ActorResponse> actors(@Path("id") int id);

	@GET("series/{id}/episodes")
	Call<EpisodeResponse> episodes(@Path("id") int id, @Query("page") Integer page,
			@Header(TheTvDBClient.HEADER_ACCEPT_LANGUAGE) String language);

}
