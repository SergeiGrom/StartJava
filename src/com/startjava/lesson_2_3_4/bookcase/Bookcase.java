package com.startjava.lesson_2_3_4.bookcase;

public class Bookcase {
    private int booksNumber;
    private Book[] books;

    public Bookcase(int booksNumber, Book[] books) {
        this.booksNumber = booksNumber;
        this.books = books;
    }

    public int getBooksNumber() {
        return booksNumber;
    }

    public Book[] getBooks() {
        return books;
    }

    public Book[] findByTitle(String input) {
        Book[] booksClone = books.clone();
        for (int i = 0; i < booksNumber; ++i) {
            if (!booksClone[i].getTitle().toLowerCase().contains(input)) {
                booksClone[i] = null;
            }
        }
        return booksClone;
    }

    public void add(String author, String title, int year) {
        books[booksNumber] = new Book(author, title, year);
        booksNumber++;
    }

    public void delete(int shelf) {
        if (shelf == books.length) {
            books[books.length - 1] = null;
            booksNumber--;
            return;
        }
        System.arraycopy(books, shelf, books, shelf - 1, booksNumber - shelf);
        books[booksNumber - 1] = null;
        booksNumber--;
    }

    public void deleteAll() {
        for (int i = 0; i < booksNumber; ++i) {
            books[i] = null;
        }
        booksNumber = 0;
    }
}
