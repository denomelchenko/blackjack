package blackjack;

import blackjack.model.*;
import blackjack.player.Dealer;
import blackjack.player.Player;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BlackjackGameTest {

    @Test
    void playerBustLosesRegardless() {
        Player player = new Player("Test", 1000);
        Dealer dealer = new Dealer();
        player.addCard(new Card(Suit.SPADES, Rank.KING));
        player.addCard(new Card(Suit.HEARTS, Rank.KING));
        player.addCard(new Card(Suit.DIAMONDS, Rank.FIVE));
        dealer.addCard(new Card(Suit.SPADES, Rank.TWO));
        dealer.addCard(new Card(Suit.HEARTS, Rank.THREE));
        RoundResult result = BlackjackGame.determineWinner(player, dealer);
        assertEquals(RoundResult.DEALER_WINS, result);
    }

    @Test
    void dealerBustMeansPlayerWins() {
        Player player = new Player("Test", 1000);
        Dealer dealer = new Dealer();
        player.addCard(new Card(Suit.SPADES, Rank.KING));
        player.addCard(new Card(Suit.HEARTS, Rank.EIGHT));
        dealer.addCard(new Card(Suit.SPADES, Rank.KING));
        dealer.addCard(new Card(Suit.HEARTS, Rank.KING));
        dealer.addCard(new Card(Suit.DIAMONDS, Rank.FIVE));
        RoundResult result = BlackjackGame.determineWinner(player, dealer);
        assertEquals(RoundResult.PLAYER_WINS, result);
    }

    @Test
    void playerBlackjackBeatsDealer18() {
        Player player = new Player("Test", 1000);
        Dealer dealer = new Dealer();
        player.addCard(new Card(Suit.SPADES, Rank.ACE));
        player.addCard(new Card(Suit.HEARTS, Rank.KING));
        dealer.addCard(new Card(Suit.SPADES, Rank.KING));
        dealer.addCard(new Card(Suit.HEARTS, Rank.EIGHT));
        RoundResult result = BlackjackGame.determineWinner(player, dealer);
        assertEquals(RoundResult.PLAYER_BLACKJACK, result);
    }

    @Test
    void dealerHigherScoreWins() {
        Player player = new Player("Test", 1000);
        Dealer dealer = new Dealer();
        player.addCard(new Card(Suit.SPADES, Rank.KING));
        player.addCard(new Card(Suit.HEARTS, Rank.SIX));
        dealer.addCard(new Card(Suit.SPADES, Rank.KING));
        dealer.addCard(new Card(Suit.HEARTS, Rank.EIGHT));
        RoundResult result = BlackjackGame.determineWinner(player, dealer);
        assertEquals(RoundResult.DEALER_WINS, result);
    }

    @Test
    void playerHigherScoreWins() {
        Player player = new Player("Test", 1000);
        Dealer dealer = new Dealer();
        player.addCard(new Card(Suit.SPADES, Rank.KING));
        player.addCard(new Card(Suit.HEARTS, Rank.NINE));
        dealer.addCard(new Card(Suit.SPADES, Rank.KING));
        dealer.addCard(new Card(Suit.HEARTS, Rank.SEVEN));
        RoundResult result = BlackjackGame.determineWinner(player, dealer);
        assertEquals(RoundResult.PLAYER_WINS, result);
    }

    @Test
    void equalScoresResultInPush() {
        Player player = new Player("Test", 1000);
        Dealer dealer = new Dealer();
        player.addCard(new Card(Suit.SPADES, Rank.KING));
        player.addCard(new Card(Suit.HEARTS, Rank.EIGHT));
        dealer.addCard(new Card(Suit.DIAMONDS, Rank.KING));
        dealer.addCard(new Card(Suit.CLUBS, Rank.EIGHT));
        RoundResult result = BlackjackGame.determineWinner(player, dealer);
        assertEquals(RoundResult.PUSH, result);
    }

    @Test
    void dealInitialCardsGivesTwoCardsEach() {
        Player player = new Player("Test", 1000);
        Dealer dealer = new Dealer();
        Deck deck = new Deck();
        BlackjackGame.dealInitialCards(player, dealer, deck);
        assertEquals(2, player.getHand().getCards().size());
        assertEquals(2, dealer.getHand().getCards().size());
    }

    @Test
    void bothBustDealerWinsBecausePlayerCheckedFirst() {
        Player player = new Player("Test", 1000);
        Dealer dealer = new Dealer();
        player.addCard(new Card(Suit.SPADES, Rank.KING));
        player.addCard(new Card(Suit.HEARTS, Rank.KING));
        player.addCard(new Card(Suit.DIAMONDS, Rank.FIVE));
        dealer.addCard(new Card(Suit.CLUBS, Rank.KING));
        dealer.addCard(new Card(Suit.SPADES, Rank.QUEEN));
        dealer.addCard(new Card(Suit.HEARTS, Rank.FIVE));
        RoundResult result = BlackjackGame.determineWinner(player, dealer);
        assertEquals(RoundResult.DEALER_WINS, result);
    }

    @Test
    void exactlyTwentyOneIsNotBust() {
        Player player = new Player("Test", 1000);
        Dealer dealer = new Dealer();
        player.addCard(new Card(Suit.SPADES, Rank.SEVEN));
        player.addCard(new Card(Suit.HEARTS, Rank.SEVEN));
        player.addCard(new Card(Suit.DIAMONDS, Rank.SEVEN));
        dealer.addCard(new Card(Suit.CLUBS, Rank.KING));
        dealer.addCard(new Card(Suit.SPADES, Rank.QUEEN));
        RoundResult result = BlackjackGame.determineWinner(player, dealer);
        assertEquals(RoundResult.PLAYER_WINS, result);
    }

    @Test
    void pushWhenBothHaveTwenty() {
        Player player = new Player("Test", 1000);
        Dealer dealer = new Dealer();
        player.addCard(new Card(Suit.SPADES, Rank.KING));
        player.addCard(new Card(Suit.HEARTS, Rank.QUEEN));
        dealer.addCard(new Card(Suit.DIAMONDS, Rank.KING));
        dealer.addCard(new Card(Suit.CLUBS, Rank.QUEEN));
        RoundResult result = BlackjackGame.determineWinner(player, dealer);
        assertEquals(RoundResult.PUSH, result);
    }
}