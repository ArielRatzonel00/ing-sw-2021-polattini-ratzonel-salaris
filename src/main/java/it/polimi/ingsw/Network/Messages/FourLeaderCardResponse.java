package it.polimi.ingsw.Network.Messages;

import it.polimi.ingsw.Model.LeaderCard.LeaderCard;
import it.polimi.ingsw.Model.Player;

import java.util.ArrayList;

public class FourLeaderCardResponse extends Message{
    public FourLeaderCardResponse() {
        this.typeOfMessage = "FourLeaderCardResponse";
    }
    ArrayList<LeaderCard> leaderCards;

    public void setLeaderCards(ArrayList<LeaderCard> leaderCards) {
        this.leaderCards = leaderCards;
    }

    public ArrayList<LeaderCard> getLeaderCards() {
        return leaderCards;
    }
}
