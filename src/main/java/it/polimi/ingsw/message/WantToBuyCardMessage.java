package it.polimi.ingsw.message;

import it.polimi.ingsw.Model.CostOfCard;

import java.util.ArrayList;

public class WantToBuyCardMessage extends Message {
    public WantToBuyCardMessage() {
        this.typeOfMessage = "WantToBuyCardMessage";
    }

    int PlayerIndex = 0;
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

    public int getPlayerIndex() {
        return PlayerIndex;
    }

    public void setPlayerIndex(int playerIndex) {
        PlayerIndex = playerIndex;
    }
}
