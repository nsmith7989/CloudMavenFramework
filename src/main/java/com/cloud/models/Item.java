package com.cloud.models;


public class Item {

	private String ssPath;

	public Item() {
	}

	public Item(String _ssPath) {		
		this.ssPath = _ssPath;
		//this.methodName = _methodName;
	}

	public String getssPath() {
		return ssPath;
	}

	public void setCityText(String ssPath) {
		this.ssPath = ssPath;
	}

}
