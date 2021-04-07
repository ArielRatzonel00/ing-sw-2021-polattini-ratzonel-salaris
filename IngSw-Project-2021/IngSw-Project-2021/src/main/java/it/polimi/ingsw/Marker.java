package it.polimi.ingsw;

public class Marker {
    private int IdMarker;
    private boolean TypeRemoveCards = false;
    private boolean TypePlusTwoBlack = false;
    private boolean TypePlusOneShuffle = false;

    public Marker(int idMarker, boolean typeRemoveCards, boolean typePlusTwoBlack, boolean typePlusOneShuffle) {
        IdMarker = idMarker;
        TypeRemoveCards = typeRemoveCards;
        TypePlusTwoBlack = typePlusTwoBlack;
        TypePlusOneShuffle = typePlusOneShuffle;
    }

    public int getIdMarker() {
        return IdMarker;
    }

    public boolean isTypeRemoveCards() {
        return TypeRemoveCards;
    }

    public boolean isTypePlusTwoBlack() {
        return TypePlusTwoBlack;
    }

    public boolean isTypePlusOneShuffle() {
        return TypePlusOneShuffle;
    }
}

