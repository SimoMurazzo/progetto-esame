package com.esame.model;


/**
 * Modello per evento che contiene tipo, intensità dell'evento, data del tweet,
 * dimesione dell'immagine
 * @author Simone Murazzo
 * @author Sergio Galletto
 */

public class Event {

	private String type;
	private String intensity;
	private String date;
	private String[] min = new String[2];
	private String[] max = new String[2];
	private String[] med = new String[2];
	
	public Event(String type, String intensity, String date, String[] min,String[] max, String[] med){
		this.type = type;
		this.intensity = intensity;
		this.date = date;
		this.min = min.clone();
		this.max = max.clone();
		this.med = med.clone();
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getType() {
		return type;
	}
	
	public void setIntensity(String intensity) {
		this.intensity = intensity;
	}
	
	public String getIntensity() {
		return intensity;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public String getDate() {
		return date;
	}
	
	public String[] getMin() {
		return min;
	}
	
	public String[] getMax() {
		return max;
	}
	
	public String[] getMed() {
		return med;
	}
}
