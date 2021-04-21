package it.polimi.ingsw.Model;

// Method that represents a DevelopmentCard.
// Da cambiare inserendo una istanza di Production

import java.util.ArrayList;

public class DevelopmentCard {
    private ArrayList<CostOfCard> Cost = new ArrayList<>(); //purple, blue, yellow, grey
    private Production production;
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
        this.Cost = Cost;
        this.production = production;
        this.Id = id;
        this.Color = color;
        this.Level = level;
        this.VictoryPoints = victoryPoints;
    }


    public ArrayList<CostOfCard> getCost() {
        return Cost;
    }

    public Production getProduction() {
        return production;
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
}