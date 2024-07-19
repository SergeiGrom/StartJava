package com.startjava.lesson_2_3_4.guess;

import java.util.Arrays;

public class Player {
    static final int ATTEMPTS_MAX = 10;
    private int attempt;
    private String name;
    private int[] inputNums = new int[ATTEMPTS_MAX];
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

    public void setInputNum(int input) {
        if (input < GuessNumber.MIN_RANGE || input > GuessNumber.MAX_RANGE) {
            throw new IllegalArgumentException("Число должно входить в интервал от " +
                                               GuessNumber.MIN_RANGE + " до " + GuessNumber.MAX_RANGE + ".\nПопробуйте еще раз: ");
        }
        inputNums[attempt] = input;
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

    public int getLastNum() {
        return inputNums[attempt - 1];
    }

    @Override
    public String toString() {
        return name;
    }
}