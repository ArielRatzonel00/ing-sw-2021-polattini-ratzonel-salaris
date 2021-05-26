package it.polimi.ingsw.Network.Client.CModel;

import it.polimi.ingsw.Model.WarehouseRow;

import java.util.ArrayList;

public class WarehouseClient {
    private ArrayList<WarehouseRow> warehouseRows = new ArrayList<>();

    public ArrayList<WarehouseRow> getWarehouseRows() {
        return warehouseRows;
    }

    public void setWarehouseRows(ArrayList<WarehouseRow> warehouseRows) {
        this.warehouseRows = warehouseRows;
    }
}
