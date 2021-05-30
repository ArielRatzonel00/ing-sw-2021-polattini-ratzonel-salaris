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