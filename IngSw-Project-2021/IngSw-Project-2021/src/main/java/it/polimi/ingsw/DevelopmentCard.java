package it.polimi.ingsw;

public class DevelopmentCard {
    private int[] ResourcesCost; //purple, blue, yellow, grey
    private int[] ResourcesProductionCost; //purple, blue, yellow, grey
    private int[] ResourcesProductionProfit; //purple, blue, yellow, grey, red
    private int Id;
    private enum colorCard {
        Green,
        Blue,
        Yellow,
        Purple
    }
    private colorCard Color; //colore della carta
    private int Level;//livello della carta
    private int VictoryPoints; // Victory Points

    public DevelopmentCard(int[] resourcesCost, int[] resourcesProductionCost, int[] resourcesProductionProfit, int id, colorCard color, int level, int victoryPoints) {
        ResourcesCost = resourcesCost;
        ResourcesProductionCost = resourcesProductionCost;
        ResourcesProductionProfit = resourcesProductionProfit;
        Id = id;
        Color = color;
        Level = level;
        VictoryPoints = victoryPoints;
    }

    public int[] getResourcesCost() {
        return ResourcesCost;
    }

    public int[] getResourcesProductionCost() {
        return ResourcesProductionCost;
    }

    public int[] getResourcesProductionProfit() {
        return ResourcesProductionProfit;
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