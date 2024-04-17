import java.util.Scanner;

public class GuessNumberTest {
    public static void main(String[] args) {
        System.out.println("\nИгра Угадай число от (0 до 100]:");
        Player player1 = new Player(1);
        Player player2 = new Player(2);
        System.out.printf("Введите имя %d игрока : ", player1.getIndex());
        Scanner scanner = new Scanner(System.in);
        player1.setName(scanner.nextLine());
        System.out.printf("Введите имя %d игрока : ", player2.getIndex());
        player2.setName(scanner.nextLine());
        GuessNumber guessNumber = new GuessNumber(player1, player2);
        String exitGame;
        do {
            guessNumber.game();
            do {
                System.out.print("\nХотите продолжить игру? [yes/no]: ");
                exitGame = scanner.nextLine();
            } while (!exitGame.equals("no") && !exitGame.equals("yes"));
        } while (!exitGame.equals("no"));
        scanner.close();
    }
}
