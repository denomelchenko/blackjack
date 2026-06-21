package blackjack;

import blackjack.model.*;
import blackjack.player.Dealer;
import blackjack.player.Player;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BlackjackGameTest {

    @Test
    void playerBustLosesRegardless() {
        Player player = new Player("Test", 1000);
        Dealer dealer = new Dealer();
        player.addCard(new Card(Suit.SPADES, Rank.KING));
        player.addCard(new Card(Suit.HEARTS, Rank.KING));
        player.addCard(new Card(Suit.DIAMONDS, Rank.FIVE));
        dealer.addCard(new Card(Suit.SPADES, Rank.TWO));
        dealer.addCard(new Card(Suit.HEARTS, Rank.THREE));
        RoundResult result = BlackjackGame.determineWinner(player, dealer);
        assertEquals(RoundResult.DEALER_WINS, result);
    }
}