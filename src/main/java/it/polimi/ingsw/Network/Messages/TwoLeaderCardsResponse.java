package it.polimi.ingsw.Network.Messages;

import it.polimi.ingsw.Model.LeaderCard.LeaderCard;
import it.polimi.ingsw.Model.Production;

import java.util.ArrayList;

public class TwoLeaderCardsResponse extends Message {
    private ArrayList<LeaderCard> leaderCards;
    private ArrayList<Production> productions;
    public TwoLeaderCardsResponse() {
        this.typeOfMessage = "Two leader card response";
    }


    public ArrayList<LeaderCard> getLeaderCards() {
        return leaderCards;
    }
    public void setLeaderCards(ArrayList<LeaderCard> leaderCards) {
        this.leaderCards = leaderCards;
    }

    public ArrayList<Production> getProductions() {
        return productions;
    }

    public void setProductions(ArrayList<Production> productions) {
        this.productions = productions;
    }
}
