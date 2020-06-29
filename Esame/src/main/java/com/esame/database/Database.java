package com.esame.database;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLConnection;
import java.net.URL;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONValue;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import com.esame.model.Tweet;

public class Database {
	private static String[] min = new String[2];
	private static String[] med = new String[2];
	private static String[] max = new String[2];
	private static ArrayList<Tweet> tweet = new ArrayList<Tweet>();
	
	public static ArrayList<Tweet> getTweet(){
		return tweet;
	}
	
	public static void download(String url) {
		try {
			URLConnection twitterConnection = new URL(url).openConnection();
			InputStream inConnect = twitterConnection.getInputStream();
			
			String data = "";
			String line = "";
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
			
			JSONObject tweetList = (JSONObject) JSONValue.parseWithException(data);
			String tweetDate = (String) (tweetList.get("created_at"));
			String tweetText = (String) (tweetList.get("text"));
			JSONObject tweetEntity = (JSONObject) (tweetList.get("entities"));
			JSONArray tweetMedia = (JSONArray) (tweetEntity.get("media"));
			
			for(Object m: tweetMedia) {
				if(m instanceof JSONObject) {
					JSONObject media = (JSONObject) m;
					JSONObject photoSizes = (JSONObject) (media.get("sizes"));
					JSONObject small = (JSONObject) photoSizes.get("small");
					min[1] = (String) small.get("w");
					min[2] = (String) small.get("h");
									
					JSONObject medium = (JSONObject) photoSizes.get("medium");
					med[1] = (String) medium.get("w");
					med[2] = (String) medium.get("h");
									
					JSONObject large = (JSONObject) photoSizes.get("large");
					min[1] = (String) large.get("w");
					min[2] = (String) large.get("h");
				}
			}
			tweet.add(new Tweet(tweetText, tweetDate, min, max, med));
			
		}catch(IOException e) {
			System.out.println(e.getClass().getCanonicalName()+"Errore in com.esame.database.Database.java: "
					+"Connessione non riuscita o url errato");
		}catch(ParseException e) {
			System.out.println(e.getClass().getCanonicalName()+"Errore in com.esame.database.Database.java: "
					+"Operazione di parsing non riuscita: Object non può essere convertito in String");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
