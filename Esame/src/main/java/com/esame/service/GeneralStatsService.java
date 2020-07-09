package com.esame.service;

import com.esame.database.Database;
import com.esame.exception.InvalidTypeStatException;
import com.esame.model.GeneralStatsMod;
import com.esame.util.stats.GeneralStats;

public class GeneralStatsService {
	private static GeneralStats gStat;
	
	public GeneralStatsService(String type, String filter) throws InvalidTypeStatException {
			instanceGen(type,filter);
	}
	
	public static GeneralStatsMod instanceGen(String type, String filter) throws InvalidTypeStatException{
		gStat = new GeneralStats(Database.getTweet());
		return gStat.returnGeneralStat(type, filter);
	}
}
