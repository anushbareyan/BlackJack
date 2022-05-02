package am.aua.blackjack.core;

public class BlackJack {
    public static final int NUMBER_OF_ALL_CARDS = 52;
    private static int numberOfCardsLeft;//TODO static??
    private static Card[] usedCards;

    public BlackJack(){
        Player p =new Player();
        Dealer d =new Dealer();
        usedCards = new Card[0];
        numberOfCardsLeft = NUMBER_OF_ALL_CARDS;
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
    public int getNumberOfCardsLeft(){
        return numberOfCardsLeft;
    }

    public static void addToUsedCards(Card c) throws NoCardsLeftException{
        if(numberOfCardsLeft<=0 || numberOfCardsLeft>52){
            throw new NoCardsLeftException();
        }else{
            c.setIsUsed(true);
            Card.appendCardsToArray(usedCards, c);
            numberOfCardsLeft--;
        }

    }
}
