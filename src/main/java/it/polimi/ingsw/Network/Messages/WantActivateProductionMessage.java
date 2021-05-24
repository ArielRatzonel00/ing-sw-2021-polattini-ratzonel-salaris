package it.polimi.ingsw.Network.Messages;

import it.polimi.ingsw.Model.CostOfCard;
import it.polimi.ingsw.Model.Marble.MarketMarble;

import java.util.ArrayList;

public class WantActivateProductionMessage extends Message {

    private ArrayList<Integer> productions = new ArrayList<>();
    private ArrayList<CostOfCard> ProductionBasicCost;

    public WantActivateProductionMessage(){
        this.typeOfMessage = "WantActivateProductionMessage";
    }

    public void setProduction(int production) {
        this.productions.add(production);
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

}
