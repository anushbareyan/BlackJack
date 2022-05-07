package am.aua.blackjack.core;

import java.util.ArrayList;
import java.util.Random;


public class Deck {
    public static final int NUMBER_OF_ALL_CARDS = 52;
    private ArrayList<Card> cards;
    private ArrayList<Card> usedCards;

    public Deck(){
        cards =new ArrayList<>(52);
        for(Card.Suit s: Card.Suit.values()){
            for(Card.Value v: Card.Value.values()){
                cards.add(new Card(s,v));
            }
        }
    }

    public Card getRandomNotUsedCard(){
        Random rand =new Random();
        int randomForCards = rand.nextInt(cards.size());
        return cards.get(randomForCards);
    }

    public void removeUsedCard(Card c){
        cards.remove(c);
        usedCards.add(c);
    }

    public ArrayList<Card> getUsedCards(){
        ArrayList<Card> usedCardsCopy = new ArrayList<Card>(usedCards.size());
        for (int i = 0; i < usedCards.size(); i++) {
            if (usedCards.get(i) == null) {
                usedCardsCopy.set(i, null);
            } else {
                usedCardsCopy.set(i, (Card) usedCards.get(i).clone());
            }
        }
        return usedCardsCopy;
    }

    @Override
    public String toString(){
        String str ="";
        for(Card c:cards){
            str+=c.toString()+"\n";
        }return str;
    }

    public static void main(String[] args) {
        Deck d = new Deck();
        Card c = new Card(Card.Suit.HEART, Card.Value.ACE);
        d.removeUsedCard(c);
        System.out.println(c + "\n"+ d);

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
