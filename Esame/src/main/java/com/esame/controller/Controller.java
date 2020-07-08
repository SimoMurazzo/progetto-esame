package com.esame.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.esame.database.Database;
import com.esame.exception.FilterNotFoundException;
import com.esame.exception.InternalGeneralException;
import com.esame.exception.InvalidTypeStatException;
import com.esame.model.Tweet;
import com.esame.service.FilterService;
import com.esame.service.StatsService;

/**
 * Classe che gestisce le chiamate al server
 * @author Simone Murazzo
 * @author Sergio Galletto
 */

@RestController
public class Controller {
	
	@RequestMapping(value = "tweets", method = RequestMethod.GET)
	public ArrayList<Tweet> getTweets() {
		return Database.getTweet();
	}
	
	@RequestMapping(value="tweets", method = RequestMethod.POST)
	public void getTweetsWithPost(@RequestBody String[] filter)
			throws InternalGeneralException, FilterNotFoundException{
		FilterService.tweetInstance(filter[0], filter[1]);
	}
	
	@RequestMapping(value="stats", method = RequestMethod.POST)
	public void getStatsWithPost(@RequestParam(value = "type") String type, @RequestBody String filter) 
			throws InternalGeneralException, FilterNotFoundException, InvalidTypeStatException{
		StatsService.statInstance(type, filter);
	}
}
