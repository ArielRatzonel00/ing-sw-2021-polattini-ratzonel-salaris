package it.polimi.ingsw.Model;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GridCell {
    private ArrayList<DevelopmentCard> cell = new ArrayList<>();


    private int i = 0;

    public GridCell(DevelopmentCard developmentCard1, DevelopmentCard developmentCard2,DevelopmentCard developmentCard3,DevelopmentCard developmentCard4) {
        cell.add(developmentCard1);
        cell.add(developmentCard2);
        cell.add(developmentCard3);
        cell.add(developmentCard4);
        Collections.shuffle(cell);
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
    public boolean RemoveFirstCard(){
        if (cell.size() > 0){
            cell.remove(0);
            return true;
        }
        else {
            return false;
        }

    }

}
