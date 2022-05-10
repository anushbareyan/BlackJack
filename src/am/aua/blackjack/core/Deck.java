package am.aua.blackjack.core;

import java.util.ArrayList;
import java.util.Random;


public class Deck {
    public static final int NUMBER_OF_ALL_CARDS = 52;
    private final ArrayList<Card> cards;
    private final ArrayList<Card> usedCards;

    public Deck() {
        cards = new ArrayList<>(312);
        for(int i=0;i<6;i++){
            for (Card.Suit s : Card.Suit.values()) {
                for (Card.Value v : Card.Value.values()) {
                    cards.add(new Card(s, v));
                }
            }
        }
        usedCards = new ArrayList<>(0);
    }

    public static void main(String[] args) {
        Deck d = new Deck();
        Card c = new Card(Card.Suit.HEART, Card.Value.ACE);
        d.removeUsedCard(c);
        System.out.println(c + "\n" + d);
    }

    public Card getRandomNotUsedCard() {
        Random rand = new Random();
        int randomForCards = rand.nextInt(cards.size());
        return cards.get(randomForCards);
    }

    public void removeUsedCard(Card c) {
        if(cards.size()==0){
            new Deck();
        }
        cards.remove(c);
        usedCards.add(c);
    }

    public ArrayList<Card> getCards() {
        ArrayList<Card> cardsCopy = new ArrayList<Card>(cards.size());
        for (int i = 0; i < cards.size(); i++) {
            if (cards.get(i) == null) {
                cardsCopy.set(i, null);
            } else {
                cardsCopy.set(i, cards.get(i).clone());
            }
        }
        return cardsCopy;
    }

    @Override
    public String toString() {
        String str = "";
        for (Card c : cards) {
            str += c.toString() + "\n";
        }
        return str;
    }


    //    public static void addToUsedCards(Blackjack game, Card c) throws NoCardsLeftException{
//        if(numberOfCardsLeft<=0 || numberOfCardsLeft>52){
//            throw new NoCardsLeftException();
//        }else{
//            game.deck.usedCards.add(c);
//            numberOfCardsLeft--;
//        }
//    }
}
