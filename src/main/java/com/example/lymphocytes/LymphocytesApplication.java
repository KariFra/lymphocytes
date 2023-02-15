package com.example.lymphocytes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class LymphocytesApplication {

	public static void main(String[] args) {
		SpringApplication.run(LymphocytesApplication.class, args);
	}

}
