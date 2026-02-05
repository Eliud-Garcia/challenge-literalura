package com.alura.literalura.service;

import com.alura.literalura.model.Author;
import com.alura.literalura.model.AuthorData;
import com.alura.literalura.model.Book;
import com.alura.literalura.model.BookData;
import com.alura.literalura.repository.AuthorRepository;
import com.alura.literalura.repository.BookRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class AuthorBookService {
    private final AuthorRepository authorRepo;
    private final BookRepository bookRepo;

    public AuthorBookService(AuthorRepository authorRepo, BookRepository bookRepo) {
        this.authorRepo = authorRepo;
        this.bookRepo = bookRepo;
    }

    @Transactional
    public void saveAuthorWithBook(AuthorData author, BookData book) {

        Author authorEntity = authorRepo.findByName(author.name())
                .orElseGet(() -> authorRepo.save(new Author(author)));

        Book bookEntity = bookRepo.findByTitle(book.title())
                .orElseGet(() -> bookRepo.save(new Book(book)));

        authorEntity.addBook(bookEntity);
    }
}
