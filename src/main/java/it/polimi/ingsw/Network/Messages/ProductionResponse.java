package it.polimi.ingsw.Network.Messages;

import it.polimi.ingsw.Model.FaithTrack;
import it.polimi.ingsw.Model.Strongbox;
import it.polimi.ingsw.Model.Warehouse;

public class ProductionResponse extends Message{
    public ProductionResponse() {
        this.typeOfMessage = "ProductionResponse";
    }
    Warehouse newwarehouse;
    Strongbox newstrongbox;
    FaithTrack faithTrack;

    public Warehouse getNewwarehouse() {
        return newwarehouse;
    }

    public void setNewwarehouse(Warehouse newwarehouse) {
        this.newwarehouse = newwarehouse;
    }

    public Strongbox getNewstrongbox() {
        return newstrongbox;
    }

    public void setNewstrongbox(Strongbox newstrongbox) {
        this.newstrongbox = newstrongbox;
    }

    public FaithTrack getFaithTrack() {
        return faithTrack;
    }

    public void setFaithTrack(FaithTrack faithTrack) {
        this.faithTrack = faithTrack;
    }
}
