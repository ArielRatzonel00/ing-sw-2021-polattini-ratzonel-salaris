package it.polimi.ingsw.Model;

//Method that Represents the Faith Traick. Every Player has one

import java.util.ArrayList;

public abstract class FaithTrack {
    protected int RedPosition = 0;
    protected int points = 0;
    public enum popeFavorState{
        Activate,
        Unabled,
        Deleted
    }
    protected popeFavorState popeFavor1 = popeFavorState.Unabled;
    protected popeFavorState popeFavor2 = popeFavorState.Unabled;
    protected popeFavorState popeFavor3 = popeFavorState.Unabled;
    //private ArrayList<Player> OtherPlayers = new ArrayList<>();
    // private int BlackPosition = 0;
    //private boolean Multiplayer;





    public int getRedPosition() {
        return RedPosition;
    } // get posizione pedina rossa

    public int getBlackPosition() {
        return 1;
    } // get posizione pedina nera


  /*  public boolean isMultiplayer() {
        return Multiplayer;
    }

   */

    public int getPoints() {
      return points;
  } // get punti totalizzati dai favori papali

    public popeFavorState getPopeFavor1() {
        return popeFavor1;
    }

    public popeFavorState getPopeFavor2() {
        return popeFavor2;
    }

    public popeFavorState getPopeFavor3() {
        return popeFavor3;
    }
/*
    public void setMultiplayer(boolean multiplayer) {
        Multiplayer = multiplayer;
    }
*/

    public void setRedPosition(int redPosition) {

    }

   public void setBlackPosition(int blackPosition) { }



    public void setPopeFavor1(popeFavorState popeFavor1) {
        this.popeFavor1 = popeFavor1;
    }

    public void setPopeFavor2(popeFavorState popeFavor2) {
        this.popeFavor2 = popeFavor2;
    }

    public void setPopeFavor3(popeFavorState popeFavor3) {
        this.popeFavor3 = popeFavor3;
    }

    public void setPoints(int points) {
        this.points += points;
    }
    public Integer TotalPoints(){
        return 0;
    }
}




    /*public void PopeSpaceAction(){
        // cosa speciale
    } // fai l'azione speciale

}
 public void moveForwardRed(){
        RedPosition++;
        //if RedPosition = casella in cui c'è qualcosa di speciale, fai la cosa speciale chiamando pope space action
        // if RedPosition = Numero, Points = points + valore casella
    }
    public void moveForwardBlack(){
        BlackPosition++;
        //if BlackPosition = casella in cui c'è qualcosa di speciale, fai la cosa speciale

    }
     */
