package com.esame.service;

import com.esame.exception.FilterNotFoundException;
import com.esame.util.filter.CombinedFilter;
import com.esame.util.filter.ImageFilter;
import com.esame.util.filter.TypeFilter;

public class FilterService {
	private static String out = new String();
	
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
