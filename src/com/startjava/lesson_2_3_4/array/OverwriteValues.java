package com.startjava.lesson_2_3_4.array;

public class OverwriteValues {
    public static void main(String[] args) {
        System.out.println("\n3. Удаление элементов массива");
        double[] randomDoubles = new double[15];
        for (int i = 0; i < randomDoubles.length; i++) {
            randomDoubles[i] = Math.random();
        }
        overwriteAboveSetValue(-1, randomDoubles);
        overwriteAboveSetValue(15, randomDoubles);
        overwriteAboveSetValue(0, randomDoubles);
        overwriteAboveSetValue(14, randomDoubles);
    }

    private static void overwriteAboveSetValue(int index, double[] randomDoubles) {
        int length = randomDoubles.length;
        if (index >= 0 && index < length) {
            System.out.println("Исходный массив :");
            printArray(length, randomDoubles);
            System.out.printf("\nЗначение из ячейки по адресу %d: %.3f \n", index, randomDoubles[index]);
            int replacementsCounter = 0;
            for (int i = 0; i < length; i++) {
                if (randomDoubles[i] > randomDoubles[index]) {
                    randomDoubles[i] = 0.0;
                    replacementsCounter++;
                }
            }
            System.out.println("Измененный массив :");
            printArray(length, randomDoubles);
            System.out.println("\nКоличество изменений элементов массива : " + replacementsCounter);
        } else {
            System.out.printf("Не верно задан адрес ячейки массива: %d5%n", index);
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
