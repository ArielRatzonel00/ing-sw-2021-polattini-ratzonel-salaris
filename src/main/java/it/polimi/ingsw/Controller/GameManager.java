package it.polimi.ingsw.Controller;
import it.polimi.ingsw.Model.*;
import java.util.*;


public class GameManager {
    private List<Player> players;
    private MultiplayerGame MultiGame;
    private SinglePlayerGame SingleGame;

    //Constructor of game Manager, choose between single or multi player game
    public void GameManaer(){

    }
    public void startGame(ArrayList<Player> player){
        //Se players <1 throw new exception
        if(players.size()>1)
        this.MultiGame= new MultiplayerGame(Lobby.getPlayers());
        else
        this.SingleGame=new SinglePlayerGame(Lobby.getPlayers());

    }

    public void endGame(){}
    public Player selectWinner(){}

    //metodo TURNO SUCCESSIVO

    //metodo FINISCI PARTITA
    //metodo conta punti




}
