package it.polimi.ingsw.Network.Messages;

import it.polimi.ingsw.Model.MultipleyerFaithTrack;
import it.polimi.ingsw.Model.Warehouse;

public class NewWarehouseFaithtrackResponse extends Message{
    Warehouse newwarehouse;
    MultipleyerFaithTrack faithTrack;
    public NewWarehouseFaithtrackResponse() {
        this.typeOfMessage = "New Warehouse Strongbox response";
    }

    public Warehouse getNewwarehouse() {
        return newwarehouse;
    }

    public void setNewwarehouse(Warehouse newwarehouse) {
        this.newwarehouse = newwarehouse;
    }

    public MultipleyerFaithTrack getFaithTrack() {
        return faithTrack;
    }

    public void setFaithTrack(MultipleyerFaithTrack faithTrack) {
        this.faithTrack = faithTrack;
    }
}
