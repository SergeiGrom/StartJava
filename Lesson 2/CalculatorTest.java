import java.util.Scanner;

public class CalculatorTest {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        Scanner sc = new Scanner(System.in);
        String exitCalc;
        do {
            System.out.print("Введите первое число: ");
            calc.setInputA(sc.nextInt());
            sc.nextLine();
            do {
                System.out.print("Введите знак математической операции [+ - * / % ^] : ");
            }
            while (!calc.setSign(sc.nextLine().charAt(0)));
            System.out.print("Введите второе число: ");
            calc.setInputB(sc.nextInt());
            System.out.printf("Результат вычисления: %d\n", calc.calculate());
            sc.nextLine();
            do {
                System.out.print("Хотите продолжить вычисления? [yes/no]: ");
                exitCalc = sc.nextLine();
            } while (!exitCalc.equals("yes") && !exitCalc.equals("no"));
        }
        while (!exitCalc.equals("no"));
        sc.close();
    }
}