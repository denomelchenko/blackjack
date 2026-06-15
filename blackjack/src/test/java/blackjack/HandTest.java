package blackjack;

import blackjack.model.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class HandTest {

    @Test
    void emptyHandHasScoreZero() {
        Hand hand = new Hand();
        assertEquals(0, hand.getScore());
    }

    @Test
    void handCalculatesScoreWithoutAce() {
        Hand hand = new Hand();
        hand.addCard(new Card(Suit.SPADES, Rank.KING));
        hand.addCard(new Card(Suit.HEARTS, Rank.EIGHT));
        assertEquals(18, hand.getScore());
    }

    @Test
    void aceReducesValueWhenOver21() {
        Hand hand = new Hand();
        hand.addCard(new Card(Suit.SPADES, Rank.KING));
        hand.addCard(new Card(Suit.HEARTS, Rank.KING));
        hand.addCard(new Card(Suit.DIAMONDS, Rank.ACE));
        assertEquals(21, hand.getScore());
    }

    @Test
    void blackjackIsAceAndFaceCard() {
        Hand hand = new Hand();
        hand.addCard(new Card(Suit.SPADES, Rank.ACE));
        hand.addCard(new Card(Suit.HEARTS, Rank.KING));
        assertTrue(hand.isBlackjack());
    }

    @Test
    void bustWhenOver21() {
        Hand hand = new Hand();
        hand.addCard(new Card(Suit.SPADES, Rank.KING));
        hand.addCard(new Card(Suit.HEARTS, Rank.KING));
        hand.addCard(new Card(Suit.DIAMONDS, Rank.FIVE));
        assertTrue(hand.isBust());
    }
}