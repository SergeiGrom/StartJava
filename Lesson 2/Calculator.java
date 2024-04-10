public class Calculator {
    public int inputA;
    public int inputB;
    public int result;
    public String sign;
    public String yesNo;

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

    public double getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public void setSign(String sign) {
        this.sign = sign;
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
        }
        return result;
    }
}