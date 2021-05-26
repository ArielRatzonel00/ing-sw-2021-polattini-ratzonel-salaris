package it.polimi.ingsw.Network.Client;

import it.polimi.ingsw.Model.Warehouse;

public class ClientModel {
    int numberOfPlayers;
    int totalDevCards=0;

    public ClientModel(){

    }



    /*
    MARKETTRAY is a 4x4 matrix, in which
        0 = GREY,
        1 = YELLOW,
        2 = PURPLE,
        3 = BLUE,
        4 = RED,
        5 = WHITE,
     */ public int[][] marketTray=new int[4][4];

    /*
    STRONGBOX is an Array of 4 elements, in which positions rapresent
        0 = GREY/STONE,
        1 = YELLOW/GOLD,
        2 = PURPLE/SERVANT,
        3 = BLUE/SHIELD,
 */ public int[] strongBox = new int[4];


    public Warehouse clientWarehouse = new Warehouse();

    /*
    DEVCARDSTABLE
     First index [1] = an integer between 1 and 16 representing the position of the card on the table
     Second index[6] = representing the cost, in which:
        position[0] = STONE cost
        position[1] = GOLD cost
        position[2] = SERVANT cost
        position[3] = SHIELD cost
    */public int[][] devCardsTable = new int[1][4];

    /*
    FAITHTRACKS
     First index [1] = numberOfPlayers
     Second index[1] = playerPosition (1-28)
    */public int[][] faithTracks = new int[1][1];

    /*
    DEVCARDSLOT
     First index [1] = an integer between 1 and 4(3+1extra) representing the position of slot
     Second index[6] = representing the production cost, in which:
        position[0] = STONE cost
        position[1] = GOLD cost
        position[2] = SERVANT cost
        position[3] = SHIELD cost
    */public int[][] devCardSlot = new int[1][4];

    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public void setNumberOfPlayers(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }

    public int getTotalDevCards() {
        return totalDevCards;
    }

    public void setTotalDevCards(int totalDevCards) {
        this.totalDevCards = totalDevCards;
    }

    public int[][] getMarketTray() {
        return marketTray;
    }

    public void setMarketTray(int[][] marketTray) {
        this.marketTray = marketTray;
    }

    public int[] getStrongBox() {
        return strongBox;
    }

    public void setStrongBox(int[] strongBox) {
        this.strongBox = strongBox;
    }

    public Warehouse getClientWarehouse() {
        return clientWarehouse;
    }

    public void setClientWarehouse(Warehouse clientWarehouse) {
        this.clientWarehouse = clientWarehouse;
    }

    public int[][] getDevCardsTable() {
        return devCardsTable;
    }

    public void setDevCardsTable(int[][] devCardsTable) {
        this.devCardsTable = devCardsTable;
    }

    public int[][] getFaithTracks() {
        return faithTracks;
    }

    public void setFaithTracks(int[][] faithTracks) {
        this.faithTracks = faithTracks;
    }

    public int[][] getDevCardSlot() {
        return devCardSlot;
    }

    public void setDevCardSlot(int[][] devCardSlot) {
        this.devCardSlot = devCardSlot;
    }
}
