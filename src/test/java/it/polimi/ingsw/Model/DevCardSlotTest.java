
package it.polimi.ingsw.Model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DevCardSlotTest {
    private DevCardSlot TestSlot;
    private Deck deck;

    @BeforeEach
    void initialization(){
        TestSlot = new DevCardSlot();
        deck = new Deck();
    }

    @Test
    @DisplayName("Get Top Card")
    void getTopCardTest(){
        TestSlot.addCard(deck.getGreen12());
        TestSlot.addCard(deck.getGreen21());
        TestSlot.addCard(deck.getGreen31());
        TestSlot.addCard(deck.getBlue11());
        assertSame(TestSlot.getTopCard(), deck.getGreen31());
    }

    @Test
    @DisplayName("Count Victory Points")
     void countVictoryPointsTest(){
        TestSlot.addCard(deck.getGreen12());
        TestSlot.addCard(deck.getGreen21());
        TestSlot.addCard(deck.getGreen31());
        assertEquals(20, TestSlot.countVictoryPoints());
    }

    @Test
    @DisplayName("Filter count level with no cards 1")
    void filterCountTest1() {
        assertEquals(0, TestSlot.filterCount(1));
    }

    @Test
    @DisplayName("Filter count level with no cards 2")
    void filterCountTest2() {
        TestSlot.addCard(deck.getGreen31()); // non la aggiunge perchè non ha livello 2 sotto
        assertEquals(0, TestSlot.filterCount(1));
    }

    @Test
    @DisplayName("Filter count color")
    void filterCountTest3() {
        TestSlot.addCard(deck.getGreen12());
        TestSlot.addCard(deck.getGreen12()); //non la aggiunge perchè già una di livello c'è
        TestSlot.addCard(deck.getGreen21());
        TestSlot.addCard(deck.getGreen31());
        assertEquals(3, TestSlot.filterCount(DevelopmentCard.colorCard.Green));
    }

    @Test
    @DisplayName("Filter count color and level")
    void filterCountTest4() {
        TestSlot.addCard(deck.getGreen12());
        TestSlot.addCard(deck.getGreen12()); //non la aggiunge perchè già una di livello c'è
        TestSlot.addCard(deck.getGreen21());
        TestSlot.addCard(deck.getGreen31());
        assertEquals(1, TestSlot.filterCount(DevelopmentCard.colorCard.Green,1));
    }
}


