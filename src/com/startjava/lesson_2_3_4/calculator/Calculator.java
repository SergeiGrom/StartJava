package com.startjava.lesson_2_3_4.calculator;

public class Calculator {
    private static final int EXPRESSION_LENGTH = 3;
    private static int arg1;
    private static int arg2;
    private static String sign;

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

    public static double calculate(String inputExpression) {
        String[] elements = inputExpression.trim().split(" +");
        checkExpressionLength(elements);
        parseArgs(elements);
        sign = elements[1];
        return switch (sign) {
            case "+" -> arg1 + arg2;
            case "-" -> arg1 - arg2;
            case "*" -> arg1 * arg2;
            case "/", "%" -> {
                checkDivisor(arg2);
                yield sign.equals("/") ? (double) arg1 / arg2 : Math.floorMod(arg1, arg2);
            }
            case "^" -> Math.pow(arg1, arg2);
            default -> throw new IllegalStateException("Ошибка! Используйте только операции - + * / % ^");
        };
    }

    private static void checkExpressionLength(String[] elements) {
        if (elements.length != EXPRESSION_LENGTH) {
            throw new RuntimeException("Ошибка! Отделяйте пробелом каждый введенный элемент выражения.");
        }
    }

    private static void parseArgs(String[] elements) {
        try {
            arg1 = Integer.parseInt(elements[0]);
            arg2 = Integer.parseInt(elements[2]);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Ошибка! Введите целые числа.");
        }
    }

    private static void checkDivisor(int divisor) {
        if (divisor == 0) {
            throw new ArithmeticException("Ошибка! На 0 делить нельзя.");
        }
    }
}


