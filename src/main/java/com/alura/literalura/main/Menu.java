package com.alura.literalura.main;

import com.alura.literalura.model.*;
import com.alura.literalura.repository.AuthorRepository;
import com.alura.literalura.repository.BookRepository;
import com.alura.literalura.service.ApiConnection;
import com.alura.literalura.service.ConvertData;
import com.alura.literalura.service.InputValidator;

import java.util.*;


public class Menu {
    private Scanner en = new Scanner(System.in);
    private ConvertData convert = new ConvertData();
    private ApiConnection api = new ApiConnection();
    private InputValidator inputValidator = new InputValidator();

    private final String BASE_URL = "https://gutendex.com/books/";

    private BookRepository bookRepo;
    private AuthorRepository authorRepo;

    Map<Integer, String> languagesOptions = new HashMap<>();

    private final String menu = """
            Ingresa una opción a través de su número:
            1. Buscar libro por título
            2. Listar libros registrados
            3. Listar autores registrados
            4. Listar autores vivos en un determinado año
            5. Listar libros por idioma
            0. Salir
            """;

    public Menu(BookRepository bookRepo, AuthorRepository authorRepo){
        this.bookRepo = bookRepo;
        this.authorRepo = authorRepo;
    }

    public void preLoad(){
        languagesOptions.put(1, "es");
        languagesOptions.put(2, "en");
        languagesOptions.put(3, "it");
        languagesOptions.put(4, "zh");
    }

    public void init(){
        preLoad();
        System.out.println("Bienvenido a literalura");
        int option = 99;
        while(option != 0){
            option = 99;
            System.out.println(menu);
            String input = en.nextLine();
            if(inputValidator.isValidInteger(input)){
                option = Integer.parseInt(input);
            }

            switch (option){
                case 1:
                    System.out.println("1. Buscar libro por título");
                    System.out.println("Ingresa el título del libro: ");
                    searchBookByTitle(en.nextLine());
                    break;
                case 2:
                    System.out.println("2. Listar libros registrados");
                    getAllBooks();
                    break;
                case 3:
                    System.out.println("3. Listar autores registrados");
                    getAllAuthors();
                    break;
                case 4:
                    System.out.println("4. Listar autores vivos en un determinado año");
                    System.out.println("Ingresa el año: ");
                    int year = inputValidator.parseIntegerWithRetry("Ingresa un año válido", en);
                    getLivingAuthorsByYear(year);
                    break;
                case 5:
                    System.out.println("5. Listar libros por idioma");
                    final String LANGUAGES = """
                                1. Español
                                2. Inglés
                                3. Italiano
                                4. Chino 
                            """;

                    System.out.println(LANGUAGES);
                    System.out.println("Ingresa la opción correspondiente al idioma: ");
                    int value = inputValidator.parseIntegerWithRetry("Ingresa la opción correspondiente al idioma: ", en);
                    getBooksByLanguage(value);
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
        AuthorData author = book.authors().stream().
                findFirst().
                orElse(new AuthorData(null, null, "unknown"));

        String language = book.languages().stream()
                        .findFirst().orElse("unknown");

        System.out.println("===========================");
        System.out.printf("Titulo: %s\n", book.title());
        System.out.printf("Idioma: %s\n", language);

        System.out.println("Autor: ");
        System.out.printf("     Nombre: %s\n", author.name());
        System.out.printf("     Año nacimiento: %d\n", author.birthYear());
        System.out.printf("     Año fallecimiento: %d\n", author.deathYear());

        System.out.printf("Descargas: %d\n", book.downloadCount());
        System.out.println("===========================");

        /* guardar un autor con su libro*/
        Author authorSave = new Author(author);
        Book bookSave = new Book(book);
        authorSave.addBook(bookSave);

        authorRepo.save(authorSave);

    }

    public void getAllBooks(){
        List<Book> allBooks = bookRepo.findAll();
        System.out.printf("Cantidad de libros: %d\n", allBooks.size());
        allBooks.forEach(System.out::println);
        System.out.println();
    }

    public void getAllAuthors(){
        List<Author> allAuthors = authorRepo.findAll();
        System.out.printf("Cantidad de autores: %d\n", allAuthors.size());
        allAuthors.forEach(System.out::println);
        System.out.println();
    }

    public void getLivingAuthorsByYear(int year){
        List<Author> ans = authorRepo.
                findByBirthYearIsNotNullAndDeathYearIsNotNullAndBirthYearLessThanEqualAndDeathYearGreaterThanEqual(year, year);
        System.out.printf("Resultados encontrados: %d\n", ans.size());
        ans.forEach(System.out::println);
        System.out.println();
    }

    public void getBooksByLanguage(int value){
        if(!languagesOptions.containsKey(value)){
            System.out.printf("La opción del lenguaje (%d) no está disponible\n", value);
            return;
        }
        List<Book> ans = bookRepo.findByLanguage(languagesOptions.get(value));
        System.out.printf("Resultados encontrados: %d\n", ans.size());
        ans.forEach(System.out::println);
        System.out.println();
    }


}