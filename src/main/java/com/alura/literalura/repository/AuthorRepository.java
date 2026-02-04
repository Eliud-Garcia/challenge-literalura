package com.alura.literalura.repository;

import com.alura.literalura.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    //Busca los autores que estaban vivos en un año dado
    //(l, r) deben ser iguales a dicho año
    List<Author> findByBirthYearIsNotNullAndDeathYearIsNotNullAndBirthYearLessThanEqualAndDeathYearGreaterThanEqual(int l, int r);
}
