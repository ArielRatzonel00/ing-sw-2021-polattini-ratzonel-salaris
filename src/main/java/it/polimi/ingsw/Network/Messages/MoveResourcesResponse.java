package it.polimi.ingsw.Network.Messages;

import it.polimi.ingsw.Model.Warehouse;
import it.polimi.ingsw.Model.WarehouseRow;

import java.util.ArrayList;

public class MoveResourcesResponse extends Message{
    private ArrayList<WarehouseRow> newwarehouse;
    private boolean ok;
    public MoveResourcesResponse() {
        this.typeOfMessage = "MoveResourcesResponse";
    }
    public ArrayList<WarehouseRow> getNewwarehouse() {
        return newwarehouse;
    }
    public void setNewwarehouse(ArrayList<WarehouseRow> newwarehouse) {
        this.newwarehouse = newwarehouse;
    }
    public boolean isOk() {
        return ok;
    }
    public void setOk(boolean ok) {
        this.ok = ok;
    }
}
