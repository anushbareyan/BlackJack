package am.aua.blackjack.core;

import java.util.Random;
public class Player extends Participant implements Comparable<Player>{
    private Bank bank;

    public Player(){//karogha arandzin createhand anel?
        super();
        setName("No name");
        bank = new Bank("1000.00");
    }
    public Player(String name , Bank bank, Deck deck){
        super(deck);
        setName(name);
        this.bank = new Bank(bank);
    }
    public Player(String name, Deck deck){
        super(deck);
        setName(name);
        bank = new Bank("1000.00");
    }
    public Player(Deck deck){
        super(deck);
    }

    public Bank getBank() {
        return new Bank(bank);
    }

    public void makeBet(String amount) throws InsufficientFundsException {
        this.bank.makePayment(amount);
    }

    public void setBettedMoney(String amount){
        bank.setBettedMoney(amount);
    }
    public void setBalance(String amount){
        bank.setBalance(amount);
    }
    public void addMoneyToBettedMoney(String amount){
        bank.addInBettedMoney(amount);
    }
    public void addMoneyToBalance(String amount){
        bank.addInBalance(amount);
    }

    @Override
    public int compareTo(Player o) { //comparing only their banks to see who is the leader

        if(bank.getMoneyDollars()> o.bank.getMoneyDollars() && bank.getMoneyCents()>o.bank.getMoneyCents()){
            return (int) (bank.getMoneyDollars()- o.bank.getMoneyDollars());
        }
        if(bank.getMoneyCents()<o.bank.getMoneyCents() || bank.getMoneyDollars()<o.bank.getMoneyDollars()){
            return (int) (o.bank.getMoneyDollars()-bank.getMoneyDollars());
        }
        if(bank.getMoneyDollars()!= o.bank.getMoneyDollars()){
            return (int) (bank.getMoneyDollars()- o.bank.getMoneyDollars());
        }else{
            if( bank.getMoneyCents()!=o.bank.getMoneyCents()){
                return (bank.getMoneyCents()-o.bank.getMoneyCents())/100;
            }else{
                return 0;
            }
        }
    }

    //public String toString(){
        //return getName()+" has:\n"+bank+"\n"+getHand();
    //}
    public String toStringWithBank(){
        return getName()+" has:\n"+bank+"\n"+getHand();
    }
    public String toStringOnlyBank(){
        return getName()+" has:\n" + bank;
    }
    public Player clone(){
        Player copy = (Player) super.clone();
        copy.setName(getName());
        copy.bank = new Bank(bank);
        return copy;
    }

    public static void main(String[] args) {
        Deck d = new Deck();
        Player p = new Player();
        p.hit(d);
        p.hit(d);
        System.out.println(p);
    }
}
