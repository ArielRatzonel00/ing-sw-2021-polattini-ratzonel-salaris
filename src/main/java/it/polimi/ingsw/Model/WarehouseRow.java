package it.polimi.ingsw.Model;

import it.polimi.ingsw.Model.Marble.MarketMarble;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.ArrayList;
// Class that represents a single row of the Warehosue
public class WarehouseRow implements Serializable {
    private ArrayList<MarketMarble> marbles = new ArrayList<>();
    private int space;
    private MarketMarble.ColorMarble color;

    public WarehouseRow(int space) {
        this.space = space;
    } // A warehouse row is created by passing the number of maximum Marbles accepted


    public boolean addMarble(MarketMarble MarketMarble){
        if(marbles.size() == 0) {
            marbles.add(MarketMarble);
            color = MarketMarble.getColorMarble();
            return true;
        }
        else if(marbles.size() < space){
            if(MarketMarble.getColorMarble().equals(color)){
                marbles.add(MarketMarble);
                return true;
            }
        }
        return false;
    } // Method that adds a Marble in the row, the method returns true if it can be done and false if not


    public void removeMarble(MarketMarble.ColorMarble colorMarble, int num){
        for (int i = 0; i < num; i++) {
            if (colorMarble.equals(color) && marbles.size() > 0) {
                marbles.remove(marbles.size() - 1);
            }
        }
    } // Method that removes a Marble in the row.

    public ArrayList<MarketMarble> getMarbles() {
        return marbles;
    } // Method that returns the marbles in the row
    public int getNumberOfMarbles(){
        return marbles.size();
    }
    public void ChangeMarbles(ArrayList<MarketMarble> newmarbles, MarketMarble.ColorMarble newcolor){
        marbles = newmarbles;
        color = newcolor;
    } // Method that changes the marbles and the color of the row, it is useful for the method MoveResources in the Warehouse


    public int getSpace() {
        return space;
    } // Method that returns the number of maximum Marbles accepted

    public MarketMarble.ColorMarble getColor() {
        return color;
    } // Method that returns the color of the row

    public void setColor(MarketMarble.ColorMarble color) {
        this.color = color;
    } // Method that set the color of the row, it is used when the player activates the Leadercard that creates an extraWarehouseRow that has a specific color
}
