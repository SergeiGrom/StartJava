package com.startjava.lesson_2_3_4.array;

import java.util.Random;
import java.util.Scanner;

public class GallowsGame {
    public static void main(String[] args) {
        System.out.println("6. Игра “Виселица”");
        // Выбор случайного слова из перечня.
        String[] wordsPool = {"репродукция", "вирусолог", "пекарня", "сопряжение", "заведение"};
        Random rnd = new Random();
        StringBuilder hiddenWord = new StringBuilder(wordsPool[rnd.nextInt(wordsPool.length)]);

        // Создаем слово-маску и слово-набор не верно введенных букв
        StringBuilder wrongLetters = new StringBuilder();
        StringBuilder maskedWord = new StringBuilder();
        int length = hiddenWord.length();
        maskedWord.append("_".repeat(length));

        // Игра длится, пока слово не будет отгадано или не кончатся попытки.
        Scanner console = new Scanner(System.in);
        int attempts = length;
        int drawElements = 0;
        char inputChar = ' ';
        while (attempts > 0) {
            // проверка введенных с клавиатуры символов на кириллицу [A->Я. а->я]
            do {
                System.out.println("Угадайте слово: " + maskedWord);
                System.out.println("Количество попыток: " + attempts);
                System.out.print("Введите букву: ");
                inputChar = console.nextLine().charAt(0);
            } while (!isCyrillic(inputChar));

            // количество попыток увелич или уменьш, согасно условиям задачи
            boolean isEqualsHidden = isLetter(hiddenWord, inputChar);
            boolean isEqualsWrong = isLetter(wrongLetters, inputChar);
            boolean isEqualsMasked = isLetter(maskedWord, inputChar);
            if (!isEqualsHidden && !isEqualsWrong) {
                wrongLetters.append(Character.toUpperCase(inputChar));
                attempts--;
                drawElements++;
                drawGallows(length, drawElements);
                System.out.println("Не совпали буквы: " + wrongLetters);
            }
            if (isEqualsHidden && !isEqualsMasked) {
                if (attempts < length) {
                    attempts++;
                }
                if (drawElements > 0) {
                    drawElements--;
                }
                drawGallows(length, drawElements);
            }

            // метод меняет _ на букву при совпадении
            openMasked(maskedWord, hiddenWord, inputChar);

            // Проверка условия победы.
            if (hiddenWord.toString().equalsIgnoreCase(maskedWord.toString())) {
                System.out.println(maskedWord + "\nПоздравляем! Вы победили!");
                break;
            }
        }
        System.out.println("Вы проиграли.\nЗагаданное слово: " + hiddenWord.toString().toUpperCase());
    }

    private static void openMasked(StringBuilder maskedWord, StringBuilder hiddenWord, char inputChar) {
        for (int i = 0; i < hiddenWord.length(); i++) {
            if (String.valueOf(hiddenWord.charAt(i)).equalsIgnoreCase(String.valueOf(inputChar))) {
                maskedWord.setCharAt(i, Character.toUpperCase(inputChar));
            }
        }
    }

    private static boolean isCyrillic(char inputChar) {
        // визуально разделяем попытки чертой, это не часть виселицы.
        System.out.println("-------------------------------------------");
        if (inputChar < 'А' || inputChar > 'я' || String.valueOf(inputChar).isBlank()) {
            System.out.println("Используйте только кириллицу [A->Я. а->я]");
            return false;
        }
        return true;
    }

    private static boolean isLetter(StringBuilder word, char inputChar) {
        for (int i = 0; i < word.length(); i++) {
            if (String.valueOf(word.charAt(i)).equalsIgnoreCase(String.valueOf(inputChar))) {
                return true;
            }
        }
        return false;
    }

    // Г-образная, делим пополам длину слова (кол-во попыток)
    private static void drawGallows(int length, int drawElements) {
        int middle = length % 2 == 0 ? length / 2 : length / 2 + 1;
        if (drawElements > middle) {
            System.out.print("|");
            for (int i = 0; i < drawElements - middle; i++) {
                System.out.print("= ");
            }
            System.out.println();
            for (int i = 0; i < middle - 1; i++) {
                System.out.println("|");
            }
        } else {
            for (int i = 0; i < drawElements; i++) {
                System.out.println("|");
            }
        }
    }
}

