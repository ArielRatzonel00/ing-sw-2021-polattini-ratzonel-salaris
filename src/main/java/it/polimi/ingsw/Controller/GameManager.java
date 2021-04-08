package it.polimi.ingsw.Controller;
import it.polimi.ingsw.Model.*;
import java.util.*;


public class GameManager {
    private MultiplayerGame MultiGame;
    private SinglePlayerGame SingleGame;

    GameManager(){
        // if(CLASSE.get.TANTIGIOCATORI)
        this.MultiGame= new MultiplayerGame();
        //else
        this.SingleGame=new SinglePlayerGame();

    }

}
