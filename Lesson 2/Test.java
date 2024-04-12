public class Test {
    public static void main(String[] args) {

int secret = 1 + (int)(Math.random() * 100);
System.out.println("Для теста secret="+secret);
            int guess = 50;
            // int lower;
            // int upper;
            System.out.printf(" Загадано число %d\n", guess);
            if (guess < 1 || guess > 100 ) {
                System.out.println("Вы вышли из интервала от 1 до 100");
            } else {
                while (guess != secret){
                    if (guess > secret) {
                        System.out.println("Число " + guess + " больше того, что загадал компьютер ");
                        // lower = guess + 1;
                        guess -= 1;
                    } else if (guess < secret) {
                        System.out.println("Число " + guess + " меньше того, что загадал компьютер ");
                        // upper = guess - 1;
                        guess +=1;
                   
                }
                System.out.println("Вы угадали число");
            }
        }
    }
}