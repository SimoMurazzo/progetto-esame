package com.esame.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.esame.model.Tweet;
import com.esame.database.Database;

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
}
