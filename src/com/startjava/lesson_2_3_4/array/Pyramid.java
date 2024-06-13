package com.startjava.lesson_2_3_4.array;

public class Pyramid {
    public static void main(String[] args) {
        System.out.println("4. Вывод отсортированных символов в виде пирамиды");
        displayPyramid('0', '9', true);
        displayPyramid('/', '!', false);
        displayPyramid('A', 'J', false);
    }

    private static void displayPyramid(char start, char end, boolean isAscending) {
        // Приводим к унифицированному виду. start < end в ASCII.
        if (start > end) {
            start += end;
            end = (char) (start - end);
            start -= end;
        }

        // Выводим символы пирамидой в указанном порядке. Строки формируем StringBuilder, согласно заданию.
        char toPrint = 0;
        int i = 0;
        StringBuilder line = new StringBuilder();
        while (toPrint != (isAscending ? end : start)) {
            toPrint = isAscending ? (char) (start + i) : (char) (end - i);
            line.append(" ".repeat(end - start - i));
            line.append(String.valueOf(toPrint).repeat(i * 2 + 1));
            System.out.println(line);
            i++;
            line.setLength(0);
        }
    }
}
