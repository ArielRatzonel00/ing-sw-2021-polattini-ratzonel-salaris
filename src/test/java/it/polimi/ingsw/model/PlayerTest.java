package it.polimi.ingsw.model;

import it.polimi.ingsw.Model.Deck;
import it.polimi.ingsw.Model.DevCardSlot;
import it.polimi.ingsw.Model.FaithTrack;
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
    private FaithTrack faithTrack;

    @BeforeEach
    void initialization(){
        deck = new Deck();
        leaderCards = new ArrayList<>();
        leaderCards.add(deck.getExtraRsc1());
        leaderCards.add(deck.getExtraRsc2());
        leaderCards.add(deck.getExtraRsc3());
        leaderCards.add(deck.getExtraRsc4());
        player = new Player("Jonny", faithTrack);
        player.DiscardLeaderCard(2); //tolgo quella con id = 3
        player.DiscardLeaderCard(2); //tolgo quella con id = 4
        //da rivedere
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