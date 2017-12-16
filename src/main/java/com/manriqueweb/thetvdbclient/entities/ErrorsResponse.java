package com.manriqueweb.thetvdbclient.entities;

import java.util.List;

public class ErrorsResponse {

	private String error;
	private List<Errors> errors;
	
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public List<Errors> getErrors() {
		return errors;
	}
	public void setErrors(List<Errors> errors) {
		this.errors = errors;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ErrorsResponse [error=");
		builder.append(error);
		builder.append(", errors=");
		builder.append(errors);
		builder.append("]");
		return builder.toString();
	}


}
