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

    public StringBuilder printProduction(){
        StringBuilder string = new StringBuilder();
        string.append("You pay:\n");
        for (CostOfCard c : ProductionCost){
            string.append(c.getCostNumber());
            string.append(" ");
            string.append(c.getCostColor());
            string.append(" ");
        }
        string.append("\n");
        string.append("You get:\n");
        for (CostOfCard c : ProductionProfit){
            string.append(c.getCostNumber());
            string.append(" ");
            string.append(c.getCostColor());
            string.append(" ");
        }
        return string;
    }


}
