package com.alura.literalura;

import com.alura.literalura.main.Menu;
import com.alura.literalura.model.BookData;
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
		Menu menu = new Menu();
		menu.init();
	}
}
