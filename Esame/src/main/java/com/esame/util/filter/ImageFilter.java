package com.esame.util.filter;

import java.util.ArrayList;

import com.esame.database.Database;
import com.esame.model.Tweet;

public class ImageFilter {
	private ArrayList<Tweet> tweets = new ArrayList<Tweet>();
	
	public ImageFilter(String filter) {
		tweets = Database.getTweet();
		this.getImage(filter);
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
