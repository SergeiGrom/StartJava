package com.startjava.lesson_2_3_4.calculator;

public class Calculator {
    static int inputA;
    static int inputB;
    static String sign;
    static final int ARR_LENGTH = 3;

    public static double calculate(String input) throws RuntimeException {
        String[] calcMembers = input.trim().split(" +");
        if (calcMembers.length != ARR_LENGTH) {
            throw new RuntimeException("Ошибка! Введите в формате [A + B].");
        }
        try {
            inputA = Integer.parseInt(calcMembers[0]);
            inputB = Integer.parseInt(calcMembers[2]);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Ошибка! Введите целые числа.");
        }
        sign = calcMembers[1];
        return switch (sign) {
            case "+" -> inputA + inputB;
            case "-" -> inputA - inputB;
            case "*" -> inputA * inputB;
            case "/" -> (double) inputA / inputB;
            case "^" -> Math.pow(inputA, inputB);
            case "%" -> Math.floorMod(inputA, inputB);
            default -> throw new IllegalStateException("Ошибка! Используйте только операции [- + * / % ^]");
        };
    }
}

