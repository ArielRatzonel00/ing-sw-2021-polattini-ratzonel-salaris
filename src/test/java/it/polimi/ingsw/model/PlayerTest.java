package it.polimi.ingsw.model;

import it.polimi.ingsw.Model.*;
import it.polimi.ingsw.Model.Marble.MarketMarble;
import it.polimi.ingsw.Model.LeaderCard.LeaderCard;
import it.polimi.ingsw.Model.Player;
import it.polimi.ingsw.Model.Deck;
import it.polimi.ingsw.Model.Warehouse;
import it.polimi.ingsw.Model.SlotsBoard;
import it.polimi.ingsw.Model.Strongbox;
import it.polimi.ingsw.Model.Production;
import it.polimi.ingsw.Model.CostOfCard;
import it.polimi.ingsw.Model.DevCardSlot;
import it.polimi.ingsw.Model.LeaderCard.LeaderCard4;
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
    private DevCardSlot SlotTest1;
    private DevCardSlot SlotTest2;
    private DevCardSlot SlotTest3;
    private ArrayList<DevCardSlot> ArrayDevCardSlotTest;
    private Production ProductionLeaderTest;


    @BeforeEach
    void initialization(){
        costCard1 = new CostOfCard(2, MarketMarble.ColorMarble.BLUE);
        costCard2 = new CostOfCard(2, MarketMarble.ColorMarble.YELLOW);
        costCard3 = new CostOfCard(2, MarketMarble.ColorMarble.PURPLE);
        costTest = new ArrayList<>();
        warehouseTest = new Warehouse();
        strongboxTest = new Strongbox();
        slotsBoardTest = new SlotsBoard();
        productionsTest = new ArrayList<>();
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
        SlotTest1 = new DevCardSlot();
        SlotTest2 = new DevCardSlot();
        SlotTest3 = new DevCardSlot();
        ArrayDevCardSlotTest = new ArrayList<>();
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

    @Test
    void productionIsAvailableTest() {
        gamer.getSlotsBoard().getSlots().get(2).addCard(deck.getGreen11());
        gamer.setProductionsAvailable(2);
        assertTrue(gamer.ProductionIsAvailable(3));
        assertTrue(gamer.ProductionIsAvailable(0));
        assertFalse(gamer.ProductionIsAvailable(1));
    }

    @Test
    void buyCardTest() {
        gamer.buyCard(deck.getGreen11(),2);
        SlotTest3.addCard(deck.getGreen11());
        assertTrue(gamer.getSlotsBoard().getSlots().get(2).getTopCard().equals(SlotTest3.getTopCard()));
    }

    @Test
    void newProductionFromLeaderCardTest() {
        gamer.newProductionFromLeaderCard(((LeaderCard4) deck.getConvertRsc1()).getProduction());
        assertTrue(gamer.ProductionIsAvailable(4));
    }

    @Test
    void pointsFromLeaderCardTest() {
        gamer.AssignFourLeaderCard(leaderCards);
        gamer.getLeaderCard(1).setActivate(true);
        gamer.getLeaderCard(2).setActivate(true);
        assertEquals(10, gamer.PointsFromLeaderCard());
    }

    @Test
    void pointsFromWarehouseAndStrongboxTest() {
        gamer.getStrongbox().AddResource(3, MarketMarble.ColorMarble.BLUE);
        gamer.getStrongbox().AddResource(5, MarketMarble.ColorMarble.YELLOW);
        gamer.getWarehouse().addToRow(Blue,0);
        gamer.getWarehouse().addToRow(Blue,1);
        gamer.getWarehouse().addToRow(Yellow,1);
        assertEquals(2,gamer.PointsFromWarehouseAndStrongbox());
    }

    @Test
    void getTotalPointsTest() {
        gamer.getStrongbox().AddResource(3, MarketMarble.ColorMarble.BLUE);
        gamer.getStrongbox().AddResource(5, MarketMarble.ColorMarble.YELLOW);
        gamer.getWarehouse().addToRow(Blue,0);
        gamer.getWarehouse().addToRow(Blue,1);
        gamer.getWarehouse().addToRow(Yellow,1);
        gamer.getFaithTrack().setRedPosition(10);
        assertEquals(6,gamer.GetTotalPoints());
    }
}