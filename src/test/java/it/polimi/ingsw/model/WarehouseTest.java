package it.polimi.ingsw.model;

import it.polimi.ingsw.Model.Marble.MarketMarble;
import it.polimi.ingsw.Model.Warehouse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WarehouseTest {
    private Warehouse WarehouseTest;
    private MarketMarble Grey;
    private MarketMarble Blue;

    @BeforeEach
    void initialization(){
        WarehouseTest = new Warehouse();
        Grey = new MarketMarble(MarketMarble.ColorMarble.GREY);
        Blue = new MarketMarble(MarketMarble.ColorMarble.BLUE);
    }

    @Test
    @DisplayName("Add a marble in a row")
    void addToRowTest() {
        assertTrue(WarehouseTest.addToRow(Grey, 0),"Aggiungo la prima pallina grigia alla linea 1");
        assertFalse(WarehouseTest.addToRow(Grey, 0), "Non posso aggiungere la pallina grigia 2");
        assertFalse(WarehouseTest.addToRow(Blue, 0));
        assertTrue(WarehouseTest.addToRow(Blue, 1));
        assertTrue(WarehouseTest.addToRow(Blue, 1));
        assertFalse(WarehouseTest.addToRow(Blue, 1));
    }

    @Test
    @DisplayName("Move resources 1")
    void moveResourceTest1() {
        WarehouseTest.addToRow(Grey, 0);
        WarehouseTest.addToRow(Blue, 1);
        assertTrue(WarehouseTest.MoveResource(0, 1));
    }

    @Test
    @DisplayName("Move resources 2")
    void moveResourceTest2() {
        WarehouseTest.addToRow(Grey, 0);
        WarehouseTest.addToRow(Blue, 1);
        WarehouseTest.addToRow(Blue, 1);
        assertFalse(WarehouseTest.MoveResource(0, 1));
    }

    @Test
    @DisplayName("Get number of resources of one type in the warehouse")
    void getNumberOfResourceTest() {
        WarehouseTest.addToRow(Blue, 1);
        WarehouseTest.addToRow(Blue, 1);
        assertEquals(2, WarehouseTest.getNumberOfResource(MarketMarble.ColorMarble.BLUE));
        assertEquals(0, WarehouseTest.getNumberOfResource(MarketMarble.ColorMarble.GREY));
        WarehouseTest.addToRow(Grey, 2);
        WarehouseTest.addToRow(Grey, 2);
        assertEquals(2, WarehouseTest.getNumberOfResource(MarketMarble.ColorMarble.BLUE));
        assertEquals(2, WarehouseTest.getNumberOfResource(MarketMarble.ColorMarble.GREY));
    }

    @Test
    @DisplayName("Get number of total resources in the warehouse")
    void getNumberOfTotalResourcesInWarehouseTest() {
        WarehouseTest.addToRow(Blue, 1);
        WarehouseTest.addToRow(Grey, 2);
        WarehouseTest.addToRow(Grey, 2);
        assertEquals(3, WarehouseTest.getNumberOfTotalResourcesInWarehouse());
    }

    @Test
    void checkRowTest() {
    }
}