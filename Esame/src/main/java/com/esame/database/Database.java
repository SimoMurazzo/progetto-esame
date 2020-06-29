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
			JSONArray tweetEntity = (JSONArray) (tweetList.get("entities"));
			
			for(Object en: tweetEntity) {
				if(en instanceof JSONArray) {
					JSONArray tweetMedia = (JSONArray) (en.get("media"));
					for(Object media: tweetMedia) {
						if(media instanceof JSONArray) {
							JSONArray photoSizes = (JSONArray) (media.get("sizes"));
							for(Object sizes: photoSizes) {
								if(sizes instanceof JSONObject) {
									JSONArray minSize = (JSONArray) (sizes.get("small"));
									min[1] = (minSize.get("w")).toString();
									min[2] = (minSize.get("h")).toString();
									
									JSONArray medSize = (JSONArray) (sizes.get("medium"));
									min[1] = (medSize.get("w")).toString();
									min[2] = (medSize.get("h")).toString();
									
									JSONArray maxSize = (JSONArray) (sizes.get("small"));
									min[1] = (maxSize.get("w")).toString();
									min[2] = (maxSize.get("h")).toString();
								}
							}
						}
					}
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
