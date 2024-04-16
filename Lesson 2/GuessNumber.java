public class GuessNumber {
    int max = 100;
    int hiddenNum = 1 + (int) (Math.random() * max);
    int playerNum = max;
    int middle = (int) Math.round(playerNum / 2.0);
    public game() {
        while (playerNum != hiddenNum) {
            System.out.printf("Введено число %d\n", playerNum);
            // middle = (int) Math.round(middle / 2.0);
            if (playerNum > hiddenNum) {
                System.out.printf("Число %d больше того, что загадал компьютер\n\n", playerNum);
                playerNum -= middle;
            } else if (playerNum < hiddenNum) {
                System.out.printf("Число %d меньше того, что загадал компьютер\n\n", playerNum);
                playerNum += middle;
            }
        }
        System.out.println("!!!ВЫ ПОБЕДИЛИ!!!");
    }
}