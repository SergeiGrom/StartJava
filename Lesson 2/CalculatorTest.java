import java.util.Scanner;

public class CalculatorTest {
    public static void main(String[] args) {
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
            System.out.printf("Результат вычисления: %.3f\n", calc.checkSign());
            sc.nextLine();
            String text;
            do {
                System.out.print("Хотите продолжить вычисления? [yes/no]: ");
                text = sc.nextLine();
                if (text.equals("no")) {
                    System.exit(0);
                }
            } while (!text.equals("yes"));
        }
    }
}