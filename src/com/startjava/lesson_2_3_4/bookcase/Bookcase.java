package com.startjava.lesson_2_3_4.bookcase;

import java.util.Scanner;

public class Bookcase {
    public static int booksNumber = 0;
    public static Book[] books = new Book[10];

    public static void display(ConsoleUi ui) {
        displayInfo(ui);
        if (booksNumber == 0) return;
        int maxLine = maxInfoLength(booksNumber);
        String dash = "-";
        for (int i = 0; i < books.length; i++) {
            System.out.printf("Полка %02d", (i + 1));
            System.out.println("|" + (books[i] != null ?
                    books[i] + " ".repeat(maxLine - books[i].toString().length()) : dash.repeat(maxLine)) + "|");
        }
    }

    public static void add(Scanner sc, ConsoleUi ui) {
        int emptyIndex = booksNumber;
        if (emptyIndex == books.length) {
            System.out.println(ui.fullBookcase);
            return;
        }
        books[emptyIndex] = new Book();
        System.out.print(ui.setAuthor);
        books[emptyIndex].setAuthor(sc.nextLine());
        System.out.print(ui.setTitle);
        books[emptyIndex].setTitle(sc.nextLine());
        System.out.print(ui.setYearEstablishment);
        books[emptyIndex].setYearEstablishment(sc.nextInt());
        sc.nextLine();
        booksNumber++;

        displayBookInfo(ui, booksNumber, "add");
    }

    public static void delete(Scanner sc, ConsoleUi ui) {
        System.out.println(ui.chooseShelf);
        boolean isCorrect = false;
        int input = sc.nextInt();
        sc.nextLine();
        while (!isCorrect) {
            if (input < 1 || input > booksNumber) {
                System.out.println(ui.wrongShelfInput + booksNumber);
            }
            isCorrect = true;
        }
        if (booksNumber == books.length && input == booksNumber) {
            displayBookInfo(ui, booksNumber, "delete");
            books[books.length - 1] = null;
            booksNumber--;
            return;
        }
        displayBookInfo(ui, input, "delete");
        System.arraycopy(books, input, books, input - 1, booksNumber - input);
        books[booksNumber - 1] = null;
        booksNumber--;
    }

    public static void clearAll(ConsoleUi ui) {
        for (int i = 0; i < booksNumber; ++i) {
            books[i] = null;
        }
        System.out.println(ui.separator);
        System.out.printf("%s %s %d%n", ui.emptyBookcase, ui.emptyShelves, books.length);
        booksNumber = 0;
    }

    public static void findByTitle(Scanner sc, ConsoleUi ui) {
        System.out.print(ui.setAuthor);
        String input = sc.nextLine().toLowerCase();
        System.out.println(ui.searchResult);
        boolean isAnything = false;
        for (int i = 0; i < booksNumber; ++i) {
            if (books[i].getTitle().toLowerCase().contains(input)) {
                displayBookInfo(ui, i, "");
                isAnything = true;
            }
        }
        if (!isAnything) {
            System.out.println(ui.findNothing);
        }
    }

    public static void displayInfo(ConsoleUi ui) {
        System.out.printf("%s %d. %s %d.\n", ui.booksAmount, booksNumber, ui.emptyShelves, books.length - booksNumber);
    }

    public static void displayBookInfo(ConsoleUi ui, int shelf, String state) {
        if (state.equals("add")) {
            System.out.println(ui.separator);
            System.out.printf("Полка %d. Добавлена книга:%n%s%n", shelf, books[shelf - 1]);
            return;
        }
        if (state.equals("delete")) {
            System.out.println(ui.separator);
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
