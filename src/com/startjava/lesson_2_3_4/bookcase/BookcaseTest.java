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
    private static Bookcase bookcase = new Bookcase(0);

    public static void main(String[] args) {
        while (menuItem != MenuItems.EXIT) {
            if (bookcase.isEmpty()) {
                System.out.println("Шкаф пуст. Вы можете добавить книгу.");
                menuItem = MenuItems.ADD;
            }
            menu(menuItem);
            pressEnter();
            selectMenuItem();
        }
        sc.close();
    }

    private static void menu(MenuItems menuItem) {
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
                }
            }
            case DELETE_ALL -> {
                bookcase.clear();
                System.out.println("Шкаф очищен.");
            }
        }
    }

    private static void findDelete() {
        System.out.print("Введите название книги: ");
        String inputTitle = sc.nextLine();
        Book[] foundBooks = bookcase.find(inputTitle);
        System.out.println("Результат поиска:");
        if (foundBooks.length != 0) {
            for (Book book : foundBooks) {
                System.out.println(book.toString());
            }
            if (menuItem == MenuItems.DELETE) {
                bookcase.delete(inputTitle);
                System.out.println("Книги удалены!");
            }
        } else {
            System.out.println("Поиск не дал результатов.");
        }
    }

    private static void displayBookcaseInfo() {
        System.out.printf("В шкафу книг: %d. Свободно полок: %d.\n", bookcase.getBooksNumber(),
                bookcase.emptyShelves());
    }

    private static void displayBookcase() {
        int maxLine = bookcase.maxInfoLength();
        for (int i = 0; i < bookcase.getBooks().length; i++) {
            System.out.printf("Полка %02d", (i + 1));
            System.out.println("|" + (bookcase.getBooks()[i] != null ?
                    bookcase.getBooks()[i] + " ".repeat(maxLine - bookcase.getBooks()[i].toString().length()) :
                    "-".repeat(maxLine)) + "|");
        }
    }

    private static void addBook() {
        System.out.print("Введите имя автора: ");
        String author = sc.nextLine();
        System.out.print("Введите название книги: ");
        String title = sc.nextLine();
        System.out.print("Введите год выпуска: ");
        int year = validateYear();
        Book book = new Book(author, title, year);
        bookcase.add(book);
        System.out.printf("\nПолка %d. Добавлена книга:%n%s%n", bookcase.getBooksNumber(),
                book);
    }

    private static int validateYear() {
        while (true) {
            int input = readInt();
            if (input <= Year.now().getValue()) {
                return input;
            }
            System.out.printf("Ошибка. Год больше текущего: %d.\nПопробуйте снова: ", Year.now().getValue());
        }
    }

    private static int readInt() {
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

    private static void selectMenuItem() {
        do {
            System.out.print(MENU);
            int input = readInt();
            menuItem = MenuItems.getEnumByValue(input);
            if (menuItem == null) {
                System.out.println("Ошибка. Не верно введен пункт меню.");
            }
            System.out.println();
        } while (menuItem == null);
    }

    private static void pressEnter() {
        String input;
        do {
            System.out.print("\nДля продолжения работы нажмите клавишу <Enter>\n");
            input = sc.nextLine();
        } while (!input.isEmpty());
    }
}
