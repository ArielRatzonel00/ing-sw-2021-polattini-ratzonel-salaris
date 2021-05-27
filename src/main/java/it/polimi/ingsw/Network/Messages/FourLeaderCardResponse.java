package it.polimi.ingsw.Network.Messages;

import it.polimi.ingsw.Model.DevelopmentCard;
import it.polimi.ingsw.Model.DevelopmentGrid;
import it.polimi.ingsw.Model.LeaderCard.LeaderCard;
import it.polimi.ingsw.Model.MarketTray;
import it.polimi.ingsw.Model.Player;

import java.util.ArrayList;

public class FourLeaderCardResponse extends Message{
    private ArrayList<LeaderCard> leaderCards;
    private ArrayList<DevelopmentCard> topCards;
    private MarketTray marketTray;

    public FourLeaderCardResponse(ArrayList<LeaderCard> leaderCard) {
        this.leaderCards=leaderCard;
        this.typeOfMessage = "FourLeaderCardResponse";
    }

    /*
    public void setLeaderCards(ArrayList<LeaderCard> leaderCards) {
        this.leaderCards = leaderCards;
    }
     */

    public ArrayList<LeaderCard> getLeaderCards() {
        return leaderCards;
    }

    public ArrayList<DevelopmentCard> getTopCards() {
        return topCards;
    }

    public MarketTray getMarketTray() {
        return marketTray;
    }

    public void setLeaderCards(ArrayList<LeaderCard> leaderCards) {
        this.leaderCards = leaderCards;
    }

    public void setTopCards(ArrayList<DevelopmentCard> topCards) {
        this.topCards = topCards;
    }

    public void setMarketTray(MarketTray marketTray) {
        this.marketTray = marketTray;
    }

    @Override
    public String toString() {
        return "FourLeaderCardResponse{" +
                "leaderCards=" + leaderCards +
                '}';
    }
}
