package it.polimi.ingsw;

public class DevelopmentGrid {
    private DevelopmentCard Slot;
    private int i = 0;

    private DevelopmentCard[][][] DevelopmentGrid;
    public DevelopmentCard AcquireCard(int colonna, int riga){
        i = 0;
        while (DevelopmentGrid[colonna][riga][i] != null) {
            Slot = DevelopmentGrid[colonna][riga][i];
        i++;
        }
        return Slot;
    }

}
