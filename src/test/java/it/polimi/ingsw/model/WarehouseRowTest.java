package it.polimi.ingsw.model;

import it.polimi.ingsw.Model.Deck;
import it.polimi.ingsw.Model.DevCardSlot;
import it.polimi.ingsw.Model.GridCell;
import it.polimi.ingsw.Model.Marble.ColoredMarble;
import it.polimi.ingsw.Model.WarehouseRow;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WarehouseRowTest {
    private WarehouseRow Row1;
    private WarehouseRow Row2;
    private WarehouseRow Row3;
    private ColoredMarble Grey;
    private ColoredMarble Yellow;
    private ColoredMarble Purple;
    private ColoredMarble Blue;

    @BeforeEach
    void initialization(){
        Row1 = new WarehouseRow(1);
        Row2 = new WarehouseRow(2);
        Row3 = new WarehouseRow(3);
        Grey = new ColoredMarble(ColoredMarble.ColorMarble.GREY);
        Yellow = new ColoredMarble(ColoredMarble.ColorMarble.YELLOW);
        Purple = new ColoredMarble(ColoredMarble.ColorMarble.PURPLE);
        Blue = new ColoredMarble(ColoredMarble.ColorMarble.BLUE);
    }

    @Test
    @DisplayName("Adding marbles to rows")
    void addMarble() {
       assertTrue(Row1.addMarble(Grey), "La grey è in Row1 -> 1");
       assertFalse(Row1.addMarble(Grey), "La grey è in Row1 -> 2");
       assertFalse(Row2.addMarble(Grey), "La grey è in Row2-> 1");
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