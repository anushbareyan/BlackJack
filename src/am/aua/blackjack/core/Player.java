package am.aua.blackjack.core;

public class Player extends Participant implements Comparable<Player>{
    private Bank bank;

    public Player(){
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

    public void makeBet(String amount) throws InsufficientFundsException, InvalidMoneyInputException, NoMoneyException {
        this.bank.makePayment(amount);
    }

    public void setBettedMoney(String amount){
        bank.setBettedMoney(amount);
    }
    public void addMoneyToBalance(String amount){
        bank.addInBalance(amount);
    }

    public void addWinToBalance(){
        addMoneyToBalance(bank.multiplyByWinCoefficient(bank.getBettedMoney()));
    }

    @Override
    public int compareTo(Player o) { //comparing only their banks to see who is the leader
        if(bank.getBalanceInDollars()> o.bank.getBalanceInDollars()){
            return 1;
        }else if(bank.getBalanceInDollars() < o.bank.getBalanceInDollars()){
            return -1;
        }else{
            if(bank.getBalanceInCents()>o.bank.getBalanceInCents()){
                return 1;
            }else if(bank.getBalanceInCents()<o.bank.getBalanceInCents()){
                return -1;
            }else{
                return 0;
            }
        }
    }

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
}
