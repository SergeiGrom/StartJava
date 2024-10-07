package com.startjava.lesson_2_3_4.bookcase;

import java.time.Year;
import java.util.Scanner;

public class BookcaseTest {
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
    private static MenuOptions currentOption;

    private enum MenuOptions {
        VIEW(1), FIND(2), ADD(3), DELETE(4), DELETE_ALL(5), EXIT(6);
        private int optionNumber;

        MenuOptions(int optionNumber) {
            this.optionNumber = optionNumber;
        }

        public int getOptionNumber() {
            return optionNumber;
        }

        private static MenuOptions getEnumByValue(int input) {
            MenuOptions[] menuOptions = values();
            for (MenuOptions option : menuOptions) {
                if (option.getOptionNumber() == input) {
                    return option;
                }
            }
            return null;
        }
    }

    public static void main(String[] args) {
        while (true) {
            if (currentOption != MenuOptions.EXIT && Bookcase.isEmpty()) {
                System.out.println("Вы можете добавить книгу.");
                currentOption = MenuOptions.ADD;
            }
            switch (currentOption) {
                case VIEW -> {
                    Bookcase.displayBookcaseInfo();
                    Bookcase.displayBookcase();
                }
                case FIND -> {
                    if (!Bookcase.isEmpty()) {
                        Bookcase.findByTitle(sc);
                    }
                }
                case ADD -> {
                    if (!Bookcase.isFull()) {
                        setNewBook();
                    }
                }
                case DELETE -> {
                    if (!Bookcase.isEmpty()) {
                        delete();
                    }
                }
                case DELETE_ALL -> Bookcase.deleteAll();
                case EXIT -> {
                    sc.close();
                    return;
                }
                default -> mainMenu();
            }
            pressEnter();
            mainMenu();
        }
    }

    private static void mainMenu() {
        do {
            System.out.print(MAIN_OPTIONS);
            int input = readInt();
            currentOption = MenuOptions.getEnumByValue(input);
            if (currentOption == null) {
                System.out.println("Ошибка. Не верно введен пункт меню.");
            }
        } while (currentOption == null);
        pressEnter();
    }

    private static void setNewBook() {
        System.out.print("Введите имя автора: ");
        String author = sc.nextLine();
        System.out.print("Введите название книги: ");
        String title = sc.nextLine();
        System.out.print("Введите год выпуска: ");
        int year = validateYear();
        pressEnter();
        Bookcase.add(author, title, year);
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
        System.out.printf("Занято полок: %d\nВведите номер полки для удаления: ", Bookcase.booksNumber);
        int shelfNum;
        while (true) {
            shelfNum = readInt();
            if (shelfNum >= 1 && shelfNum <= Bookcase.booksNumber) {
                break;
            }
            System.out.print("Неверно указан № полки. Попробуйте снова: ");
        }
        Bookcase.delete(shelfNum);
    }

    private static void pressEnter() {
        String input;
        do {
            System.out.print("\nДля продолжения работы нажмите клавишу <Enter>\n");
            input = sc.nextLine();
        } while (!input.isEmpty());
    }
}
