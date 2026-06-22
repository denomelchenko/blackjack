package blackjack;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("╔══════════════════════════╗");
        System.out.println("║        BLACKJACK         ║");
        System.out.println("╚══════════════════════════╝");
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
    }
}