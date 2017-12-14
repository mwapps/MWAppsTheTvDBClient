package com.manriqueweb.thetvdbclient.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Actor {
    public Integer id;
    public Integer seriesId;
    public String name;
    public String role;
    public Integer sortOrder;
    public String image;
    public Integer imageAuthor;
    public String imageAdded;
    public String lastUpdated;
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getSeriesId() {
		return seriesId;
	}
	public void setSeriesId(Integer seriesId) {
		this.seriesId = seriesId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Integer getSortOrder() {
		return sortOrder;
	}
	public void setSortOrder(Integer sortOrder) {
		this.sortOrder = sortOrder;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Integer getImageAuthor() {
		return imageAuthor;
	}
	public void setImageAuthor(Integer imageAuthor) {
		this.imageAuthor = imageAuthor;
	}
	public String getImageAdded() {
		return imageAdded;
	}
	public void setImageAdded(String imageAdded) {
		this.imageAdded = imageAdded;
	}
	public String getLastUpdated() {
		return lastUpdated;
	}
	public void setLastUpdated(String lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Actor [id=");
		builder.append(id);
		builder.append(", seriesId=");
		builder.append(seriesId);
		builder.append(", name=");
		builder.append(name);
		builder.append(", role=");
		builder.append(role);
		builder.append(", sortOrder=");
		builder.append(sortOrder);
		builder.append(", image=");
		builder.append(image);
		builder.append(", imageAuthor=");
		builder.append(imageAuthor);
		builder.append(", imageAdded=");
		builder.append(imageAdded);
		builder.append(", lastUpdated=");
		builder.append(lastUpdated);
		builder.append("]");
		return builder.toString();
	}

}
