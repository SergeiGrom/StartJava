package com.startjava.lesson_2_3_4.robot;

class JaegerTest {
    public static void main(String[] args) {
        Jaeger gipsyAvenger = new Jaeger("Gipsy Avenger", "Mark 10", "India", 3, 20.2, 3.7, 22, 7.8);
        System.out.println("Model Name : " + gipsyAvenger.getModelName() +
                "\nCategory : " + gipsyAvenger.getCategory() + "\nOrigin : " + gipsyAvenger.getOrigin());
        gipsyAvenger.useMeleeWeapon();
        gipsyAvenger.move();
        gipsyAvenger.stealthMode();
        gipsyAvenger.attack();

        Jaeger romeoBlue = new Jaeger();
        romeoBlue.setModelName("Romeo Blue");
        romeoBlue.setCategory("Mark 2");
        romeoBlue.setOrigin("Russia");
        romeoBlue.setPilotsNum(2);
        romeoBlue.setHeight(28.7);
        romeoBlue.setWeight(4.9);
        romeoBlue.setArmorClass(30);
        romeoBlue.setDangerRate(15.4);
        System.out.println("\nModel Name : " + romeoBlue.getModelName() +
                "\nCategory : " + romeoBlue.getCategory() + "\nOrigin : " + romeoBlue.getOrigin() +
                "\nPilots Number : " + romeoBlue.getPilotsNum() + "\nHeight : " + romeoBlue.getHeight() +
                "\nWeight : " + romeoBlue.getWeight() + "\nArmor Class : " + romeoBlue.getArmorClass() +
                "\nDangerRate : " + romeoBlue.getDangerRate());
        romeoBlue.useRangeWeapon();
        romeoBlue.attack();
    }
}