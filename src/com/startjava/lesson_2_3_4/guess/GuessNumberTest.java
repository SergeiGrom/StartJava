package com.startjava.lesson_2_3_4.guess;

import java.util.Scanner;

public class GuessNumberTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n\t\tИгра \"Угадай число\" от (0 до 100].");
        System.out.print("Введите имя 1 игрока : ");
        String name1 = scanner.nextLine();
        System.out.print("Введите имя 2 игрока : ");
        String name2 = scanner.nextLine();
        System.out.print("Введите имя 3 игрока : ");
        String name3 = scanner.nextLine();
        GuessNumber game = new GuessNumber(name1, name2, name3);
        boolean isExit = false;
        while (!isExit) {
            System.out.printf("Игра началась! У каждого игрока по %d попыток.\n", Player.ATTEMPTS_MAX);
            game.setTurnsOrder(game.players);
            for (int i = 1; i <= GuessNumber.ROUNDS; i++) {
                System.out.println("\n\t\tРАУНД " + i);
                game.start();
                game.displayNumbers(game.players);
                game.clean(game.players);
            }
            game.findWinner(game.players);
            game.setWinsDefault(game.players);
            System.out.print("\nХотите продолжить игру? [yes/no]: ");
            while (true) {
                try {
                    isExit = exit(scanner);
                    break;
                } catch (Exception e) {
                    System.out.print(e.getMessage());
                }
            }
            System.out.println();
        }
        scanner.close();
    }

    public static boolean exit(Scanner scanner) throws RuntimeException {
        String answer = scanner.nextLine().toLowerCase();
        return switch (answer) {
            case "yes" -> false;
            case "no" -> true;
            default -> throw new IllegalStateException("Введите корректный ответ [yes / no]: ");
        };
    }
}
