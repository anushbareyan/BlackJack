package am.aua.blackjack.core;

public class Blackjack {
    private static final int NUMBER_OF_DECKS = 6;
    public Deck deck;
    private int numberOfChanges;
    private int numberOfPlayers;
    private Player[] players;
    private Dealer dealer;

    public Blackjack(){
        deck = new Deck();
        players =new Player[0];
        dealer =new Dealer();
    }


    public Player getTurn(){
        return players[numberOfChanges% players.length];
    }

}
