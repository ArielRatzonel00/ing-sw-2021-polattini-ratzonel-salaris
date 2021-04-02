package it.polimi.ingsw;

public class DevelopmentGrid {
    private DevelopmentCard CardChosen; //carta che pesco
    private int i = 0;

    private DevelopmentCard[][][] DevelopmentGrid; // Matrice che contiene tutte le developmentCard,
    // ogni cella della matrice è a sua volta un array di development card,
    // quando una carta viene scelta si mette a null quella cella

    public DevelopmentCard AcquireCard(int colonna, int riga){
        i = 0;
        while (DevelopmentGrid[colonna][riga][i] != null) {
            CardChosen = DevelopmentGrid[colonna][riga][i];
        i++;
        } // per prendere si scorre l'array fino a che non si trova una cosa diversa null
        return CardChosen;
    }

}
