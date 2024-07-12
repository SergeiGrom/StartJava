package com.startjava.lesson_2_3_4.bookcase;

import java.util.Scanner;

public class BookcaseTest {
    static String addBook = """
            1. Добавить книгу
            2. Главное меню
            """;
    static String mainMenu = """
            Книжный шкаф.
            1. Осмотреть
            2. Добавить
            3. Удалить
            4. Поиск
            5. Завершить
            """;
    static String deleteBook = """
            1. Удалить книгу
            2. Очистить шкаф
            3. Главное меню
            """;
    static boolean isExit = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (!isExit) {
            addBookMenu(sc);
        }
        sc.close();
    }

    private static void addBookMenu(Scanner sc) {
        Bookcase.displayBookcaseInfo();
        System.out.print(addBook);
        System.out.print("Введите пункт меню: ");
        boolean isInputCorrect = false;
        while (!isInputCorrect) {
            switch (sc.nextLine()) {
                case "1" -> {
                    isInputCorrect = true;
                    pressEnter(sc);
                    Bookcase.add();
                    pressEnter(sc);
                }
                case "2" -> {
                    isInputCorrect = true;
                    pressEnter(sc);
                    mainMenu(sc);
                }
                default -> throw new IllegalArgumentException("Ошибка: введите номер из списка:");
            }
        }
    }

    private static void mainMenu(Scanner sc) {
        System.out.print(mainMenu);
        System.out.print("Введите пункт меню: ");
        boolean isInputCorrect = false;
        while (!isInputCorrect) {
            switch (sc.nextLine()) {
                case "1" -> {
                    isInputCorrect = true;
                    pressEnter(sc);
                    Bookcase.displayBookcaseInfo();
                    Bookcase.displayBookcase();
                    pressEnter(sc);
                    mainMenu(sc);
                }
                case "2" -> {
                    isInputCorrect = true;
                    pressEnter(sc);
                    addBookMenu(sc);
                }
                case "3" -> {
                    isInputCorrect = true;
                    pressEnter(sc);
                    deleteBookMenu(sc);
                }
                case "4" -> {
                    isInputCorrect = true;
                    pressEnter(sc);
                    Bookcase.findByTitle();
                    pressEnter(sc);
                    mainMenu(sc);
                }
                case "5" -> {
                    isInputCorrect = true;
                    isExit = true;
                }
                default -> throw new IllegalArgumentException("Ошибка: введите номер из списка:");
            }
        }
    }

    private static void deleteBookMenu(Scanner sc) {
        System.out.print(deleteBook);
        System.out.print("Введите пункт меню: ");
        boolean isInputCorrect = false;
        while (!isInputCorrect) {
            switch (sc.nextLine()) {
                case "1" -> {
                    isInputCorrect = true;
                    pressEnter(sc);
                    Bookcase.delete();
                    pressEnter(sc);
                    mainMenu(sc);
                }
                case "2" -> {
                    isInputCorrect = true;
                    pressEnter(sc);
                    Bookcase.deleteAll();
                    pressEnter(sc);
                    mainMenu(sc);
                }
                case "3" -> {
                    isInputCorrect = true;
                    pressEnter(sc);
                    mainMenu(sc);
                }
                default -> throw new IllegalArgumentException("Ошибка: введите номер из списка:");
            }
        }
    }

    private static void pressEnter(Scanner sc) {
        String input;
        do {
            System.out.print("Для продолжения работы нажмите клавишу <Enter>");
            input = sc.nextLine();
        } while (!input.isEmpty());
    }
}

