package com.startjava.lesson_2_3_4.bookcase;

import java.util.Scanner;

public class Control {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ConsoleUi ui = new ConsoleUi();
        String displayScreen = "empty";
        do {
            displayScreen = switch (displayScreen) {
                case "empty": {
                    System.out.printf("%13s%n", ui.emptyBookcase);
                    System.out.print(ui.addBook);
                    yield empty(sc, ui);
                }
                case "menu": {
                    System.out.println(ui.separator);
                    System.out.print(ui.mainMenu);
                    yield menu(sc, ui);
                }
                case "inspect": {
                    System.out.println(ui.separator);
                    Bookcase.display(ui);
                    confirm(sc, ui);
                    yield "menu";
                }
                case "add": {
                    System.out.println(ui.separator);
                    Bookcase.add(sc, ui);
                    confirm(sc, ui);
                    yield "menu";
                }
                case "delete":
                    System.out.println(ui.separator);
                    if (Bookcase.booksNumber == 0) yield "empty";
                    System.out.print(ui.deleteBook);
                    delete(sc, ui);
                    confirm(sc, ui);
                    yield "menu";
                case "search":
                    System.out.println(ui.separator);
                    if (Bookcase.booksNumber == 0) yield "empty";
                    Bookcase.findByTitle(sc, ui);
                    confirm(sc, ui);
                    yield "menu";
                default:
                    throw new IllegalStateException("Unexpected value: " + displayScreen);
            };
        } while (!displayScreen.equals("end"));
    }

    private static String empty(Scanner sc, ConsoleUi ui) {
        String input;
        do {
            System.out.print(ui.chooseOptions);
            input = sc.nextLine();
            if (input.equals("1")) return "add";
        } while (!input.equals("2"));
        return "menu";
    }

    private static String menu(Scanner sc, ConsoleUi ui) {
        String input;
        do {
            System.out.print(ui.chooseOptions);
            input = sc.nextLine();
            if (input.equals("1")) return "inspect";
            if (input.equals("2")) return "add";
            if (input.equals("3")) return "delete";
            if (input.equals("4")) return "search";
        } while (!input.equals("5"));
        return "end";
    }

    private static void confirm(Scanner sc, ConsoleUi ui) {
        System.out.println(ui.separator);
        String input;
        do {
            System.out.print(ui.pressEnter);
            input = sc.nextLine();
        } while (!input.isEmpty());
    }

    private static void delete(Scanner sc, ConsoleUi ui) {
        String input;
        do {
            System.out.print(ui.chooseOptions);
            input = sc.nextLine();
            if (input.equals("1")) {
                Bookcase.delete(sc, ui);
                return;
            }
            if (input.equals("2")) {
                Bookcase.clearAll(ui);
                return;
            }
        } while (!input.equals("3"));
    }
}

