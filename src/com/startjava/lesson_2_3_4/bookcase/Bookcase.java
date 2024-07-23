package com.startjava.lesson_2_3_4.bookcase;

public class Bookcase {
    static int booksNumber = 0;
    private static Book[] books = new Book[10];

    private Bookcase() {
        throw new AssertionError("This class cannot be instantiated");
    }

    public static void displayBookcase() {
        int maxLine = maxInfoLength(booksNumber);
        String dash = "-";
        for (int i = 0; i < books.length; i++) {
            System.out.printf("Полка %02d", (i + 1));
            System.out.println("|" + (books[i] != null ?
                    books[i] + " ".repeat(maxLine - books[i].toString().length()) : dash.repeat(maxLine)) + "|");
        }
    }

    public static void add(String author, String title, int year) {
        books[booksNumber] = new Book(author, title, year);
        booksNumber++;
        System.out.printf("Полка %d. Добавлена книга:%n%s%n", booksNumber, books[booksNumber - 1].toString());
    }

    public static void delete(int shelf) {
        if (shelf == books.length) {
            books[books.length - 1] = null;
            System.out.printf("Полка %d. Удалена книга:%n%s%n", shelf,  books[shelf - 1].toString());
            booksNumber--;
            return;
        }
        System.out.printf("Полка %d. Удалена книга:%n%s%n", shelf, books[shelf - 1].toString());
        System.arraycopy(books, shelf, books, shelf - 1, booksNumber - shelf);
        books[booksNumber - 1] = null;
        booksNumber--;
    }

    public static void findByTitle(String input) {
        boolean hasMatch = false;
        for (int i = 0; i < booksNumber; ++i) {
            if (books[i].getTitle().toLowerCase().contains(input)) {
                System.out.printf("Полка %d: %s\n", i + 1, books[i].toString());
                hasMatch = true;
            }
        }
        if (!hasMatch) {
            System.out.println("Поск не дал результатов.");
        }
    }

    public static void deleteAll() {
        for (int i = 0; i < booksNumber; ++i) {
            books[i] = null;
        }
        booksNumber = 0;
        System.out.println("Шкаф очищен.");
    }

    public static void displayBookcaseInfo() {
        System.out.printf("В шкафу книг: %d. Свободно полок: %d.\n", booksNumber, books.length - booksNumber);
    }

    public static int maxInfoLength(int booksNumber) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < booksNumber; ++i) {
            if (books[i].toString().length() > max) {
                max = books[i].toString().length();
            }
        }
        return !isEmpty() ? max : 15;
    }

    public static boolean isFull() {
        if (booksNumber == books.length) {
            System.out.println("Шкаф полон.");
            return true;
        }
        return false;
    }

    public static boolean isEmpty() {
        if (booksNumber == 0) {
            System.out.println("Шкаф пуст.");
            return true;
        }
        return false;
    }
}
