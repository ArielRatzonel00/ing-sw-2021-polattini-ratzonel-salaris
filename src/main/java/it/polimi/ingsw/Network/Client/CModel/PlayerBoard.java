package it.polimi.ingsw.Network.Client.CModel;

import it.polimi.ingsw.Model.DevelopmentCard;
import it.polimi.ingsw.Model.FaithTrack;
import it.polimi.ingsw.Model.LeaderCard.LeaderCard;
import it.polimi.ingsw.Model.Production;

import java.util.ArrayList;

public class PlayerBoard {
    private WarehouseClient warehosueClient = new WarehouseClient();
    private String nickname;
    private ArrayList<Integer> strongBox = new ArrayList<>(); // [0] = SHIELD/BLUE, [1] = STONE/GREY, [2] = SERVANT/PURPLE, [3] = COIN/YELLOW
    //Aggiungere contatori del colore e livello delle leaderCards
    private ArrayList<DevelopmentCard> devSlotClient = new ArrayList<>();
    private int devCardCounter=0;
    private ArrayList<Production> productions = new ArrayList<>();
    private FaithTrackClient faithTrackClient = new FaithTrackClient();
    private ArrayList<LeaderCard> leaderCards = new ArrayList<>();

    public WarehouseClient getWarehosueClient() {
        return warehosueClient;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setWarehosueClient(WarehouseClient warehosueClient) {
        this.warehosueClient = warehosueClient;
    }

    public ArrayList<Integer> getStrongBox() {
        return strongBox;
    }

    public void setStrongBox(ArrayList<Integer> strongBox) {
        this.strongBox = strongBox;
    }

    public ArrayList<DevelopmentCard> getDevSlotClient() {
        return devSlotClient;
    }

    public void setDevSlotClient(ArrayList<DevelopmentCard> devSlotClient) {
        this.devSlotClient = devSlotClient;
    }

    public int getDevCardCounter() {
        return devCardCounter;
    }

    public void setDevCardCounter(int devCardCounter) {
        this.devCardCounter = devCardCounter;
    }

    public ArrayList<Production> getProductions() {
        return productions;
    }

    public void setProductions(ArrayList<Production> productions) {
        this.productions = productions;
    }

    public FaithTrackClient getFaithTrackClient() {
        return faithTrackClient;
    }

    public void setFaithTrackClient(FaithTrackClient faithTrackClient) {
        this.faithTrackClient = faithTrackClient;
    }

    public ArrayList<LeaderCard> getLeaderCards() {
        return leaderCards;
    }

    public void setLeaderCards(ArrayList<LeaderCard> leaderCards) {
        this.leaderCards = leaderCards;
    }
}
