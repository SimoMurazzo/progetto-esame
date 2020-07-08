package com.esame.service;

import com.esame.database.Database;
import com.esame.exception.FilterNotFoundException;
import com.esame.exception.InvalidTypeStatException;
import com.esame.util.stats.GeneralStats;
import com.esame.util.stats.ImageStats;

public class StatsService {
	private static GeneralStats gStat;
	private static ImageStats iStat;
	
	public static void statInstance(String type, String filter) throws InvalidTypeStatException, FilterNotFoundException{
		gStat = new GeneralStats(Database.getTweet());
		iStat = new ImageStats(Database.getTweet());
		if(!(type.equalsIgnoreCase("min") || type.equalsIgnoreCase("med") || type.equalsIgnoreCase("max")))
			System.out.println("\"" + type + "\":\"" + filter + 
				"\"\n" + gStat.returnGeneralStat(type, filter));
		else if(!(type.equalsIgnoreCase("type") || 
				type.equalsIgnoreCase("date") || 
				type.equalsIgnoreCase("type in last month")))
			System.out.println("\"" + type + "\":\"" + filter + 
				"\"\n" + iStat.returnImageStat(type, filter));
		else
			throw new FilterNotFoundException("Filter is inexistent");
	}
}
