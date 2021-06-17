package it.polimi.ingsw.Network.Client;

import it.polimi.ingsw.Model.*;
import it.polimi.ingsw.Model.LeaderCard.LeaderCard;
import it.polimi.ingsw.Model.Marble.MarketMarble;
import it.polimi.ingsw.Network.Client.CModel.ClientModel;
import it.polimi.ingsw.Network.Client.CModel.PlayerBoard;
import it.polimi.ingsw.Network.Messages.*;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Client extends Messanger {

    private String ip;
    private String nickname;
    private int port;
    private int ID;
    private Socket socket;
    Scanner stdin = new Scanner(System.in);
    private ObjectOutputStream socketOut;
    private ObjectInputStream socketIn;
    private UserInterface userInterface;
    private boolean active = true;
    private ClientModel clientModel = new ClientModel();
    private boolean actionDone = false;
    private int leaderCardActionAvailable = 2;
    private boolean isSinglePlayer = false;
    public Client(String ip, int port, UserInterface userInterface) {
        this.ip = ip;
        this.port = port;
        this.userInterface=userInterface;
    }

    public ClientModel getClientModel() {
        return clientModel;
    }

    public synchronized boolean isActive() {
        return active;
    }
    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public void setSocketOut(ObjectOutputStream socketOut) {
        this.socketOut = socketOut;
    }

    public void setSocketIn(ObjectInputStream socketIn) {
        this.socketIn = socketIn;
    }

    public boolean isSinglePlayer() {
        return isSinglePlayer;
    }

    public void setSinglePlayer(boolean singlePlayer) {
        isSinglePlayer = singlePlayer;
    }

    public synchronized void setActive(boolean active) {
        this.active = active;
    }

    public synchronized void receiveMessage(SocketMessage message) throws IOException {
        //System.out.println("messaggio ricevuto: " + message.getID() + "destinato a: "+ message.getReceiver());
        if(message.getReceiver()==null || message.getReceiver().contains(this.nickname)){
            switch (message.getID()){
                case "nicknameResponse":
                    if(message.getValue()==0){
                        userInterface.PrintMessages("Nickname already in use, choose again...");
                        this.nickname = userInterface.askNickname(stdin);
                        sendMessage(this.socketOut,new SocketMessage("nickname",0,null,this.nickname));
                    }
                    else {
                        boolean multiplayer = false;
                        multiplayer = userInterface.askMultiplayer(stdin);
                        if(multiplayer){
                            userInterface.PrintMessages("Waiting ...\n");

                            sendMessage(this.socketOut,new SocketMessage("newMulti",1,null,nickname));

                        }
                        else {
                            sendMessage(this.socketOut, new SocketMessage("newMulti", 0, null, nickname));
                        }
                    }
                    break;
                case "connected":
                    this.nickname = userInterface.askNickname(stdin);
                    sendMessage(this.socketOut,new SocketMessage("nickname",0,null,this.nickname));
                    break;
                case "numberOfPlayers":
                    int numberOfPlayers = 0;
                    numberOfPlayers = userInterface.askNumberOfPlayers(stdin);
                    userInterface.waitingForOtherPlayers(stdin);
                    sendMessage(this.socketOut,new SocketMessage("numberOfPlayersReply",numberOfPlayers,null,this.nickname));

                    break;
                case "waiting":
                    userInterface.Waiting(stdin);
                    break;
                case "GameStarted":
                    ID=message.getValue();
                    userInterface.GameStarted(stdin);
                    sendMessage(socketOut, new SocketMessage("Fine",0, null, null));
                    FourLeaderCardsMessage fourLeaderCardsMessage = userInterface.FourLeaderCards(stdin);
                    fourLeaderCardsMessage.setPlayerIndex(ID);
                    sendMessage(this.socketOut, fourLeaderCardsMessage);

                    break;
                default:
                    break;
            }
        }
    }
    public synchronized void receiveMessageFromServer(Message message) throws IOException {
        //if(message.getPlayerIndex()==null || message.getPlayerIndex().contains(this.nickname)){
            switch (message.getTypeOfMessage()) {
                case ("FourLeaderCardResponse"):
                    FourLeaderCardResponse fourLeaderCardResponse = (FourLeaderCardResponse) message;

                    clientModel.getPlayerBoards().get(fourLeaderCardResponse.getPlayerIndex()).setNickname(fourLeaderCardResponse.getNickname());
                    clientModel.getPlayerBoards().get(fourLeaderCardResponse.getPlayerIndex()).setLeaderCards(fourLeaderCardResponse.getLeaderCards());

                    if (message.getPlayerIndex() == ID) {
                        if (fourLeaderCardResponse.isSinglePlayer()){
                            setSinglePlayer(true);
                            clientModel.getPlayerBoards().get(ID).setTopMarker(fourLeaderCardResponse.getMarkers().get(fourLeaderCardResponse.getMarkers().size()-1));
                        }
                        clientModel.getMarketTrayClient().setMarketMatrix(((fourLeaderCardResponse).getMarketTray().getMarketMatrix()));
                        clientModel.getMarketTrayClient().setOustideMarble(((fourLeaderCardResponse).getMarketTray().getOustideMarble()));
                        clientModel.setDevGrid(((fourLeaderCardResponse.getTopCards())));

                        int a = 0;
                        int b = 0;
                        int cont = 0;
                        DiscardInitialLeaderCardsMessage discardInitial = new DiscardInitialLeaderCardsMessage();
                        discardInitial.setPlayerIndex(ID);
                        userInterface.DiscardInitialLeaderCards(stdin, clientModel.getPlayerBoards().get(ID).getLeaderCards(), discardInitial);
                        sendMessage(socketOut, discardInitial);
                        break;
                    } else
                        break;

                case ("Two leader card response"):
                    TwoLeaderCardsResponse twoLeaderCardsResponse = (TwoLeaderCardsResponse) message;
                    clientModel.getPlayerBoards().get(message.getPlayerIndex()).setLeaderCards(twoLeaderCardsResponse.getLeaderCards());
                    clientModel.getPlayerBoards().get(message.getPlayerIndex()).setProductions(twoLeaderCardsResponse.getProductions());
                    if (message.getPlayerIndex() == ID) {
                        InitialResourcesMessage message1 = new InitialResourcesMessage();
                        message1.setPlayerIndex(ID);
                        userInterface.InitialResources(stdin, ID, message1);
                        sendMessage(socketOut, message1);
                        break;
                    } else
                        break;
                case ("initialResourcesSet"):
                    InitialResourcesSet initialResourcesSet = (InitialResourcesSet) message;
                    clientModel.getPlayerBoards().get(initialResourcesSet.getPlayerIndex()).getFaithTrackClient().setRedPosition(initialResourcesSet.getPosition());
                    clientModel.getPlayerBoards().get(initialResourcesSet.getPlayerIndex()).getWarehosueClient().setWarehouseRows(initialResourcesSet.getWarehouse().getRows());
                    boolean start = initialResourcesSet.getStart();
                    if (start) {
                        if (ID == 0) {
                            int i = userInterface.Menù(stdin,actionDone, leaderCardActionAvailable, isSinglePlayer);
                            ChoiceOfTheMenu(i);
                            //MenuCli();
                        } else {
                            userInterface.PrintMessages("The game is started, it isn't your turn now");
                        }
                    }
                    break;
                case "MarketTrayActionResponse":
                    MarketTrayActionResponse marketTrayActionResponse = (MarketTrayActionResponse) message;
                    MarketMarble.ColorMarble colorMarble;
                    DealWithResourcesFromMarketTrayMessage dealWithResourcesFromMarketTrayMessage = new DealWithResourcesFromMarketTrayMessage();
                    dealWithResourcesFromMarketTrayMessage.setPlayerIndex(ID);
                    clientModel.getMarketTrayClient().setMarketMatrix(marketTrayActionResponse.getMarketTray());
                    clientModel.getMarketTrayClient().setOustideMarble(marketTrayActionResponse.getOutsideMarble());
                    if (marketTrayActionResponse.getPlayerIndex() == ID) {
                        userInterface.DealWithResourcesFromMarketTray(stdin, marketTrayActionResponse,dealWithResourcesFromMarketTrayMessage, ID);
                        sendMessage(socketOut, dealWithResourcesFromMarketTrayMessage);
                    }

                    break;

                case "DealWithResourcesFromMarketTrayResponse":
                    int indexPopeFavor = 0;
                    DealWithResourcesFromMarketTrayResponse dealWithResourcesFromMarketTrayResponse = (DealWithResourcesFromMarketTrayResponse) message;
                    clientModel.getPlayerBoards().get(dealWithResourcesFromMarketTrayResponse.getPlayerIndex()).getFaithTrackClient().setRedPosition(dealWithResourcesFromMarketTrayResponse.getCurrPlayersAdvances());
                    clientModel.getPlayerBoards().get(dealWithResourcesFromMarketTrayResponse.getPlayerIndex()).getWarehosueClient().setWarehouseRows(dealWithResourcesFromMarketTrayResponse.getWarehouse().getRows());
                    if (dealWithResourcesFromMarketTrayResponse.isPopeFavoreEvent()) {
                        userInterface.PopeFavorStateEventOccured(stdin);
                        for (PlayerBoard p : clientModel.getPlayerBoards()){
                            p.getFaithTrackClient().setPopeFavors(dealWithResourcesFromMarketTrayResponse.getPopeFavorStates().get(0), indexPopeFavor);
                            indexPopeFavor++;
                            p.getFaithTrackClient().setPopeFavors(dealWithResourcesFromMarketTrayResponse.getPopeFavorStates().get(1), indexPopeFavor);
                            indexPopeFavor++;
                            p.getFaithTrackClient().setPopeFavors(dealWithResourcesFromMarketTrayResponse.getPopeFavorStates().get(2), indexPopeFavor);
                            indexPopeFavor++;
                        }
                    }
                    if (!isSinglePlayer) {
                        for (PlayerBoard p : clientModel.getPlayerBoards()) {
                            if (p.getNickname() != null && !p.getNickname().equals(clientModel.getPlayerBoards().get(dealWithResourcesFromMarketTrayResponse.getPlayerIndex()).getNickname())) {
                                p.getFaithTrackClient().setRedPosition(dealWithResourcesFromMarketTrayResponse.getOtherPlayersAdvances());
                            }
                        }
                        if (dealWithResourcesFromMarketTrayResponse.getPlayerIndex() == ID) {
                            userInterface.DealWithResFromMarkTrayResponse(stdin, dealWithResourcesFromMarketTrayResponse, isSinglePlayer);
                            actionDone = true;
                            int i = userInterface.Menù(stdin,actionDone, leaderCardActionAvailable, isSinglePlayer);
                            ChoiceOfTheMenu(i);
                        }
                    }
                    else {
                        clientModel.getPlayerBoards().get(dealWithResourcesFromMarketTrayResponse.getPlayerIndex()).getFaithTrackClient().setBlackPosition(dealWithResourcesFromMarketTrayResponse.getOtherPlayersAdvances());
                        if (dealWithResourcesFromMarketTrayResponse.getPlayerIndex() == ID) {
                            userInterface.DealWithResFromMarkTrayResponse(stdin,dealWithResourcesFromMarketTrayResponse,isSinglePlayer);
                            actionDone = true;
                            int i = userInterface.Menù(stdin,actionDone, leaderCardActionAvailable, isSinglePlayer);
                            ChoiceOfTheMenu(i);
                        }
                    }
                    break;
                case "WantToBuyCardResponse":
                    ArrayList<CostOfCard> resourcesFromStrongbox = new ArrayList<>();
                    ArrayList<CostOfCard> resourcesFromWarehouse = new ArrayList<>();
                    ArrayList<Integer> warehouseRows = new ArrayList<>();
                    WantToBuyCardResponse wantToBuyCardResponse = (WantToBuyCardResponse) message;
                    if (wantToBuyCardResponse.getPlayerIndex() == ID) {
                        userInterface.WantToBuyCardResponse(stdin, wantToBuyCardResponse, ID);
                        switch (wantToBuyCardResponse.getPhrasetoShow()) {
                            case "The card can't be added in the slot that you selected", "The card selected doesn't exist", "You don't have enough resources to buy this card":
                                userInterface.PrintMessages(wantToBuyCardResponse.getPhrasetoShow());
                                int i = userInterface.Menù(stdin,actionDone,leaderCardActionAvailable, isSinglePlayer);
                                ChoiceOfTheMenu(i);
                                break;
                            case "You have the resources to add the card and you can add it in the slot that you selected":
                                BuyCardMessage buyCardMessage = new BuyCardMessage();
                                buyCardMessage.setPlayerIndex(ID);

                                userInterface.WantToBuyCardResponse(stdin, wantToBuyCardResponse, ID);
                                userInterface.Payment(stdin, wantToBuyCardResponse.getCost(),resourcesFromStrongbox,resourcesFromWarehouse,warehouseRows,ID);
                                buyCardMessage.setResourcesFromWarehouse(resourcesFromWarehouse);
                                buyCardMessage.setResourcesFromStrongbox(resourcesFromStrongbox);
                                buyCardMessage.setPlayerIndex(ID);
                                buyCardMessage.setRows(warehouseRows);
                                buyCardMessage.setCellrow(wantToBuyCardResponse.getCellRow());
                                buyCardMessage.setCellcol(wantToBuyCardResponse.getCellCol());
                                buyCardMessage.setSlot(wantToBuyCardResponse.getSlot());
                                sendMessage(socketOut,buyCardMessage);
                                break;
                        }
                    }
                    break;
                case "MoveResourcesResponse":
                    MoveResourcesResponse moveResourcesResponse = (MoveResourcesResponse) message;
                    if (moveResourcesResponse.isOk()) {
                        clientModel.getPlayerBoards().get(moveResourcesResponse.getPlayerIndex()).getWarehosueClient().setWarehouseRows(moveResourcesResponse.getNewwarehouse());
                        if (moveResourcesResponse.getPlayerIndex() == ID) {
                            userInterface.newWarehosue(stdin, ID);
                            int i = userInterface.Menù(stdin, actionDone, leaderCardActionAvailable, isSinglePlayer);
                            ChoiceOfTheMenu(i);
                        }
                    } else {
                        if (moveResourcesResponse.getPlayerIndex() == ID) {
                            userInterface.PrintMessages("Can't move the resources selected");
                            int i = userInterface.Menù(stdin, actionDone, leaderCardActionAvailable, isSinglePlayer);
                            ChoiceOfTheMenu(i);

                        }
                    }

                    break;
                case "WantActivateProductionResponse":

                    WantActivateProductionResponse wantActivateProductionResponse = (WantActivateProductionResponse) message;
                    if (wantActivateProductionResponse.getPlayerIndex() == ID) {

                        ProduceMessage produceMessage = new ProduceMessage();
                        produceMessage.setPlayerIndex(ID);
                        if (wantActivateProductionResponse.isOk()) {
                            userInterface.WantToActivateProdResponse(stdin, ID);
                            for (int prod : wantActivateProductionResponse.getProductions()) {
                                userInterface.Produce(stdin, wantActivateProductionResponse, produceMessage, ID, prod);
                            }
                            produceMessage.setProductions(wantActivateProductionResponse.getProductions());
                            produceMessage.setPlayerIndex(ID);
                            sendMessage(socketOut, produceMessage);
                        } else {
                            userInterface.PrintMessages("You don't have enough resources to produce all the productions that you selected");
                            int i = userInterface.Menù(stdin, actionDone, leaderCardActionAvailable, isSinglePlayer);
                            ChoiceOfTheMenu(i);
                        }
                    }
                    break;
                case "EndTurnResponse":
                    int popeFavorIndex = 0;
                    EndTurnResponse endTurnResponse = (EndTurnResponse) message;
                    if (endTurnResponse.getIndexNewTurn() == ID) {
                        if (!isSinglePlayer) {
                            userInterface.PrintMessages("It's your turn!");
                            int i = userInterface.Menù(stdin,actionDone,leaderCardActionAvailable,isSinglePlayer);
                            ChoiceOfTheMenu(i);
                        }
                        else {
                            clientModel.getPlayerBoards().get(ID).setTopMarker(endTurnResponse.getTopMarker());
                            clientModel.setDevGrid(endTurnResponse.getNewDevGrid());
                            clientModel.getPlayerBoards().get(ID).getFaithTrackClient().setBlackPosition(endTurnResponse.getBlackPosition());
                            if (endTurnResponse.isPopeFavorChanged()){
                                userInterface.PrintMessages("a pope favor event has occured!\n");
                                clientModel.getPlayerBoards().get(ID).getFaithTrackClient().setPopeFavors(endTurnResponse.getPopeFavorStates().get(popeFavorIndex), popeFavorIndex);
                                popeFavorIndex++;
                                clientModel.getPlayerBoards().get(ID).getFaithTrackClient().setPopeFavors(endTurnResponse.getPopeFavorStates().get(popeFavorIndex), popeFavorIndex);
                                popeFavorIndex++;
                                clientModel.getPlayerBoards().get(ID).getFaithTrackClient().setPopeFavors(endTurnResponse.getPopeFavorStates().get(popeFavorIndex), popeFavorIndex);
                                popeFavorIndex++;
                            }
                            int i = userInterface.Menù(stdin,actionDone,leaderCardActionAvailable,isSinglePlayer);
                            ChoiceOfTheMenu(i);
                        }
                    } else {
                        userInterface.PrintMessages("Now it's the turn of:" + clientModel.getPlayerBoards().get(endTurnResponse.getIndexNewTurn()).getNickname());
                    }
                    break;
                case "ActivateLeaderCardActionResponse":
                    ActivateLeaderCardActionResponse activateLeaderCardActionResponse = (ActivateLeaderCardActionResponse) message;
                    if (activateLeaderCardActionResponse.isOk()) {
                        clientModel.getPlayerBoards().get(activateLeaderCardActionResponse.getPlayerIndex()).getLeaderCards().get(activateLeaderCardActionResponse.getCardindex()).setActivate(true);
                    }
                    if (activateLeaderCardActionResponse.getPlayerIndex() == ID) {
                        userInterface.PrintMessages(activateLeaderCardActionResponse.getResponse());
                        if (activateLeaderCardActionResponse.isOk()) {
                            leaderCardActionAvailable--;
                        }
                        int i = userInterface.Menù(stdin,actionDone,leaderCardActionAvailable,isSinglePlayer);
                        ChoiceOfTheMenu(i);
                    }
                    break;
                case "DiscardLeaderCardActionResponse":
                    int indexPopeFavorState = 0;
                    DiscardLeaderCardActionResponse discardLeaderCardActionResponse = (DiscardLeaderCardActionResponse) message;
                    if (discardLeaderCardActionResponse.isOk()) {
                        clientModel.getPlayerBoards().get(discardLeaderCardActionResponse.getPlayerIndex()).getLeaderCards().remove(discardLeaderCardActionResponse.getCardIndex());
                        if (discardLeaderCardActionResponse.isPopeFavorStateEvent()) {
                            userInterface.PrintMessages("A pope favor  event has occured!");
                            if (!isSinglePlayer) {
                                for (PlayerBoard p : clientModel.getPlayerBoards()) {
                                    if (p.getNickname() != null) {
                                        p.getFaithTrackClient().setPopeFavors(discardLeaderCardActionResponse.getPopeFavorStates().get(indexPopeFavorState), 0);
                                        indexPopeFavorState++;
                                        p.getFaithTrackClient().setPopeFavors(discardLeaderCardActionResponse.getPopeFavorStates().get(indexPopeFavorState), 1);
                                        indexPopeFavorState++;
                                        p.getFaithTrackClient().setPopeFavors(discardLeaderCardActionResponse.getPopeFavorStates().get(indexPopeFavorState), 2);

                                    }
                                }
                            }
                            else {
                                clientModel.getPlayerBoards().get(0).getFaithTrackClient().setPopeFavors(discardLeaderCardActionResponse.getPopeFavorStates().get(indexPopeFavorState), 0);
                                indexPopeFavorState++;
                                clientModel.getPlayerBoards().get(0).getFaithTrackClient().setPopeFavors(discardLeaderCardActionResponse.getPopeFavorStates().get(indexPopeFavorState), 1);
                                indexPopeFavorState++;
                                clientModel.getPlayerBoards().get(0).getFaithTrackClient().setPopeFavors(discardLeaderCardActionResponse.getPopeFavorStates().get(indexPopeFavorState), 2);

                            }
                        }
                        clientModel.getPlayerBoards().get(discardLeaderCardActionResponse.getPlayerIndex()).getFaithTrackClient().setRedPosition(1);
                    }

                    if (discardLeaderCardActionResponse.getPlayerIndex() == ID) {
                        leaderCardActionAvailable--;
                        userInterface.PrintMessages(discardLeaderCardActionResponse.getResponse());
                        int i = userInterface.Menù(stdin, actionDone, leaderCardActionAvailable, isSinglePlayer);
                        ChoiceOfTheMenu(i);
                    }


                    break;
                case "ProductionResponse":
                    ProductionResponse productionResponse = (ProductionResponse) message;
                    clientModel.getPlayerBoards().get(productionResponse.getPlayerIndex()).getWarehosueClient().setWarehouseRows(productionResponse.getNewwarehouse());
                    clientModel.getPlayerBoards().get(productionResponse.getPlayerIndex()).getFaithTrackClient().setRedPosition(productionResponse.getFaithTrackpositions());
                    indexPopeFavorState = 0;
                    clientModel.getPlayerBoards().get(productionResponse.getPlayerIndex()).setStrongBox(productionResponse.getNewstrongbox());
                    if (productionResponse.isPopeFavoreStateEvent()) {

                        userInterface.PrintMessages("A pope favor state event has occured!");
                        if (!isSinglePlayer) {
                            for (PlayerBoard p : clientModel.getPlayerBoards()) {
                                if (p.getNickname() != null) {
                                    p.getFaithTrackClient().setPopeFavors(productionResponse.getPopeFavorStates().get(indexPopeFavorState), 0);
                                    indexPopeFavorState++;
                                    p.getFaithTrackClient().setPopeFavors(productionResponse.getPopeFavorStates().get(indexPopeFavorState), 1);
                                    indexPopeFavorState++;
                                    p.getFaithTrackClient().setPopeFavors(productionResponse.getPopeFavorStates().get(indexPopeFavorState), 2);
                                    indexPopeFavorState++;
                                }
                            }
                        }
                        else {
                            clientModel.getPlayerBoards().get(0).getFaithTrackClient().setPopeFavors(productionResponse.getPopeFavorStates().get(indexPopeFavorState), 0);
                            indexPopeFavorState++;
                            clientModel.getPlayerBoards().get(0).getFaithTrackClient().setPopeFavors(productionResponse.getPopeFavorStates().get(indexPopeFavorState), 1);
                            indexPopeFavorState++;
                            clientModel.getPlayerBoards().get(0).getFaithTrackClient().setPopeFavors(productionResponse.getPopeFavorStates().get(indexPopeFavorState), 2);
                            indexPopeFavorState++;
                        }
                    }
                    if (productionResponse.getPlayerIndex() == ID) {
                        actionDone = true;
                        int i = userInterface.Menù(stdin, actionDone, leaderCardActionAvailable, isSinglePlayer);
                        ChoiceOfTheMenu(i);
                    }
                    break;

                case "CardBuyedResponse":
                    CardBuyedResponse cardBuyedResponse = (CardBuyedResponse) message;
                    clientModel.setDevGrid(cardBuyedResponse.getNewDevGrid());
                    clientModel.getPlayerBoards().get(cardBuyedResponse.getPlayerIndex()).setStrongBox(cardBuyedResponse.getNewstrongbox());
                    clientModel.getPlayerBoards().get(cardBuyedResponse.getPlayerIndex()).getWarehosueClient().setWarehouseRows(cardBuyedResponse.getNewwarehouse());
                    clientModel.getPlayerBoards().get(cardBuyedResponse.getPlayerIndex()).setProductions(cardBuyedResponse.getNewproductionAvailables());
                    if (clientModel.getPlayerBoards().get(cardBuyedResponse.getPlayerIndex()).getDevSlotClient().size() <= cardBuyedResponse.getSlot()) {
                        clientModel.getPlayerBoards().get(cardBuyedResponse.getPlayerIndex()).getDevSlotClient().add(cardBuyedResponse.getSlot(), cardBuyedResponse.getCard());
                    }
                    else {
                        clientModel.getPlayerBoards().get(cardBuyedResponse.getPlayerIndex()).getDevSlotClient().set(cardBuyedResponse.getSlot(),cardBuyedResponse.getCard());
                    }
                    clientModel.getPlayerBoards().get(cardBuyedResponse.getPlayerIndex()).setTotalCards();
                    switch (cardBuyedResponse.getCard().getLevel()) {
                        case 1 -> clientModel.getPlayerBoards().get(cardBuyedResponse.getPlayerIndex()).setLvl1();
                        case 2 -> clientModel.getPlayerBoards().get(cardBuyedResponse.getPlayerIndex()).setLvl2();
                        case 3 -> clientModel.getPlayerBoards().get(cardBuyedResponse.getPlayerIndex()).setLvl3();
                    }
                    switch (cardBuyedResponse.getCard().getColor()){
                        case Purple -> clientModel.getPlayerBoards().get(cardBuyedResponse.getPlayerIndex()).setPurplec();
                        case Green -> clientModel.getPlayerBoards().get(cardBuyedResponse.getPlayerIndex()).setGreenc();
                        case Blue -> clientModel.getPlayerBoards().get(cardBuyedResponse.getPlayerIndex()).setBluec();
                        case Yellow -> clientModel.getPlayerBoards().get(cardBuyedResponse.getPlayerIndex()).setYellowc();
                    }
                    if (cardBuyedResponse.getPlayerIndex() == ID){
                        actionDone = true;
                        int i = userInterface.Menù(stdin, actionDone, leaderCardActionAvailable, isSinglePlayer);
                        ChoiceOfTheMenu(i);
                    }
                    break;
                case "FinishMultiplayerGame":
                    FinishMultiplayerGame finishMultiplayerGame = (FinishMultiplayerGame) message;
                    userInterface.PrintMessages("The game is finished, the winner is.............. ");
                    userInterface.PrintMessages(finishMultiplayerGame.getWinnerPlayer() + ", Congratulations!!!");
                    break;
                case "FinishSinglePlayerGame":
                    FinishSinglePlayerGame finishSinglePlayerGame = (FinishSinglePlayerGame) message;
                    userInterface.singlePlayerGameFinished(finishSinglePlayerGame.isRedWon(), finishSinglePlayerGame.getTotPoints());
                    break;
                case "DisconnectionMessage":
                    userInterface.handleDisconnection();
                    break;
            }

    }



    public void ChoiceOfTheMenu(int choice) throws IOException {

        switch (choice) {
            case 0:
                userInterface.GeneralInformationchoice(stdin);
                int i = userInterface.Menù(stdin, actionDone, leaderCardActionAvailable, isSinglePlayer);
                ChoiceOfTheMenu(i);
                break;
            case 1:
                SeePersonalPlayerBoardChoice();
                break;
            case 2:
                MoveResourcesChoice();
                break;
            case 3:
                ActionChoice();
                break;
            case 4:
                LeaderCardActionChoice();
                break;
            case 5:
                actionDone = false;
                leaderCardActionAvailable = 2;
                EndOfTurnMessage endOfTurnMessage = new EndOfTurnMessage();
                endOfTurnMessage.setPlayerIndex(ID);
                sendMessage(socketOut,endOfTurnMessage);
                break;

        }
    }
    public void ActionChoice() throws IOException {
        int choice = 0;
        choice = userInterface.ActionMenu(stdin);
        WhichActionChoice(choice);
    }
    public void WhichActionChoice(int choice) throws IOException {
        switch (choice){
            case 1:
                WantToBuyCardMessage wantToBuyCardMessage = new WantToBuyCardMessage();
                userInterface.BuyCardChoice(stdin,wantToBuyCardMessage, ID);
                sendMessage(socketOut, wantToBuyCardMessage);
                break;
            case 2: // Produce

                WantActivateProductionMessage wantActivateProductionMessage = new WantActivateProductionMessage();
                wantActivateProductionMessage.setPlayerIndex(ID);
                int contYes = 0;
                contYes = userInterface.ProduceChoice(stdin, ID,wantActivateProductionMessage);

                if (contYes > 0) {
                    sendMessage(socketOut, wantActivateProductionMessage);
                }
                else {
                    int i = userInterface.Menù(stdin, actionDone, leaderCardActionAvailable, isSinglePlayer);
                    ChoiceOfTheMenu(i);
                }
                break;
            case 3:
                MarketTrayActionMessage marketTrayActionMessage = new MarketTrayActionMessage();
                marketTrayActionMessage.setPlayerIndex(ID);
                userInterface.MarketTrayActionChoice(stdin, marketTrayActionMessage);
                sendMessage(socketOut, marketTrayActionMessage);
                break;
        }

    }
    public void SeePersonalPlayerBoardChoice() throws IOException {
        userInterface.SeePersonalBoardChoice(stdin, ID, isSinglePlayer);
        int i = userInterface.Menù(stdin, actionDone, leaderCardActionAvailable, isSinglePlayer);
        ChoiceOfTheMenu(i);
    }
    public void MoveResourcesChoice() throws IOException {
        MoveResourcesMessage moveResourcesMessage = new MoveResourcesMessage();
        moveResourcesMessage.setPlayerIndex(ID);
        userInterface.MoveResourcesChoice(stdin,ID, moveResourcesMessage);
        sendMessage(socketOut, moveResourcesMessage);
    }

    public void LeaderCardActionChoice() throws IOException {

        int choice = 0;
        int choice2 = 0;
        choice = userInterface.LeaderCardActionChoice(stdin, ID);

        if (choice == 2){
            choice2 = userInterface.ActivateLeaderCardActionChoice(stdin);
            ActivateLeaderCardActionMessage activateLeaderCardActionMessage = new ActivateLeaderCardActionMessage();
            activateLeaderCardActionMessage.setPlayerIndex(ID);
            activateLeaderCardActionMessage.setLeaderCardIndex(choice2);
            sendMessage(socketOut, activateLeaderCardActionMessage);
        }
        else {
            choice2 = userInterface.DiscardLeaderCardActionChoice(stdin);
            DiscardLeaderCardActionMessage discardLeaderCardActionMessage = new DiscardLeaderCardActionMessage();
            discardLeaderCardActionMessage.setPlayerIndex(ID);
            discardLeaderCardActionMessage.setLeaderCardIndex(choice2);
            sendMessage(socketOut, discardLeaderCardActionMessage);
        }
    }

    /*public Thread asyncReadFromSocket(final ObjectInputStream socketIn) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (isActive()) {
                        Object inputObject = socketIn.readObject();
                        if (inputObject instanceof String) {
                            System.out.println((String) inputObject);
                        } else if (inputObject instanceof Board) {
                            ((Board) inputObject).print();
                        } else {
                            throw new IllegalArgumentException();
                        }
                    }
                } catch (Exception e) {
                    setActive(false);
                }
            }
        });
        t.start();
        return t;
    }

    public Thread asyncWriteToSocket(final Scanner stdin, final PrintWriter socketOut) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (isActive()) {
                        String inputLine = stdin.nextLine();
                        socketOut.println(inputLine);
                        socketOut.flush();
                    }
                } catch (Exception e) {
                    setActive(false);
                }
            }
        });
        t.start();
        return t;
    }
*/

    public void run() throws IOException {
        Socket socket = new Socket(ip, port);
        //System.out.println("Connection established");
        setSocket(socket);
        setSocketOut(new ObjectOutputStream(socket.getOutputStream()));
        setSocketIn(new ObjectInputStream(socket.getInputStream()));

        try {

                SocketMessage message=(SocketMessage)socketIn.readObject();
                receiveMessage(message);
                message=(SocketMessage)socketIn.readObject();
                receiveMessage(message);

                while(!message.getID().equalsIgnoreCase("GameStarted")){
                    message=(SocketMessage)socketIn.readObject();
                    receiveMessage(message);
                }
                while(true){
                    Message message2=(Message)socketIn.readObject();
                    receiveMessageFromServer(message2);
                }
                /*System.out.println("Quanto vuoi che valga A?");
                int a=stdin.nextInt();
                socketOut.writeObject(a);

                SocketMessage b= (SocketMessage)socketIn.readObject();
                receiveMessage(b);*/
            } catch (NoSuchElementException | ClassNotFoundException e) {
                System.out.println("Connection closed from the client side");
            } finally {
                stdin.close();
                socketIn.close();
                socketOut.close();
                socket.close();
            }
    }



    public int nextInt(){
        int a = 0;
        boolean ok = false;
        while (!ok){
            try {
                a = stdin.nextInt();
                ok = true;
            }catch (Exception e){
                ok = false;
                stdin.next();
            }
        }
        return a;

    }


}

