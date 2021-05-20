package it.polimi.ingsw.message;

import it.polimi.ingsw.Model.Marble.MarketMarble;

public class DealWithAResourceFromMarketTrayMessage {
    private int PlayerIndex = 0;
    private boolean keep = false;
    private int rowOfTheWarehouse = 0;
    private MarketMarble.ColorMarble colorChangeWhite;

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

    public MarketMarble.ColorMarble getColorChangeWhite() {
        return colorChangeWhite;
    }

    public void setColorChangeWhite(MarketMarble.ColorMarble colorChangeWhite) {
        this.colorChangeWhite = colorChangeWhite;
    }

    public int getPlayerIndex() {
        return PlayerIndex;
    }

    public void setPlayerIndex(int playerIndex) {
        PlayerIndex = playerIndex;
    }
}
