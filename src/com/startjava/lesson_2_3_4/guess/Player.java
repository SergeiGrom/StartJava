package com.startjava.lesson_2_3_4.guess;

import java.util.Arrays;

public class Player {
    static final int ATTEMPTS_MAX = 10;
    private int attempts = 0;
    private String name;
    private int[] inputNums = new int[ATTEMPTS_MAX];
    private int inputNum;
    private int wins = 0;

    public int getAttempts() {
        return attempts;
    }

    public void setAttempts(int attempts) {
        this.attempts = attempts;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInputNums() {
        int[] copyInputNums = Arrays.copyOf(inputNums, attempts);
        return Arrays.toString(copyInputNums).replaceAll("[\\[\\]]", "");
    }

    public void setInputNums(int number, int index) {
        this.inputNums[index] = number;
    }

    public int getInputNum() {
        return inputNum;
    }

    public void setInputNum(int inputNum) throws RuntimeException {
        if (inputNum < 1 || inputNum > 100) {
            throw new IllegalArgumentException("Число должно входить в интервал [1, 100].\nПопробуйте еще раз: ");
        }
        this.inputNum = inputNum;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public void cleanInputNums() {
        Arrays.fill(inputNums, 0);
    }

    @Override
    public String toString() {
        return name;
    }
}