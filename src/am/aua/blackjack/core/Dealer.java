package am.aua.blackjack.core;

public class Dealer extends Hand{
    public Dealer(){
        super();
    }
    public String toString(){
        String str="";
        str = str + "HIDDEN ";
        Card[] dealHand =this.getHand();
        for(int i=1;i<dealHand.length;i++){
            str=str+dealHand[i]+ " "+ dealHand[i].getIntValue()+"\n";
        }
        return str;
    }

    public static void main(String[] args) {
        Dealer d = new Dealer();
        System.out.println(d);
    }





}
