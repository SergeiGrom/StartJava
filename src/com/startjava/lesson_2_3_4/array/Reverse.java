package com.startjava.lesson_2_3_4.array;

import java.util.Arrays;

public class Reverse {
    public static void main(String[] args) {
        System.out.println("1. Реверс значений массива");
        int[] integers = {};
        reverseNums(integers);
        reverseNums(null);
        reverseNums(6, 8, 9, 1);
        reverseNums(13, 8, 5, 3, 2, 1, 1);
        reverseNums(1, 7, 4, 5, 2, 6, 3);
    }

    private static void reverseNums(int... integers) {
        if (integers != null && integers.length > 0) {
            int length = integers.length;
            System.out.println("   До реверса: " + Arrays.toString(integers));
            for (int i = 0; i < length; i++) {
                int temp = integers[i];
                integers[i] = integers[--length];
                integers[length] = temp;
            }
            System.out.println("После реверса: " + Arrays.toString(integers) + "\n");
        }
    }
}
