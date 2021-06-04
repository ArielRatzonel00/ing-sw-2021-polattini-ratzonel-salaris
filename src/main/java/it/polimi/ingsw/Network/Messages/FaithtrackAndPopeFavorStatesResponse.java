package it.polimi.ingsw.Network.Messages;

import it.polimi.ingsw.Model.PopeFavorState;

import java.util.ArrayList;

public class FaithtrackAndPopeFavorStatesResponse extends Message{
    boolean CurrPlayerAdvance = false;
    ArrayList<PopeFavorState> popeFavorStates = new ArrayList<>();
    boolean popeFavorStateChanged = false;
    public FaithtrackAndPopeFavorStatesResponse() {
        this.typeOfMessage = "FaithtrackAndPopeFavorStatesResponse";
    }

    public boolean isCurrPlayerAdvance() {
        return CurrPlayerAdvance;
    }

    public void setCurrPlayerAdvance(boolean currPlayerAdvance) {
        CurrPlayerAdvance = currPlayerAdvance;
    }

    public ArrayList<PopeFavorState> getPopeFavorStates() {
        return popeFavorStates;
    }

    public void setPopeFavorStates(ArrayList<PopeFavorState> popeFavorStates) {
        this.popeFavorStates = popeFavorStates;
    }

    public boolean isPopeFavorStateChanged() {
        return popeFavorStateChanged;
    }

    public void setPopeFavorStateChanged(boolean popeFavorStateChanged) {
        this.popeFavorStateChanged = popeFavorStateChanged;
    }
}
