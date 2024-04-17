import java.util.Scanner;

public class Calculator {
    public int inputA;
    public int inputB;
    public char sign;

    public void setInputA(int inputA) {
        this.inputA = inputA;
    }

    public void setInputB(int inputB) {
        this.inputB = inputB;
    }

    public char getSign() {
        return sign;
    }

    public boolean setSign(char sign) {
        this.sign = sign;
        return (sign == '-' || sign == '+' || sign == '*' || sign == '/' || sign == '%' || sign == '^') ? true : false;
    }

    public int calculate() {
        int result = 0;
        switch (sign) {
            case '+':
                return inputA + inputB;
            case '-':
                return inputA - inputB;
            case '*':
                return inputA * inputB;
            case '/':
                return inputA / inputB;
            case '^':
                result = 1;
                for (int i = 0; i < inputB; i++) {
                    result *= inputA;
                }
                break;
            case '%':
                return inputA % inputB;
        }
        return result;
    }
}