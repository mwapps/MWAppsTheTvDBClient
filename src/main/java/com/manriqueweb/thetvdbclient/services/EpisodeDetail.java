package com.manriqueweb.thetvdbclient.services;

import com.manriqueweb.thetvdbclient.TheTvDBClient;
import com.manriqueweb.thetvdbclient.entities.EpisodeDetailResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

public interface EpisodeDetail {

	@GET("episodes/{id}")
	Call<EpisodeDetailResponse> getEpisode(@Path("id") int id, @Header(TheTvDBClient.HEADER_ACCEPT_LANGUAGE) String language);

}
