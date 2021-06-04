package it.polimi.ingsw.Network.Messages;

import it.polimi.ingsw.Model.*;

import java.util.ArrayList;

public class ProductionResponse extends Message{
    public ProductionResponse() {
        this.typeOfMessage = "ProductionResponse";
    }
    private ArrayList<WarehouseRow> newwarehouse;
    private ArrayList<Integer> newstrongbox;
    private int faithTrackpositions;
    private boolean PopeFavoreStateEvent = false;
    private ArrayList<PopeFavorState> popeFavorStates;

    public ArrayList<WarehouseRow> getNewwarehouse() {
        return newwarehouse;
    }

    public void setNewwarehouse(ArrayList<WarehouseRow> newwarehouse) {
        this.newwarehouse = newwarehouse;
    }

    public ArrayList<PopeFavorState> getPopeFavorStates() {
        return popeFavorStates;
    }

    public void setPopeFavorStates(ArrayList<PopeFavorState> popeFavorStates) {
        this.popeFavorStates = popeFavorStates;
    }

    public ArrayList<Integer> getNewstrongbox() {
        return newstrongbox;
    }

    public void setNewstrongbox(ArrayList<Integer> newstrongbox) {
        this.newstrongbox = newstrongbox;
    }

    public int getFaithTrackpositions() {
        return faithTrackpositions;
    }

    public void setFaithTrackpositions(int faithTrackpositions) {
        this.faithTrackpositions = faithTrackpositions;
    }

    public boolean isPopeFavoreStateEvent() {
        return PopeFavoreStateEvent;
    }

    public void setPopeFavoreStateEvent(boolean popeFavoreStateEvent) {
        PopeFavoreStateEvent = popeFavoreStateEvent;
    }
}
