package com.esame.model;

public class GeneralStatsMod {

	private String tweetattribute;
	private String attributetype;
	private int counter;
	
	public GeneralStatsMod() {}
	
	public GeneralStatsMod(String tweetattribute, int counter, String attributetype) {
		this.tweetattribute = tweetattribute;
		this.attributetype = attributetype;
		this.counter = counter;
	}

	public String getTweetattribute() {
		return tweetattribute;
	}
	
	public String getAttributetype() {
		return attributetype;
	}

	public int getCounter() {
		return counter;
	}

	public void setTweetAttribute(String tweetattribute) {
		this.tweetattribute = tweetattribute;
	}
	
	public void setAttributeType(String attributetype) {
		this.attributetype = attributetype;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}
	
	
}
