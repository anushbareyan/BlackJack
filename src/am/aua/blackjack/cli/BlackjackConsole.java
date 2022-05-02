package am.aua.blackjack.cli;

import am.aua.blackjack.core.BlackJack;

import java.util.Scanner;

public class BlackjackConsole {
    private BlackJack game;

    public void run(){
        Scanner sc = new Scanner(System.in);
        String inputLine;

        System.out.println("Welcome to Blackjack Console!");
        printInstructions();
        inputLine = sc.nextLine();

        while(!inputLine.equals("q")){
            if (inputLine.equals("p")) {
                game = new BlackJack();
                play();
            }
        }
    }

    public void play(){

    }
/*
    public void play() {
        Scanner sc = new Scanner(System.in);
        String inputLine;

        print();

        while (!game.isGameOver()) {
            if (game.getTurn() == Chess.PieceColor.WHITE)
                System.out.println("White's move: ");
            else
                System.out.println("Black's move: ");

            inputLine = sc.nextLine();
            String[] input = inputLine.split(" ");

            Position p1 = null, p2 = null;

            if (input.length >= 1) {
                if (input[0].equals("resign")) {
                    System.out.println(game.getTurn() + " has resigned.");
                    return;
                }

                if (input[0].equals("debug")) {
                    debug();
                    print();
                    continue;
                }

                p1 = Position.generateFromString(input[0]);

                if (p1 == null || game.getPieceAt(p1) == null) {
                    System.out.println("Invalid position. Please try again.");
                    continue;
                }

                if (input.length == 1) {
                    // Players are informed about wrong turns, but the squares for
                    // the opponent's piece are still highlighted
                    if (game.getPieceAt(p1).getPieceColor() != game.getTurn())
                        System.out.println("That piece belongs to the opponent.");
                    print(p1);
                }
                else if (input.length == 2) {
                    if (game.getPieceAt(p1).getPieceColor() != game.getTurn()) {
                        System.out.println("That piece belongs to the opponent.");
                        continue;
                    }

                    boolean success = false;

                    p2 = Position.generateFromString(input[1]);

                    // checking if p1 != null is not necessary
                    // its negation is already checked on line 59
                    if (p2 != null) {
                        Move m = new Move(p1, p2);
                        success = game.performMove(m);
                    }
                    if (!success)
                        System.out.println("Invalid move. Please try again.");

                    print();
                }
            }
        }
    }
 */

    private void printInstructions() {
        System.out.println("Input 'p' to play Blackjack.");
        System.out.println("If you want to end the program, input 'q'.");
    }
}
