package am.aua.blackjack.core;

public class NoCardsLeftException extends Exception {
    public NoCardsLeftException() {
        super("shuffling again");
    }

    public NoCardsLeftException(String message) {
        super(message);
    }
}
