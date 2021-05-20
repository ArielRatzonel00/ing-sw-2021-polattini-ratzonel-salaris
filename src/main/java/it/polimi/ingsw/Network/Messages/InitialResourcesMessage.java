package it.polimi.ingsw.Network.Messages;

import it.polimi.ingsw.Model.Marble.MarketMarble;
import it.polimi.ingsw.Model.Player;

import java.util.ArrayList;

public class InitialResourcesMessage extends Message{
    private int PlayerIndex = 0;
    private MarketMarble.ColorMarble colorMarble1;
    private int row1;
    private MarketMarble.ColorMarble colorMarble2;
    private int row2;

    public InitialResourcesMessage() {
        this.typeOfMessage = "InitialResourcesMessage";
    }

    public void setPlayerIndex(int playerIndex) {
        PlayerIndex = playerIndex;
    }

    public void setColorMarble1(MarketMarble.ColorMarble colorMarble1) {
        this.colorMarble1 = colorMarble1;
    }

    public void setRow1(int row1) {
        this.row1 = row1;
    }

    public void setColorMarble2(MarketMarble.ColorMarble colorMarble2) {
        this.colorMarble2 = colorMarble2;
    }

    public void setRow2(int row2) {
        this.row2 = row2;
    }

    public int getPlayerIndex() {
        return PlayerIndex;
    }

    public MarketMarble.ColorMarble getColorMarble1() {
        return colorMarble1;
    }

    public int getRow1() {
        return row1;
    }

    public MarketMarble.ColorMarble getColorMarble2() {
        return colorMarble2;
    }

    public int getRow2() {
        return row2;
    }
}
