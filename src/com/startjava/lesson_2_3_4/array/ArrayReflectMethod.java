package com.startjava.lesson_2_3_4.array;

import java.lang.reflect.Method;

public class ArrayReflectMethod {
    public static void main(String[] args) {
        int[] array = {};
        System.out.println("Тип массива - " + array.getClass());
        System.out.println("Суперкласс типа массива - " + array.getClass().getSuperclass());

        System.out.println("Доступные методы:");
        for (Method m : array.getClass().getMethods()) {
            System.out.println(m.getName());
        }
    }
}
