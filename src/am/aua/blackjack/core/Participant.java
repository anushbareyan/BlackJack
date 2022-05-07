package am.aua.blackjack.core;

public abstract class Participant {
    private Hand hand;

    public Participant(){
        hand =new Hand();
    }

    //hit method returns what was given to the participant
    public Card hit(Deck deck){
        Card c =deck.getRandomNotUsedCard();
        hand.addCardsToCardsInHand(c);
        return c;
    }
}
