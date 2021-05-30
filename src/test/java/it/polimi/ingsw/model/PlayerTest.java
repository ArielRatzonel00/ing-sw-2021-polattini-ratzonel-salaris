package it.polimi.ingsw.model;

import it.polimi.ingsw.Model.Deck;
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
    private int TotalPointsTest;
    private ArrayList<Production> productionsTest;
    private ArrayList<CostOfCard> costTest;


    @BeforeEach
    void initialization(){
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
    }

    @Test
    void assignFourLeaderCard() {
        gamer.AssignFourLeaderCard(leaderCards);
        assertTrue(leaderCards.equals(gamer.getLeaderCards()));
    }

    @Test
    void checkResourcesForAcquisition() {

    }

    @Test
    void checkResourcesForProduce() {
    }

    @Test
    void discardLeaderCard() {
    }

    @Test
    void checkPositionPopeFavor() {
    }

    @Test
    void productionIsAvailable() {
    }

    @Test
    void buyCard() {
    }

    @Test
    void newProductionFromLeaderCard() {
    }

    @Test
    void pointsFromLeaderCard() {
    }

    @Test
    void pointsFromWarehouseAndStrongbox() {
    }

    @Test
    void getTotalPoints() {
    }

    @Test
    void getProductionsAvailable() {
    }
}