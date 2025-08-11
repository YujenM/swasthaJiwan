package com.swasthajiwan.swasthajiwan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication
public class SwasthajiwanApplication {
	static {
		Dotenv dotenv = Dotenv.load();
		System.setProperty("JWT_SECRET", dotenv.get("JWT_SECRET", "default_secret"));
		System.setProperty("JWT_EXPIRATION_MS", dotenv.get("JWT_EXPIRATION_MS", "86400000"));
		System.out.println("Loaded JWT_SECRET: " + dotenv.get("JWT_SECRET"));
	}
	public static void main(String[] args) {

		SpringApplication.run(SwasthajiwanApplication.class, args);
		System.out.println("Hello world");
	}

}
