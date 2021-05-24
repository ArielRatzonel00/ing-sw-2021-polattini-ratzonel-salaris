package it.polimi.ingsw.Network.Messages;

import it.polimi.ingsw.Model.Marble.MarketMarble;

import java.util.ArrayList;

public class DealWithAResourceFromMarketTrayMessage extends Message{
    private int PlayerIndex = 0;
    private boolean Keep = false;
    private int rowOfTheWarehouse = 0;
    private MarketMarble.ColorMarble marble;

    public DealWithAResourceFromMarketTrayMessage() {
        this.typeOfMessage = "DealWithAResourceFromMarketTrayMessage";
    }

    public int getPlayerIndex() {
        return PlayerIndex;
    }

    public void setPlayerIndex(int playerIndex) {
        PlayerIndex = playerIndex;
    }

    public boolean isKeep() {
        return Keep;
    }

    public void setKeep(boolean keep) {
        Keep = keep;
    }

    public int getRowOfTheWarehouse() {
        return rowOfTheWarehouse;
    }

    public void setRowOfTheWarehouse(int rowOfTheWarehouse) {
        this.rowOfTheWarehouse = rowOfTheWarehouse;
    }

    public MarketMarble.ColorMarble getMarble() {
        return marble;
    }

    public void setMarble(MarketMarble.ColorMarble marble) {
        this.marble = marble;
    }
}
