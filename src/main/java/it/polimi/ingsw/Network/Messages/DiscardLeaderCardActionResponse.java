package it.polimi.ingsw.Network.Messages;

import it.polimi.ingsw.Model.PopeFavorState;

import java.util.ArrayList;

public class DiscardLeaderCardActionResponse extends Message{
    private boolean ok = false;
    private boolean PopeFavorStateEvent = false;
    private String response ="";
    private int cardIndex = 0;
    private ArrayList<PopeFavorState> popeFavorStates = new ArrayList<>();
    public DiscardLeaderCardActionResponse() {
        this.typeOfMessage = "DiscardLeaderCardActionResponse";
    }

    public boolean isOk() {
        return ok;
    }

    public boolean isPopeFavorStateEvent() {
        return PopeFavorStateEvent;
    }

    public String getResponse() {
        return response;
    }

    public void setOk(boolean ok) {
        if (ok){
            this.response = "Card discarded correctly, you advance by one";
        }
        else {
            this.response = "Couldn't discard the card";
        }
        this.ok = ok;
    }

    public void setPopeFavorStateEvent(boolean popeFavorStateEvent) {
        PopeFavorStateEvent = popeFavorStateEvent;
    }

    public ArrayList<PopeFavorState> getPopeFavorStates() {
        return popeFavorStates;
    }

    public void setPopeFavorStates(ArrayList<PopeFavorState> popeFavorStates) {
        this.popeFavorStates = popeFavorStates;
    }

    public int getCardIndex() {
        return cardIndex;
    }

    public void setCardIndex(int cardIndex) {
        this.cardIndex = cardIndex;
    }
}
