import java.util.Scanner;

public class CalculatorTest {
    public static void main(String[] args) {
        //TODO
        // код, отвечающий за:
        // создание объектов
        // их инициализацию
        // ввод математического выражения
        // запуск вычислений
        // обработку ответа пользователя о продолжении/завершении
        
        Calculator calc = new Calculator();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите первое число: ");
        calc.setInputA(scanner.nextInt());
        // calc.setInputA(10);
        scanner.nextLine();
        System.out.print("Введите знак математической операции: ");
        do {
            calc.setSign(scanner.nextLine());
            System.out.println(calc.isSign());
        } while (calc.isSign(false));
        System.out.println(calc.isSign());
        // scanner.nextLine();
        // calc.setSign("-");
        System.out.println(calc.getSign());
        System.out.print("Введите второе число: ");
        calc.setInputB(scanner.nextInt());
        // calc.setInputB(10);
        // scanner.nextLine();
        System.out.println(calc.getResult());
        System.out.println("Результат вычисления: " + calc.check());
        System.out.println(calc.getResult());
        System.out.println("Хотите продолжить вычисления? [yes/no]: ");
        // yesNo = scanner.nextLine();
    }
}