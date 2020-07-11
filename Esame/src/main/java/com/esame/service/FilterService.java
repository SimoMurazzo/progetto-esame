package com.esame.service;

import com.esame.exception.FilterNotFoundException;
import com.esame.util.filter.CombinedFilter;
import com.esame.util.filter.ImageFilter;
import com.esame.util.filter.TypeFilter;

/**
 * Classe che implementa il service per i filtri
 * @author Simone Murazzo
 * @author Sergio Galletto
 */
public class FilterService {
	private static String out = new String();
	
	/**
	 * Metodo che usa il tipo di filtro adeguato e restituisce una stringa json filtrata
	 * @param type tipo di filtro
	 * @param filter1 filtro
	 * @param filter2 filtro
	 * @return String in formato json
	 * @throws FilterNotFoundException se il filtro non è corretto
	 */
	public static String tweetInstance(String type, String filter1, String filter2) 
			throws FilterNotFoundException {	
			switch(type) {
				case "combined":
					CombinedFilter fil1 = new CombinedFilter();
					out = fil1.get(filter1, filter2);
					break;
				case "type":
					TypeFilter fil2 = new TypeFilter();
					out = fil2.get(filter1);
					break;
				case "image":
					ImageFilter fil3 = new ImageFilter();
					out = fil3.get(filter2);
					break;
				default:
					throw new FilterNotFoundException("Type of filter not valid");
			}
			return out;
	}
}
