package it.polimi.ingsw.Model;

import it.polimi.ingsw.Model.Marble.MarketMarble;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ModelTest {
    Player player1, player2, player3, player4;
    Model model;
    ArrayList<Player> players;
    int lead0,lead1,lead2,lead3;
    CostOfCard cost0, cost1, cost2, cost3;
    CostOfCard cost4, cost5, cost6, cost7;
    DevelopmentCard card1;
    MarketMarble yellow, purple, blue, grey;

    @BeforeEach
    void initialization(){
        player1 = new Player("Luca");
        player2 = new Player("Marco");
        player3 = new Player("Gianfranco");
        player4 = new Player("Marcello");
        players = new ArrayList<>();
        players.add(player1);
        players.add(player2);
        players.add(player3);
        players.add(player4);
        model = new Model(players);
        cost0 = new CostOfCard(2, MarketMarble.ColorMarble.BLUE);
        cost1 = new CostOfCard(2, MarketMarble.ColorMarble.PURPLE);
        cost2 = new CostOfCard(2, MarketMarble.ColorMarble.GREY);
        cost3 = new CostOfCard(2, MarketMarble.ColorMarble.YELLOW);
        cost4 = new CostOfCard(0, MarketMarble.ColorMarble.BLUE);
        cost5 = new CostOfCard(0, MarketMarble.ColorMarble.PURPLE);
        cost6 = new CostOfCard(0, MarketMarble.ColorMarble.GREY);
        cost7 = new CostOfCard(0, MarketMarble.ColorMarble.YELLOW);
        yellow = new MarketMarble(MarketMarble.ColorMarble.YELLOW);
        blue = new MarketMarble(MarketMarble.ColorMarble.BLUE);
        purple = new MarketMarble(MarketMarble.ColorMarble.PURPLE);
        grey = new MarketMarble(MarketMarble.ColorMarble.GREY);

    }

    @Test
    void assignFourLeaderCardsTest() {
        assertEquals(4, model.getNumberOfPlayers());
        model.AssignFourLeaderCards(0);
        lead0 = model.getPlayers().get(0).getLeaderCard(0).getId();
        lead1 = model.getPlayers().get(0).getLeaderCard(1).getId();
        lead2 = model.getPlayers().get(0).getLeaderCard(2).getId();
        lead3 = model.getPlayers().get(0).getLeaderCard(3).getId();
        model.DiscardInitialLeaderCards(0,1, 2);
        assertSame(lead0,model.getPlayers().get(0).getLeaderCard(0).getId());
        assertSame(lead2,model.getPlayers().get(0).getLeaderCard(1).getId());
    }

    @Test
    void setInitialResourcesTest() {
        model.SetInitialResourcesForFirstPlayer();
        model.SetInitialResourcesForSecondPlayer(MarketMarble.ColorMarble.BLUE,2);
        model.SetInitialResourcesForThirdPlayer(MarketMarble.ColorMarble.GREY,1);
        model.SetInitialResourcesForForthPlayer(MarketMarble.ColorMarble.GREY,1, MarketMarble.ColorMarble.GREY,1);
        assertEquals(0, model.getPlayers().get(0).getWarehouse().getNumberOfResource(MarketMarble.ColorMarble.BLUE));
        assertEquals(1, model.getPlayers().get(1).getWarehouse().getNumberOfResource(MarketMarble.ColorMarble.BLUE));
        assertEquals(1, model.getPlayers().get(2).getWarehouse().getNumberOfResource(MarketMarble.ColorMarble.GREY));
        assertEquals(2, model.getPlayers().get(3).getWarehouse().getNumberOfResource(MarketMarble.ColorMarble.GREY));
    }

    @Test
    void marketTrayActionTest() { //
        MarketTray marketTray = new MarketTray();
        marketTray = model.getMarketTray();
        marketTray.ShiftMatrixByCol(2);
        MarketMarble[] returnedMarblesTest1 = new MarketMarble[3];
        returnedMarblesTest1 = model.getMarketTray().GetMarketMarblesFromCol(2);
        model.MarketTrayAction(0,true,2);
        assertSame(model.getMarketTray().getMarketMatrix(),marketTray.getMarketMatrix());
    }

    @Test
    void dealWithResourcesTest() {
        ArrayList<MarketMarble.ColorMarble> marbles = new ArrayList<>();
        marbles.add(MarketMarble.ColorMarble.BLUE);
        marbles.add(MarketMarble.ColorMarble.GREY);
        marbles.add(MarketMarble.ColorMarble.RED);
        ArrayList<Boolean> keep = new ArrayList<>();
        keep.add(false);
        keep.add(true);
        keep.add(true);
        ArrayList<Integer> Rows = new ArrayList<>();
        Rows.add(0);
        Rows.add(1);
        Rows.add(2);
        model.DealWithResources(0,keep,marbles,Rows);
        assertEquals(1, model.getPlayers().get(0).getWarehouse().getNumberOfTotalResourcesInWarehouse());
        marbles.remove(2);
        keep.remove(2);
        marbles.add(MarketMarble.ColorMarble.BLUE);
        marbles.add(MarketMarble.ColorMarble.BLUE);
        keep.add(false);
        keep.add(false);
        assertEquals(1, model.getPlayers().get(0).getWarehouse().getNumberOfTotalResourcesInWarehouse());
    }

    @Test
    void wantToBuyCardeBuyCardTest() {
        model.getPlayers().get(0).getStrongbox().AddResource(10, MarketMarble.ColorMarble.BLUE);
        model.getPlayers().get(0).getStrongbox().AddResource(10, MarketMarble.ColorMarble.YELLOW);
        model.getPlayers().get(0).getStrongbox().AddResource(10, MarketMarble.ColorMarble.GREY);
        model.getPlayers().get(0).getStrongbox().AddResource(10, MarketMarble.ColorMarble.PURPLE);
        model.WantToBuyCard(0,0,0,0);
        ArrayList<CostOfCard> costSt = new ArrayList<>();
        costSt.add(cost0);
        costSt.add(cost1);
        costSt.add(cost2);
        costSt.add(cost3);
        ArrayList<CostOfCard> costWh = new ArrayList<>();
        costWh.add(cost4);
        costWh.add(cost5);
        costWh.add(cost6);
        costWh.add(cost7);
        ArrayList<Integer> Rows = new ArrayList<>();
        Rows.add(0);
        Rows.add(1);
        Rows.add(2);
        Rows.add(2);

        card1 = model.getDevelopmentGrid().get(0,0);
        model.BuyCard(0,costSt,costWh,Rows,0,0,0);
        assertSame(card1,model.getPlayers().get(0).getSlotsBoard().getSlots().get(0).getTopCard());
    }

    @Test
    void discardLeaderCardActionTest() {
        model.AssignFourLeaderCards(0);
        lead0 = model.getPlayers().get(0).getLeaderCard(0).getId();
        lead1 = model.getPlayers().get(0).getLeaderCard(1).getId();
        lead2 = model.getPlayers().get(0).getLeaderCard(2).getId();
        lead3 = model.getPlayers().get(0).getLeaderCard(3).getId();
        model.DiscardInitialLeaderCards(0,1, 2);
        model.DiscardLeaderCardAction(0,1);

        assertSame(lead0,model.getPlayers().get(0).getLeaderCard(0).getId());
    }

    @Test
    void activateLeaderCardActionTest() {
        model.getPlayers().get(0).getStrongbox().AddResource(10, MarketMarble.ColorMarble.BLUE);
        model.getPlayers().get(0).getStrongbox().AddResource(10, MarketMarble.ColorMarble.YELLOW);
        model.getPlayers().get(0).getStrongbox().AddResource(10, MarketMarble.ColorMarble.GREY);
        model.getPlayers().get(0).getStrongbox().AddResource(10, MarketMarble.ColorMarble.PURPLE);
        model.AssignFourLeaderCards(0);
        lead0 = model.getPlayers().get(0).getLeaderCard(0).getId();
        lead1 = model.getPlayers().get(0).getLeaderCard(1).getId();
        lead2 = model.getPlayers().get(0).getLeaderCard(2).getId();
        lead3 = model.getPlayers().get(0).getLeaderCard(3).getId();
        model.DiscardInitialLeaderCards(0,1, 2);
        assertFalse(model.getPlayers().get(0).getLeaderCard(0).isActivate());
        model.ActivateLeaderCardAction(0,0);
        if(model.getPlayers().get(0).getLeaderCard(0).canBeActivated(player1)){
            assertTrue(model.getPlayers().get(0).getLeaderCards().get(0).isActivate());
        } else {
            assertFalse(model.getPlayers().get(0).getLeaderCards().get(0).isActivate());
        }
    }

    @Test
    void moveResourcesTest() {
        model.getPlayers().get(0).getWarehouse().addToRow(grey,0);
        model.getPlayers().get(0).getWarehouse().addToRow(blue,1);
        assertSame(MarketMarble.ColorMarble.GREY, model.getPlayers().get(0).getWarehouse().getRow(0).getColor());
        assertSame(MarketMarble.ColorMarble.BLUE, model.getPlayers().get(0).getWarehouse().getRow(1).getColor());
        model.MoveResources(0,0,1);
        assertSame(MarketMarble.ColorMarble.GREY, model.getPlayers().get(0).getWarehouse().getRow(1).getColor());
        //assertEquals(2, model.getPlayers().get(0).getWarehouse().getNumberOfTotalResourcesInWarehouse());
    }

    @Test
    void canProduce() {
    }

    @Test
    void produce() {
    }

    @Test
    void endTurn() {
    }

    @Test
    void getMarkers() {
    }

    @Test
    void getWinnerMultiplayer() {
    }

    @Test
    void getDeck() {
    }

    @Test
    void incrementContForStart() {
    }

    @Test
    void checkPopeFavorState() {
    }

    @Test
    void getPopeFavorStates() {
    }

    @Test
    void checkPopeFavorStateActivatedByCurrentPlayer() {
    }
}