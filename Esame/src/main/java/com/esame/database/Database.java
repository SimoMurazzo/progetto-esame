package com.esame.database;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;

import com.esame.model.Tweet;

public class Database {
	private static String[] min = {" ", " "};
	private static String[] med = {" ", " "};
	private static String[] max = {" ", " "};
	private static Tweet tweet;
	private static ArrayList<Tweet> tweets = new ArrayList<Tweet>();
	
	public static ArrayList<Tweet> getTweet(){
		return tweets;
	}
	
	public static void download(String url) {
		try {
			URLConnection twitterConnection = new URL(url).openConnection();
			twitterConnection.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/83.0.4103.116 Safari/537.36");
			InputStream inConnect = twitterConnection.getInputStream();
			
			String data = "";
			String line = "";
			String tweetDate = " ";
			String tweetText = " ";
			try {
				InputStreamReader in =  new InputStreamReader(inConnect);
				BufferedReader buffer = new BufferedReader(in);
				
				while((line = buffer.readLine()) != null)
					data +=line;
			}catch(IOException e) {
				System.out.println(e.getClass().getCanonicalName()+"Errore in com.esame.database.Database.java: operazione di I/O JSON interrotta");
			}finally {
				inConnect.close();
			}
			
			JSONArray list = (JSONArray) JSONValue.parseWithException(data);
			for(Object t: list) {
				if(t instanceof JSONObject) {
					JSONObject tweetList = (JSONObject) t;
					tweetDate = (String) (tweetList.get("created_at"));
					tweetText = (String) (tweetList.get("text"));
					JSONObject tweetEntity = (JSONObject) (tweetList.get("entities"));
					
					if( ((JSONObject) tweetEntity).containsKey("media")) {
						JSONArray tweetMedia = (JSONArray) (tweetEntity.get("media"));
					
						for(Object m: tweetMedia) {
							if(m instanceof JSONObject) {
								JSONObject media = (JSONObject) m;
								JSONObject photoSizes = (JSONObject) (media.get("sizes"));
								JSONObject small = (JSONObject) photoSizes.get("small");
								min[0] = (small.get("w")).toString();
								min[1] = (small.get("h")).toString();
												
								JSONObject medium = (JSONObject) photoSizes.get("medium");
								med[0] = (medium.get("w")).toString();
								med[1] = (medium.get("h")).toString();
												
								JSONObject large = (JSONObject) photoSizes.get("large");
								max[0] = (large.get("w")).toString();
								max[1] = (large.get("h")).toString();
							}
							tweet = new Tweet(tweetText, tweetDate, min, max, med);
							tweets.add(tweet);
						}
					}
				}
			}
		}catch(IOException e) {
			System.out.println(e.getClass().getCanonicalName()+"Errore in com.esame.database.Database.java: "
					+"Connessione non riuscita o url errato");
		}catch(ParseException e) {
			System.out.println(e.getClass().getCanonicalName()+"Errore in com.esame.database.Database.java: "
					+"Operazione di parsing non riuscita: Object non può essere convertito in String");
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("Inizializzazione database completata!");
	}
}