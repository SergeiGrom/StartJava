package com.startjava.lesson_2_3_4.bookcase;

import java.time.Year;
import java.util.Scanner;

public class BookcaseTest {
    private static final String MENU = """
            \t\tКНИЖНЫЙ ШКАФ
            1. Осмотреть
            2. Поиск книги
            3. Добавить
            4. Удалить
            5. Очистить шкаф
            6. Завершить
            Введите пункт меню:\s""";
    private static Scanner sc = new Scanner(System.in);
    private static MenuItems menuItem;
    private static Bookcase bookcase = new Bookcase();

    public static void main(String[] args) {
        while (menuItem != MenuItems.EXIT) {
            checkMenuItem();
            pressEnter();
            selectMenuItem();
        }
        sc.close();
    }

    private static void checkMenuItem() {
        if (bookcase.isEmpty()) {
            System.out.println("Шкаф пуст. Вы можете добавить книгу.");
            menuItem = MenuItems.ADD;
        }
        switch (menuItem) {
            case VIEW -> {
                displayBookcaseInfo();
                displayBookcase();
            }
            case FIND, DELETE -> {
                if (!bookcase.isEmpty()) {
                    findDelete();
                }
            }
            case ADD -> {
                if (!bookcase.isFull()) {
                    addBook();
                } else {
                    System.out.println("Шкаф полон. Вы не можете добавить еще книги.");
                }
            }
            case DELETE_ALL -> {
                bookcase.clear();
                System.out.println("Шкаф очищен.");
            }
        }
    }

    private static void displayBookcaseInfo() {
        System.out.printf("В шкафу книг: %d. Свободно полок: %d.\n", bookcase.getBooksNumber(), bookcase.emptyShelves());
    }

    private static void displayBookcase() {
        int shelfNum = 1;
        for (Book book : bookcase.getBooks()) {
            System.out.printf("Полка %02d", shelfNum);
            System.out.println("|" + book +
                               " ".repeat(bookcase.getMaxShelvesLen() - book.toString().length()) + "|");
            shelfNum += 1;
        }
    }

    private static void findDelete() {
        System.out.print("Введите название книги: ");
        String inputTitle = sc.nextLine();
        Book[] foundBooks = bookcase.find(inputTitle);
        System.out.println("Результат поиска:");
        if (foundBooks.length != 0) {
            for (Book book : foundBooks) {
                System.out.println(book);
            }
            if (menuItem == MenuItems.DELETE) {
                bookcase.delete(inputTitle);
                System.out.println("Книги удалены!");
            }
        } else {
            System.out.println("Поиск не дал результатов.");
        }
    }

    private static void addBook() {
        System.out.print("Введите имя автора: ");
        String author = sc.nextLine();
        System.out.print("Введите название книги: ");
        String title = sc.nextLine();
        System.out.print("Введите год выпуска: ");
        int year = inputYear();
        Book book = new Book(author, title, year);
        bookcase.add(book);
        System.out.printf("\nПолка %d. Добавлена книга:%n%s%n",
                bookcase.getBooksNumber(), book);
    }

    private static int inputYear() {
        while (true) {
            int userYear = input();
            if (userYear <= Year.now().getValue()) {
                return userYear;
            }
            System.out.printf("Ошибка. Год больше текущего: %d.\nПопробуйте снова: ", Year.now().getValue());
        }
    }

    private static int input() {
        int input;
        while (true) {
            try {
                input = Integer.parseInt(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.print("Ошибка. Введите целое число. Попробуйте снова: ");
            }
        }
        return input;
    }

    private static void pressEnter() {
        String input;
        do {
            System.out.print("\nДля продолжения работы нажмите клавишу <Enter>\n");
            input = sc.nextLine();
        } while (!input.isEmpty());
    }

    private static void selectMenuItem() {
        do {
            System.out.print(MENU);
            int input = input();
            menuItem = MenuItems.getEnumByValue(input);
            if (menuItem == null) {
                System.out.println("Ошибка. Не верно введен пункт меню.");
            }
            System.out.println();
        } while (menuItem == null);
    }
}
