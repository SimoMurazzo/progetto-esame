package com.esame.service;

import com.esame.database.Database;
import com.esame.exception.InvalidTypeStatException;
import com.esame.model.ImageStatsMod;
import com.esame.util.stats.ImageStats;

/**
 * Classe che implementa il service per le statistiche sulle immagini
 * @author Simone Murazzo
 * @author Sergio Galletto
 */
public class ImageStatsService {
	private static ImageStats iStat;
	
	public ImageStatsService(String type, String filter) throws InvalidTypeStatException{
		instanceIma(type,filter);
	}
	
	/**
	 * Metodo che restituisce un oggetto con le statistiche sulle immagini richieste
	 * @param type tipo di statistica
	 * @param filter stringa che specifica meglio la statistica richiesta
	 * @return ImageStatsMod modello di statistica sulle immagini
	 * @throws InvalidTypeStatException se la statistica non è corretta
	 */
	public static ImageStatsMod instanceIma(String type, String filter) throws InvalidTypeStatException{
		iStat = new ImageStats(Database.getTweet());
		return iStat.returnImageStat(type, filter);
	}
}
