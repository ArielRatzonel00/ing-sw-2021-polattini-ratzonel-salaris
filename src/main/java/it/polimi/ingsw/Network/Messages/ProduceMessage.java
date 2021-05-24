package it.polimi.ingsw.Network.Messages;

import it.polimi.ingsw.Model.CostOfCard;
import it.polimi.ingsw.Model.Marble.MarketMarble;

import java.util.ArrayList;

public class ProduceMessage extends Message{
    public ProduceMessage() {
        this.typeOfMessage = "ProduceMessage";
    }

    private ArrayList<Integer> productions = new ArrayList<>();
    private ArrayList<CostOfCard> ProductionBasicCost;
    private MarketMarble.ColorMarble ProductionBasicProfit;
    private ArrayList<CostOfCard> Production4Profit;
    private ArrayList<CostOfCard> Production5Profit;
    private ArrayList<CostOfCard> ResourcesFromStrongbox0;
    private ArrayList<CostOfCard> ResourcesFromWarehouse0;
    private ArrayList<Integer> rows0;
    private ArrayList<CostOfCard> ResourcesFromStrongbox1;
    private ArrayList<CostOfCard> ResourcesFromWarehouse1;
    private ArrayList<Integer> rows1;
    private ArrayList<CostOfCard> ResourcesFromStrongbox2;
    private ArrayList<CostOfCard> ResourcesFromWarehouse2;
    private ArrayList<Integer> rows2;
    private ArrayList<CostOfCard> ResourcesFromStrongbox3;
    private ArrayList<CostOfCard> ResourcesFromWarehouse3;
    private ArrayList<Integer> rows3;
    private ArrayList<CostOfCard> ResourcesFromStrongbox4;
    private ArrayList<CostOfCard> ResourcesFromWarehouse4;
    private ArrayList<Integer> rows4;
    private ArrayList<CostOfCard> ResourcesFromStrongbox5;
    private ArrayList<CostOfCard> ResourcesFromWarehouse5;
    private ArrayList<Integer> rows5;


    public void setProduction(int production) {
        this.productions.add(production);
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



    public ArrayList<Integer> getProductions() {
        return productions;
    }

    public void setProductions(ArrayList<Integer> productions) {
        this.productions = productions;
    }

    public ArrayList<CostOfCard> getProductionBasicCost() {
        return ProductionBasicCost;
    }

    public void setProductionBasicCost(ArrayList<CostOfCard> productionBasicCost) {
        ProductionBasicCost = productionBasicCost;
    }

    public ArrayList<CostOfCard> getResourcesFromStrongbox0() {
        return ResourcesFromStrongbox0;
    }

    public void setResourcesFromStrongbox0(ArrayList<CostOfCard> resourcesFromStrongbox0) {
        ResourcesFromStrongbox0 = resourcesFromStrongbox0;
    }

    public ArrayList<CostOfCard> getResourcesFromWarehouse0() {
        return ResourcesFromWarehouse0;
    }

    public void setResourcesFromWarehouse0(ArrayList<CostOfCard> resourcesFromWarehouse0) {
        ResourcesFromWarehouse0 = resourcesFromWarehouse0;
    }

    public ArrayList<Integer> getRows0() {
        return rows0;
    }

    public void setRows0(ArrayList<Integer> rows0) {
        this.rows0 = rows0;
    }

    public ArrayList<CostOfCard> getResourcesFromStrongbox1() {
        return ResourcesFromStrongbox1;
    }

    public void setResourcesFromStrongbox1(ArrayList<CostOfCard> resourcesFromStrongbox1) {
        ResourcesFromStrongbox1 = resourcesFromStrongbox1;
    }

    public ArrayList<CostOfCard> getResourcesFromWarehouse1() {
        return ResourcesFromWarehouse1;
    }

    public void setResourcesFromWarehouse1(ArrayList<CostOfCard> resourcesFromWarehouse1) {
        ResourcesFromWarehouse1 = resourcesFromWarehouse1;
    }

    public ArrayList<Integer> getRows1() {
        return rows1;
    }

    public void setRows1(ArrayList<Integer> rows1) {
        this.rows1 = rows1;
    }

    public ArrayList<CostOfCard> getResourcesFromStrongbox2() {
        return ResourcesFromStrongbox2;
    }

    public void setResourcesFromStrongbox2(ArrayList<CostOfCard> resourcesFromStrongbox2) {
        ResourcesFromStrongbox2 = resourcesFromStrongbox2;
    }

    public ArrayList<CostOfCard> getResourcesFromWarehouse2() {
        return ResourcesFromWarehouse2;
    }

    public void setResourcesFromWarehouse2(ArrayList<CostOfCard> resourcesFromWarehouse2) {
        ResourcesFromWarehouse2 = resourcesFromWarehouse2;
    }

    public ArrayList<Integer> getRows2() {
        return rows2;
    }

    public void setRows2(ArrayList<Integer> rows2) {
        this.rows2 = rows2;
    }

    public ArrayList<CostOfCard> getResourcesFromStrongbox3() {
        return ResourcesFromStrongbox3;
    }

    public void setResourcesFromStrongbox3(ArrayList<CostOfCard> resourcesFromStrongbox3) {
        ResourcesFromStrongbox3 = resourcesFromStrongbox3;
    }

    public ArrayList<CostOfCard> getResourcesFromWarehouse3() {
        return ResourcesFromWarehouse3;
    }

    public void setResourcesFromWarehouse3(ArrayList<CostOfCard> resourcesFromWarehouse3) {
        ResourcesFromWarehouse3 = resourcesFromWarehouse3;
    }

    public ArrayList<Integer> getRows3() {
        return rows3;
    }

    public void setRows3(ArrayList<Integer> rows3) {
        this.rows3 = rows3;
    }

    public ArrayList<CostOfCard> getResourcesFromStrongbox4() {
        return ResourcesFromStrongbox4;
    }

    public void setResourcesFromStrongbox4(ArrayList<CostOfCard> resourcesFromStrongbox4) {
        ResourcesFromStrongbox4 = resourcesFromStrongbox4;
    }

    public ArrayList<CostOfCard> getResourcesFromWarehouse4() {
        return ResourcesFromWarehouse4;
    }

    public void setResourcesFromWarehouse4(ArrayList<CostOfCard> resourcesFromWarehouse4) {
        ResourcesFromWarehouse4 = resourcesFromWarehouse4;
    }

    public ArrayList<Integer> getRows4() {
        return rows4;
    }

    public void setRows4(ArrayList<Integer> rows4) {
        this.rows4 = rows4;
    }

    public ArrayList<CostOfCard> getResourcesFromStrongbox5() {
        return ResourcesFromStrongbox5;
    }

    public void setResourcesFromStrongbox5(ArrayList<CostOfCard> resourcesFromStrongbox5) {
        ResourcesFromStrongbox5 = resourcesFromStrongbox5;
    }

    public ArrayList<CostOfCard> getResourcesFromWarehouse5() {
        return ResourcesFromWarehouse5;
    }

    public void setResourcesFromWarehouse5(ArrayList<CostOfCard> resourcesFromWarehouse5) {
        ResourcesFromWarehouse5 = resourcesFromWarehouse5;
    }

    public ArrayList<Integer> getRows5() {
        return rows5;
    }

    public void setRows5(ArrayList<Integer> rows5) {
        this.rows5 = rows5;
    }
}
