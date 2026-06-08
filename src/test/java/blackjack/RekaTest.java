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

    @Test
    void aceReducesValueWhenOver21() {
        Reka reka = new Reka();
        reka.addCard(new Card(Suit.SPADES, Rank.KING));
        reka.addCard(new Card(Suit.HEARTS, Rank.KING));
        reka.addCard(new Card(Suit.DIAMONDS, Rank.ACE));
        assertEquals(21, reka.getScore());
    }

    @Test
    void blackjackIsAceAndFaceCard() {
        Reka reka = new Reka();
        reka.addCard(new Card(Suit.SPADES, Rank.ACE));
        reka.addCard(new Card(Suit.HEARTS, Rank.KING));
        assertTrue(reka.isBlackjack());
    }

    @Test
    void bustWhenOver21() {
        Reka reka = new Reka();
        reka.addCard(new Card(Suit.SPADES, Rank.KING));
        reka.addCard(new Card(Suit.HEARTS, Rank.KING));
        reka.addCard(new Card(Suit.DIAMONDS, Rank.FIVE));
        assertTrue(reka.isBust());
    }

    @Test
    void handSizeIsCorrect() {
        Reka reka = new Reka();
        reka.addCard(new Card(Suit.SPADES, Rank.ACE));
        assertEquals(1, reka.getCards().size());
    }
}
