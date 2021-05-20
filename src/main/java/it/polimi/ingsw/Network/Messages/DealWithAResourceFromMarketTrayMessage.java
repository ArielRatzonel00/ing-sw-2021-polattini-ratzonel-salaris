package it.polimi.ingsw.Network.Messages;

import it.polimi.ingsw.Model.Marble.MarketMarble;

public class DealWithAResourceFromMarketTrayMessage extends Message{
    private int PlayerIndex = 0;
    private boolean keep = false;
    private int rowOfTheWarehouse = 0;
    private MarketMarble.ColorMarble colorMarble;

    public DealWithAResourceFromMarketTrayMessage() {
        this.typeOfMessage = "DealWithAResourceFromMarketTrayMessage";
    }

    public boolean isKeep() {
        return keep;
    }

    public void setKeep(boolean keep) {
        this.keep = keep;
    }

    public int getRowOfTheWarehouse() {
        return rowOfTheWarehouse;
    }

    public void setRowOfTheWarehouse(int rowOfTheWarehouse) {
        this.rowOfTheWarehouse = rowOfTheWarehouse;
    }

    public MarketMarble.ColorMarble getColorMarble() {
        return colorMarble;
    }

    public void setColorMarble(MarketMarble.ColorMarble colorMarble) {
        this.colorMarble = colorMarble;
    }

    public int getPlayerIndex() {
        return PlayerIndex;
    }

    public void setPlayerIndex(int playerIndex) {
        PlayerIndex = playerIndex;
    }
}
