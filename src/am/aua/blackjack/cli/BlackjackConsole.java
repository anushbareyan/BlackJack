package am.aua.blackjack.cli;

import am.aua.blackjack.core.Blackjack;
import am.aua.blackjack.core.InsufficientFundsException;

import java.util.Scanner;

public class BlackjackConsole {
    private Blackjack game;

    public void run(){
        Scanner sc = new Scanner(System.in);
        String inputLine;

        System.out.println("Welcome to Blackjack Console! ^-^");
        printInstructions();
        inputLine = sc.nextLine();

        while(!inputLine.equals("q")){
            if (inputLine.equals("p")) {
                System.out.println("enter your name: ");
                game = new Blackjack(1,sc.nextLine());
                play();
            }else if (inputLine.startsWith("p ")) {
                int playerNumber = Integer.parseInt(inputLine.substring(2));
                String[] names = new String[playerNumber];
                System.out.println("enter your names separated by a linebreak only: ");
                for(int i=0;i<playerNumber;i++){
                    names[i] = sc.nextLine();
                }
                game = new Blackjack(playerNumber, names);
                play();
            } else {
                System.out.println("Unknown instruction. Please try again.");
            }
            printInstructions();
            inputLine = sc.nextLine();
        }

    }

    public void play(){
        Scanner sc = new Scanner(System.in);
        String inputLine;
        while(!game.isGameOver()){
            for(int i=0; i<game.getNumberOfPlayers();i++){
                System.out.println(game.getPlayers()[i].toStringOnlyBank());
                System.out.println("Enter the amount of bet with the following format--> 100.00");
                String StringAmount = sc.nextLine();
                boolean success = false;
                while(!success){
                    try {
                        game.indexPlayerMakeBet(StringAmount, i);
                        success =true;
                    } catch (InsufficientFundsException e) {
                        System.out.println(e.getMessage());
                        System.out.println("Enter the amount of bet with the following format--> 100.00");
                        StringAmount = sc.nextLine();
                    }

                }
            }
            boolean isDealerCardHidden = true;
            for(int i=0; i<game.getNumberOfPlayers();i++) {
                boolean success = false;
                System.out.println(game.getPlayers()[i].toStringWithBank()+"\n");
                if(!isDealerCardHidden){
                    System.out.println(game.getDealer()+"\n");
                }else{
                    System.out.println(game.getDealer().toStringWhenHidden()+"\n");
                }
                while(!success) {
                    System.out.println("Enter hit, if you want to hit, enter stand if you want to stand, write double if you want to double");
                    String instruction = sc.nextLine();
                    if (instruction.equals("hit")) {
                        game.playerHit(i);
                        System.out.println(game.getPlayers()[i]+"\n");
                        System.out.println(game.getDealer().toStringWhenHidden());
                        if(game.getPlayers()[i].getHand().getValueOfCardsInHand()>=21){
                            success =true;
                            continue;
                        }
                    }else if(instruction.equals("double")){
                        game.playerHit(i);
                        System.out.println(game.getPlayers()[i]+"\n");
                        System.out.println(game.getDealer().toStringWhenHidden());
                        try {
                            game.indexPlayerMakeBet(game.getPlayers()[i].getBank().getBettedMoney(), i);
                        } catch (InsufficientFundsException e) {
                            System.out.println(e.getMessage());
                        }
                    }else if(instruction.equals("stand")){
                        success=true;
                        //isDealerCardHidden=false;
                        continue;
                    }else{
                        System.out.println("Unknown instruction. Please try again.");
                        continue;
                    }
                }


            }
            while(game.getDealer().getHand().getValueOfCardsInHand()<17){
                game.dealerHit();
            }
            System.out.println(game.getDealer()+"\n");
            for(int j=0; j<game.getNumberOfPlayers();j++) {
                int dealerValueOfHand =game.getDealer().getHand().getValueOfCardsInHand();
                int playerValueOfHand =game.getPlayers()[j].getHand().getValueOfCardsInHand();
                if(playerValueOfHand>21){
                    System.out.println("\n"+game.getPlayers()[j].getName()+" busted! ;("+"\n");
                    game.setBettedMoney(j,"0.00");
                    System.out.println(game.getPlayers()[j].toStringOnlyBank());
                }
                else{

                    if(dealerValueOfHand>21){
                        System.out.println("\n"+game.getPlayers()[j].getName()+" Won! :)");
                        game.payBack(j,game.getPlayers()[j].getBank().getBettedMoney());
                        game.payBack(j,game.getPlayers()[j].getBank().getBettedMoney());
                        game.setBettedMoney(j,"0.00");
//                        System.out.println(game.getPlayers()[j].toStringOnlyBank());
                    }else if(playerValueOfHand==dealerValueOfHand){
                        System.out.println("\n"+game.getPlayers()[j].getName()+" has a push! :|");
                        game.payBack(j,game.getPlayers()[j].getBank().getBettedMoney());
                        game.setBettedMoney(j,"0.00");
//                        System.out.println(game.getPlayers()[j].toStringOnlyBank());
                    }else if(playerValueOfHand<dealerValueOfHand){
                        System.out.println("\n"+game.getPlayers()[j].getName()+" busted! ;("+"\n");
                        game.setBettedMoney(j,"0.00");
//                        System.out.println(game.getPlayers()[j].toStringOnlyBank());
                    }else{
                        System.out.println("\n"+game.getPlayers()[j].getName()+" Won! :)");
                        game.payBack(j,game.getPlayers()[j].getBank().getBettedMoney());
                        game.payBack(j,game.getPlayers()[j].getBank().getBettedMoney());
                        game.setBettedMoney(j,"0.00");
                    }
                }
            }
        }

    }

    public void print(){
        System.out.println( );
    }

    private void printInstructions() {
        System.out.println("Input 'p' to play Blackjack alone ;)");
        System.out.println("Input 'p <number>' to play Blackjack with <number> friends! :)");
        System.out.println("If you want to end the program, input 'q' :(");
    }
}
