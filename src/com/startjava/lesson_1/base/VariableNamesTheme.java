package com.startjava.lesson_1.base;

public class VariableNamesTheme {
    @SuppressWarnings("checkstyle:LocalVariableName")
    public static void main(String[] args) {
        System.out.println("1. Разные переменные");
        // цифра
        int digit = 2;
        System.out.printf("цифра = %s%n", digit);

        // сумма чисел
        double sumNumbers = digit + 5.5555555;
        System.out.printf("сумма чисел = %s%n", sumNumbers);

        // произведение цифр
        int multiplicationDigits = digit * 8;
        System.out.printf("произведение цифр = %s%n", multiplicationDigits);

        // максимальное число
        int maxNumber = 2_147_483_647;
        System.out.printf("максимальное число = %s%n", maxNumber);

        // количество десятков
        int numberTens = (maxNumber / 10) % 10;
        System.out.printf("количество десятков = %s%n", numberTens);

        // вес собаки
        double dogWeight = 7.656;
        System.out.printf("вес собаки = %.3f%n", dogWeight);

        // исходное число
        double originalNumber = 1.1111;
        System.out.printf("исходное число = %s%n", originalNumber);

        // процент по вкладу
        double percentOnDeposite = 1.8;
        System.out.printf("процент по вкладу = %s%n", percentOnDeposite);

        // переменная хранит символ &
        char ampersand = '&';
        System.out.printf("переменная хранит символ = %s%n", ampersand);

        // код ошибки
        int errorCode = 404;
        System.out.printf("код ошибки = %s%n", errorCode);

        // тип сообщения
        char messageType = 'A';
        System.out.printf("тип сообщения = %s%n", messageType);

        // число нулей
        int zerosNumber = 777;
        System.out.printf("число нулей = %s%n", zerosNumber);

        // уникальное число
        double uniqueNumber = 666.666;
        System.out.printf("уникальное число = %s%n", uniqueNumber);

        // случайное число
        double randomNumber = (double) Math.random();
        System.out.printf("случайное число = %s%n", randomNumber);
        
        // математическое выражение
        double mathExpression = Math.pow(randomNumber, 2);
        System.out.printf("математическое выражение = %s%n", mathExpression);

        // выбор
        double option = Math.abs(randomNumber);
        System.out.printf("выбор = %s%n", option);

        // счет в игре
        int gameScore = 0;
        System.out.printf("счет в игре = %s:%s%n", gameScore, gameScore);

        // максимальная длина
        long maxLength = (long) Math.pow(maxNumber, 2);
        System.out.printf("максимальная длина = %s%n", maxLength);

        // пункт меню
        int menuItem = 5;
        System.out.printf("пункт меню = %s%n", menuItem);

        // стоимость кофе на вынос
        double takeawayCoffeePrice = 2.5;
        System.out.printf("стоимость кофе на вынос = %s%n", takeawayCoffeePrice);

        // дата начала
        int startDate = 20;
        System.out.printf("дата начала = %s%n%n", startDate);

        System.out.println("2. boolean-переменные");
        // сотни равны?
        boolean isEqualHundreds = true;
        System.out.printf("сотни равны? : %s%n", isEqualHundreds);

        // компьютер включен?
        boolean isComputerOn = true;
        System.out.printf("компьютер включен? : %s%n", isComputerOn);

        // есть равные цифры?
        boolean hasEqualDigits = false;
        System.out.printf("есть равные цифры? : %s%n", hasEqualDigits);

        // создано?
        boolean isCreated = false;
        System.out.printf("создано? : %s%n", isCreated);

        // пустое?
        boolean isEmpty = true;
        System.out.printf("пустое? : %s%n", isEmpty);

        // активное?
        boolean isActive = true;
        System.out.printf("активное? : %s%n", isActive);

        // новое?
        boolean isNew = false;
        System.out.printf("новое? : %s%n", isNew);

        // электронная почта действительная?
        boolean isValidEmail = false;
        System.out.printf("электронная почта действительная? : %s%n", isValidEmail);

        // имеются уникальные строки?
        boolean hasUniqueRaws = true;
        System.out.printf("имеются уникальные строки? : %s%n%n", hasUniqueRaws);

        System.out.println("3. Аббревиатуры");
        // старый universally unique identifier
        int oldUuid = 1;
        System.out.printf("старый universally unique identifier = %s%n", oldUuid);

        // производитель оперативной памяти
        int ramManufacture = 777;
        System.out.printf("производитель оперативной памяти = %s%n", ramManufacture);

        // емкость жесткого диска
        int hddCapacity = 1024;
        System.out.printf("емкость жесткого диска = %s%n", hddCapacity);

        // протокол передачи гипертекста
        int http = 3;
        System.out.printf("протокол передачи гипертекста = %s%n", http);

        // сокращенный uniform resource locator
        int shortUrl = 0;
        System.out.printf("сокращенный uniform resource locator = %s%n", shortUrl);

        // новый идентификатор клиента
        long newCid = 10000000000000000L;
        System.out.printf("новый идентификатор клиента = %s%n", newCid);

        // кодировка american standard code for information interchange
        char encodingAscii = 1;
        System.out.printf("кодировка american standard code for information interchange = %s%n", 
                encodingAscii);
    }
}