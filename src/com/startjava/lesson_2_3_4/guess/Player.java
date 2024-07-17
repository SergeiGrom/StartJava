package com.startjava.lesson_2_3_4.guess;

import java.util.Arrays;

public class Player {
    static final int ATTEMPT_MAX = 3;
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

    public void setInputNum(int number) {
        if (number < GuessNumber.MIN_RANGE || number > GuessNumber.MAX_RANGE) {
            throw new IllegalArgumentException("Число должно входить в интервал [" + GuessNumber.MIN_RANGE +
                                               ", " + GuessNumber.MAX_RANGE + "].\nПопробуйте еще раз: ");
        }
        inputNums[attempt] = number;
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

    public int lastInputNum() {
        return inputNums[attempt - 1];
    }

    @Override
    public String toString() {
        return name;
    }
}