package it.polimi.ingsw.model;

import it.polimi.ingsw.Model.DevCardSlot;
import it.polimi.ingsw.Model.DevelopmentCard;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DevCardSlotTest {

    @BeforeEach
    public void initialization() {
        ArrayList<DevelopmentCard> cards = new ArrayList<DevelopmentCard>();
    }

    public void testAddGet(){
        ArrayList<DevelopmentCard> Card = new ArrayList<DevelopmentCard>();
        Card.add();
        Card.add();

        assertSame(DevelopmentCard, Card.get(0));
        assertSame(DevelopmentCard, Card.get(0));
    }

    @Test
    public void countVictoryPointsTest() {
        assertEquals(12, );
    }
}