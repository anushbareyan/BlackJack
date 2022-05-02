package am.aua.blackjack.core;

public class NoCardsLeftException extends Exception {
    public NoCardsLeftException() {
        super("No cards left :(");
    }

    public NoCardsLeftException(String message) {
        super(message);
    }
}
