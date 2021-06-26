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
}