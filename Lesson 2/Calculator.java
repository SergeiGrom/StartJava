public class Calculator {
    public int inputA;
    public int inputB;
    public int result;
    public String sign;
    public String yesNo;
    public boolean isSign; //= sign == "+";// || sign == "-" || sign == "*" || sign == "/" || sign == "%" || sign == "^";

    // public Calculator(double inputA, double inputB, double result, String sign) {
    //     this.inputA = inputA;
    //     this.inputB = inputB;
    //     this.result = result;
    //     this.sign = sign;
    //     this.yesNo = yesNo;
    // }

    public void setInputA(int inputA) {
        this.inputA = inputA;
    }

    public void setInputB(int inputB) {
        this.inputB = inputB;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        if (sign == "+" || sign == "-" || sign == "*" || sign == "/" || sign == "%" || sign == "^") {
            isSign = true;
            
        } else {
            System.out.print("Неверно задан знак мат. операции!\n" +
                    "Выберите из списка [+ - * / % ^] : ");
        }
        this.sign = sign;
    }

    public boolean isSign() {
        return isSign;
    }

    public int check() {
        switch (sign) {
            case "+":
                result = inputA + inputB;
                break;
            case "-":
                result = inputA - inputB;
                break;
            case "*":
                result = inputA * inputB;
                break;
            case "/":
                result = inputA / inputB;
                break;
            case "^":
                for (int i = 0; i < inputB; i++) {
                    result *= inputA;
                }
                break;
            case "%":
                result = inputA % inputB;
                break;
            default:
                
                break;
        }
        return result;

    }
}