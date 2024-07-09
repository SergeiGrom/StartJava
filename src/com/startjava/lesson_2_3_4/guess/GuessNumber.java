package com.startjava.lesson_2_3_4.guess;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
    static final int ROUNDS = 3;
    Scanner scanner = new Scanner(System.in);
    Player player1 = new Player();
    Player player2 = new Player();
    Player player3 = new Player();
    Player[] players = {player1, player2, player3};

    public GuessNumber(String name1, String name2, String name3) {
        this.player1.setName(name1);
        this.player2.setName(name2);
        this.player3.setName(name3);
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
        System.out.printf("Жребий брошен! Очередность хода: %s.\n",
                Arrays.toString(players).replaceAll("[\\[\\]]", ""));
    }

    public void start() {
        int hiddenNum = 1 + (int) (Math.random() * 100);
        System.out.println("*HIDDEN* " + hiddenNum);
        for (int i = 0; true; i++) {
            if (i == Player.ATTEMPTS_MAX) {
                System.out.printf("\nУ игрока %s закончились попытки.\n", players[0].getName());
                return;
            }
            for (Player player : players) {
                inputNumber(player, i);
                int attempts = player.getAttempts();
                player.setAttempts(++attempts);
                if (checkNumber(player, hiddenNum, i)) {
                    int wins = player.getWins();
                    player.setWins(++wins);
                    return;
                }
            }
        }
    }

    public void inputNumber(Player player, int index) {
        System.out.printf("Ходит %s.\nВведите число: ", player.getName());
        while (true) {
            try {
                player.setInputNum(scanner.nextInt());
                scanner.nextLine();
                break;
            } catch (Exception e) {
                System.out.print(e.getMessage());
            }
        }
        player.setInputNums(player.getInputNum(), index);
    }

    public boolean checkNumber(Player player, int hiddenNum, int attempts) {
        if (player.getInputNum() == hiddenNum) {
            System.out.printf("\nПОБЕДИЛ %s c %d-й попытки.\n", player.getName(), (attempts + 1));
            return true;
        }
        System.out.printf("\nЧисло %d %s того, что загадал компьютер.\n", player.getInputNum(),
                player.getInputNum() > hiddenNum ? "больше" : "меньше");
        return false;
    }

    public void displayNumbers(Player[] players) {
        for (Player player : players) {
            System.out.printf("%s ввел: %s\n", player.getName(), player.getInputNums());
        }
    }

    public void setDefault(Player[] players) {
        for (Player player : players) {
            player.cleanInputNums();
            player.setAttempts(0);
        }
    }

    public void findWinner(Player[] players) {
        String end;
        if (players[0].getWins() == players[1].getWins() && players[1].getWins() == players[2].getWins()) {
            end = "ничья!";
        } else if (players[0].getWins() == players[1].getWins() && players[0].getWins() != 0) {
            end = "ничья между " + player1.getName() + " и " + player2.getName();
        } else if (players[0].getWins() == players[2].getWins() && players[0].getWins() != 0) {
            end = "ничья между " + player1.getName() + " и " + player3.getName();
        } else if (players[1].getWins() == players[2].getWins() && players[1].getWins() != 0) {
            end = "ничья между " + player2.getName() + " и " + player3.getName();
        } else {
            int winner = 0;
            int wins = 0;
            for (int i = 0; i < players.length; i++) {
                if (players[i].getWins() > wins) {
                    winner = i;
                }
            }
            end = "победил " + players[winner];
        }
        System.out.println("\nПо результатам " + ROUNDS + " раундов " + end);
    }

    public void setWinsDefault(Player[] players) {
        for (Player player : players) {
            player.setWins(0);
        }
    }
}
