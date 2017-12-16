package com.manriqueweb.thetvdbclient.entities;

import java.util.List;

public class Errors {
	
	private List<String> invalidFilters;
	private String invalidLanguage;
	private List<String> invalidQueryParams;
	
	public List<String> getInvalidFilters() {
		return invalidFilters;
	}
	public void setInvalidFilters(List<String> invalidFilters) {
		this.invalidFilters = invalidFilters;
	}
	public String getInvalidLanguage() {
		return invalidLanguage;
	}
	public void setInvalidLanguage(String invalidLanguage) {
		this.invalidLanguage = invalidLanguage;
	}
	public List<String> getInvalidQueryParams() {
		return invalidQueryParams;
	}
	public void setInvalidQueryParams(List<String> invalidQueryParams) {
		this.invalidQueryParams = invalidQueryParams;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Errors [invalidFilters=");
		builder.append(invalidFilters);
		builder.append(", invalidLanguage=");
		builder.append(invalidLanguage);
		builder.append(", invalidQueryParams=");
		builder.append(invalidQueryParams);
		builder.append("]");
		return builder.toString();
	}

}
