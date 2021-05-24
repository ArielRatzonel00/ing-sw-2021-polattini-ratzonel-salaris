package it.polimi.ingsw.Model;

// Class that represents a structure that has a number and a color

import it.polimi.ingsw.Model.Marble.MarketMarble;

import java.io.Serializable;

public class CostOfCard implements Serializable {
    private int costNumber;
    private MarketMarble.ColorMarble costColor;

    public CostOfCard(int costNumber, MarketMarble.ColorMarble costColor) {
        this.costNumber = costNumber;
        this.costColor = costColor;
    }

    public int getCostNumber() {
        return costNumber;
    }

    public MarketMarble .ColorMarble getCostColor() {
        return costColor;
    }
}
