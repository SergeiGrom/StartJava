package com.startjava.lesson_2_3_4.bookcase;

enum MenuOptions {
    VIEW(1), FIND(2), ADD(3), DELETE(4), DELETE_ALL(5), EXIT(6);
    private int optionNumber;

    MenuOptions(int optionNumber) {
        this.optionNumber = optionNumber;
    }

    public int getOptionNumber() {
        return optionNumber;
    }

    public static MenuOptions getEnumByValue(int input) {
        MenuOptions[] menuOptions = values();
        for (MenuOptions option : menuOptions) {
            if (option.getOptionNumber() == input) {
                return option;
            }
        }
        return null;
    }
}
