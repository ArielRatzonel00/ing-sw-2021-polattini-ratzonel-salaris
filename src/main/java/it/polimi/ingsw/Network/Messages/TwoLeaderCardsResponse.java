package it.polimi.ingsw.Network.Messages;

import it.polimi.ingsw.Model.LeaderCard.LeaderCard;

import java.util.ArrayList;

public class TwoLeaderCardsResponse extends Message {
    ArrayList<LeaderCard> leaderCards;
    public TwoLeaderCardsResponse() {
        this.typeOfMessage = "Two leader card response";
    }

    public ArrayList<LeaderCard> getLeaderCards() {
        return leaderCards;
    }

    public void setLeaderCards(ArrayList<LeaderCard> leaderCards) {
        this.leaderCards = leaderCards;
    }

}
