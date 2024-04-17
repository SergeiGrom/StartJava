import java.util.Scanner;

public class GuessNumber {
    Player player1;
    Player player2;

    public GuessNumber(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public void game() {
        Scanner scanner = new Scanner(System.in);
        int hiddenNum = 1 + (int) (Math.random() * 100);
        int playerNum = 0;
        int counter = 0;
        while (playerNum != hiddenNum) {
            counter += 1;
            System.out.printf("\nХодит %s : ", counter % 2 != 0 ? player1.getName() : player2.getName());
            playerNum = scanner.nextInt();
            scanner.nextLine();
            if (playerNum > hiddenNum) {
                System.out.printf("\nЧисло %d больше того, что загадал компьютер\n", playerNum);
            } else if (playerNum < hiddenNum) {
                System.out.printf("\nЧисло %d меньше того, что загадал компьютер\n", playerNum);
            }
        }
        System.out.printf("\nПОБЕДИЛ : %s\n", counter % 2 != 0 ? player1.getName() : player2.getName());
    }
}
