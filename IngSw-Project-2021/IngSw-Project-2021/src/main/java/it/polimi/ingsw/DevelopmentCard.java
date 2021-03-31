package it.polimi.ingsw;

public class DevelopmentCard {
    private int cost;
    private enum color;
    private int level;
    private int ProductionPowerCost;
    // da cambiare
    private int productionPowerProfit;
    // da cambiare
    private int VictoryPoints;

    public DevelopmentCard(int cost, int level, int productionPowerCost, int productionPowerProfit, int victoryPoints) {
        this.cost = cost;
        this.level = level;
        this.ProductionPowerCost = productionPowerCost;
        this.productionPowerProfit = productionPowerProfit;
        this.VictoryPoints = victoryPoints;
    }

    public int getCost() {
        return cost;
    }

    public int getLevel() {
        return level;
    }
// get color

    public int getProductionPowerCost() {
        return ProductionPowerCost;
    }

    public int getProductionPowerProfit() {
        return productionPowerProfit;
    }
    public void produce(Warehouse warehouse){}
}
