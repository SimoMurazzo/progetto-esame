package com.esame.util.other;

import java.util.ArrayList;

import com.esame.exception.FilterNotFoundException;
import com.esame.model.Tweet;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

/**
 * Classe che contiene metodi per operare su ArrayList
 * @author Simone Murazzo
 * @author Sergio Galletto
 */
public class ArrayListOperation {
	private static ArrayList<Tweet> tweets = new ArrayList<Tweet>();
	
	/**
	 * Metodo che restituisce una stringa json a partire da un ArrayList
	 * @param arTweets ArrayList di tweet
	 * @return String in formato json
	 */
	public static String arrayListToString(ArrayList<Tweet> arTweets) {
		tweets = arTweets;
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		String json = gson.toJson(tweets);
		return json;
	}
	
	/**
	 * Metodo che restituisce una stringa json a partire da un ArrayList filtrando le dimensioni delle immagini
	 * @param arTweets ArrayList di tweet
	 * @param filter stringa filtro
	 * @return String in formato json
	 * @throws FilterNotFoundException se il filtro non è corretto
	 */
	public static String arrayListToFilteredString(ArrayList<Tweet> arTweets, String filter) throws FilterNotFoundException{
		tweets = arTweets;
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		String json = gson.toJson(tweets);
		
		JsonArray jsonAr = gson.fromJson(json, JsonElement.class).getAsJsonArray();
		JsonArray finalJsonAr = new JsonArray();
		JsonObject jsonOb = new JsonObject();
		for(int i = 0; i < jsonAr.size(); i++) {
			jsonOb = jsonAr.get(i).getAsJsonObject();
				switch(filter) {
					case "min":
						jsonOb.get("evento").getAsJsonObject().remove("max");
						jsonOb.get("evento").getAsJsonObject().remove("med");
						break;
					case "max":
						jsonOb.get("evento").getAsJsonObject().remove("min");
						jsonOb.get("evento").getAsJsonObject().remove("med");
						break;
					case "med":
						jsonOb.get("evento").getAsJsonObject().remove("min");
						jsonOb.get("evento").getAsJsonObject().remove("max");
						break;
					default:
						throw new FilterNotFoundException("Invalid image filter");
				}
				finalJsonAr.add(jsonOb);
			}
		
		String finalJson = gson.toJson(finalJsonAr);
		return finalJson;
	}
}
