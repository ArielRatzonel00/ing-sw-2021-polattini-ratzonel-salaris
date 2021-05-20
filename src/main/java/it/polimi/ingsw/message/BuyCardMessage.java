package it.polimi.ingsw.message;

import it.polimi.ingsw.Model.CostOfCard;

import java.util.ArrayList;

public class BuyCardMessage {
    private ArrayList<CostOfCard> ResourcesFromStrongbox;
    private ArrayList<CostOfCard> ResourcesFromWarehouse;
    private ArrayList<Integer> rows;

    public ArrayList<CostOfCard> getResourcesFromStrongbox() {
        return ResourcesFromStrongbox;
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
}
