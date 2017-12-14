package com.manriqueweb.thetvdbclient.services;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

import com.manriqueweb.thetvdbclient.TheTvDBClient;
import com.manriqueweb.thetvdbclient.entities.SerieResponse;

public interface SearchSeries {

	@GET("search/series")
	Call<SerieResponse> searchSeriesByName(@Query("name") String name,
			@Header(TheTvDBClient.HEADER_ACCEPT_LANGUAGE) String languages);

	@GET("search/series")
	Call<SerieResponse> searchSeriesByIMDB(@Query("imdbId") String imdbId,
			@Header(TheTvDBClient.HEADER_ACCEPT_LANGUAGE) String languages);

	@GET("search/series")
	Call<SerieResponse> searchSeriesByZap2itId(@Query("zap2itId") String zap2itId,
			@Header(TheTvDBClient.HEADER_ACCEPT_LANGUAGE) String languages);
}
