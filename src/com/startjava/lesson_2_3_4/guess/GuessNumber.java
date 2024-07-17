package com.startjava.lesson_2_3_4.guess;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
    private static final int ROUNDS = 3;
    static final int PLAYERS = 3;
    static final int MAX_RANGE = 100;
    static final int MIN_RANGE = 1;
    private Scanner scanner = new Scanner(System.in);
    private Player[] players = new Player[PLAYERS];

    public GuessNumber(String... name) {
        for (int i = 0; i < PLAYERS; i++) {
            players[i] = new Player(name[i]);
        }
    }

    public void start() {
        System.out.printf("\t\tИгра началась!\nУ каждого игрока по %d попыток.\n", Player.ATTEMPT_MAX);
        shufflePlayers(players);
        System.out.printf("Очередность хода: %s.\n",
                Arrays.toString(players).replaceAll("[\\[\\]]", ""));
        for (int i = 1; i <= ROUNDS; i++) {
            int hiddenNum = MIN_RANGE + (int) (Math.random() * MAX_RANGE);
            System.out.println("\t\tРАУНД " + i);
            boolean hasWinner = false;
            while (!hasWinner) {
                if (players[0].getAttempt() == Player.ATTEMPT_MAX) {
                    System.out.printf("\nУ игрока %s закончились попытки.\n", players[0].getName());
                    break;
                }
                for (Player player : players) {
                    System.out.printf("Ходит %s.\nВведите число: ", player.getName());
                    inputNumber(player);
                    if (checkNumber(player, hiddenNum)) {
                        hasWinner = true;
                        break;
                    }
                }
            }
            displayNumbers(players);
            setDefault(players);
        }
        findWinner(players);
        setWinsDefault(players);
    }

    private void shufflePlayers(Player[] players) {
        Random rand = new Random();
        for (int i = players.length - 1; i >= 1; i--) {
            int j = rand.nextInt(i);
            Player swap = players[i];
            players[i] = players[j];
            players[j] = swap;
        }
    }

    private void inputNumber(Player player) {
        while (true) {
            try {
                int input = Integer.parseInt(scanner.nextLine());
                player.setInputNum(input);
                int attempt = player.getAttempt();
                player.setAttempt(++attempt);
                break;
            } catch (NumberFormatException e) {
                System.out.print("Введено не целое число.\nПопробуйте еще раз: ");
            } catch (IllegalArgumentException e) {
                System.out.print(e.getMessage());
            }
        }
    }

    private boolean checkNumber(Player player, int hiddenNum) {
        if (player.getLastInput() == hiddenNum) {
            int wins = player.getWins();
            player.setWins(++wins);
            System.out.printf("\nПОБЕДИЛ %s c %d-й попытки.\n", player.getName(), player.getAttempt());
            return true;
        }
        System.out.printf("\nЧисло %d %s того, что загадал компьютер.\n", player.getLastInput(),
                player.getLastInput() > hiddenNum ? "больше" : "меньше");
        return false;
    }

    private void displayNumbers(Player[] players) {
        for (Player player : players) {
            System.out.printf("%s ввел: %s\n", player.getName(),
                    Arrays.toString(player.getInputNums()).replaceAll("[\\[\\]]", ""));
        }
    }

    private void setDefault(Player[] players) {
        for (Player player : players) {
            player.cleanInputNums();
            player.setAttempt(0);
        }
    }

    private void findWinner(Player[] players) {
        Arrays.sort(players, Comparator.comparing(Player::getWins).reversed());
        String result = "";
        if (players[0].getWins() > players[1].getWins()) {
            result = "победил " + players[0].getName();
        }
        StringBuilder winners = new StringBuilder();
        for (Player player : players) {
            if (players[0].getWins() == player.getWins()) {
                winners.append(player.getName()).append(" ");
                result = "ничья между: " + winners;
            }
        }
        System.out.printf("\nПо результатам %d раундов %s.", ROUNDS, result.trim());
    }

    private void setWinsDefault(Player[] players) {
        for (Player player : players) {
            player.setWins(0);
        }
    }
}
