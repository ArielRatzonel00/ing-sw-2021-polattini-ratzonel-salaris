package it.polimi.ingsw.Network.Messages;

import it.polimi.ingsw.Model.CostOfCard;
import it.polimi.ingsw.Model.Marble.MarketMarble;

import java.util.ArrayList;

public class ProduceMessage extends Message{
    public ProduceMessage() {
        this.typeOfMessage = "ProduceMessage";
    }
    private int production = 0;
    private ArrayList<CostOfCard> ResourcesFromStrongbox;
    private ArrayList<CostOfCard> ResourcesFromWarehouse;
    private ArrayList<CostOfCard> ProductionBasicCost;
    private MarketMarble.ColorMarble ProductionProfit;
    private ArrayList<Integer> rows;

    public int getProduction() {
        return production;
    }

    public void setProduction(int production) {
        this.production = production;
    }

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

    public ArrayList<CostOfCard> getProductionBasicCost() {
        return ProductionBasicCost;
    }

    public void setProductionBasicCost(ArrayList<CostOfCard> productionBasicCost) {
        ProductionBasicCost = productionBasicCost;
    }

    public MarketMarble.ColorMarble getProductionProfit() {
        return ProductionProfit;
    }

    public void setProductionProfit(MarketMarble.ColorMarble productionProfit) {
        ProductionProfit = productionProfit;
    }

    public ArrayList<Integer> getRows() {
        return rows;
    }

    public void setRows(ArrayList<Integer> rows) {
        this.rows = rows;
    }
}
