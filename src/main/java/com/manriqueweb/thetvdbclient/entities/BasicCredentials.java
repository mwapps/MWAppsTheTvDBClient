package com.manriqueweb.thetvdbclient.entities;

/**
 * Basic authentication credentials.
 */
public class BasicCredentials {
    private String apikey;
    private String username;
    private String userkey;
    private String defaultlanguaje;
    
	public BasicCredentials(String apikey, String username, String userkey, String defaultlanguaje) {
		super();
		this.apikey = apikey;
		this.username = username;
		this.userkey = userkey;
		this.defaultlanguaje = defaultlanguaje;
	}
	
	public String getApikey() {
		return apikey;
	}
	public void setApikey(String apikey) {
		this.apikey = apikey;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserkey() {
		return userkey;
	}
	public void setUserkey(String userkey) {
		this.userkey = userkey;
	}
	public String getDefaultlanguaje() {
		return defaultlanguaje;
	}
	public void setDefaultlanguaje(String defaultlanguaje) {
		this.defaultlanguaje = defaultlanguaje;
	}
    
}

