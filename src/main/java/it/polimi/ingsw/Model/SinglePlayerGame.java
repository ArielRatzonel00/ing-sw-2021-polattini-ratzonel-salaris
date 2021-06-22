package it.polimi.ingsw.Model;

import it.polimi.ingsw.Model.Markers.Marker;

import java.util.ArrayList;

// Class that represents the SinglePlayerGame

public class SinglePlayerGame {

    private Player Player;
    private MarketTray marketTray;
    private DevelopmentGrid developmentGrid;
    private MarkerStack markers ;
    private Deck deck = new Deck();


    public SinglePlayerGame(Player player) {
        this.Player = player;
        this.developmentGrid = new DevelopmentGrid(deck);
        this.marketTray = new MarketTray();
        this.markers = new MarkerStack(); // creare classe MarkerStack
    }

    public Player getPlayer() {
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

    public Deck getDeck() {
        return deck;
    }
}
