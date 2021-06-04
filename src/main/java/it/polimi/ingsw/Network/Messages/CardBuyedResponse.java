package it.polimi.ingsw.Network.Messages;

import it.polimi.ingsw.Model.*;

import java.util.ArrayList;

public class CardBuyedResponse extends Message{
    private ArrayList<WarehouseRow> newwarehouse;
    private ArrayList<Integer> newstrongbox;
    private ArrayList<DevelopmentCard> newDevGrid;
    private DevelopmentCard card;
    private ArrayList<Production> newproductionAvailables;
    private int slot;
    public CardBuyedResponse() {
        this.typeOfMessage = "CardBuyedResponse";
    }


    public ArrayList<DevelopmentCard> getNewDevGrid() {
        return newDevGrid;
    }

    public void setNewDevGrid(ArrayList<DevelopmentCard> newDevGrid) {
        this.newDevGrid = newDevGrid;
    }

    public ArrayList<WarehouseRow> getNewwarehouse() {
        return newwarehouse;
    }

    public void setNewwarehouse(ArrayList<WarehouseRow> newwarehouse) {
        this.newwarehouse = newwarehouse;
    }

    public ArrayList<Integer> getNewstrongbox() {
        return newstrongbox;
    }

    public void setNewstrongbox(ArrayList<Integer> newstrongbox) {
        this.newstrongbox = newstrongbox;
    }

    public DevelopmentCard getCard() {
        return card;
    }

    public void setCard(DevelopmentCard card) {
        this.card = card;
    }

    public ArrayList<Production> getNewproductionAvailables() {
        return newproductionAvailables;
    }

    public void setNewproductionAvailables(ArrayList<Production> newproductionAvailables) {
        this.newproductionAvailables = newproductionAvailables;
    }
    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }
}
