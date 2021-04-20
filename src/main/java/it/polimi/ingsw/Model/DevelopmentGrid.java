package it.polimi.ingsw.Model;

public class DevelopmentGrid {

    // Method that represents the DevelopmentGrid. It is a Matrix of GridCell and it contains all the DevelopmentCard

    private GridCell[][] CardMatrix = new GridCell[3][4]; // Matrice che contiene tutte le developmentCard
    public DevelopmentGrid(Deck deck) {
        CardMatrix[0][0] = deck.getCell00();
        CardMatrix[0][1] = deck.getCell01();
        CardMatrix[0][2] = deck.getCell02();
        CardMatrix[0][3] = deck.getCell03();
        CardMatrix[1][0] = deck.getCell10();
        CardMatrix[1][1] = deck.getCell11();
        CardMatrix[1][2] = deck.getCell12();
        CardMatrix[1][3] = deck.getCell13();
        CardMatrix[2][0] = deck.getCell20();
        CardMatrix[2][1] = deck.getCell21();
        CardMatrix[2][2] = deck.getCell22();
        CardMatrix[2][3] = deck.getCell23();
    }



    public GridCell[][] getCardMatrix() {
        return CardMatrix;
    }
    public GridCell getSingleCell(int riga, int colonna) {
        return CardMatrix[riga][colonna];
    }
    public boolean RemoveCardByColor(DevelopmentCard.colorCard colorCard){
        if(colorCard == DevelopmentCard.colorCard.Green){
            if(CardMatrix[0][0].RemoveFirstCard() == true){
                return true;
            }else if(CardMatrix[1][0].RemoveFirstCard() == true) {
                return true;
            }
            else if(CardMatrix[2][0].RemoveFirstCard() == true) {
                return true;
            }

        }
        else if (colorCard == DevelopmentCard.colorCard.Blue){
            if(CardMatrix[0][1].RemoveFirstCard() == true){
                return true;
            }else if(CardMatrix[1][1].RemoveFirstCard() == true) {
                return true;
            }
            else if(CardMatrix[2][1].RemoveFirstCard() == true) {
                return true;
            }
        }
        else if (colorCard == DevelopmentCard.colorCard.Yellow){
            if(CardMatrix[0][2].RemoveFirstCard() == true){
                return true;
            }else if(CardMatrix[1][2].RemoveFirstCard() == true) {
                return true;
            }
            else if(CardMatrix[2][2].RemoveFirstCard() == true) {
                return true;
            }
        }
        else if (colorCard == DevelopmentCard.colorCard.Purple){
            if(CardMatrix[0][3].RemoveFirstCard() == true){
                return true;
            }else if(CardMatrix[1][3].RemoveFirstCard() == true) {
                return true;
            }
            else if(CardMatrix[2][3].RemoveFirstCard() == true) {
                return true;
            }
        }
        return true;
    } // Method that removes the bottom card of the lowest level of the color that is still on the DevelopmentGrid (Used in the effect of the Marker that RemovesCard)


    public DevelopmentCard remove(int a, int b){
        DevelopmentCard temp= CardMatrix[a][b].getTopCard();
        CardMatrix[a][b].RemoveTopCard();
        return temp;
    } // Method that removes and returns the top card of the cell selected

}
