package it.polimi.ingsw.Model;


import it.polimi.ingsw.Model.LeaderCard.LeaderCard;
import it.polimi.ingsw.Model.Marble.MarketMarble;

import java.util.ArrayList;

// Class that represents the Player

public class Player {
    private String nickname;
    private FaithTrack faithTrack;
    private Warehouse warehouse;
    private Strongbox strongbox;
    private ArrayList<LeaderCard> leaderCards = new ArrayList<>();
    private SlotsBoard slotsBoard;
    private boolean isFirst;
    private int DiscountGrey = 0;
    private int DiscountYellow = 0;
    private int DiscountPurple = 0;
    private int DiscountBlue = 0;
    private ArrayList<Production> productionsAvaible = new ArrayList<>(4);




    public Player(String nickname, ArrayList<LeaderCard> FourLeaderCards, FaithTrack faithTrack) {

        this.nickname = nickname;
        this.faithTrack = faithTrack;
        this.warehouse = new Warehouse();
        this.strongbox = new Strongbox();
        this.leaderCards = FourLeaderCards;
        this.slotsBoard = new SlotsBoard();
        this.isFirst = false;
        ArrayList<CostOfCard> ProductionBasicCost = new ArrayList<>();
        ProductionBasicCost.add(0, new CostOfCard(2, MarketMarble.ColorMarble.UNKNOWN));
        ArrayList<CostOfCard> ProductionBasicProfit = new ArrayList<>();
        ProductionBasicCost.add(0, new CostOfCard(1, MarketMarble.ColorMarble.UNKNOWN));
        this.productionsAvaible.add(0, new Production(ProductionBasicCost, ProductionBasicProfit));
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

    public boolean CheckResourcesForAcquisition(ArrayList<CostOfCard> cost) {
        for (CostOfCard costOfCard : cost){
            if (costOfCard.getCostColor() == MarketMarble.ColorMarble.GREY){
                if (costOfCard.getCostNumber() - DiscountGrey > this.getWarehouse().getNumberOfResource(costOfCard.getCostColor()) + this.getStrongbox().CountResources(costOfCard.getCostColor())){
                    return false;
                }
            }
            else if (costOfCard.getCostColor() == MarketMarble.ColorMarble.YELLOW){
                if (costOfCard.getCostNumber() - DiscountYellow > this.getWarehouse().getNumberOfResource(costOfCard.getCostColor()) + this.getStrongbox().CountResources(costOfCard.getCostColor())){
                    return false;
                }
            }
            else if (costOfCard.getCostColor() == MarketMarble.ColorMarble.BLUE){
                if (costOfCard.getCostNumber() - DiscountBlue > this.getWarehouse().getNumberOfResource(costOfCard.getCostColor()) + this.getStrongbox().CountResources(costOfCard.getCostColor())){
                    return false;
                }
            }
            else if (costOfCard.getCostColor() == MarketMarble.ColorMarble.PURPLE){
                if (costOfCard.getCostNumber() - DiscountPurple > this.getWarehouse().getNumberOfResource(costOfCard.getCostColor()) + this.getStrongbox().CountResources(costOfCard.getCostColor())){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean CheckResourcesForProudce(ArrayList<CostOfCard> cost) {
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

    public void setProductionsAvaible(int slot){
        productionsAvaible.set(slot, this.slotsBoard.getSlots().get(slot).getTopCard().getProduction());
    }
    public void newProductionFromLeaderCard(Production production){
        productionsAvaible.add(production);
    }
    public void setDiscountGrey(int discountGrey) {
        DiscountGrey += discountGrey;
    }

    public void setDiscountYellow(int discountYellow) {
        DiscountYellow += discountYellow;
    }

    public void setDiscountBlue(int discountBlue) {
        DiscountBlue += discountBlue;
    }

    public void setDiscountPurple(int discountPurple) {
        DiscountPurple += discountPurple;
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









