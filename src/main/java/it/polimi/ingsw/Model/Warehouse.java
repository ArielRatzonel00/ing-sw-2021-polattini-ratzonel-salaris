package it.polimi.ingsw.Model;

public class Warehouse {
    private MarketMarble.ColorMarble Colorrow1;
    private MarketMarble.ColorMarble Colorrow2;
    private MarketMarble.ColorMarble Colorrow3;
    private MarketMarble.ColorMarble ColorrowExtra1;
    private MarketMarble.ColorMarble ColorrowExtra2;
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

    public void addToRow1(MarketMarble row1Marble) {
        row1 = row1Marble;
        Colorrow1 = row1Marble.getColorMarble();
    }

    public void addToRow2(MarketMarble row2Marble) {
        if (this.row2[0] == null){
            row2[0] = row2Marble;
            Colorrow2 = row2Marble.getColorMarble();
        }
        else if (this.row2[1] == null && Colorrow2 == row2Marble.getColorMarble()){
            row2[1] = row2Marble;
        }
        else {
            // Can't put Marble here
        }
    }

    public void addToRow3(MarketMarble row3Marble) {
        if (this.row3[0] == null){
            row3[0] = row3Marble;
            Colorrow3 = row3Marble.getColorMarble();
        }
        else if (this.row3[1] == null && Colorrow3 == row3Marble.getColorMarble()){
            row3[1] = row3Marble;
        }
        else if (this.row3[2] == null && Colorrow3 == row3Marble.getColorMarble()){
            row3[2] = row3Marble;
        }
        else {
            // Can't put Marble here
        }

        // funzione per gestire i row extra
        // funzione per togliere
        // funzione per muovere
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

