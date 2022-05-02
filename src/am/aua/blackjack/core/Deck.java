package am.aua.blackjack.core;

import java.util.Random;

public class Deck {
    public static final int NUMBER_OF_ALL_CARDS = 52;
    private int numberOfCardsLeft;
    private static Card[] usedCards = new Card[0];

    public Deck(){

    }

    public Card[] getUsedCards(){
        Card[] usedCardsCopy = new Card[usedCards.length];
        for (int i = 0; i < usedCards.length; i++) {
            if (this.usedCards[i] == null) {
                usedCardsCopy[i] = null;
            } else {
                usedCardsCopy[i] = (Card) this.usedCards[i].clone();
            }
        }
        return usedCardsCopy;
    }
    
    public static void addToUsedCards(Card c){
        c.setIsUsed(true);
        Card.appendCardsToArray(usedCards, c);
    }
}
