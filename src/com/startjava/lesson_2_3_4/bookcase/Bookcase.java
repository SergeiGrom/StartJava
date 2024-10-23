package com.startjava.lesson_2_3_4.bookcase;

import java.util.Arrays;

public class Bookcase {
    private static final int CAPACITY = 10;
    private int maxShelvesLen;
    private int booksNumber;
    private Book[] books = new Book[CAPACITY];

    public int getBooksNumber() {
        return booksNumber;
    }

    public int getMaxShelvesLen() {
        return maxShelvesLen;
    }

    public Book[] getBooks() {
        return Arrays.copyOf(books, booksNumber);
    }

    public Book[] find(String inputTitle) {
        Book[] foundBooks = new Book[booksNumber];
        int index = 0;
        for (Book book : getBooks()) {
            if (book.getTitle().equalsIgnoreCase(inputTitle)) {
                foundBooks[index] = book;
                index++;
            }
        }
        return Arrays.copyOf(foundBooks, index);
    }

    public void add(Book book) {
        books[booksNumber] = book;
        booksNumber++;
        updateLenShelves();
    }

    public void delete(String inputTitle) {
        for (int i = 0; i < booksNumber; ) {
            if (books[i].getTitle().equalsIgnoreCase(inputTitle)) {
                System.arraycopy(books, i + 1, books, i, booksNumber - 1 - i);
                books[booksNumber - 1] = null;
                booksNumber--;
                updateLenShelves();
            } else {
                i++;
            }
        }
    }

    public void clear() {
        Arrays.fill(books, 0, booksNumber, null);
        booksNumber = 0;
        updateLenShelves();
    }

    public int emptyShelves() {
        return CAPACITY - booksNumber;
    }

    public void updateLenShelves() {
        int maxLen = Integer.MIN_VALUE;
        for (Book book : getBooks()) {
            maxLen = Math.max(book.toString().length(), maxLen);
        }
        maxShelvesLen = maxLen;
    }

    public boolean isEmpty() {
        return booksNumber == 0;
    }

    public boolean isFull() {
        return booksNumber == CAPACITY;
    }
}
