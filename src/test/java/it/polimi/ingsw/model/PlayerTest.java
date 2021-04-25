package it.polimi.ingsw.model;

import it.polimi.ingsw.Model.Deck;
import it.polimi.ingsw.Model.DevCardSlot;
import it.polimi.ingsw.Model.LeaderCard.LeaderCard;
import it.polimi.ingsw.Model.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    private Player player;
    private ArrayList<LeaderCard> leaderCards;
    private Deck deck;

    @BeforeEach
    void initialization(){
        deck = new Deck();
        leaderCards = new ArrayList<>();
        leaderCards.add(deck.SelectLeadFromId(1));
        leaderCards.add(deck.SelectLeadFromId(2));
        leaderCards.add(deck.SelectLeadFromId(3));
        leaderCards.add(deck.SelectLeadFromId(4));
        player = new Player("Jonny",leaderCards);
        player.DiscardLeaderCard(2); //tolgo quella con id = 3
        player.DiscardLeaderCard(2); //tolgo quella con id = 4
    }

    @Test
    @DisplayName("")
    void checkResourcesForAcquisition() {
    }

    @Test
    @DisplayName("")
    void checkResourcesForProduce() {
    }

    @Test
    @DisplayName("")
    void checkPositionPopeFavor() {
    }

}