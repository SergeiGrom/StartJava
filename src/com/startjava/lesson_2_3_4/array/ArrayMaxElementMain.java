package com.startjava.lesson_2_3_4.array;

import java.util.Scanner;

public class ArrayMaxElementMain {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите длину массива: ");
        int maxLength = sc.nextInt();
        int[] numbers = new int[maxLength];

        System.out.println("Заполните массив целыми числами через пробел: ");
        for (int i = 0; i < maxLength; i++) {
            numbers[i] = sc.nextInt();
        }

        int max = numbers[0];
        for (int i = 0; i < maxLength; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }
        System.out.println("Максимальное число: " + max);
    }
}
