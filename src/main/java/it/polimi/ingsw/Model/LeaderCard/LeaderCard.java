package it.polimi.ingsw.Model.LeaderCard;

import it.polimi.ingsw.Model.Player;

import java.io.Serializable;
import java.util.ArrayList;

public  class LeaderCard implements Serializable {
    //private int Type; // 1=TypeExtraResources, 2=TypeReduceCost, 3=TypeExtraWarehouse, 4=TypeConvertResource
    private boolean Activate = false;

    private int Id;

    public LeaderCard(int id,int victoryPoints ) {
        Id = id;
        VictoryPoints = victoryPoints;
    }

    private int Color1Cost; // se TypeExtraResources 1=purple, 2=blue, 3=yellow, 4=green
                            // se TypeReduceCost 1=purple, 2=blue, 3=yellow, 4=green
                            // se Type ExtraWarehouse 1=purple, 2=blue, 3=yellow, 4=grey
                            // se Type ConvertResources 1=purple, 2=blue, 3=yellow, 4=green



    public boolean canBeActivated (Player player) {
        return true;
    }
    private int Color2; // i numeri rimangono uguali a sopra, 0 se non ho un solo costo in quella carta

    private int VictoryPoints;
    // private int act; andrà nella funzione che chiama Active

    private int SpecialAbilityColor; // 1=purple, 2=blue, 3=yellow, 4=grey
    // è il colore dell'abilità speciale che hanno



    /*public int getType() {
        return Type;
    }*/

    public boolean isActivate() {
        return Activate;
    }

    public int getId() {
        return Id;
    }

    public int getColor1Cost() {
        return Color1Cost;
    }

    public int getColor2() {
        return Color2;
    }

    public int getVictoryPoints() {
        return VictoryPoints;
    }

    public int getSpecialAbilityColor() {
        return SpecialAbilityColor;
    }

    public void setActivate(boolean activate) {
        this.Activate = activate;
    }

    public void effect(Player player){};

    public int getLeadIdFromCard(LeaderCard LeadCard) { //prende in ingresso una carta e mi ritorna il suo id
        return LeadCard.Id;
    }

    public String StampaCarta(){
        return "a";
    }

    @Override
    public String toString(){
        return "leadercard";
    }

    public int getType() {
        return 0;
    }
}