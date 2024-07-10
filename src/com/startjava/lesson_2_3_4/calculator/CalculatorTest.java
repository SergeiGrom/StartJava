package com.startjava.lesson_2_3_4.calculator;

import java.text.DecimalFormat;
import java.util.Scanner;

public class CalculatorTest {
    private static final String YES = "yes";
    private static final String NO = "no";

    public static void main(String[] args) {
        System.out.println("Калькулятор.");
        Scanner sc = new Scanner(System.in);
        double result;
        String answer = YES;
        do {
            if (YES.equals(answer)) {
                System.out.print("Введите выражение: ");
                try {
                    result = Calculator.calculate(sc.nextLine());
                } catch (RuntimeException e) {
                    System.out.println(e.getMessage());
                    continue;
                }
                displayResult(result);
                System.out.print("\nХотите продолжить? [yes / no]: ");
            } else {
                System.out.print("Введите корректный ответ [yes / no]: ");
            }
            answer = sc.nextLine();
        } while (!NO.equals(answer));
        sc.close();
    }

    private static void displayResult(double result) {
        String resultPattern = result % 1 != 0 ? "#,###,###,###.###" : "#,###,###,###";
        DecimalFormat df = new DecimalFormat(resultPattern);
        System.out.printf("Результат: %d %s %d = %s", Calculator.getArg1(), Calculator.getSign(),
                Calculator.getArg2(), df.format(result));
    }
}

