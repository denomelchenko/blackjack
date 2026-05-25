package blackjack.model;

public enum Wartosc {
    DWA(2),
    TRZY(3),
    CZTERY(4),
    PIEC(5),
    SZESC(6),
    SIEDEM(7),
    OSIEM(8),
    DZIEWIEC(9),
    DZIESIEC(10),
    WALET(10),
    DAMA(10),
    KROL(10),
    AS(11);

    private final int liczba;

    Wartosc(int liczba) {
        this.liczba = liczba;
    }

    public int getLiczba() {
        return liczba;
    }
}