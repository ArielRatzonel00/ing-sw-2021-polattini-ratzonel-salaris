package it.polimi.ingsw.Network.Messages;

import it.polimi.ingsw.Model.Marble.MarketMarble;
import it.polimi.ingsw.Model.MarketTray;

import java.util.ArrayList;

public class MarketTrayActionResponse extends Message{
    private MarketMarble[][] marketTray;
    private MarketMarble outsideMarble;
    private ArrayList<MarketMarble> returnedmarbles;
    private MarketMarble.ColorMarble ChangeWhite1;
    private MarketMarble.ColorMarble ChangeWhite2;

    public MarketMarble.ColorMarble getChangeWhite1() {
        return ChangeWhite1;
    }

    public void setChangeWhite1(MarketMarble.ColorMarble changeWhite1) {
        ChangeWhite1 = changeWhite1;
    }

    public MarketMarble.ColorMarble getChangeWhite2() {
        return ChangeWhite2;
    }

    public void setChangeWhite2(MarketMarble.ColorMarble changeWhite2) {
        ChangeWhite2 = changeWhite2;
    }

    public MarketTrayActionResponse() {
        this.typeOfMessage = "MarketTrayActionResponse";
    }

    public MarketMarble[][] getMarketTray() {
        return marketTray;
    }

    public void setMarketTray(MarketMarble[][] marketTray) {
        this.marketTray = marketTray;
    }

    public MarketMarble getOutsideMarble() {
        return outsideMarble;
    }

    public void setOutsideMarble(MarketMarble outsideMarble) {
        this.outsideMarble = outsideMarble;
    }

    public ArrayList<MarketMarble> getReturnedmarbles() {
        return returnedmarbles;
    }

    public void setReturnedmarbles(ArrayList<MarketMarble> returnedmarbles) {
        this.returnedmarbles = returnedmarbles;
    }
}
