package it.polimi.ingsw.Network.Messages;

import it.polimi.ingsw.Model.Production;
import it.polimi.ingsw.Model.WarehouseRow;

import java.util.ArrayList;

public class ActivateLeaderCardActionResponse extends Message{
    boolean ok = false;
    String response = "";
    int Cardindex = 0;
    ArrayList<WarehouseRow> newWarehouse= new ArrayList<>();
    ArrayList<Production> newProdAvailables = new ArrayList<>();
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

    public ArrayList<WarehouseRow> getNewWarehouse() {
        return newWarehouse;
    }

    public void setNewWarehouse(ArrayList<WarehouseRow> newWarehouse) {
        this.newWarehouse = newWarehouse;
    }

    public ArrayList<Production> getNewProdAvailables() {
        return newProdAvailables;
    }

    public void setNewProdAvailables(ArrayList<Production> newProdAvailables) {
        this.newProdAvailables = newProdAvailables;
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
