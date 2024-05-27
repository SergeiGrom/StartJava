package com.startjava.lesson_2_3_4.array;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Задачи на тему: “Массивы. Цикл for-each”
 *
 * @author Sergei Grom
 * @version dated May 27, 2024
 */

public class ArrayTheme {
    public static void main(String[] args) {
        reverseArray();
        factorial();
        overwriteAboveMiddleValue();
        reverseAlphabet();
        addUniqueNums();
        gameHangman();
    }

    public static void reverseArray() {
        int[] intNums = {2, 1, 4, 3, 7, 6, 5};
        int len = intNums.length;
        System.out.println("1. Реверс значений массива");
        System.out.println("До реверса: " + Arrays.toString(intNums));
        for (int i = 0; i < len; i++) {
            --len;
            int temp = intNums[i];
            intNums[i] = intNums[len];
            intNums[len] = temp;
        }
        System.out.println("После реверса: " + Arrays.toString(intNums));
        System.out.println();
    }

    public static void factorial() {
        System.out.println("2. Вычисление факториала 8");
        int[] multipliers = new int[10];
        int len = multipliers.length;
        int factorial = 1;
        for (int i = 0; i < len; i++) {
            multipliers[i] = i;
            if (i == 0 || i == len - 1) {
                continue;
            }
            factorial *= multipliers[i];
            System.out.print(multipliers[i]);
            System.out.print(i != (len - 2) ? " * " : "");
        }
        System.out.print(" = " + factorial + "\n");
    }

    public static void overwriteAboveMiddleValue() {
        System.out.println("3. Удаление элементов массива");
        double[] randomDoubles = new double[15];
        int len = randomDoubles.length;
        int indexMiddle = len / 2;
        System.out.println("Исходный массив :");
        for (int i = 0; i < len; i++) {
            randomDoubles[i] = Math.random();
            if (i == indexMiddle + 1) {
                System.out.println();
            }
            System.out.printf("%.3f ", randomDoubles[i]);
        }
        double numMiddle = randomDoubles[indexMiddle];
        System.out.printf("\nЗначение средней ячейки массива : %.3f \n", numMiddle);
        System.out.println("Измененный массив :");
        int numChange = 0;
        for (int i = 0; i < len; i++) {
            if (randomDoubles[i] > numMiddle) {
                randomDoubles[i] = 0.0;
                numChange++;
            }
            if (i == indexMiddle + 1) {
                System.out.println();
            }
            System.out.printf("%.3f ", randomDoubles[i]);
        }
        System.out.println("\nКоличество изменений элементов массива : " + numChange);
    }

    public static void reverseAlphabet() {
        System.out.println("\n4. Вывод алфавита лесенкой");
        char[] alphabet = new char[26];
        int len = alphabet.length;
        for (int i = 0; i < len; i++) {
            alphabet[i] = (char) ('A' + i);
        }
        for (int i = 0; i < len; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(alphabet[len - 1 - j]);
            }
            System.out.println();
        }
    }

    public static void addUniqueNums() {
        System.out.println("\n5. Заполнение массива уникальными числами :");
        int[] uniqueNums = new int[30];
        int len = uniqueNums.length;
        int randomNum = 0;
        for (int i = 0; i < len; i++) {
            boolean isEqual = true;
            while (isEqual) {
                isEqual = false;
                randomNum = (int) (60 + Math.random() * 40);
                for (int j = 0; j < i; j++) {
                    if (randomNum == uniqueNums[j]) {
                        isEqual = true;
                    }
                }
            }
            uniqueNums[i] = randomNum;
        }
        for (int i = 0; i < len; i++) {
            for (int j = 0; j <= i; j++) {
                if (uniqueNums[j] > uniqueNums[i]) {
                    randomNum = uniqueNums[j];
                    uniqueNums[j] = uniqueNums[i];
                    uniqueNums[i] = randomNum;
                }
            }
        }
        for (int i = 0; i < len; i++) {
            System.out.print(uniqueNums[i] + " ");
            if ((i + 1) % 10 == 0) {
                System.out.println();
            }
        }
    }

    public static void gameHangman() {
        System.out.println("\n6. Игра “Виселица”");
        // Выбор случайного слова из перечня.
        String[] wordsPool = {"репродукция", "вирусолог", "пекарня", "сопряжение", "заведение"};
        int randomIndex = (int) Math.floor(Math.random() * wordsPool.length);
        String hiddenWord = wordsPool[randomIndex];

        // Создаем массив из букв загаданного слова
        int length = hiddenWord.length();
        char[] hiddenLetters = hiddenWord.toCharArray();

        // ADMIN Hint. Подглядываем слово.
        // System.out.println(Arrays.toString(hiddenLetters));

        // Создаем массив-маску загаданного слова.
        char[] maskedLetters = hiddenLetters.clone();
        Arrays.fill(maskedLetters, '*');

        // Игра длится, пока слово не будет отгадано или не кончатся попытки.
        int attempts = (int) (length * 1.5);
        int drawElements = 0;
        char inputChar = ' ';
        String wrongLetters = "";
        String maskedWord = arrayToString(maskedLetters);
        while (attempts > 0) {
            System.out.println("Угадайте слово: " + maskedWord);
            System.out.println("Количество попыток: " + attempts);
            // проверка введенных с клавиатуры символов на кириллицу [A->Я. а->я]
            do {
                System.out.print("Введите букву: ");
                Scanner console = new Scanner(System.in);
                inputChar = console.nextLine().charAt(0);
            } while (checkCyrillic(inputChar));
            // метод меняет * на букву при совпадении
            openMasked(maskedLetters, hiddenLetters, inputChar);
            // визуально разделяем попытки чертой, это не часть виселицы.
            System.out.println("------------------------------------------");
            // количество попыток увелич или уменьш, согасно условиям задачи
            boolean isEqualsHidden = findEqualLetters(hiddenWord, inputChar);
            boolean isEqualsWrong = findEqualLetters(wrongLetters, inputChar);
            boolean isEqualsMasked = findEqualLetters(maskedWord, inputChar);
            if (!isEqualsHidden && !isEqualsWrong) {
                wrongLetters += inputChar;
                attempts--;
                drawElements += 1;
                if (drawElements > 0) {
                    drawHangman(length, drawElements);
                }
                System.out.println("Не совпали буквы: " + wrongLetters.toUpperCase());
            }
            if (isEqualsHidden && !isEqualsMasked) {
                attempts++;
                drawElements -= 1;
                if (drawElements > 0) {
                    drawHangman(length, drawElements);
                }
            }
            /*
             Проверка условия победы\поражения.
             Тк для удобства чтения буквы maskedWord разделены, сравниваем также разделяя буквы загаданного слова.
            */
            if (attempts == 0) {
                System.out.println("Вы проиграли.\nЗагаданное слово: " + hiddenWord.toUpperCase());
            }
            maskedWord = arrayToString(maskedLetters);
            String checkWord = arrayToString(hiddenLetters);
            if (checkWord.equalsIgnoreCase(maskedWord)) {
                System.out.println(maskedWord + "\nПоздравляем! Вы победили!");
                break;
            }
        }
    }

    private static void openMasked(char[] maskedLetters, char[] hiddenLetters, char inputChar) {
        for (int i = 0; i < hiddenLetters.length; i++) {
            if (Character.toUpperCase(hiddenLetters[i]) == Character.toUpperCase(inputChar)) {
                maskedLetters[i] = Character.toUpperCase(inputChar);
            }
        }
    }

    private static String arrayToString(char[] maskedLetters) {
        String maskedWord = Arrays.toString(maskedLetters);
        maskedWord = maskedWord.replaceAll("[\\[\\],]", " ");
        maskedWord = maskedWord.toUpperCase();
        return maskedWord;
    }

    private static boolean checkCyrillic(char inputChar) {
        if ('А' > inputChar || inputChar > 'я') {
            System.out.println("Используйте только кириллицу [A->Я. а->я]");
            return true;
        }
        return false;
    }

    private static boolean findEqualLetters(String word, char inputChar) {
        char[] splitLetters = word.toCharArray();
        for (char splitLetter : splitLetters) {
            if (Character.toUpperCase(splitLetter) == Character.toUpperCase(inputChar)) {
                return true;
            }
        }
        return false;
    }

    // Г-образная, по вертикали размер <= длине слова, по горизонтали + от половины слова к int.
    private static void drawHangman(int length, int drawElements) {
        if (drawElements >= length) {
            for (int i = 0; i <= drawElements - length; i++) {
                System.out.print("|*|");
            }
            System.out.println();
            for (int i = 1; i < length; i++) {
                System.out.println("|*|");
            }
        } else {
            for (int i = 1; i <= drawElements; i++) {
                System.out.println("|*|");
            }
        }
    }
}

