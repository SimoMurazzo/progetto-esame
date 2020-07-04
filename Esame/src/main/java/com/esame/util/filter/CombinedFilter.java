package com.esame.util.filter;

import java.util.ArrayList;

import com.esame.database.Database;
import com.esame.model.Tweet;

public class CombinedFilter {
	private ArrayList<Tweet> tweets = new ArrayList<Tweet>();
	
	public CombinedFilter(String filter) {
		tweets = Database.getTweet();
		this.getTweet(filter);
		this.getImage(filter);
	}
	
	public boolean getTweet(String filter) {
		for(Tweet t: tweets) {
			if(t.getEvento().getType().equalsIgnoreCase(filter)) {
				return true;
			}
		}
		return false;
	}
	
	public String[] getImage(String filter) {
		for(Tweet t: tweets) {
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
