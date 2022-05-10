package am.aua.blackjack.core;
public class Bank {
    private Money balance;
    private Money bettedMoney;

    public Bank(){
        balance = new Money("0.00");
        bettedMoney =new Money("0.00");
    }
    public Bank(String stringAmount){//assigns only the balance, bettedMoney=0.00
        balance = new Money(stringAmount);
        bettedMoney =new Money("0.00");
    }
    public Bank(String balanceStr, String bettedMoneyStr){
        balance = new Money(balanceStr);
        bettedMoney =new Money(bettedMoneyStr);
    }
    public Bank(Bank bank){   //copy constructor
        balance = new Money(bank.balance);
        bettedMoney =new Money(bank.bettedMoney);
    }

    public void setBettedMoney(String amount){
        bettedMoney = new Money(amount);
    }
    public void setBalance(String amount){
        balance = new Money(amount);
    }
    public void addInBettedMoney(String amount){
        bettedMoney.addIn(new Money(amount));
    }
    public void addInBalance(String amount){
        balance.addIn(new Money(amount));
    }
    public String getBettedMoney(){
        return bettedMoney.getAmount();
    }

    public String getBalance(){
        return balance.getAmount();
    }

    public String multiplyByWinCoefficient(String amount){
        Money m = new Money(amount);

         m.dollars = (long) (m.getDollars()*1.5);
        m.cents = (int) (Math.round(m.getCents()*(float)1.5)+((m.getDollars()*3)%2)*10);
        return m.toString();
    }

    public long getMoneyInDollars(String amount){
        Money m =new Money(amount);
        return m.getDollars();
    }public long getMoneyInCents(String amount){
        Money m =new Money(amount);
        return m.getCents();
    }

    public long getBalanceInDollars() {
        return balance.getDollars();
    }

    public int getBalanceInCents() {
        return balance.getCents();
    }
    public void makePayment(String betAmount) throws InsufficientFundsException, InvalidMoneyInputException, NoMoneyException {
        if(new Money(betAmount).getDollars()< balance.getDollars()
                ||(new Money(betAmount).getDollars()== balance.getDollars()
                && new Money(betAmount).getCents()< balance.getCents())){
            bettedMoney.addIn(new Money(betAmount));
        }
        balance.takeOut(new Money(betAmount));
    }

    public void closeAccount()
    {
        balance.dollars = 0;
        balance.cents =0;
    }

    @Override
    public String toString() {
        return "Bank: "+ balance+"$"+"\nBetted money: "+bettedMoney+"$";
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

        public Money(Money money){
            abortOnNull(money);
            dollars = money.dollars;
            cents =money.cents;
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
        public void takeOut(Money secondAmount) throws InsufficientFundsException, InvalidMoneyInputException, NoMoneyException {
            abortOnNull(secondAmount);
            if((secondAmount.dollars<=0 && secondAmount.cents<=0) ||(secondAmount.toString().charAt(0)=='-')){
                throw new InvalidMoneyInputException();
            }
            if(dollars==0 &&cents==0){
                throw new NoMoneyException();
            }
            if(secondAmount.dollars>dollars){
                throw new InsufficientFundsException();
            }else if(cents - secondAmount.cents>=0){
                int newCents = (cents - secondAmount.cents)%100;
                dollars = dollars-secondAmount.dollars;
                cents = newCents;
            }else{
                 int newCents= (secondAmount.cents-cents)%100;
                dollars = dollars-secondAmount.dollars-1;
                cents = newCents;
            }

        }

        @Override
        public String toString() {
            if(this.cents==0 && this.dollars==0){
                return "0.00";
            }
            if (cents > 9)
                return (dollars + "." + cents);
            else
                return (dollars + ".0" + cents);
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
    public static void main(String[] args) {
        Bank  b= new Bank("100.02");
        b.setBalance("50.01");
        b.setBettedMoney("10.22");
        Bank b2 = new Bank(b);
        System.out.println(b);
        System.out.println(b2);
    }

}
