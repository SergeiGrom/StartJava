package com.startjava.lesson_2_3_4.bookcase;

enum MenuItems {
    VIEW(1), FIND(2), ADD(3), DELETE(4), DELETE_ALL(5), EXIT(6);
    private int itemNumber;

    MenuItems(int itemNumber) {
        this.itemNumber = itemNumber;
    }

    public int getItemNumber() {
        return itemNumber;
    }

    public static MenuItems getEnumByValue(int input) {
        MenuItems[] menuItems = values();
        for (MenuItems item : menuItems) {
            if (item.getItemNumber() == input) {
                return item;
            }
        }
        return null;
    }
}
