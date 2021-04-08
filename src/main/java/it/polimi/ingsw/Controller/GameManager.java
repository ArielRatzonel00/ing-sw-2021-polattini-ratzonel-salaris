package it.polimi.ingsw.Controller;
import it.polimi.ingsw.Model.*;
import java.util.*;


public class GameManager {
    private List<Player> players;
    private MultiplayerGame MultiGame;
    private SinglePlayerGame SingleGame;

    //Constructor of game Manager, choose between single or multi player game
    public GameManager(){
        //Se players <1 throw new exception
        if(players.size()>1)
        this.MultiGame= new MultiplayerGame(CLASSE.getPlayers, CLASSE.getDevelopmentCards);
        else
        this.SingleGame=new SinglePlayerGame(CLASSE.getPlayers, CLASSE.getDevelopmentCards,Classe.getMarkers);

    }

    // classe che estrae 4 carte per ogni giocatore e chiede di sceglierne 2
    public LeaderCardExtractor();


}
