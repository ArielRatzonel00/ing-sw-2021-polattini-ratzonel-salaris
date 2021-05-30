package it.polimi.ingsw.Model;

import java.io.Serializable;
import java.util.ArrayList;

public class FaithTrack  implements Serializable {
    public enum PopeFavorState{
        Activate,
        Unabled,
        Deleted
    }
    private ArrayList<Player> OtherPlayers = new ArrayList<>();
    private int redPosition = 0;
    private int blackPosition = 0;
    private PopeFavorState popeFavor1 = PopeFavorState.Unabled;
    private PopeFavorState popeFavor2 = PopeFavorState.Unabled;
    private PopeFavorState popeFavor3 = PopeFavorState.Unabled;
    private int Points = 0;

    public ArrayList<Player> getOtherPlayers() {
        return OtherPlayers;
    }

    public int getRedPosition() {
        return redPosition;
    }

    public int getBlackPosition() {
        return blackPosition;
    }

    public PopeFavorState getPopeFavor1() {
        return popeFavor1;
    }

    public void setPopeFavor1(PopeFavorState popeFavor1) {
        this.popeFavor1 = popeFavor1;
    }

    public PopeFavorState getPopeFavor2() {
        return popeFavor2;
    }

    public void setPopeFavor2(PopeFavorState popeFavor2) {
        this.popeFavor2 = popeFavor2;
    }

    public PopeFavorState getPopeFavor3() {
        return popeFavor3;
    }

    public void setPopeFavor3(PopeFavorState popeFavor3) {
        this.popeFavor3 = popeFavor3;
    }

    public void setOtherPlayers(ArrayList<Player> otherPlayers) {
        OtherPlayers = otherPlayers;
    }

    public int getPoints() {
        return Points;
    }

    public void setPoints(int points) {
        Points += points;
    }

    public int setRedPosition(int RedPosition) {
        redPosition  += RedPosition;
        if (redPosition == 8 || redPosition == 16 || redPosition == 24){
            if (redPosition == 8){
                return 1;
            }
            else if (redPosition == 16){
                return 2;
            }
            else {
                return 3;
            }
        }
        return 0;
    }
    public int setBlackPosition(int BlackPosition){
        blackPosition += BlackPosition;
        if (blackPosition == 8 || blackPosition== 16 || blackPosition == 24){
            if (blackPosition == 8){
                return 1;
            }
            else if (blackPosition == 16){
                return 2;
            }
            else {
                return 3;
            }
        }
        return 0;
    }

    public Integer TotalPoints(){
        if (redPosition >= 3 && redPosition < 6){
            return 1;
        }
        else if (redPosition >= 6 && redPosition < 9){
            return 2;
        }
        else if (redPosition >= 9 && redPosition < 12){
            return 4;
        }
        else if (redPosition >= 12 && redPosition < 15){
            return 6;
        }
        else if (redPosition >= 15 && redPosition < 18){
            return 9;
        }
        else if (redPosition >= 18 && redPosition < 21){
            return 12;
        }
        else if (redPosition >= 21 && redPosition < 24){
            return 16;
        }
        else if (redPosition == 24){
            return 20;
        } else {
            return 0;
        }

    }
}
