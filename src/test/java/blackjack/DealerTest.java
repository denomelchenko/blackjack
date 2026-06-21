package blackjack;

import blackjack.model.Card;
import blackjack.model.Deck;
import blackjack.player.Dealer;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

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

    @Test
    void dealerDrawsUntilSeventeen() {
        Dealer dealer = new Dealer();
        dealer.addCard(new blackjack.model.Card(
                blackjack.model.Suit.SPADES,
                blackjack.model.Rank.SEVEN
        ));
        dealer.addCard(new blackjack.model.Card(
                blackjack.model.Suit.HEARTS,
                blackjack.model.Rank.SEVEN
        )); // 14

        FixedDeck deck = new FixedDeck(
                new blackjack.model.Card(blackjack.model.Suit.CLUBS, blackjack.model.Rank.TWO),
                new blackjack.model.Card(blackjack.model.Suit.DIAMONDS, blackjack.model.Rank.THREE)
        );

        dealer.drawUntilSeventeen(deck);

        assertTrue(dealer.getScore() >= 17);
        assertEquals(4, dealer.getHand().getCards().size());
    }

    @Test
    void dealerCanResetHand() {
        Dealer dealer = new Dealer();
        dealer.addCard(new blackjack.model.Card(
                blackjack.model.Suit.SPADES,
                blackjack.model.Rank.ACE
        ));
        dealer.resetHand();
        assertEquals(0, dealer.getHand().getCards().size());
        assertEquals(0, dealer.getScore());
    }
}

class FixedDeck extends Deck {
    private final Queue<Card> cards;

    FixedDeck(Card... cards) {
        this.cards = new ArrayDeque<>(Arrays.asList(cards));
    }

    @Override
    public Card deal() {
        return cards.remove();
    }
}