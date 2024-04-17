public class MyFirstGame {
    public static void main(String[] args) {
        System.out.println("Игра Угадай число от (0 до 100]:");
        int max = 100;
        int hiddenNum = 1 + (int) (Math.random() * max);
        int playerNum = max / 2;
        int middle = playerNum;
        while (playerNum != hiddenNum) {
            System.out.printf("Введено число %d\n", playerNum);
            middle = (int) Math.round(middle / 2.0);
            if (playerNum > hiddenNum) {
                System.out.printf("Число %d больше того, что загадал компьютер\n\n", playerNum);
                playerNum -= middle;
            } else if (playerNum < hiddenNum) {
                System.out.printf("Число %d меньше того, что загадал компьютер\n\n", playerNum);
                playerNum += middle;
            }
        }
        System.out.printf("Введено число %d\n!!!ВЫ ПОБЕДИЛИ!!!", playerNum);
    }
}