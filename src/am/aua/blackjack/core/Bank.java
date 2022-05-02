package am.aua.blackjack.core;
//TODO inner clas????
//TODO Blackjackum klor tverov en bet dnum. stegh vonc dnem ?
public class Bank {//TODO petka voobshe Bank arandzin??
    private double balance;//TODO money n normala double?
    private double bettedMoney;//TODO petqa??

    public Bank(){
        balance=1000;
        bettedMoney =0;
    }

    public Bank(double balance){
        this.balance=balance;
    }

    public double getBalance(){
        return balance;
    }

    public void setBalance(double money){//TODO petqa exception anel???
        if(money>=0){
            this.balance=money;
        }
    }
    public void setBettedMoney(double money){//TODO petqa exception anel???
        if(money>=0 && money<=balance){
            this.bettedMoney=money;
        }
    }
    @Override
    public String toString() {
        return "Bank: "+ balance+"$"+"\nBetted money:"+bettedMoney+"$";
    }
}
