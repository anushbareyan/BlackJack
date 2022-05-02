package am.aua.blackjack.core;

public class BlackJack {//TODO petqa??
    //private Card[] deck; TODO karanq chunenanq deck uxxaki yntacqum bajaneluc random anenq??
    public static final int NUMBER_OF_ALL_CARDS = 52;
    private static int numberOfCardsLeft;.//TODO petqa?????static lini?????
    private Card[] usedCards;

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

    public boolean isUsed(){
        for(Card card: usedCards){
            if(this.equals(card))
                return true;
        }
        return false;
    }
}
