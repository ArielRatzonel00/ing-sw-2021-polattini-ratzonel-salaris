package it.polimi.ingsw;

public class DevelopmentGrid {



    private DevelopmentCard CardChosen; //carta che pesco
    private int i = 0;
    private DevelopmentCard[][][] CardMatrix; // Matrice che contiene tutte le developmentCard,
    public DevelopmentGrid(DevelopmentCard[] developmentCards) {

        this.CardMatrix[0][0][0] = developmentCards[0];
        // da gestire con i contatori

    }
    public DevelopmentCard[][][] getDevelopmentGrid() {
        return DevelopmentGrid;
    }
    public DevelopmentCard GetCard(int colonna, int riga){
        i = 0;
        while (DevelopmentGrid[colonna][riga][i] != null) {
            CardChosen = DevelopmentGrid[colonna][riga][i];
        i++;
        } // per prendere si scorre l'array fino a che non si trova una cosa diversa null
        return CardChosen;
    }

}
    // ogni cella della matrice è a sua volta un array di development card,
    // quando una carta viene scelta si mette a null quella cella
    // Quando ho finito le carte, ci sarà null nella cella e verrà gestito

