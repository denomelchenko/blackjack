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
}