package it.polimi.ingsw.Network.Client.CModel;

import it.polimi.ingsw.Model.WarehouseRow;

import java.util.ArrayList;

public class WarehouseClient {
    private ArrayList<WarehouseRow> warehouseRows = new ArrayList<>();

    public WarehouseClient() {
        warehouseRows.add(new WarehouseRow(1));
        warehouseRows.add(new WarehouseRow(2));
        warehouseRows.add(new WarehouseRow(3));
    }

    public ArrayList<WarehouseRow> getWarehouseRows() {
        return warehouseRows;
    }

    public void setWarehouseRows(ArrayList<WarehouseRow> warehouseRows) {
        this.warehouseRows = warehouseRows;
    }
}
