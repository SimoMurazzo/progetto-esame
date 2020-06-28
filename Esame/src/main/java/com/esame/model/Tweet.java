package com.esame.model;

import java.util.regex.Pattern;

import java.util.regex.Matcher;

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
		
		String type = findType();
		String intensity = "";
		if (type == "flare") {
		Pattern intensityP = Pattern.compile("[ABCMX][0-9]*.[0-9]*");
		Matcher intensityM = intensityP.matcher(text);
		while (intensityM.find()) 
			intensity = intensityM.group(1);
		return intensity;
		
		}
		else if (type == "geomagnetic conditions" || type == "geomagnetic storm") {
			Pattern intensityP = Pattern.compile("Kp[0-9]");
			Matcher intensityM = intensityP.matcher(text);
			while (intensityM.find()) 
				intensity = intensityM.group(1);
			return intensity;
			
		}
		else {
		intensity = "intensity not valid";
		return intensity;
		}
	}
}

