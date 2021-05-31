package it.polimi.ingsw.model;

import it.polimi.ingsw.Model.Deck;
import it.polimi.ingsw.Model.Marble.MarketMarble;
import it.polimi.ingsw.Model.Player;
import it.polimi.ingsw.Model.Warehouse;
import it.polimi.ingsw.Model.Strongbox;
import it.polimi.ingsw.Model.SlotsBoard;
import it.polimi.ingsw.Model.Production;
import it.polimi.ingsw.Model.CostOfCard;
import it.polimi.ingsw.Model.LeaderCard.LeaderCard;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    private Player gamer;
    private ArrayList<LeaderCard> leaderCards;
    private Deck deck;
    private Warehouse warehouseTest;
    private Strongbox strongboxTest;
    private SlotsBoard slotsBoardTest;
    private int TotalPointsTest = 0;
    private ArrayList<Production> productionsTest;
    private ArrayList<CostOfCard> costTest;
    private CostOfCard costCard1;
    private CostOfCard costCard2;
    private CostOfCard costCard3;
    private MarketMarble Yellow;
    private MarketMarble Blue;
    private int[] CostProduceTest = {0,0,0,0};


    @BeforeEach
    void initialization(){
        costCard1 = new CostOfCard(2, MarketMarble.ColorMarble.BLUE);
        costCard2 = new CostOfCard(2, MarketMarble.ColorMarble.YELLOW);
        costCard3 = new CostOfCard(2, MarketMarble.ColorMarble.PURPLE);
        costTest = new ArrayList<>();
        warehouseTest = new Warehouse();
        strongboxTest = new Strongbox();
        slotsBoardTest = new SlotsBoard();
        productionsTest = new ArrayList<>(4);
        deck = new Deck();
        leaderCards = new ArrayList<>();
        leaderCards.add(deck.getExtraRsc1());
        leaderCards.add(deck.getExtraRsc2());
        leaderCards.add(deck.getExtraRsc3());
        leaderCards.add(deck.getExtraRsc4());
        gamer = new Player("Jonny");
        gamer.AssignFourLeaderCard(leaderCards);
        Yellow = new MarketMarble(MarketMarble.ColorMarble.YELLOW);
        Blue = new MarketMarble(MarketMarble.ColorMarble.BLUE);
    }

    @Test
    void assignFourLeaderCardTest() {
        gamer.AssignFourLeaderCard(leaderCards);
        assertTrue(leaderCards.equals(gamer.getLeaderCards()));
    }

    @Test
    void discardLeaderCardTest() {
        gamer.AssignFourLeaderCard(leaderCards);
        gamer.DiscardLeaderCard(2);
        leaderCards.remove(2);
        assertTrue(leaderCards.equals(gamer.getLeaderCards()));
    }

    @Test
    void checkResourcesForAcquisitionTest() {
        costTest.add(costCard1);
        costTest.add(costCard2);
        assertFalse(gamer.CheckResourcesForAcquisition(costTest));
        costTest.add(costCard1);
        costTest.add(costCard2);
        gamer.getWarehouse().addToRow(Yellow,1);
        gamer.getWarehouse().addToRow(Yellow,1);
        gamer.getWarehouse().addToRow(Blue,2);
        gamer.getWarehouse().addToRow(Blue,2);
        assertTrue(gamer.CheckResourcesForAcquisition(costTest));
        costTest.add(costCard3);
        assertFalse(gamer.CheckResourcesForAcquisition(costTest));
    }

    @Test
    void checkResourcesForProduceTest() { //cost[0] = BLUE, cost[1] = GREY, cost[2] = PURPLE, cost[3] = YELLOW
        //da verificare anche con risorse nello strongbox -> solo che strongbox non funziona
        CostProduceTest[3]= 2;
        assertFalse(gamer.CheckResourcesForProduce(CostProduceTest));
        gamer.getWarehouse().addToRow(Yellow,1);
        gamer.getWarehouse().addToRow(Yellow,1);
        assertTrue(gamer.CheckResourcesForProduce(CostProduceTest));
        CostProduceTest[2]=4;
        assertFalse(gamer.CheckResourcesForProduce(CostProduceTest));
    }

    @Test
    void checkPositionPopeFavorTest() {
        gamer.getFaithTrack().setRedPosition(14);
        gamer.CheckPositionPopeFavor(2);
        assertEquals(3,gamer.getFaithTrack().getPoints());
    }

    /*
    @Test
    void productionIsAvailableTest() {
        gamer.setProductionsAvailable(2);
        assertTrue(gamer.ProductionIsAvailable(2));
    }

     */

    @Test
    void buyCardTest() {
    }

    @Test
    void newProductionFromLeaderCardTest() {
    }

    @Test
    void pointsFromLeaderCardTest() {
    }

    @Test
    void pointsFromWarehouseAndStrongboxTest() {
    }

    @Test
    void getTotalPointsTest() {
    }

    @Test
    void getProductionsAvailableTest() {
    }
}