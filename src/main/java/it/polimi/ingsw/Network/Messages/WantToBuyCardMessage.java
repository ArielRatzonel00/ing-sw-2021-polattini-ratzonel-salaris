package it.polimi.ingsw.Network.Messages;

import it.polimi.ingsw.Model.CostOfCard;

import java.util.ArrayList;

public class WantToBuyCardMessage extends Message {
    public WantToBuyCardMessage() {
        this.typeOfMessage = "WantToBuyCardMessage";
    }
    int slot;

    int row = 0;
    int col = 0;
    ArrayList<CostOfCard> costOfCards;

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public ArrayList<CostOfCard> getCostOfCards() {
        return costOfCards;
    }

    public void setCostOfCards(ArrayList<CostOfCard> costOfCards) {
        this.costOfCards = costOfCards;
    }

    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }
}
