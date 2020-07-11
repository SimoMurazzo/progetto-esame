package com.esame.util.filter;

import java.util.ArrayList;

import com.esame.database.Database;
import com.esame.model.Tweet;
import com.esame.util.other.ArrayListOperation;

/**
 * Classe che implementa un filtro per il tipo di evento
 * @author Simone Murazzo
 * @author Sergio Galletto
 */
public class TypeFilter{
	private ArrayList<Tweet> tweets = new ArrayList<Tweet>();
	private ArrayList<Tweet> newTweets = new ArrayList<Tweet>();
	
	public TypeFilter() {
		tweets = Database.getTweet();
	}
	
	/**
	 * Metodo che passa la stringa filter a arrayListToString e filtra per tipo di evento
	 * restituisce una stringa in formato json
	 * @param filter1 stringa filtro
	 * @return String in formato json
	 */
	public String get(String filter1) {
		for(Tweet t: tweets) {
			if(t.getEvento().getType().equalsIgnoreCase(filter1)) {
				newTweets.add(t);
			} else {
				continue;
			}
		}
		String tString = ArrayListOperation.arrayListToString(newTweets);
		return tString;
	}
}
