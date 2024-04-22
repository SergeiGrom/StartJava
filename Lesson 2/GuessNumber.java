import java.util.Scanner;

public class GuessNumber {
    private Player player1;
    private Player player2;

    public GuessNumber(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public void start() {
        int playerNum = 0;
        int hiddenNum = 1 + (int) (Math.random() * 100);
        Scanner scanner = new Scanner(System.in);
        while (playerNum != hiddenNum) {
            System.out.printf("\nХодит %s.\nВведите число: ", player1.getName());
            player1.setPlayerNum(scanner.nextInt());
            scanner.nextLine();
            playerNum = player1.getPlayerNum();
            if (!checkNum(hiddenNum, playerNum)) {
                System.out.printf("\nХодит %s.\nВведите число: ", player2.getName());
                player2.setPlayerNum(scanner.nextInt());
                scanner.nextLine();
                playerNum = player2.getPlayerNum();
                checkNum(hiddenNum, playerNum);
            }
        }
    }

    public boolean checkNum(int hiddenNum, int playerNum) {
        if (playerNum > hiddenNum) {
            System.out.printf("\nЧисло %d больше того, что загадал компьютер\n", playerNum);
        } else if (playerNum < hiddenNum) {
            System.out.printf("\nЧисло %d меньше того, что загадал компьютер\n", playerNum);
        } else {
            System.out.printf("\nПОБЕДИЛ : %s\n", (player1.getPlayerNum() == hiddenNum) ? player1.getName() : player2.getName());
            return true;
        }
        return false;
    }
}
