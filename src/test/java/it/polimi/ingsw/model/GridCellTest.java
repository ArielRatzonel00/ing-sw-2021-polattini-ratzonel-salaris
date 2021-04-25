package it.polimi.ingsw.model;

import it.polimi.ingsw.Model.Deck;
import it.polimi.ingsw.Model.DevelopmentCard;
import it.polimi.ingsw.Model.GridCell;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class GridCellTest {
    private GridCell cell;
    private Deck deck;

    @BeforeEach
    void initialization(){
        deck = new Deck();
        cell = new GridCell(deck.getGreen11(), deck.getGreen12(), deck.getGreen13(), deck.getGreen14());
    }

    @Test
    @DisplayName("Get Top Card")
    void getTopCardTest(){
        assertSame(cell.getTopCard(), deck.getGreen14()); //il problema è che è shuffle quindi a volte esce giusto e a volte no.
    }


/*
    @Test
    @DisplayName("Remove First Card")
    void removeFirstCardTest() {
    }

 */
}