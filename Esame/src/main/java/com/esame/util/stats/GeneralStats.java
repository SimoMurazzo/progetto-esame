package com.esame.util.stats;

import java.util.ArrayList;

import com.esame.exception.InvalidTypeStatException;
import com.esame.model.GeneralStatsMod;
import com.esame.model.Tweet;
import com.esame.exception.InvalidTypeStatException;

public class GeneralStats {
	
	private ArrayList<Tweet> tweets;
	
	public GeneralStats(ArrayList<Tweet> tweetlist) {
		this.tweets = tweetlist;
	}
	
	public GeneralStatsMod returnGeneralStat(String typestat, String typefilter)
	throws InvalidTypeStatException {
		
		GeneralStatsMod stat = new GeneralStatsMod();
		long counter = 0;
		
		switch(typestat) {
		case "type": {
			
			if(typefilter.equals("geomagnetic conditions"))
				counter =(long) tweets.stream()
				.filter(Tweet -> Tweet.getEvento().getType().equals("geomagnetic conditions"))
				.count();
			else if(typefilter.equals("geomagnetic storm"))
				counter =(long) tweets.stream()
				.filter(Tweet -> Tweet.getEvento().getType().equals("geomagnetic storm"))
				.count();
			else if(typefilter.equals("flare"))
				counter =(long) tweets.stream()
				.filter(Tweet -> Tweet.getEvento().getType().equals("flare"))
				.count();
			else counter = 0;
			stat.setTweetAttribute(typestat);
			stat.setCounter(counter);
			return stat;
		}
		case "date": {
			
			switch(typefilter) {
			case "Jan":
				counter =(long) tweets.stream()
				.filter(Tweet -> Tweet.findMonth().equals("Jan"))
				.count();break;
			case "Feb":
				counter =(long) tweets.stream()
				.filter(Tweet -> Tweet.findMonth().equals("Feb"))
				.count();break;
			case "Mar":
				counter =(long) tweets.stream()
				.filter(Tweet -> Tweet.findMonth().equals("Mar"))
				.count();break;
			case "Apr":
				counter =(long) tweets.stream()
				.filter(Tweet -> Tweet.findMonth().equals("Apr"))
				.count();break;
			case "May":
				counter =(long) tweets.stream()
				.filter(Tweet -> Tweet.findMonth().equals("May"))
				.count();break;
			case "Jun":
				counter =(long) tweets.stream()
				.filter(Tweet -> Tweet.findMonth().equals("Jun"))
				.count();break;
			case "Jul":
				counter =(long) tweets.stream()
				.filter(Tweet -> Tweet.findMonth().equals("Jul"))
				.count();break;
			case "Aug":
				counter =(long) tweets.stream()
				.filter(Tweet -> Tweet.findMonth().equals("Aug"))
				.count();break;
			case "Sep":
				counter =(long) tweets.stream()
				.filter(Tweet -> Tweet.findMonth().equals("Sep"))
				.count();break;
			case "Oct":
				counter =(long) tweets.stream()
				.filter(Tweet -> Tweet.findMonth().equals("Oct"))
				.count();break;
			case "Nov":
				counter =(long) tweets.stream()
				.filter(Tweet -> Tweet.findMonth().equals("Nov"))
				.count();break;
			case "Dec":
				counter =(long) tweets.stream()
				.filter(Tweet -> Tweet.findMonth().equals("Dec"))
				.count();break;
			default:
				counter = 0;
			}
			stat.setTweetAttribute(typestat);
			stat.setCounter(counter);
			return stat;
		}
		default: {
			stat.setTweetAttribute("Type stat not valid!");
			stat.setCounter(0);
			throw new InvalidTypeStatException("Tipo di statistica non valido!");
			}
		}
		
	}

}
