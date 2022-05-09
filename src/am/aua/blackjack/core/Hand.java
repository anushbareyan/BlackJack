package am.aua.blackjack.core;


import static am.aua.blackjack.core.Card.createCardAndRemoveFromDeck;

public class Hand {
    private Card[] cardsInHand;
    private int valueOfCardsInHand;


    public Hand() {
        cardsInHand = new Card[]{new Card(), new Card()};
        valueOfCardsInHand = cardsInHand[0].getIntValue() + cardsInHand[1].getIntValue();
    }
    public Hand(Deck d){
        cardsInHand = new Card[]{createCardAndRemoveFromDeck(d), createCardAndRemoveFromDeck(d)};
        valueOfCardsInHand = cardsInHand[0].getIntValue() + cardsInHand[1].getIntValue();
    }

    public Hand(Card[] cardsInHand, int valueOfCardsInHand) {
        setCardsInHand(cardsInHand);
        this.valueOfCardsInHand = valueOfCardsInHand;
    }

    public Hand(Card[] cardsInHand) {
        setCardsInHand(cardsInHand);
        for (int i = 0; i < cardsInHand.length; i++) {
            valueOfCardsInHand += cardsInHand[i].getIntValue();
        }
    }

    public Hand(Hand h){
        setCardsInHand(h.cardsInHand);
        this.valueOfCardsInHand = h.valueOfCardsInHand;
    }


    public Card[] getCardsInHand() {
        Card[] copy = new Card[cardsInHand.length];
        for (int i = 0; i < cardsInHand.length; i++) {
            if (this.cardsInHand[i] != null)
                copy[i] = this.cardsInHand[i].clone();
        }
        return copy;
    }

    public void setCardsInHand(Card[] cardsInHand) {
        this.cardsInHand =new Card[cardsInHand.length];
        for (int i = 0; i < cardsInHand.length; i++) {
            if (cardsInHand[i] != null) {
                this.cardsInHand[i] = cardsInHand[i].clone();
            }
        }
    }

    public int getValueOfCardsInHand() {
        return valueOfCardsInHand;
    }

    public void addCardsToCardsInHand(Card... newCards) {

        cardsInHand = Card.appendCardsToArray(cardsInHand, newCards);
        for (int i = 0; i < newCards.length; i++) {
            valueOfCardsInHand += newCards[i].getIntValue();
        }

    }

    @Override
    public String toString() {
        String str = "";
        int totalVal=0;
        for (Card c : cardsInHand) {
            str = str + c + "\n";//TODO karogha with the value n petq chi
            totalVal+=c.getIntValue();
        }
        return str+"Total Value: "+totalVal;
    }

    public static void main(String[] args) {
        Hand h = new Hand();
        System.out.println(h);
        for (int i = 0; i < 2; i++) {
            System.out.println(h.getCardsInHand()[i]);
        }

    }


}
