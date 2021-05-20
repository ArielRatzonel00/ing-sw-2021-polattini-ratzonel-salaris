package it.polimi.ingsw.Network.Messages;

import it.polimi.ingsw.Model.CostOfCard;
import it.polimi.ingsw.Model.Marble.MarketMarble;

import java.util.ArrayList;

public class ActivateProductionMessage extends Message {
    private int PlayerIndex = 0;
    private ArrayList<Integer> productions;
    private ArrayList<CostOfCard> ProductionBasicCost;
    private MarketMarble.ColorMarble ProductionBasicProfit;
    private ArrayList<CostOfCard> Production4Profit;
    private ArrayList<CostOfCard> Production5Profit;
    public ActivateProductionMessage(){
        this.typeOfMessage = "ActivateProductionMessage";
    }

    public void setProductions(ArrayList<Integer> productions) {
        this.productions = productions;
    }

    public int getPlayerIndex() {
        return PlayerIndex;
    }

    public void setPlayerIndex(int playerIndex) {
        PlayerIndex = playerIndex;
    }

    public ArrayList<Integer> getProductions() {
        return productions;
    }

    public ArrayList<CostOfCard> getProductionBasicCost() {
        return ProductionBasicCost;
    }

    public void setProductionBasicCost(ArrayList<CostOfCard> productionBasicCost) {
        ProductionBasicCost = productionBasicCost;
    }

    public MarketMarble.ColorMarble getProductionBasicProfit() {
        return ProductionBasicProfit;
    }

    public void setProductionBasicProfit(MarketMarble.ColorMarble productionBasicProfit) {
        ProductionBasicProfit = productionBasicProfit;
    }

    public ArrayList<CostOfCard> getProduction4Profit() {
        return Production4Profit;
    }

    public void setProduction4Profit(ArrayList<CostOfCard> production4Profit) {
        Production4Profit = production4Profit;
    }

    public ArrayList<CostOfCard> getProduction5Profit() {
        return Production5Profit;
    }

    public void setProduction5Profit(ArrayList<CostOfCard> production5Profit) {
        Production5Profit = production5Profit;
    }
}
