package am.aua.blackjack.core;

public class Blackjack {
    private static final int NUMBER_OF_DECKS = 6;
    public Deck deck;
    private int numberOfPlayers;
    private Player[] players;
    private Dealer dealer;

    public Blackjack(){
        deck = new Deck();
        players =new Player[1];
        players[0] = new Player();
        dealer =new Dealer();
    }
    public Blackjack(int numberOfPlayers, String...names){
        deck = new Deck();
        players =new Player[numberOfPlayers];
        this.numberOfPlayers = numberOfPlayers;
        for(int i=0;i<numberOfPlayers;i++){
            players[i]= new Player(names[i], deck);
        }
        dealer =new Dealer(deck);
    }
    public Blackjack(Blackjack game){
        this.dealer = new Dealer(game.deck);
        this.deck=game.deck;
        for(int i=0;i<numberOfPlayers;i++){
            players[i]= new Player(game.players[i].getName(),game.players[i].getBank(), game.deck);
        }
        this.numberOfPlayers = game.numberOfPlayers;
    }

    public int getNumberOfPlayers(){
        return numberOfPlayers;
    }

    public Player[] getPlayers(){
        Player[] copy = new Player[players.length];
        for(int i=0;i<players.length;i++){
            copy[i]= players[i].clone();
        }
        return copy;
    }
    public Dealer getDealer(){
        return dealer.clone();
    }

    public void indexPlayerMakeBet(String amount, int numberOfPlayer) throws InsufficientFundsException, InvalidMoneyInputException, NoMoneyException {
        players[numberOfPlayer].makeBet(amount);
    }
    public void removePlayerFromArray(int index){
        Player[] result =new Player[players.length-1];
        for (int i = 0, k = 0; i <players.length; i++) {
            if (i == index) {
                continue;
            }
            result[k++] = players[i];
        }
        players =result;
    }

    public void playerHit(int numberOfPlayer){
        players[numberOfPlayer].hit(deck);
    }
    public void dealerHit(){
        dealer.hit(deck);
    }

    public void setBettedMoney(int index, String amount){
        players[index].setBettedMoney(amount);
    }

    public void payBack(int index, String amount){
        players[index].addMoneyToBalance(players[index].getBank().getBettedMoney());
    }
    public void payWinningToPlayer(int index){
        players[index].addWinToBalance();
    }

    public void updateParticipantsHandAfterRound(){
        for(int i = 0; i<players.length;i++){
            players[i].updateHandAfterRound(deck);
        }
        dealer.updateHandAfterRound(deck);
    }
    public boolean isGameOver(){
        return false;
    }
}
