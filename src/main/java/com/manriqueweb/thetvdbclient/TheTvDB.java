package com.manriqueweb.thetvdbclient;

import java.io.IOException;
import java.util.Date;

import org.apache.commons.validator.routines.UrlValidator;
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
import com.manriqueweb.thetvdbclient.ifaces.IApiResponse;

import retrofit2.Call;
import retrofit2.Callback;
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

    public void updates(Date fromTime, Integer nDays, final IApiResponse<UpdatesResponse> mListener) throws TheTvDBClientException {
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
        
    	Call<UpdatesResponse> calling = this.theTvDBClient.updates()
			    .updates(starDateTime.getMillis()/1000, toDateTime.getMillis()/1000);
    	
    	calling.enqueue(new Callback<UpdatesResponse>() {
			@Override
			public void onResponse(Call<UpdatesResponse> call, Response<UpdatesResponse> dataResponse) {
                if(dataResponse.isSuccessful()){
                    mListener.onResponse(dataResponse.body());
                }else{
                	assert dataResponse.errorBody() != null;
                    mListener.onError(dataResponse.errorBody().toString());
                }
			}
			
			@Override
			public void onFailure(Call<UpdatesResponse> call, Throwable dataThrowable) {
				mListener.onError(dataThrowable.getLocalizedMessage());
			}
		});
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
    
    public void search(final String seriesName, String languaje, final IApiResponse<SerieResponse> mListener) throws IllegalArgumentException, TheTvDBClientException {
		if(seriesName==null)
		    throw new IllegalArgumentException("imdbID is null");
		if(languaje==null)
			languaje = theTvDBClient.getBasicCredentials().getDefaultlanguaje();
		
    	Call<SerieResponse> calling = this.theTvDBClient.search().searchSeriesByName(seriesName, languaje);
    	calling.enqueue(new Callback<SerieResponse>() {
			
			@Override
			public void onResponse(Call<SerieResponse> call, Response<SerieResponse> dataResponse) {
                if(dataResponse.isSuccessful()){
                    mListener.onResponse(dataResponse.body());
                }else{
                	assert dataResponse.errorBody() != null;
                    mListener.onError(dataResponse.errorBody().toString());
                }
			}
			
			@Override
			public void onFailure(Call<SerieResponse> call, Throwable dataThrowable) {
				mListener.onError(dataThrowable.getLocalizedMessage());
			}
		});
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
    
    public void searchByIMDB(final String imdbID, String languaje, final IApiResponse<SerieResponse> mListener) throws IllegalArgumentException, TheTvDBClientException  {
		if(imdbID==null)
		    throw new IllegalArgumentException("imdbID is null");
		if(languaje==null)
			languaje = theTvDBClient.getBasicCredentials().getDefaultlanguaje();
		
    	Call<SerieResponse> calling = this.theTvDBClient.search().searchSeriesByIMDB(imdbID, languaje);
    	calling.enqueue(new Callback<SerieResponse>() {
			
			@Override
			public void onResponse(Call<SerieResponse> call, Response<SerieResponse> dataResponse) {
                if(dataResponse.isSuccessful()){
                    mListener.onResponse(dataResponse.body());
                }else{
                	assert dataResponse.errorBody() != null;
                    mListener.onError(dataResponse.errorBody().toString());
                }
			}
			
			@Override
			public void onFailure(Call<SerieResponse> call, Throwable dataThrowable) {
				mListener.onError(dataThrowable.getLocalizedMessage());
			}
		});
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
    
    public void searchByZap2itId(final String zap2itId, String languaje, final IApiResponse<SerieResponse> mListener) throws IllegalArgumentException, TheTvDBClientException {
		if(zap2itId==null)
		    throw new IllegalArgumentException("zap2itId is null");
		if(languaje==null)
			languaje = theTvDBClient.getBasicCredentials().getDefaultlanguaje();
    	
    	Call<SerieResponse> calling = this.theTvDBClient.search().searchSeriesByZap2itId(zap2itId, languaje);
    	calling.enqueue(new Callback<SerieResponse>() {
			
			@Override
			public void onResponse(Call<SerieResponse> call, Response<SerieResponse> dataResponse) {
                if(dataResponse.isSuccessful()){
                    mListener.onResponse(dataResponse.body());
                }else{
                	assert dataResponse.errorBody() != null;
                    mListener.onError(dataResponse.errorBody().toString());
                }
			}
			
			@Override
			public void onFailure(Call<SerieResponse> call, Throwable dataThrowable) {
				mListener.onError(dataThrowable.getLocalizedMessage());
			}
		});
    }
    
    public SerieByIdResponse serieById(final Long serieId, String languaje) throws IllegalArgumentException, TheTvDBClientException {
    	SerieByIdResponse serieResponse = null;
    	
		if(serieId==null)
		    throw new IllegalArgumentException("serieId is null");
		if(serieId<(long)0)
		    throw new IllegalArgumentException("serieId is less than zero");
		if(serieId==(long)0)
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
    
    public void serieById(final Long serieId, String languaje, final IApiResponse<SerieByIdResponse> mListener) throws IllegalArgumentException, TheTvDBClientException {
		if(serieId==null)
		    throw new IllegalArgumentException("serieId is null");
		if(serieId<(long)0)
		    throw new IllegalArgumentException("serieId is less than zero");
		if(serieId==(long)0)
		    throw new IllegalArgumentException("serieId is zero");
		if(languaje==null)
			languaje = theTvDBClient.getBasicCredentials().getDefaultlanguaje();
		
    	Call<SerieByIdResponse> calling = this.theTvDBClient.serie().serie(serieId.intValue(), languaje);
    	calling.enqueue(new Callback<SerieByIdResponse>() {
			@Override
			public void onResponse(Call<SerieByIdResponse> call, Response<SerieByIdResponse> dataResponse) {
                if(dataResponse.isSuccessful()){
                    mListener.onResponse(dataResponse.body());
                }else{
                	assert dataResponse.errorBody() != null;
                    mListener.onError(dataResponse.errorBody().toString());
                }
			}
			
			@Override
			public void onFailure(Call<SerieByIdResponse> call, Throwable dataThrowable) {
				mListener.onError(dataThrowable.getLocalizedMessage());
			}
		});
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
    
    public void actorsBySerieId(final Integer serieId, final IApiResponse<ActorResponse> mListener) throws IllegalArgumentException, TheTvDBClientException {
		if(serieId==null)
		    throw new IllegalArgumentException("serieId is null");
		if(serieId<0)
		    throw new IllegalArgumentException("serieId is less than zero");
		if(serieId==0)
		    throw new IllegalArgumentException("serieId is zero");
    	
    	Call<ActorResponse> calling = this.theTvDBClient.serie().actors(serieId.intValue());
    	calling.enqueue(new Callback<ActorResponse>() {
			
			@Override
			public void onResponse(Call<ActorResponse> call, Response<ActorResponse> dataResponse) {
                if(dataResponse.isSuccessful()){
                    mListener.onResponse(dataResponse.body());
                }else{
                	assert dataResponse.errorBody() != null;
                    mListener.onError(dataResponse.errorBody().toString());
                }
			}
			
			@Override
			public void onFailure(Call<ActorResponse> call, Throwable dataThrowable) {
				mListener.onError(dataThrowable.getLocalizedMessage());
			}
		});
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
    
    public void episodesBySerieById(final Integer serieId, final Integer pageNumber, String languaje, final IApiResponse<EpisodeResponse> mListener) throws IllegalArgumentException, TheTvDBClientException {
		if(serieId==null)
		    throw new IllegalArgumentException("serieId is null");
		else if(serieId<0)
		    throw new IllegalArgumentException("serieId is less than zero");
		else if(serieId==0)
		    throw new IllegalArgumentException("serieId is zero");
		if(languaje==null)
			languaje = theTvDBClient.getBasicCredentials().getDefaultlanguaje();
		
    	Call<EpisodeResponse> calling = this.theTvDBClient.serie().episodes(serieId.intValue(), pageNumber, languaje);
    	calling.enqueue(new Callback<EpisodeResponse>() {
			
			@Override
			public void onResponse(Call<EpisodeResponse> call, Response<EpisodeResponse> dataResponse) {
                if(dataResponse.isSuccessful()){
                    mListener.onResponse(dataResponse.body());
                }else{
                	assert dataResponse.errorBody() != null;
                    mListener.onError(dataResponse.errorBody().toString());
                }
			}
			
			@Override
			public void onFailure(Call<EpisodeResponse> call, Throwable dataThrowable) {
				mListener.onError(dataThrowable.getLocalizedMessage());
			}
		});
		
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
    
    public void episodeById(final Integer episodeId, String languaje, final IApiResponse<EpisodeDetailResponse> mListener) throws IllegalArgumentException, TheTvDBClientException {
		if(episodeId==null)
		    throw new IllegalArgumentException("episodeId is null");
		else if(episodeId<0)
		    throw new IllegalArgumentException("episodeId is less than zero");
		else if(episodeId==0)
		    throw new IllegalArgumentException("episodeId is zero");
		if(languaje==null)
			languaje = theTvDBClient.getBasicCredentials().getDefaultlanguaje();

		
    	Call<EpisodeDetailResponse> calling = this.theTvDBClient.EpisodeDetail().getEpisode(episodeId.intValue(), languaje);
    	calling.enqueue(new Callback<EpisodeDetailResponse>() {
			
			@Override
			public void onResponse(Call<EpisodeDetailResponse> call, Response<EpisodeDetailResponse> dataResponse) {
                if(dataResponse.isSuccessful()){
                    mListener.onResponse(dataResponse.body());
                }else{
                	assert dataResponse.errorBody() != null;
                    mListener.onError(dataResponse.errorBody().toString());
                }
			}
			
			@Override
			public void onFailure(Call<EpisodeDetailResponse> call, Throwable dataThrowable) {
				mListener.onError(dataThrowable.getLocalizedMessage());
			}
		});
    }

    public byte[] downloadImage(final String imageURL) throws IllegalArgumentException, TheTvDBClientException {
    	byte[] responseImage = null;
    	
		if(imageURL==null)
		    throw new IllegalArgumentException("The image url is invalid");
		
		final String newURL = new StringBuilder().append(TheTvDBClient.IMAGE_HOST).append(imageURL).toString();
		
		if(!(new UrlValidator().isValid(newURL)))
		    throw new IllegalArgumentException("The image url is invalid");
		
		responseImage = this.theTvDBClient.downloadImage(newURL);
    	
        return responseImage;
    }

}
