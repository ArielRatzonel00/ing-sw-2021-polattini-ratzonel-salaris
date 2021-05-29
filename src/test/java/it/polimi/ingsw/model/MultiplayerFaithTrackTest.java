package it.polimi.ingsw.model;

import it.polimi.ingsw.Model.MultiplayerFaithTrack;
import it.polimi.ingsw.Model.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MultiplayerFaithTrackTest {
    private int RedPositionTest;
    private MultiplayerFaithTrack Faith;
    private ArrayList<Player> OtherPlayersTest;
    private Player Gamer;

    @BeforeEach
    void initialization(){
        Faith = new MultiplayerFaithTrack();
        OtherPlayersTest = new ArrayList<>();
        Gamer = new Player("Luca");
        OtherPlayersTest.add(Gamer);
        RedPositionTest = 8;
        Faith.setRedPosition(RedPositionTest);
    }

    @Test
    void totalPointsTest() {
        assertEquals(2, Faith.TotalPoints());
        Faith.setRedPosition(8);
        Faith.setRedPosition(8);
        assertEquals(20, Faith.TotalPoints());
    }

    @Test
    void setOtherPlayersTest() {
        Faith.setOtherPlayers(OtherPlayersTest);
    }
}