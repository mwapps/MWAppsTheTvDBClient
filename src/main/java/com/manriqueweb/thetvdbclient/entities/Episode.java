package com.manriqueweb.thetvdbclient.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Episode {

    private Integer id;
    private Integer absoluteNumber;
    private Integer airedEpisodeNumber;
    private Integer airedSeason;
    private Integer airedSeasonID;
    private Double dvdEpisodeNumber;
    private Integer dvdSeason;
    private String episodeName;
    private String firstAired;
    private Translations language;
    private Long lastUpdated;
    private String overview;
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getAbsoluteNumber() {
		return absoluteNumber;
	}
	public void setAbsoluteNumber(Integer absoluteNumber) {
		this.absoluteNumber = absoluteNumber;
	}
	public Integer getAiredEpisodeNumber() {
		return airedEpisodeNumber;
	}
	public void setAiredEpisodeNumber(Integer airedEpisodeNumber) {
		this.airedEpisodeNumber = airedEpisodeNumber;
	}
	public Integer getAiredSeason() {
		return airedSeason;
	}
	public void setAiredSeason(Integer airedSeason) {
		this.airedSeason = airedSeason;
	}
	public Integer getAiredSeasonID() {
		return airedSeasonID;
	}
	public void setAiredSeasonID(Integer airedSeasonID) {
		this.airedSeasonID = airedSeasonID;
	}
	public Double getDvdEpisodeNumber() {
		return dvdEpisodeNumber;
	}
	public void setDvdEpisodeNumber(Double dvdEpisodeNumber) {
		this.dvdEpisodeNumber = dvdEpisodeNumber;
	}
	public Integer getDvdSeason() {
		return dvdSeason;
	}
	public void setDvdSeason(Integer dvdSeason) {
		this.dvdSeason = dvdSeason;
	}
	public String getEpisodeName() {
		return episodeName;
	}
	public void setEpisodeName(String episodeName) {
		this.episodeName = episodeName;
	}
	public String getFirstAired() {
		return firstAired;
	}
	public void setFirstAired(String firstAired) {
		this.firstAired = firstAired;
	}
	public Translations getLanguage() {
		return language;
	}
	public void setLanguage(Translations language) {
		this.language = language;
	}
	public Long getLastUpdated() {
		return lastUpdated;
	}
	public void setLastUpdated(Long lastUpdated) {
		this.lastUpdated = lastUpdated;
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
		builder.append("Episode [id=");
		builder.append(id);
		builder.append(", absoluteNumber=");
		builder.append(absoluteNumber);
		builder.append(", airedEpisodeNumber=");
		builder.append(airedEpisodeNumber);
		builder.append(", airedSeason=");
		builder.append(airedSeason);
		builder.append(", airedSeasonID=");
		builder.append(airedSeasonID);
		builder.append(", dvdEpisodeNumber=");
		builder.append(dvdEpisodeNumber);
		builder.append(", dvdSeason=");
		builder.append(dvdSeason);
		builder.append(", episodeName=");
		builder.append(episodeName);
		builder.append(", firstAired=");
		builder.append(firstAired);
		builder.append(", language=");
		builder.append(language);
		builder.append(", lastUpdated=");
		builder.append(lastUpdated);
		builder.append(", overview=");
		builder.append(overview);
		builder.append("]");
		return builder.toString();
	}

}
