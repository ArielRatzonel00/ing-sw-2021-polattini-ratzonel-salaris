package it.polimi.ingsw.Model;


import it.polimi.ingsw.Model.LeaderCard.LeaderCard;

import java.util.ArrayList;

// Class that represents the Player

public class Player {
    private final String nickname;
    private FaithTrack faithTrack;
    private Warehouse warehouse;
    private Strongbox strongbox;
    private LeaderCard[] leaderCards;
    private SlotsBoard slotsBoard;
    private boolean isFirst;


    public Player(String nickname, LeaderCard[] FourLeaderCards) {

        this.nickname = nickname;
        this.faithTrack = new FaithTrack();
        this.warehouse = new Warehouse();
        this.strongbox = new Strongbox();
        this.leaderCards = FourLeaderCards;
        this.slotsBoard = new SlotsBoard();
        this.isFirst = false;
    }

    public String getNickname() {
        return nickname;
    }

    public FaithTrack getFaithTrack() {
        return faithTrack;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public Strongbox getStrongbox() {
        return strongbox;
    }

    public LeaderCard getLeaderCards(int num) {
        return leaderCards[num];
    }

    public SlotsBoard getSlotsBoard() {
        return slotsBoard;
    }

    public void setFirst(boolean first) {
        this.isFirst = first;
    } // Method that set the first player to enter the lobby

    public boolean CheckResources(ArrayList<CostOfCard> resoucesFromStrongbox, ArrayList<CostOfCard> resourcesFromWarehouse) {
        for (CostOfCard costOfCard : resoucesFromStrongbox) {
            if (costOfCard.getCostNumber() > this.getStrongbox().CountResources(costOfCard.getCostColor())) {
                return false;
            }
        }
        for (CostOfCard costOfCard : resourcesFromWarehouse) {
            if (costOfCard.getCostNumber() > this.getStrongbox().CountResources(costOfCard.getCostColor())) {
                return false;
            }
        }
        return true;
    }
}













/*   public void marketTray(MarketTray marketTray ){
        //ChiamaLaFunzioneDiMarketTray
    }
    public void DiscardLeaderCard(int num){
        leaderCards[num] = null; // Con ArrayList basta fare remove
    }
    public void produceByCard(DevelopmentCard developmentCard){
        //chiama la funzione di developmentCard
    }
    public void produceTwoOne(Resource First,Resource Second ){
        //Prende 2 risorse e ne mette una
    }
    public void ActiveLeaderCard(LeaderCard leaderCard){
        //Chiama la Funzione Di Leader Card
    }

    public void DiscardLeaderCard(LeaderCard leaderCard){
        //Chiama La Funzione Di LeaderCard
    }

    public void chooseLeaderCard(LeaderCard[] leaderCard){
        // da rivedere
    }
    public void BuyDevelopmentCard(int Colonna, int Righe){
        //Chiama la funzione di DevelopmentCard
        //Chiama la funzione di Slots
    }

  */



//da rivedere









