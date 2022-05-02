package am.aua.blackjack.core;

import java.util.Objects;
import java.util.Random;

public class Card implements Cloneable{
    private final Suit suit;
    private final Value value;
    private int intValue;
    private boolean isUsed;

    public Card() {
        Random rand = new Random();
        int randomForSuit = rand.nextInt(3);
        int randomForValue = rand.nextInt(12);
        suit=Card.Suit.values()[randomForSuit];
        value =Card.Value.values()[randomForValue];
        if(value.ordinal()<9){
            this.intValue=value.ordinal()+2;
        }else{
            this.intValue =10;
        }
    }

    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
        if(value.ordinal()<9){
            this.intValue=value.ordinal()+2;
        }else{
            this.intValue =10;
        }

    }

    public boolean getIsUsed(){
        return isUsed;
    }

    public void setIsUsed(boolean b){
        isUsed = b;
    }

    public Value getValue(){
        return value;
    }
    public Suit getSuit(){
        return suit;
    }
    public  int getIntValue(){ return intValue; }

    @Override
    public String toString() {
        return value.name()+" OF "+suit.name()+"S";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return intValue == card.intValue && suit == card.suit && value == card.value;
    }

    @Override
    public Card clone(){
        try{
            Card copy =(Card)super.clone();
            return copy;
        }catch (CloneNotSupportedException e) {
            // never reached
            return null;
        }
    }
    public enum Suit {
        HEART, CLUB, DIAMOND, SPADE
    }

    public enum Value {
        TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE
    }
    public static Card getRandomCard() {
        Random rand = new Random();
        Card randomCard;
        do {
            int randomForSuit = rand.nextInt(3);
            int randomForValue = rand.nextInt(12);
            randomCard = new Card(Card.Suit.values()[randomForSuit], Card.Value.values()[randomForValue]);
        } while (randomCard.getIsUsed());
        return randomCard;
    }
    public static Card[] appendCardsToArray(Card[] arr, Card... cards){
        Card[] result = new Card[arr.length+cards.length];

        for (int i = 0; i < arr.length; i++)
            result[i] = arr[i];
        for (int i = 0; i < cards.length; i++)
            result[arr.length + i] = cards[i];

        return result;
    }
    public static void main(String[] args) {
        Card c = new Card(Suit.HEART, Value.QUEEN);
        System.out.println(c);
    }

}
