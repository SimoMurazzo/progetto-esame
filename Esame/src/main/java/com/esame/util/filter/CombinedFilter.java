package com.esame.util.filter;

import java.util.ArrayList;

import com.esame.database.Database;
import com.esame.exception.FilterNotFoundException;
import com.esame.model.Tweet;
import com.esame.util.other.ArrayListOperation;

public class CombinedFilter {
	private ArrayList<Tweet> tweets = new ArrayList<Tweet>();
	private ArrayList<Tweet> newTweets = new ArrayList<Tweet>();

	public CombinedFilter() {
		tweets = Database.getTweet();
	}
	
	public String get(String filter1, String filter2) throws FilterNotFoundException{
		for(Tweet t: tweets) {
			if(t.getEvento().getType().equalsIgnoreCase(filter1)) {
				newTweets.add(t);
			} else {
				continue;
			}
		}	
		String out = ArrayListOperation.arrayListToFilteredString(newTweets, filter2);
		return out;
	}
}
