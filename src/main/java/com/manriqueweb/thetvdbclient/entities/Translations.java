package com.manriqueweb.thetvdbclient.entities;

public class Translations {

    private String episodeName;
    private String overview;
    
	public String getEpisodeName() {
		return episodeName;
	}
	public void setEpisodeName(String episodeName) {
		this.episodeName = episodeName;
	}
	public String getOverview() {
		return overview;
	}
	public void setOverview(String overview) {
		this.overview = overview;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Translations [episodeName=");
		builder.append(episodeName);
		builder.append(", overview=");
		builder.append(overview);
		builder.append("]");
		return builder.toString();
	}

}
