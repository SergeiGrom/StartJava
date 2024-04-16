import java.util.Scanner;

public class GuessNumberTest {
    public static void main(String[] args) {
        System.out.println("Игра Угадай число от (0 до 100]:");
        Scanner scanner = new Scanner();

        PLayer player1 = new Player(, 1);
        System.out.printf("Введите имя %d игрока : %s", player1.getIndex(), player1.setName(scanner.nextInt()));
        PLayer player2 = new Player(, 2);
        System.out.printf("Введите имя %d игрока : %s", player1.getIndex(), player2.setName(scanner.nextInt()));

        //TODO


    }
}