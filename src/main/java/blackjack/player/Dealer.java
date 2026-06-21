package blackjack.player;

import blackjack.model.Card;
import blackjack.model.Deck;
import blackjack.model.Hand;

public class Dealer {
    private final Hand hand;

    public Dealer() {
        this.hand = new Hand();
    }

    public Hand getHand() {
        return hand;
    }

    public int getScore() {
        return hand.getScore();
    }

    public void addCard(Card card) {
        hand.addCard(card);
    }

    public void drawUntilSeventeen(Deck deck) {
        while (hand.getScore() < 17) {
            hand.addCard(deck.deal());
        }
    }

    public void resetHand() {
        hand.clear();
    }
}