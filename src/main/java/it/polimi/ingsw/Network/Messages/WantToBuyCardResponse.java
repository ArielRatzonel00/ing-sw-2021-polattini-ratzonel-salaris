package it.polimi.ingsw.Network.Messages;

import it.polimi.ingsw.Model.CostOfCard;

import java.util.ArrayList;

public class WantToBuyCardResponse extends Message{
    public WantToBuyCardResponse() {
        this.typeOfMessage = "WantToBuyCardResponse";
    }
    private String phrasetoShow = "";
    private ArrayList<CostOfCard> cost;
    private int slot = 0;
    private int cellRow = 0;
    private int cellCol = 0;

    public String getPhrasetoShow() {
        return phrasetoShow;
    }

    public void setPhrasetoShow(String phrasetoShow) {
        this.phrasetoShow = phrasetoShow;
    }

    public ArrayList<CostOfCard> getCost() {
        return cost;
    }

    public void setCost(ArrayList<CostOfCard> cost) {
        this.cost = cost;
    }

    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }

    public int getCellRow() {
        return cellRow;
    }

    public void setCellRow(int cellRow) {
        this.cellRow = cellRow;
    }

    public int getCellCol() {
        return cellCol;
    }

    public void setCellCol(int cellCol) {
        this.cellCol = cellCol;
    }
}
