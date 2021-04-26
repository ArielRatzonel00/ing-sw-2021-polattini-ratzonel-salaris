package it.polimi.ingsw.Model;

import it.polimi.ingsw.Model.Marble.ColoredMarble;

import java.util.ArrayList;
// This class represent the Warehouse, every player has one Warehouse
public class Warehouse {

    private ArrayList<WarehouseRow> rows = new ArrayList<>();

    public Warehouse() {
        this.rows.add(new WarehouseRow(1));
        this.rows.add(new WarehouseRow(2));
        this.rows.add(new WarehouseRow(3));
    } // The Warehouse is created whit 3 Warehouse row: one with space 1, one with space 2, one with space 3

    public WarehouseRow getRow(int rowNumber) {
        return rows.get(rowNumber);
    } // returns the WarehouseRow selected

    public boolean addToRow(ColoredMarble coloredMarble, int rowNumber){
        if (rowNumber == 4 || rowNumber == 5  ){
            if (!(coloredMarble.getColorMarble().equals(getRow(rowNumber).getColor()))){
                return false;
            }
        }
        return rows.get(rowNumber).addMarble(coloredMarble);
    } // The method adds a Marble int the WarehouseRow selected, the method returns true if it can be added and returns false if not. If the row is a Extrarow there is an extra check that controls if the Marble has the color of the WarehouseRow color

    public boolean RemoveFromRow(ColoredMarble coloredMarble, int rowNumber){
        return rows.get(rowNumber).removeMarble(coloredMarble);
    } //The method removes a Marble int the WarehouseRow selected, the method returns true if it can be removed and returns false if not

    public boolean MoveResource(int rowNumber1, int rowNumber2){
        if (rowNumber1 == 4 || rowNumber1 == 5 || rowNumber2 == 4 ||rowNumber2 == 5 ){
            if (!(rows.get(rowNumber1).getColor().equals(rows.get(rowNumber2).getColor()))){
                return false;
            }
        }
        if(rows.get(rowNumber1).getMarbles().size()<=rows.get(rowNumber2).getSpace() && rows.get(rowNumber2).getMarbles().size()<=rows.get(rowNumber1).getSpace()){
            WarehouseRow temp = rows.get(rowNumber2);
            rows.get(rowNumber2).ChangeMarbles(rows.get(rowNumber1).getMarbles(),rows.get(rowNumber1).getColor());
            rows.get(rowNumber1).ChangeMarbles(temp.getMarbles(), temp.getColor());

            return true;
        }
        return false;
    } // The method swap the marbles of two WarehouseRows, the method returns true if it can be done and returns false if not. The method does an extra check if one of the two rows in Extrarow and controls that the swap happens only if the color of the two WarehouseRow is the same

    public int getNumberOfResource(ColoredMarble.ColorMarble color){
        int i=0;
        for (WarehouseRow a: rows) {
            if(a.getColor().equals(color))
                i += a.getMarbles().size();
        }
        return i;
    } // the method returns the number of Resorces in the Warehouse that have the color selected

    public ArrayList<WarehouseRow> getRows() {
        return rows;
    } // the method returns all the WarehouseRows in the Warehouse
}









