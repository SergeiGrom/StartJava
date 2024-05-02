package com.startjava.lesson_2_3.person;

public class Person {
    String sex = "Male";
    String name = "KOKO";
    int age = 20;
    double height = 180.5;
    double weight = 75.7;

    void move() {
        System.out.println("Идти");;
    }

    void sit() {
        System.out.println("Сидеть");
    }

    void run() {
        System.out.println("Бежать");
    }

    void speak() {
        System.out.println("Говорить");
    }

    void learn() {
        System.out.println("Учить");
    }
}