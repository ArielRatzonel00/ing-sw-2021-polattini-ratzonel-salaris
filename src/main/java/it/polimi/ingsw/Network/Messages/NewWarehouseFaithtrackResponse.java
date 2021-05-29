package it.polimi.ingsw.Network.Messages;

import it.polimi.ingsw.Model.MultiplayerFaithTrack;
import it.polimi.ingsw.Model.Warehouse;

public class NewWarehouseFaithtrackResponse extends Message{
    Warehouse newwarehouse;
    MultiplayerFaithTrack faithTrack;
    public NewWarehouseFaithtrackResponse() {
        this.typeOfMessage = "New Warehouse Strongbox response";
    }

    public Warehouse getNewwarehouse() {
        return newwarehouse;
    }

    public void setNewwarehouse(Warehouse newwarehouse) {
        this.newwarehouse = newwarehouse;
    }

    public MultiplayerFaithTrack getFaithTrack() {
        return faithTrack;
    }

    public void setFaithTrack(MultiplayerFaithTrack faithTrack) {
        this.faithTrack = faithTrack;
    }
}
