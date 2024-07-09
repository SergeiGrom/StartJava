package com.startjava.lesson_2_3_4.calculator;

public class Calculator {
    private static int arg1;
    private static int arg2;
    private static String sign;
    private static final int MATH_EXPRESSION_ELEMENTS = 3;

    private Calculator() {
        throw new AssertionError("This class cannot be instantiated");
    }

    public static int getArg1() {
        return arg1;
    }

    public static int getArg2() {
        return arg2;
    }

    public static String getSign() {
        return sign;
    }

    public static double calculate(String input) {
        String[] mathExpressionElements = input.trim().split(" +");
        if (mathExpressionElements.length != MATH_EXPRESSION_ELEMENTS) {
            throw new RuntimeException("Ошибка! Введите, отделяя члены выражения пробелом.");
        }
        try {
            arg1 = Integer.parseInt(mathExpressionElements[0]);
            arg2 = Integer.parseInt(mathExpressionElements[2]);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Ошибка! Введите целые числа.");
        }
        sign = mathExpressionElements[1];
        return switch (sign) {
            case "+" -> arg1 + arg2;
            case "-" -> arg1 - arg2;
            case "*" -> arg1 * arg2;
            case "/" -> divide(arg1, arg2);
            case "^" -> Math.pow(arg1, arg2);
            case "%" -> Math.floorMod(arg1, arg2);
            default -> throw new IllegalStateException("Ошибка! Используйте только операции - + * / % ^");
        };
    }

    public static double divide(double arg1, double arg2) {
        if (arg2 == 0.0) {
            throw new ArithmeticException("Ошибка! На 0 делить нельзя.");
        }
        return arg1 / arg2;
    }
}


