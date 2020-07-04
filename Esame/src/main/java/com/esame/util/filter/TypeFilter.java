package com.esame.util.filter;

import java.util.ArrayList;

import com.esame.database.Database;
import com.esame.model.Tweet;

public class TypeFilter {
	private ArrayList<Tweet> tweets = new ArrayList<Tweet>();
	
	public TypeFilter(String filter) {
		tweets = Database.getTweet();
		this.getTweet(filter);
	}

	public Tweet getTweet(String filter) {
		for(Tweet t: tweets) {
			if(t.getEvento().getType().equalsIgnoreCase(filter)) {
				return t;
			}
		}
	}
}
