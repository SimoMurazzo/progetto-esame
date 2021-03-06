package com.esame.model;


import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * Modello per il tweet che cattura il tweet e ne estrapola l'evento
 * @author Sergio Galletto
 * @author Simone Murazzo
 */
public class Tweet {
	private Event evento;
	
	public Tweet(String text, String date, String[] min, String[] max, String[] med){
		evento = new Event(this.findType(text), this.findIntensity(text), date, min, max, med);
	}
	
	/**
	 * Metodo che restituisce il tipo di evento
	 * @param text testo del tweet
	 * @return String tipo di evento
	 */
	public String findType(String text) {
			boolean isFlare = text.contains("flare");
			if(isFlare)
				return "flare";
			boolean isConditions = text.contains("geomagnetic conditions");
			if(isConditions)
				return "geomagnetic conditions";
			boolean isStorm = text.contains("geomagnetic storm");
			if(isStorm)
				return "geomagnetic storm";
			else
				return "tweet not valid";
	}
	
	/**
	 * Metodo che restituisce l'intensità dell'evento
	 * @param text testo del tweet
	 * @return String intensità
	 */
	public String findIntensity(String text) {
		
		String type = findType(text);
		String intensity = "";
		if (type == "flare") {
		Pattern intensityP = Pattern.compile("[ABCMX][0-9]\\.*[0-9]*");
		Matcher intensityM = intensityP.matcher(text);
		while (intensityM.find()) 
			intensity = intensityM.group(0);
		return intensity;
		
		}
		else if (type == "geomagnetic conditions" || type == "geomagnetic storm") {
			Pattern intensityP = Pattern.compile("Kp[0-9]");
			Matcher intensityM = intensityP.matcher(text);
			while (intensityM.find()) 
				intensity = intensityM.group(0);
			return intensity;
			
		}
		else {
			intensity = "intensity not valid";
			return intensity;
		}
	}
	
	/**
	 * Metodo che restituisce il mese
	 * @return String mese
	 */
	public String findMonth() {
		
		if(evento.getDate().contains("Jan"))
			return "Jan";
		else if(evento.getDate().contains("Feb"))
			return "Feb";
		else if(evento.getDate().contains("Mar"))
			return "Mar";
		else if(evento.getDate().contains("Apr"))
			return "Apr";
		else if(evento.getDate().contains("May"))
			return "May";
		else if(evento.getDate().contains("Jun"))
			return "Jun";
		else if(evento.getDate().contains("Jul"))
			return "Jul";
		else if(evento.getDate().contains("Aug"))
			return "Aug";
		else if(evento.getDate().contains("Sep"))
			return "Sep";
		else if(evento.getDate().contains("Oct"))
			return "Oct";
		else if(evento.getDate().contains("Nov"))
			return "Nov";
		else 
			return "Dec";
	}

	public Event getEvento() {
		return evento;
	}

	public void setEvento(Event evento) {
		this.evento = evento;
	}
}

