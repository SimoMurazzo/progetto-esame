package com.esame.model;

public class GeneralStatsMod {

	private String tweetattribute;
	private long counter;
	
	public GeneralStatsMod() {}
	
	public GeneralStatsMod(String tweetattribute, long counter) {
		this.tweetattribute = tweetattribute;
		this.counter = counter;
	}

	public String getTweetattribute() {
		return tweetattribute;
	}

	public long getCounter() {
		return counter;
	}

	public void setTweetAttribute(String tweetattribute) {
		this.tweetattribute = tweetattribute;
	}

	public void setCounter(long counter) {
		this.counter = counter;
	}
	
	
}
