package it.polimi.ingsw.Network.Messages;

import it.polimi.ingsw.Model.FaithTrack;
import it.polimi.ingsw.Model.Warehouse;

public class NewWarehouseFaithtrackResponse extends Message{
    Warehouse newwarehouse;
    FaithTrack faithTrack;
    public NewWarehouseFaithtrackResponse() {
        this.typeOfMessage = "New Warehouse Strongbox response";
    }

    public Warehouse getNewwarehouse() {
        return newwarehouse;
    }

    public void setNewwarehouse(Warehouse newwarehouse) {
        this.newwarehouse = newwarehouse;
    }

    public FaithTrack getFaithTrack() {
        return faithTrack;
    }

    public void setFaithTrack(FaithTrack faithTrack) {
        this.faithTrack = faithTrack;
    }
}
