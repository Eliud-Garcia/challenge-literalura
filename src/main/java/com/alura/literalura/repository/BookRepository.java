package com.alura.literalura.repository;

import com.alura.literalura.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {
    public List<Book> findByLanguage(String language); //derived query
    Optional<Book> findByTitle(String title);
}
