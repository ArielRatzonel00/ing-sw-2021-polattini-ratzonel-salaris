package it.polimi.ingsw.Model;

import it.polimi.ingsw.Model.Marble.MarketMarble;
import it.polimi.ingsw.Network.Messages.Message;
import it.polimi.ingsw.Observer.ModelObservable;
import it.polimi.ingsw.Observer.Observable;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Model extends ModelObservable {

    // Class that represents the Model

    private ArrayList<Player> players;
    private MarketTray marketTray;
    private DevelopmentGrid developmentGrid;
    private MarkerStack markers ;
    private Deck deck = new Deck();
    private boolean IsSinglePlayerGame = false;
    private Player CurrentPlayer;
    private int a;
    public Model() {
        this.developmentGrid = new DevelopmentGrid(deck);
        this.marketTray = new MarketTray();
        this.players = new ArrayList<>();
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public MarketTray getMarketTray() {
        return marketTray;
    }

    public DevelopmentGrid getDevelopmentGrid() {
        return developmentGrid;
    }

    public int getNumberOfPlayers() {
        if (players!=null)
        return players.size();
        else
            return 0;
    } // numero di giocatori

    public void SetInitialResourcesForSecondPlayer(MarketMarble.ColorMarble colorMarble, int row) {
        players.get(1).getWarehouse().addToRow(new MarketMarble(colorMarble), row);
    }
    public void SetInitialResourcesForThirdPlayer(MarketMarble.ColorMarble colorMarble, int row) {
        players.get(2).getWarehouse().addToRow(new MarketMarble(colorMarble), row);
        players.get(2).getFaithTrack().setRedPosition(1);
    }
    public void SetInitialResourcesForForthPlayer(MarketMarble.ColorMarble colorMarble1, int row1,MarketMarble.ColorMarble colorMarble2, int row2 ) {
        players.get(3).getWarehouse().addToRow(new MarketMarble(colorMarble1), row1);
        players.get(3).getWarehouse().addToRow(new MarketMarble(colorMarble2), row2);
        players.get(3).getFaithTrack().setRedPosition(1);
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
            if (player.getWarehouse().getNumberOfTotalResourcesInWarehouse() + player.getStrongbox().getNumberOfTotalResoucesInStrongbox() > MaxResources) {
                winner = player;
                MaxResources = player.getWarehouse().getNumberOfTotalResourcesInWarehouse() + player.getStrongbox().getNumberOfTotalResoucesInStrongbox();
            }
        }
        return winner;
    }

    public Deck getDeck() {
        return deck;
    }

   /*
    public int GetA() {
        return a;
    }
    public void setA(int a) throws IOException {
        this.a=a;
        List<Integer> interi =new ArrayList<>();
        interi.add(5);
        interi.add(324);
        notifyTest(new Message("abc",interi));
    } */
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
