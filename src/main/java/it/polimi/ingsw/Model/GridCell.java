package it.polimi.ingsw.Model;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GridCell {
    private ArrayList<DevelopmentCard> cell;

    private int i = 0;

    public GridCell(ArrayList<DevelopmentCard> ArrayDevelopmentCard) {
        cell = ArrayDevelopmentCard;
        Collections.shuffle(ArrayDevelopmentCard);
    } // le carte saranno mischiate prima di qua

    public DevelopmentCard getTopCard() { // mi ridà la prima carta non nulla
        if (cell.size() > 0){
            DevelopmentCard temp = cell.get(cell.size()-1);
            cell.remove(cell.size()-1);
            return temp;
        }
        else {
            return null;
        }
    }
}
