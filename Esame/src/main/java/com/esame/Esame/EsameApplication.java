package com.esame.Esame;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.esame.database.Database;

@SpringBootApplication
public class EsameApplication {

	public static void main(String[] args) {
		Database.download("https://wd4hfxnxxa.execute-api.us-east-2.amazonaws.com/dev/user/1.1/statuses/user_timeline.json?screen_name=_spaceweather_&count=100");
		SpringApplication.run(EsameApplication.class, args);
	}

}
