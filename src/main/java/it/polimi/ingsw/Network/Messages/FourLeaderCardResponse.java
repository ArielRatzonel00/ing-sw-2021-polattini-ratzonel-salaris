package it.polimi.ingsw.Network.Messages;

import it.polimi.ingsw.Model.LeaderCard.LeaderCard;
import it.polimi.ingsw.Model.Player;

import java.util.ArrayList;

public class FourLeaderCardResponse extends Message{
    ArrayList<String> leaderCards;
    public FourLeaderCardResponse(ArrayList<String> leaderCards) {
        this.leaderCards=leaderCards;
        this.typeOfMessage = "FourLeaderCardResponse";
    }

    /*
    public void setLeaderCards(ArrayList<LeaderCard> leaderCards) {
        this.leaderCards = leaderCards;
    }
     */

    public ArrayList<String> getLeaderCards() {
        return leaderCards;
    }

    @Override
    public String toString() {
        return "FourLeaderCardResponse{" +
                "leaderCards=" + leaderCards +
                '}';
    }
}
