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
}