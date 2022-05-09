package am.aua.blackjack.core;

import java.util.Random;

/**
 * <p>A mutable class for storing and representing a card in blackjack deck. Contains static methods
 * that generate valid objects after ensuring that the given arguments are valid.
 *
 * @author Anush Bareyan <a href="mailto:anush_bareyan@edu.aua.am">anush_bareyan@edu.aua.am</a>
 * @author Liana Aramyan <a href="mailto:liana_aramyan@edu.aua.am">liana_aramyan@edu.aua.am</a>
 * @author Elen Antapyan <a href="mailto:elen_antapyan@edu.aua.am">elen_antapyan@edu.aua.am</a>
 * @version 1.0
 * @since 1.0
 */
public class Card implements Cloneable{
    //mutable
//    public static final int NUMBER_OF_SUITS =4;
//    public static final int NUMBER_OF_VALUE =13;
    private final Suit suit;
    private final Value value;
    private final int intValue;

    public Card() {
        Random rand = new Random();
        int randomForSuit = rand.nextInt(3);
        int randomForValue = rand.nextInt(12);
        suit = Card.Suit.values()[randomForSuit];
        value = Card.Value.values()[randomForValue];
        if (value.ordinal() < 9) {
            this.intValue = value.ordinal() + 2;
        } else {
            this.intValue = 10;
        }
    }

    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
        if (value.ordinal() < 9) {
            this.intValue = value.ordinal() + 2;
        } else {
            this.intValue = 10;
        }
    }

    public Card(Card card) {
        this.suit = card.suit;
        this.value = card.value;
        this.intValue = card.intValue;
    }
    public static Card createCardAndRemoveFromDeck(Deck deck){
        Card c =deck.getRandomNotUsedCard();
        deck.removeUsedCard(c);
        return c;
    }

    public static Card[] appendCardsToArray(Card[] arr, Card... cards) {
        Card[] result = new Card[arr.length + cards.length];

        for (int i = 0; i < arr.length; i++)
            result[i] = arr[i];
        for (int i = 0; i < cards.length; i++)
            result[arr.length + i] = cards[i];

        return result;
    }

    public Value getValue() {
        return value;
    }

    public Suit getSuit() {
        return suit;
    }

    public int getIntValue() {
        return intValue;
    }

    @Override
    public String toString() {
        return value.name() + " OF " + suit.name() + "S";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return (intValue == ((Card) o).intValue && suit == ((Card) o).suit && value == ((Card) o).value);
    }

    @Override
    public Card clone() {
        try {
            Card copy = (Card) super.clone();
            return copy;
        } catch (CloneNotSupportedException e) {
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

    public static void main(String[] args) {
        Card c =new Card();
        System.out.println(c);

        Card d = c.clone();
        System.out.println(d);
    }
}
