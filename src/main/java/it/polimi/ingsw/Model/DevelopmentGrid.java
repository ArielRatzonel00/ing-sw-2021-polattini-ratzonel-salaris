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
    }

}
