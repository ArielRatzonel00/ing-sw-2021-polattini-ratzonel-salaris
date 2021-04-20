package it.polimi.ingsw.Model;

import it.polimi.ingsw.Model.Marble.ColoredMarble;

public class CostOfCard {
    private int costNumber;
    private ColoredMarble.ColorMarble costColor;

    public CostOfCard(int costNumber, ColoredMarble.ColorMarble costColor) {
        this.costNumber = costNumber;
        this.costColor = costColor;
    }

    public int getCostNumber() {
        return costNumber;
    }

    public ColoredMarble.ColorMarble getCostColor() {
        return costColor;
    }
}
