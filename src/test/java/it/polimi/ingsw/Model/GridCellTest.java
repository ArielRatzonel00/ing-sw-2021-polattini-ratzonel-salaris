package it.polimi.ingsw.Model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GridCellTest {
    private GridCell cell;
    private Deck deck;
    private DevelopmentCard devCard;

    @BeforeEach
    void initialization(){
        deck = new Deck();
        cell = new GridCell(deck.getGreen11(), deck.getGreen12(), deck.getGreen13(), deck.getGreen14());
    }

    @Test
    void removeTopCardTest() {
        devCard = cell.getTopCard();
        assertSame(devCard,cell.RemoveTopCard());
    }
}