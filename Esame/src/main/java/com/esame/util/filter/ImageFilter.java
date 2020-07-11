package com.esame.util.filter;

import java.util.ArrayList;

import com.esame.database.Database;
import com.esame.exception.FilterNotFoundException;
import com.esame.model.Tweet;
import com.esame.util.other.ArrayListOperation;

/**
 * Classe che implementa un filtro per i parametri delle immagini
 * @author Simone Murazzo
 * @author Sergio Galletto
 */
public class ImageFilter{
	private ArrayList<Tweet> tweets = new ArrayList<Tweet>();
	
	public ImageFilter() {
		tweets = Database.getTweet();
	}
	
	/**
	 * Metodo che passa la stringa filter a arrayListToFilteredString
	 * restituisce una stringa in formato json
	 * @param filter stringa filtro
	 * @return String in formato json
	 * @throws FilterNotFoundException se il filtro non è corretto
	 */
	public String get(String filter) throws FilterNotFoundException{
		String out = ArrayListOperation.arrayListToFilteredString(tweets, filter);
		return out;
	}
}
