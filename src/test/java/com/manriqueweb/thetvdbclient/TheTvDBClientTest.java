package com.manriqueweb.thetvdbclient;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.manriqueweb.thetvdbclient.entities.ActorResponse;
import com.manriqueweb.thetvdbclient.entities.EpisodeDetailResponse;
import com.manriqueweb.thetvdbclient.entities.EpisodeResponse;
import com.manriqueweb.thetvdbclient.entities.SerieByIdResponse;
import com.manriqueweb.thetvdbclient.entities.SerieResponse;
import com.manriqueweb.thetvdbclient.entities.UpdatesResponse;
import com.manriqueweb.thetvdbclient.exceptions.TheTvDBClientException;

public class TheTvDBClientTest {
	
	TheTvDB theTvDB = null;
	
	public TheTvDBClientTest(){
    	theTvDB = new TheTvDB(
	    			DataForTest.getBasicCredentials().getApikey(),
	    			DataForTest.getBasicCredentials().getUsername(),
	    			DataForTest.getBasicCredentials().getUserkey(),
	    			DataForTest.getBasicCredentials().getDefaultlanguaje()
    			);
	}
	
	
    @Test
    public void testTheTvDB() {
		try {
			assertNotNull(theTvDB.getCurrentToken());
		} catch (TheTvDBClientException e) {
			fail(e.getMessage());
		}
    }
    
    @Test
    public void testUpdates() {
    	try {
        	UpdatesResponse response = theTvDB.updates(null, null);
			assertNotNull(response);
			assertNotNull(response.getData());
			assertTrue(response.getData().size()>0);
		} catch (TheTvDBClientException e) {
			fail(e.getMessage());
		}
    }

    @Test
    public void testSearchSeriesByName() {
		try {
			SerieResponse serieResponse = theTvDB.search("suits", null);
			
			assertNotNull(serieResponse);
			assertEquals(2, serieResponse.getData().size());
			
		} catch (TheTvDBClientException e) {
			fail(e.getMessage());
		}
    }

    @Test
    public void testSearchSeriesByIMDB() {
		try {
			SerieResponse serieResponse = theTvDB.searchByIMDB("tt5420376", null);
			
			assertNotNull(serieResponse);
			
		} catch (TheTvDBClientException e) {
			fail(e.getMessage());
		}
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testSearchSeriesNUll() {

		try {
			theTvDB.search(null, null);
			
		} catch (TheTvDBClientException e) {

		}

    }
    
    @Test
    public void testSerieByID() {
		try {
			SerieByIdResponse serieResponse = theTvDB.serieById(311954, null);
			
			assertNotNull(serieResponse);
			
		} catch (TheTvDBClientException e) {
			fail(e.getMessage());
		}
    }
    
    @Test
    public void testActorsSerieByID() {
		try {
			ActorResponse actorResponse = theTvDB.actorsBySerieId(311954);
			
			assertNotNull(actorResponse);
			
		} catch (TheTvDBClientException e) {
			fail(e.getMessage());
		}
    }
    
    @Test
    public void testEpisodesBySerieByID() {
		try {
			EpisodeResponse episodeResponse = theTvDB.episodesBySerieById(311954, null, null);
			
			assertNotNull(episodeResponse);
			
		} catch (TheTvDBClientException e) {
			fail(e.getMessage());
		}
    }
    
    @Test
    public void testEpisodeByID() {
		try {
			EpisodeDetailResponse episodeDetailResponse = theTvDB.episodeById(6246547, null);
			
			assertNotNull(episodeDetailResponse);
			
		} catch (TheTvDBClientException e) {
			fail(e.getMessage());
		}
    }

}
