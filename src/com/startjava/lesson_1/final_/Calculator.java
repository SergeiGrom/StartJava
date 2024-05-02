package com.startjava.lesson_1.final_;

public class Calculator {
    public static void main(String[] args) {
        System.out.println("Калькулятор:");
        int a = 10;
        int b = 3;
        char sign = '/';
        int result = 1;
        if (sign == '+') {
            result = a + b;
        } else if (sign == '-') {
            result = a - b;
        } else if (sign == '*') {
            result = a * b;
        } else if (sign == '/') {
            result = a / b;
        } else if (sign == '^') {
            for (int i = 0; i < b; i++) {
                result *= a;
            }
        } else if (sign == '%') {
            result = a % b;
        }
        System.out.println(a + " " + sign + " " + b + " = " + result);
    }
}