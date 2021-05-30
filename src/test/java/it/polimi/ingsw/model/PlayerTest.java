package it.polimi.ingsw.model;

import it.polimi.ingsw.Model.Deck;
import it.polimi.ingsw.Model.FaithTrack;
import it.polimi.ingsw.Model.LeaderCard.LeaderCard;
import it.polimi.ingsw.Model.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class PlayerTest {
    private Player gamer;
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
        gamer = new Player("Jonny");
    }

    @Test
    void checkResourcesForAcquisition() {
    }

    @Test
    void checkResourcesForProduce() {
    }

    @Test
    void checkPositionPopeFavor() {
    }

}