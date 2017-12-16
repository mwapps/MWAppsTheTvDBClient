package com.manriqueweb.thetvdbclient.entities;

public class Link {

	private Integer first;
    private Integer last;
    private Integer next;
    private Integer prev;
    
	public Integer getFirst() {
		return first;
	}
	public void setFirst(Integer first) {
		this.first = first;
	}
	public Integer getLast() {
		return last;
	}
	public void setLast(Integer last) {
		this.last = last;
	}
	public Integer getNext() {
		return next;
	}
	public void setNext(Integer next) {
		this.next = next;
	}
	public Integer getPrev() {
		return prev;
	}
	public void setPrev(Integer prev) {
		this.prev = prev;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Link [first=");
		builder.append(first);
		builder.append(", last=");
		builder.append(last);
		builder.append(", next=");
		builder.append(next);
		builder.append(", prev=");
		builder.append(prev);
		builder.append("]");
		return builder.toString();
	}
    

}
