package blackjack.model;

import java.util.ArrayList;
import java.util.List;

public class Hand {

    private static final int BLACKJACK_SCORE = 21;
    private static final int BLACKJACK_CARD_COUNT = 2;
    private static final int ACE_ADJUSTMENT = 10;

    private final List<Card> cards = new ArrayList<>();

    public void addCard(Card card) {
        cards.add(card);
    }

    public int getScore() {
        int total = 0;
        int aceCount = 0;

        for (Card card : cards) {
            total += card.getValue();
            if (card.getRank() == Rank.ACE) {
                aceCount++;
            }
        }

        while (total > BLACKJACK_SCORE && aceCount > 0) {
            total -= ACE_ADJUSTMENT;
            aceCount--;
        }

        return total;
    }

    public boolean isBlackjack() {
        return cards.size() == BLACKJACK_CARD_COUNT && getScore() == BLACKJACK_SCORE;
    }

    public boolean isBust() {
        return getScore() > BLACKJACK_SCORE;
    }

    public List<Card> getCards() {
        return new ArrayList<>(cards);
    }

    public void clear() {
        cards.clear();
    }
}