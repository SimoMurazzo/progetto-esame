package com.esame.util.stats;

import java.util.ArrayList;

import com.esame.exception.InvalidTypeStatException;
import com.esame.model.GeneralStatsMod;
import com.esame.model.Tweet;

public class GeneralStats {
	
	private ArrayList<Tweet> tweets;
	
	public GeneralStats(ArrayList<Tweet> tweetlist) {
		this.tweets = tweetlist;
	}
	
	public GeneralStatsMod returnGeneralStat(String typestat, String typefilter) throws InvalidTypeStatException{
		
		GeneralStatsMod stat = new GeneralStatsMod();
		int counter = 0;
		
		switch(typestat) {
		case "type": {
			
			if(typefilter.equals("geomagnetic conditions"))
				counter =(int) tweets.stream()
				.filter(Tweet -> Tweet.getEvento().getType().equals("geomagnetic conditions"))
				.count();
			else if(typefilter.equals("geomagnetic storm"))
				counter =(int) tweets.stream()
				.filter(Tweet -> Tweet.getEvento().getType().equals("geomagnetic storm"))
				.count();
			else if(typefilter.equals("flare"))
				counter =(int) tweets.stream()
				.filter(Tweet -> Tweet.getEvento().getType().equals("flare"))
				.count();
			else counter = 0;
			stat.setTweetAttribute(typestat);
			stat.setAttributeType(typefilter);
			stat.setCounter(counter);
			return stat;
		}
		case "date": {
			
			switch(typefilter) {
			case "Jan":
				counter =(int) tweets.stream()
				.filter(Tweet -> Tweet.findMonth().equals("Jan"))
				.count();break;
			case "Feb":
				counter =(int) tweets.stream()
				.filter(Tweet -> Tweet.findMonth().equals("Feb"))
				.count();break;
			case "Mar":
				counter =(int) tweets.stream()
				.filter(Tweet -> Tweet.findMonth().equals("Mar"))
				.count();break;
			case "Apr":
				counter =(int) tweets.stream()
				.filter(Tweet -> Tweet.findMonth().equals("Apr"))
				.count();break;
			case "May":
				counter =(int) tweets.stream()
				.filter(Tweet -> Tweet.findMonth().equals("May"))
				.count();break;
			case "Jun":
				counter =(int) tweets.stream()
				.filter(Tweet -> Tweet.findMonth().equals("Jun"))
				.count();break;
			case "Jul":
				counter =(int) tweets.stream()
				.filter(Tweet -> Tweet.findMonth().equals("Jul"))
				.count();break;
			case "Aug":
				counter =(int) tweets.stream()
				.filter(Tweet -> Tweet.findMonth().equals("Aug"))
				.count();break;
			case "Sep":
				counter =(int) tweets.stream()
				.filter(Tweet -> Tweet.findMonth().equals("Sep"))
				.count();break;
			case "Oct":
				counter =(int) tweets.stream()
				.filter(Tweet -> Tweet.findMonth().equals("Oct"))
				.count();break;
			case "Nov":
				counter =(int) tweets.stream()
				.filter(Tweet -> Tweet.findMonth().equals("Nov"))
				.count();break;
			case "Dec":
				counter =(int) tweets.stream()
				.filter(Tweet -> Tweet.findMonth().equals("Dec"))
				.count();break;
			default:
				counter = 0;
			}
			stat.setTweetAttribute(typestat);
			stat.setAttributeType(typefilter);
			stat.setCounter(counter);
			return stat;
		}
		case "type in last month": {
			
			String lastMonth = tweets.get(0).findMonth();
			if(typefilter.equals("geomagnetic conditions"))
				counter =(int) tweets.stream()
				.filter(Tweet -> Tweet.getEvento().getType().equals("geomagnetic conditions"))
				.filter(Tweet -> Tweet.findMonth().equals(lastMonth))
				.count();
			else if(typefilter.equals("geomagnetic storm"))
				counter =(int) tweets.stream()
				.filter(Tweet -> Tweet.getEvento().getType().equals("geomagnetic storm"))
				.filter(Tweet -> Tweet.findMonth().equals(lastMonth))
				.count();
			else if(typefilter.equals("flare"))
				counter =(int) tweets.stream()
				.filter(Tweet -> Tweet.getEvento().getType().equals("flare"))
				.filter(Tweet -> Tweet.findMonth().equals(lastMonth))
				.count();
			else counter = 0;
			stat.setTweetAttribute(typestat);
			stat.setAttributeType(typefilter);
			stat.setCounter(counter);
			return stat;
		}
		default: {
			throw new InvalidTypeStatException("Typestat or typefilter not valid!");
			}
		}
		
	}

}
