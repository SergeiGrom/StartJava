package com.startjava.lesson_2_3_4.array;

public class UniqueNumbers {
    public static void main(String[] args) {
        System.out.println("5. Заполнение массива уникальными числами :");
        addSortedUniqueNums(23, -10, 20);
        addSortedUniqueNums(10, 60, 100);
        addSortedUniqueNums(0, 34, -34);
        addSortedUniqueNums(-8, 0, 0);
    }

    private static void addSortedUniqueNums(int numsInLine, int borderA, int borderB) {
        if (numsInLine >= 1) {
            // создаем массив c параметрами, согласно условию
            int length = (int) (Math.abs((borderB - borderA) + 1) * 0.75);
            int[] uniqueNums = new int[length];

            // заполняем массив уникальными значениями
            int index = 0;
            while (index < length) {
                uniqueNums[index] = generateUnique(uniqueNums, borderA, borderB, index);
                index++;
            }

            // сортируем пузырьком массив по возрастанию (вручную)
            sortAscending(uniqueNums);

            // выводим numsInLine значений в строке, согласно условию
            for (int i = 0; i < length; i++) {
                System.out.print(uniqueNums[i] + " ");
                if ((i + 1) % numsInLine == 0) {
                    System.out.println();
                }
            }
        } else {
            System.out.printf("Ошибка: количество чисел в строке не может быть меньше 1 (%d)\n", numsInLine);
        }
    }

    private static int generateUnique(int[] uniqueNums, int borderA, int borderB, int index) {
        int min = Math.min(borderA, borderB);
        int max = Math.max(borderA, borderB);
        int random = 0;
        boolean isUnique = true;
        while (isUnique) {
            isUnique = false;
            random = (int) (min + Math.random() * (max - min + 1));
            for (int j = 0; j < index; j++) {
                if (random == uniqueNums[j]) {
                    isUnique = true;
                }
            }
        }
        return random;
    }

    private static void sortAscending(int[] uniqueNums) {
        int length = uniqueNums.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j <= i; j++) {
                if (uniqueNums[j] > uniqueNums[i]) {
                    uniqueNums[i] += uniqueNums[j];
                    uniqueNums[j] = uniqueNums[i] - uniqueNums[j];
                    uniqueNums[i] -= uniqueNums[j];
                }
            }
        }
    }
}


