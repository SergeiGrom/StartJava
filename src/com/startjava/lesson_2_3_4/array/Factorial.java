package com.startjava.lesson_2_3_4.array;

import java.util.Arrays;

public class Factorial {
    public static void main(String[] args) {
        System.out.println("2. Вычисление факториала");
        calcFactorials();
        calcFactorials(null);
        calcFactorials(8, 0, 9);
        calcFactorials(-3, 1, 7, 13);
        calcFactorials(-22, -0);
    }

    private static void calcFactorials(long... integers) {
        if (integers == null || integers.length == 0) {
            System.out.println("Ошибка. Длина массива должна быть > 0\n");
            return;
        }
        long[] factorials = new long[integers.length];
        for (int i = 0; i < integers.length; i++) {
            long factorial = 1;
            if (integers[i] >= 0) {
                System.out.print(integers[i] + "! = ");
                for (int j = 1; j <= integers[i]; j++) {
                    if (integers[i] == 1) {
                        continue;
                    }
                    factorial *= j;
                    System.out.printf("%d%s", j, j != integers[i] ? " * " : " = ");
                }
                factorials[i] = factorial;
                System.out.println(factorial);
            } else {
                factorials[i] = integers[i];
                System.out.printf("Ошибка: факториал %d! не определен\n", integers[i]);
            }
        }
        System.out.println("Новый массив : " + Arrays.toString(factorials) + "\n");
    }
}
