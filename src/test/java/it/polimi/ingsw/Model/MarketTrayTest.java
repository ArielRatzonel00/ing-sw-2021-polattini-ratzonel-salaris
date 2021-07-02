package it.polimi.ingsw.Model;

import it.polimi.ingsw.Model.Marble.MarketMarble;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MarketTrayTest {
    private MarketTray MarketTest;
    private MarketMarble[] returnedMarblesTest;
    private MarketMarble[] returnedMarblesTest1;
    private ArrayList<MarketMarble> returnedMarblesTest2;

    @BeforeEach
    void initialization(){
        MarketTest = new MarketTray();
        MarketMarble[] returnedMarblesTest = new MarketMarble[4];
        MarketMarble[] returnedMarblesTest1 = new MarketMarble[3];
        returnedMarblesTest2 = new ArrayList<>();
    }

    /**
     * test to try that marbles are returned in the right way
     */
    @Test
    void getMarketMarblesFromRowTest() {
        returnedMarblesTest = MarketTest.GetMarketMarblesFromRow(2);
        assertSame(MarketTest.getMarketMatrix()[2][0],returnedMarblesTest[0]);
        assertSame(MarketTest.getMarketMatrix()[2][1],returnedMarblesTest[1]);
        assertSame(MarketTest.getMarketMatrix()[2][2],returnedMarblesTest[2]);
        assertSame(MarketTest.getMarketMatrix()[2][3],returnedMarblesTest[3]);
    }

    /**
     * test to try that marbles are returned in the right way
     */
    @Test
    void getMarketMarblesFromColTest() {
        returnedMarblesTest1 = MarketTest.GetMarketMarblesFromCol(2);
        assertSame(MarketTest.getMarketMatrix()[0][2],returnedMarblesTest1[0]);
        assertSame(MarketTest.getMarketMatrix()[1][2],returnedMarblesTest1[1]);
        assertSame(MarketTest.getMarketMatrix()[2][2],returnedMarblesTest1[2]);
    }

    /**
     * test to try that marbles are shifted and returned in the right way
     */
    @Test
    void shiftMatrixByRowTest() {
        returnedMarblesTest2 = MarketTest.ShiftMatrixByRow(2);
        assertSame(MarketTest.getMarketMatrix()[2][0],returnedMarblesTest2.get(1));
        assertSame(MarketTest.getMarketMatrix()[2][1],returnedMarblesTest2.get(2));
        assertSame(MarketTest.getMarketMatrix()[2][2],returnedMarblesTest2.get(3));
        assertSame(MarketTest.getOustideMarble(),returnedMarblesTest2.get(0));
    }

    /**
     * test to try that marbles are shifted and returned in the right way
     */
    @Test
    void shiftMatrixByColTest() {
        returnedMarblesTest2 = MarketTest.ShiftMatrixByCol(2);
        assertSame(MarketTest.getMarketMatrix()[2][2],returnedMarblesTest2.get(1));
        assertSame(MarketTest.getMarketMatrix()[1][2],returnedMarblesTest2.get(2));
        assertSame(MarketTest.getOustideMarble(),returnedMarblesTest2.get(0));
    }
}