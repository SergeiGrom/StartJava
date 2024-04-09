public class IfElseStatementTheme {
    public static void main(String[] args) {
        System.out.println("1. Перевод псевдокода на язык Java:");
        boolean male = true;
        if (!male) {
            System.out.println("Вы не мужского пола!");
        } else {
            System.out.println("Красавчик!");
        }

        int age = 19;
        if (age > 18) {
            System.out.println("Учи Java!");
        } else {
            System.out.println("Учи Python!");
        }

        double height = 1.7;
        if (height < 1.8) {
            System.out.println("Не расстраивайся и записывайся на StartJava!");
        } else {
            System.out.println("Не смотри на всех свысока!");
        }

        char nameFirstLetter = "Name".charAt(0);
        if (nameFirstLetter == 'M') {
            System.out.println("Первая буква имени - M\n");
        } else if (nameFirstLetter == 'I') {
            System.out.println("Первая буква имени - I\n");
        } else {
            System.out.println("Ты не ментор! Иди и учи Java!\n");
        }

        System.out.println("2. Поиск большего числа:");
        int ageRobert = 80;
        int ageMartin = 80;
        int ageDifference = ageRobert - ageMartin;
        if (ageDifference == 0) {
            System.out.printf("Число %s равно %s%n%n", ageRobert, ageMartin);
        } else if (ageDifference < 0) {
            System.out.printf("Число %s меньше %s%n%n", ageRobert, ageMartin);
        } else {
            System.out.printf("Число %s больше %s%n%n", ageRobert, ageMartin);
        }

        System.out.println("3. Проверка числа:");
        int number = 8;
        if (number == 0) {
            System.out.println("Число равно 0\n");
        } else {
            System.out.print("Число " + number);
            if (number > 0) {
                System.out.print(" положительное ");
            } else {
                System.out.print(" отрицательное ");
            }
            if (number % 2 == 0) {
                System.out.println("и четное\n");
            } else {
                System.out.println("и нечетное\n");
            }
        }

        System.out.println("4. Поиск одинаковых цифр в числах:");
        int a = 213;
        int b = 223;
        boolean isEqualOnes = (a - b) % 10 == 0;
        boolean isEqualTens = ((a - b) / 10) % 10 == 0;
        boolean isEqualHundreds = (a - b) / 100 == 0;
        if (a == b) {
            System.out.printf("Числа %s и %s равны.\n", a, b);
        } else if (!isEqualOnes && !isEqualTens && !isEqualHundreds) {
            System.out.printf("У чисел %s и %s отсутствуют одинаковые цифры, стоящие в одном" + 
                    " и том же разряде.\n", a, b);
        } else {
            System.out.printf("У чисел %s и %s равны:\n", a, b);
            if (isEqualOnes) {
                System.out.printf("%s в первом разряде\n", a % 10);
            } 
            if (isEqualTens) {
                System.out.printf("%s во втором разряде\n", a / 10 % 10);
            }
            if (isEqualHundreds) {
                System.out.printf("%s в третьем разряде\n", a / 100);
            }
        }

        System.out.println("\n5. Определение символа по его коду:");
        char symbol = '\u005E';
        boolean isLowercase = symbol >= 'a' && symbol <= 'z';
        boolean isUppercase = symbol >= 'A' && symbol <= 'Z';
        boolean isDigit = symbol >= '0' && symbol <= '9';
        if (isDigit) {
            System.out.printf("Символ %s - цифра.\n\n", symbol);
        } else if (isLowercase) {
            System.out.printf("Символ %s - маленькая буква.\n\n", symbol);
        } else if (isUppercase) {
            System.out.printf("Символ %s - большая буква.\n\n", symbol);
        } else {
            System.out.printf("Символ %s - не буква и не цифра.\n\n", symbol);
        }

        System.out.println("6. Подсчет суммы вклада и начисленных банком %:");
        double originalDeposite = 1000;
        double rate = 5;
        if (originalDeposite >= 100000 & originalDeposite <= 300000) {
            rate = 7;
        } else if (originalDeposite > 300000) {
            rate = 10;
        }
        double rateAmount = (rate / 100) * originalDeposite;
        double yearDeposite = originalDeposite + rateAmount;
        System.out.printf("Сумма вклада = %,.2f, рублей\n" + 
                "Сумма начисленного процента за год = %,.2f, рублей\n" + 
                "Итоговая сумма с процентами за год = %,.2f, рублей%n%n", 
                originalDeposite, rateAmount, yearDeposite);

        System.out.println("7. Определение оценки по предметам:");
        int historyPercent = 59;
        int historyGrade = 2;
        if (historyPercent > 60 & historyPercent <= 73) {
            historyGrade = 3;
        } else if (historyPercent > 73 & historyPercent <= 91) {
            historyGrade = 4;
        } else if (historyPercent > 91 & historyPercent <= 100) {
            historyGrade = 5;
        }
        System.out.println("История оценка " + historyGrade);
        int csPercent = 92;
        int csGrade = 2;
        if (csPercent > 60 & csPercent <= 73) {
            csGrade = 3;
        } else if (csPercent > 73 & csPercent <= 91) {
            csGrade = 4;
        } else if (csPercent > 91 & csPercent <= 100) {
            csGrade = 5;
        }
        System.out.println("Программирование оценка " + csGrade);
        double gpa = (double) (historyGrade + csGrade) / 2;
        System.out.printf("Средний балл = %.1f%n", gpa);
        double avgPercent = (double) (historyPercent + csPercent) / 2;
        System.out.printf("Средний %% по предметам = %.1f%n%n", avgPercent);

        System.out.println("8. Расчет годовой прибыли:");
        double mounthSales = 13000;
        double mounthRent = 5000;
        double mounthProductionCost = 9000;
        double yearProfit = (mounthSales - mounthRent - mounthProductionCost) * 12;
        if (yearProfit > 0) {
            System.out.printf("Прибыль за год: %+,.2f руб.%n", yearProfit);
        } else {
            System.out.printf("Прибыль за год: %,.2f руб.%n", yearProfit);
        }
    }
}