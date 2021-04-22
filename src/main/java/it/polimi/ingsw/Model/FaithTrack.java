package it.polimi.ingsw.Model;

//Method that Represents the Faith Traick. Every Player has one

import java.util.ArrayList;

public class FaithTrack {
    private boolean Multiplayer;
    private int RedPosition = 0;
    private int BlackPosition = 0;
    private int points = 0;
    public enum popeFavorState{
        Activate,
        Unabled,
        Deleted
    }
    private popeFavorState popeFavor1 = popeFavorState.Unabled;
    private popeFavorState popeFavor2 = popeFavorState.Unabled;
    private popeFavorState popeFavor3 = popeFavorState.Unabled;
    private ArrayList<Player> OtherPlayers = new ArrayList<>();



    public int getRedPosition() {
        return RedPosition;
    } // get posizione pedina rossa

    public int getBlackPosition() {
        return BlackPosition;
    } // get posizione pedina nera

    public int getPoints() {
        return points;
    } // get punti totalizzati

    public boolean isMultiplayer() {
        return Multiplayer;
    }

    public popeFavorState getPopeFavor1() {
        return popeFavor1;
    }

    public popeFavorState getPopeFavor2() {
        return popeFavor2;
    }

    public popeFavorState getPopeFavor3() {
        return popeFavor3;
    }

    public void setMultiplayer(boolean multiplayer) {
        Multiplayer = multiplayer;
    }

    public void setRedPosition(int redPosition) {
        RedPosition  += redPosition;
        if (RedPosition == 8 || RedPosition == 16 || RedPosition == 24){
            if (RedPosition == 8){
                if (popeFavor1 == popeFavorState.Unabled){
                    setPopeFavor1(popeFavorState.Activate);
                    for (Player otherPlayer : OtherPlayers){
                        otherPlayer.CheckPositionPopeFavor(RedPosition);{
                        }
                    }
                    points += 2;
                }
            }
            else if (RedPosition == 16){
                if (popeFavor2 == popeFavorState.Unabled){
                    setPopeFavor2(popeFavorState.Activate);
                    for (Player otherPlayer : OtherPlayers){
                        otherPlayer.CheckPositionPopeFavor(RedPosition);{
                        }
                    }
                }
                points += 3;
            }
            else {
                if (popeFavor3 == popeFavorState.Unabled){
                    setPopeFavor3(popeFavorState.Activate);
                    for (Player otherPlayer : OtherPlayers){
                        otherPlayer.CheckPositionPopeFavor(RedPosition);
                    }
                    points += 4;
                }

            }
        }
    }

    public void setBlackPosition(int blackPosition) {
        BlackPosition += blackPosition;
    }

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
