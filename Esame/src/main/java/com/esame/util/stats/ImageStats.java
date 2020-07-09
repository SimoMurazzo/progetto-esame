package com.esame.util.stats;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

import com.esame.exception.InvalidTypeStatException;
import com.esame.model.ImageStatsMod;
import com.esame.model.Tweet;

public class ImageStats {

	private ArrayList<Tweet> tweets;
	
	public ImageStats(ArrayList<Tweet> tweetlist) {
		this.tweets = tweetlist;
	}
	
	public ImageStatsMod returnImageStat(String typestat, String typeDim) throws InvalidTypeStatException{
		
		ImageStatsMod stat = new ImageStatsMod();
		
		int min = 0;
		double med = 0;
		int max = 0;

		switch(typestat) {
		case "min": {
			if(typeDim.equals("w")) {
				min =(int) tweets.stream()
				.map(Tweet -> Arrays.stream(Tweet.getEvento().getMin()).findFirst().get())
				.map(Object::toString)
				.map(Integer::parseInt)
				.min(Comparator.comparingInt(Integer::valueOf)).get();
				med =(double) tweets.stream()
				.map(Tweet -> Arrays.stream(Tweet.getEvento().getMin()).findFirst().get())
				.map(Object::toString)
				.map(Double::parseDouble)
				.mapToDouble(Double::doubleValue)
				.average().getAsDouble();
				max =(int) tweets.stream()
				.map(Tweet -> Arrays.stream(Tweet.getEvento().getMin()).findFirst().get())
				.map(Object::toString)
				.map(Integer::parseInt)
				.max(Comparator.comparing(Integer::valueOf)).get();
				
				stat.setTweetattribute(typestat);
				stat.setImageDim(typeDim);
				stat.setMin(min);
				stat.setMed(med);
				stat.setMax(max);
				return stat;
			}
			else if(typeDim.equals("h")) {
				min =(int) tweets.stream()
				.map(Tweet -> Arrays.stream(Tweet.getEvento().getMin()).reduce((first, second) -> second))
				.map(Object::toString)
				.map(Integer::parseInt)
				.min(Comparator.comparing(Integer::valueOf)).get();
				med =(double) tweets.stream()
				.map(Tweet -> Arrays.stream(Tweet.getEvento().getMin()).reduce((first, second) -> second))
				.map(Object::toString)
				.map(Double::parseDouble)
				.mapToDouble(Double::doubleValue)
				.average().getAsDouble();
				max =(int) tweets.stream()
				.map(Tweet -> Arrays.stream(Tweet.getEvento().getMin()).reduce((first, second) -> second))
				.map(Object::toString)
				.map(Integer::parseInt)
				.max(Comparator.comparing(Integer::valueOf)).get();
						
				stat.setTweetattribute(typestat);
				stat.setImageDim(typeDim);
				stat.setMin(min);
				stat.setMed(med);
				stat.setMax(max);
				return stat;
			}
			else {
				stat.setTweetattribute(typestat);
				stat.setImageDim("Dimension not valid!");
				stat.setMin(0);
				stat.setMed(0);
				stat.setMax(0);
				return stat;
			}
		}
		case "med": {
			if(typeDim.equals("w")) {
				min =(int) tweets.stream()
				.map(Tweet -> Arrays.stream(Tweet.getEvento().getMed()).findFirst().get())
				.map(Object::toString)
				.map(Integer::parseInt)
				.min(Comparator.comparing(Integer::valueOf)).get();
				med =(double) tweets.stream()
				.map(Tweet -> Arrays.stream(Tweet.getEvento().getMed()).findFirst().get())
				.map(Object::toString)
				.map(Double::parseDouble)
				.mapToDouble(Double::doubleValue)
				.average().getAsDouble();
				max =(int) tweets.stream()
				.map(Tweet -> Arrays.stream(Tweet.getEvento().getMed()).findFirst().get())
				.map(Object::toString)
				.map(Integer::parseInt)
				.max(Comparator.comparing(Integer::valueOf)).get();
					
				stat.setTweetattribute(typestat);
				stat.setImageDim(typeDim);
				stat.setMin(min);
				stat.setMed(med);
				stat.setMax(max);
				return stat;
			}
			else if(typeDim.equals("h")) {
				min =(int) tweets.stream()
				.map(Tweet -> Arrays.stream(Tweet.getEvento().getMed()).reduce((first, second) -> second))
				.map(Object::toString)
				.map(Integer::parseInt)
				.min(Comparator.comparing(Integer::valueOf)).get();
				med =(double) tweets.stream()
				.map(Tweet -> Arrays.stream(Tweet.getEvento().getMed()).reduce((first, second) -> second))
				.map(Object::toString)
				.map(Double::parseDouble)
				.mapToDouble(Double::doubleValue)
				.average().getAsDouble();
				max =(int) tweets.stream()
				.map(Tweet -> Arrays.stream(Tweet.getEvento().getMed()).reduce((first, second) -> second))
				.map(Object::toString)
				.map(Integer::parseInt)
				.max(Comparator.comparing(Integer::valueOf)).get();
								
				stat.setTweetattribute(typestat);
				stat.setImageDim(typeDim);
				stat.setMin(min);
				stat.setMed(med);
				stat.setMax(max);
				return stat;
			}
			else {
				stat.setTweetattribute(typestat);
				stat.setImageDim("Dimension not valid!");
				stat.setMin(0);
				stat.setMed(0);
				stat.setMax(0);
				return stat;
			}
		}
		case "max": {
			if(typeDim.equals("w")) {
				min =(int) tweets.stream()
				.map(Tweet -> Arrays.stream(Tweet.getEvento().getMax()).findFirst().get())
				.map(Object::toString)
				.map(Integer::parseInt)
				.min(Comparator.comparing(Integer::valueOf)).get();
				med =(double) tweets.stream()
				.map(Tweet -> Arrays.stream(Tweet.getEvento().getMax()).findFirst().get())
				.map(Object::toString)
				.map(Double::parseDouble)
				.mapToDouble(Double::doubleValue)
				.average().getAsDouble();
				max =(int) tweets.stream()
				.map(Tweet -> Arrays.stream(Tweet.getEvento().getMax()).findFirst().get())
				.map(Object::toString)
				.map(Integer::parseInt)
				.max(Comparator.comparing(Integer::valueOf)).get();
					
				stat.setTweetattribute(typestat);
				stat.setImageDim(typeDim);
				stat.setMin(min);
				stat.setMed(med);
				stat.setMax(max);
				return stat;
			}
			else if(typeDim.equals("h")) {
				min =(int) tweets.stream()
				.map(Tweet -> Arrays.stream(Tweet.getEvento().getMax()).reduce((first, second) -> second))
				.map(Object::toString)
				.map(Integer::parseInt)
				.min(Comparator.comparing(Integer::valueOf)).get();
				med =(double) tweets.stream()
				.map(Tweet -> Arrays.stream(Tweet.getEvento().getMax()).reduce((first, second) -> second))
				.map(Object::toString)
				.map(Double::parseDouble)
				.mapToDouble(Double::doubleValue)
				.average().getAsDouble();
				max =(int) tweets.stream()
				.map(Tweet -> Arrays.stream(Tweet.getEvento().getMax()).reduce((first, second) -> second))
				.map(Object::toString)
				.map(Integer::parseInt)
				.max(Comparator.comparing(Integer::valueOf)).get();
										
				stat.setTweetattribute(typestat);
				stat.setImageDim(typeDim);
				stat.setMin(min);
				stat.setMed(med);
				stat.setMax(max);
				return stat;
			}
			else {
				stat.setTweetattribute(typestat);
				stat.setImageDim("Dimension not valid!");
				stat.setMin(0);
				stat.setMed(0);
				stat.setMax(0);
				return stat;
			}
		}
		case "min in last month": {
			String lastMonth = tweets.get(0).findMonth();
			if(typeDim.equals("w")) {
				min =(int) tweets.stream()
				.filter(Tweet -> Tweet.findMonth().equals(lastMonth))
				.map(Tweet -> Arrays.stream(Tweet.getEvento().getMin()).findFirst().get())
				.map(Object::toString)
				.map(Integer::parseInt)
				.min(Comparator.comparing(Integer::valueOf)).get();
				med =(double) tweets.stream()
				.filter(Tweet -> Tweet.findMonth().equals(lastMonth))
				.map(Tweet -> Arrays.stream(Tweet.getEvento().getMin()).findFirst().get())
				.map(Object::toString)
				.map(Double::parseDouble)
				.mapToDouble(Double::doubleValue)
				.average().getAsDouble();
				max =(int) tweets.stream()
				.filter(Tweet -> Tweet.findMonth().equals(lastMonth))
				.map(Tweet -> Arrays.stream(Tweet.getEvento().getMin()).findFirst().get())
				.map(Object::toString)
				.map(Integer::parseInt)
				.max(Comparator.comparing(Integer::valueOf)).get();
				
				stat.setTweetattribute(typestat);
				stat.setImageDim(typeDim);
				stat.setMin(min);
				stat.setMed(med);
				stat.setMax(max);
				return stat;
			}
			else if(typeDim.equals("h")) {
				min =(int) tweets.stream()
				.filter(Tweet -> Tweet.findMonth().equals(lastMonth))
				.map(Tweet -> Arrays.stream(Tweet.getEvento().getMin()).reduce((first, second) -> second))
				.map(Object::toString)
				.map(Integer::parseInt)
				.min(Comparator.comparing(Integer::valueOf)).get();
				med =(double) tweets.stream()
				.filter(Tweet -> Tweet.findMonth().equals(lastMonth))
				.map(Tweet -> Arrays.stream(Tweet.getEvento().getMin()).reduce((first, second) -> second))
				.map(Object::toString)
				.map(Double::parseDouble)
				.mapToDouble(Double::doubleValue)
				.average().getAsDouble();
				max =(int) tweets.stream()
				.filter(Tweet -> Tweet.findMonth().equals(lastMonth))
				.map(Tweet -> Arrays.stream(Tweet.getEvento().getMin()).reduce((first, second) -> second))
				.map(Object::toString)
				.map(Integer::parseInt)
				.max(Comparator.comparing(Integer::valueOf)).get();
						
				stat.setTweetattribute(typestat);
				stat.setImageDim(typeDim);
				stat.setMin(min);
				stat.setMed(med);
				stat.setMax(max);
				return stat;
			}
			else {
				stat.setTweetattribute(typestat);
				stat.setImageDim("Dimension not valid!");
				stat.setMin(0);
				stat.setMed(0);
				stat.setMax(0);
				return stat;
			}
			
		}
		case "med in last month": {
			String lastMonth = tweets.get(0).findMonth();
			if(typeDim.equals("w")) {
				min =(int) tweets.stream()
				.filter(Tweet -> Tweet.findMonth().equals(lastMonth))
				.map(Tweet -> Arrays.stream(Tweet.getEvento().getMed()).findFirst().get())
				.map(Object::toString)
				.map(Integer::parseInt)
				.min(Comparator.comparing(Integer::valueOf)).get();
				med =(double) tweets.stream()
				.filter(Tweet -> Tweet.findMonth().equals(lastMonth))
				.map(Tweet -> Arrays.stream(Tweet.getEvento().getMed()).findFirst().get())
				.map(Object::toString)
				.map(Double::parseDouble)
				.mapToDouble(Double::doubleValue)
				.average().getAsDouble();
				max =(int) tweets.stream()
				.filter(Tweet -> Tweet.findMonth().equals(lastMonth))
				.map(Tweet -> Arrays.stream(Tweet.getEvento().getMed()).findFirst().get())
				.map(Object::toString)
				.map(Integer::parseInt)
				.max(Comparator.comparing(Integer::valueOf)).get();
				
				stat.setTweetattribute(typestat);
				stat.setImageDim(typeDim);
				stat.setMin(min);
				stat.setMed(med);
				stat.setMax(max);
				return stat;
			}
			else if(typeDim.equals("h")) {
				min =(int) tweets.stream()
				.filter(Tweet -> Tweet.findMonth().equals(lastMonth))
				.map(Tweet -> Arrays.stream(Tweet.getEvento().getMed()).reduce((first, second) -> second))
				.map(Object::toString)
				.map(Integer::parseInt)
				.min(Comparator.comparing(Integer::valueOf)).get();
				med =(double) tweets.stream()
				.filter(Tweet -> Tweet.findMonth().equals(lastMonth))
				.map(Tweet -> Arrays.stream(Tweet.getEvento().getMed()).reduce((first, second) -> second))
				.map(Object::toString)
				.map(Double::parseDouble)
				.mapToDouble(Double::doubleValue)
				.average().getAsDouble();
				max =(int) tweets.stream()
				.filter(Tweet -> Tweet.findMonth().equals(lastMonth))
				.map(Tweet -> Arrays.stream(Tweet.getEvento().getMed()).reduce((first, second) -> second))
				.map(Object::toString)
				.map(Integer::parseInt)
				.max(Comparator.comparing(Integer::valueOf)).get();
						
				stat.setTweetattribute(typestat);
				stat.setImageDim(typeDim);
				stat.setMin(min);
				stat.setMed(med);
				stat.setMax(max);
				return stat;
			}
			else {
				stat.setTweetattribute(typestat);
				stat.setImageDim("Dimension not valid!");
				stat.setMin(0);
				stat.setMed(0);
				stat.setMax(0);
				return stat;
			}
		}
		case "max in last month": {
			String lastMonth = tweets.get(0).findMonth();
			if(typeDim.equals("w")) {
				min =(int) tweets.stream()
				.filter(Tweet -> Tweet.findMonth().equals(lastMonth))
				.map(Tweet -> Arrays.stream(Tweet.getEvento().getMax()).findFirst().get())
				.map(Object::toString)
				.map(Integer::parseInt)
				.min(Comparator.comparing(Integer::valueOf)).get();
				med =(double) tweets.stream()
				.filter(Tweet -> Tweet.findMonth().equals(lastMonth))
				.map(Tweet -> Arrays.stream(Tweet.getEvento().getMax()).findFirst().get())
				.map(Object::toString)
				.map(Double::parseDouble)
				.mapToDouble(Double::doubleValue)
				.average().getAsDouble();
				max =(int) tweets.stream()
				.filter(Tweet -> Tweet.findMonth().equals(lastMonth))
				.map(Tweet -> Arrays.stream(Tweet.getEvento().getMax()).findFirst().get())
				.map(Object::toString)
				.map(Integer::parseInt)
				.max(Comparator.comparing(Integer::valueOf)).get();
				
				stat.setTweetattribute(typestat);
				stat.setImageDim(typeDim);
				stat.setMin(min);
				stat.setMed(med);
				stat.setMax(max);
				return stat;
			}
			else if(typeDim.equals("h")) {
				min =(int) tweets.stream()
				.filter(Tweet -> Tweet.findMonth().equals(lastMonth))
				.map(Tweet -> Arrays.stream(Tweet.getEvento().getMax()).reduce((first, second) -> second))
				.map(Object::toString)
				.map(Integer::parseInt)
				.min(Comparator.comparing(Integer::valueOf)).get();
				med =(double) tweets.stream()
				.filter(Tweet -> Tweet.findMonth().equals(lastMonth))
				.map(Tweet -> Arrays.stream(Tweet.getEvento().getMax()).reduce((first, second) -> second))
				.map(Object::toString)
				.map(Double::parseDouble)
				.mapToDouble(Double::doubleValue)
				.average().getAsDouble();
				max =(int) tweets.stream()
				.filter(Tweet -> Tweet.findMonth().equals(lastMonth))
				.map(Tweet -> Arrays.stream(Tweet.getEvento().getMax()).reduce((first, second) -> second))
				.map(Object::toString)
				.map(Integer::parseInt)
				.max(Comparator.comparing(Integer::valueOf)).get();
						
				stat.setTweetattribute(typestat);
				stat.setImageDim(typeDim);
				stat.setMin(min);
				stat.setMed(med);
				stat.setMax(max);
				return stat;
			}
			else {
				stat.setTweetattribute(typestat);
				stat.setImageDim("Dimension not valid!");
				stat.setMin(0);
				stat.setMed(0);
				stat.setMax(0);
				return stat;
			}
		}
		default: {
			throw new InvalidTypeStatException("Typestat or dimension not valid");
		}
		}
	}
}
