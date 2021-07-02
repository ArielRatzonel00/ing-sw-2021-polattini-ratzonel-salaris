package it.polimi.ingsw.Model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SlotsBoardTest {
    private ArrayList<DevCardSlot> TestSlotBoard;
    private Deck deck;
    private DevCardSlot TestSlot0;
    private DevCardSlot TestSlot1;
    private DevCardSlot TestSlot2;
    private SlotsBoard TestSlotGen;


    @BeforeEach
    void initialization(){
        TestSlotBoard = new ArrayList<>();
        TestSlot0 = new DevCardSlot();
        TestSlot1 = new DevCardSlot();
        TestSlot2 = new DevCardSlot();
        deck = new Deck();
        TestSlotGen = new SlotsBoard();
    }

    @Test
    void countVictoryPointsTest(){
        TestSlot0.addCard(deck.getGreen12());
        TestSlot0.addCard(deck.getGreen21());
        TestSlot0.addCard(deck.getGreen31());
        TestSlotBoard.add(TestSlot0);
        TestSlotGen.setSlots(TestSlotBoard);
        assertEquals(20, TestSlotGen.countVictoryPoints());
    }

    /**
     * tests that the player has a certain type of development cards in its slotsboard
     */
    @Test
    void filterCountTest1() {
        assertEquals(0, TestSlotGen.filterCount(1));
    }

    @Test
    void filterCountTest2() {
        TestSlot0.addCard(deck.getGreen31()); // non la aggiunge perchè non ha livello 2 sotto
        TestSlotBoard.add(TestSlot0);
        TestSlotGen.setSlots(TestSlotBoard);
        assertEquals(0, TestSlotGen.filterCount(1));
    }

    @Test
    void filterCountTest3() {
        TestSlot0.addCard(deck.getGreen12());
        TestSlot0.addCard(deck.getGreen12()); //non la aggiunge perchè già una di livello c'è
        TestSlot0.addCard(deck.getGreen21());
        TestSlot0.addCard(deck.getGreen31());
        TestSlotBoard.add(TestSlot0);
        TestSlotGen.setSlots(TestSlotBoard);
        assertEquals(3, TestSlotGen.filterCount(DevelopmentCard.colorCard.Green));
    }

    @Test
    void filterCountTest4() {
        TestSlot0.addCard(deck.getGreen12());
        TestSlot0.addCard(deck.getGreen12()); //non la aggiunge perchè già una di livello c'è
        TestSlot0.addCard(deck.getGreen21());
        TestSlot0.addCard(deck.getGreen31());
        TestSlotBoard.add(TestSlot0);
        TestSlotGen.setSlots(TestSlotBoard);
        assertEquals(1, TestSlotGen.filterCount(DevelopmentCard.colorCard.Green,1));
    }

    @Test
    void getCardsQuantityTest() {
        TestSlot0.addCard(deck.getGreen12());
        TestSlot0.addCard(deck.getGreen12()); //non la aggiunge perchè già una di livello c'è
        TestSlot0.addCard(deck.getGreen21());
        TestSlot0.addCard(deck.getGreen31());
        TestSlotBoard.add(TestSlot0);
        TestSlotGen.setSlots(TestSlotBoard);
        assertEquals(3, TestSlotGen.getCardsQuantity());
    }
}