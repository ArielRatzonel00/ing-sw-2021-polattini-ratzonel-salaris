package it.polimi.ingsw.model;

import it.polimi.ingsw.Model.Deck;
import it.polimi.ingsw.Model.DevCardSlot;
import it.polimi.ingsw.Model.Marble.MarketMarble;
import it.polimi.ingsw.Model.Strongbox;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class StrongboxTest {
    private Strongbox strongboxTest;

    @BeforeEach
    void initialization(){
        strongboxTest = new Strongbox();
    }


    @Test
    void countResourcesTest() {
        assertEquals(0, strongboxTest.CountResources(MarketMarble.ColorMarble.BLUE));
        assertEquals(0, strongboxTest.CountResources(MarketMarble.ColorMarble.GREY));
        assertEquals(0, strongboxTest.CountResources(MarketMarble.ColorMarble.PURPLE));
        assertEquals(0, strongboxTest.CountResources(MarketMarble.ColorMarble.YELLOW));
        strongboxTest.AddResource(4, MarketMarble.ColorMarble.BLUE);
        assertEquals(4, strongboxTest.CountResources(MarketMarble.ColorMarble.BLUE));
        strongboxTest.RemoveResourcesFromStrongbox(2, MarketMarble.ColorMarble.BLUE);
        assertEquals(2, strongboxTest.CountResources(MarketMarble.ColorMarble.BLUE));
        assertEquals(0, strongboxTest.CountResources(MarketMarble.ColorMarble.RED));
        strongboxTest.AddResource(4, MarketMarble.ColorMarble.PURPLE);
        assertEquals(4, strongboxTest.CountResources(MarketMarble.ColorMarble.PURPLE));
        strongboxTest.AddResource(4, MarketMarble.ColorMarble.YELLOW);
        assertEquals(4, strongboxTest.CountResources(MarketMarble.ColorMarble.YELLOW));
        strongboxTest.AddResource(4, MarketMarble.ColorMarble.GREY);
        assertEquals(4, strongboxTest.CountResources(MarketMarble.ColorMarble.GREY));

    }

    @Test
    void getNumberOfTotalResourcesInStrongboxTest() {
        strongboxTest.AddResource(4, MarketMarble.ColorMarble.BLUE);
        strongboxTest.AddResource(3, MarketMarble.ColorMarble.GREY);
        assertEquals(3, strongboxTest.CountResources(MarketMarble.ColorMarble.GREY));
        strongboxTest.AddResource(2, MarketMarble.ColorMarble.RED);
        assertEquals(7, strongboxTest.getNumberOfTotalResourcesInStrongbox());
    }


}