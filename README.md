# MWAppsTheTvDBClient
MWApps java client for <a href="https://api.thetvdb.com/swagger">The TVDB REST API</a> (v2.1.2).

<a href="http://www.thetvdb.com">TheTVDB.com</a> is an open database for television show fans where everybody can modified it.

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

## License
Created by [Omar Manrique Zorrilla](https://www.linkedin.com/in/omargmanriquez) under Apache License 2.0

