import java.util.Scanner;

public class GuessNumber {
    private Player player1;
    private Player player2;

    public GuessNumber(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public void start() {
        int hiddenNum = 1 + (int) (Math.random() * 100);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.printf("\nХодит %s.\nВведите число: ", player1.getName());
            player1.setNumber(scanner.nextInt());
            scanner.nextLine();
            if (isGussed(player1, hiddenNum)) {
                break;
            }
            System.out.printf("\nХодит %s.\nВведите число: ", player2.getName());
            player2.setNumber(scanner.nextInt());
            scanner.nextLine();
            if (isGussed(player2, hiddenNum)) {
                break;
            }
        }
    }

    public boolean isGussed(Player player, int hiddenNum) {
        if (player.getNumber() == hiddenNum) {
            System.out.printf("\nПОБЕДИЛ %s\n", player.getName());
            return true;
        }
        System.out.printf("\nЧисло %d %s того, что загадал компьютер\n", player.getNumber(),
                player.getNumber() > hiddenNum ? "больше" : "меньше");
        return false;
    }
}
