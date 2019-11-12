package com.manriqueweb.thetvdbclient;


import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.concurrent.CountDownLatch;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.manriqueweb.thetvdbclient.entities.SerieResponse;
import com.manriqueweb.thetvdbclient.entities.UpdatesResponse;
import com.manriqueweb.thetvdbclient.exceptions.TheTvDBClientException;
import com.manriqueweb.thetvdbclient.ifaces.IApiResponse;

public class TheTvDBClientAsyncCallsTest {
	
	TheTvDB theTvDB = null;
	
    private boolean called = false;
    private CountDownLatch signal = null;
    
	public TheTvDBClientAsyncCallsTest(){
    	theTvDB = new TheTvDB(
	    			DataForTest.getBasicCredentials().getApikey(),
	    			DataForTest.getBasicCredentials().getUsername(),
	    			DataForTest.getBasicCredentials().getUserkey(),
	    			DataForTest.getBasicCredentials().getDefaultlanguaje()
    			);
	}
	
    @Before
    public void beforeTest01() {
        called = false;
        signal = new CountDownLatch(1);
    }
    
    @Test
    public void test01() throws Exception {
    	signal = new CountDownLatch(1);
    	
		try {
			theTvDB.updates(null, null, new IApiResponse<UpdatesResponse>() {
				
				@Override
				public void onResponse(UpdatesResponse dataResponse) {
	                assertNotNull(dataResponse);
	    			assertNotNull(dataResponse.getData());
	    			assertTrue(dataResponse.getData().size()>0);

	                called = true;
	                signal.countDown();
				}
				
				@Override
				public void onError(String errorMsg) {
	                called = false;
	                signal.countDown();
	                assertTrue(called);
				}
			});
			
		} catch (TheTvDBClientException e) {
			fail(e.getMessage());
		}
		
        signal.await();
        assertTrue(called);
    }
    
    @After
    public void afterTest01() {
        signal = null;
    }
    
    @Before
    public void beforeTest02() {
        called = false;
        signal = new CountDownLatch(1);
    }

    @Test
    public void test02() throws Exception {
    	signal = new CountDownLatch(1);
    	
		try {
			theTvDB.search("suits", null, new IApiResponse<SerieResponse>() {
				
				@Override
				public void onResponse(SerieResponse dataResponse) {
	                assertNotNull(dataResponse);
	    			assertNotNull(dataResponse.getData());
	    			assertTrue(dataResponse.getData().size()>0);

	                called = true;
	                signal.countDown();
				}
				
				@Override
				public void onError(String errorMsg) {
	                called = false;
	                signal.countDown();
	                assertTrue(called);
				}
			});
			
		} catch (TheTvDBClientException e) {
			fail(e.getMessage());
		}
		
        signal.await();
        assertTrue(called);
    }

    @After
    public void afterTest02() {
        signal = null;
    }

}
