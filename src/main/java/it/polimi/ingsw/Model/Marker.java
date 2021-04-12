package it.polimi.ingsw.Model;

public abstract class Marker {
    //private int IdMarker;
    private boolean TypeRemoveCards = false;
    private boolean TypePlusTwoBlack = false;
    private boolean TypePlusOneShuffle = false;

    public Marker(int idMarker, boolean typeRemoveCards, boolean typePlusTwoBlack, boolean typePlusOneShuffle) {
        //IdMarker = idMarker;
        TypeRemoveCards = typeRemoveCards;
        TypePlusTwoBlack = typePlusTwoBlack;
        TypePlusOneShuffle = typePlusOneShuffle;
    }

    /*public int getIdMarker() {
        return IdMarker;
    }*/


}

