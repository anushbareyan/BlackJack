package am.aua.blackjack.core;

public class NoMoneyException extends Exception{
    public NoMoneyException() {
        super("You lost all your money. Game over.");
    }
}
