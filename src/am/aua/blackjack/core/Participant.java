package am.aua.blackjack.core;

public abstract class Participant implements Cloneable{
    private Hand hand;
    private String name;

    public Participant(){
        hand =new Hand();
    }
    public Participant(Deck deck){
        hand =new Hand(deck);
    }

    public void setName(String name){
        this.name =name;
    }


    public String getName(){
        return name;
    }

    public Hand getHand(){
        return new Hand(hand.getCardsInHand(), hand.getValueOfCardsInHand());
    }

    //hit method returns what was given to the participant
    public Card hit(Deck deck){
        Card c =deck.getRandomNotUsedCard();
        hand.addCardsToCardsInHand(c);
        deck.removeUsedCard(c);
        return c;
    }

    @Override
    public String toString() {
        return name+" has:\n"+getHand();
    }

    public Participant clone(){
        try {
            Participant clone = (Participant)super.clone();
            clone.hand = new Hand(this.hand);
            return clone;
        } catch (CloneNotSupportedException e) {
            return null;
        }

    }
}
