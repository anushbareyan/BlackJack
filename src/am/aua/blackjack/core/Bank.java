package am.aua.blackjack.core;
public class Bank {
    private Money balance;
    private Money bettedMoney;

    public Bank(){
        balance = new Money("0");
    }

    public String getBalance(){
        return balance.getAmount();
    }
    public long getMoneyDollars() {
        return balance.getDollars();
    }

    public int getMoneyCents() {
        return balance.getCents();
    }

    public String getBettedMoney(){
        return bettedMoney.getAmount();
    }


    public void makePaying(String betAmount) throws InsufficientFundsException {
        bettedMoney.addIn(new Money(betAmount));
        balance.takeOut(new Money(betAmount));
    }

    public void closeAccount()
    {
        balance.dollars = 0;
        balance.cents =0;
    }
    @Override
    public String toString() {
        return "Bank: "+ balance+"$"+"\nBetted money:"+bettedMoney+"$";
    }

    public class Money {
        private long dollars;
        private int cents;

        public Money(String stringAmount){
            abortOnNull(stringAmount);
            int length = stringAmount.length();
            dollars = Long.parseLong(stringAmount.substring(0, length - 3));
            cents = Integer.parseInt(stringAmount.substring(length - 2, length));
        }

        public long getDollars() {
            return dollars;
        }

        public int getCents() {
            return cents;
        }

        public String getAmount() {
            if (cents > 9)
                return (dollars + "." + cents);
            else
                return (dollars + ".0" + cents);
        }
        public void addIn(Money secondAmount)
        {
            abortOnNull(secondAmount);
            int newCents = (cents + secondAmount.cents)%100;
            long carry = (cents + secondAmount.cents)/100;
            cents = newCents;
            dollars = dollars + secondAmount.dollars + carry;
        }
        public void takeOut(Money secondAmount) throws InsufficientFundsException {
            abortOnNull(secondAmount);
            if(secondAmount.dollars>dollars){
                throw new InsufficientFundsException();
            }
            if(cents - secondAmount.cents>=0){
                int newCents = (cents - secondAmount.cents)%100;
                dollars = dollars+secondAmount.dollars;
                cents = newCents;
            }else{
                 int newCents= (secondAmount.cents-cents)%100;
                dollars = dollars+secondAmount.dollars-1;
                cents = newCents;
            }

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
