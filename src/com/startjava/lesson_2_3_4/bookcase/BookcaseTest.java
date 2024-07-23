package com.startjava.lesson_2_3_4.bookcase;

import java.time.Year;
import java.util.Scanner;

public class BookcaseTest {
    private static final String MAIN_OPTIONS = """
            \t\tКнижный шкаф.
            1. Осмотреть
            2. Добавить
            3. Удалить
            4. Поиск
            5. Завершить
            Введите пункт меню:\s""";
    private static final String ADD_OPTIONS = """
            1. Добавить книгу
            2. Главное меню
            Введите пункт меню:\s""";
    private static final String DELETE_OPTIONS = """
            1. Удалить книгу
            2. Очистить шкаф
            3. Главное меню
            Введите пункт меню:\s""";
    private static final String INCORRECT_INPUT = "Ошибка. Не верно введен пункт меню.";
    private static final String PRESS_ENTER = "Для продолжения работы нажмите клавишу <Enter>";
    private static boolean isExit = false;
    private static Scanner sc = new Scanner(System.in);
    private static State state = State.ADD;

    private enum State {
        MAIN_MENU, VIEW_BOOKCASE, ADD, ADD_BOOK, DELETE, DELETE_BOOK, CLEAR_BOOKCASE, FIND, EXIT
    }

    public static void main(String[] args) {
        while (!isExit) {
            pressEnter();
            switch (state) {
                case MAIN_MENU -> mainMenu();
                case VIEW_BOOKCASE -> {
                    Bookcase.displayBookcaseInfo();
                    Bookcase.displayBookcase();
                    state = State.MAIN_MENU;
                }
                case ADD -> addMenu();
                case ADD_BOOK -> add();
                case DELETE -> deleteMenu();
                case DELETE_BOOK -> {
                    if (!Bookcase.isEmpty()) {
                        delete();
                    }
                    state = State.MAIN_MENU;
                }
                case CLEAR_BOOKCASE -> {
                    Bookcase.deleteAll();
                    state = State.MAIN_MENU;
                }
                case FIND -> {
                    if (!Bookcase.isEmpty()) {
                        findByTitle();
                    }
                    state = State.MAIN_MENU;
                }
                case EXIT -> {
                    isExit = true;
                    sc.close();
                }
                default -> state = State.MAIN_MENU;
            }
        }
    }

    private static void mainMenu() {
        System.out.print(MAIN_OPTIONS);
        switch (sc.nextLine()) {
            case "1" -> state = State.VIEW_BOOKCASE;
            case "2" -> state = State.ADD;
            case "3" -> state = State.DELETE;
            case "4" -> state = State.FIND;
            case "5" -> state = State.EXIT;
            default -> System.out.println(INCORRECT_INPUT);
        }
    }

    private static void addMenu() {
        Bookcase.displayBookcaseInfo();
        System.out.print(ADD_OPTIONS);
        switch (sc.nextLine()) {
            case "1" -> state = State.ADD_BOOK;
            case "2" -> state = State.MAIN_MENU;
            default -> System.out.println(INCORRECT_INPUT);
        }
    }

    private static void add() {
        if (!Bookcase.isFull()) {
            System.out.print("Введите имя автора: ");
            String author = sc.nextLine();
            System.out.print("Введите название книги: ");
            String title = sc.nextLine();
            System.out.print("Введите год выпуска: ");
            while (true) {
                int year = readInt();
                if (year <= Year.now().getValue()) {
                    Bookcase.add(author, title, year);
                    break;
                }
                System.out.printf("Ошибка. Год больше текущего: %d.\nПопробуйте снова: ", Year.now().getValue());
            }
        }
        state = State.MAIN_MENU;
    }

    public static int readInt() {
        while (true) {
            String input = sc.nextLine();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.print("Ошибка. Попробуйте снова: ");
            }
        }
    }

    private static void deleteMenu() {
        Bookcase.displayBookcaseInfo();
        System.out.print(DELETE_OPTIONS);
        switch (sc.nextLine()) {
            case "1" -> state = State.DELETE_BOOK;
            case "2" -> state = State.CLEAR_BOOKCASE;
            case "3" -> state = State.MAIN_MENU;
            default -> System.out.println(INCORRECT_INPUT);
        }
    }

    private static void delete() {
        System.out.print("Введите номер полки: ");
        int shelf;
        while (true) {
            shelf = BookcaseTest.readInt();
            if (shelf >= 1 && shelf <= Bookcase.booksNumber) {
                break;
            }
            System.out.printf("Неверно указан № полки. Занято полок: %d\nПопробуйте снова: ", Bookcase.booksNumber);
        }
        Bookcase.delete(shelf);
    }

    private static void findByTitle() {
        System.out.print("Введите название книги: ");
        String input = sc.nextLine().toLowerCase();
        System.out.println("Подходящие варианты:");
        Bookcase.findByTitle(input);
    }

    private static void pressEnter() {
        String input;
        do {
            System.out.print(PRESS_ENTER);
            input = sc.nextLine();
        } while (!input.isEmpty());
    }
}
