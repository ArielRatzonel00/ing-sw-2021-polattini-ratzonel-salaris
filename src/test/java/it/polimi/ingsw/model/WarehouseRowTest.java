package it.polimi.ingsw.model;

import it.polimi.ingsw.Model.Marble.MarketMarble;
import it.polimi.ingsw.Model.WarehouseRow;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class WarehouseRowTest {
    private WarehouseRow Row1;
    private WarehouseRow Row2;
    private WarehouseRow Row3;
    private MarketMarble Grey;
    private MarketMarble Yellow;
    private MarketMarble Purple;
    private MarketMarble Blue;
    private ArrayList<MarketMarble> marblesTest;

    @BeforeEach
    void initialization(){
        Row1 = new WarehouseRow(1);
        Row2 = new WarehouseRow(2);
        Row3 = new WarehouseRow(3);
        Grey = new MarketMarble(MarketMarble.ColorMarble.GREY);
        Yellow = new MarketMarble(MarketMarble.ColorMarble.YELLOW);
        Purple = new MarketMarble(MarketMarble.ColorMarble.PURPLE);
        Blue = new MarketMarble(MarketMarble.ColorMarble.BLUE);
        marblesTest = new ArrayList<>();
    }

    @Test
    @DisplayName("Adding marbles to rows")
    void addMarble() {
        assertTrue(Row1.addMarble(Grey), "La grey è in Row1 -> 1");
        assertFalse(Row1.addMarble(Grey), "La grey è in Row1 -> 2");
        assertTrue(Row2.addMarble(Grey), "La grey è in Row2-> 1");//posso aggiungerla perchè il controllo è in warehouse
        assertFalse(Row2.addMarble(Blue), "La blu è in Row2-> 1");//la blu non può andare in row2 perchè c'è già una grigia che blocca il colore
        assertTrue(Row2.addMarble(Grey), "La grey è in Row2-> 2");
        assertFalse(Row2.addMarble(Grey), "La grey è in Row2-> 3");//la row2 ha solo 2 posti
        assertTrue(Row3.addMarble(Grey), "La grey è in Row3 -> 1");
        assertTrue(Row3.addMarble(Grey), "La grey è in Row3 -> 2");
        assertTrue(Row3.addMarble(Grey), "La grey è in Row3 -> 3");
        assertFalse(Row3.addMarble(Grey), "La grey è in Row3 -> 4");//no perchè spazio pieno
    }

    @Test
    @DisplayName("Remove marbles from rows")
    void removeMarble() {
        Row1.removeMarble(MarketMarble.ColorMarble.GREY, 1); // non fa niente perchè non ho palline
        Row1.addMarble(Grey);
        marblesTest.add(Grey);
        assertEquals(marblesTest,Row1.getMarbles());
        assertEquals(marblesTest.size(),Row1.getNumberOfMarbles());
        assertEquals(MarketMarble.ColorMarble.GREY,Row1.getColor());
        assertEquals(1, Row1.getSpace());
        Row1.removeMarble(MarketMarble.ColorMarble.GREY, 1);
        marblesTest.remove(0);
        assertEquals(marblesTest,Row1.getMarbles());
    }

    @Test
    void changeMarbles() { //i controlli avvengono in warehouse quindi inutile testare qui
        Row2.addMarble(Grey);
        Row2.addMarble(Grey);
        marblesTest.add(Grey);
        marblesTest.add(Grey);
        assertEquals(marblesTest,Row2.getMarbles());
        marblesTest.remove(1);
        marblesTest.remove(0);
        marblesTest.add(Blue);
        marblesTest.add(Blue);
        Row2.ChangeMarbles(marblesTest, MarketMarble.ColorMarble.BLUE);
        assertEquals(marblesTest,Row2.getMarbles());
    }
}