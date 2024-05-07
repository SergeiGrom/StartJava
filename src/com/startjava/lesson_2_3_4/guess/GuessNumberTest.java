package com.startjava.lesson_2_3_4.guess;

import java.util.Scanner;

public class GuessNumberTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nИгра Угадай число от (0 до 100]:");
        System.out.print("Введите имя 1 игрока : ");
        Player player1 = new Player(scanner.nextLine());
        System.out.print("Введите имя 2 игрока : ");
        Player player2 = new Player(scanner.nextLine());
        GuessNumber game = new GuessNumber(player1, player2);
        String exitGame;
        do {
            game.start();
            do {
                System.out.print("\nХотите продолжить игру? [yes/no]: ");
                exitGame = scanner.nextLine();
            } while (!exitGame.equals("no") && !exitGame.equals("yes"));
        } while (!exitGame.equals("no"));
        scanner.close();
    }
}
