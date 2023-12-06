package com.example.CacheImpl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class CacheImplApplication {

	public static void main(String[] args) {
		SpringApplication.run(CacheImplApplication.class, args);
	}

}
