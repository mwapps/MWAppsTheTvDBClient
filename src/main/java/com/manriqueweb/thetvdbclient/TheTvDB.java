package com.manriqueweb.thetvdbclient;

import java.io.IOException;
import java.util.Date;

import org.joda.time.DateTime;

import com.manriqueweb.thetvdbclient.entities.ActorResponse;
import com.manriqueweb.thetvdbclient.entities.BasicCredentials;
import com.manriqueweb.thetvdbclient.entities.EpisodeDetailResponse;
import com.manriqueweb.thetvdbclient.entities.EpisodeResponse;
import com.manriqueweb.thetvdbclient.entities.SerieByIdResponse;
import com.manriqueweb.thetvdbclient.entities.SerieResponse;
import com.manriqueweb.thetvdbclient.entities.TokenResponse;
import com.manriqueweb.thetvdbclient.entities.UpdatesResponse;
import com.manriqueweb.thetvdbclient.exceptions.TheTvDBClientException;

import retrofit2.Call;
import retrofit2.Response;

public class TheTvDB {
    private TheTvDBClient theTvDBClient = null;

	public TheTvDB(String apikey, String username, String userkey, String defaultlanguaje) {
		this.theTvDBClient = new TheTvDBClient(new BasicCredentials(apikey, username, userkey, defaultlanguaje));
	}
	

    /**
     * Retrieve the current token
     */
    public String getCurrentToken() throws TheTvDBClientException {
    	
		try {
	    	Call<TokenResponse> calling = this.theTvDBClient.authentication().login(this.theTvDBClient.getBasicCredentials());
	    	Response<TokenResponse> response = calling.execute();
	    	return response.body().getToken();
		} catch (IOException ioe) {
		    throw new TheTvDBClientException(ioe.getMessage());
		}

    }
    /**
     * Retrieve the updates from series.
     */
    public UpdatesResponse updates(Date fromTime, Integer nDays) throws TheTvDBClientException {
    	UpdatesResponse updatesResponse = null;

		retrofit2.Response<UpdatesResponse> response;
		try {
        	if(fromTime==null)
        		fromTime = new Date();
        	
            final DateTime starDateTime = new DateTime(fromTime)
            		.withHourOfDay(0)
                	.withMinuteOfHour(0)
                	.withSecondOfMinute(0);
            
            if(nDays==null || nDays>7)
        		nDays = 7;
            
            DateTime toDateTime = starDateTime.plusDays(nDays)
            		.withHourOfDay(0)
                	.withMinuteOfHour(0)
                	.withSecondOfMinute(0);
            
			response = this.theTvDBClient.updates()
			    .updates(starDateTime.getMillis()/1000, toDateTime.getMillis()/1000)
			    .execute();
			
			if (!response.isSuccessful()) {
			    throw new TheTvDBClientException(response.message());
			}
			
			updatesResponse = response.body();
		} catch (IOException ioe) {
		    throw new TheTvDBClientException(ioe.getMessage());
		}
		
		return updatesResponse;
    }

    public SerieResponse search(final String seriesName, String languaje) throws IllegalArgumentException, TheTvDBClientException {
    	SerieResponse serieResponse = null;
    	
		if(seriesName==null)
		    throw new IllegalArgumentException("imdbID is null");
		
		retrofit2.Response<SerieResponse> response;
		try {
			
			if(languaje==null)
				languaje = theTvDBClient.getBasicCredentials().getDefaultlanguaje();
            
			response = this.theTvDBClient.search()
			    .searchSeriesByName(seriesName, languaje)
			    .execute();
			
			if (!response.isSuccessful()) {
			    throw new TheTvDBClientException(response.message());
			}
			
			serieResponse = response.body();
		} catch (IOException ioe) {
		    throw new TheTvDBClientException(ioe.getMessage());
		}
		
        return serieResponse;
    }

    public SerieResponse searchByIMDB(final String imdbID, String languaje) throws IllegalArgumentException, TheTvDBClientException  {
    	SerieResponse serieResponse = null;
    	
		if(imdbID==null)
		    throw new IllegalArgumentException("imdbID is null");
		
		retrofit2.Response<SerieResponse> response;
		try {
			
			if(languaje==null)
				languaje = theTvDBClient.getBasicCredentials().getDefaultlanguaje();
            
			response = this.theTvDBClient.search()
			    .searchSeriesByIMDB(imdbID, languaje)
			    .execute();
			
			if (!response.isSuccessful()) {
			    throw new TheTvDBClientException(response.message());
			}
			
			serieResponse = response.body();
		} catch (IOException ioe) {
		    throw new TheTvDBClientException(ioe.getMessage());
		}
		
        return serieResponse;
    }

    public SerieResponse searchByZap2itId(final String zap2itId, String languaje) throws IllegalArgumentException, TheTvDBClientException {
    	SerieResponse serieResponse = null;
    	
		if(zap2itId==null)
		    throw new IllegalArgumentException("zap2itId is null");

		retrofit2.Response<SerieResponse> response;
		try {
			
			if(languaje==null)
				languaje = theTvDBClient.getBasicCredentials().getDefaultlanguaje();
            
			response = this.theTvDBClient.search()
			    .searchSeriesByZap2itId(zap2itId, languaje)
			    .execute();
			
			if (!response.isSuccessful()) {
			    throw new TheTvDBClientException(response.message());
			}
			
			serieResponse = response.body();
		} catch (IOException ioe) {
		    throw new TheTvDBClientException(ioe.getMessage());
		}
		
        return serieResponse;
    }
    
    public SerieByIdResponse serieById(final Integer serieId, String languaje) throws IllegalArgumentException, TheTvDBClientException {
    	SerieByIdResponse serieResponse = null;
    	
		if(serieId==null)
		    throw new IllegalArgumentException("serieId is null");
		if(serieId<0)
		    throw new IllegalArgumentException("serieId is less than zero");
		if(serieId==0)
		    throw new IllegalArgumentException("serieId is zero");

		retrofit2.Response<SerieByIdResponse> response;
		try {
			
			if(languaje==null)
				languaje = theTvDBClient.getBasicCredentials().getDefaultlanguaje();
            
			response = this.theTvDBClient.serie()
			    .serie(serieId.intValue(), languaje)
			    .execute();
			
			if (!response.isSuccessful()) {
			    throw new TheTvDBClientException(response.message());
			}
			
			serieResponse = response.body();
		} catch (IOException ioe) {
		    throw new TheTvDBClientException(ioe.getMessage());
		}
		
        return serieResponse;
    }

    public ActorResponse actorsBySerieId(final Integer serieId) throws IllegalArgumentException, TheTvDBClientException {
    	ActorResponse actorResponse = null;
    	
		if(serieId==null)
		    throw new IllegalArgumentException("serieId is null");
		if(serieId<0)
		    throw new IllegalArgumentException("serieId is less than zero");
		if(serieId==0)
		    throw new IllegalArgumentException("serieId is zero");

		retrofit2.Response<ActorResponse> response;
		try {
			
			response = this.theTvDBClient.serie()
			    .actors(serieId.intValue())
			    .execute();
			
			if (!response.isSuccessful()) {
			    throw new TheTvDBClientException(response.message());
			}
			
			actorResponse = response.body();
		} catch (IOException ioe) {
		    throw new TheTvDBClientException(ioe.getMessage());
		}
		
        return actorResponse;
    }

    public EpisodeResponse episodesBySerieById(final Integer serieId, final Integer pageNumber, String languaje) throws IllegalArgumentException, TheTvDBClientException {
    	EpisodeResponse episodeResponse = null;
    	
		if(serieId==null)
		    throw new IllegalArgumentException("serieId is null");
		else if(serieId<0)
		    throw new IllegalArgumentException("serieId is less than zero");
		else if(serieId==0)
		    throw new IllegalArgumentException("serieId is zero");

		retrofit2.Response<EpisodeResponse> response;
		try {
			if(languaje==null)
				languaje = theTvDBClient.getBasicCredentials().getDefaultlanguaje();
			
			response = this.theTvDBClient.serie()
			    .episodes(serieId.intValue(), pageNumber, languaje)
			    .execute();
			
			if (!response.isSuccessful()) {
			    throw new TheTvDBClientException(response.message());
			}
			
			episodeResponse = response.body();
		} catch (IOException ioe) {
		    throw new TheTvDBClientException(ioe.getMessage());
		}
		
        return episodeResponse;
    }

    public EpisodeDetailResponse episodeById(final Integer episodeId, String languaje) throws IllegalArgumentException, TheTvDBClientException {
    	EpisodeDetailResponse episodeResponse = null;
    	
		if(episodeId==null)
		    throw new IllegalArgumentException("episodeId is null");
		else if(episodeId<0)
		    throw new IllegalArgumentException("episodeId is less than zero");
		else if(episodeId==0)
		    throw new IllegalArgumentException("episodeId is zero");

		retrofit2.Response<EpisodeDetailResponse> response;
		try {
			if(languaje==null)
				languaje = theTvDBClient.getBasicCredentials().getDefaultlanguaje();
			
			response = this.theTvDBClient.EpisodeDetail()
				.getEpisode(episodeId.intValue(), languaje)
			    .execute();
			
			if (!response.isSuccessful()) {
			    throw new TheTvDBClientException(response.message());
			}
			
			episodeResponse = response.body();
		} catch (IOException ioe) {
		    throw new TheTvDBClientException(ioe.getMessage());
		}
		
        return episodeResponse;
    }
}
