package it.polimi.ingsw.Model.LeaderCard;

import it.polimi.ingsw.Model.CostOfCard;
import it.polimi.ingsw.Model.Deck;
import it.polimi.ingsw.Model.Marble.MarketMarble;
import it.polimi.ingsw.Model.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LeaderCardTest {
    Deck deck;
    Player player;

    @BeforeEach
    void initialization(){
        deck = new Deck();
        player = new Player("Luca");
    }

    /**
     * tests that leader cards can't be activated at the start of the game
     */
    @Test
    void canBeActivatedTest() {
        assertFalse (deck.getExtraRsc1().canBeActivated(player));
        assertFalse (deck.getConvertRsc1().canBeActivated(player));
        assertFalse (deck.getExtraWarehouse1().canBeActivated(player));
        assertFalse (deck.getReduceCost1().canBeActivated(player));
    }

    /**
     * tests that leader cards are printed in the right way
     */
    @Test
    void stampaCartaTest() {
       assertTrue(("Power: WHITE marble -> PURPLE marble \n" + "Requirements: 1 devCard Blue, 2 devCard Yellow\n" + "VP: 5").equals(deck.getExtraRsc1().StampaCarta()));
       assertTrue(("Power: Extra production 1PURPLE-> 1 Faithpoint and 1 resource of your choice\n" +
               "Requirements: level 2 DevCard Blue\n" +
               "VP: 4").equals(deck.getConvertRsc1().StampaCarta()));
       assertTrue(("Power: Extra warehouse (2 space) PURPLE\n" +
               "Requirements: 5 resources GREY\n" +
               "VP: 3").equals(deck.getExtraWarehouse1().StampaCarta()));
        assertTrue(("Power: Discount -1 for devCard: PURPLE\n" +
                "Requirements: 1 devCard Yellow, 1 devCard Green\n" +
                "VP: 2").equals(deck.getReduceCost1().StampaCarta()));
    }
}