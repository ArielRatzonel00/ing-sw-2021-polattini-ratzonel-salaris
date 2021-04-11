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

    public void addToRow(MarketMarble rowMarble, int row) {
        if (row == 1) {
            row1 = rowMarble;
            Colorrow1 = rowMarble.getColorMarble();
        }
        else if(row == 2){
            if (this.row2[0] == null){
                row2[0] = rowMarble;
                Colorrow2 = rowMarble.getColorMarble();
            }
            else if (this.row2[1] == null && Colorrow2 == rowMarble.getColorMarble()){
                row2[1] = rowMarble;
            }
            else {
                // Can't put Marble here
            }
        }
        else if(row == 3){
            if (this.row3[0] == null){
                row3[0] = rowMarble;
                Colorrow3 = rowMarble.getColorMarble();
            }
            else if (this.row3[1] == null && Colorrow3 == rowMarble.getColorMarble()){
                row3[1] = rowMarble;
            }
            else if (this.row3[2] == null && Colorrow3 == rowMarble.getColorMarble()){
                row3[2] = rowMarble;
            }
            else {
                // Can't put Marble here
            }

        }
    }
    public MarketMarble RemoveResource(int row){
        MarketMarble temp = null;
        if (row == 1){
            temp = row1;
            row1 = null;
        }
        else if (row == 2){
            if (row2[1] != null){
                temp = row2[1];
                row2[1] = null;
            }
            else {
                temp = row2[0];
                row2[0] = null;
            }
        }
        else if(row == 3){
            if (row3[2] != null){
                temp = row3[2];
                row3[2] = null;
            }
            else if (row2[1] != null){
                temp = row3[1];
                row3[1] = null;
            }
            else {
                temp = row3[0];
                row3[0] = null;
            }

        }
        return temp;
    }
        public void moveResources (int FromRow, int toRow){

    }
        public boolean CheckWarehouse(){
        return true;

        }
    }



// funzione per gestire i row extra
        // funzione per togliere
        // funzione per muovere

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

