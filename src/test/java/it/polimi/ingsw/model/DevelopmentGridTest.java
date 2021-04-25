package it.polimi.ingsw.model;

import it.polimi.ingsw.Model.Deck;
import it.polimi.ingsw.Model.DevCardSlot;
import it.polimi.ingsw.Model.DevelopmentGrid;
import it.polimi.ingsw.Model.GridCell;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DevelopmentGridTest {
    private GridCell[][] CardMatrix;
    private Deck deck;

    // un casino da testare perchè c'è shuffle -> come faccio a testare shuffle?
    @BeforeEach
    void initialization(){
        deck = new Deck();
        CardMatrix = new GridCell[3][4];

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

    @Test
    void getCardMatrix() {
    }

    @Test
    void getSingleCell() {
    }

    @Test
    void removeCardByColor() {
    }

    @Test
    void remove() {
    }
}