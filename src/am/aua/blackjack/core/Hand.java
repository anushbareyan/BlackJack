package am.aua.blackjack.core;

public abstract class Hand {
    private Card[] hand;
    private int valueOfHand;

    public Hand(){
        hand =new Card[0];
        Card randomCard1 = new Card();

        Card randomCard2 = new Card();
        try{ //TODo inchna sxal vor anyndhat qcuma exception?
            BlackJack.addToUsedCards(randomCard1);
            BlackJack.addToUsedCards(randomCard2);
        } catch (NoCardsLeftException e) {
            System.out.println(e);
        }
        hand = Card.appendCardsToArray(hand,randomCard1 ,randomCard2 );

        valueOfHand = randomCard1.getIntValue()+randomCard2.getIntValue();
    }

    public Card[] getHand(){
        Card[] copy = new Card[hand.length];
        for (int i = 0; i < hand.length; i++)
                if (this.hand[i] != null)
                    copy[i] = (Card) this.hand[i].clone();
        return copy;
    }

    public void hit(){
        hand= Card.appendCardsToArray(hand, Card.getRandomCard());
    }

    @Override
    public String toString(){
        String str="";
        for(Card c: hand){
            str=str+c+ " "+ c.getIntValue()+"\n";
        }
        return str;
    }

    public int getValueOfHand(){
        return valueOfHand;
    }

    public static void main(String[] args) {

    }
}
