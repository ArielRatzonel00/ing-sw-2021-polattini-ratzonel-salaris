package it.polimi.ingsw.Network.Messages;

import it.polimi.ingsw.Model.PopeFavorState;
import it.polimi.ingsw.Model.Warehouse;

import java.util.ArrayList;

public class DealWithResourcesFromMarketTrayResponse extends Message{
    private Warehouse warehouse;
    private int currPlayersAdvances = 0;
    private int otherPlayersAdvances = 0;
    private boolean popeFavoreEvent = false;
    private ArrayList<PopeFavorState> popeFavorStates;
    public ArrayList<PopeFavorState> getPopeFavorStates() {
        return popeFavorStates;
    }
    public void setPopeFavorStates(ArrayList<PopeFavorState> popeFavorStates) {
        this.popeFavorStates = popeFavorStates;
    }

    public boolean isPopeFavoreEvent() {
        return popeFavoreEvent;
    }

    public void setPopeFavoreEvent(boolean popeFavoreEvent) {
        this.popeFavoreEvent = popeFavoreEvent;
    }

    public DealWithResourcesFromMarketTrayResponse() {
        this.typeOfMessage = "DealWithResourcesFromMarketTrayResponse";
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public int getCurrPlayersAdvances() {
        return currPlayersAdvances;
    }

    public void setCurrPlayersAdvances(int currPlayersAdvances) {
        this.currPlayersAdvances = currPlayersAdvances;
    }

    public int getOtherPlayersAdvances() {
        return otherPlayersAdvances;
    }

    public void setOtherPlayersAdvances(int otherPlayersAdvances) {
        this.otherPlayersAdvances = otherPlayersAdvances;
    }
}
