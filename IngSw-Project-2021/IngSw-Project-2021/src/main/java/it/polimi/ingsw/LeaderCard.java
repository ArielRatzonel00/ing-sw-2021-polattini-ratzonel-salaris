package it.polimi.ingsw;

import java.util.Map;

public class LeaderCard {
    private boolean[] Type; // TypeExtraResources, TypeReduceCost, TypeExtraWarehouse, TypeConvertResource
    private int Id;
    private int Color1Cost; // se TypeExtraResources 1:yellow, 2:purple, 3: green, 4: blue
                        // se TypeReduceCost uguale
                        // se Type ExtraWarehouse 3 non è più green ma grey
                        // se Type ConvertResources uguale a Extra resources

    private int Color2; // i numeri rimangono uguale

    private int VictoryPoints;
    // private int act; andrà nella funzione che chiama Active

    private int SpecialAbilityColor; // 1:yellow, 2:purple, 3: grey, 4: blue

    public LeaderCard(boolean[] type, int id, int color1Cost, int color2, int specialAbilityColor) {
        Type = type;
        Id = id;
        Color1Cost = color1Cost;
        Color2 = color2;
        // da fare con i casi if VictoryPoints = ;
        SpecialAbilityColor = specialAbilityColor;
    }

    public boolean isActivate(int act) {
        if (act == 0) {
            return false;
        } else {
            return true;
        } // controllo se carta leader è da attivare

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