public class VariablesTheme {
    public static void main(String[] args) {
        System.out.println("1. Вывод характеристик компьютера:");
        boolean hasEthernetPort = true;
        System.out.printf("Наличие Ethernet порта : %s%n", hasEthernetPort);
        byte numberCpuCore = 8;
        System.out.printf("Количество ядер процессора = %s%n", numberCpuCore);
        short ramCapacityMbyte = 8192;
        System.out.printf("Емкость оперативной памяти, Мбайт = %s%n", ramCapacityMbyte);
        int hddCapacityMbyte = 102400;
        System.out.printf("Емкость жесткого диска, Мбайт = %s%n", hddCapacityMbyte);
        long vramCapacityMbyte = 16384L;
        System.out.printf("Емкость оперативной памяти видеоадаптера, Мбайт = %s%n", vramCapacityMbyte);
        char biosRevision = 'B';
        System.out.printf("Текущая ревизия BIOS : %s%n", biosRevision);
        float clockSpeedGhz = 1.2F;
        System.out.printf("Частота процессора, ГГц = %s%n", clockSpeedGhz);
        double gFlops = 150.5;
        System.out.printf("Производительность компьютера, ГФлопс = %s%n%n", gFlops);

        System.out.println("2. Расчет стоимости товара со скидкой:");
        double penPrice = 100;
        double bookPrice = 200;
        double discountPercent = 11;
        double totalPrice = penPrice + bookPrice;
        double totalPriceAfterDiscount = totalPrice * (1 - discountPercent / 100);
        double discountPrice = totalPrice - totalPriceAfterDiscount;
        System.out.printf("Общая стоимость товаров без скидки = %s руб.%n", totalPrice);
        System.out.printf("Сумма скидки = %s руб.%n", discountPrice);
        System.out.printf("Общая стоимость товаров со скидкой = %s руб.%n%n", totalPriceAfterDiscount);

        System.out.println("3. Вывод слова JAVA:");
        System.out.println("   J    a  v     v  a\n" +
                "   J   a a  v   v  a a\n" +
                "J  J  aaaaa  V V  aaaaa\n" +
                " JJ  a     a  V  a     a\n");

        System.out.println("4. Вывод min и max значений целых числовых типов:");
        byte byteMax = Byte.MAX_VALUE;
        System.out.printf("максимальное значение переменной типа byte = %s%n", byteMax);
        System.out.printf("значение этой переменной после инкремента на 1 = %s%n", ++byteMax);
        System.out.printf("значение этой переменной после декремента на 1 = %s%n", --byteMax);
        short shortMax = Short.MAX_VALUE;
        System.out.printf("максимальное значение переменной типа short = %s%n", shortMax);
        System.out.printf("значение этой переменной после инкремента на 1 = %s%n", ++shortMax);
        System.out.printf("значение этой переменной после декремента на 1 = %s%n", --shortMax);
        int intMax = Integer.MAX_VALUE;
        System.out.printf("максимальное значение переменной типа int = %s%n", intMax);
        System.out.printf("значение этой переменной после инкремента на 1 = %s%n", ++intMax);
        System.out.printf("значение этой переменной после декремента на 1 = %s%n", --intMax);
        long longMax = Long.MAX_VALUE;
        System.out.printf("максимальное значение переменной типа long = %s%n", longMax);
        System.out.printf("значение этой переменной после инкремента на 1 = %s%n", ++longMax);
        System.out.printf("значение этой переменной после декремента на 1 = %s%n%n", --longMax);

        System.out.println("5. Перестановка значений переменных:");
        int a = 2;
        int b = 5;
        System.out.printf("исходные значения переменных = %s и %s%n", a, b);
        int swap = b;
        b = a;
        a = swap;
        System.out.printf("с помощью третьей переменной = %s и %s%n", a, b);
        a += b;
        b = a - b;
        a -= b;
        System.out.printf("с помощью арифметических операций = %s и %s%n", a, b);
        a ^= b;
        b ^= a;
        a ^= b;
        System.out.printf("с помощью побитовой операции ^ = %s и %s%n%n", a, b);

        System.out.println("6. Вывод символов и их кодов:");
        char dollar = '$';
        char asterisk = '*';
        char atSign = '@';
        char verticalBar = '|';
        char tilde = '~';
        System.out.println(dollar + " " + (int) dollar);
        System.out.println(asterisk + " " + (int) asterisk);
        System.out.println(atSign + " " + (int) atSign);
        System.out.println(verticalBar + " " + (int) verticalBar);
        System.out.println(tilde + " " + (int) tilde + "\n");

        System.out.println("7. Вывод в консоль ASCII-арт Дюка:");
        char slash = '/';
        char backslash = '\\';
        char underscore = '_';
        char leftParenthesis = '(';
        char rightParenthesis = ')';
        System.out.println("    " + slash + backslash + "\n" +
                "   " + slash + "  " + backslash + "\n" +
                "  " + slash + underscore + leftParenthesis + " " +
                rightParenthesis + backslash + "\n" +
                " " + slash + "      " + backslash + " " + "\n" +
                slash + underscore + underscore + underscore + underscore + slash +
                backslash + underscore + underscore + backslash + "\n");

        System.out.println("8. Вывод количества сотен, десятков и единиц числа:");
        int srcNumber = 124;
        int ones = srcNumber % 10;
        int tens = srcNumber / 10 % 10;
        int hundreds = srcNumber / 100;
        System.out.printf("Число %s содержит:\n  сотен - %s\n  десятков - %s\n  единиц - %s\n",
                srcNumber, hundreds, tens, ones);
        System.out.printf("Сумма его цифр = %s%n", ones + tens + hundreds);
        System.out.printf("Произведение = %s%n%n", ones * tens * hundreds);

        System.out.println("9. Вывод времени:");
        int time = 86399;
        int hh = time / 3600;
        int mm = (time % 3600) / 60;
        int ss = time % 60;
        System.out.printf("%02d:%02d:%02d", hh, mm, ss);
    }
}