package it.polimi.ingsw.Network.Messages;

import it.polimi.ingsw.Model.DevelopmentCard;
import it.polimi.ingsw.Model.Markers.Marker;
import it.polimi.ingsw.Model.PopeFavorState;

import java.util.ArrayList;

public class EndTurnResponse extends Message{
    private int IndexNewTurn;
    private boolean popeFavorChanged = false;
    private ArrayList<DevelopmentCard> newDevGrid = new ArrayList<>();
    private int blackPosition = 0;
    private Marker topMarker;
    private ArrayList<PopeFavorState> popeFavorStates = new ArrayList<>();

    public EndTurnResponse() {
        this.typeOfMessage = "EndTurnResponse";
    }

    public int getIndexNewTurn() {
        return IndexNewTurn;
    }

    public void setIndexNewTurn(int indexNewTurn) {
        IndexNewTurn = indexNewTurn;
    }

    public boolean isPopeFavorChanged() {
        return popeFavorChanged;
    }

    public void setPopeFavorChanged(boolean popeFavorChanged) {
        this.popeFavorChanged = popeFavorChanged;
    }

    public ArrayList<DevelopmentCard> getNewDevGrid() {
        return newDevGrid;
    }

    public void setNewDevGrid(ArrayList<DevelopmentCard> newDevGrid) {
        this.newDevGrid = newDevGrid;
    }

    public int getBlackPosition() {
        return blackPosition;
    }

    public void setBlackPosition(int blackPosition) {
        this.blackPosition = blackPosition;
    }

    public Marker getTopMarker() {
        return topMarker;
    }

    public void setTopMarker(Marker topMarker) {
        this.topMarker = topMarker;
    }

    public ArrayList<PopeFavorState> getPopeFavorStates() {
        return popeFavorStates;
    }

    public void setPopeFavorStates(ArrayList<PopeFavorState> popeFavorStates) {
        this.popeFavorStates = popeFavorStates;
    }
}
