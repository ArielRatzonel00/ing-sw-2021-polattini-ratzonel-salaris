package it.polimi.ingsw.Network.Client.CModel;


import it.polimi.ingsw.Model.PopeFavorState;

import java.util.ArrayList;

public class FaithTrackClient {
    private int redPosition=0;
    private int blackPosition = 0;
    private ArrayList<PopeFavorState> popeFavors =new ArrayList<>();

    public FaithTrackClient() {
        popeFavors.add(PopeFavorState.Unabled);
        popeFavors.add(PopeFavorState.Unabled);
        popeFavors.add(PopeFavorState.Unabled);
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

    public ArrayList<PopeFavorState> getPopeFavors() {
        return popeFavors;
    }

    public void setPopeFavors(PopeFavorState popeFavor,int popefavornum ) {
        this.popeFavors.set(popefavornum,popeFavor);
    }
}
