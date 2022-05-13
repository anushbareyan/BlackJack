package am.aua.blackjack.core;

public class Dealer extends Participant{
    public Dealer(){
        super();
        setName("Dealer");
    }
    public Dealer(Deck deck){
        super(deck);
        setName("Dealer");
    }

    public String toStringWhenHidden(){
        String str= getName()+" has:\n";
        str += "HIDDEN\n";
        str+=getHand().toString().split("\n")[1];
        int total = getHand().getValueOfCardsInHand()-getHand().getCardsInHand()[0].getIntValue();
        return str+ "\nTotal: "+ total;
    }
    public int getValueWhenHidden(){
        return this.getHand().getValueOfCardsInHand()-getHand().getCardsInHand()[0].getIntValue();
    }
    public Dealer clone(){
        return (Dealer) super.clone();
    }

}
