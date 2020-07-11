package com.esame.util.other;

/**
 * Classe che implementa oggetti filtro con attributi per definire il tipo di filtro
 * @author Simone Murazzo
 * @author Sergio Galletto
 */
public class FilterParam {
	private String type;
	private String filter1;
	private String filter2;
	
	public FilterParam(String type, String filter1, String filter2) {
		this.type = type;
		this.filter1 = filter1;
		this.filter2 = filter2;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getFilter1() {
		return filter1;
	}

	public void setFilter1(String filter1) {
		this.filter1 = filter1;
	}
	
	public String getFilter2() {
		return filter2;
	}
	
	public void setFilter2(String filter2) {
		this.filter2 = filter2;
	}
}
