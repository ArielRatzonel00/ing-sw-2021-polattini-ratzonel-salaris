package it.polimi.ingsw;

public class DevelopmentGrid {
    private GridCell[][] CardMatrix; // Matrice che contiene tutte le developmentCard
    public GridCell[][] getCardMatrix() {
        return CardMatrix;
    }
    public GridCell getSingleCell(int riga, int colonna) {
        return CardMatrix[riga][colonna];
    }

}
