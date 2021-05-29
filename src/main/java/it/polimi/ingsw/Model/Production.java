package it.polimi.ingsw.Model;

import it.polimi.ingsw.Model.Marble.MarketMarble;

import java.io.Serializable;
import java.util.ArrayList;

public class Production implements Serializable {
    private ArrayList<CostOfCard> ProductionCost = new ArrayList<>();
    private ArrayList<CostOfCard> ProductionProfit = new ArrayList<>();

    public Production(ArrayList<CostOfCard> productionCost, ArrayList<CostOfCard> productionProfit) {
        ProductionCost = productionCost;
        ProductionProfit = productionProfit;
    }

    public ArrayList<CostOfCard> getProductionCost() {
        return ProductionCost;
    }

    public ArrayList<CostOfCard> getProductionProfit() {
        return ProductionProfit;
    }

    public void setProductionCost(ArrayList<CostOfCard> productionCost) {
        ProductionCost = productionCost;
    }

    public void setProductionProfit(ArrayList<CostOfCard> productionProfit) {
        ProductionProfit = productionProfit;
    }

    public void Produce(ArrayList<CostOfCard> ResourcesFromWarehouse, ArrayList<Integer> Rows, ArrayList<CostOfCard> ResourcesFromStrongbox, Player player) {
        // Le resources from Warehouse e from Strongbox me le deve passare il Player
        // chiede quanti da Strongbox e quanti da Warehouse
        for (CostOfCard costOfCard : ProductionProfit){
            if (costOfCard.getCostColor() != MarketMarble.ColorMarble.RED) {
                player.getStrongbox().AddResource(costOfCard.getCostNumber(), costOfCard.getCostColor());
            }
            else {
                player.getFaithTrack().setRedPosition(costOfCard.getCostNumber());
            }
        }

    }

}
