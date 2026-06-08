package blackjack.model;

import java.util.ArrayList;
import java.util.List;

public class Reka {

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

        while (total > 21 && aceCount > 0) {
            total -= 10;
            aceCount--;
        }

        return total;
    }

}
