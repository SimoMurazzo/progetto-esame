package com.esame.service;

import com.esame.exception.FilterNotFoundException;
import com.esame.util.filter.CombinedFilter;
import com.esame.util.filter.ImageFilter;
import com.esame.util.filter.TypeFilter;

public class FilterService {	
	public static void tweetInstance(String filter1, String filter2) 
			throws FilterNotFoundException {
			if(filter1 != null && filter2 != null) {
				CombinedFilter fil = new CombinedFilter(filter1, filter2);
			}
			else if(filter2 == null && (filter1.equalsIgnoreCase("flare")||
					filter1.equalsIgnoreCase("geomagnetic condition")||
					filter1.equalsIgnoreCase("geomagnetic storm"))) {
				TypeFilter fil = new TypeFilter(filter1);
			}
			else if(filter1 == null && (filter2.equalsIgnoreCase("min")||
					filter2.equalsIgnoreCase("med")||filter2.equalsIgnoreCase("max"))) {
				ImageFilter fil = new ImageFilter(filter2);
			}else {
				throw new FilterNotFoundException("Filter not found: Illegal argument");
			}
	}
}
