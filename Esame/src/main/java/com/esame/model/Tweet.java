package com.esame.model;

import java.util.regex.Pattern;

/**
 * Cattura il tweet e ne estrapola l'evento
 * @author Simone Murazzo
 * @author Sergio Galletto
 */

public class Tweet {
	private String text;
	private Event event;
	
	public Tweet(String text, String date){
		event = new Event(this.findType(), this.findIntensity(), date);
	}
	
	public String findType() {
			boolean isFlare = text.contains("flare");
			if(isFlare)
				return "flare";
			boolean isConditions = text.contains("geomagnetic conditions");
			if(isConditions)
				return "geomagnetic conditions";
			boolean isStorm = text.contains("geomagnetic storm");
			if(isConditions)
				return "geomagnetic storm";
			else
				return "tweet not valid";
	}
	
	public String findIntensity() {
		
	}
}
