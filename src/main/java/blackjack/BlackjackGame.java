package blackjack;

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
        return null;
    }
}