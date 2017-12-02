package com.shvants.UrlShorter;

import com.shvants.UrlShorter.service.IdGenerator;
import com.shvants.UrlShorter.service.ShortUrlGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UrlShorterApplication {

	public static void main(String[] args) {
		SpringApplication.run(UrlShorterApplication.class, args);
		Facade.getInstance();
	}
}
