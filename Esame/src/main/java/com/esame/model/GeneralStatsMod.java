package com.esame.model;

public class GeneralStatsMod {

	private String tweetattribute;
	private int counter;
	
	public GeneralStatsMod() {}
	
	public GeneralStatsMod(String tweetattribute, int counter) {
		this.tweetattribute = tweetattribute;
		this.counter = counter;
	}

	public String getTweetattribute() {
		return tweetattribute;
	}

	public int getCounter() {
		return counter;
	}

	public void setTweetAttribute(String tweetattribute) {
		this.tweetattribute = tweetattribute;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}
	
	
}
