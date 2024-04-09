public class CyclesTheme {
    public static void main(String[] args) {
        System.out.println("1. Подсчет суммы четных и нечетных чисел:");
        int start = -10;
        int end = 21;
        int sumEven = 0;
        int sumOdd = 0;
        System.out.printf("В отрезке [%d, %d] сумма ", start, end);
        do {
            if (start % 2 == 0) {
                sumEven += start;
            } else {
                sumOdd += start;
            }
            start++;
        } while (start <= end);
        System.out.printf("четных чисел = %d, а нечетных = %d%n%n", sumEven, sumOdd);

        System.out.println("2. Вывод чисел в порядке убывания:");
        int a = 10;
        int b = 5;
        int c = -1;
        int max = a;
        int min = b;
        if (a < b) {
            max = b;
            min = a;
        }
        if (c < min) {
            min = c;
        } else if (c > max) {
            max = c;
        }
        for (int i = --max; i > min; i--) {
            System.out.print(i + " ");
        }

        System.out.println("\n\n3. Вывод реверсивного числа и суммы его цифр:");
        int srcNumber = 1234;
        int sum = 0;
        while (srcNumber > 0) {
            int lastDigit = srcNumber % 10;
            srcNumber /= 10;
            sum += lastDigit;
            System.out.print(lastDigit);
        }
        System.out.print("\n" + sum);

        System.out.println("\n\n4. Вывод чисел в несколько строк:");
        int countNums = 0;
        for (int i = 1; i < 24; i += 2) {
            countNums++;
            System.out.printf("%5d", i);
            if (countNums > 1 && countNums % 5 == 0) {
                System.out.println();
            }
        }
        if (countNums % 5 != 0) {
            for (int i = 5 - (countNums % 5); i > 0; i--) {
                System.out.printf("%5d", 0);
            }
        }

        System.out.println("\n\n5. Проверка количества двоек числа на четность/нечетность");
        srcNumber = 3242592;
        System.out.print("В " + srcNumber);
        int countTwos = 0;
        while (srcNumber > 0) {
            if (srcNumber % 10 == 2) {
                countTwos++;
            }
            srcNumber /= 10;
        }
        if (countTwos % 2 == 0) {
            System.out.printf(" четное количество двоек - %s%n%n", countTwos);
        } else {
            System.out.printf(" нечетное количество двоек - %s%n%n", countTwos);
        }

        System.out.println("6. Отображение геометрических фигур:");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println();
        int lines = 5;
        while (lines >= 1) {
            int symbols = 1;
            while (symbols <= lines) {
                System.out.print("#");
                symbols++;
            }
            System.out.println();
            lines--;
        }

        System.out.println();
        int srcWidth = 3;
        int srcRows = 5;
        int countRows = 1;
        int countWidth = 1;
        do {
            int countSymbols = 0;
            do {
                System.out.print("$");
                countSymbols++;
            } while (countSymbols < countWidth);
            System.out.println();
            int addOne = (countRows < srcWidth) ? 1 : -1;
            countWidth += addOne;
            countRows++;
        } while (countRows <= srcRows);

        System.out.println("\n7. Отображение ASCII-символов:");
        System.out.printf("%s %5s %5s%n", "DECIMAL", "CHARACTER", "DESCRIPTION");
        for (char i = 33; i <= 47; i++) {
            if (i % 2 != 0) {
                System.out.printf("%4d %8c\t\t%-24s%n", (int) i, i, Character.getName(i));
            }
        }
        for (char i = 97; i <= 122; i++) {
            if (i % 2 == 0) {
                System.out.printf("%4d %8c\t\t%-24s%n", (int) i, i, Character.getName(i));
            }
        }

        System.out.println("\n8. Проверка, является ли число палиндромом:");
        srcNumber = 1234321;
        System.out.printf("Число %d ", srcNumber);
        int reversed = 0;
        int srcNum = srcNumber;
        while (srcNum > 0) {
            int lastDigit = srcNum % 10;
            reversed = (reversed * 10) + lastDigit;
            srcNum /= 10;
        }
        if (reversed == srcNumber) {
            System.out.println("является палиндромом\n");
        } else {
            System.out.println("не является палиндромом\n");
        }

        System.out.println("9. Проверка, является ли число счастливым:");
        srcNumber = 124232;
        int rightHalf = srcNumber % 1000;
        int leftHalf = srcNumber / 1000;
        int sumRight = 0;
        int sumLeft = 0;
        System.out.print("Число " + srcNumber);
        for (int i = 0; i < 3; i++) {
            sumRight += rightHalf % 10;
            sumLeft += leftHalf % 10;
            rightHalf /= 10;
            leftHalf /= 10;
        }
        if (sumRight == sumLeft) {
            System.out.println(" является счастливым");
        } else {
            System.out.println(" не является счастливым");
        }
        System.out.printf("Сумма цифр %d = %d, а сумма %d = %d\n\n",
                srcNumber % 1000, sumRight, + srcNumber / 1000, sumLeft);

        System.out.println("10. Отображение таблицы умножения Пифагора:");
        System.out.printf("\t%s", "ТАБЛИЦА ПИФАГОРА\n");
        for (int i = 1; i <= 9; i++) {
            if (i == 1) {
                System.out.printf("%4c", '|');
                for (int j = 2; j <= 9; j++) {
                    System.out.printf("%3d", j);
                }
                System.out.println();
                for (int j = 0; j < 29; j++) {
                    System.out.print('=');
                }
                System.out.println();
            } else {
                System.out.printf("%2d %c", i, '|');
                for (int j = 2; j <= 9; j++) {
                    System.out.printf("%3d", i * j);
                }
                System.out.println();
            }
        }
    }
}