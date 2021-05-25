package it.polimi.ingsw.Network.Messages;

import it.polimi.ingsw.Model.Warehouse;

public class NewWarehouseResponse extends Message{
    Warehouse newwarehouse;
    public NewWarehouseResponse() {
        this.typeOfMessage = "New Warehouse Response";
    }

    public Warehouse getNewwarehouse() {
        return newwarehouse;
    }

    public void setNewwarehouse(Warehouse newwarehouse) {
        this.newwarehouse = newwarehouse;
    }
}
