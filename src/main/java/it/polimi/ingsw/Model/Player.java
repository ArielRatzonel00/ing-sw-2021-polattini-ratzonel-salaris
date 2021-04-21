package it.polimi.ingsw.Model;


import it.polimi.ingsw.Model.LeaderCard.LeaderCard;

import java.util.ArrayList;

// Class that represents the Player

public class Player {
    private final String nickname;
    private FaithTrack faithTrack;
    private Warehouse warehouse;
    private Strongbox strongbox;
    private ArrayList<LeaderCard> leaderCards = new ArrayList<>();
    private SlotsBoard slotsBoard;
    private boolean isFirst;


    public Player(String nickname, ArrayList<LeaderCard> FourLeaderCards) {

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
        return leaderCards.get(num);
    }

    public SlotsBoard getSlotsBoard() {
        return slotsBoard;
    }

    public void setFirst(boolean first) {
        this.isFirst = first;
    } // Method that set the first player to enter the lobby

    public boolean CheckResources(ArrayList<CostOfCard> cost) {
        for (CostOfCard costOfCard : cost){
            if (costOfCard.getCostNumber() > this.getWarehouse().getNumberOfResource(costOfCard.getCostColor()) + this.getStrongbox().CountResources(costOfCard.getCostColor())){
                return false;
            }

        }
        return true;
    }
    public void DiscardLeaderCard(int index){
        leaderCards.remove(index);
    }
    public void CheckPositionPopeFavor(int RedPositionOfOtherPlayer){
        if (RedPositionOfOtherPlayer == 8){
            if (faithTrack.getRedPosition() >=5 ){
                faithTrack.setPopeFavor1(FaithTrack.popeFavorState.Activate);
                faithTrack.setPoints(2);
            }
            else {
                faithTrack.setPopeFavor1(FaithTrack.popeFavorState.Deleted);
            }
        }
        else if (RedPositionOfOtherPlayer == 16){
            if (faithTrack.getRedPosition() >= 12){
                faithTrack.setPopeFavor2(FaithTrack.popeFavorState.Activate);
                faithTrack.setPoints(3);
            }
            else {
                faithTrack.setPopeFavor1(FaithTrack.popeFavorState.Deleted);
            }
        }
        else {
            if (faithTrack.getRedPosition() >= 19){
                faithTrack.setPopeFavor3(FaithTrack.popeFavorState.Activate);
                faithTrack.setPoints(4);
            }
            else {
                faithTrack.setPopeFavor3(FaithTrack.popeFavorState.Deleted);
            }
        }
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









