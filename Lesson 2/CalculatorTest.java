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
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("Введите первое число: ");
            calc.setInputA(sc.nextDouble());
            sc.nextLine();
            System.out.print("Введите знак математической операции: ");
            while (calc.isSign() != true) {
                calc.setSign(sc.nextLine().charAt(0));
            }
            calc.setIsSign(false);
            System.out.print("Введите второе число: ");
            calc.setInputB(sc.nextDouble());
            System.out.printf("Результат вычисления: %.3f\n", calc.check());
            // sc.nextLine();
            // while (!sc.nextLine().equals("yes") && !sc.nextLine().equals("no")); {
            //     System.out.print("Хотите продолжить вычисления? [yes/no]:");
            // }
            calc.yn();
            if (sc.nextLine().equals("no")) {
                break;
            }
        }
    }
}