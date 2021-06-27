package it.polimi.ingsw.Model;

// Method that represents a DevelopmentCard.
// Da cambiare inserendo una istanza di Production

import java.io.Serializable;
import java.util.ArrayList;

public class DevelopmentCard implements Serializable {
    private ArrayList<CostOfCard> Cost; //purple, blue, yellow, grey
    private Production Production;
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

    public DevelopmentCard(ArrayList<CostOfCard> costOfCards, Production production, int id, colorCard color, int level, int victoryPoints) {
        this.Cost = costOfCards;
        this.Production = production;
        this.Id = id;
        this.Color = color;
        this.Level = level;
        this.VictoryPoints = victoryPoints;
    }


    public ArrayList<CostOfCard> getCost() {
        return Cost;
    }

    public Production getProduction() {
        return Production;
    }

    public int getId() {
        return Id;
    }

    public int getDevIdFromCard(DevelopmentCard DevCard) { //in teoria prende in ingresso una carta e mi ritorna il suo id
        return DevCard.Id;
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

    public void printCard(){
        System.out.println("Color: " + Color+"   " +
                "Level: " + Level +"   " +
                "Cost:" + printCostofCard(Cost) +
                "Production Cost:" + printCostofCard(Production.getProductionCost()) +
                "Production Profit:" + printCostofCard(Production.getProductionProfit()) +
                "Victory Points:" + VictoryPoints );

    }
    public StringBuilder printCostofCard(ArrayList<CostOfCard> cc){
        StringBuilder string = new StringBuilder();
        for (CostOfCard c : cc){
            string.append(c.getCostNumber());
            string.append(" ");
            string.append(c.getCostColor());
            string.append(" ");

        }
        string.append("\n");
        return string;
    }

}