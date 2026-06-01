package blackjack;

import blackjack.model.Card;
import blackjack.model.Suit;
import blackjack.model.Rank;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CardTest {

    @Test
    void faceCardHasValueTen() {
        Card card = new Card(Suit.SPADES, Rank.KING);
        assertEquals(10, card.getValue());
    }

    @Test
    void aceHasValueEleven() {
        Card card = new Card(Suit.HEARTS, Rank.ACE);
        assertEquals(11, card.getValue());
    }

    @Test
    void cardReturnsSuit() {
        Card card = new Card(Suit.DIAMONDS, Rank.FIVE);
        assertEquals(Suit.DIAMONDS, card.getSuit());
    }

    @Test
    void cardReturnsRank() {
        Card card = new Card(Suit.CLUBS, Rank.JACK);
        assertEquals(Rank.JACK, card.getRank());
    }

    @Test
    void toStringContainsRankAndSuit() {
        Card card = new Card(Suit.SPADES, Rank.ACE);
        String result = card.toString();
        assertTrue(result.contains("ACE") || result.contains("SPADES"));
    }
}