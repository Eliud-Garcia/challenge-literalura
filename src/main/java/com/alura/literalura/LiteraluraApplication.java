package com.alura.literalura;

import com.alura.literalura.model.BooksData;
import com.alura.literalura.service.ApiConnection;
import com.alura.literalura.service.ConvertData;
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

		//probando conversor
		ConvertData cd = new ConvertData();
		BooksData data = cd.getDataFromJson(ans, BooksData.class);
		System.out.println(data);
	}
}
