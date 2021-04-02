package it.polimi.ingsw;

import java.awt.*;
import java.util.Map;

public class DevelopmentCard {
    private int IdCard; // Identificativo della carta, probabibelmente ci servirà per il random
    private Map<Integer, MarketMarble> cost; // metodo di Luca

    private enum colorCard {
        Green,
        Blue,
        Yellow,
        Purple
    }

    ;
    private colorCard Color; //colore della carta
    private int level;//livello della carta
    private Map<Integer, MarketMarble> ProductionPowerCost; // metodo di Luca
    private Map<Integer, MarketMarble> productionPowerProfit; // metodo di Luca
    private int VictoryPoints; // Victory Points

    public DevelopmentCard(Map<Integer, MarketMarble> cost, int level, Map<Integer, MarketMarble> productionPowerCost, Map<Integer, MarketMarble> productionPowerProfit, int victoryPoints, colorCard color) {
        this.cost = cost;
        this.level = level;
        this.ProductionPowerCost = productionPowerCost;
        this.productionPowerProfit = productionPowerProfit;
        this.VictoryPoints = victoryPoints;
        this.Color = color;
    } // costruttore della carta

    public Map<Integer, MarketMarble> getCost() {
        return cost;
    } // get costo carta

    public int getLevel() {
        return level;
    } // get level carta

    public colorCard getColor() {
        return Color;
    } // get colore carta

    public Map<Integer, MarketMarble> getProductionPowerCost() {
        return ProductionPowerCost;
    } // get costo della produzione

    public Map<Integer, MarketMarble> getProductionPowerProfit() {
        return productionPowerProfit;
    } // get profitto produzione

    public int getVictoryPoints() {
        return VictoryPoints;
    }

    public int getIdCard() {
        return IdCard;
    }
}




/*public void produce(Warehouse warehouse){
        // Da vedere se mettere nel controller o lasciare qua
        //scorriamo la mappa del productionPowerProfit e chiamiamo i metodi Add dello strongbox per ogni tipologia di risorse che otteniamo
        //scorraimo la mappa del productionPowerCost e chiamiamo per togliere le risorse dal warehouse


    }

 */
