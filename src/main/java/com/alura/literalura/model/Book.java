package com.alura.literalura.model;

public class Book {
    private String title;
    private String language;
    private Integer downloadCount;

    public Book(BookData book) {
        this.title = book.title();
        this.language =  book.languages().stream()
                .findFirst().orElse("unknown");
        this.downloadCount = book.downloadCount();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Integer getDownloadCount() {
        return downloadCount;
    }

    public void setDownloadCount(Integer downloadCount) {
        this.downloadCount = downloadCount;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", language='" + language + '\'' +
                ", downloadCount=" + downloadCount +
                '}';
    }
}
