package com.startjava.lesson_2_3_4.bookcase;

import java.time.Year;
import java.util.Arrays;
import java.util.Scanner;

public class BookcaseTest {
    private static final int DEFAULT_INFO_LENGTH = 15;
    private static final String MAIN_OPTIONS = """
            \t\tКНИЖНЫЙ ШКАФ
            1. Осмотреть
            2. Поиск книги
            3. Добавить
            4. Удалить
            5. Очистить шкаф
            6. Завершить
            Введите пункт меню:\s""";
    private static Scanner sc = new Scanner(System.in);
    private static MenuOptions currentMenuOption;
    private static Bookcase bookcase = new Bookcase(0, new Book[10]);

    public static void main(String[] args) {
        while (true) {
            if (currentMenuOption != MenuOptions.EXIT && isBookcaseEmpty()) {
                System.out.println("Вы можете добавить книгу.");
                currentMenuOption = MenuOptions.ADD;
            }
            switch (currentMenuOption) {
                case VIEW -> {
                    displayBookcaseInfo();
                    displayBookcase();
                }
                case FIND -> {
                    if (!isBookcaseEmpty()) {
                        findByTitle();
                    }
                }
                case ADD -> {
                    if (!isBookcaseFull()) {
                        setNewBook();
                    }
                }
                case DELETE -> {
                    if (!isBookcaseEmpty()) {
                        delete();
                    }
                }
                case DELETE_ALL -> {
                    bookcase.deleteAll();
                    System.out.println("Шкаф очищен.");
                }
                case EXIT -> {
                    sc.close();
                    return;
                }
            }
            pressEnter();
            mainMenu();
        }
    }

    public static void findByTitle() {
        System.out.print("Введите название книги: ");
        String input = sc.nextLine().toLowerCase();
        System.out.println("Результат поиска:");
        Book[] searchResults = bookcase.findByTitle(input);
        Book[] empty = new Book[searchResults.length];
        if (Arrays.equals(searchResults, empty)) {
            System.out.println("Поск не дал результатов.");
        } else {
            for (int i = 0; i < searchResults.length; i++) {
                if (searchResults[i] != null) {
                    System.out.printf("Полка %d: %s\n", i + 1, searchResults[i].toString());
                }
            }
        }
    }

    public static void displayBookcaseInfo() {
        System.out.printf("В шкафу книг: %d. Свободно полок: %d.\n", bookcase.getBooksNumber(),
                bookcase.getBooks().length - bookcase.getBooksNumber());
    }

    public static void displayBookcase() {
        int maxLine = maxInfoLength(bookcase.getBooksNumber());
        for (int i = 0; i < bookcase.getBooks().length; i++) {
            System.out.printf("Полка %02d", (i + 1));
            System.out.println("|" + (bookcase.getBooks()[i] != null ?
                    bookcase.getBooks()[i] + " ".repeat(maxLine - bookcase.getBooks()[i].toString().length()) :
                    "-".repeat(maxLine)) + "|");
        }
    }

    public static int maxInfoLength(int booksNumber) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < booksNumber; ++i) {
            if (bookcase.getBooks()[i].toString().length() > max) {
                max = bookcase.getBooks()[i].toString().length();
            }
        }
        return !isBookcaseEmpty() ? max : DEFAULT_INFO_LENGTH;
    }

    public static boolean isBookcaseEmpty() {
        if (bookcase.getBooksNumber() == 0) {
            System.out.println("Шкаф пуст.");
            return true;
        }
        return false;
    }

    public static boolean isBookcaseFull() {
        if (bookcase.getBooksNumber() == bookcase.getBooks().length) {
            System.out.println("Шкаф полон.");
            return true;
        }
        return false;
    }

    private static void setNewBook() {
        System.out.print("Введите имя автора: ");
        String author = sc.nextLine();
        System.out.print("Введите название книги: ");
        String title = sc.nextLine();
        System.out.print("Введите год выпуска: ");
        int year = validateYear();
        pressEnter();
        bookcase.add(author, title, year);
        System.out.printf("Полка %d. Добавлена книга:%n%s%n", bookcase.getBooksNumber(),
                bookcase.getBooks()[bookcase.getBooksNumber() - 1].toString());
    }

    public static int validateYear() {
        while (true) {
            int input = readInt();
            if (input <= Year.now().getValue()) {
                return input;
            }
            System.out.printf("Ошибка. Год больше текущего: %d.\nПопробуйте снова: ", Year.now().getValue());
        }
    }

    public static int readInt() {
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

    private static void delete() {
        System.out.printf("Занято полок: %d\nВведите номер полки для удаления: ", bookcase.getBooksNumber());
        int shelfNum;
        while (true) {
            shelfNum = readInt();
            if (shelfNum >= 1 && shelfNum <= bookcase.getBooksNumber()) {
                break;
            }
            System.out.print("Неверно указан № полки. Попробуйте снова: ");
        }
        bookcase.delete(shelfNum);
        System.out.printf("Полка %d. Удалена книга:%n%s%n", shelfNum, bookcase.getBooks()[shelfNum - 1].toString());
    }

    private static void mainMenu() {
        do {
            System.out.print(MAIN_OPTIONS);
            int input = readInt();
            currentMenuOption = MenuOptions.getEnumByValue(input);
            if (currentMenuOption == null) {
                System.out.println("Ошибка. Не верно введен пункт меню.");
            }
        } while (currentMenuOption == null);
        pressEnter();
    }

    private static void pressEnter() {
        String input;
        do {
            System.out.print("\nДля продолжения работы нажмите клавишу <Enter>\n");
            input = sc.nextLine();
        } while (!input.isEmpty());
    }
}
