package it.polimi.ingsw.model;

import it.polimi.ingsw.Model.Marble.MarketMarble;
import it.polimi.ingsw.Model.Warehouse;
import it.polimi.ingsw.Model.WarehouseRow;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WarehouseTest {/*
    private Warehouse Warehousetest;
    private MarketMarble Grey;
    private MarketMarble Blue;

    @BeforeEach
    void initialization(){
        Warehousetest = new Warehouse();
        Grey = new MarketMarble(MarketMarble.ColorMarble.GREY);
        Blue = new MarketMarble(MarketMarble.ColorMarble.BLUE);
    }

    @Test
    @DisplayName("Add a marble in a row")
    void addToRow() {
        assertTrue(Warehousetest.addToRow(Grey, 0),"Aggiungo la prima pallina grigia alla linea 1");
        assertFalse(Warehousetest.addToRow(Grey, 0), "Non posso aggiungere la pallina grigia 2");
        assertFalse(Warehousetest.addToRow(Blue, 0));
        assertTrue(Warehousetest.addToRow(Blue, 1));
        assertTrue(Warehousetest.addToRow(Blue, 1));
        assertFalse(Warehousetest.addToRow(Blue, 1));
    }

    @Test
    @DisplayName("Remove a marble from a row")
    void removeFromRow() {
        assertFalse(Warehousetest.RemoveFromRow(Grey, 0));
        Warehousetest.addToRow(Grey, 0);
        assertTrue(Warehousetest.RemoveFromRow(Grey, 0));
    }

    @Test
    @DisplayName("Move resources 1")
    void moveResource1() {
        Warehousetest.addToRow(Grey, 0);
        Warehousetest.addToRow(Blue, 1);
        assertTrue(Warehousetest.MoveResource(0, 1));
    }

    @Test
    @DisplayName("Move resources 2")
    void moveResource2() {
        Warehousetest.addToRow(Grey, 0);
        Warehousetest.addToRow(Blue, 1);
        Warehousetest.addToRow(Blue, 1);
        assertFalse(Warehousetest.MoveResource(0, 1));
    }

    @Test
    @DisplayName("Get number of resources of one type in the warehouse")
    void getNumberOfResource() {
        Warehousetest.addToRow(Blue, 1);
        Warehousetest.addToRow(Blue, 1);
        assertEquals(2, Warehousetest.getNumberOfResource(MarketMarble.ColorMarble.BLUE));
        assertEquals(0, Warehousetest.getNumberOfResource(MarketMarble.ColorMarble.GREY));
        Warehousetest.addToRow(Grey, 2);
        Warehousetest.addToRow(Grey, 2);
        assertEquals(2, Warehousetest.getNumberOfResource(MarketMarble.ColorMarble.BLUE));
        assertEquals(2, Warehousetest.getNumberOfResource(MarketMarble.ColorMarble.GREY));

    }

    @Test
    @DisplayName("Get number of total resources in the warehouse")
    void getNumberOfTotalResourcesInWarehouse() {
        Warehousetest.addToRow(Blue, 1);
        Warehousetest.addToRow(Grey, 2);
        Warehousetest.addToRow(Grey, 2);
        assertEquals(3, Warehousetest.getNumberOfTotalResourcesInWarehouse());
    }*/
}