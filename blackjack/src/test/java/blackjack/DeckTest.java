package blackjack;

import blackjack.model.Card;
import blackjack.model.Deck;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DeckTest {

    @Test
    void newDeckHas52Cards() {
        Deck deck = new Deck();
        assertEquals(52, deck.size());
    }

    @Test
    void dealCardReducesSize() {
        Deck deck = new Deck();
        deck.deal();
        assertEquals(51, deck.size());
    }

    @Test
    void dealCardReturnsCard() {
        Deck deck = new Deck();
        Card card = deck.deal();
        assertNotNull(card);
    }

    @Test
    void shuffleDoesNotChangeSize() {
        Deck deck = new Deck();
        deck.shuffle();
        assertEquals(52, deck.size());
    }

    @Test
    void dealFromEmptyDeckThrowsException() {
        Deck deck = new Deck();
        for (int i = 0; i < 52; i++) {
            deck.deal();
        }
        assertThrows(IllegalStateException.class, deck::deal);
    }
}