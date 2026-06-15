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
}