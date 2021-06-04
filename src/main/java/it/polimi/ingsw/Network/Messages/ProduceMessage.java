package it.polimi.ingsw.Network.Messages;

import it.polimi.ingsw.Model.CostOfCard;
import it.polimi.ingsw.Model.Marble.MarketMarble;

import java.util.ArrayList;

public class ProduceMessage extends Message{
    public ProduceMessage() {
        this.typeOfMessage = "ProduceMessage";
    }
    private int production = 0;

    private ArrayList<MarketMarble.ColorMarble> ProductionProfit = new ArrayList<>();
    private ArrayList<ArrayList<CostOfCard>> ResourcesFromStrongbox = new ArrayList<>();;
    private ArrayList<ArrayList<CostOfCard>> ResourcesFromWarehouse = new ArrayList<>();;
    private ArrayList<ArrayList<Integer>> rows;

    public int getProduction() {
        return production;
    }

    public void setProduction(int production) {
        this.production = production;
    }

    public void setResourcesFromStrongbox(ArrayList<CostOfCard> resourcesFromStrongbox) {
        this.ResourcesFromStrongbox.add(resourcesFromStrongbox);
    }
    public void setResourcesFromWarehouse(ArrayList<CostOfCard> resourcesFromWarehouse) {
        this.ResourcesFromWarehouse .add(resourcesFromWarehouse);
    }

    public void setProductionProfit(MarketMarble.ColorMarble productionProfit) {
        ProductionProfit.add(productionProfit);
    }
    public void setRows(ArrayList<Integer> rows) {
        this.rows.add(rows);
    }

    public ArrayList<MarketMarble.ColorMarble> getProductionProfit() {
        return ProductionProfit;
    }

    public ArrayList<ArrayList<CostOfCard>> getResourcesFromStrongbox() {
        return ResourcesFromStrongbox;
    }

    public ArrayList<ArrayList<CostOfCard>> getResourcesFromWarehouse() {
        return ResourcesFromWarehouse;
    }

    public ArrayList<ArrayList<Integer>> getRows() {
        return rows;
    }
}
