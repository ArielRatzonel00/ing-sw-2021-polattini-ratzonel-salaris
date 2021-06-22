package it.polimi.ingsw.Model;

import java.io.Serializable;
import java.util.ArrayList;

public class DevelopmentGrid implements Serializable {

    // Method that represents the DevelopmentGrid. It is a Matrix of GridCell and it contains all the DevelopmentCard

    private GridCell[][] CardMatrix = new GridCell[3][4]; // Matrice che contiene tutte le developmentCard
    private DevelopmentCard nullCard;
    
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
        nullCard = deck.getNullCard();
    }

    public ArrayList<DevelopmentCard> getTopcards(){
        ArrayList<DevelopmentCard> topcards = new ArrayList<>();
        for (int i = 0; i<3; i++) {
            for (int j = 0; j < 4; j++) {
                if (CardMatrix[i][j] != null) {
                    topcards.add(CardMatrix[i][j].getTopCard());
                } else {
                    topcards.add(nullCard);
                }
            }
        }
        return topcards;
    }

    public GridCell[][] getCardMatrix() {
        return CardMatrix;
    }

    public GridCell getSingleCell(int riga, int colonna) {
        return CardMatrix[riga][colonna];
    }

    /**
     * removes the bottom card of the lowest level of the color that is still on the DevelopmentGrid (Used in the effect of the Marker that RemovesCard)
     * @param colorCard color of the card
     * @return true if the card exists
     */
    public boolean RemoveCardByColor(DevelopmentCard.colorCard colorCard){
        switch(colorCard){
            case Green:if(CardMatrix[0][0].RemoveFirstCard()){
                return true;
            }else if(CardMatrix[1][0].RemoveFirstCard()) {
                return true;
            }
            else if(CardMatrix[2][0].RemoveFirstCard()) {
                return true;
            }
            break;

            case Blue:if(CardMatrix[0][1].RemoveFirstCard()){
                return true;
            }else if(CardMatrix[1][1].RemoveFirstCard()) {
                return true;
            }
            else if(CardMatrix[2][1].RemoveFirstCard()) {
                return true;
            }
            break;

            case Yellow: if(CardMatrix[0][2].RemoveFirstCard()){
                return true;
            }else if(CardMatrix[1][2].RemoveFirstCard()) {
                return true;
            }
            else if(CardMatrix[2][2].RemoveFirstCard()) {
                return true;
            }
            break;

            case Purple: if(CardMatrix[0][3].RemoveFirstCard()){
                return true;
            }else if(CardMatrix[1][3].RemoveFirstCard()) {
                return true;
            }
            else if(CardMatrix[2][3].RemoveFirstCard()) {
                return true;
            }
            break;

            default:return true;
        }

        return true;
    }

    public DevelopmentCard remove(int a, int b){
        return  CardMatrix[a][b].RemoveTopCard();
    }

    public DevelopmentCard get(int a, int b){
        return CardMatrix[a][b].getTopCard();
    }

}
