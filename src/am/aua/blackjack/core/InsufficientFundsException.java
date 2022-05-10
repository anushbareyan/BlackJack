package am.aua.blackjack.core;

public class InsufficientFundsException extends Exception{
    public InsufficientFundsException() {
        super("Insufficient Funds. You have not enough money!  Try again.");
    }
}
