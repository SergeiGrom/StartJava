package com.startjava.lesson_2_3_4.bookcase;

enum MenuItem {
    VIEW(1), FIND(2), ADD(3), DELETE(4), DELETE_ALL(5), EXIT(6);

    private int itemNumber;

    MenuItem(int itemNumber) {
        this.itemNumber = itemNumber;
    }

    public static MenuItem getName(int input) {
        return (input > 0 && input <= MenuItem.values().length) ? MenuItem.values()[input - 1] : null;
    }
}
