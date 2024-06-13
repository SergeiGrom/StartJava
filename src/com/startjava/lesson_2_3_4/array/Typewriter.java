package com.startjava.lesson_2_3_4.array;

public class Typewriter {
    public static void main(String[] args) throws InterruptedException {
        String line1 = "Java - это C++, из которого убрали все пистолеты, ножи и дубинки.\n" +
                "- James Gosling";
        printOnTypewriter(line1);
        String line2 = "Чтобы написать чистый код, мы сначала пишем грязный код, затем рефакторим его.\n" +
                "- Robert Martin";
        printOnTypewriter(line2);
        printOnTypewriter("");
        printOnTypewriter(null);
    }

    private static void printOnTypewriter(String line) throws InterruptedException {
        if (line == null || line.isBlank()) {
            System.out.println("Ошибка. Пустая строка!\n");
            return;
        }
        // ищем индекс самого короткого и длинного слов без учета знаков препинания
        String[] words = line.split(" ");
        int minLengthIndex = 0;
        int maxLengthIndex = 0;
        int shortestWord = Integer.MAX_VALUE;
        int longestWord = Integer.MIN_VALUE;
        for (int i = 0; i < words.length; i++) {
            int length = words[i].replaceAll("\\p{P}", "").length();
            if (length == 0) continue;
            if (length < shortestWord) {
                shortestWord = length;
                minLengthIndex = i;
            }
            if (length > longestWord) {
                longestWord = length;
                maxLengthIndex = i;
            }
        }

        // приводим к верхнему регистру слова предложения в границах слов, найденных выше
        int startUpperCase = Math.min(minLengthIndex, maxLengthIndex);
        int endUpperCase = Math.max(minLengthIndex, maxLengthIndex);
        for (int i = startUpperCase; i <= endUpperCase; i++) {
            words[i] = words[i].toUpperCase();
        }

        // выводим на экран с эффектом печатающей машинки
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                System.out.print(word.charAt(i));
                Thread.sleep(150);
            }
            System.out.print(" ");
        }
        System.out.println("\n");
    }
}
