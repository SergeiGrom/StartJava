package com.startjava.lesson_2_3_4.array;

import java.util.Arrays;

/**
 * Задачи на тему: “Массивы. Цикл for-each”
 *
 * @author Sergei Grom
 * @version dated May 06, 2024
 */

public class ArrayTheme {
    public static void main(String[] args) {
        arrayIndexReverse();
        arrayCountFactorial();
        arrayIndexDelete();
        arrayAlphabetReverse();
        /*arrayUniqueNumbers();
        gameHangmanStart();
        typewriterTextOutput();*/
    }

    public static void arrayIndexReverse() {
        int[] src = {2, 1, 4, 3, 7, 6, 5};
        int len = src.length;
        System.out.println("1. Реверс значений массива");
        System.out.println("До реверса: " + Arrays.toString(src));
        for (int i = 0; src[i] != src[len - 1 - i]; i++) {
            int temp = src[i];
            src[i] = src[len - 1 - i];
            src[len - 1 - i] = temp;
        }
        System.out.println("После реверса: " + Arrays.toString(src));
        System.out.println();
    }

    public static void arrayCountFactorial() {
        System.out.println("2. Вычисление факториала 8");
        int[] src = new int[10];
        int len = src.length;
        int factorial = 1;
        for (int i = 1; i < len - 1; i++) {
            src[i] = i;
            factorial *= src[i];
            System.out.print(i != (len - 2) ? src[i] + " * " : src[i]);
        }
        System.out.print(" = " + factorial);
        System.out.println("\n");
    }

    public static void arrayIndexDelete() {
        System.out.println("3. Удаление элементов массива");
        double[] src = new double[15];
        int len = src.length;
        int indexMiddle = 0;
        double numMiddle = 0;
        System.out.println("Исходный массив : ");
        for (int i = 0; i < len; i++) {
            src[i] = Math.random();
            if (i == len / 2 + 1) {
                System.out.println();
                indexMiddle = i - 1;
                numMiddle = src[i - 1];
            }
            System.out.printf("%.3f ", src[i]);
        }
        System.out.printf("\nЗначение средней ячейки массива : %.3f \n", numMiddle);
        System.out.println("Измененный массив : ");
        int numChange = 0;
        for (int i = 0; i < len; i++) {
            if (src[i] > numMiddle) {
                src[i] = 0.0;
                numChange++;
            }
            if (i == indexMiddle + 1) {
                System.out.println();
            }
            System.out.printf("%.3f ", src[i]);
        }
        System.out.println("\nКоличество изменений элементов массива : " + numChange);
    }

    public static void arrayAlphabetReverse() {
        System.out.println("\n4. Вывод алфавита лесенкой");
        char[] src = new char[26];
        int len = src.length;
        char c = 'A';
        for (int i = 0; i < len; i++) {
            src [i] = c++;
        }
        for (int i = 0; i < len; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(src[len - 1 - j]);
            }
            System.out.println();
        }
    }
}

