package com.manriqueweb.thetvdbclient.entities;

import java.util.List;

public class UpdatesResponse extends ErrorsResponse {

	private List<Update> data;

	public List<Update> getData() {
		return data;
	}

	public void setData(List<Update> data) {
		this.data = data;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UpdatesResponse [data=");
		builder.append(data);
		builder.append(", getErrors=");
		builder.append(getErrors());
		builder.append(", getError=");
		builder.append(getError());
		builder.append("]");
		return builder.toString();
	}


}
