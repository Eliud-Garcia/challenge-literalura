package com.alura.literalura;

import com.alura.literalura.service.ApiConnection;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiteraluraApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(LiteraluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		ApiConnection api = new ApiConnection();
		String ans = api.getData("https://gutendex.com/books/1/");
		System.out.println(ans);
	}
}
