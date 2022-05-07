package am.aua.blackjack.core;

public class Hand {
    private Card[] cardsInHand;
    private int valueOfCardsInHand;


    public Hand(){
        cardsInHand[0]=new Card();
        cardsInHand[1]=new Card();
        valueOfCardsInHand = cardsInHand[0].getIntValue()+cardsInHand[1].getIntValue();

    }

    public Hand(Card[] cardsInHand, int valueOfCardsInHand){
        setCardsInHand(cardsInHand);
        this.valueOfCardsInHand =valueOfCardsInHand;
    }
    public Hand(Card[] cardsInHand){
        setCardsInHand(cardsInHand);
        for(int i =0;i< cardsInHand.length;i++) {
            valueOfCardsInHand += cardsInHand[i].getIntValue();
        }
    }

    public Card[] getCardsInHand(){
        Card[] copy = new Card[cardsInHand.length];
        for (int i = 0; i < cardsInHand.length; i++)
            if (this.cardsInHand[i] != null)
                copy[i] = (Card) this.cardsInHand[i].clone();
        return copy;
    }

    public int getValueOfCardsInHand(){
        return valueOfCardsInHand;
    }

    public void setCardsInHand(Card[] cardsInHand){
        for (int i = 0; i < cardsInHand.length; i++) {
            if (cardsInHand[i] != null) {
                this.cardsInHand[i]= cardsInHand[i].clone();
            }
        }
    }

    public void addCardsToCardsInHand(Card...newCards){

        cardsInHand = Card.appendCardsToArray(cardsInHand, newCards);
        for(int i =0;i< newCards.length;i++){
            valueOfCardsInHand += newCards[i].getIntValue();
        }

    }

    @Override
    public String toString(){
        String str="";
        for(Card c: cardsInHand){
            str=str+c+ " with the value of"+ c.getIntValue()+"\n";
        }
        return str;
    }


}
