package it.polimi.ingsw.Model;

import it.polimi.ingsw.Model.Marble.MarketMarble;
import it.polimi.ingsw.Observer.ModelObservable;

import java.util.ArrayList;

public class Model extends ModelObservable {

    // Class that represents the Model

    private ArrayList<Player> players;
    private MarketTray marketTray;
    private DevelopmentGrid developmentGrid;
    private MarkerStack markers ;
    private Deck deck = new Deck();
    private boolean IsSinglePlayerGame = false;
    private boolean start;
    private int contForStart;
    private Player CurrentPlayer;
    private int a;
    public Model(ArrayList<Player> players) {
        this.developmentGrid = new DevelopmentGrid(deck);
        this.marketTray = new MarketTray();
        this.players = players;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public MarketTray getMarketTray() {
        return marketTray;
    }

    public DevelopmentGrid getDevelopmentGrid() {
        return developmentGrid;
    }

    public int getNumberOfPlayers() {
        if (players!=null)
        return players.size();
        else
            return 0;
    } // numero di giocatori


    public void AssignFourLeaderCards(int PlayerIndex){
        Player currentplayer = players.get(PlayerIndex);
        System.out.println("Asssegna 4leader nel game");
        currentplayer.AssignFourLeaderCard(deck.getTopFourLeaderCard());
        System.out.println(currentplayer.getLeaderCards().size());
        notifyFourLeaderCards(PlayerIndex, currentplayer.getLeaderCards(), developmentGrid, marketTray, currentplayer.getNickname());

    }

    public void DiscardInitialLeaderCards(int PlayerIndex, int LeaderCard1Index, int LeaderCard2Index){
        Player currentplayer = players.get(PlayerIndex);
        currentplayer.DiscardLeaderCard(LeaderCard1Index);
        currentplayer.DiscardLeaderCard(LeaderCard2Index);
        notifyLeaderCardsAfterFirstDiscard(PlayerIndex,currentplayer.getLeaderCards());
    }
    public void SetInitialResourcesForFirstPlayer() {
        Player currentplayer = players.get(0);
        incrementContForStart();
        notifyInitialResourcesSet(0, start, currentplayer.getWarehouse(),0);
    }
    public void SetInitialResourcesForSecondPlayer(MarketMarble.ColorMarble colorMarble, int row) {
        Player currentplayer = players.get(1);
        currentplayer.getWarehouse().addToRow(new MarketMarble(colorMarble), row);
        incrementContForStart();
        notifyInitialResourcesSet(1, start, currentplayer.getWarehouse(),0);
    }
    public void SetInitialResourcesForThirdPlayer(MarketMarble.ColorMarble colorMarble, int row) {
        Player currentplayer = players.get(2);
        currentplayer.getWarehouse().addToRow(new MarketMarble(colorMarble), row);
        currentplayer.getFaithTrack().setRedPosition(1);
        incrementContForStart();
        notifyInitialResourcesSet(2, start, currentplayer.getWarehouse(), 1);
    }
    public void SetInitialResourcesForForthPlayer(MarketMarble.ColorMarble colorMarble1, int row1,MarketMarble.ColorMarble colorMarble2, int row2 ) {
        Player currentplayer = players.get(3);
        incrementContForStart();
        if (row1 == row2 && (!colorMarble1.equals(colorMarble2) || row1 == 0)){
            //NotifyErrorMessage
        }
        else if (row1 != row2 && colorMarble1.equals(colorMarble2)){
            //NotifyErrorMessage
        }
        else {
            currentplayer.getWarehouse().addToRow(new MarketMarble(colorMarble1), row1);
            currentplayer.getWarehouse().addToRow(new MarketMarble(colorMarble2), row2);
            currentplayer.getFaithTrack().setRedPosition(1);
            notifyInitialResourcesSet(3, start, currentplayer.getWarehouse(),1);
        }
    }
    public void MarketTrayAction(int PlayerIndex, boolean isRow, int index){
        ArrayList<MarketMarble> returnedMarbles = new ArrayList<>();
        if (isRow) {
            if (index >= 0 && index < 3){
                returnedMarbles = marketTray.ShiftMatrixByRow(index);
            }
            else {
                //NotifyErrorMessage
            }
        } else {
            if (index >= 0 && index < 4){
                returnedMarbles = marketTray.ShiftMatrixByCol(index);
            }
            else {
                //NotifyErrorMessage
            }
        }
        notifyMarketTrayActionResponse(PlayerIndex,marketTray,returnedMarbles);
    }
    public void DealWithAResource(int PlayerIndex,  boolean keepResource, MarketMarble.ColorMarble marble, int rowOfWarehouse){
        Player currentPlayer = players.get(PlayerIndex);
        if (keepResource){
            if (currentPlayer.getWarehouse().addToRow(new MarketMarble(marble), rowOfWarehouse)){
                notifyNewWarehouse(PlayerIndex, currentPlayer.getWarehouse());
            }
            else {
                for (Player otherplayer : players) {
                    if (!otherplayer.equals(currentPlayer)){
                        otherplayer.getFaithTrack().setRedPosition(1);
                    }
                }
                //NotifyInvalidAdd, OtherPlayers Advance by one
            }
        }
        else {
            for (Player otherplayer : players) {
                if (!otherplayer.equals(currentPlayer)){
                    otherplayer.getFaithTrack().setRedPosition(1);
                }
            }
            //NotifyPlayersAdvanced by one
        }
    }
    public void WantToBuyCard(int PlayerIndex, int row, int col, int slot){
        if (developmentGrid.getSingleCell(row,col)!= null && row>=0 && row <=2 && col>=0 && col <= 3 && developmentGrid.getSingleCell(row,col).getTopCard()!= null){
            ArrayList<CostOfCard> cost = developmentGrid.getSingleCell(row, col).getTopCard().getCost();
            if (slot < 0 || slot > 3 || !players.get(PlayerIndex).getSlotsBoard().getSlots().get(slot).CanBeAddedInTheSlot(developmentGrid.getSingleCell(row,col).getTopCard())){
                //NotifyCan'tBeAddedIntThatSlot
            }
            else {
                if (players.get(PlayerIndex).CheckResourcesForAcquisition(cost)) {
                    notifyTextMessage(PlayerIndex, "Card available and purchasable");
                } else {
                    //NotifyDoesn't have resources to buyCard
                }
            }
        }
        else{
            //Notify Card Doesn't Exist
        }
    }
    public void BuyCard(int PlayerIndex, ArrayList<CostOfCard> resourcesFromStrogbox, ArrayList<CostOfCard> resourcesFromWarehouse, ArrayList<Integer> rows, int row, int col, int slot ) {
        int contRow = 0;
        boolean notEnoughResources = false;
        Player currentPlayer = players.get(PlayerIndex);
        for (CostOfCard resourceFromStrongbox : resourcesFromStrogbox) {
            if (currentPlayer.getStrongbox().CountResources(resourceFromStrongbox.getCostColor()) < resourceFromStrongbox.getCostNumber()) {
                notEnoughResources = true;
            }
        }
        if (notEnoughResources) {
            //NotifyNotEnoughResourcesFromStrongbox
        } else {
            for (CostOfCard resourceFromWarehouse : resourcesFromWarehouse) {
                if (currentPlayer.getWarehouse().CheckRow(rows.get(contRow), resourceFromWarehouse.getCostNumber(), resourceFromWarehouse.getCostColor())) {
                    notEnoughResources = true;
                }
                contRow++;
            }
            if (notEnoughResources) {
                //NotifyNotEnoughResourcesFromRowsSelected
            }
        }
        if (!notEnoughResources) {
            contRow = 0;
            for (CostOfCard resourceFromStrongbox2 : resourcesFromStrogbox) {
                currentPlayer.getStrongbox().RemoveResourcesFromStrongbox(resourceFromStrongbox2.getCostNumber(), resourceFromStrongbox2.getCostColor());
            }
            for (CostOfCard resourceFromWarehouse2 : resourcesFromWarehouse) {
                currentPlayer.getWarehouse().getRow(contRow).removeMarble(resourceFromWarehouse2.getCostColor(), resourceFromWarehouse2.getCostNumber());
                contRow++;
            }
            DevelopmentCard card = developmentGrid.remove(row, col);
            currentPlayer.buyCard(card,slot);
            notifyCardBuyedResponse(PlayerIndex, currentPlayer.getWarehouse(), currentPlayer.getStrongbox(), currentPlayer.getSlotsBoard(),currentPlayer.getProductionsAvailable(), col, row);

            //NotifyNewStrongboxNewWarehouseNewDevelopmentGridNewSlotsBoardNewProductionsAvailable
        }
    }
    public void DiscardLeaderCardAction(int PlayerIndex, int NCard) {
        Player currentplayer = players.get(PlayerIndex);
        if (currentplayer.getLeaderCard(NCard) != null && !currentplayer.getLeaderCard(NCard).isActivate()) {
            currentplayer.DiscardLeaderCard(NCard);
            for (Player otherplayer : players) {
                if (!otherplayer.equals(currentplayer)){
                    otherplayer.getFaithTrack().setRedPosition(1);
                }
            }
            //Notify LeaderCardsAndFaithTracks
        }
        else{
            //Notify Can't DiscardThisLeaderCard
        }
    }

    public void ActivateLeaderCardAction(int PlayerIndex, int NCard){
        Player currentplayer = players.get(PlayerIndex);
        if (currentplayer.getLeaderCard(NCard) != null && !currentplayer.getLeaderCard(NCard).isActivate()){
            if (currentplayer.getLeaderCard(NCard).canBeActivated(currentplayer)){
                currentplayer.getLeaderCard(NCard).setActivate(true);
                currentplayer.getLeaderCard(NCard).effect(currentplayer);
                //Notify
            }
            else {
                //NotifyCan'tBeActivated
            }
        }

    }


    public void MoveResources(int PlayerIndex, int row1, int row2) {
        Player currentplayer = players.get(PlayerIndex);
        if (currentplayer.getWarehouse().MoveResource(row1, row2)) {
            notifyNewWarehouse(PlayerIndex, currentplayer.getWarehouse());
        } else {
            //NotifyNotValidMove
        }
    }
    public void CanProduce(int PlayerIndex, ArrayList<Integer> productionsIndexes, ArrayList<CostOfCard> productionBasicCost){
        Player currentplayer = players.get(PlayerIndex);
        boolean allProductionAvailable = true;
        int[] resources = new int[4]; // 0 Blue, 1 Grey, 2 Purple, 3 Yellow
        resources[0] = 0;
        resources[1] = 0;
        resources[2] = 0;
        resources[3] = 0;
        for (int index : productionsIndexes){
            if(index > 5 || !currentplayer.ProductionIsAvailable(index) ){
                allProductionAvailable = false;
            }
        }
        if (!allProductionAvailable){
            //NotifyLeProduzioniCheHaiSelezionatoNonSonoTutteDisponibili
        }else {

            for (int index : productionsIndexes){
                if (index == 0) {
                    switch (productionBasicCost.get(0).getCostColor()) {
                        case BLUE:
                            resources[0]++;
                        case GREY:
                            resources[1]++;
                        case PURPLE:
                            resources[2]++;
                        case YELLOW:
                            resources[3]++;
                    }
                    switch (productionBasicCost.get(1).getCostColor()) {
                        case BLUE:
                            resources[0]++;
                        case GREY:
                            resources[1]++;
                        case PURPLE:
                            resources[2]++;
                        case YELLOW:
                            resources[3]++;
                    }
                }
                else{
                    for (CostOfCard c: currentplayer.getProductionsAvailable().get(index).getProductionCost()){
                        switch (c.getCostColor()){
                            case BLUE:
                                resources[0]+= c.getCostNumber();
                            case GREY:
                                resources[1]+= c.getCostNumber();
                            case PURPLE:
                                resources[2]+= c.getCostNumber();
                            case YELLOW:
                                resources[3]+= c.getCostNumber();
                        }
                    }
                }
            }
            if(currentplayer.CheckResourcesForProduce(resources)){
                notifyTextMessage(PlayerIndex, "You can produce everything that you selected ");
                //NotifyCanProduceEverything
            }
            else {
                //NotifyYouDon'tHaveEnoughResources
            }
        }
    }
    public void Produce(int PlayerIndex, ArrayList<CostOfCard> ResourcesFromStrongbox,ArrayList<CostOfCard> ResourcesFromWarehouse, ArrayList<Integer>rows, boolean lastproduction){
        Player currentplayer = players.get(PlayerIndex);
        int contRow = 0;
        for (CostOfCard c : ResourcesFromStrongbox) {
            currentplayer.getStrongbox().RemoveResourcesFromStrongbox(c.getCostNumber(), c.getCostColor());
        }
        for (CostOfCard resourceFromWarehouse : ResourcesFromWarehouse) {
            currentplayer.getWarehouse().getRow(rows.get(contRow)).removeMarble(resourceFromWarehouse.getCostColor(), resourceFromWarehouse.getCostNumber());
            contRow++;
        }
        if (lastproduction){
            notifyProductionResponse(PlayerIndex, currentplayer.getWarehouse(), currentplayer.getStrongbox(), currentplayer.getFaithTrack());
        }
    }
    public void EndTurn(int PlayerIndex){
        int IndexNewTurn = 0;
        players.get(PlayerIndex).setYourTurn(false);
        if (PlayerIndex!= players.size()-1) {
            players.get(PlayerIndex + 1).setYourTurn(true);
            IndexNewTurn = PlayerIndex + 1;
        }
        else {
            IndexNewTurn = 0;
            players.get(0).setYourTurn(true);
        }
        notifyNewTurn(IndexNewTurn);
    }


    public Player GetWinner() {
        int MaxPoints = 0;
        int MaxResources = 0;
        Player winner = null;
        ArrayList<Player> PlayersWithMorePoints = new ArrayList<>();
        for (Player player : players) {
            if (player.GetTotalPoints() > MaxPoints) {
                for (int i = 0; i < PlayersWithMorePoints.size(); i++) {
                    PlayersWithMorePoints.remove(PlayersWithMorePoints.size() - 1);
                }
                PlayersWithMorePoints.add(player);
            } else if (player.GetTotalPoints() == MaxPoints) {
                PlayersWithMorePoints.add(player);
            }
        }
        for (Player player : PlayersWithMorePoints) {
            if (player.getWarehouse().getNumberOfTotalResourcesInWarehouse() + player.getStrongbox().getNumberOfTotalResourcesInStrongbox() > MaxResources) {
                winner = player;
                MaxResources = player.getWarehouse().getNumberOfTotalResourcesInWarehouse() + player.getStrongbox().getNumberOfTotalResourcesInStrongbox();
            }
        }
        return winner;
    }

    public Deck getDeck() {
        return deck;
    }

    public void incrementContForStart() {
        this.contForStart ++;
        if(contForStart==players.size())
            start=true;
    }
    /*
    public int GetA() {
        return a;
    }
    public void setA(int a) throws IOException {
        this.a=a;
        List<Integer> interi =new ArrayList<>();
        interi.add(5);
        interi.add(324);
        notifyTest(new Message("abc",interi));
    } */
}





 /*   public void startgame(){
        //Creazione di Development grid
        //Assegnazione di Leader Card a ogni player
        // settaggio di tutte le cose iniziali come creazione di ogni faithTrack/Warehouse ecc per ogni player


    }
    public void finishgame(){
        // Ricordarsi di fare i controlli nelle classi che posso far finire la partita esempio nella classed Faith Track controllare Red Position ecc
        // fai i calcoli per finire la partita



    }

}
  */
