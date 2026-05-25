package blackjack.model;

public class Karta {
    private final Kolor kolor;
    private final Wartosc wartosc;

    public Karta(Kolor kolor, Wartosc wartosc) {
        this.kolor = kolor;
        this.wartosc = wartosc;
    }

    public int getWartoscLiczbowa() {
        return wartosc.getLiczba();
    }

    public Kolor getKolor() {
        return kolor;
    }

    public Wartosc getWartosc() {
        return wartosc;
    }

    @Override
    public String toString() {
        return "[" + wartosc + " " + kolor.getSymbol() + "]";
    }
}