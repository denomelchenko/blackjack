package blackjack;

import blackjack.model.Deck;
import blackjack.player.Dealer;
import blackjack.player.Player;

public class BlackjackGame {

    public static RoundResult determineWinner(Player player, Dealer dealer) {
        if (player.getHand().isBust()) {
            return RoundResult.DEALER_WINS;
        }
        if (dealer.getHand().isBust()) {
            return RoundResult.PLAYER_WINS;
        }
        if (player.getHand().isBlackjack() && !dealer.getHand().isBlackjack()) {
            return RoundResult.PLAYER_BLACKJACK;
        }

        int playerScore = player.getScore();
        int dealerScore = dealer.getScore();

        if (playerScore > dealerScore) {
            return RoundResult.PLAYER_WINS;
        } else if (dealerScore > playerScore) {
            return RoundResult.DEALER_WINS;
        } else {
            return RoundResult.PUSH;
        }
    }

    public static void dealInitialCards(Player player, Dealer dealer, Deck deck) {
        player.addCard(deck.deal());
        dealer.addCard(deck.deal());
        player.addCard(deck.deal());
        dealer.addCard(deck.deal());
    }
}