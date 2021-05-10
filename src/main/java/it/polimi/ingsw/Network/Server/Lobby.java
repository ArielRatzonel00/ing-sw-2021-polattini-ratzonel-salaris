package it.polimi.ingsw.Network.Server;

import it.polimi.ingsw.Model.MultiplayerGame;
import it.polimi.ingsw.Model.Player;
import it.polimi.ingsw.Model.SinglePlayerGame;

import java.util.ArrayList;

public class Lobby{
    private static Lobby instance;
    private boolean isFull = true;
    private int nextGameNPlayers;
    private ArrayList<Player> Players = new ArrayList<>();
    private MultiplayerGame MultiGame;
    private SinglePlayerGame singleGame;


    //synchronized method to control simultaneous access

    synchronized public static Lobby getInstance()
    {
        if (instance == null)
        {
            // if instance is null, initialize
            instance = new Lobby();
        }
        return instance;
    }

    public boolean isFull() {
        return isFull;
    }

    public ArrayList<Player> getPlayers() {
        return Players;
    }

    public void setFull(boolean full) {
        isFull = full;
    }

    public void setNextGameNPlayers(int nextGameNPlayers) {
        this.nextGameNPlayers = nextGameNPlayers;
    }

    public int getNextGameNPlayers() {
        return nextGameNPlayers;
    }
}





/*import it.polimi.ingsw.Controller.GameManager;

import java.util.ArrayList;

public class Lobby {
    private ArrayList<Player> players = new Player;
    private int numberOfPlayers;
    /*Primo giocatore che entra nella lobby decide numero N di giocatori che giocheranno la partita
    quanto la lunghezza della lista dei giocatori sarà uguale ad N viene creata la partita
     */

    //Possibile idea: Observer

/*
void addPlayer (Player player){
    if(this.players.isEmpty()){
        player.setFirst(true);
        setNumberOfPlayers();
    }
    this.players.add(player);
    if(this.players.size()==numberOfPlayers)

}

//remove player (non particolarmente utile al momento)

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setNumberOfPlayers(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }
}
*/
