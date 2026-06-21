package blackjack;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RoundResultTest {

    @Test
    void roundResultHasAllValues() {
        assertEquals(4, RoundResult.values().length);
        assertNotNull(RoundResult.valueOf("PLAYER_WINS"));
        assertNotNull(RoundResult.valueOf("PLAYER_BLACKJACK"));
        assertNotNull(RoundResult.valueOf("DEALER_WINS"));
        assertNotNull(RoundResult.valueOf("PUSH"));
    }
}