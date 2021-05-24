package it.polimi.ingsw.Network.Messages;

import it.polimi.ingsw.Model.Player;

import java.util.ArrayList;

public class FourLeaderCardResponse extends Message{
    public FourLeaderCardResponse() {
        this.typeOfMessage = "FourLeaderCardResponse";
    }
    ArrayList<Player> players;

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }
}
