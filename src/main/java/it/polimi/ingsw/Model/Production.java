package it.polimi.ingsw.Model;

import java.util.ArrayList;

public class Production {
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

    public boolean Produce(Player player) {
        // Le resources from Warehouse e from Strongbox me le deve passare il Player
        if (!(player.CheckResourcesForProudce(ProductionCost))){
            return false;
        }
        // chiede quanti da Strogobx e quanti da Warehosue
        return true;

    }

}
