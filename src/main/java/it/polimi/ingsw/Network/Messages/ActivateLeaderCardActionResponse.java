package it.polimi.ingsw.Network.Messages;

public class ActivateLeaderCardActionResponse extends Message{
    boolean ok = false;
    String response = "";
    int Cardindex = 0;
    public ActivateLeaderCardActionResponse() {
        this.typeOfMessage = "ActivateLeaderCardActionResponse";
    }

    public boolean isOk() {
        return ok;
    }

    public void setOk(boolean ok) {
        if (ok) {
            this.response = "Card Activated";
        }
        else {
            this.response = "Card can't be activated";
        }
        this.ok = ok;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public int getCardindex() {
        return Cardindex;
    }

    public void setCardindex(int cardindex) {
        Cardindex = cardindex;
    }
}
