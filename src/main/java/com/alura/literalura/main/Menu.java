package com.alura.literalura.main;

import com.alura.literalura.model.BookData;
import com.alura.literalura.model.GutendexResponseData;
import com.alura.literalura.service.ApiConnection;
import com.alura.literalura.service.ConvertData;

import java.util.Scanner;

public class Menu {
    private Scanner en = new Scanner(System.in);
    private ConvertData convert = new ConvertData();
    private ApiConnection api = new ApiConnection();

    private final String BASE_URL = "https://gutendex.com/books/";

    private final String menu = """
            Bienvenido a literalura
            Ingresa una opción a través de su número:
            1. Buscar libro por título
            2. Listar libros registrados
            3. Listar autores registrados
            4. Listar autores vivos en un determinado año
            5. Listar libros por idioma
            0. Salir
            """;

    public void init(){
        int option = -1;
        while(option != 0){
            System.out.println(menu);
            option = en.nextInt();
            en.nextLine();

            switch (option){
                case 1:
                    System.out.println("1. Buscar libro por título");
                    searchBookByTitle(en.nextLine());
                    break;
                case 2:
                    System.out.println("2. Listar libros registrados");
                    break;
                case 3:
                    System.out.println("3. Listar autores registrados");
                    break;
                case 4:
                    System.out.println("4. Listar autores vivos en un determinado año");
                    break;
                case 5:
                    System.out.println("5. Listar libros por idioma");
                    break;
                case 0:
                    System.out.println("Has salido de literalura :)");
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        }
    }

    public void searchBookByTitle(String title){
        // the little prince -> the%20little%20prince
        String titleUrl = title.replace(" ", "%20");
        String json = api.getData(BASE_URL + "?search=" + titleUrl);
        GutendexResponseData data = convert.getDataFromJson(json, GutendexResponseData.class);

        BookData book = data.books().stream().findFirst().orElse(null);
        if(book == null){
            System.out.printf("No hay resultados para %s\n", title);
            return;
        }

        System.out.println("===========================");
        System.out.printf("Titulo: %s\n", book.title());
        System.out.println("Autores: ");
        book.authors().forEach(author -> {
            System.out.printf("     Nombre: %s\n", author.name());
            System.out.printf("     Año nacimiento: %d\n", author.birthYear());
            System.out.printf("     Año fallecimiento: %d\n", author.deathYear());
        });
        System.out.printf("Descargas: %d\n", book.download_count());
        System.out.println("===========================");
    }
}