package it.polimi.ingsw;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GridCell {
    private DevelopmentCard[] cell;
    private int i = 0;

    public GridCell(DevelopmentCard card1,DevelopmentCard card2,DevelopmentCard card3,DevelopmentCard card4) {
        cell[0] = card1;
        cell[1] = card2;
        cell[2] = card3;
        cell[3] = card4;

        List<DevelopmentCard> ListCell = Arrays.asList(cell);
        Collections.shuffle(ListCell);
        ListCell.toArray(cell);

    } // le carte saranno mischiate prima di qua

    public DevelopmentCard getTopCard() { // mi rida la prima carta non nulla
        i = 0;
        while (cell[i]== null &&  i <= 3){
            i++;
        }
        if(i == 4) {
            return null;
        }
        else {
            return cell[i];
        }
    }
}
