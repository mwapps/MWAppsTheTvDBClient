package com.manriqueweb.thetvdbclient.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Serie implements Serializable {
	private static final long serialVersionUID = -7148298541881835279L;
	
	private Integer id;
    private String seriesName;
    private List<String> aliases = new ArrayList<>();
    private String banner;
    private String status;
    private String firstAired;
    private String network;
    private String networkId;
    private String runtime;
    private List<String> genre = new ArrayList<>();
    private String overview;
    private Long lastUpdated;
    private String airsDayOfWeek;
    private String airsTime;
    private String rating;
    private String imdbId;
    private String zap2itId;
    private String added;
    private Integer addedBy;
    private Double siteRating;
    private Integer siteRatingCount;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSeriesName() {
		return seriesName;
	}
	public void setSeriesName(String seriesName) {
		this.seriesName = seriesName;
	}
	public List<String> getAliases() {
		return aliases;
	}
	public void setAliases(List<String> aliases) {
		this.aliases = aliases;
	}
	public String getBanner() {
		return banner;
	}
	public void setBanner(String banner) {
		this.banner = banner;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getFirstAired() {
		return firstAired;
	}
	public void setFirstAired(String firstAired) {
		this.firstAired = firstAired;
	}
	public String getNetwork() {
		return network;
	}
	public void setNetwork(String network) {
		this.network = network;
	}
	public String getNetworkId() {
		return networkId;
	}
	public void setNetworkId(String networkId) {
		this.networkId = networkId;
	}
	public String getRuntime() {
		return runtime;
	}
	public void setRuntime(String runtime) {
		this.runtime = runtime;
	}
	public List<String> getGenre() {
		return genre;
	}
	public void setGenre(List<String> genre) {
		this.genre = genre;
	}
	public String getOverview() {
		return overview;
	}
	public void setOverview(String overview) {
		this.overview = overview;
	}
	public Long getLastUpdated() {
		return lastUpdated;
	}
	public void setLastUpdated(Long lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	public String getAirsDayOfWeek() {
		return airsDayOfWeek;
	}
	public void setAirsDayOfWeek(String airsDayOfWeek) {
		this.airsDayOfWeek = airsDayOfWeek;
	}
	public String getAirsTime() {
		return airsTime;
	}
	public void setAirsTime(String airsTime) {
		this.airsTime = airsTime;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getImdbId() {
		return imdbId;
	}
	public void setImdbId(String imdbId) {
		this.imdbId = imdbId;
	}
	public String getZap2itId() {
		return zap2itId;
	}
	public void setZap2itId(String zap2itId) {
		this.zap2itId = zap2itId;
	}
	public String getAdded() {
		return added;
	}
	public void setAdded(String added) {
		this.added = added;
	}
	public Integer getAddedBy() {
		return addedBy;
	}
	public void setAddedBy(Integer addedBy) {
		this.addedBy = addedBy;
	}
	public Double getSiteRating() {
		return siteRating;
	}
	public void setSiteRating(Double siteRating) {
		this.siteRating = siteRating;
	}
	public Integer getSiteRatingCount() {
		return siteRatingCount;
	}
	public void setSiteRatingCount(Integer siteRatingCount) {
		this.siteRatingCount = siteRatingCount;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Serie [id=");
		builder.append(id);
		builder.append(", seriesName=");
		builder.append(seriesName);
		builder.append(", aliases=");
		builder.append(aliases);
		builder.append(", banner=");
		builder.append(banner);
		builder.append(", status=");
		builder.append(status);
		builder.append(", firstAired=");
		builder.append(firstAired);
		builder.append(", network=");
		builder.append(network);
		builder.append(", networkId=");
		builder.append(networkId);
		builder.append(", runtime=");
		builder.append(runtime);
		builder.append(", genre=");
		builder.append(genre);
		builder.append(", overview=");
		builder.append(overview);
		builder.append(", lastUpdated=");
		builder.append(lastUpdated);
		builder.append(", airsDayOfWeek=");
		builder.append(airsDayOfWeek);
		builder.append(", airsTime=");
		builder.append(airsTime);
		builder.append(", rating=");
		builder.append(rating);
		builder.append(", imdbId=");
		builder.append(imdbId);
		builder.append(", zap2itId=");
		builder.append(zap2itId);
		builder.append(", added=");
		builder.append(added);
		builder.append(", addedBy=");
		builder.append(addedBy);
		builder.append(", siteRating=");
		builder.append(siteRating);
		builder.append(", siteRatingCount=");
		builder.append(siteRatingCount);
		builder.append("]");
		return builder.toString();
	}

}
