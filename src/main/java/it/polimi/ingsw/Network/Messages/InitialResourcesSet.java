package it.polimi.ingsw.Network.Messages;

import it.polimi.ingsw.Model.Warehouse;

public class InitialResourcesSet extends Message{
    Warehouse warehouse;
    int position=0;
    int playerIndex;
    Boolean start;

    public InitialResourcesSet() {
        this.typeOfMessage = "initialResourcesSet";
    }

    public Boolean getStart() {
        return start;
    }

    public void setStart(Boolean start) {
        this.start = start;
    }


    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    @Override
    public int getPlayerIndex() {
        return playerIndex;
    }

    @Override
    public void setPlayerIndex(int playerIndex) {
        this.playerIndex = playerIndex;
    }
}
