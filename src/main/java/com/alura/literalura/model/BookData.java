package com.alura.literalura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

//para ignorar los datos que no estan mapeados
@JsonIgnoreProperties(ignoreUnknown = true)

public record BookData(
        @JsonAlias("title") String title,
        @JsonAlias("subjects") List<String> subjects,
        @JsonAlias("authors") List<AuthorData> authors,
        @JsonAlias("summaries") List<String> summaries,
        @JsonAlias("languages") List<String> languages,
        @JsonAlias("copyright") Boolean copyright,
        //@JsonAlias("formats") String formats,
        @JsonAlias("download_count") Integer downloadCount
) {
}
