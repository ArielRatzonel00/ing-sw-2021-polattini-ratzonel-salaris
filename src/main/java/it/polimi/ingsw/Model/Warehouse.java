package it.polimi.ingsw.Model;

import it.polimi.ingsw.Model.Marble.ColoredMarble;

import java.util.ArrayList;

public class Warehouse {

    private ArrayList<WarehouseRow> rows;

    public Warehouse() {
        this.rows.add(new WarehouseRow(1));
        this.rows.add(new WarehouseRow(2));
        this.rows.add(new WarehouseRow(3));
    }




    public WarehouseRow getRow(int rowNumber) {
        return rows.get(rowNumber);
    }

    public boolean addToRow(ColoredMarble coloredMarble, WarehouseRow row){
        if(row.addMarble(coloredMarble))
            return true;
        else
            return false;
    }

    public boolean RemoveFromRow(ColoredMarble coloredMarble, WarehouseRow row){
        if(row.removeMarble(coloredMarble))
            return true;
        else
            return false;
    }

    public boolean MoveResource(WarehouseRow row1, WarehouseRow row2){
        if(row1.getMarbles().size()<=row2.getSpace() && row2.getMarbles().size()<=row1.getSpace()){
            WarehouseRow temp = row2;
            row2=row1;
            row1=temp;
            return true;
        }
        return false;
    }

    public int getNumberOfResource(ColoredMarble.ColorMarble color){
        int i=0;
        for (WarehouseRow a: rows) {
            if(a.getColor().equals(color))
                i += a.getMarbles().size();
        }
        return i;
    }

}




// funzione per gestire i row extra




