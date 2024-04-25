import java.util.Scanner;

public class GuessNumber {
    private Player player1;
    private Player player2;
    Scanner scanner = new Scanner(System.in);

    public GuessNumber(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public void start() {
        int hiddenNum = 1 + (int) (Math.random() * 100);
        while (true) {
            inputNumber(player1);
            if (isGussed(player1, hiddenNum)) {
                break;
            }
            inputNumber(player2);
            if (isGussed(player2, hiddenNum)) {
                break;
            }
        }
    }

    public void inputNumber(Player player) {
        System.out.printf("\nХодит %s.\nВведите число: ", player.getName());
            player.setNumber(scanner.nextInt());
            scanner.nextLine();
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
