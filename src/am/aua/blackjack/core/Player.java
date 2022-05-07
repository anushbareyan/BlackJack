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
        if(this.bank.getBalance()!=o.bank.getBalance()){
            return this.bank.getBalance()-o.bank.getBalance();
        }else{
            return 0;
        }
    }



}
