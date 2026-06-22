package blackjack;
import java.util.Scanner;
import blackjack.player.Player;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("╔══════════════════════════╗");
        System.out.println("║        BLACKJACK         ║");
        System.out.println("╚══════════════════════════╝");
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        Player player = new Player(name, 1000);
        System.out.println("\nWelcome, " + name + "! Your balance: $" + player.getBalance());

        boolean playing = true;
        while (playing && player.getBalance() > 0) {
            playing = playRound(player);
            if (playing) {
                System.out.print("\nPlay again? (y/n): ");
                String answer = scanner.nextLine().trim().toLowerCase();
                playing = answer.equals("y");
            }
        }
    }

    private static boolean playRound(Player player) {
        System.out.println("\n--- New Round ---");
        return true;
    }
}