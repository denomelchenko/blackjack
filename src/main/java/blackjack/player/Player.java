package blackjack.player;

import blackjack.model.Card;
import blackjack.model.Hand;

public class Player {
    private final String name;
    private int balance;
    private int bet;
    private final Hand hand;

    public Player(String name, int startingBalance) {
        this.name = name;
        this.balance = startingBalance;
        this.bet = 0;
        this.hand = new Hand();
    }

    public int getBalance() { return balance; }
    public int getBet() { return bet; }
    public String getName() { return name; }
    public Hand getHand() { return hand; }

    public void placeBet(int amount) {
        if (amount <= 0) throw new IllegalArgumentException("Bet must be positive!");
        if (amount > balance) throw new IllegalArgumentException("Insufficient balance!");
        this.bet = amount;
        this.balance -= amount;
    }

    public void win() {
        balance += bet * 2;
        bet = 0;
    }

    public void lose() {
        bet = 0;
    }
}