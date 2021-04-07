package it.polimi.ingsw.Model;

public class MultiplayerGame {

    private Player[] players;
    private MarketTray marketTray;
    private DevelopmentGrid developmentGrid;
    private MarkerStack markers ;

    public MultiplayerGame(Player[] players, DevelopmentCard[] developmentCards) {
        this.players = players;
        this.developmentGrid = new DevelopmentGrid();
        this.marketTray = new MarketTray();
    }
    private int NumberOfPlayers = players.length;

    public Player[] getPlayers() {
        return players;
    }

    public MarketTray getMarketTray() {
        return marketTray;
    }

    public DevelopmentGrid getDevelopmentGrid() {
        return developmentGrid;
    }

    public int getNumberOfPlayers() {
        return NumberOfPlayers;
    } // numero di giocatori

}

 /*   public void startgame(){
        //Creazione di Development grid
        //Assegnazione di Leader Card a ogni player
        // settaggio di tutte le cose iniziali come creazione di ogni faithTrack/Warehouse ecc per ogni player


    }
    public void finishgame(){
        // Ricordarsi di fare i controlli nelle classi che posso far finire la partita esempio nella classed Faith Track controllare Red Position ecc
        // fai i calcoli per finire la partita



    }

}
  */
