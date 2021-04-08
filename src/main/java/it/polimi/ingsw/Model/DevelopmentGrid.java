package it.polimi.ingsw.Model;

public class DevelopmentGrid {
    private GridCell[][] CardMatrix; // Matrice che contiene tutte le developmentCard
   // CardMatrix[0][0] = get(Cella 1);



    public GridCell[][] getCardMatrix() {
        return CardMatrix;
    }
    public GridCell getSingleCell(int riga, int colonna) {
        return CardMatrix[riga][colonna];
    }

}
