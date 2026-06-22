package blackjack;
import java.util.Scanner;
import blackjack.player.Player;
import blackjack.model.Deck;
import blackjack.player.Dealer;

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

        System.out.println("\n=== GAME OVER ===");
        System.out.println("Final balance: $" + player.getBalance());
        if (player.getBalance() > 1000) {
            System.out.println("You won $" + (player.getBalance() - 1000) + "!");
        } else if (player.getBalance() < 1000) {
            System.out.println("You lost $" + (1000 - player.getBalance()) + ".");
        } else {
            System.out.println("You broke even!");
        }
    }

    private static boolean playRound(Player player) {
        System.out.println("\n--- New Round ---");
        System.out.println("Balance: $" + player.getBalance());
        System.out.print("Place your bet (1-" + player.getBalance() + "): ");

        int bet;
        try {
            bet = Integer.parseInt(scanner.nextLine().trim());
            player.placeBet(bet);
        } catch (Exception e) {
            System.out.println("Invalid bet!");
            return true;
        }

        Deck deck = new Deck();
        deck.shuffle();
        Dealer dealer = new Dealer();
        player.resetHand();

        BlackjackGame.dealInitialCards(player, dealer, deck);

        System.out.println("\nYour hand: " + player.getHand().getCards() + " = " + player.getScore());
        System.out.println("Dealer shows: " + dealer.getHand().getCards().get(0) + " [?]");

        if (player.getHand().isBlackjack()) {
            System.out.println("\nBLACKJACK! You win!");
            player.win();
            System.out.println("Balance: $" + player.getBalance());
            return true;
        }

        boolean playerTurn = true;
        while (playerTurn && !player.getHand().isBust()) {
            System.out.print("\nYour move: (h)it / (s)tand: ");
            String move = scanner.nextLine().trim().toLowerCase();
            if (move.equals("h")) {
                player.addCard(deck.deal());
                System.out.println("Your hand: " + player.getHand().getCards() + " = " + player.getScore());
                if (player.getHand().isBust()) {
                    System.out.println("BUST! You exceeded 21.");
                }
            } else if (move.equals("s")) {
                playerTurn = false;
            } else {
                System.out.println("Enter 'h' (hit) or 's' (stand).");
            }
        }

        if (!player.getHand().isBust()) {
            System.out.println("\nDealer's hand: " + dealer.getHand().getCards());
            dealer.drawUntilSeventeen(deck);
            System.out.println("Dealer draws... Hand: " + dealer.getHand().getCards() + " = " + dealer.getScore());
        }

        RoundResult result = BlackjackGame.determineWinner(player, dealer);

        System.out.println("\n--- RESULT ---");
        System.out.println("You: " + player.getScore() + " | Dealer: " + dealer.getScore());

        switch (result) {
            case PLAYER_WINS -> { System.out.println("You win!"); player.win(); }
            case PLAYER_BLACKJACK -> { System.out.println("BLACKJACK! You win 3:2!"); player.win(); }
            case DEALER_WINS -> { System.out.println("Dealer wins."); player.lose(); }
            case PUSH -> { System.out.println("Push!"); }
        }

        System.out.println("Balance: $" + player.getBalance());
        return true;
    }
}