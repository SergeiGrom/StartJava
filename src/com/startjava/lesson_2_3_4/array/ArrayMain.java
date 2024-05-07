package com.startjava.lesson_2_3_4.array;

public class ArrayMain {

    public static void main(String[] args) {
        int[] numbers = new int[6];
        float[] numbers2 = {5.1f, .5f, 200.5f};

        System.out.println(numbers.length);
        System.out.println(numbers2.length);

        for (float number : numbers2) {
            System.out.println(number);
        }

        String[] text = new String[5];
        for (String string : text) {
            System.out.println(string);
        }
    }
}
