package it.polimi.ingsw.Model;

import it.polimi.ingsw.Model.Marble.MarketMarble;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class CostOfCardTest {
    private CostOfCard Cost;

    @BeforeEach
    void initialization(){
      Cost = new CostOfCard(3, MarketMarble.ColorMarble.BLUE);
    }

    @Test
    void toStringTest() {
        assertTrue(Cost.toString().equals(Cost.getCostNumber() + "" + Cost.getCostColor()));
    }
}
