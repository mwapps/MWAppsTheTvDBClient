# MWAppsTheTvDBClient
MWApps java client for The TVDB REST API (v2.1.2)


Follow the example implementation:

```java
try {

	TheTvDB theTvDB = new TheTvDB(
		"Apikey",
		"Username",
		"Userkey",
		"languaje"
	);

	UpdatesResponse updatesResponse = theTvDB.updates(null, null);
	if(updatesResponse.getData()!=null){
		for(Update itemUpdate : updatesResponse.getData()){
			SerieByIdResponse serieById = theTvDB.serieById(itemUpdate.getId(), null);
		}
	}
} catch (TheTvDBClientException e) {

}


```


