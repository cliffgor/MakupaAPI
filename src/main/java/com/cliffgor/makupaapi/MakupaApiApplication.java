package com.cliffgor.makupaapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class MakupaApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MakupaApiApplication.class, args);
	}

}
