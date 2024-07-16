package com.startjava.lesson_2_3_4.guess;

import java.util.Scanner;

public class GuessNumberTest {
    private static final String YES = "yes";
    private static final String NO = "no";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("\n\t\tИгра \"Угадай число\" (от 1 до %d).\n", GuessNumber.MAX_RANGE);
        GuessNumber game = new GuessNumber(inputName(scanner));
        String answer = YES;
        do {
            if (isEquals(answer, YES)) {
                game.start();
                System.out.print("\nХотите продолжить игру? [yes/no]: ");
            } else {
                System.out.print("Введите корректный ответ [yes/no]: ");
            }
            answer = scanner.nextLine();
        } while (!isEquals(answer, NO));
        scanner.close();
    }

    private static String[] inputName(Scanner scanner) {
        String[] names = new String[GuessNumber.PLAYERS];
        for (int i = 0; i < names.length; i++) {
            while (true) {
                System.out.print("Введите имя игрока : ");
                names[i] = scanner.nextLine();
                if (!names[i].isBlank()) {
                    break;
                }
                System.out.println("Ошибка. Имя не должно быть пустым.");
            }
        }
        return names;
    }

    private static boolean isEquals(String answer, String flag) {
        return flag.equals(answer);
    }
}
