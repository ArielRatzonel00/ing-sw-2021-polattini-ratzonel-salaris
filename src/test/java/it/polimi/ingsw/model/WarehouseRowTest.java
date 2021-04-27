package it.polimi.ingsw.model;

import it.polimi.ingsw.Model.Deck;
import it.polimi.ingsw.Model.DevCardSlot;
import it.polimi.ingsw.Model.GridCell;
import it.polimi.ingsw.Model.Marble.MarketMarble;
import it.polimi.ingsw.Model.WarehouseRow;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WarehouseRowTest {
    private WarehouseRow Row1;
    private WarehouseRow Row2;
    private WarehouseRow Row3;
    private MarketMarble Grey;
    private MarketMarble Yellow;
    private MarketMarble Purple;
    private MarketMarble Blue;

    @BeforeEach
    void initialization(){
        Row1 = new WarehouseRow(1);
        Row2 = new WarehouseRow(2);
        Row3 = new WarehouseRow(3);
        Grey = new MarketMarble(MarketMarble.ColorMarble.GREY);
        Yellow = new MarketMarble(MarketMarble.ColorMarble.YELLOW);
        Purple = new MarketMarble(MarketMarble.ColorMarble.PURPLE);
        Blue = new MarketMarble(MarketMarble.ColorMarble.BLUE);
    }

    @Test
    @DisplayName("Adding marbles to rows")
    void addMarble() {
       assertTrue(Row1.addMarble(Grey), "La grey è in Row1 -> 1");
       assertFalse(Row1.addMarble(Grey), "La grey è in Row1 -> 2");
       assertTrue(Row2.addMarble(Grey), "La grey è in Row2-> 1"); //posso aggiungerla perchè il controllo è in warehouse
    }

    @Test
    void removeMarble() {
    }

    @Test
    void getMarbles() {
    }

    @Test
    void changeMarbles() {
    }

    @Test
    void getSpace() {
    }

    @Test
    void getColor() {
    }

    @Test
    void setColor() {
    }
}