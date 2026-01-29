package com.alura.literalura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;


/*
* Se creo porque el json no devuelve un book
* directamente
* */

@JsonIgnoreProperties(ignoreUnknown = true)

public record GutendexResponseData(
        @JsonAlias("count") int count,
        @JsonAlias("next") String nextUrl,
        @JsonAlias("previous") String previousUrl,
        @JsonAlias("results") List<BookData> books
        ) {
}
