package com.startjava.lesson_2_3_4.calculator;

import java.text.DecimalFormat;
import java.util.Scanner;

public class CalculatorTest {
    public static void main(String[] args) {
        System.out.println("Калькулятор.");
        Scanner sc = new Scanner(System.in);
        double result;
        boolean isExit = false;
        while (!isExit) {
            System.out.print("Введите выражение: ");
            try {
                result = Calculator.calculate(sc.nextLine());
            } catch (Exception e) {
                System.out.println(e.getMessage());
                continue;
            }
            String resultPattern = result % 1 != 0 ? "#,###,###,###.###" : "#,###,###,###";
            DecimalFormat df = new DecimalFormat(resultPattern);
            System.out.printf("Результат: %d %s %d = %s", Calculator.inputA, Calculator.sign,
                    Calculator.inputB, df.format(result));
            System.out.print("\nХотите продолжить? [yes / no]: ");
            while (true) {
                try {
                    isExit = exit(sc);
                    break;
                } catch (Exception e) {
                    System.out.print(e.getMessage());
                }
            }
        }
        sc.close();
    }

    public static boolean exit(Scanner sc) throws RuntimeException {
        String answer = sc.nextLine().toLowerCase();
        return switch (answer) {
            case "yes" -> false;
            case "no" -> true;
            default -> throw new IllegalStateException("Введите корректный ответ [yes / no]: ");
        };
    }
}
    /*
        Проверка с использованием Nan выглядела так:
        if (Double.isNaN(result) || Double.isInfinite(result)) {
            System.out.println("Не допустимая мат. операция!");
        }*/

