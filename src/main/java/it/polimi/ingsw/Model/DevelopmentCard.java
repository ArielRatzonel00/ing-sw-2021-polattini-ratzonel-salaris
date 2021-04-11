package it.polimi.ingsw.Model;

public class DevelopmentCard {
    private int[] Cost; //purple, blue, yellow, grey
    private int[] ProductionCost; //purple, blue, yellow, grey
    private int[] ProductionProfit; //purple, blue, yellow, grey, red
    private int Id;
    public enum colorCard {
        Green,
        Blue,
        Yellow,
        Purple
    }
    private colorCard Color; //colore della carta
    private int Level;//livello della carta
    private int VictoryPoints; // Victory Points

    public DevelopmentCard(int[] Cost, int[] ProductionCost, int[] ProductionProfit, int id, colorCard color, int level, int victoryPoints) {
        this.Cost = Cost;
        this.ProductionCost = ProductionCost;
        this.ProductionProfit = ProductionProfit;
        this.Id = id;
        this.Color = color;
        this.Level = level;
        this.VictoryPoints = victoryPoints;
    }


    public int[] getResourcesCost() {
        return Cost;
    }

    public int[] getResourcesProductionCost() {
        return ProductionCost;
    }

    public int[] getResourcesProductionProfit() {
        return ProductionProfit;
    }

    public int getId() {
        return Id;
    }

    public colorCard getColor() {
        return Color;
    }

    public int getLevel() {
        return Level;
    }

    public int getVictoryPoints() {
        return VictoryPoints;
    }
}