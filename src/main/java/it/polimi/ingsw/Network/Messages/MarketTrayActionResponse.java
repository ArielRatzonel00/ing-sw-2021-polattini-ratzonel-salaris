package it.polimi.ingsw.Network.Messages;

import it.polimi.ingsw.Model.Marble.MarketMarble;
import it.polimi.ingsw.Model.MarketTray;

import java.util.ArrayList;

public class MarketTrayActionResponse extends Message{
    private MarketTray marketTray;
    private ArrayList<MarketMarble> returnedmarbles;
    public MarketTrayActionResponse() {
        this.typeOfMessage = "MarketTrayActionResponse";
    }

    public MarketTray getMarketTray() {
        return marketTray;
    }

    public void setMarketTray(MarketTray marketTray) {
        this.marketTray = marketTray;
    }

    public ArrayList<MarketMarble> getReturnedmarbles() {
        return returnedmarbles;
    }

    public void setReturnedmarbles(ArrayList<MarketMarble> returnedmarbles) {
        this.returnedmarbles = returnedmarbles;
    }
}
