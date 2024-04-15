import java.util.Scanner;

public class Calculator {
    public double inputA;
    public double inputB;
    public double result;
    public char sign;
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

    public boolean isSign() {
        return isSign;
    }

    public void setIsSign(boolean isSign) {
        this.isSign = isSign;
    }

    public double checkSign() {
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
}