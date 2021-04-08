package it.polimi.ingsw.Model;

import java.util.Map;

public class LeaderCard {
    private int Type; // 1 = TypeExtraResources, 2=TypeReduceCost, 3=TypeExtraWarehouse, 4=TypeConvertResource
    private boolean Activate = false;
    private int Id;
    private int Color1Cost; // se TypeExtraResources 1=purple, 2=blue, 3=yellow, 4=green
                            // se TypeReduceCost 1=purple, 2=blue, 3=yellow, 4=green
                            // se Type ExtraWarehouse 1=purple, 2=blue, 3=yellow, 4=grey
                            // se Type ConvertResources 1=purple, 2=blue, 3=yellow, 4=green

    private int Color2; // i numeri rimangono uguali a sopra

    private int VictoryPoints;
    // private int act; andrà nella funzione che chiama Active

    private int SpecialAbilityColor; // 1=purple, 2=blue, 3=yellow, 4=grey
    // è il colore dell'abilità speciale che hanno

    public LeaderCard(int type, int id, int color1Cost, int color2, int specialAbilityColor, int victoryPoints) {
        this.Type = type;
        this.Id = id;
        this.Color1Cost = color1Cost;
        this.Color2 = color2;
        this.SpecialAbilityColor = specialAbilityColor;
        this.VictoryPoints = victoryPoints;
    }

    public int getType() {
        return Type;
    }

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
}
/*
    public void discard(){
        // da rivedere, togliere la carta leader e fare add Faith Point

    }
    public void activate(){
        act = 1;
        //attivare carta Leader magari chimando i metodi della classe effetto da creare
        }


 */