package it.polimi.ingsw.Model;

import it.polimi.ingsw.Model.Markers.Marker;

import java.util.ArrayList;

public class SinglePlayerGame {

    private Player Player;
    private MarketTray marketTray;
    private DevelopmentGrid developmentGrid;
    private MarkerStack markers ;
    private int CountForMarkerStack;
    public SinglePlayerGame(Player player, DevelopmentCard[] developmentCards, ArrayList<Marker> markers ) {
        this.Player = player;
        this.developmentGrid = new DevelopmentGrid();
        this.marketTray = new MarketTray();
        this.markers = new MarkerStack(); // creare classe MarkerStack
    }
    public it.polimi.ingsw.Model.Player getPlayer() {
        return Player;
    }

    public MarketTray getMarketTray() {
        return marketTray;
    }

    public DevelopmentGrid getDevelopmentGrid() {
        return developmentGrid;
    }

    public MarkerStack getMarkers() {
        return markers;
    }

    public int getCountForMarkerStack() {
        return CountForMarkerStack;
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
