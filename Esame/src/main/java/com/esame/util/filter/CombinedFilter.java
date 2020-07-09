package com.esame.util.filter;

import java.util.ArrayList;

import com.esame.database.Database;
import com.esame.model.Tweet;

public class CombinedFilter {
	private ArrayList<Tweet> tweets = new ArrayList<Tweet>();
	private ArrayList<Tweet> newTweets = new ArrayList<Tweet>();

	public CombinedFilter(String filterT, String filterI) {
		tweets = Database.getTweet();
		this.getTweet(filterT);
		this.getImage(filterI);
	}
	
	public ArrayList<Tweet> getTweet(String filter) {
		for(Tweet t: tweets) {
			if(t.getEvento().getType().equalsIgnoreCase(filter)) {
				newTweets.add(t);
			} else {
				continue;
			}
		}
		return newTweets;
	}
	
	public String[] getImage(String filter) {
		for(Tweet t: newTweets) {
			if(filter.equalsIgnoreCase("min")) {
				return t.getEvento().getMin();
			}else if(filter.equalsIgnoreCase("med")) {
				return t.getEvento().getMed();
			}else if(filter.equalsIgnoreCase("max")) {
				return t.getEvento().getMax();
			}
		}
		String[] def = {" ", " "};
		return def;
	}
}
