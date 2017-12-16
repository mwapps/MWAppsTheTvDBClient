package com.manriqueweb.thetvdbclient.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EpisodeResponse {

	private List<Episode> data;
	private Errors errors;
	private Link links;
	private String error;
	
	public List<Episode> getData() {
		return data;
	}
	public void setData(List<Episode> data) {
		this.data = data;
	}
	public Errors getErrors() {
		return errors;
	}
	public void setErrors(Errors errors) {
		this.errors = errors;
	}
	public Link getLinks() {
		return links;
	}
	public void setLinks(Link links) {
		this.links = links;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EpisodeResponse [data=");
		builder.append(data);
		builder.append(", errors=");
		builder.append(errors);
		builder.append(", links=");
		builder.append(links);
		builder.append(", error=");
		builder.append(error);
		builder.append("]");
		return builder.toString();
	}

}
