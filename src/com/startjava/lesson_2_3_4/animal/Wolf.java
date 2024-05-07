package com.startjava.lesson_2_3_4.animal;

public class Wolf {
    private String sex;
    private String name;
    private double weight;
    private int age;
    private String color;

    public Wolf(String sex, String name, double weight, int age, String color) {
        this.sex = sex;
        this.name = name;
        this.weight = weight;
        this.age = age;
        this.color = color;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age > 8.0) {
            System.out.println(age + " Wrong age!");
        } else {
            this.age = age;
        }
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void move() {
        System.out.println("Move");
    }

    public void sit() {
        System.out.println("Sit");
    }

    public void run() {
        System.out.println("Run");
    }

    public void howl() {
        System.out.println("Howl");
    }

    public void hunt() {
        System.out.println("Hunt");
    }
}