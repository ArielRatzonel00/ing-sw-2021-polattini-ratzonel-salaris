package it.polimi.ingsw.Model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class FaithTrackTest {

    private int RedPositionTest;
    private FaithTrack Faith;
    private ArrayList<Player> OtherPlayersTest;
    private Player Gamer;

    @BeforeEach
    void initialization(){
        Faith = new FaithTrack();
        OtherPlayersTest = new ArrayList<>();
        Gamer = new Player("Luca");
        OtherPlayersTest.add(Gamer);
        RedPositionTest = 8;
        Faith.setRedPosition(RedPositionTest);
    }

    /**
     * test to count points from FaithTrack
     */
    @Test
    void totalPointsTest() {
        assertEquals(2, Faith.TotalPoints());
        Faith.setRedPosition(8);
        Faith.setRedPosition(8);
        assertEquals(20, Faith.TotalPoints());
        Faith.setBlackPosition(8);
        Faith.setBlackPosition(8);
        assertEquals(20, Faith.TotalPoints());
    }

    @Test
    void setOtherPlayersTest() {
        Faith.setOtherPlayers(OtherPlayersTest);
    }
}
