package it.polimi.ingsw.Network.Messages;

import it.polimi.ingsw.Model.CostOfCard;

import java.util.ArrayList;

public class BuyCardMessage extends Message{
    private int Cellrow;
    private int Cellcol;
    private int slot;
    private ArrayList<CostOfCard> ResourcesFromStrongbox;
    private ArrayList<CostOfCard> ResourcesFromWarehouse;
    private ArrayList<Integer> rows;
    public ArrayList<CostOfCard> getResourcesFromStrongbox() {
        return ResourcesFromStrongbox;
    }

    public BuyCardMessage() {
        this.typeOfMessage = "BuyCardMessage";
    }

    public void setResourcesFromStrongbox(ArrayList<CostOfCard> resourcesFromStrongbox) {
        ResourcesFromStrongbox = resourcesFromStrongbox;
    }

    public ArrayList<CostOfCard> getResourcesFromWarehouse() {
        return ResourcesFromWarehouse;
    }

    public void setResourcesFromWarehouse(ArrayList<CostOfCard> resourcesFromWarehouse) {
        ResourcesFromWarehouse = resourcesFromWarehouse;
    }

    public ArrayList<Integer> getRows() {
        return rows;
    }

    public void setRows(ArrayList<Integer> rows) {
        this.rows = rows;
    }


    public int getCellrow() {
        return Cellrow;
    }

    public void setCellrow(int cellrow) {
        Cellrow = cellrow;
    }

    public int getCellcol() {
        return Cellcol;
    }

    public void setCellcol(int cellcol) {
        Cellcol = cellcol;
    }

    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }

}
