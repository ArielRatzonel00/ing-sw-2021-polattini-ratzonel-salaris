package it.polimi.ingsw.Network.Messages;

import it.polimi.ingsw.Model.Marble.MarketMarble;

import java.util.ArrayList;

public class DealWithResourcesFromMarketTrayMessage extends Message{

    private ArrayList<Boolean> keeps = new ArrayList<>();
    private ArrayList<MarketMarble.ColorMarble> marbles = new ArrayList<>();
    private ArrayList<Integer> rows = new ArrayList<>();
    public DealWithResourcesFromMarketTrayMessage() {
        this.typeOfMessage = "DealWithResourcesFromMarketTrayMessage";
    }

    public ArrayList<Boolean> getKeeps() {
        return keeps;
    }

    public ArrayList<MarketMarble.ColorMarble> getMarbles() {
        return marbles;
    }

    public ArrayList<Integer> getRows() {
        return rows;
    }

    public void setKeeps(boolean keep) {
        this.keeps.add(keep);
    }

    public void setMarbles(MarketMarble.ColorMarble marble) {
        this.marbles.add(marble);
    }

    public void setRows(int row) {
        this.rows.add(row);
    }
}
