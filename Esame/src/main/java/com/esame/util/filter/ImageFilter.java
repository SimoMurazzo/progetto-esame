package com.esame.util.filter;

import java.util.ArrayList;

import com.esame.database.Database;
import com.esame.model.Tweet;

public class ImageFilter{
	private ArrayList<Tweet> tweets = new ArrayList<Tweet>();
	private ArrayList<String[]> image = new ArrayList<String[]>();
	
	public ImageFilter() {
		tweets = Database.getTweet();
	}

	public ArrayList<String[]> getImage(String filter) {
		for(Tweet t: tweets) {
			if(filter.equalsIgnoreCase("min")) {
				image.add(t.getEvento().getMin());
			}else if(filter.equalsIgnoreCase("med")) {
				image.add(t.getEvento().getMed());
			}else if(filter.equalsIgnoreCase("max")) {
				image.add(t.getEvento().getMax());
			}
		}
		return image;
	}
}
