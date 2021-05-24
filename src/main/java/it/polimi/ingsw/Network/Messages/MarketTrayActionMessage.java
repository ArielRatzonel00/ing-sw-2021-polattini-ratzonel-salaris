package it.polimi.ingsw.Network.Messages;

public class MarketTrayActionMessage extends Message{
    private boolean isRow = false;
    int index = 0;

    public MarketTrayActionMessage() {
        this.typeOfMessage = "MarketTrayActionMessage";
    }

    public boolean isRow() {
        return isRow;
    }

    public void setRow(boolean row) {
        isRow = row;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
