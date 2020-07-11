package com.esame.service;

import com.esame.database.Database;
import com.esame.exception.InvalidTypeStatException;
import com.esame.model.GeneralStatsMod;
import com.esame.util.stats.GeneralStats;

/**
 * Classe che implementa il service per le statistiche generali
 * @author Simone Murazzo
 * @author Sergio Galletto
 */
public class GeneralStatsService {
	private static GeneralStats gStat;
	
	public GeneralStatsService(String type, String filter) throws InvalidTypeStatException {
			instanceGen(type,filter);
	}
	
	/**
	 * Metodo che restituisce un oggetto con le statistiche generali richieste
	 * @param type tipo di statistica
	 * @param filter stringa che specifica meglio le statistiche
	 * @return GeneralStatsMod modello di statistica generale
	 * @throws InvalidTypeStatException se la statistica non è corretta
	 */
	public static GeneralStatsMod instanceGen(String type, String filter) throws InvalidTypeStatException{
		gStat = new GeneralStats(Database.getTweet());
		return gStat.returnGeneralStat(type, filter);
	}
}
