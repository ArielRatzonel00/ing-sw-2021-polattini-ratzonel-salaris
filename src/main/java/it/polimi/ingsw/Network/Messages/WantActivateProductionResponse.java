package it.polimi.ingsw.Network.Messages;

import it.polimi.ingsw.Model.CostOfCard;
import it.polimi.ingsw.Model.Production;

import java.util.ArrayList;

public class WantActivateProductionResponse extends Message{
    private ArrayList<Integer> productions = new ArrayList<>();
    private boolean ok = false;
    private ArrayList<CostOfCard> basicProductionCost = new ArrayList<>();
    public WantActivateProductionResponse() {
        this.typeOfMessage = "WantActivateProductionResponse";
    }

    public ArrayList<Integer> getProductions() {
        return productions;
    }

    public void setProductions(ArrayList<Integer> productions) {
        this.productions = productions;
    }

    public boolean isOk() {
        return ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }

    public ArrayList<CostOfCard> getBasicProductionCost() {
        return basicProductionCost;
    }

    public void setBasicProductionCost(ArrayList<CostOfCard> basicProductionCost) {
        this.basicProductionCost = basicProductionCost;
    }
}
