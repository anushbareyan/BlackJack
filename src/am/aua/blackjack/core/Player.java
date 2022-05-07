package am.aua.blackjack.core;

import java.util.Random;
public class Player extends Participant implements Comparable<Player>{

    private Hand playerHand;
    private Bank bank;
    private String name;

    public Player(){//karogha arandzin createhand anel?
        super();
        setName("No name");
        bank = new Bank();
    }
    public Player(String name){
        super();
        setName(name);
        bank = new Bank();
    }
    public void setName(String name){
        this.name =name;
    }

    public void makeBet(int amount) throws InsufficientFundsException {
        bank.makePaying(((Integer)amount).toString());
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



}
