package com.esame.util.filter;

import java.util.ArrayList;

import com.esame.database.Database;
import com.esame.exception.FilterNotFoundException;
import com.esame.model.Tweet;
import com.esame.util.other.ArrayListOperation;

public class ImageFilter{
	private ArrayList<Tweet> tweets = new ArrayList<Tweet>();
	private ArrayList<String[]> image = new ArrayList<String[]>();
	
	public ImageFilter() {
		tweets = Database.getTweet();
	}

	public String get(String filter) throws FilterNotFoundException{
		String out = ArrayListOperation.arrayListToFilteredString(tweets, filter);
		return out;
	}
}
