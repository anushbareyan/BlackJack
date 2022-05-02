package am.aua.blackjack.core;

import java.util.Random;
public class Player extends Hand{
    private Bank bank;

    public Player(){
        super();
        bank = new Bank();
    }

    public void bet(int money){
        bank.setBalance(bank.getBalance()-money);
        bank.setBettedMoney(money);
    }

    public static void main(String[] args) {
        Player p = new Player();
        System.out.println(p);
    }

}
