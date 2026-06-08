package blackjack;

import blackjack.model.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RekaTest {

    @Test
    void emptyHandHasScoreZero() {
        Reka reka = new Reka();
        assertEquals(0, reka.getScore());
    }

    @Test
    void handCalculatesScoreWithoutAce() {
        Reka reka = new Reka();
        reka.addCard(new Card(Suit.SPADES, Rank.KING));
        reka.addCard(new Card(Suit.HEARTS, Rank.EIGHT));
        assertEquals(18, reka.getScore());
    }
}
