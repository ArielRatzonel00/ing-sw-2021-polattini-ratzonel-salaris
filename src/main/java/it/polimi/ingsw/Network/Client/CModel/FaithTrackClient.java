package it.polimi.ingsw.Network.Client.CModel;

import it.polimi.ingsw.Model.FaithTrack;

import java.util.ArrayList;

public class FaithTrackClient {
    private int redPosition=0;
    private int blackPosition = 0;
    private ArrayList<FaithTrack.popeFavorState> popeFavors =new ArrayList<>();

    public FaithTrackClient() {
        popeFavors.add(FaithTrack.popeFavorState.Unabled);
        popeFavors.add(FaithTrack.popeFavorState.Unabled);
        popeFavors.add(FaithTrack.popeFavorState.Unabled);
    }

    public int getRedPosition() {
        return redPosition;
    }

    public void setRedPosition(int redPosition) {
        this.redPosition = redPosition;
    }

    public int getBlackPosition() {
        return blackPosition;
    }

    public void setBlackPosition(int blackPosition) {
        this.blackPosition = blackPosition;
    }

    public ArrayList<FaithTrack.popeFavorState> getPopeFavors() {
        return popeFavors;
    }

    public void setPopeFavors(ArrayList<FaithTrack.popeFavorState> popeFavors) {
        this.popeFavors = popeFavors;
    }
}
