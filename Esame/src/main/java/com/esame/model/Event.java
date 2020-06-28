package com.esame.model;

import java.util.ArrayList;

/**
 * Modello per evento
 * @author Simone Murazzo
 * @author Sergio Galletto
 */

public class Event {

	private String type;
	private String intensity;
	private String date;
	private String min;
	
	public Event(String type, String intensity, String date){
		this.type = type;
		this.intensity = intensity;
		this.date = date;
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
}
