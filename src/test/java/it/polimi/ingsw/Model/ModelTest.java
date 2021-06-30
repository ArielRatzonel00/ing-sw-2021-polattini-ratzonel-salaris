package it.polimi.ingsw.Model;

import it.polimi.ingsw.Model.Marble.MarketMarble;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ModelTest {
    Player player1, player2, player3, player4;
    Model model, modelsingle;
    ArrayList<Player> players, playersingle;
    int lead0, lead1, lead2, lead3;
    CostOfCard cost0, cost1, cost2, cost3;
    CostOfCard cost4, cost5, cost6, cost7;
    DevelopmentCard card1;
    MarketMarble yellow, purple, blue, grey;
    Deck deck;
    PopeFavorState popeFavorAct;
    PopeFavorState popeFavorDel;
    PopeFavorState popeFavorUn;


    @BeforeEach
    void initialization() {
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
        playersingle = new ArrayList<>();
        playersingle.add(player1);
        modelsingle = new Model(playersingle);
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
        deck = new Deck();
        popeFavorAct = PopeFavorState.Activate;
        popeFavorDel = PopeFavorState.Deleted;
        popeFavorUn = PopeFavorState.Unabled;
    }

    @Test
    void assignFourLeaderCardsTest() {
        assertEquals(4, model.getNumberOfPlayers());
        model.AssignFourLeaderCards(0);
        lead0 = model.getPlayers().get(0).getLeaderCard(0).getId();
        lead1 = model.getPlayers().get(0).getLeaderCard(1).getId();
        lead2 = model.getPlayers().get(0).getLeaderCard(2).getId();
        lead3 = model.getPlayers().get(0).getLeaderCard(3).getId();
        model.DiscardInitialLeaderCards(0, 1, 2);
        assertSame(lead0, model.getPlayers().get(0).getLeaderCard(0).getId());
        assertSame(lead2, model.getPlayers().get(0).getLeaderCard(1).getId());
    }

    @Test
    void setInitialResourcesTest() {
        model.SetInitialResourcesForFirstPlayer();
        model.SetInitialResourcesForSecondPlayer(MarketMarble.ColorMarble.BLUE, 2);
        model.SetInitialResourcesForThirdPlayer(MarketMarble.ColorMarble.GREY, 1);
        model.SetInitialResourcesForForthPlayer(MarketMarble.ColorMarble.GREY, 1, MarketMarble.ColorMarble.GREY, 1);
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
        model.MarketTrayAction(0, true, 2);
        assertSame(model.getMarketTray().getMarketMatrix(), marketTray.getMarketMatrix());
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
        model.DealWithResources(0, keep, marbles, Rows);
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
    void wantToBuyCardAndBuyCardTest() {
        model.getPlayers().get(0).getStrongbox().AddResource(10, MarketMarble.ColorMarble.BLUE);
        model.getPlayers().get(0).getStrongbox().AddResource(10, MarketMarble.ColorMarble.YELLOW);
        model.getPlayers().get(0).getStrongbox().AddResource(10, MarketMarble.ColorMarble.GREY);
        model.getPlayers().get(0).getStrongbox().AddResource(10, MarketMarble.ColorMarble.PURPLE);
        model.WantToBuyCard(0, 0, 0, 0);
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

        card1 = model.getDevelopmentGrid().get(0, 0);
        model.BuyCard(0, costSt, costWh, Rows, 0, 0, 0);
        assertSame(card1, model.getPlayers().get(0).getSlotsBoard().getSlots().get(0).getTopCard());
    }

    @Test
    void discardLeaderCardActionTest() {
        model.AssignFourLeaderCards(0);
        lead0 = model.getPlayers().get(0).getLeaderCard(0).getId();
        lead1 = model.getPlayers().get(0).getLeaderCard(1).getId();
        lead2 = model.getPlayers().get(0).getLeaderCard(2).getId();
        lead3 = model.getPlayers().get(0).getLeaderCard(3).getId();
        model.DiscardInitialLeaderCards(0, 1, 2);
        model.DiscardLeaderCardAction(0, 1);

        assertSame(lead0, model.getPlayers().get(0).getLeaderCard(0).getId());
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
        model.DiscardInitialLeaderCards(0, 1, 2);
        assertFalse(model.getPlayers().get(0).getLeaderCard(0).isActivate());
        model.ActivateLeaderCardAction(0, 0);
        if (model.getPlayers().get(0).getLeaderCard(0).canBeActivated(player1)) {
            assertTrue(model.getPlayers().get(0).getLeaderCards().get(0).isActivate());
        } else {
            assertFalse(model.getPlayers().get(0).getLeaderCards().get(0).isActivate());
        }
    }

    @Test
    void moveResourcesTest() {
        model.getPlayers().get(0).getWarehouse().addToRow(grey, 0);
        model.getPlayers().get(0).getWarehouse().addToRow(blue, 1);
        assertSame(MarketMarble.ColorMarble.GREY, model.getPlayers().get(0).getWarehouse().getRow(0).getColor());
        assertSame(MarketMarble.ColorMarble.BLUE, model.getPlayers().get(0).getWarehouse().getRow(1).getColor());
        model.MoveResources(0, 0, 1);
        assertEquals(1, model.getPlayers().get(0).getWarehouse().getRow(0).getMarbles().size());
        assertSame(MarketMarble.ColorMarble.GREY, model.getPlayers().get(0).getWarehouse().getRow(1).getColor());
        assertSame(MarketMarble.ColorMarble.BLUE, model.getPlayers().get(0).getWarehouse().getRow(0).getColor());
    }

    @Test
    void produceAndCanProduceTest() {
        //faccio la produzione base e la produzione della carta Purple13 -> carta di livello 1 viola con 3 punti vittoria
        model.getPlayers().get(0).getSlotsBoard().getSlots().get(0).addCard(deck.getPurple13());
        assertTrue(deck.getPurple13().equals(model.getPlayers().get(0).getSlotsBoard().getSlots().get(0).getTopCard()));

        //rifornisco lo strongbox
        model.getPlayers().get(0).getStrongbox().AddResource(10, MarketMarble.ColorMarble.BLUE);
        model.getPlayers().get(0).getStrongbox().AddResource(10, MarketMarble.ColorMarble.YELLOW);
        model.getPlayers().get(0).getStrongbox().AddResource(10, MarketMarble.ColorMarble.GREY);
        model.getPlayers().get(0).getStrongbox().AddResource(10, MarketMarble.ColorMarble.PURPLE);
        assertEquals(40,model.getPlayers().get(0).getStrongbox().getNumberOfTotalResourcesInStrongbox());

        //rifornisco il warehouse
        model.getPlayers().get(0).getWarehouse().addToRow(blue,0);
        model.getPlayers().get(0).getWarehouse().addToRow(yellow,1);
        model.getPlayers().get(0).getWarehouse().addToRow(yellow,1);
        assertTrue(model.getPlayers().get(0).getWarehouse().CheckRow(1,2, MarketMarble.ColorMarble.YELLOW));
        assertTrue(model.getPlayers().get(0).getWarehouse().CheckRow(0,1, MarketMarble.ColorMarble.BLUE));

        //scelgo le produzioni da attivare -> la basic e la carta viola
        ArrayList<Integer> productionsIndexes = new ArrayList<>();
        productionsIndexes.add(0);
        productionsIndexes.add(1);

        //scelgo la basic
        ArrayList<CostOfCard> productionBasicCost = new ArrayList<>();
        CostOfCard costBasic1  = new CostOfCard(1, MarketMarble.ColorMarble.BLUE);
        CostOfCard costBasic2  = new CostOfCard(1, MarketMarble.ColorMarble.YELLOW);
        productionBasicCost.add(costBasic1);
        productionBasicCost.add(costBasic2);

        //controllo di poter produrre
        model.CanProduce(0, productionsIndexes, productionBasicCost);

        ArrayList<CostOfCard> resources = new ArrayList<>();


        ArrayList<ArrayList<CostOfCard>> ResourcesFromStrongbox = new ArrayList<>();
        ResourcesFromStrongbox.add(resources);
        ArrayList<CostOfCard> productionPurple = new ArrayList<>();
        CostOfCard costProd = new CostOfCard(2, MarketMarble.ColorMarble.YELLOW);
        productionPurple.add(costProd);
        ResourcesFromStrongbox.add(productionPurple);

        ArrayList<ArrayList<CostOfCard>> ResourcesFromWarehouse = new ArrayList<>();

        ResourcesFromWarehouse.add(productionBasicCost);
        ResourcesFromWarehouse.add(resources);

        ArrayList<MarketMarble.ColorMarble> profit = new ArrayList<>();
        profit.add(MarketMarble.ColorMarble.PURPLE);


        ArrayList<Integer> Rows = new ArrayList<>();
        Rows.add(0);
        Rows.add(1);

        ArrayList<ArrayList<Integer>> rows = new ArrayList<>();
        rows.add(Rows);


        model.Produce(0, productionsIndexes, ResourcesFromStrongbox, ResourcesFromWarehouse, rows, profit);


    }

    @Test
    void endTurn1() {
        model.EndTurn(0);
        modelsingle.EndTurn(0);
        assertFalse(model.getPlayers().get(0).isYourTurn());
        assertTrue(model.getPlayers().get(1).isYourTurn());
    }

    @Test
    void endTurnLastPlayer() {
        model.EndTurn(3);
        assertFalse(model.getPlayers().get(3).isYourTurn());
        assertTrue(model.getPlayers().get(0).isYourTurn());
    }

    @Test
    void getWinnerMultiplayer() {
        model.getPlayers().get(0).getStrongbox().AddResource(10, MarketMarble.ColorMarble.BLUE);
        assertTrue(player1.equals(model.GetWinnerMultiplayer()));
    }

    @Test
    void checkPopeFavorState() {
        ArrayList<PopeFavorState> popeFavorStatesUn = new ArrayList<>();
        popeFavorStatesUn.add(popeFavorUn);
        popeFavorStatesUn.add(popeFavorUn);
        popeFavorStatesUn.add(popeFavorUn);
        popeFavorStatesUn.add(popeFavorUn);
        popeFavorStatesUn.add(popeFavorUn);
        popeFavorStatesUn.add(popeFavorUn);
        popeFavorStatesUn.add(popeFavorUn);
        popeFavorStatesUn.add(popeFavorUn);
        popeFavorStatesUn.add(popeFavorUn);
        popeFavorStatesUn.add(popeFavorUn);
        popeFavorStatesUn.add(popeFavorUn);
        popeFavorStatesUn.add(popeFavorUn);
        assertTrue(popeFavorStatesUn.equals(model.getPopeFavorStates()));
        model.getPlayers().get(0).getFaithTrack().setRedPosition(8);
        model.getPlayers().get(1).getFaithTrack().setRedPosition(4);
        model.getPlayers().get(2).getFaithTrack().setRedPosition(5);
        model.CheckPopeFavorStateActivatedByCurrentPlayer(1);
        ArrayList<PopeFavorState> popeFavorStates = new ArrayList<>();
        popeFavorStates.add(popeFavorAct);
        popeFavorStates.add(popeFavorUn);
        popeFavorStates.add(popeFavorUn);
        popeFavorStates.add(popeFavorDel);
        popeFavorStates.add(popeFavorUn);
        popeFavorStates.add(popeFavorUn);
        popeFavorStates.add(popeFavorAct);
        popeFavorStates.add(popeFavorUn);
        popeFavorStates.add(popeFavorUn);
        popeFavorStates.add(popeFavorDel);
        popeFavorStates.add(popeFavorUn);
        popeFavorStates.add(popeFavorUn);
        model.CheckPopeFavorState(1);
        assertTrue(popeFavorStates.equals(model.getPopeFavorStates()));
    }
}