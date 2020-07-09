package com.esame.util.other;

public class FilterParam {
	private String type;
	private String filter;
	
	public FilterParam(String type, String filter) {
		this.type = type;
		this.filter = filter;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getFilter() {
		return filter;
	}

	public void setFilter(String filter) {
		this.filter = filter;
	}
	
	
}
