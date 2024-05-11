package com.startjava.lesson_2_3_4.array;

import java.util.Arrays;

/**
 * Задачи на тему: “Массивы. Цикл for-each”
 *
 * @author Sergei Grom
 * @version dated May 11, 2024
 */

public class ArrayTheme {
    public static void main(String[] args) {
        reverseVariables();
        factorial();
        deleteVariables();
        reverseAlphabet();
        addUniqueNums();
        /* gameHangmanStart();
        typewriterTextOutput();*/
    }

    public static void reverseVariables() {
        int[] intNums = {2, 1, 4, 3, 7, 6, 5};
        int len = intNums.length;
        System.out.println("1. Реверс значений массива");
        System.out.println("До реверса: " + Arrays.toString(intNums));
        for (int i = 0; intNums[i] != intNums[len - 1 - i]; i++) {
            int temp = intNums[i];
            intNums[i] = intNums[len - 1 - i];
            intNums[len - 1 - i] = temp;
        }
        System.out.println("После реверса: " + Arrays.toString(intNums));
        System.out.println();
    }

    public static void factorial() {
        System.out.println("2. Вычисление факториала 8");
        int[] intNums = new int[10];
        int len = intNums.length;
        int factorial = 1;
        for (int i = 0; i < len; i++) {
            intNums[i] = i;
            if (i == 0 || i == len - 1) {
                continue;
            }
            factorial *= intNums[i];
            System.out.print(i != (len - 2) ? intNums[i] + " * " : intNums[i]);
        }
        System.out.print(" = " + factorial);
        System.out.println("\n");
    }

    public static void deleteVariables() {
        System.out.println("3. Удаление элементов массива");
        double[] realNums = new double[15];
        int len = realNums.length;
        int indexMiddle = 0;
        double numMiddle = 0;
        for (int i = 0; i < len; i++) {
            realNums[i] = Math.random();
            if (i == len / 2) {
                indexMiddle = i;
                numMiddle = realNums[i];
            }
        }
        System.out.printf("Значение средней ячейки массива : %.3f \n", numMiddle);
        System.out.println("Измененный массив : ");
        int numChange = 0;
        for (int i = 0; i < len; i++) {
            if (realNums[i] > numMiddle) {
                realNums[i] = 0.0;
                numChange++;
            }
            if (i == indexMiddle + 1) {
                System.out.println();
            }
            System.out.printf("%.3f ", realNums[i]);
        }
        System.out.println("\nКоличество изменений элементов массива : " + numChange);
    }

    public static void reverseAlphabet() {
        System.out.println("\n4. Вывод алфавита лесенкой");
        char[] alphabet = new char[26];
        int len = alphabet.length;
        for (int i = 0; i < len; i++) {
            alphabet[i] = (char) ('A' + i);
        }
        for (int i = 0; i < len; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(alphabet[len - 1 - j]);
            }
            System.out.println();
        }
    }

    public static void addUniqueNums() {
        System.out.println("\n5. Заполнение массива уникальными числами :");
        int[] uniqueNums = new int[39];
        int len = uniqueNums.length;
        int temp = 0;
        for (int i = 0; i < len; i++) {
            boolean flag = true;
            while (flag) {
                flag = false;
                temp = (int) (60 + Math.random() * 40);
                for (int j = 0; j < i; j++) {
                    if (temp == uniqueNums[j]) {
                        flag = true;
                    }
                }
            }
            uniqueNums[i] = temp;
        }
        for (int i = 0; i < len; i++) {
            for (int j = 0; j <= i; j++) {
                if (uniqueNums[j] > uniqueNums[i]) {
                    temp = uniqueNums[j];
                    uniqueNums[j] = uniqueNums[i];
                    uniqueNums[i] = temp;
                }
            }
        }
        for (int i = 0; i < len - 1; i++) {
            uniqueNums[i] = uniqueNums[i + 1];
            System.out.print(uniqueNums[i] + " ");
            if ((i + 1) % 10 == 0) {
                System.out.println();
            }
        }
    }
}

