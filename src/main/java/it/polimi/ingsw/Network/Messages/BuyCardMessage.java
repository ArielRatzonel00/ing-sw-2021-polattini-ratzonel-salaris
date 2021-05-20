package it.polimi.ingsw.Network.Messages;

import it.polimi.ingsw.Model.CostOfCard;

import java.util.ArrayList;

public class BuyCardMessage extends Message{
    private int PlayerIndex = 0;
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

    public int getPlayerIndex() {
        return PlayerIndex;
    }

    public void setPlayerIndex(int playerIndex) {
        PlayerIndex = playerIndex;
    }
}
