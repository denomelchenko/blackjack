package blackjack.model;

public enum Kolor {
    PIK("♠"),
    KIER("♥"),
    KARO("♦"),
    TREFL("♣");

    private final String symbol;

    Kolor(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}