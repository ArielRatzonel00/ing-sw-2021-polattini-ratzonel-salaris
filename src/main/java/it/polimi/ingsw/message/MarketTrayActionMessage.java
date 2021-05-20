package it.polimi.ingsw.message;

public class MarketTrayActionMessage extends Message{
    private boolean isRow = false;
    int row = 0;
    int col = 0;

    public MarketTrayActionMessage() {
        this.typeOfMessage = "MarketTrayActionMessage";
    }

    public boolean isRow() {
        return isRow;
    }

    public void setRow(boolean row) {
        isRow = row;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }
}
