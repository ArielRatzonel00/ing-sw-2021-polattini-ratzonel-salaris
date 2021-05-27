package it.polimi.ingsw.Network.Client.CModel;

import it.polimi.ingsw.Model.DevelopmentCard;
import it.polimi.ingsw.Model.DevelopmentGrid;
import it.polimi.ingsw.Model.Warehouse;

import java.util.ArrayList;

public class ClientModel {
    private ArrayList<PlayerBoard> playerBoards=new ArrayList<>();
    private boolean isActive=false;
    private MarketTrayClient marketTrayClient=new MarketTrayClient();
    private ArrayList<DevelopmentCard> devGrid = new ArrayList<>();

    public ClientModel(){
        playerBoards.add(new PlayerBoard());
        playerBoards.add(new PlayerBoard());
        playerBoards.add(new PlayerBoard());
        playerBoards.add(new PlayerBoard());
    }

    public ArrayList<PlayerBoard> getPlayerBoards() {
        return playerBoards;
    }

    public void setPlayerBoards(ArrayList<PlayerBoard> playerBoards) {
        this.playerBoards = playerBoards;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public MarketTrayClient getMarketTrayClient() {
        return marketTrayClient;
    }

    public void setMarketTrayClient(MarketTrayClient marketTrayClient) {
        this.marketTrayClient = marketTrayClient;
    }

    public ArrayList<DevelopmentCard> getDevGrid() {
        return devGrid;
    }

    public void setDevGrid(ArrayList<DevelopmentCard> devGrid) {
        this.devGrid = devGrid;
    }
}
