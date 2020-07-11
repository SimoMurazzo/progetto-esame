package com.test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.esame.exception.FilterNotFoundException;
import com.esame.model.Tweet;
import com.esame.util.other.ArrayListOperation;

class TestFilter {
	private ArrayList<Tweet> tweetlist;
	private Tweet tweet;
	private String[] min = {"10", "8"};
	private String[] med = {"15", "10"};
	private String[] max = {"20", "15"};
	
	@BeforeEach
	void setUp() throws Exception {
		tweet = new Tweet("flare M1.19", "Jul", min, max, med);
		tweetlist = new ArrayList<Tweet>();
		tweetlist.add(tweet);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		assertAll("operations", ()->assertEquals("[\n" + 
				"  {\n" + 
				"    \"evento\": {\n" + 
				"      \"type\": \"flare\",\n" + 
				"      \"intensity\": \"M1.19\",\n" + 
				"      \"date\": \"Jul\",\n" + 
				"      \"min\": [\n" + 
				"        \"10\",\n" + 
				"        \"8\"\n" + 
				"      ]\n" + 
				"    }\n" + 
				"  }\n" + 
				"]", ArrayListOperation.arrayListToFilteredString(tweetlist, "min")),
				()->assertEquals("[\n" + 
						"  {\n" + 
						"    \"evento\": {\n" + 
						"      \"type\": \"flare\",\n" + 
						"      \"intensity\": \"M1.19\",\n" + 
						"      \"date\": \"Jul\",\n" + 
						"      \"min\": [\n" + 
						"        \"10\",\n" + 
						"        \"8\"\n" + 
						"      ],\n" + 
						"      \"max\": [\n" + 
						"        \"20\",\n" + 
						"        \"15\"\n" + 
						"      ],\n" + 
						"      \"med\": [\n" + 
						"        \"15\",\n" + 
						"        \"10\"\n" + 
						"      ]\n" + 
						"    }\n" + 
						"  }\n" + 
						"]", ArrayListOperation.arrayListToString(tweetlist)));
	}
	
	@Test
	void test1() {
		assertThrows(FilterNotFoundException.class, ()->ArrayListOperation.arrayListToFilteredString(tweetlist, " "));
	}
	
	@Test
	void test2() throws FilterNotFoundException {
		assertAll("not null", ()->assertNotNull(ArrayListOperation.arrayListToFilteredString(tweetlist, "min")),
		()->assertNotNull(ArrayListOperation.arrayListToString(tweetlist)));
	}

}
