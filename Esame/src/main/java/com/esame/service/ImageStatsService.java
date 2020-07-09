package com.esame.service;

import com.esame.database.Database;
import com.esame.exception.InvalidTypeStatException;
import com.esame.model.ImageStatsMod;
import com.esame.util.stats.ImageStats;

public class ImageStatsService {
	private static ImageStats iStat;
	
	public ImageStatsService(String type, String filter) throws InvalidTypeStatException{
		instanceIma(type,filter);
	}
	
	public static ImageStatsMod instanceIma(String type, String filter) throws InvalidTypeStatException{
		iStat = new ImageStats(Database.getTweet());
		return iStat.returnImageStat(type, filter);
	}
}
