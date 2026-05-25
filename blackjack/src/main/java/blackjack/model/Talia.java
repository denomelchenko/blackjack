package blackjack.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Talia {
    private final List<Karta> karty;

    public Talia() {
        karty = new ArrayList<>();
        for (Kolor kolor : Kolor.values()) {
            for (Wartosc wartosc : Wartosc.values()) {
                karty.add(new Karta(kolor, wartosc));
            }
        }
    }

    public void tasuj() {
        Collections.shuffle(karty);
    }

    public Karta rozdajKarte() {
        if (karty.isEmpty()) {
            throw new IllegalStateException("Talia jest pusta!");
        }
        return karty.remove(karty.size() - 1);
    }

    public int iloscKart() {
        return karty.size();
    }
}