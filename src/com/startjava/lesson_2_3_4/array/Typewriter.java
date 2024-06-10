package com.startjava.lesson_2_3_4.array;

public class Typewriter {
    public static void main(String[] args) throws InterruptedException {
        String line1 = "Java - это C++, из которого убрали все пистолеты, ножи и дубинки.\n" +
                "- James Gosling";
        prtCharsDelayed(line1);
        String line2 = "Чтобы написать чистый код, мы сначала пишем грязный код, затем рефакторим его.\n" +
                "- Robert Martin";
        prtCharsDelayed(line2);
        prtCharsDelayed("");
        prtCharsDelayed(null);
    }

    private static void prtCharsDelayed(String line) throws InterruptedException {
        if (line == null || line.isBlank()) {
            System.out.println("Ошибка. Пустая строка!");
        } else {
            String[] words = line.split("\\s+");
            int startUpperCaseIndex = Math.min(minLengthIndex(words), maxLengthIndex(words));
            int endUpperCaseIndex = Math.max(minLengthIndex(words), maxLengthIndex(words));
            for (int i = startUpperCaseIndex; i <= endUpperCaseIndex; i++) {
                words[i] = words[i].toUpperCase();
            }
            for (String word : words) {
                for (int i = 0; i < word.length(); i++) {
                    System.out.print(word.charAt(i));
                    if (word.charAt(i) == '.') {
                        System.out.println();
                    }
                    Thread.sleep(150);
                }
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    private static int minLengthIndex(String[] words) {
        int index = 0;
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            int length = words[i].replaceAll("\\p{P}", "").length();
            if (length < minLen && length != 0) {
                minLen = length;
                index = i;
            }
        }
        return index;
    }

    private static int maxLengthIndex(String[] words) {
        int index = 0;
        int maxLen = Integer.MIN_VALUE;
        for (int i = 0; i < words.length; i++) {
            int length = words[i].replaceAll("\\p{P}", "").length();
            if (length > maxLen && length != 0) {
                maxLen = length;
                index = i;
            }
        }
        return index;
    }
}
