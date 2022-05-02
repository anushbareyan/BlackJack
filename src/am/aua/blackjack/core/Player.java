package am.aua.blackjack.core;

import java.util.Random;
public class Player extends Hand{
    private Bank bank;

    public Player(){//karogha arandzin createhand anel?
        super();
        bank = new Bank();
    }

    public void bet(int money){
        bank.setBalance(bank.getBalance()-money);
        bank.setBettedMoney(money);
    }

    public static void main(String[] args) {
        BlackJack b =new BlackJack();
        System.out.println(b.getNumberOfCardsLeft());
        Player p = new Player();
        System.out.println(p);
        p.bet(100);
        System.out.println(p.bank);
        System.out.println(b.getNumberOfCardsLeft());

        for(int i=0;i<b.getUsedCards().length;i++){
            System.out.println(b.getUsedCards()[i]);
        }
    }
}
