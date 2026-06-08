package blackjack;

import blackjack.model.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RekaTest {

    @Test
    void emptyHandHasScoreZero() {
        Reka reka = new Reka();
        assertEquals(0, reka.getScore());
    }
}
