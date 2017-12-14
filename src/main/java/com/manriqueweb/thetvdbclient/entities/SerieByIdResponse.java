package com.manriqueweb.thetvdbclient.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SerieByIdResponse {

	private Serie data;
	private String error;
	private Errors errors;
	public Serie getData() {
		return data;
	}
	public void setData(Serie data) {
		this.data = data;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public Errors getErrors() {
		return errors;
	}
	public void setErrors(Errors errors) {
		this.errors = errors;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SerieByIdResponse [data=");
		builder.append(data);
		builder.append(", error=");
		builder.append(error);
		builder.append(", errors=");
		builder.append(errors);
		builder.append("]");
		return builder.toString();
	}

}
