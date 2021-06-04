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

    public void printDevGrid(int level){
        switch (level){
            case 1:
                for (int i = 0; i< 4;i++) {
                    if (devGrid.get(i) != null) {
                        System.out.println("[" + i + "]");
                        devGrid.get(i).printCard();
                    } else {
                        System.out.println("no card");
                    }
                }
                break;
            case 2:
                for (int i = 4; i < 8; i++){
                    if (devGrid.get(i) != null) {
                        System.out.println(i + "\n");
                        devGrid.get(i).printCard();
                    } else {
                        System.out.println("no card");
                    }
                }
                break;
            case 3:
                for (int i = 8; i < 12; i++){
                    if (devGrid.get(i) != null) {
                        System.out.println(i + "\n");
                        devGrid.get(i).printCard();
                    } else {
                        System.out.println("no card");
                    }
                }
                break;
        }
    }
}
