package com.startjava.lesson_2_3_4.bookcase;

public class Book {
    private String author;
    private String title;
    private int yearPublication;

    public Book(String author, String title, int year) {
        this.author = author;
        this.title = title;
        this.yearPublication = year;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Автор: " + author + ". " +
               "Название: " + title + ". " +
               "Год издания: " + yearPublication + ".";
    }
}


