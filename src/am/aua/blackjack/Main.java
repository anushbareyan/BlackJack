package am.aua.blackjack;

import am.aua.blackjack.cli.BlackjackConsole;
import am.aua.blackjack.core.Card;
import am.aua.blackjack.core.NoCardsLeftException;

import static am.aua.blackjack.core.Deck.*;

public class Main {
    public static void main(String[] args) {
        BlackjackConsole blackjackConsole = new BlackjackConsole();
        blackjackConsole.run();


//        Blackjack game =new Blackjack();
//        Blackjack secondGame =new Blackjack();
//        Card c =new Card(Card.Suit.HEART, Card.Value.ACE);
//        Card c1 = new Card(Card.Suit.SPADE, Card.Value.EIGHT);
    }
}
