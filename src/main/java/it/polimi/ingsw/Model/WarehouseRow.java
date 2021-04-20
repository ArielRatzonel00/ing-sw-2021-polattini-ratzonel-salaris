package it.polimi.ingsw.Model;

import it.polimi.ingsw.Model.Marble.ColoredMarble;
import java.util.ArrayList;

public class WarehouseRow {
    private ArrayList<ColoredMarble> marbles = new ArrayList<>();
    private int space;
    private ColoredMarble.ColorMarble color;

    public WarehouseRow(int space) {
        this.space = space;
    }


    public boolean addMarble(ColoredMarble coloredMarble){
        if(marbles.size() == 0) {
            marbles.add(coloredMarble);
            color = coloredMarble.getColorMarble();
            return true;
        }
        else if(marbles.size() <space){
            if(coloredMarble.getColorMarble().equals(color)){
                marbles.add(coloredMarble);
                return true;
            }
        }
        return false;
    }


    public boolean removeMarble(ColoredMarble coloredMarble){
        if(coloredMarble.getColorMarble().equals(color) && marbles.size()>0) {
            marbles.remove(marbles.size() - 1);
            if (marbles.size()==0)
                color = null;
            return true;
        }
        return false;
    }

    public ArrayList<ColoredMarble> getMarbles() {
        return marbles;
    }
    public void ChangeMarbles(ArrayList<ColoredMarble> newmarbles, ColoredMarble.ColorMarble newcolor){
        marbles = newmarbles;
        color = newcolor;
    }


    public int getSpace() {
        return space;
    }

    public ColoredMarble.ColorMarble getColor() {
        return color;
    }
}
