package am.aua.blackjack.core;
public class Bank {
    private Money balance;
    private Money bettedMoney;

    public Bank(){
        balance = new Money("0");
    }

    public int getBalance(){
        return balance.getAmount();
    }

    public int getBettedMoney(){
        return bettedMoney.getAmount();
    }

    public void makePaying(String betAmount) throws InsufficientFundsException {
        bettedMoney.addIn(new Money(betAmount));
        balance.takeOut(new Money(betAmount));
    }
    @Override
    public String toString() {
        return "Bank: "+ balance+"$"+"\nBetted money:"+bettedMoney+"$";
    }

    public void closeAccount()
    {
        balance.dollars = 0;
    }
    private class Money {
        private int dollars;

        public Money(String stringAmount){
            abortOnNull(stringAmount);
            int length = stringAmount.length();
            dollars = Integer.parseInt(stringAmount);
        }
        public Money(int Amount){
            abortOnNull(Amount);
            dollars = Amount;
        }
        public int getAmount(){
            return dollars;
        }
        public void addIn(Money secondAmount)
        {
            abortOnNull(secondAmount);
            dollars += secondAmount.dollars;
        }
        public void takeOut(Money secondAmount) throws InsufficientFundsException {
            abortOnNull(secondAmount);
            if(secondAmount.dollars>dollars){
                throw new InsufficientFundsException();
            }
            dollars -= secondAmount.dollars;
        }
        private void abortOnNull(Object o)
        {
            if (o == null)
            {
                System.out.println("Unexpected null argument.");
                System.exit(0);
            }
        }
    }

}
