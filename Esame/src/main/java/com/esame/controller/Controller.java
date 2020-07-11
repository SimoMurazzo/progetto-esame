package com.esame.controller;

import java.util.ArrayList;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.esame.database.Database;
import com.esame.exception.FilterNotFoundException;
import com.esame.exception.InvalidTypeStatException;
import com.esame.model.GeneralStatsMod;
import com.esame.model.ImageStatsMod;
import com.esame.model.Tweet;
import com.esame.service.FilterService;
import com.esame.service.GeneralStatsService;
import com.esame.service.ImageStatsService;
import com.esame.util.other.FilterParam;

/**
 * Classe che gestisce le chiamate al server
 * @author Simone Murazzo
 * @author Sergio Galletto
 */

@RestController
public class Controller {
	
	/**
	 * Risponde alla richiesta GET /tweets
	 * @return Arraylist di tipo Tweet
	 */
	@RequestMapping(value = "tweets", method = RequestMethod.GET)
	public ArrayList<Tweet> getTweets() {
		return Database.getTweet();
	}
	
	/**
	 * Risponde alla richiesta POST /tweets
	 * @param filter oggetto di tipo FilterParam preso come json
	 * @return String in formato json
	 * @throws FilterNotFoundException eccezione filtro non trovato
	 */
	@RequestMapping(value="tweets", method = RequestMethod.POST)
	public String getTweetsWithPost(@RequestBody FilterParam filter)
			throws FilterNotFoundException{
		return FilterService.tweetInstance(filter.getType(), filter.getFilter1(), filter.getFilter2());
	}
	
	/**
	 * Risponde alla chiamata POST /general_stats?type='tipo'&filter='filtro'
	 * @param type tipo di statistica generale
	 * @param filter filtro del tweet
	 * @return GeneralStatsMod modello di statistica generale
	 * @throws FilterNotFoundException eccezione type non trovato
	 * @throws InvalidTypeStatException eccezione filter non valido
	 */
	@RequestMapping(value="general_stats", method = RequestMethod.POST)
	public GeneralStatsMod getGStatsWithPost(@RequestParam(value = "type") String type, @RequestParam(value = "filter") String filter) 
			throws FilterNotFoundException, InvalidTypeStatException{
			return GeneralStatsService.instanceGen(type, filter);
	}
	
	/**
	 * Risponde alla chiamata POST /image_stats?type='tipo'&filter='filtro'
	 * @param type tipo di statistica per le immagini
	 * @param filter filtro sulla dimensione
	 * @return ImageStatsMod modello di statistica per le immagini
	 * @throws FilterNotFoundException eccezione type non trovato
	 * @throws InvalidTypeStatException eccezione filter non valido
	 */
	@RequestMapping(value="image_stats", method = RequestMethod.POST)
	public ImageStatsMod  getIStatsWithPost(@RequestParam(value = "type") String type, @RequestParam(value = "filter") String filter)
			throws FilterNotFoundException, InvalidTypeStatException{
			return ImageStatsService.instanceIma(type, filter);
	}
}
