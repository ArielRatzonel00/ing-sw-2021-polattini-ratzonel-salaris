package it.polimi.ingsw.Model;


import it.polimi.ingsw.Model.LeaderCard.LeaderCard;
import it.polimi.ingsw.Model.Marble.MarketMarble;

import java.io.Serializable;
import java.util.ArrayList;

// Class that represents the Player

public class Player implements Serializable {
    private String nickname;
    private int index;
    private FaithTrack faithTrack;
    private Warehouse warehouse;
    private Strongbox strongbox;
    private ArrayList<LeaderCard> leaderCards = new ArrayList<>();
    private SlotsBoard slotsBoard;
    private boolean IsYourTurn = false;
    private boolean isFirst;
    private int DiscountGrey = 0;
    private int DiscountYellow = 0;
    private int DiscountPurple = 0;
    private int DiscountBlue = 0;
    private int TotalPoints = 0;
    private boolean SinglePlayer = false;
    private ArrayList<Production> productionsAvailable = new ArrayList<>(4);
    private ArrayList<CostOfCard> ProductionBasicCost = new ArrayList<>();
    private ArrayList<CostOfCard> ProductionBasicProfit = new ArrayList<>();
    private Production BasicProduction = new Production(ProductionBasicCost, ProductionBasicProfit);
    private MarketMarble.ColorMarble ChangeWhite1;
    private MarketMarble.ColorMarble ChangeWhite2;
    public Player(String nickname) {
        this.nickname = nickname;
        this.warehouse = new Warehouse();
        this.strongbox = new Strongbox();
        this.faithTrack = new FaithTrack();
        //this.leaderCards = FourLeaderCards;
        this.slotsBoard = new SlotsBoard();
        this.isFirst = false;
        ProductionBasicCost.add(0, new CostOfCard(2, MarketMarble.ColorMarble.UNKNOWN));
        ProductionBasicProfit.add(0, new CostOfCard(1, MarketMarble.ColorMarble.UNKNOWN));
        BasicProduction.setProductionCost(ProductionBasicCost);
        BasicProduction.setProductionProfit(ProductionBasicProfit);
        this.productionsAvailable.add(BasicProduction);
        this.productionsAvailable.add(BasicProduction);
        this.productionsAvailable.add(BasicProduction);
        this.productionsAvailable.add(BasicProduction);
        this.ChangeWhite1 = MarketMarble.ColorMarble.WHITE;
        this.ChangeWhite2 = MarketMarble.ColorMarble.WHITE;
    }

    public void AssignFourLeaderCard(ArrayList<LeaderCard> FourLeaderCards){
        this.leaderCards = FourLeaderCards;
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

    public LeaderCard getLeaderCard(int num) {
        return leaderCards.get(num);
    }

    public ArrayList<LeaderCard> getLeaderCards() {
        return leaderCards;
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

    public boolean CheckResourcesForProduce(int[] cost) {
        if (cost[0] > this.getWarehouse().getNumberOfResource(MarketMarble.ColorMarble.BLUE) + this.getStrongbox().CountResources(MarketMarble.ColorMarble.BLUE)){
            return false;
        }
        if (cost[1] > this.getWarehouse().getNumberOfResource(MarketMarble.ColorMarble.GREY) + this.getStrongbox().CountResources(MarketMarble.ColorMarble.GREY)){
            return false;
        }
        if (cost[2] > this.getWarehouse().getNumberOfResource(MarketMarble.ColorMarble.PURPLE) + this.getStrongbox().CountResources(MarketMarble.ColorMarble.PURPLE)){
            return false;
        }
        if (cost[3] > this.getWarehouse().getNumberOfResource(MarketMarble.ColorMarble.YELLOW) + this.getStrongbox().CountResources(MarketMarble.ColorMarble.YELLOW)){
            return false;
        }
        return true;
    }

    public void DiscardLeaderCard(int index){
        leaderCards.remove(index);
    }

    public void CheckPositionPopeFavor(int PopeFavor){
        if (PopeFavor == 1){
            if (faithTrack.getRedPosition() >=5 ){
                faithTrack.setPopeFavor1(PopeFavorState.Activate);
                faithTrack.setPoints(2);
            }
            else {
                faithTrack.setPopeFavor1(PopeFavorState.Deleted);
            }
        }
        else if (PopeFavor == 2){
            if (faithTrack.getRedPosition() >= 12){
                faithTrack.setPopeFavor2(PopeFavorState.Activate);
                faithTrack.setPoints(3);
            }
            else {
                faithTrack.setPopeFavor1(PopeFavorState.Deleted);
            }
        }
        else {
            if (faithTrack.getRedPosition() >= 19){
                faithTrack.setPopeFavor3(PopeFavorState.Activate);
                faithTrack.setPoints(4);
            }
            else {
                faithTrack.setPopeFavor3(PopeFavorState.Deleted);
            }
        }
    }

    public void setProductionsAvailable(int slot){
        productionsAvailable.set(slot+1, this.slotsBoard.getSlots().get(slot).getTopCard().getProduction());
    }

    public boolean ProductionIsAvailable(int index){
        if ((index == 4 && productionsAvailable.size()<4) || (index == 5 && productionsAvailable.size()<5 )){
            return false;
        }
        else if(index != 0 && productionsAvailable.get(index).equals(BasicProduction)){
            return false;
        }
        else {
            return true;
        }
    }

    public void buyCard(DevelopmentCard card, int slot){
        slotsBoard.getSlots().get(slot).addCard(card);
    }

    public void newProductionFromLeaderCard(Production production){
        productionsAvailable.add(production);
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

    public boolean isFirst() {
        return isFirst;
    }

    public int PointsFromLeaderCard(){
        int PointsFromLeaderCard = 0;
        for (LeaderCard leaderCard : leaderCards){
            if (leaderCard.isActivate()) {
                PointsFromLeaderCard += leaderCard.getVictoryPoints();
            }
        }
        return PointsFromLeaderCard;
    }

    public int PointsFromWarehouseAndStrongbox(){
        int Points;
        int Resources = warehouse.getNumberOfTotalResourcesInWarehouse() + strongbox.getNumberOfTotalResourcesInStrongbox();
        Points = Resources / 5;
        return Points;
    }

    public int GetTotalPoints(){
        TotalPoints = slotsBoard.countVictoryPoints() + faithTrack.TotalPoints() + faithTrack.getPoints() + PointsFromLeaderCard() + PointsFromWarehouseAndStrongbox();
        return TotalPoints;
    }

    public ArrayList<Production> getProductionsAvailable() {
        return productionsAvailable;
    }

    public int getIndex() {
        return index;
    }

    public boolean isSinglePlayer() {
        return SinglePlayer;
    }

    public void setSinglePlayer(boolean singlePlayer) {
        SinglePlayer = singlePlayer;
    }

    public boolean isYourTurn() {
        return IsYourTurn;
    }

    public void setYourTurn(boolean yourTurn) {
        IsYourTurn = yourTurn;
    }

    @Override
    public String toString() {
        return nickname;
    }

    public MarketMarble.ColorMarble getChangeWhite1() {
        return ChangeWhite1;
    }

    public void setChangeWhite1(MarketMarble.ColorMarble changeWhite1) {
        ChangeWhite1 = changeWhite1;
    }

    public MarketMarble.ColorMarble getChangeWhite2() {
        return ChangeWhite2;
    }

    public void setChangeWhite2(MarketMarble.ColorMarble changeWhite2) {
        ChangeWhite2 = changeWhite2;
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









