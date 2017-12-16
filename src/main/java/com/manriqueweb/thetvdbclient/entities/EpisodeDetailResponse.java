package com.manriqueweb.thetvdbclient.entities;

public class EpisodeDetailResponse {
	private EpisodeDetail data;
	private Errors errors;
	private String error;
	
	public EpisodeDetail getData() {
		return data;
	}
	public void setData(EpisodeDetail data) {
		this.data = data;
	}
	public Errors getErrors() {
		return errors;
	}
	public void setErrors(Errors errors) {
		this.errors = errors;
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
		builder.append("EpisodeDetailResponse [data=");
		builder.append(data);
		builder.append(", errors=");
		builder.append(errors);
		builder.append(", error=");
		builder.append(error);
		builder.append("]");
		return builder.toString();
	}


}
