package com.manriqueweb.thetvdbclient.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ActorResponse {
	
	public List<Actor> data;
	private Errors errors;
	private String error;
	
	public List<Actor> getData() {
		return data;
	}
	public void setData(List<Actor> data) {
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
		builder.append("ActorsResponse [data=");
		builder.append(data);
		builder.append(", errors=");
		builder.append(errors);
		builder.append(", error=");
		builder.append(error);
		builder.append("]");
		return builder.toString();
	}


}
