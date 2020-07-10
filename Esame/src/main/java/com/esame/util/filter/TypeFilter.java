package com.esame.util.filter;

import java.util.ArrayList;

import com.esame.database.Database;
import com.esame.model.Tweet;
import com.esame.util.other.ArrayListOperation;

public class TypeFilter{
	private ArrayList<Tweet> tweets = new ArrayList<Tweet>();
	private ArrayList<Tweet> newTweets = new ArrayList<Tweet>();
	
	public TypeFilter() {
		tweets = Database.getTweet();
	}

	public String get(String filter1) {
		for(Tweet t: tweets) {
			if(t.getEvento().getType().equalsIgnoreCase(filter1)) {
				newTweets.add(t);
			} else {
				continue;
			}
		}
		String tString = ArrayListOperation.arrayListToString(newTweets);
		return tString;
	}
}
