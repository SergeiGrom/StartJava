package com.startjava.lesson_2_3_4.bookcase;

import java.util.Arrays;

public class Bookcase {
    static final int MAX_BOOKS_NUMBER = 10;
    private static final int DEFAULT_INFO_LENGTH = 15;
    private int booksNumber;
    private Book[] books = new Book[MAX_BOOKS_NUMBER];

    public Bookcase(int booksNumber) {
        this.booksNumber = booksNumber;
    }

    public int getBooksNumber() {
        return booksNumber;
    }

    public Book[] getBooks() {
        return Arrays.copyOf(books, booksNumber);
    }

    public Book[] find(String inputTitle) {
        Book[] foundBooks = new Book[booksNumber];
        boolean hasMatch = false;
        int index = 0;
        for (Book book : getBooks()) {
            if (book.getTitle().equalsIgnoreCase(inputTitle)) {
                foundBooks[index] = book;
                index++;
                hasMatch = true;
            }
        }
        return hasMatch ? Arrays.copyOf(foundBooks, index) : new Book[0];
    }

    public void add(Book book) {
        books[booksNumber] = book;
        booksNumber++;
    }

    public void delete(String inputTitle) {
        for (int i = 0; i < booksNumber; ) {
            if (books[i].getTitle().equalsIgnoreCase(inputTitle)) {
                try {
                    System.arraycopy(books, i + 1, books, i, booksNumber - 1);
                } catch (ArrayIndexOutOfBoundsException e) {
                }
                books[booksNumber - 1] = null;
                booksNumber--;
            } else {
                i++;
            }
        }
    }

    public void clear() {
        Arrays.fill(books, 0, booksNumber, null);
        booksNumber = 0;
    }

    public int emptyShelves() {
        return MAX_BOOKS_NUMBER - booksNumber;
    }

    public int maxInfoLength() {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < booksNumber; ++i) {
            if (getBooks()[i].toString().length() > max) {
                max = getBooks()[i].toString().length();
            }
        }
        return !isEmpty() ? max : DEFAULT_INFO_LENGTH;
    }

    public boolean isEmpty() {
        return booksNumber == 0;
    }

    public boolean isFull() {
        return booksNumber == MAX_BOOKS_NUMBER;
    }
}
