package com.startjava.lesson_2_3_4.bookcase;

public class Book {
    private String author;
    private String title;
    private int yearEstablishment;

    @Override
    public String toString() {
        return author + ", " +
                title + ", " +
                yearEstablishment;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYearEstablishment(int yearEstablishment) {
        this.yearEstablishment = yearEstablishment;
    }
}


