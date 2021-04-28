package it.polimi.ingsw.Model;

import java.util.ArrayList;

public class MultiplayerGame {

    // Class that represents the MultiplayerGame

    private Player[] players;
    private MarketTray marketTray;
    private DevelopmentGrid developmentGrid;
    private MarkerStack markers ;
    private Deck deck = new Deck();
    public MultiplayerGame(Player[] players) {
        this.players = players;
        this.developmentGrid = new DevelopmentGrid(deck);
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

    public void SetInitialResources(){
        int i = 0;
        for (Player player : players) {
            if (i == 1) {
                // Stampa all'utente 2 "scegli una risorsa a scelta con cui partire e in che riga la vuoi mettere,
                // MarbleChosen = new Marble del colore scelto
                //player.getWarehouse().addToRow(MarbleChosen,rowChosen)
            } else if (i == 2) {
                // Stampa all'utente 3 "scegli una risorsa a scelta con cui partire e in che riga la vuoi mettere,
                // MarbleChosen = new Marble del colore scelto
                //player.getWarehouse().addToRow(MarbleChosen,rowChosen)
                player.getFaithTrack().setRedPosition(1);

            } else if (i == 4) {
                // Stampa all'utente 4 "scegli due risorse a scelta con cui partire e in che riga le vuoi mettere,
                // MarbleChosen1 = new Marble del colore scelto
                // MarbleChosen2 = new Marble del colore scelto
                //player.getWarehouse().addToRow(MarbleChosen1,rowChosen1)
                //player.getWarehouse().addToRow(MarbleChosen2,rowChosen2)
                player.getFaithTrack().setRedPosition(1);

            }
            i++;
        }
    }
    public Player GetWinner() {
        int MaxPoints = 0;
        int MaxResources = 0;
        Player winner = null;
        ArrayList<Player> PlayersWithMorePoints = new ArrayList<>();
        for (Player player : players) {
            if (player.GetTotalPoints() > MaxPoints) {
                for (int i = 0; i < PlayersWithMorePoints.size(); i++) {
                    PlayersWithMorePoints.remove(PlayersWithMorePoints.size() - 1);
                }
                PlayersWithMorePoints.add(player);
            } else if (player.GetTotalPoints() == MaxPoints) {
                PlayersWithMorePoints.add(player);
            }
        }
        for (Player player : PlayersWithMorePoints) {
            if (player.getWarehouse().getNumberOfTotalResoucesInWarehouse() + player.getStrongbox().getNumberOfTotalResoucesInStrongbox() > MaxResources) {
                winner = player;
                MaxResources = player.getWarehouse().getNumberOfTotalResoucesInWarehouse() + player.getStrongbox().getNumberOfTotalResoucesInStrongbox();
            }
        }
        return winner;
    }

    public Deck getDeck() {
        return deck;
    }
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
