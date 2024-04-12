import java.util.Scanner;

public class Calculator {
    public double inputA;
    public double inputB;
    public double result;
    public char sign;
    public String yesNo;
    public boolean isSign;

    public void setInputA(double inputA) {
        this.inputA = inputA;
    }

    public void setInputB(double inputB) {
        this.inputB = inputB;
    }

    public char getSign() {
        return sign;
    }

    public void setSign(char sign) {
        if (sign == '-' || sign == '+' || sign == '*' || sign == '/' || sign == '%' || sign == '^') {
            this.sign = sign;
            isSign = true;
        } else {
            System.out.print("Неверно задан знак математической операции!\n" +
                    "Выберите из списка [+ - * / % ^] и введите снова: ");
        }
    }

    

    public void setYesNo(String yesNo) {
        if (yesNo.equals("yes") || yesNo.equals("no")) {
            this.yesNo = yesNo;
        } else {
            System.out.print("Ошибка");
        }
    }

    public String getYesNo() {
        // System.out.println(yesNo);
        return yesNo;
    }

    public boolean isSign() {
        return isSign;
    }

    public void setIsSign(boolean isSign) {
        this.isSign = isSign;
    }

    public double check() {
        switch (sign) {
            case '+':
                result = inputA + inputB;
                break;
            case '-':
                result = inputA - inputB;
                break;
            case '*':
                result = inputA * inputB;
                break;
            case '/':
                result = inputA / inputB;
                break;
            case '^':
                result = 1;
                for (double i = 0; i < inputB; i++) {
                    result *= inputA;
                }
                break;
            case '%':
                result = inputA % inputB;
                break;
        }
        return result;
    }

    public void yn() {
        Scanner sc = new Scanner(System.in);
        String yes = "yes";
        String no = "no";
        String text = sc.nextLine();
        while (text.equals(yes) || text.equals(no)) {

            System.out.print("Хотите продолжить вычисления? [yes/no]: ");
        }
        // sc.close();
    }
}