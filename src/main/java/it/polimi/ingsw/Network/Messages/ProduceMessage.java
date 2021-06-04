package it.polimi.ingsw.Network.Messages;

import it.polimi.ingsw.Model.CostOfCard;
import it.polimi.ingsw.Model.Marble.MarketMarble;

import java.util.ArrayList;

public class ProduceMessage extends Message{
    public ProduceMessage() {
        this.typeOfMessage = "ProduceMessage";
    }
    private ArrayList<Integer> productions = new ArrayList<>();
    private ArrayList<MarketMarble.ColorMarble> ProductionProfit = new ArrayList<>();
    private ArrayList<ArrayList<CostOfCard>> ResourcesFromStrongbox = new ArrayList<>();;
    private ArrayList<ArrayList<CostOfCard>> ResourcesFromWarehouse = new ArrayList<>();;
    private ArrayList<ArrayList<Integer>> rows = new ArrayList<>();

    public ArrayList<Integer> getProductions() {
        return productions;
    }

    public void setProductions(ArrayList<Integer> productions) {
        this.productions = productions;
    }

    public ArrayList<MarketMarble.ColorMarble> getProductionProfit() {
        return ProductionProfit;
    }

    public void setProductionProfit(MarketMarble.ColorMarble productionProfit) {
        ProductionProfit.add(productionProfit);
    }

    public ArrayList<ArrayList<CostOfCard>> getResourcesFromStrongbox() {
        return ResourcesFromStrongbox;
    }

    public void setResourcesFromStrongbox(ArrayList<CostOfCard> resourcesFromStrongbox) {
        ResourcesFromStrongbox .add(resourcesFromStrongbox);
    }

    public ArrayList<ArrayList<CostOfCard>> getResourcesFromWarehouse() {
        return ResourcesFromWarehouse;
    }

    public void setResourcesFromWarehouse(ArrayList<CostOfCard> resourcesFromWarehouse) {
        ResourcesFromWarehouse .add(resourcesFromWarehouse);
    }

    public ArrayList<ArrayList<Integer>> getRows() {
        return rows;
    }

    public void setRows(ArrayList<Integer> rows) {
        this.rows.add(rows);
    }
}