package com.startjava.lesson_2_3_4.array;

import java.util.Arrays;

public class OverwriteValues {
    public static void main(String[] args) {
        System.out.println("\n3. Удаление элементов массива");
        overwriteAboveSetValue(-1);
        overwriteAboveSetValue(15);
        overwriteAboveSetValue(0);
        overwriteAboveSetValue(14);
    }

    private static void overwriteAboveSetValue(int index) {
        double[] randomDoubles = new double[15];
        Arrays.fill(randomDoubles, 1);
        for (int i = 0; i < 15; i++) {
            randomDoubles[i] = Math.random();
        }
        int length = randomDoubles.length;
        if (index >= 0 && index < length) {
            System.out.println("Исходный массив:");
            printArray(length, randomDoubles);
            System.out.printf("\nЗначение из ячейки по адресу %d: %.3f \n", index, randomDoubles[index]);
            int replacementsCounter = 0;
            for (int i = 0; i < length; i++) {
                if (randomDoubles[i] > randomDoubles[index]) {
                    randomDoubles[i] = 0.0;
                    replacementsCounter++;
                }
            }
            System.out.println("Измененный массив:");
            printArray(length, randomDoubles);
            System.out.println("\nКоличество изменений элементов массива: " + replacementsCounter);
        } else {
            System.out.printf("Ошибка: значение индекса (%d) должно быть от 0 до %d%n", index, length - 1);
        }
        System.out.println("--------------------------------------------------");
    }

    private static void printArray(int length, double[] randomDoubles) {
        for (int i = 0; i < length; i++) {
            System.out.printf("%.3f ", randomDoubles[i]);
            if (i == length / 2) {
                System.out.println();
            }
        }
    }
}
