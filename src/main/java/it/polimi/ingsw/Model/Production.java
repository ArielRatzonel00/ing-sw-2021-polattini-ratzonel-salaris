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

    public void Produce(ArrayList<CostOfCard> ResoucesFromWarehouse, ArrayList<Integer> Rows, ArrayList<CostOfCard> ResoucesFromStrongobox, Player player) {
        // Le resources from Warehouse e from Strongbox me le deve passare il Player
        // chiede quanti da Strogobx e quanti da Warehosue
        for (CostOfCard costOfCard : ProductionProfit){
            player.getStrongbox().AddResource(costOfCard.getCostNumber(), costOfCard.getCostColor());
        }
    }

}
