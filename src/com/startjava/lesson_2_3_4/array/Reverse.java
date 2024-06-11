package com.startjava.lesson_2_3_4.array;

import java.util.Arrays;

public class Reverse {
    public static void main(String[] args) {
        System.out.println("1. Реверс значений массива");
        reverseNums(new int[]{});
        reverseNums(null);
        reverseNums(new int[]{6, 8, 9, 1});
        reverseNums(new int[]{13, 8, 5, 3, 2, 1, 1});
    }

    private static void reverseNums(int[] integers) {
        if (integers == null) {
            System.out.println("Ошибка. Длина массива должна быть > 1\n");
            return;
        }
        int length = integers.length;
        System.out.println("   До реверса: " + Arrays.toString(integers));
        for (int i = 0; i < length - 1; i++) {
            int swap = integers[i];
            integers[i] = integers[--length];
            integers[length] = swap;
        }
        System.out.println("После реверса: " + Arrays.toString(integers) + "\n");
    }
}
