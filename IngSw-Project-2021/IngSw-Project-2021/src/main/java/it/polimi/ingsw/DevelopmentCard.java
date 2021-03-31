package it.polimi.ingsw;

import java.awt.*;
import java.util.Map;

public class DevelopmentCard {
    private int NumCard;
    private Map<Integer,MarketMarble> cost;// metodo di Luca
    private enum colorCard{
        Green,
        Blue,
        Yellow,
        Purple
    };
    private colorCard Color;
    private int level;
    private Map<Integer,MarketMarble> ProductionPowerCost; // metodo di Luca
    private Map<Integer,MarketMarble> productionPowerProfit; // metodo di Luca
    private int VictoryPoints;

    public DevelopmentCard(Map<Integer,MarketMarble> cost, int level, Map<Integer,MarketMarble> productionPowerCost, Map<Integer,MarketMarble> productionPowerProfit, int victoryPoints, colorCard color) {
        this.cost = cost;
        this.level = level;
        this.ProductionPowerCost = productionPowerCost;
        this.productionPowerProfit = productionPowerProfit;
        this.VictoryPoints = victoryPoints;
        this.Color = color;
    }

    public Map<Integer,MarketMarble> getCost() {
        return cost;
    }

    public int getLevel() {
        return level;
    }
// get color

    public Map<Integer,MarketMarble> getProductionPowerCost() {
        return ProductionPowerCost;
    }

    public Map<Integer,MarketMarble> getProductionPowerProfit() {
        return productionPowerProfit;
    }
    public void produce(Warehouse warehouse){

        //scorriamo la mappa del productionPowerProfit e chiamiamo i metodi Add dello strongbox per ogni tipologia di risorse che otteniamo
        //scorraimo la mappa del productionPowerCost e chiamiamo per togliere le risorse dal warehouse


    }
}
