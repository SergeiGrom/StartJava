package com.startjava.lesson_2_3_4.guess;

import java.util.Scanner;

public class GuessNumberTest {
    private static final String YES = "yes";
    private static final String NO = "no";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("\n\t\tИгра \"Угадай число\" (от 1 до %d).\n", GuessNumber.MAX_RANGE);
        GuessNumber game = new GuessNumber(inputNames(scanner));
        String answer = YES;
        do {
            if (answer.equals(YES)) {
                game.start();
                System.out.print("\nХотите продолжить игру? [yes/no]: ");
            } else {
                System.out.print("Введите корректный ответ [yes/no]: ");
            }
            answer = scanner.nextLine();
        } while (!answer.equals(NO));
        scanner.close();
    }

    private static String[] inputNames(Scanner scanner) {
        String[] names = new String[GuessNumber.PLAYERS];
        for (int i = 0; i < names.length; i++) {
            while (true) {
                System.out.printf("Введите имя %d игрока : ", i + 1);
                String input = scanner.nextLine();
                if (!input.isBlank()) {
                    names[i] = input;
                    break;
                }
                System.out.println("Ошибка. Имя не должно быть пустым.");
            }
        }
        return names;
    }
}
