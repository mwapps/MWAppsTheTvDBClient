package com.manriqueweb.thetvdbclient;


import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.IOException;

import org.apache.commons.io.IOUtils;
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
    public void test01() {
		try {
			assertNotNull(theTvDB.getCurrentToken());
		} catch (TheTvDBClientException e) {
			fail(e.getMessage());
		}
    }
    
    @Test
    public void test02() {
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
    public void test03() {
		try {
			SerieResponse serieResponse = theTvDB.search("suits", null);
			
			assertNotNull(serieResponse);
			assertEquals(2, serieResponse.getData().size());
			
		} catch (TheTvDBClientException e) {
			fail(e.getMessage());
		}
    }

    @Test
    public void test04() {
		try {
			SerieResponse serieResponse = theTvDB.searchByIMDB("tt5420376", null);
			
			assertNotNull(serieResponse);
			
		} catch (TheTvDBClientException e) {
			fail(e.getMessage());
		}
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void test05() {

		try {
			theTvDB.search(null, null);
			
		} catch (TheTvDBClientException e) {

		}

    }
    
    @Test
    public void test06() {
		try {
			SerieByIdResponse serieResponse = theTvDB.serieById(311954, null);
			
			assertNotNull(serieResponse);
			
		} catch (TheTvDBClientException e) {
			fail(e.getMessage());
		}
    }
    
    @Test
    public void test07() {
		try {
			ActorResponse actorResponse = theTvDB.actorsBySerieId(311954);
			
			assertNotNull(actorResponse);
			
		} catch (TheTvDBClientException e) {
			fail(e.getMessage());
		}
    }
    
    @Test
    public void test08() {
		try {
			EpisodeResponse episodeResponse = theTvDB.episodesBySerieById(311954, null, null);
			
			assertNotNull(episodeResponse);
			
		} catch (TheTvDBClientException e) {
			fail(e.getMessage());
		}
    }
    
    @Test
    public void test09() {
		try {
			EpisodeDetailResponse episodeDetailResponse = theTvDB.episodeById(6246547, null);
			
			assertNotNull(episodeDetailResponse);
			
		} catch (TheTvDBClientException e) {
			fail(e.getMessage());
		}
    }
    
    @Test
    public void test10(){
		try {
			byte[] responseBytes = theTvDB.downloadImage("graphical/311954-g3.jpg");
			assertNotNull(responseBytes);
			
			byte[] responseFile = IOUtils.toByteArray(getClass().getClassLoader().getResourceAsStream("311954-g3.jpg"));
			assertNotNull(responseFile);
			
			assertArrayEquals(responseBytes, responseFile);
			
		} catch (TheTvDBClientException e) {
			fail(e.getMessage());
		} catch (IOException e) {
			fail(e.getMessage());
		}
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void test11() {

		try {
			theTvDB.downloadImage("https://www.thetvdb.com/banners/graphical/311954-g3.jpg");
			
		} catch (TheTvDBClientException e) {

		}

    }

}
