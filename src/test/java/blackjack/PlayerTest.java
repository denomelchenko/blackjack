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
}