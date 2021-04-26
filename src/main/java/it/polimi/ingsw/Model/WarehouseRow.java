package it.polimi.ingsw.Model;

import it.polimi.ingsw.Model.Marble.ColoredMarble;

import java.lang.reflect.Method;
import java.util.ArrayList;
// Class that represents a single row of the Warehosue
public class WarehouseRow {
    private ArrayList<ColoredMarble> marbles = new ArrayList<>();
    private int space;
    private ColoredMarble.ColorMarble color;

    public WarehouseRow(int space) {
        this.space = space;
    } // A warehouse row is created by passing the number of maximum Marbles accepted

    public boolean addMarble(ColoredMarble coloredMarble){
        if(marbles.size() == 0) {
            marbles.add(coloredMarble);
            color = coloredMarble.getColorMarble();
            return true;
        }
        else if(marbles.size() < space){
            if(coloredMarble.getColorMarble().equals(color)){
                marbles.add(coloredMarble);
                return true;
            }
        }
        return false;
    } // Method that adds a Marble in the row, the method returns true if it can be done and false if not

    public boolean removeMarble(ColoredMarble coloredMarble){
        if(coloredMarble.getColorMarble().equals(color) && marbles.size()>0) {
            marbles.remove(marbles.size() - 1);
            return true;
        }
        return false;
    } // Method that removes a Marble in the row, the method returns true if it can be done and false if not

    public ArrayList<ColoredMarble> getMarbles() {
        return marbles;
    } // Method that returns the marbles in the row

    public void ChangeMarbles(ArrayList<ColoredMarble> newmarbles, ColoredMarble.ColorMarble newcolor){
        marbles = newmarbles;
        color = newcolor;
    } // Method that changes the marbles and the color of the row, it is useful for the method MoveResources in the Warehouse


    public int getSpace() {
        return space;
    } // Method that returns the number of maximum Marbles accepted

    public ColoredMarble.ColorMarble getColor() {
        return color;
    } // Method that returns the color of the row

    public void setColor(ColoredMarble.ColorMarble color) {
        this.color = color;
    } // Method that set the color of the row, it is used when the player activates the Leadercard that creates an extraWarehouseRow that has a specific color
}
