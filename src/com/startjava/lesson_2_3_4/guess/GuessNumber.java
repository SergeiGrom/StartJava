package com.startjava.lesson_2_3_4.guess;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
    static final int ROUNDS = 3;
    static final int MAX_RANGE = 100;
    Scanner scanner = new Scanner(System.in);
    Player[] players;

    public GuessNumber(String name1, String name2, String name3) {
        Player player1 = new Player(name1);
        Player player2 = new Player(name2);
        Player player3 = new Player(name3);
        this.players = new Player[]{player1, player2, player3};
    }

    public void start() {
        System.out.printf("\t\tИгра началась!\nУ каждого игрока по %d попыток.\n", Player.ATTEMPTS_MAX);
        setTurnsOrder(players);
        System.out.printf("Очередность хода: %s.\n",
                Arrays.toString(players).replaceAll("[\\[\\]]", ""));
        for (int i = 1; i <= ROUNDS; i++) {
            int hiddenNum = 1 + (int) (Math.random() * MAX_RANGE);
            System.out.println("\t\tРАУНД " + i);
            int j = 0;
            boolean hasWinner = false;
            while (!hasWinner) {
                if (j == Player.ATTEMPTS_MAX) {
                    System.out.printf("\nУ игрока %s закончились попытки.\n", players[0].getName());
                    break;
                }
                for (Player player : players) {
                    System.out.printf("Ходит %s.\nВведите число: ", player.getName());
                    inputNumber(player, j);
                    int attempts = player.getAttempts();
                    player.setAttempts(++attempts);
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

    public void setTurnsOrder(Player[] players) {
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
                player.setInputNums(scanner.nextInt(), index);
                scanner.nextLine();
                break;
            } catch (RuntimeException e) {
                System.out.print(e.getMessage());
            }
        }
    }

    public boolean checkNumber(Player player, int hiddenNum, int index) {
        int[] copyInputNums = player.getInputNums();
        if (copyInputNums[index] == hiddenNum) {
            System.out.printf("\nПОБЕДИЛ %s c %d-й попытки.\n", player.getName(), (index + 1));
            return true;
        }
        System.out.printf("\nЧисло %d %s того, что загадал компьютер.\n", copyInputNums[index],
                copyInputNums[index] > hiddenNum ? "больше" : "меньше");
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
            player.setAttempts(0);
        }
    }

    public void findWinner(Player[] players) {
        int maxScore = findMax(players);
        StringBuilder winners = new StringBuilder();
        for (Player player : players) {
            if (player.getWins() == maxScore) {
                winners.append(player.getName()).append(" ");
            }
        }
        String result;
        if (winners.toString().trim().split("\\s").length == 1) {
            result = "победил " + winners;
        } else if (winners.toString().trim().split("\\s").length == players.length) {
            result = "ничья";
        } else {
            result = "ничья между " + winners;
        }
        System.out.println("\nПо результатам " + ROUNDS + " раундов " + result + ".");
    }

    public int findMax(Player[] players) {
        int max = Integer.MIN_VALUE;
        for (Player player : players) {
            if (player.getWins() > max) {
                max = player.getWins();
            }
        }
        return max;
    }

    public void setWinsDefault(Player[] players) {
        for (Player player : players) {
            player.setWins(0);
        }
    }
}
