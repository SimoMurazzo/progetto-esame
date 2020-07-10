package com.esame.Esame;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.esame.exception.InvalidTypeStatException;
import com.esame.model.GeneralStatsMod;
import com.esame.model.Tweet;
import com.esame.util.stats.GeneralStats;

class TestGeneralStats {
	
	private GeneralStats stat;
	private GeneralStatsMod statmod;
	private String[] min = {"min", "min"};
	private String[] med = {"med", "med"};
	private String[] max = {"max", "max"};
	private Tweet tweet;
	private ArrayList<Tweet> tweetlist;

	@BeforeEach
	void setUp() throws Exception {
		tweet = new Tweet("flare M1.19", "Jul", min, max, med);
		tweetlist = new ArrayList<Tweet>();
		tweetlist.add(tweet);
		stat = new GeneralStats(tweetlist);
		statmod = new GeneralStatsMod("type", 1, "flare");
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() throws InvalidTypeStatException {
		assertAll("tweet", ()->assertEquals(statmod.getAttributetype(), stat.returnGeneralStat("type", "flare").getAttributetype()),
				()->assertEquals(statmod.getTweetattribute(), stat.returnGeneralStat("type", "flare").getTweetattribute()),
				()->assertEquals(statmod.getCounter(), stat.returnGeneralStat("type", "flare").getCounter()));
	}
	
	@Test
	void test1() {
		assertThrows(InvalidTypeStatException.class, ()->stat.returnGeneralStat(" ", " "));
	}
	
	@Test
	void test2() throws InvalidTypeStatException {
		assertNotNull(stat.returnGeneralStat("type", "flare"));
	}

}
