package com.startjava.lesson_2_3_4.guess;

import java.util.Arrays;

public class Player {
    static final int ATTEMPTS_MAX = 10;
    private int attempts;
    private String name;
    private int[] inputNums = new int[ATTEMPTS_MAX];
    private int wins;

    public Player(String name) {
        this.name = name;
    }

    public int getAttempts() {
        return attempts;
    }

    public void setAttempts(int attempts) {
        this.attempts = attempts;
    }

    public String getName() {
        return name;
    }

    public int[] getInputNums() {
        return Arrays.copyOf(inputNums, attempts);
    }

    public void setInputNums(int number, int index) {
        if (number < 1 || number > 100) {
            throw new IllegalArgumentException("Число должно входить в интервал [1, 100].\nПопробуйте еще раз: ");
        }
        this.inputNums[index] = number;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public void cleanInputNums() {
        Arrays.fill(inputNums, 0, attempts, 0);
    }

    @Override
    public String toString() {
        return name;
    }
}