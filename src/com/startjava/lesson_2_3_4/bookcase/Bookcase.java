package com.startjava.lesson_2_3_4.bookcase;

import java.util.Scanner;

public class Bookcase {
    private static int booksNumber = 0;
    private static Book[] books = new Book[10];
    static Scanner sc = new Scanner(System.in);

    private Bookcase() {
        throw new AssertionError("This class cannot be instantiated");
    }

    public static void displayBookcase() {
        if (booksNumber == 0) {
            return;
        }
        int maxLine = maxInfoLength(booksNumber);
        String dash = "-";
        for (int i = 0; i < books.length; i++) {
            System.out.printf("Полка %02d", (i + 1));
            System.out.println("|" + (books[i] != null ?
                    books[i] + " ".repeat(maxLine - books[i].toString().length()) : dash.repeat(maxLine)) + "|");
        }
    }

    public static void add() {
        if (booksNumber == books.length) {
            System.out.println("Шкаф полон.");
            return;
        }
        books[booksNumber] = new Book();
        System.out.print("Введите имя автора: ");
        books[booksNumber].setAuthor(sc.nextLine());
        System.out.print("Введите название книги: ");
        books[booksNumber].setTitle(sc.nextLine());
        System.out.print("Введите год выпуска: ");
        books[booksNumber].setYearEstablishment(sc.nextInt());
        sc.nextLine();
        booksNumber++;
        displayBookInfo(booksNumber, "add");
    }

    public static void delete() {
        if (booksNumber == 0) {
            System.out.println("Шкаф пуст.");
            return;
        }
        System.out.println("Введите номер полки: ");
        int input = sc.nextInt();
        sc.nextLine();
        while (true) {
            if (input < 1 || input > booksNumber) {
                System.out.println("Неверно указан № полки. Занято полок: " + booksNumber);
            } else break;
        }
        if (input == books.length) {
            displayBookInfo(booksNumber, "delete");
            books[books.length - 1] = null;
            booksNumber--;
            return;
        }
        displayBookInfo(input, "delete");
        System.arraycopy(books, input, books, input - 1, booksNumber - input);
        books[booksNumber - 1] = null;
        booksNumber--;
    }

    public static void deleteAll() {
        if (booksNumber == 0) {
            System.out.println("Шкаф пуст.");
            return;
        }
        for (int i = 0; i < booksNumber; ++i) {
            books[i] = null;
        }
        booksNumber = 0;
        System.out.println("Шкаф очищен.");
    }

    public static void findByTitle() {
        if (booksNumber == 0) {
            displayBookcaseInfo();
            return;
        }
        System.out.print("Введите название книги: ");
        String input = sc.nextLine().toLowerCase();
        System.out.println("Подходящие варианты:");
        boolean hasMatch = false;
        for (int i = 0; i < booksNumber; ++i) {
            if (books[i].getTitle().toLowerCase().contains(input)) {
                displayBookInfo(i, "");
                hasMatch = true;
            }
        }
        if (!hasMatch) {
            System.out.println("Поск не дал результатов.");
        }
    }

    public static void displayBookcaseInfo() {
        System.out.printf("В шкафу книг: %d. Свободно полок: %d.\n", booksNumber, books.length - booksNumber);
    }

    public static void displayBookInfo(int shelf, String keyWord) {
        if (keyWord.equals("add")) {
            System.out.printf("Полка %d. Добавлена книга:%n%s%n", shelf, books[shelf - 1]);
            return;
        }
        if (keyWord.equals("delete")) {
            System.out.printf("Полка %d. Удалена книга:%n%s%n", shelf, books[shelf - 1]);
            return;
        }
        System.out.printf("Полка %d. %s%n", shelf + 1, books[shelf]);
    }

    public static int maxInfoLength(int booksNumber) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < booksNumber; ++i) {
            if (books[i].toString().length() > max) {
                max = books[i].toString().length();
            }
        }
        return max;
    }
}
