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
    }
}