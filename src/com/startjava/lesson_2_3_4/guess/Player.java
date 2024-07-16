package com.startjava.lesson_2_3_4.guess;

import java.util.Arrays;

public class Player {
    static final int ATTEMPT_MAX = 10;
    private int attempt;
    private String name;
    private int[] inputNums = new int[ATTEMPT_MAX];
    private int wins;

    public Player(String name) {
        this.name = name;
    }

    public int getAttempt() {
        return attempt;
    }

    public void setAttempt(int attempt) {
        this.attempt = attempt;
    }

    public String getName() {
        return name;
    }

    public int[] getInputNums() {
        return Arrays.copyOf(inputNums, attempt);
    }

    public void setInputNum(int number, int index) {
        if (number < GuessNumber.MIN_RANGE || number > GuessNumber.MAX_RANGE) {
            throw new IllegalArgumentException("Число должно входить в интервал [1, 100].\nПопробуйте еще раз: ");
        }
        inputNums[index] = number;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public void cleanInputNums() {
        Arrays.fill(inputNums, 0, attempt, 0);
    }

    @Override
    public String toString() {
        return name;
    }
}