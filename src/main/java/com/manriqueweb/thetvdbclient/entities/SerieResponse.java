package com.manriqueweb.thetvdbclient.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SerieResponse extends ErrorsResponse {

	private List<Serie> data;
	
	public List<Serie> getData() {
		return data;
	}
	public void setData(List<Serie> data) {
		this.data = data;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SerieResponse [data=");
		builder.append(data);
		builder.append(", error=");
		builder.append(getError());
		builder.append(", errors=");
		builder.append(getErrors());
		builder.append("]");
		return builder.toString();
	}
	


}
