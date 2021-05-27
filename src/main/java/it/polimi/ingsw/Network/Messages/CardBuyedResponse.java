package it.polimi.ingsw.Network.Messages;

import it.polimi.ingsw.Model.Production;
import it.polimi.ingsw.Model.SlotsBoard;
import it.polimi.ingsw.Model.Strongbox;
import it.polimi.ingsw.Model.Warehouse;

import java.util.ArrayList;

public class CardBuyedResponse extends Message{
    Warehouse newwarehouse;
    Strongbox newstrongbox;
    SlotsBoard slotsBoard;
    ArrayList<Production> newproductionAvailables;

    public ArrayList<Production> getNewproductionAvailables() {
        return newproductionAvailables;
    }

    public void setNewproductionAvailables(ArrayList<Production> newproductionAvailables) {
        this.newproductionAvailables = newproductionAvailables;
    }

    int col;
    int row;
    public CardBuyedResponse() {
        this.typeOfMessage = "CardBuyedResponse";
    }

    public Warehouse getNewwarehouse() {
        return newwarehouse;
    }

    public void setNewwarehouse(Warehouse newwarehouse) {
        this.newwarehouse = newwarehouse;
    }

    public Strongbox getNewstrongbox() {
        return newstrongbox;
    }

    public void setNewstrongbox(Strongbox newstrongbox) {
        this.newstrongbox = newstrongbox;
    }

    public SlotsBoard getSlotsBoard() {
        return slotsBoard;
    }

    public void setSlotsBoard(SlotsBoard slotsBoard) {
        this.slotsBoard = slotsBoard;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }
}
