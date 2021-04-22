
package it.polimi.ingsw.model;

import it.polimi.ingsw.Model.DevCardSlot;
import it.polimi.ingsw.Model.DevelopmentCard;
import it.polimi.ingsw.Model.Deck;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DevCardSlotTest {

    /*
    @BeforeEach
    public void initialization() {
        ArrayList<DevelopmentCard> cards = new ArrayList<DevelopmentCard>();
        cards.add(new DevelopmentGrid(new Deck()).getSingleCell(0,0).getTopCard());
    }

     */

    @Test
     void countVictoryPointsTest(){
        DevCardSlot TestSlot = new DevCardSlot();
        TestSlot.addCard(new Deck().getGreen11());
        assertEquals(1, TestSlot.countVictoryPoints());
    }


}


