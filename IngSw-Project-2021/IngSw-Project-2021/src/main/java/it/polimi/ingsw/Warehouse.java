package it.polimi.ingsw;

public class Warehouse {
    private MarketMarble row1;
    private MarketMarble[] row2 = new MarketMarble[2];
    private MarketMarble[] row3 = new MarketMarble[3];
    private MarketMarble[] rowextra1 = new MarketMarble[2];
    private MarketMarble[] rowextra2 = new MarketMarble[2];
    private MarketMarble temp1;

    public MarketMarble getRow1() {
        return row1;
    }
    public MarketMarble[] getRow2() {
        return row2;
    }
    public MarketMarble[] getRow3() {
        return row3;
    }

    public MarketMarble[] getRowextra1() {
        return rowextra1;
    }

    public MarketMarble[] getRowextra2() {
        return rowextra2;
    }
}

/*
    public void addResourcesRow1(MarketMarble MarketMarble){

    }

    public void addResourcesRow2(MarketMarble[] MarketMarble){

    }
    public void addResourcesRow3(MarketMarble[] MarketMarble){

    }
    public void moveResources(){

    }
     */
