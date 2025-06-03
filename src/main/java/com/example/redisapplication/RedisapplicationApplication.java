package com.example.redisapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class RedisapplicationApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedisapplicationApplication.class, args);
	}

}
