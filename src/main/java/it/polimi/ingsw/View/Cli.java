package it.polimi.ingsw.View;


import it.polimi.ingsw.Model.CostOfCard;
import it.polimi.ingsw.Model.LeaderCard.*;
import it.polimi.ingsw.Model.Marble.MarketMarble;
import it.polimi.ingsw.Model.WarehouseRow;
import it.polimi.ingsw.Network.Client.CModel.ClientModel;
import it.polimi.ingsw.Network.Client.CModel.PlayerBoard;
import it.polimi.ingsw.Network.Client.UserInterface;
import it.polimi.ingsw.Network.Messages.*;


import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

//import it.polimi.ingsw.utils.gameMessage;

public class Cli implements UserInterface {
    private boolean SinglePlayer;
    private final PrintStream out;

    ClientModel clientModel;

    public Cli() {
        out=System.out;
    }

    public ClientModel getCmodel() {
        return clientModel;
    }

    public void setCmodel(ClientModel cmodel) {
        clientModel = cmodel;
    }




    @Override
    public boolean askMultiplayer(Scanner scanner){
        String response = "";
        boolean multiplayer=true;

        while (!response.equalsIgnoreCase("s") && !response.equalsIgnoreCase("m")) {
            System.out.println("Would you play SinglePlayer or Multiplayer? (S/M)");
            response = scanner.nextLine();
        }
        if(response.equalsIgnoreCase("S"))
            multiplayer=false;

        return multiplayer;

    }

    @Override
    public void DiscardInitialLeaderCards(Scanner scanner, ArrayList<LeaderCard> leaderCards, DiscardInitialLeaderCardsMessage discardInitialLeaderCardsMessage) {
        int cont = 0;
        for (LeaderCard l : leaderCards) {
            System.out.println("[" + cont + "]");
            System.out.println(l.StampaCarta());
            //userInterface.ShowCard(l);
            //System.out.println(l);
            cont++;
            System.out.println("\n");

        }
        int a = 4;
        int b = 4;

        while (a > 3 || b > 3) {
            System.out.println("Which ones you want to discard? insert 2 index [0-3]");
            a = nextInt(scanner);
            b = nextInt(scanner);
            if (a > 3 || b > 3 || a == b) {
                a = 4;
                System.out.println("wrong indexes, try again");
            }
        }
        discardInitialLeaderCardsMessage.setIndexLeaderCard1(a);
        discardInitialLeaderCardsMessage.setIndexLeaderCard2(b);
    }

    @Override
    public void InitialResources(Scanner stdin, int ID, InitialResourcesMessage message1) {
        System.out.println("It's time to choose your initial resources");
        switch (ID){

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
                    a = nextInt(stdin);

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
                    a = nextInt(stdin);
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
                        b = nextInt(stdin);
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
        }


    @Override
    public String askNickname(Scanner scanner) {
        out.println("Insert your nickname:");
        String name= scanner.nextLine();
        return name;

    }

    @Override
    public int askNumberOfPlayers(Scanner scanner) {
        System.out.println("How many players in the game (2-4)?");
        int numberOfPlayers=nextInt(scanner);
        return numberOfPlayers;
    }
    @Override
    public FourLeaderCardsMessage FourLeaderCards(Scanner scanner){
            System.out.println("Press a button to start the game\n");
            String s=scanner.next();
            FourLeaderCardsMessage fourLeaderCardsMessage = new FourLeaderCardsMessage();
            return fourLeaderCardsMessage;
    }

    @Override
    public int Menù(Scanner scanner, boolean actionDone, int leaderCardActionAvailable, boolean isSinglePlayer) {
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
                    i = nextInt(scanner);
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
                    i = nextInt(scanner);
                }
            }

        } else {
            if (leaderCardActionAvailable > 0) {
                if (!isSinglePlayer) {
                    System.out.println("----------------Menù------------" +
                            "\n [0] See general informations (Market tray and DevGrid)." +
                            "\n [1] See a personal player board." +
                            "\n [2] Move resources in the Warehouse." +
                            "\n [3] ---Option not Available ---" +
                            "\n [4] Leader Action" +
                            "\n [5] EndTurn");
                } else {
                    System.out.println("----------------Menù------------" +
                            "\n [0] See general informations (Market tray and DevGrid)." +
                            "\n [1] See a personal player board." +
                            "\n [2] Move resources in the Warehouse." +
                            "\n [3] ---Option not Available ---" +
                            "\n [4] Leader Action" +
                            "\n [5] EndTurn and pick the Top Marker (Type: " + clientModel.getPlayerBoards().get(0).getTopMarker().getType() + ")");
                }
                while (i > 5 || i < 0 || i == 3) {
                    System.out.println("Insert the right index\n");
                    i = nextInt(scanner);
                }
            }
            else {
                if (!isSinglePlayer) {
                    System.out.println("----------------Menù------------" +
                            "\n [0] See general informations (Market tray and DevGrid)." +
                            "\n [1] See a personal player board." +
                            "\n [2] Move resources in the Warehouse." +
                            "\n [3] ---Option not Available ---" +
                            "\n [4] ---Option not Available ---" +
                            "\n [5] EndTurn");
                }
                else {
                    System.out.println("----------------Menù------------" +
                            "\n [0] See general informations (Market tray and DevGrid)." +
                            "\n [1] See a personal player board." +
                            "\n [2] Move resources in the Warehouse." +
                            "\n [3] ---Option not Available ---" +
                            "\n [4] ---Option not Available ---" +
                            "\n [5] EndTurn and pick the Top Marker (Type: " + clientModel.getPlayerBoards().get(0).getTopMarker() + ")");

                }
                while (i > 5 || i < 0 || i == 3 || i == 4) {
                    System.out.println("Insert the right index\n");
                    i = nextInt(scanner);
                }
            }
        }
        return i;
    }

    @Override
    public void DealWithResourcesFromMarketTray(Scanner scanner, MarketTrayActionResponse marketTrayActionResponse, DealWithResourcesFromMarketTrayMessage dealWithResourcesFromMarketTrayMessage, int ID) {
        boolean keep = false;
        String c = "";
        int row = 0;
        int ch = 0;
        clientModel.getPlayerBoards().get(ID).PrintWarehouse();
        MarketMarble.ColorMarble colorMarble;
        System.out.println("You have collected some marbles, choose what to do with them: ");
        for (MarketMarble marketMarble : marketTrayActionResponse.getReturnedmarbles()) {
            colorMarble = marketMarble.getColorMarble();
            if (colorMarble == MarketMarble.ColorMarble.WHITE) {
                if (marketTrayActionResponse.getChangeWhite1() != MarketMarble.ColorMarble.WHITE) {
                    if (marketTrayActionResponse.getChangeWhite2() == MarketMarble.ColorMarble.WHITE) {
                        while (ch != 1 && ch != 2) {
                            System.out.println("You want to trasform the white marble in" + marketTrayActionResponse.getChangeWhite1() + "[1] or" + marketTrayActionResponse.getChangeWhite2() + "[2]\n");
                            ch = nextInt(scanner);
                            if (ch == 1) {
                                colorMarble = marketTrayActionResponse.getChangeWhite1();
                            } else if (ch == 2){
                                colorMarble = marketTrayActionResponse.getChangeWhite2();
                            }
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
                    c = scanner.next();
                    if (c.equalsIgnoreCase("s")) {
                        keep = true;
                        System.out.println("In which warehouse row do you want to add the marble?\nChoose correctly because if you can't add the marble in the row selected, it will be automatically considered as you discarded it\n");
                        row = nextInt(scanner);
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
    }

    @Override
    public void PopeFavorStateEventOccured(Scanner scanner) {
        System.out.println("PopeFavorEvent has occured\n");
    }

    @Override
    public void DealWithResFromMarkTrayResponse(Scanner scanner, DealWithResourcesFromMarketTrayResponse dealWithResourcesFromMarketTrayResponse, boolean isSinglePlayer) {
        if (!isSinglePlayer) {
            System.out.println("You advanced by " + dealWithResourcesFromMarketTrayResponse.getCurrPlayersAdvances() + "\n" +
                    "OtherPlayers advanced by " + dealWithResourcesFromMarketTrayResponse.getOtherPlayersAdvances());
        }
        else {
            System.out.println("You advanced by " + dealWithResourcesFromMarketTrayResponse.getCurrPlayersAdvances() + "\n" +
                    "Black advanced by " + dealWithResourcesFromMarketTrayResponse.getOtherPlayersAdvances());
        }
    }
    public void PrintMessages(String string){
        System.out.println(string);
    }

    @Override
    public void WantToBuyCardResponse(Scanner scanner, WantToBuyCardResponse wantToBuyCardResponse, int ID) {
        clientModel.getPlayerBoards().get(ID).PrintWarehouse();
        clientModel.getPlayerBoards().get(ID).PrintStrongbox();
        System.out.println(wantToBuyCardResponse.getPhrasetoShow() + "[" + wantToBuyCardResponse.getSlot() + "]" + "\nThe card costs:" + CostofCardInString(wantToBuyCardResponse.getCost()));
        System.out.println("How do you want to buy it?\n");
    }

    @Override
    public void Payment(Scanner scanner,ArrayList<CostOfCard> cost, ArrayList<CostOfCard> resourcesFromStrongbox, ArrayList<CostOfCard> resourcesFromWarehouse, ArrayList<Integer> rows, int playerIndex) {
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
                            temp = nextInt(scanner);
                        }
                        resFromStrong = temp;
                        contServants -= resFromStrong;
                        if (resFromStrong!=0) {
                            resourcesFromStrongbox.add(new CostOfCard(resFromStrong, MarketMarble.ColorMarble.PURPLE));
                        }
                        for (WarehouseRow r : clientModel.getPlayerBoards().get(playerIndex).getWarehosueClient().getWarehouseRows()) {
                            temp = 0;
                            if (r.getColor() == MarketMarble.ColorMarble.PURPLE && r.getMarbles().size() > 0) {
                                while (temp > r.getMarbles().size() || temp < contServants) {
                                    System.out.println("How many servants(P) from row " + indexrow);
                                    temp = nextInt(scanner);
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
                            temp = nextInt(scanner);
                        }
                        resFromStrong = temp;
                        contCoins -= resFromStrong;
                        if (resFromStrong != 0) {
                            resourcesFromStrongbox.add(new CostOfCard(resFromStrong, MarketMarble.ColorMarble.YELLOW));
                        }
                        for (WarehouseRow r : clientModel.getPlayerBoards().get(playerIndex).getWarehosueClient().getWarehouseRows()) {
                            temp = 0;
                            if (r.getColor() == MarketMarble.ColorMarble.YELLOW && r.getMarbles().size() > 0) {
                                while (temp > r.getMarbles().size() || temp < contCoins) {
                                    System.out.println("How many coins(Y) from row " + indexrow);
                                    temp = nextInt(scanner);
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
                            temp = nextInt(scanner);
                        }
                        resFromStrong = temp;
                        contStones -= resFromStrong;
                        if (resFromStrong != 0) {
                            resourcesFromStrongbox.add(new CostOfCard(resFromStrong, MarketMarble.ColorMarble.GREY));
                        }
                        for (WarehouseRow r : clientModel.getPlayerBoards().get(playerIndex).getWarehosueClient().getWarehouseRows()) {
                            temp = 0;
                            if (r.getColor() == MarketMarble.ColorMarble.GREY && r.getMarbles().size() > 0) {
                                while (temp > r.getMarbles().size() || temp < contStones) {
                                    System.out.println("How many stones(G) from row " + indexrow);
                                    temp = nextInt(scanner);
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
                            temp = nextInt(scanner);
                        }
                        resFromStrong = temp;
                        contShields -= resFromStrong;
                        if (resFromStrong != 0) {
                            resourcesFromStrongbox.add(new CostOfCard(resFromStrong, MarketMarble.ColorMarble.BLUE));
                        }
                        for (WarehouseRow r : clientModel.getPlayerBoards().get(playerIndex).getWarehosueClient().getWarehouseRows()) {
                            temp = 0;
                            if (r.getColor() == MarketMarble.ColorMarble.BLUE && r.getMarbles().size() > 0) {
                                while (temp > r.getMarbles().size() || temp < contShields) {
                                    System.out.println("How many shields(B) from row " + indexrow);
                                    temp = nextInt(scanner);
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

    @Override
    public void Produce(Scanner scanner, WantActivateProductionResponse wantActivateProductionResponse, ProduceMessage produceMessage, int ID, int prod) {
        String c1 = "";
        ArrayList<CostOfCard> ResourcesFromStrongbox = new ArrayList<>();
        ArrayList<CostOfCard> ResourcesFromWarehouse = new ArrayList<>();
        ArrayList<Integer> rows = new ArrayList<>();
        System.out.println("Production number " + prod + ":\n");
        System.out.println(clientModel.getPlayerBoards().get(ID).getProductions().get(prod).printProduction());

        System.out.println("How do you want to pay it?\n");
        if (prod == 0) {
            Payment(scanner, wantActivateProductionResponse.getBasicProductionCost(),ResourcesFromStrongbox, ResourcesFromWarehouse, rows, ID);
            while (!c1.equalsIgnoreCase("P") && !c1.equalsIgnoreCase("B") && !c1.equalsIgnoreCase("G") && !c1.equalsIgnoreCase("Y")) {
                System.out.println("Choose the profit marble  [P] [Y] [G] [B]\n");
                c1 = scanner.next();
            }
            produceMessage.setResourcesFromStrongbox(ResourcesFromStrongbox);
            produceMessage.setResourcesFromWarehouse(ResourcesFromWarehouse);
            produceMessage.setProductionProfit(marbleChoice(c1));
            produceMessage.setRows(rows);

        }
        else {
            Payment(scanner,clientModel.getPlayerBoards().get(ID).getProductions().get(prod).getProductionCost(),ResourcesFromStrongbox,ResourcesFromWarehouse,rows,ID);
            produceMessage.setResourcesFromStrongbox(ResourcesFromStrongbox);
            produceMessage.setResourcesFromWarehouse(ResourcesFromWarehouse);
            produceMessage.setRows(rows);
            if (prod == 4 || prod == 5){
                while (!c1.equalsIgnoreCase("P") && !c1.equalsIgnoreCase("B") && !c1.equalsIgnoreCase("G") && !c1.equalsIgnoreCase("Y")) {
                    System.out.println("Choose the profit marble  [P] [Y] [G] [B]\n");
                    c1 = scanner.next();
                }
                produceMessage.setProductionProfit(marbleChoice(c1));
            }
        }
    }

    @Override
    public void WantToActivateProdResponse(Scanner scanner, int PlayerIndex) {
        System.out.println("You have the resources to produce\n");
        clientModel.getPlayerBoards().get(PlayerIndex).PrintWarehouse();
        clientModel.getPlayerBoards().get(PlayerIndex).PrintStrongbox();
    }

    @Override
    public void BuyCardChoice(Scanner scanner, WantToBuyCardMessage wantToBuyCardMessage, int ID) {
        int levelRow = 0;
        int DevGridCol = -1;
        int slot = -1;
        int lvl = 0;
        clientModel.getPlayerBoards().get(ID).PrintDevCard();
        while (levelRow < 1 || levelRow >3) {
            System.out.println("Choose the level of the card [1-3]\n");
            levelRow = nextInt(scanner);
        }
        clientModel.printDevGrid(levelRow);
        while (DevGridCol < 0 || DevGridCol > 3) {
            System.out.println("Choose the column [0-3]\n");
            DevGridCol = nextInt(scanner);
        }
        while (slot < 0 || slot > 3) {
            System.out.println("Choose in which slot do you want to add the card[0-3]\n");
            slot = nextInt(scanner);
        }
        wantToBuyCardMessage.setPlayerIndex(ID);
        wantToBuyCardMessage.setRow(levelRow-1);
        wantToBuyCardMessage.setCol(DevGridCol);
        wantToBuyCardMessage.setSlot(slot);
    }

    @Override
    public int ActionMenu(Scanner scanner) {
        int i = 0;
        System.out.println("----------------Menù------------" +
                "\n [1] BuyCard." +
                "\n [2] Produce." +
                "\n [3] MarketTrayAction");
        while (i < 1 || i > 3) {
            System.out.println("Select an action[1-3]\n");
            i = nextInt(scanner);
        }
        return i;
    }

    @Override
    public int ProduceChoice(Scanner scanner, int ID,WantActivateProductionMessage wantActivateProductionMessage) {
        ArrayList<CostOfCard> ProductionBasicCost = new ArrayList<>();
        String choice1 = "";
        String choice2 = "";
        String choice3 = "";
        int contYes = 0;
        clientModel.getPlayerBoards().get(ID).PrintProductionsAvailable();
        for (int i : clientModel.getPlayerBoards().get(ID).IndexesProductionAvailable()){
            choice1 = "";
            choice2 = "";
            choice3 = "";

            while (!choice1.equalsIgnoreCase("y") && !choice1.equalsIgnoreCase("n")) {
                System.out.println("Do you want to produce production " + i + "? [Y] / [N]\n");
                choice1 = scanner.next();
            }
            if (choice1.equalsIgnoreCase("y")){
                contYes++;
                wantActivateProductionMessage.getProductions().add(i);
                if (i == 0) {
                    while (!choice2.equalsIgnoreCase("P") && !choice2.equalsIgnoreCase("B") && !choice2.equalsIgnoreCase("G") && !choice2.equalsIgnoreCase("Y")) {
                        System.out.println("Choose marble1  [Y] [G] [P] [B]\n");
                        choice2 = scanner.next();
                    }
                    while (!choice3.equalsIgnoreCase("P") && !choice3.equalsIgnoreCase("B") && !choice3.equalsIgnoreCase("G") && !choice3.equalsIgnoreCase("Y")) {
                        System.out.println("Choose marble2  [Y] [G] [P] [B]\n");
                        choice3 = scanner.next();
                    }

                    if (choice2.equalsIgnoreCase(choice3)) {
                        ProductionBasicCost.add(new CostOfCard(2, marbleChoice(choice2)));
                    }
                    else {
                        ProductionBasicCost.add(new CostOfCard(1, marbleChoice(choice2)));
                        ProductionBasicCost.add(new CostOfCard(1, marbleChoice(choice3)));
                    }
                    wantActivateProductionMessage.setProductionBasicCost(ProductionBasicCost);
                }
            }
        }
        return contYes;
    }

    @Override
    public void MarketTrayActionChoice(Scanner scanner, MarketTrayActionMessage marketTrayActionMessage) {
        clientModel.getMarketTrayClient().printMarketTray();
        String c = "";
        boolean row = false;
        int indexAct = -1;

        while (!c.equalsIgnoreCase("r") && !c.equalsIgnoreCase("c") ) {
            System.out.println("Row[R] or Col[C]\n");
            c = scanner.next();
        }
        if(c.equalsIgnoreCase("r")){
            row = true;
            while (indexAct <0 || indexAct > 2) {
                System.out.println("Index?\n");
                indexAct = nextInt(scanner);
            }
        }
        else {
            while (indexAct <0 || indexAct > 3) {
                System.out.println("Index?\n");
                indexAct = nextInt(scanner);
            }

        }
        marketTrayActionMessage.setRow(row);
        marketTrayActionMessage.setIndex(indexAct);

    }

    @Override
    public void SeePersonalBoardChoice(Scanner scanner, int ID, boolean isSinglePlayer) {
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
            index = nextInt(scanner);
            if (index < 0 || index > clientModel.getPlayerBoards().size())
                System.out.println("Insert a valid index");
        }
        clientModel.getPlayerBoards().get(index).PrintStrongbox();
        clientModel.getPlayerBoards().get(index).PrintWarehouse();
        clientModel.getPlayerBoards().get(index).PrintFaithTrack(isSinglePlayer);
        clientModel.getPlayerBoards().get(index).PrintDevCard();
        if (index == ID) {
            clientModel.getPlayerBoards().get(index).PrintLeaderCards(true);
        }
        else {
            clientModel.getPlayerBoards().get(index).PrintLeaderCards(false);
        }
        System.out.println("\n ");

    }

    @Override
    public void MoveResourcesChoice(Scanner scanner,int ID, MoveResourcesMessage moveResourcesMessage) {
        int row1 = -1;
        int row2 = -1;
        clientModel.getPlayerBoards().get(ID).PrintWarehouse();
        while (row1 <0 || row1>2 || row2<0 || row2 >2 || row1 == row2) {
            System.out.println("Choose the two rows of the warehosue to switch\n");
            row1 = nextInt(scanner);
            row2 = nextInt(scanner);
        }
        if (row2 < row1){
            int temp = row1;
            row1 = row2;
            row2 = temp;
        }

        moveResourcesMessage.setRow1(row1);
        moveResourcesMessage.setRow2(row2);
    }

    @Override
    public int LeaderCardActionChoice(Scanner scanner, int ID) {
        int choice = 0;
        clientModel.getPlayerBoards().get(ID).PrintLeaderCards(true);
        while (choice != 1 && choice!=2 ){
            System.out.println("[1] Discard Leader Card\n[2] Activate Leader Card\n");
            choice = nextInt(scanner);
        }
        return choice;
    }

    @Override
    public int ActivateLeaderCardActionChoice(Scanner scanner) {
        int choice = -1;
        while (choice != 0 && choice != 1) {
            System.out.println("Which card do you want to activate? [0] or [1]\n");
            choice = nextInt(scanner);
        }
        return choice;
    }

    @Override
    public int DiscardLeaderCardActionChoice(Scanner scanner) {
        int choice = -1;
        while (choice != 0 && choice != 1) {
            System.out.println("Which card do you want to discard? [0] or [1]\n");
            choice = nextInt(scanner);
        }
        return choice;
    }

    @Override
    public void GeneralInformationchoice(Scanner scanner) {
        int lvl = -1;
        clientModel.getMarketTrayClient().printMarketTray();
        while (lvl < 0 || lvl > 3) {
            System.out.println("\nChoose level of the card that you want to see\n[0] don't want to see DevGrid\n[1] lvl1\n[2] lvl2\n[3] lvl3");
            lvl = nextInt(scanner);
        }
        if (lvl != 0) {
            clientModel.printDevGrid(lvl);
        }
    }

    @Override
    public void Waiting(Scanner scanner) {
        System.out.println("Waiting for other players...");
    }

    @Override
    public void GameStarted(Scanner scanner) {
        System.out.println("   MASTERS OF THE RENAISSANCE!    \n" +
                "(game started!) ");
    }

    public void start() {
        if (SinglePlayer) {
            System.out.println("La partita Single Player è iniziata");
            System.out.println("Scegli due carte tra queste LeaderCard, da scartare");

        }
    }

    @Override
    public void waitingForOtherPlayers(Scanner scanner) {
        System.out.println("Number of players set, waiting for them to connect...");
    }
    @Override
    public void newWarehosue(Scanner scanner, int ID) {
        clientModel.getPlayerBoards().get(ID).PrintWarehouse();
    }

    @Override
    public void singlePlayerGameFinished(boolean redWon, int TotalPoints) {
        if (redWon){
            System.out.println("Congratulations, you won the game!\n");
            System.out.println("Total Points:" + TotalPoints);
        }
        else {
            System.out.println("Lorenzo il Magnifico has won the game :(");
        }
    }

    public int nextInt(Scanner scanner){
        int a = 0;
        boolean ok = false;
        while (!ok){
            try {
                a = scanner.nextInt();
                ok = true;
            }catch (Exception e){
                ok = false;
                scanner.next();
            }
        }
        return a;

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


    @Override
    public void handleDisconnection() {
        System.out.println("A disconnection has occurred, the game is terminated! \n");
    }
}





















    /*
    private class MessageReceiver implements Observer<String> {

        @Override
        public void update(String message) {
            System.out.println("Received: " + message);
            try{
                String[] inputs = message.split(",");
                handleMove(Integer.parseInt(inputs[0]), Integer.parseInt(inputs[1]));
            }catch(IllegalArgumentException e){
                clientConnection.asyncSend("Error!");
            }
        }

    }

    private ClientConnection clientConnection;

    public RemoteView(Player player, String opponent, ClientConnection c) {
        super(player);
        this.clientConnection = c;
        c.addObserver(new MessageReceiver());
        c.asyncSend("Your opponent is: " + opponent);

    }

    @Override
    protected void showMessage(Object message) {
        clientConnection.asyncSend(message);
    }

    @Override
    public void update(MoveMessage message)
    {
        showMessage(message.getBoard());
        String resultMsg = "";
        boolean gameOver = message.getBoard().isGameOver(message.getPlayer().getMarker());
        boolean draw = message.getBoard().isFull();
        if (gameOver) {
            if (message.getPlayer() == getPlayer()) {
                resultMsg = gameMessage.winMessage + "\n";
            } else {
                resultMsg = gameMessage.loseMessage + "\n";
            }
        }
        else {
            if (draw) {
                resultMsg = gameMessage.drawMessage + "\n";
            }
        }
        if(message.getPlayer() == getPlayer()){
            resultMsg += gameMessage.waitMessage;
        }
        else{
            resultMsg += gameMessage.moveMessage;
        }

        showMessage(resultMsg);
    }

}

     */

























/* package it.polimi.ingsw.View;

import it.polimi.ingsw.Model.Player;
import it.polimi.ingsw.Network.Client.ClientController;
import it.polimi.ingsw.Network.Server.ClientConnection;
import it.polimi.ingsw.Observer.ObservableView;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class CLI extends View{
    private ClientConnection clientConnection;
    public CLI(Player player, ArrayList<Player> OtherPlayers, ClientConnection c){
        super(player);
        this.clientConnection = c;
    }

    @Override
    protected void showMessage(String message) {
        clientConnection.asyncSend(message);
    }
    public void update(Mo)


 */
























/*
    ClientController cLientController= new ClientController(this);
    private String nickname;
    private Boolean singleMulti=false; //False represent singlePlayer, True represent Multiplayer
    Scanner stdin = new Scanner(System.in);

    @Override
    public void init() throws IOException {
        System.out.println("\n" +
                "\t \uD835\uDD44\uD835\uDD52\uD835\uDD56\uD835\uDD64\uD835\uDD65\uD835\uDD63\uD835\uDD5A \uD835\uDD55\uD835\uDD56\uD835\uDD5D ℝ\uD835\uDD5A\uD835\uDD5F\uD835\uDD52\uD835\uDD64\uD835\uDD54\uD835\uDD5A\uD835\uDD5E\uD835\uDD56\uD835\uDD5F\uD835\uDD65\uD835\uDD60 \n");

        System.out.println("choose nickname:");
        nickname =stdin.nextLine();
        System.out.println("Welcome "+ nickname +", would you play SinglePlayer(s) or MultiPlayer(m)?");
        if(stdin.nextLine().equalsIgnoreCase("m") || stdin.nextLine().equalsIgnoreCase("multiplayer"))
            singleMulti=true;
        cLientController.updateInit(nickname,singleMulti);
    }
}

 */
