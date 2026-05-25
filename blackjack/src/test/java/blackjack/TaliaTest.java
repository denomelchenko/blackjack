package blackjack;

import blackjack.model.Karta;
import blackjack.model.Talia;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TaliaTest {

    @Test
    void taliaPowinnaMiec52Karty() {
        Talia talia = new Talia();
        assertEquals(52, talia.iloscKart());
    }

    @Test
    void rozdajKarteZmniejszaLiczbeKart() {
        Talia talia = new Talia();
        talia.rozdajKarte();
        assertEquals(51, talia.iloscKart());
    }

    @Test
    void rozdajKarteZwracaKarte() {
        Talia talia = new Talia();
        Karta karta = talia.rozdajKarte();
        assertNotNull(karta);
    }

    @Test
    void tasowanieNieZmienaLiczbyKart() {
        Talia talia = new Talia();
        talia.tasuj();
        assertEquals(52, talia.iloscKart());
    }

    @Test
    void pustaKartaRzucaWyjatek() {
        Talia talia = new Talia();
        for (int i = 0; i < 52; i++) {
            talia.rozdajKarte();
        }
        assertThrows(IllegalStateException.class, talia::rozdajKarte);
    }
}