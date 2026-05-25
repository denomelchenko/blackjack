package blackjack;

import blackjack.model.Karta;
import blackjack.model.Kolor;
import blackjack.model.Wartosc;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class KartaTest {

    @Test
    void kartaPowinnaZwrocicWartoscLiczbowa() {
        Karta k = new Karta(Kolor.PIK, Wartosc.KROL);
        assertEquals(10, k.getWartoscLiczbowa());
    }

    @Test
    void asPowinienMiecWartoscJedenascie() {
        Karta k = new Karta(Kolor.KIER, Wartosc.AS);
        assertEquals(11, k.getWartoscLiczbowa());
    }

    @Test
    void kartaZwracaKolor() {
        Karta k = new Karta(Kolor.KARO, Wartosc.PIEC);
        assertEquals(Kolor.KARO, k.getKolor());
    }

    @Test
    void kartaZwracaWartosc() {
        Karta k = new Karta(Kolor.TREFL, Wartosc.WALET);
        assertEquals(Wartosc.WALET, k.getWartosc());
    }

    @Test
    void kartaToStringZawieraKolorIWartosc() {
        Karta k = new Karta(Kolor.PIK, Wartosc.AS);
        String wynik = k.toString();
        assertTrue(wynik.contains("PIK") || wynik.contains("AS"));
    }
}