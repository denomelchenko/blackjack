package blackjack;

import blackjack.player.Dealer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DealerTest {

    @Test
    void dealerStartsWithEmptyHand() {
        Dealer dealer = new Dealer();
        assertEquals(0, dealer.getHand().getCards().size());
        assertEquals(0, dealer.getScore());
    }

    @Test
    void dealerCanAddCard() {
        Dealer dealer = new Dealer();
        dealer.addCard(new blackjack.model.Card(
                blackjack.model.Suit.SPADES,
                blackjack.model.Rank.ACE
        ));
        assertEquals(1, dealer.getHand().getCards().size());
    }
}