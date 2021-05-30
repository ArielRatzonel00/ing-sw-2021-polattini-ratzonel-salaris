package it.polimi.ingsw.Network.Client.CModel;


import java.util.ArrayList;

public class FaithTrackClient {
    private int redPosition=0;
    private int blackPosition = 0;
    private ArrayList<String> popeFavors =new ArrayList<>();

    public FaithTrackClient() {
        popeFavors.add("U");
        popeFavors.add("U");
        popeFavors.add("U");
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

    public ArrayList<String> getPopeFavors() {
        return popeFavors;
    }

    public void setPopeFavors(String popeFavor) {
        this.popeFavors.add(popeFavor);
    }
}
