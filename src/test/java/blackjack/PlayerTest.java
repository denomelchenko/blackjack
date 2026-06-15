package blackjack;

import blackjack.player.Player;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void playerStartsWithInitialBalance() {
        Player player = new Player("Jan", 1000);
        assertEquals(1000, player.getBalance());
    }

    @Test
    void playerCanPlaceBet() {
        Player player = new Player("Jan", 1000);
        player.placeBet(200);
        assertEquals(200, player.getBet());
        assertEquals(800, player.getBalance());
    }

    @Test
    void playerCannotBetMoreThanBalance() {
        Player player = new Player("Jan", 100);
        assertThrows(IllegalArgumentException.class, () -> player.placeBet(500));
    }

    @Test
    void playerWinDoublesBet() {
        Player player = new Player("Jan", 1000);
        player.placeBet(200);
        player.win();
        assertEquals(1200, player.getBalance());
    }

    @Test
    void playerLosesClearsBet() {
        Player player = new Player("Jan", 1000);
        player.placeBet(200);
        player.lose();
        assertEquals(0, player.getBet());
        assertEquals(800, player.getBalance());
    }

    @Test
    void playerCanAddCard() {
        Player player = new Player("Jan", 1000);
        player.addCard(new blackjack.model.Card(blackjack.model.Suit.SPADES, blackjack.model.Rank.ACE));
        assertEquals(1, player.getHand().getCards().size());
    }
}