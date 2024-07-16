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
            int j = 0;
            boolean hasWinner = false;
            while (!hasWinner) {
                if (j == Player.ATTEMPT_MAX) {
                    System.out.printf("\nУ игрока %s закончились попытки.\n", players[0].getName());
                    break;
                }
                for (Player player : players) {
                    System.out.printf("Ходит %s.\nВведите число: ", player.getName());
                    inputNumber(player, j);
                    int attempt = player.getAttempt();
                    player.setAttempt(++attempt);
                    if (checkNumber(player, hiddenNum, j)) {
                        int wins = player.getWins();
                        player.setWins(++wins);
                        hasWinner = true;
                        break;
                    }
                }
                j++;
            }
            displayNumbers(players);
            setDefault(players);
        }
        findWinner(players);
        setWinsDefault(players);
    }

    public void shufflePlayers(Player[] players) {
        Random rand = new Random();
        Player swap;
        for (int i = players.length - 1; i >= 1; i--) {
            int j = rand.nextInt(i);
            swap = players[i];
            players[i] = players[j];
            players[j] = swap;
        }
    }

    public void inputNumber(Player player, int index) {
        while (true) {
            try {
                player.setInputNum(scanner.nextInt(), index);
                scanner.nextLine();
                break;
            } catch (RuntimeException e) {
                System.out.print(e.getMessage());
            }
        }
    }

    public boolean checkNumber(Player player, int hiddenNum, int index) {
        if (player.getInputNums()[index] == hiddenNum) {
            System.out.printf("\nПОБЕДИЛ %s c %d-й попытки.\n", player.getName(), (index + 1));
            return true;
        }
        System.out.printf("\nЧисло %d %s того, что загадал компьютер.\n", player.getInputNums()[index],
                player.getInputNums()[index] > hiddenNum ? "больше" : "меньше");
        return false;
    }

    public void displayNumbers(Player[] players) {
        for (Player player : players) {
            System.out.printf("%s ввел: %s\n", player.getName(),
                    Arrays.toString(player.getInputNums()).replaceAll("[\\[\\]]", ""));
        }
    }

    public void setDefault(Player[] players) {
        for (Player player : players) {
            player.cleanInputNums();
            player.setAttempt(0);
        }
    }

    public void findWinner(Player[] players) {
        Arrays.sort(players, Comparator.comparing(Player::getWins).reversed());
        String result = "";
        if (players[0].getWins() > players[1].getWins()) {
            result = "победил " + players[0].getName();
        }
        StringBuilder winners = new StringBuilder();
        for (Player player : players) {
            if (players[0].getWins() == player.getWins()) {
                winners.append(player.getName()).append(" ");
                result = "ничья между " + winners;
            }
        }
        System.out.println("\nПо результатам " + ROUNDS + " раундов " + result + ".");
    }

    public void setWinsDefault(Player[] players) {
        for (Player player : players) {
            player.setWins(0);
        }
    }
}
