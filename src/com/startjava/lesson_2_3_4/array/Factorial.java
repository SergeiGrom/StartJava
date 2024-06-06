package com.startjava.lesson_2_3_4.array;

import java.util.Arrays;

public class Factorial {
    public static void main(String[] args) {
        System.out.println("2. Вычисление факториала");
        long[] integers = {};
        replaceIntegerOnItsFactorial(integers);
        replaceIntegerOnItsFactorial(null);
        replaceIntegerOnItsFactorial(8, 0, 9);
        replaceIntegerOnItsFactorial(-3, 1, 7, 13);
        replaceIntegerOnItsFactorial(-22, -0);
    }

    private static void replaceIntegerOnItsFactorial(long... integers) {
        if (integers != null && integers.length > 0) {
            for (int i = 0; i < integers.length; i++) {
                if (integers[i] >= 0) {
                    long factorial = 1;
                    System.out.print(integers[i] + "! = ");
                    for (int j = 1; j <= integers[i]; j++) {
                        if (integers[i] == 1) {
                            continue;
                        }
                        factorial *= j;
                        System.out.printf("%d%s", j, j != integers[i] ? " * " : " = ");
                    }
                    System.out.println(factorial);
                    integers[i] = factorial;
                } else {
                    System.out.printf("Ошибка: факториал %d! не определен\n\n", integers[i]);
                }
            }
            System.out.println("Измененный массив : " + Arrays.toString(integers) + "\n");
        }
    }
}
