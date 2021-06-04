package it.polimi.ingsw.Network.Client;

import it.polimi.ingsw.Model.*;
import it.polimi.ingsw.Model.LeaderCard.LeaderCard;
import it.polimi.ingsw.Model.Marble.MarketMarble;
import it.polimi.ingsw.Network.Client.CModel.ClientModel;
import it.polimi.ingsw.Network.Client.CModel.PlayerBoard;
import it.polimi.ingsw.Network.Messages.*;
import it.polimi.ingsw.Observer.ViewObserver;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Client extends Messanger implements ViewObserver{

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
    public Client(String ip, int port, UserInterface userInterface) {
        this.ip = ip;
        this.port = port;
        this.userInterface=userInterface;
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



    public synchronized void setActive(boolean active) {
        this.active = active;
    }

    public synchronized void receiveMessage(SocketMessage message) throws IOException {
        System.out.println("messaggio ricevuto: " + message.getID() + "destinato a: "+ message.getReceiver());
        if(message.getReceiver()==null || message.getReceiver().contains(this.nickname)){
            switch (message.getID()){
                case "connected":
                    userInterface.askMultiplayer(stdin);
                    break;
                case "numberOfPlayers":
                    userInterface.askNumberOfPlayers(stdin);
                    break;
                case "waiting":
                    System.out.println("Waiting for other players...");
                    break;
                case "GameStarted":
                    ID=message.getValue();
                    System.out.println("   MAESTRI DEL MEDIOEVO!    \n" +
                            "(game started!) ");
                    sendMessage(socketOut, new SocketMessage("Fine",0, null, null));
                    userInterface.FourLeaderCards(stdin);

                default:
                    break;
            }
        }
    }
    public void receiveMessageFromServer(Message message) throws IOException {
        //if(message.getPlayerIndex()==null || message.getPlayerIndex().contains(this.nickname)){
            switch (message.getTypeOfMessage()) {
                case ("FourLeaderCardResponse"):
                    FourLeaderCardResponse fourLeaderCardResponse = (FourLeaderCardResponse) message;

                    clientModel.getPlayerBoards().get(fourLeaderCardResponse.getPlayerIndex()).setNickname(fourLeaderCardResponse.getNickname());
                    clientModel.getPlayerBoards().get(fourLeaderCardResponse.getPlayerIndex()).setLeaderCards(fourLeaderCardResponse.getLeaderCards());

                    if (message.getPlayerIndex() == ID) {
                        clientModel.getMarketTrayClient().setMarketMatrix(((fourLeaderCardResponse).getMarketTray().getMarketMatrix()));
                        clientModel.getMarketTrayClient().setOustideMarble(((fourLeaderCardResponse).getMarketTray().getOustideMarble()));
                        clientModel.setDevGrid(((fourLeaderCardResponse.getTopCards())));

                        if (clientModel.getPlayerBoards().get(ID).getLeaderCards() == null)
                            System.out.println("NOLEADERS");
                        int cont = 0;
                        for (LeaderCard l : clientModel.getPlayerBoards().get(ID).getLeaderCards()) {
                            userInterface.ShowCard(l);
                            //System.out.println(l);
                            System.out.println(cont);
                            cont++;
                            System.out.println("\n");

                        }
                        int a = 4;
                        int b = 4;
                        while (a > 3 || b > 3) {

                            System.out.println("Which ones you want to discard? insert 2 index [0-3]");
                            a = stdin.nextInt();
                            b = stdin.nextInt();
                            if (a > 3 || b > 3 || a == b) {
                                a = 4;
                                System.out.println("wrong indexes, try again");
                            }
                        }
                        DiscardInitialLeaderCardsMessage discardInitial = new DiscardInitialLeaderCardsMessage();
                        discardInitial.setPlayerIndex(ID);
                        discardInitial.setIndexLeaderCard1(a);
                        discardInitial.setIndexLeaderCard2(b);
                        sendMessage(socketOut, discardInitial);
                        break;
                    } else
                        break;

                case ("Two leader card response"):
                    TwoLeaderCardsResponse twoLeaderCardsResponse = (TwoLeaderCardsResponse) message;
                    clientModel.getPlayerBoards().get(message.getPlayerIndex()).setLeaderCards(twoLeaderCardsResponse.getLeaderCards());
                    clientModel.getPlayerBoards().get(message.getPlayerIndex()).setProductions(twoLeaderCardsResponse.getProductions());
                    if (message.getPlayerIndex() == ID) {
                        System.out.println("It's time to choose your initial resources");

                        InitialResourcesMessage message1 = new InitialResourcesMessage();
                        message1.setPlayerIndex(ID);
                        switch (ID) {
                            case 0:
                                System.out.println("You are the first one, no initial resources\n");
                                break;
                            case 1, 2:
                                String c = "a";
                                while (!c.equalsIgnoreCase("P") && !c.equalsIgnoreCase("B") && !c.equalsIgnoreCase("G") && !c.equalsIgnoreCase("Y")) {
                                    if (ID == 1)
                                        System.out.println("You are the second one, you have one initial resource, choose between: SERVANT[P], SHIELD[B], STONE[G], COIN [Y]");
                                    else
                                        System.out.println("You are the third one, you have on FaithPoint and one initial resource , choose beetween: SERVANT[P], SHIELD[B], STONE[G], COIN [Y]");
                                    c = stdin.next();
                                }
                                message1.setColorMarble1(marbleChoice(c));

                                int a = 5;
                                while (a < 0 || a > 2) {
                                    System.out.println("Choose the Warehouse row [0-2]");
                                    a = stdin.nextInt();
                                    if (a < 0 || a > 2)
                                        System.out.println("Wrong index");
                                }
                                message1.setRow1(a);
                                break;
                            case 3:
                                c = "a";
                                while (!c.equalsIgnoreCase("P") && !c.equalsIgnoreCase("B") && !c.equalsIgnoreCase("G") && !c.equalsIgnoreCase("Y")) {
                                    System.out.println("You are the forth one, you have on FaithPoint and two initial resources , choose the first one between: SERVANT[P], SHIELD[B], STONE[G], COIN [Y]");
                                    c = stdin.next();
                                }
                                message1.setColorMarble1(marbleChoice(c));
                                a = 3;
                                while (a < 0 || a > 2) {
                                    System.out.println("Choose the Warehouse row [0-2]");
                                    a = stdin.nextInt();
                                    if (a < 0 || a > 2)
                                        System.out.println("Wrong index");
                                }
                                message1.setRow1(a);
                                int i = 0;
                                while (i == 0) {
                                    c = "a";
                                    while (!c.equalsIgnoreCase("P") && !c.equalsIgnoreCase("B") && !c.equalsIgnoreCase("G") && !c.equalsIgnoreCase("Y")) {
                                        System.out.println("choose the first one between: SERVANT[P], SHIELD[B], STONE[G], COIN [Y]");
                                        c = stdin.next();
                                    }
                                    message1.setColorMarble2(marbleChoice(c));

                                    int b = 3;
                                    while (b < 0 || b > 2) {
                                        System.out.println("Choose the Warehouse row [0-2]");
                                        b = stdin.nextInt();
                                        if (b < 0 || b > 2)
                                            System.out.println("Wrong index");
                                    }


                                    if ((message1.getRow1() == b && (message1.getColorMarble1() != message1.getColorMarble2() || b == 0)) || (message1.getRow1() != b && message1.getColorMarble1() == message1.getColorMarble2())) {
                                        System.out.println("Wrong combination, choose again the second resource");
                                    } else {
                                        message1.setRow2(b);
                                        i = 1;
                                    }
                                }
                        }
                        System.out.println("Waiting for other playes...");
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
                            int i = -1;
                            MenuCli();
                        } else {
                            System.out.println("The game is started, it isn't your turn now");
                        }
                    }
                    break;
                case "MarketTrayActionResponse":

                    boolean keep = false;
                    String c = "";
                    int row = 0;
                    MarketTrayActionResponse marketTrayActionResponse = (MarketTrayActionResponse) message;
                    MarketMarble.ColorMarble colorMarble;
                    DealWithResourcesFromMarketTrayMessage dealWithResourcesFromMarketTrayMessage = new DealWithResourcesFromMarketTrayMessage();
                    dealWithResourcesFromMarketTrayMessage.setPlayerIndex(ID);
                    clientModel.getMarketTrayClient().setMarketMatrix(marketTrayActionResponse.getMarketTray());
                    clientModel.getMarketTrayClient().setOustideMarble(marketTrayActionResponse.getOutsideMarble());
                    if (marketTrayActionResponse.getPlayerIndex() == ID) {
                        clientModel.getPlayerBoards().get(ID).PrintWarehouse();
                        System.out.println("You have collected some marbles, choose what to do with them: ");
                        for (MarketMarble marketMarble : marketTrayActionResponse.getReturnedmarbles()) {
                            colorMarble = marketMarble.getColorMarble();
                            if (colorMarble == MarketMarble.ColorMarble.WHITE) {
                                if (marketTrayActionResponse.getChangeWhite1() != MarketMarble.ColorMarble.WHITE) {
                                    if (marketTrayActionResponse.getChangeWhite2() == MarketMarble.ColorMarble.WHITE) {
                                        System.out.println("You want to trasform the white marble in" + marketTrayActionResponse.getChangeWhite1() + "[1] or" + marketTrayActionResponse.getChangeWhite2() + "[2]\n");
                                        if (stdin.nextInt() == 1) {
                                            colorMarble = marketTrayActionResponse.getChangeWhite1();
                                        } else {
                                            colorMarble = marketTrayActionResponse.getChangeWhite2();
                                        }
                                    }
                                }
                            }
                            if (colorMarble != MarketMarble.ColorMarble.WHITE) {
                                if (colorMarble == MarketMarble.ColorMarble.RED) {
                                    System.out.println("Red marble, you have to keep it \n");
                                    keep = true;
                                    row = 0;
                                } else {
                                    System.out.println("What do you want to do with marble: " + colorMarble + "? Keep it [S] or not [other] ?\n");
                                    c = stdin.next();
                                    if (c.equalsIgnoreCase("s")) {
                                        keep = true;
                                        System.out.println("In which warehouse row do you want to add the marble?\nChoose correctly because if you can't add the marble in the row selected, it will be automatically considered as you discarded it\n");
                                        row = stdin.nextInt();
                                    } else {
                                        keep = false;
                                        row = 0;
                                    }
                                }
                                dealWithResourcesFromMarketTrayMessage.setKeeps(keep);
                                dealWithResourcesFromMarketTrayMessage.setMarbles(marketMarble.getColorMarble());
                                dealWithResourcesFromMarketTrayMessage.setRows(row);
                            } else {
                                System.out.println("\nWhite marble, does nothing\n");
                            }
                        }
                        sendMessage(socketOut, dealWithResourcesFromMarketTrayMessage);
                    }

                    break;

                case "DealWithResourcesFromMarketTrayResponse":
                    int i = -1;
                    DealWithResourcesFromMarketTrayResponse dealWithResourcesFromMarketTrayResponse = (DealWithResourcesFromMarketTrayResponse) message;
                    clientModel.getPlayerBoards().get(dealWithResourcesFromMarketTrayResponse.getPlayerIndex()).getFaithTrackClient().setRedPosition(dealWithResourcesFromMarketTrayResponse.getCurrPlayersAdvances());
                    clientModel.getPlayerBoards().get(dealWithResourcesFromMarketTrayResponse.getPlayerIndex()).getWarehosueClient().setWarehouseRows(dealWithResourcesFromMarketTrayResponse.getWarehouse().getRows());
                    for (PlayerBoard p : clientModel.getPlayerBoards()) {
                        if (p.getNickname() != null && !p.getNickname().equals(clientModel.getPlayerBoards().get(dealWithResourcesFromMarketTrayResponse.getPlayerIndex()).getNickname())) {
                            p.getFaithTrackClient().setRedPosition(dealWithResourcesFromMarketTrayResponse.getOtherPlayersAdvances());
                        }
                    }
                    if (dealWithResourcesFromMarketTrayResponse.isPopeFavoreEvent()) {
                        System.out.println("PopeFavorEvent has occured\n");
                    }

                    if (dealWithResourcesFromMarketTrayResponse.getPlayerIndex() == ID) {
                        System.out.println("You advanced by " + dealWithResourcesFromMarketTrayResponse.getCurrPlayersAdvances() + "\n" +
                                "OtherPlayers advanced by " + dealWithResourcesFromMarketTrayResponse.getOtherPlayersAdvances());
                        actionDone = true;
                        MenuCli();
                    }
                    break;
                case "WantToBuyCardResponse":
                    ArrayList<CostOfCard> resourcesFromStrongbox = new ArrayList<>();
                    ArrayList<CostOfCard> resourcesFromWarehouse = new ArrayList<>();
                    ArrayList<Integer> warehouseRows = new ArrayList<>();
                    WantToBuyCardResponse wantToBuyCardResponse = (WantToBuyCardResponse) message;
                    if (wantToBuyCardResponse.getPlayerIndex() == ID) {
                        switch (wantToBuyCardResponse.getPhrasetoShow()) {
                            case "The card can't be added in the slot that you selected", "The card selected doesn't exist", "You don't have enough resources to buy this card":
                                System.out.println(wantToBuyCardResponse.getPhrasetoShow());
                                MenuCli();
                                break;
                            case "You have the resources to add the card and you can add it in the slot that you selected":
                                BuyCardMessage buyCardMessage = new BuyCardMessage();
                                buyCardMessage.setPlayerIndex(ID);
                                System.out.println(wantToBuyCardResponse.getPhrasetoShow() + "[" + wantToBuyCardResponse.getSlot() + "]" + "\nThe card costs:" + CostofCardInString(wantToBuyCardResponse.getCost()));
                                clientModel.getPlayerBoards().get(ID).PrintWarehouse();
                                clientModel.getPlayerBoards().get(ID).PrintStrongbox();
                                System.out.println("How do you want to buy it?\n");
                                Payment(wantToBuyCardResponse.getCost(),resourcesFromStrongbox,resourcesFromWarehouse,warehouseRows,ID);
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
                            System.out.println("nuovo warehouse"); // in realtà qua bisogna stampare il nuovo warehouse
                        }
                        MenuCli();
                    } else {
                        if (moveResourcesResponse.getPlayerIndex() == ID) {
                            System.out.println("Can't move the resources selected");
                            MenuCli();
                        }
                    }

                    break;
                case "WantActivateProductionResponse":
                    WantActivateProductionResponse wantActivateProductionResponse = (WantActivateProductionResponse) message;
                    if (wantActivateProductionResponse.getPlayerIndex() == ID) {
                        String c1 = "";
                        if (wantActivateProductionResponse.isOk()) {
                            System.out.println("You have the resources to produce\n");
                            clientModel.getPlayerBoards().get(ID).PrintWarehouse();
                            clientModel.getPlayerBoards().get(ID).PrintStrongbox();
                            for (int prod : wantActivateProductionResponse.getProductions()) {
                                ArrayList<CostOfCard> ResourcesFromStrongbox = new ArrayList<>();
                                ArrayList<CostOfCard> ResourcesFromWarehouse = new ArrayList<>();
                                ArrayList<Integer> rows = new ArrayList<>();
                                System.out.println("Production number " + prod + ":\n");
                                System.out.println(clientModel.getPlayerBoards().get(ID).getProductions().get(prod).printProduction());
                                ProduceMessage produceMessage = new ProduceMessage();
                                produceMessage.setPlayerIndex(ID);
                                System.out.println("How do you want to pay it?\n");
                                if (prod == 0) {
                                    Payment(wantActivateProductionResponse.getBasicProductionCost(),ResourcesFromStrongbox, ResourcesFromWarehouse, rows, ID);
                                    System.out.println("Choose the marble to get [P] [Y] [G] [B]\n");
                                    c1 = stdin.next();
                                    produceMessage.setResourcesFromStrongbox(ResourcesFromStrongbox);
                                    produceMessage.setResourcesFromWarehouse(ResourcesFromWarehouse);
                                    produceMessage.setProductionProfit(marbleChoice(c1));
                                    c1 = "";
                                }
                                else {
                                    Payment(clientModel.getPlayerBoards().get(ID).getProductions().get(prod).getProductionCost(),ResourcesFromStrongbox,ResourcesFromWarehouse,rows,ID);
                                    produceMessage.setResourcesFromStrongbox(ResourcesFromStrongbox);
                                    produceMessage.setResourcesFromWarehouse(ResourcesFromWarehouse);
                                    if (prod == 4 || prod == 5){
                                        System.out.println("Choose the marble to get [P] [Y] [G] [B]\n");
                                        c1 = stdin.next();
                                        produceMessage.setProductionProfit(marbleChoice(c1));
                                    }
                                }
                                produceMessage.setPlayerIndex(ID);

                            }


                        } else {
                            System.out.println("You don't have enough resources to produce all the productions that you selected");
                            MenuCli();
                        }
                    }
                    break;
                case "EndTurnResponse":
                    EndTurnResponse endTurnResponse = (EndTurnResponse) message;
                    if (endTurnResponse.getIndexNewTurn() == ID) {
                        System.out.println("It's your turn!");
                        MenuCli();
                    } else {
                        System.out.println("Now it's the turn of:" + clientModel.getPlayerBoards().get(endTurnResponse.getIndexNewTurn()).getNickname());
                    }
                    break;
                case "ActivateLeaderCardActionResponse":
                    ActivateLeaderCardActionResponse activateLeaderCardActionResponse = (ActivateLeaderCardActionResponse) message;
                    if (activateLeaderCardActionResponse.isOk()) {
                        clientModel.getPlayerBoards().get(activateLeaderCardActionResponse.getPlayerIndex()).getLeaderCards().get(activateLeaderCardActionResponse.getCardindex()).setActivate(true);
                    }
                    if (activateLeaderCardActionResponse.getPlayerIndex() == ID) {
                        System.out.println(activateLeaderCardActionResponse.getResponse());
                        if (activateLeaderCardActionResponse.isOk()) {
                            leaderCardActionAvailable--;
                        }
                        MenuCli();
                    }
                    break;
                case "DiscardLeaderCardActionResponse":
                    int indexPopeFavorState = 0;
                    DiscardLeaderCardActionResponse discardLeaderCardActionResponse = (DiscardLeaderCardActionResponse) message;
                    if (discardLeaderCardActionResponse.isOk()) {
                        leaderCardActionAvailable--;
                        clientModel.getPlayerBoards().get(discardLeaderCardActionResponse.getPlayerIndex()).getLeaderCards().remove(discardLeaderCardActionResponse.getCardIndex());
                        if (discardLeaderCardActionResponse.isPopeFavorStateEvent()) {
                            System.out.println("A pope favor state event has occured!");
                            for (PlayerBoard p : clientModel.getPlayerBoards()) {
                                if (p.getNickname() != null) {
                                    p.getFaithTrackClient().setPopeFavors(discardLeaderCardActionResponse.getPopeFavorStates().get(indexPopeFavorState), 0);
                                    indexPopeFavorState++;
                                    p.getFaithTrackClient().setPopeFavors(discardLeaderCardActionResponse.getPopeFavorStates().get(indexPopeFavorState), 1);
                                    indexPopeFavorState++;
                                    p.getFaithTrackClient().setPopeFavors(discardLeaderCardActionResponse.getPopeFavorStates().get(indexPopeFavorState), 2);
                                    indexPopeFavorState++;
                                }
                            }
                        }
                        clientModel.getPlayerBoards().get(discardLeaderCardActionResponse.getPlayerIndex()).getFaithTrackClient().setRedPosition(1);
                    }

                    if (discardLeaderCardActionResponse.getPlayerIndex() == ID) {
                        System.out.println(discardLeaderCardActionResponse.getResponse());
                        MenuCli();
                    }
                    break;
                case "ProductionResponse":
                    ProductionResponse productionResponse = (ProductionResponse) message;
                    clientModel.getPlayerBoards().get(productionResponse.getPlayerIndex()).getWarehosueClient().setWarehouseRows(productionResponse.getNewwarehouse());
                    clientModel.getPlayerBoards().get(productionResponse.getPlayerIndex()).getFaithTrackClient().setRedPosition(productionResponse.getFaithTrackpositions());
                    indexPopeFavorState = 0;
                    clientModel.getPlayerBoards().get(productionResponse.getPlayerIndex()).setStrongBox(productionResponse.getNewstrongbox());
                    if (productionResponse.isPopeFavoreStateEvent()) {
                        System.out.println("A pope favor state event has occured!");
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
                    if (productionResponse.getPlayerIndex() == ID) {
                        actionDone = true;
                        MenuCli();
                    }
                    break;
                case "CardBuyedResponse":
                    CardBuyedResponse cardBuyedResponse = (CardBuyedResponse) message;
                    clientModel.setDevGrid(cardBuyedResponse.getNewDevGrid());
                    clientModel.getPlayerBoards().get(cardBuyedResponse.getPlayerIndex()).setStrongBox(cardBuyedResponse.getNewstrongbox());
                    clientModel.getPlayerBoards().get(cardBuyedResponse.getPlayerIndex()).getWarehosueClient().setWarehouseRows(cardBuyedResponse.getNewwarehouse());
                    clientModel.getPlayerBoards().get(cardBuyedResponse.getPlayerIndex()).setProductions(cardBuyedResponse.getNewproductionAvailables());
                    if (clientModel.getPlayerBoards().get(cardBuyedResponse.getPlayerIndex()).getDevSlotClient().size() < cardBuyedResponse.getSlot()) {
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
                        MenuCli();
                    }
            }
    }
    public void MenuCli() throws IOException {
        int i = -1;
        if (!actionDone) {
            if (leaderCardActionAvailable > 0) {
                System.out.println("----------------Menù------------" +
                        "\n [0] See general informations (Market tray and DevGrid)." +
                        "\n [1] See a personal player board." +
                        "\n [2] Move resources in the Warehouse." +
                        "\n [3] Action" +
                        "\n [4] Leader Action");
                while (i > 4 || i < 0) {
                    System.out.println("Insert the right index\n");
                    i = stdin.nextInt();
                }
            }
            else {
                System.out.println("----------------Menù------------" +
                        "\n [0] See general informations (Market tray and DevGrid)." +
                        "\n [1] See a personal player board." +
                        "\n [2] Move resources in the Warehouse." +
                        "\n [3] Action" +
                        "\n [4] ---Option not Available ---");
                while (i >= 4 || i < 0) {
                    System.out.println("Insert the right index\n");
                    i = stdin.nextInt();
                }
            }

        } else {
            if (leaderCardActionAvailable > 0) {
                System.out.println("----------------Menù------------" +
                        "\n [0] See general informations (Market tray and DevGrid)." +
                        "\n [1] See a personal player board." +
                        "\n [2] Move resources in the Warehouse." +
                        "\n [3] ---Option not Available ---" +
                        "\n [4] Leader Action" +
                        "\n [5] EndTurn");
                while (i > 5 || i < 0 || i == 3) {
                    System.out.println("Insert the right index\n");
                    i = stdin.nextInt();
                }
            }
            else {
                System.out.println("----------------Menù------------" +
                        "\n [0] See general informations (Market tray and DevGrid)." +
                        "\n [1] See a personal player board." +
                        "\n [2] Move resources in the Warehouse." +
                        "\n [3] ---Option not Available ---" +
                        "\n [4] ---Option not Available ---" +
                        "\n [5] EndTurn");
                while (i > 5 || i < 0 || i == 3 || i == 4) {
                    System.out.println("Insert the right index\n");
                    i = stdin.nextInt();
                }
            }
        }
        ChoiceOfTheMenu(i);
    }

    public void MenuAzione(){
        System.out.println("----------------Menù------------" +
                "\n [1] BuyCard." +
                "\n [2] Produce." +
                "\n [3] MarketTrayAction");
    }
    public StringBuilder CostofCardInString(ArrayList<CostOfCard> cc){
        StringBuilder string = new StringBuilder();
        for (CostOfCard c : cc){
            string.append(c.getCostNumber());
            string.append(" ");
            string.append(c.getCostColor());
            string.append(" ");
        }
        string.append("\n");
        return string;
    }
    public void ChoiceOfTheMenu(int choice) throws IOException {
        int lvl = -1;
        switch (choice) {
            case 0:
                clientModel.getMarketTrayClient().printMarketTray();
                while (lvl < 0 || lvl > 3) {
                    System.out.println("\nChoose level of the card that you want to see\n[0] don't want to see DevGrid\n[1] lvl1\n[2] lvl2\n[3] lvl3");
                    lvl = stdin.nextInt();
                }
                if (lvl != 0) {
                    clientModel.printDevGrid(lvl);
                }
                MenuCli();
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
        MenuAzione();
        System.out.println("Select an action[1-3]\n");
        choice = stdin.nextInt();
        WhichActionChoice(choice);
    }
    public void WhichActionChoice(int choice) throws IOException {
        switch (choice){
            case 1:
                int levelRow = 0;
                int DevGridCol = 0;
                int slot = 0;
                int lvl = 0;
                clientModel.getPlayerBoards().get(ID).PrintDevCard();
                System.out.println("Choose the level of the card [1-3]\n");
                levelRow = stdin.nextInt();
                clientModel.printDevGrid(levelRow);
                System.out.println("Choose the column [0-3]\n");
                DevGridCol = stdin.nextInt();
                System.out.println("Choose in which slot do you want to add the card[0-3]\n");
                slot = stdin.nextInt();
                WantToBuyCardMessage wantToBuyCardMessage = new WantToBuyCardMessage();
                wantToBuyCardMessage.setPlayerIndex(ID);
                wantToBuyCardMessage.setRow(levelRow-1);
                wantToBuyCardMessage.setCol(DevGridCol);
                wantToBuyCardMessage.setSlot(slot);
                sendMessage(socketOut, wantToBuyCardMessage);
                break;
            case 2: // Produce
                clientModel.getPlayerBoards().get(ID).PrintProductionsAvailable();
                WantActivateProductionMessage wantActivateProductionMessage = new WantActivateProductionMessage();
                wantActivateProductionMessage.setPlayerIndex(ID);
                ArrayList<CostOfCard> ProductionBasicCost = new ArrayList<>();
                String choice1 = "";
                String choice2 = "";
                String choice3 = "";
                for (int i : clientModel.getPlayerBoards().get(ID).IndexesProductionAvailable()){
                    System.out.println("Do you want to produce production " + i +"? [Y] / [N]\n");
                    choice1 = stdin.next();
                    if (choice1.equalsIgnoreCase("y")){
                        wantActivateProductionMessage.getProductions().add(i);
                        if (i == 0){
                            System.out.println("Choose marble1  [Y] [G] [P] [B]\n");
                            choice2 = stdin.next();
                            ProductionBasicCost.add(new CostOfCard(1, marbleChoice(choice2)));
                            System.out.println("Choose marble2  [Y] [G] [P] [B]\n");
                            choice3 = stdin.next();
                            ProductionBasicCost.add(new CostOfCard(1, marbleChoice(choice3)));
                            wantActivateProductionMessage.setProductionBasicCost(ProductionBasicCost);
                        }
                    }
                    sendMessage(socketOut,wantActivateProductionMessage);
                }

                break;
            case 3:
                clientModel.getMarketTrayClient().printMarketTray();
                String c = "";
                boolean row = false;
                int indexAct = 0;
                MarketTrayActionMessage marketTrayActionMessage = new MarketTrayActionMessage();
                System.out.println("Row[R] or Col[C]\n");
                c = stdin.next();
                if(c.equalsIgnoreCase("r")){
                    row = true;
                }
                System.out.println("Index?\n");
                indexAct = stdin.nextInt();
                System.out.println(marketTrayActionMessage.getPlayerIndex());
                marketTrayActionMessage.setRow(row);
                marketTrayActionMessage.setIndex(indexAct);
                marketTrayActionMessage.setPlayerIndex(ID);
                sendMessage(socketOut, marketTrayActionMessage);
                break;
        }

    }
    public void SeePersonalPlayerBoardChoice() throws IOException {
        System.out.println("Choose player information?\n");
        int index = 0;
        for (PlayerBoard p : clientModel.getPlayerBoards()
        ) {
            if (p.getNickname() != null) {
                System.out.println("[" + index + "]" + p.getNickname() + "\n");
                index++;
            }
        }
        index = 100;
        while (index < 0 || index > clientModel.getPlayerBoards().size()) {
            index = stdin.nextInt();
            if (index < 0 || index > clientModel.getPlayerBoards().size())
                System.out.println("Insert a valid index");
        }
        clientModel.getPlayerBoards().get(index).PrintStrongbox();
        clientModel.getPlayerBoards().get(index).PrintWarehouse();
        clientModel.getPlayerBoards().get(index).PrintFaithTrack();
        clientModel.getPlayerBoards().get(index).PrintDevCard();
        if (index == ID) {
            clientModel.getPlayerBoards().get(index).PrintLeaderCards(true);
        }
        else {
           clientModel.getPlayerBoards().get(index).PrintLeaderCards(false);
        }
        System.out.println("\n ");
        MenuCli();
    }
    public void MoveResourcesChoice() throws IOException {
        int row1 = 0;
        int row2 = 0;
        clientModel.getPlayerBoards().get(ID).PrintWarehouse();
        System.out.println("Choose the two rows of the warehosue to switch\n");
        row1 = stdin.nextInt();
        row2 = stdin.nextInt();
        MoveResourcesMessage moveResourcesMessage = new MoveResourcesMessage();
        moveResourcesMessage.setPlayerIndex(ID);
        moveResourcesMessage.setRow1(row1);
        moveResourcesMessage.setRow2(row2);
        sendMessage(socketOut, moveResourcesMessage);
    }
    public MarketMarble.ColorMarble marbleChoice(String c){
        return switch (c) {
            case "R", "r" -> MarketMarble.ColorMarble.RED;
            case "B", "b" -> MarketMarble.ColorMarble.BLUE;
            case "G", "g" -> MarketMarble.ColorMarble.GREY;
            case "P", "p" -> MarketMarble.ColorMarble.PURPLE;
            default -> MarketMarble.ColorMarble.YELLOW;
        };
    }
    public void Payment(ArrayList<CostOfCard> cost, ArrayList<CostOfCard> resourcesFromStrongbox, ArrayList<CostOfCard> resourcesFromWarehouse, ArrayList<Integer> rows, int playerIndex) {
        int contServants = 0;
        int contCoins = 0;
        int contStones = 0;
        int contShields = 0;
        int indexrow = 0;
        for (CostOfCard c : cost) {
            switch (c.getCostColor()) {
                case BLUE -> contShields += c.getCostNumber();
                case GREY -> contStones += c.getCostNumber();
                case PURPLE -> contServants += c.getCostNumber();
                case YELLOW -> contCoins += c.getCostNumber();
            }
        }
        for (CostOfCard c : cost) {
            int resFromStrong = 0;
            int temp = 100;
            int row = 0;
            switch (c.getCostColor()) {
                case PURPLE:
                    while (contServants > 0) {
                        while (temp > contServants || temp > clientModel.getPlayerBoards().get(playerIndex).getStrongBox().get(2)) {
                            indexrow = 0;
                            System.out.println("How many servants(P) from Strongbox\n");
                            temp = stdin.nextInt();
                        }
                        resFromStrong = temp;
                        contServants -= resFromStrong;
                        resourcesFromStrongbox.add(new CostOfCard(resFromStrong, MarketMarble.ColorMarble.PURPLE));
                        for (WarehouseRow r : clientModel.getPlayerBoards().get(playerIndex).getWarehosueClient().getWarehouseRows()) {
                            temp = 0;
                            if (r.getColor() == MarketMarble.ColorMarble.PURPLE && r.getMarbles().size() > 0) {
                                while (temp > r.getMarbles().size() || temp < contServants) {
                                    System.out.println("How many servants(P) from row " + indexrow);
                                    temp = stdin.nextInt();
                                }
                                contServants -= temp;
                                resourcesFromWarehouse.add(new CostOfCard(temp, MarketMarble.ColorMarble.PURPLE));
                                rows.add(indexrow);
                            }
                            indexrow++;
                        }
                    }
                    break;
                case YELLOW:
                    while (contCoins > 0) {
                        while (temp > contCoins || temp > clientModel.getPlayerBoards().get(playerIndex).getStrongBox().get(3)) {
                            indexrow = 0;
                            System.out.println("How many coins(Y) from Strongbox\n");
                            temp = stdin.nextInt();
                        }
                        resFromStrong = temp;
                        contCoins -= resFromStrong;
                        resourcesFromStrongbox.add(new CostOfCard(resFromStrong, MarketMarble.ColorMarble.YELLOW));
                        for (WarehouseRow r : clientModel.getPlayerBoards().get(playerIndex).getWarehosueClient().getWarehouseRows()) {
                            temp = 0;
                            if (r.getColor() == MarketMarble.ColorMarble.YELLOW && r.getMarbles().size() > 0) {
                                while (temp > r.getMarbles().size() || temp < contShields) {
                                    System.out.println("How many coins(Y) from row " + indexrow);
                                    temp = stdin.nextInt();
                                }
                                contCoins -= temp;
                                resourcesFromWarehouse.add(new CostOfCard(temp, MarketMarble.ColorMarble.YELLOW));
                                rows.add(indexrow);
                            }
                            indexrow++;
                        }
                    }
                    break;
                case GREY:
                    while (contStones > 0) {
                        while (temp > contStones || temp > clientModel.getPlayerBoards().get(playerIndex).getStrongBox().get(1)) {
                            indexrow = 0;
                            System.out.println("How many stones(G) from Strongbox\n");
                            temp = stdin.nextInt();
                        }
                        resFromStrong = temp;
                        contStones -= resFromStrong;
                        resourcesFromStrongbox.add(new CostOfCard(resFromStrong, MarketMarble.ColorMarble.GREY));
                        for (WarehouseRow r : clientModel.getPlayerBoards().get(playerIndex).getWarehosueClient().getWarehouseRows()) {
                            temp = 0;
                            if (r.getColor() == MarketMarble.ColorMarble.GREY && r.getMarbles().size() > 0) {
                                while (temp > r.getMarbles().size() || temp < contStones) {
                                    System.out.println("How many stones(G) from row " + indexrow);
                                    temp = stdin.nextInt();
                                }
                                contStones -= temp;
                                resourcesFromWarehouse.add(new CostOfCard(temp, MarketMarble.ColorMarble.GREY));
                                rows.add(indexrow);
                            }
                            indexrow++;
                        }
                    }
                    break;
                case BLUE:
                    while (contShields > 0) {
                        while (temp > contShields || temp > clientModel.getPlayerBoards().get(playerIndex).getStrongBox().get(0)) {
                            indexrow = 0;
                            System.out.println("How many shields(B) from Strongbox\n");
                            temp = stdin.nextInt();
                        }
                        resFromStrong = temp;
                        contShields -= resFromStrong;
                        resourcesFromStrongbox.add(new CostOfCard(resFromStrong, MarketMarble.ColorMarble.BLUE));
                        for (WarehouseRow r : clientModel.getPlayerBoards().get(playerIndex).getWarehosueClient().getWarehouseRows()) {
                            temp = 0;
                            if (r.getColor() == MarketMarble.ColorMarble.BLUE && r.getMarbles().size() > 0) {
                                while (temp > r.getMarbles().size() || temp < contShields) {
                                    System.out.println("How many shields(B) from row " + indexrow);
                                    temp = stdin.nextInt();
                                }
                                contShields -= temp;
                                resourcesFromWarehouse.add(new CostOfCard(temp, MarketMarble.ColorMarble.BLUE));
                                rows.add(indexrow);
                            }
                            indexrow++;
                        }
                    }
                    break;
            }
        }

    }


    public ArrayList<CostOfCard> PayWithWarehouseResources(){
        int indexRow = 0;
        int n = 0;
        ArrayList<CostOfCard> resourcesFromWarehouse = new ArrayList<>();
        for (WarehouseRow w : clientModel.getPlayerBoards().get(ID).getWarehosueClient().getWarehouseRows()){
            System.out.println("How many marbles from row" + indexRow);
            n = stdin.nextInt();
            if (n!=0) {
                resourcesFromWarehouse.add(new CostOfCard(n, w.getColor()));
            }
        }
        return resourcesFromWarehouse;

    }
    public void LeaderCardActionChoice() throws IOException {
        clientModel.getPlayerBoards().get(ID).PrintLeaderCards(true);
        int choice = 0;
        int choice2 = -1;
        System.out.println("What do you want to do?\n");
        while (choice != 1 && choice!=2 ){
            System.out.println("[1] Discard Leader Card\n[2] Activate Leader Card\n");
            choice = stdin.nextInt();
        }
        if (choice == 2){
            while (choice2 != 0 && choice2 != 1) {
                System.out.println("Which card do you want to activate? [0] or [1]\n");
                choice2 = stdin.nextInt();
            }
            ActivateLeaderCardActionMessage activateLeaderCardActionMessage = new ActivateLeaderCardActionMessage();
            activateLeaderCardActionMessage.setPlayerIndex(ID);
            activateLeaderCardActionMessage.setLeaderCardIndex(choice2);
            sendMessage(socketOut, activateLeaderCardActionMessage);
        }
        else {
            while (choice2 != 0 && choice2 != 1) {
                System.out.println("Which card do you want to discard? [0] or [1]\n");
                choice2 = stdin.nextInt();
            }
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
        userInterface.askNickname(stdin);
        userInterface.askOnline(stdin);
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

    @Override
    public void updateOnline(boolean online) throws IOException {
     if(online){
         Socket socket = new Socket(ip, port);
         System.out.println("Connection established");
         setSocket(socket);
         setSocketOut(new ObjectOutputStream(socket.getOutputStream()));
         setSocketIn(new ObjectInputStream(socket.getInputStream()));
     }
     else
         System.out.println("OFFLINE GAME SELECTED!");
    }

    @Override
    public void updateMultiplayer(boolean multiplayer) throws IOException {
        if(multiplayer){
            sendMessage(this.socketOut,new SocketMessage("newMulti",1,null,nickname));
        }
        else
            sendMessage(this.socketOut,new SocketMessage("newMulti",0,null,nickname));
    }
    @Override
    public void updateNickname(String nickname){
        this.nickname=nickname;
    }
    @Override
    public void updateNumberOfPlayers(int numberOfPlayers) throws IOException {
        System.out.println("Number of players set, waiting for them to connect...");
        sendMessage(this.socketOut,new SocketMessage("numberOfPlayersReply",numberOfPlayers,null,nickname));
    }
    public void updateMessage(Message message) throws IOException {
        message.setPlayerIndex(ID);
        sendMessage(this.socketOut, message);
    }
}

