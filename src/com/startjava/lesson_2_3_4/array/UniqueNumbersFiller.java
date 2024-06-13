package com.startjava.lesson_2_3_4.array;

public class UniqueNumbersFiller {
    public static void main(String[] args) {
        System.out.println("5. Заполнение массива уникальными числами :");
        addSortedUniqueNumbers(11, -30, 20);
        addSortedUniqueNumbers(10, 60, 100);
        addSortedUniqueNumbers(0, 34, -34);
        addSortedUniqueNumbers(-8, 0, 0);
    }

    private static void addSortedUniqueNumbers(int numbersInLine, int start, int end) {
        if (numbersInLine < 1) {
            System.out.printf("Ошибка: количество чисел в строке не может быть меньше 1 (%d)\n\n", numbersInLine);
            return;
        }
        // создаем массив c параметрами, согласно условию
        int length = (int) (Math.abs((end - start) + 1) * 0.75);
        int[] uniqueNumbers = new int[length];

        // заполняем массив уникальными значениями
        int index = 0;
        while (index < length) {
            uniqueNumbers[index] = generateUnique(uniqueNumbers, start, end, index);
            index++;
        }

        // сортируем пузырьком массив по возрастанию (вручную)
        sortAsc(uniqueNumbers);

        // выводим numbersInLine значений в строке, согласно условию
        int k = 0;
        for (int i = 0; i < Math.ceil((double) length / numbersInLine); i++) {
            for (int j = 0; j < numbersInLine; j++) {
                System.out.printf("%4d", uniqueNumbers[k]);
                k++;
                if (k == length) {
                    break;
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    private static int generateUnique(int[] uniqueNums, int start, int end, int index) {
        int min = Math.min(start, end);
        int max = Math.max(start, end);
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

    private static void sortAsc(int[] uniqueNumbers) {
        int length = uniqueNumbers.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j <= i; j++) {
                if (uniqueNumbers[j] > uniqueNumbers[i]) {
                    uniqueNumbers[i] += uniqueNumbers[j];
                    uniqueNumbers[j] = uniqueNumbers[i] - uniqueNumbers[j];
                    uniqueNumbers[i] -= uniqueNumbers[j];
                }
            }
        }
    }
}


