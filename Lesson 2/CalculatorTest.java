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
        // Scanner scanner = new Scanner(System.in);
        System.out.print("Введите первое число: ");
        // calc.setInputA = scanner.nextDouble();
        calc.setInputA(10);
        // scanner.nextLine();
        System.out.print("Введите знак математической операции: ");
        // calc.setSign = scanner.nextLine();
        calc.setSign("-");
        System.out.print("Введите второе число: ");
        // calc.setInputB = scanner.nextDouble();
        calc.setInputB(10);
        // scanner.nextLine();
        System.out.println("Результат вычисления: " + calc.check());
        System.out.println("Хотите продолжить вычисления? [yes/no]: ");
        // yesNo = scanner.nextLine();
    }
}