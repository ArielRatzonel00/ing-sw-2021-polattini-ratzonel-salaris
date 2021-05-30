package it.polimi.ingsw.Network.Client;

import it.polimi.ingsw.Model.DevelopmentCard;
import it.polimi.ingsw.Model.LeaderCard.LeaderCard;
import it.polimi.ingsw.Model.Marble.MarketMarble;
import it.polimi.ingsw.Model.Player;
import it.polimi.ingsw.Model.WarehouseRow;
import it.polimi.ingsw.Network.Client.CModel.ClientModel;
import it.polimi.ingsw.Network.Client.CModel.PlayerBoard;
import it.polimi.ingsw.Network.Messages.*;
import it.polimi.ingsw.Observer.ViewObserver;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
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
            switch (message.getTypeOfMessage()){
                case ("FourLeaderCardResponse"):
                    FourLeaderCardResponse fourLeaderCardResponse = (FourLeaderCardResponse) message;

                    clientModel.getPlayerBoards().get(fourLeaderCardResponse.getPlayerIndex()).setNickname(fourLeaderCardResponse.getNickname());
                    clientModel.getPlayerBoards().get(fourLeaderCardResponse.getPlayerIndex()).setLeaderCards(fourLeaderCardResponse.getLeaderCards());

                    if(message.getPlayerIndex()==ID) {
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
                        int a=4;
                        int b=4;
                        while(a>3 || b>3) {
                            System.out.println("Quali vuoi scartare? inserisci 2 indici [0-3]");
                            a = stdin.nextInt();
                            b = stdin.nextInt();
                            if (a > 3 || b > 3 || a==b) {
                                a=4;
                                System.out.println("indici errati riprova");
                            }
                        }
                        DiscardInitialLeaderCardsMessage discardInitial = new DiscardInitialLeaderCardsMessage();
                        discardInitial.setPlayerIndex(ID);
                        discardInitial.setIndexLeaderCard1(a);
                        discardInitial.setIndexLeaderCard2(b);
                        sendMessage(socketOut, discardInitial);
                        break;
                    }
                    else
                    break;

                case ("Two leader card response"):
                    TwoLeaderCardsResponse twoLeaderCardsResponse = (TwoLeaderCardsResponse) message;
                    clientModel.getPlayerBoards().get(message.getPlayerIndex()).setLeaderCards(twoLeaderCardsResponse.getLeaderCards());

                    if(message.getPlayerIndex()==ID) {
                        System.out.println("RICEVUTO TWO LEADERCARD RESPONSE MESSAGE, ORA DI SCEGLIERE RISORSE");

                        InitialResourcesMessage message1 = new InitialResourcesMessage();
                        message1.setPlayerIndex(ID);
                        switch (ID) {
                            case 0:
                                System.out.println("SEI IL PRIMO, NIENTE RISORSE\n Waiting for other players...");
                                break;
                            case 1, 2:
                                String c = "a";
                                while (!c.equalsIgnoreCase("P") && !c.equalsIgnoreCase("B") && !c.equalsIgnoreCase("G") && !c.equalsIgnoreCase("Y")) {
                                    if (ID == 1)
                                        System.out.println("SEI IL SECONDO, HAI 1 RISORSA A SCELTA, SCEGLI TRA: SERVANT[P], SHIELD[B], STONE[G], COIN [Y]");
                                    else
                                        System.out.println("SEI IL TERZO, TI BECCHI 1 PUNTO FEDE E HAI 1 RISORSA A SCELTA, SCEGLI TRA: SERVANT[P], SHIELD[B], STONE[G], COIN [Y]");
                                    c = stdin.next();
                                }
                                switch (c) {
                                    case "Y", "y" -> message1.setColorMarble1(MarketMarble.ColorMarble.YELLOW);
                                    case "B", "b" -> message1.setColorMarble1(MarketMarble.ColorMarble.BLUE);
                                    case "G", "g" -> message1.setColorMarble1(MarketMarble.ColorMarble.GREY);
                                    case "P", "p" -> message1.setColorMarble1(MarketMarble.ColorMarble.PURPLE);
                                    default -> System.out.println("C vale:" + c);
                                }
                                int a = 5;
                                while (a < 0 || a > 2) {
                                    System.out.println(" Scegli la riga in cui posizionarla [0-2]");
                                    a = stdin.nextInt();
                                    if(a < 0 || a > 2)
                                        System.out.println("Indice sbagliato");
                                }
                                message1.setRow1(a);
                                break;
                            case 3:
                                c = "a";
                                while (!c.equalsIgnoreCase("P") && !c.equalsIgnoreCase("B") && !c.equalsIgnoreCase("G") && !c.equalsIgnoreCase("Y")) {
                                    System.out.println("SEI IL QUARTO, HAI 2 RISORSA A SCELTA, SCEGLI LA PRIMA TRA: SERVANT[P], SHIELD[B], STONE[G], COIN [Y]");
                                    c = stdin.next();
                                }
                                switch (c) {
                                    case "Y", "y" -> message1.setColorMarble1(MarketMarble.ColorMarble.YELLOW);
                                    case "B", "b" -> message1.setColorMarble1(MarketMarble.ColorMarble.BLUE);
                                    case "G", "g" -> message1.setColorMarble1(MarketMarble.ColorMarble.GREY);
                                    case "P", "p" -> message1.setColorMarble1(MarketMarble.ColorMarble.PURPLE);
                                }
                                a = 3;
                                while (a < 0 || a > 2) {
                                    System.out.println(" Scegli la riga in cui posizionarla [0-2] 1");
                                    a = stdin.nextInt();
                                    if(a < 0 || a > 2)
                                        System.out.println("Indice Sbagliato");
                                }
                                message1.setRow1(a);
                                int i = 0;
                                while (i == 0) {
                                    c="a";
                                    while (!c.equalsIgnoreCase("P") && !c.equalsIgnoreCase("B") && !c.equalsIgnoreCase("G") && !c.equalsIgnoreCase("Y")) {
                                        System.out.println("SCEGLI LA SECONDA TRA: SERVANT[P], SHIELD[B], STONE[G], COIN [Y]");
                                        c = stdin.next();
                                    }
                                    switch (c) {
                                        case "Y", "y" -> message1.setColorMarble2(MarketMarble.ColorMarble.YELLOW);
                                        case "B", "b" -> message1.setColorMarble2(MarketMarble.ColorMarble.BLUE);
                                        case "G", "g" -> message1.setColorMarble2(MarketMarble.ColorMarble.GREY);
                                        case "P", "p" -> message1.setColorMarble2(MarketMarble.ColorMarble.PURPLE);
                                    }
                                    int b = 3;
                                    while (b < 0 || b > 2) {
                                        System.out.println(" Scegli la riga in cui posizionarla [0-2] 2");
                                        b = stdin.nextInt();
                                        if (b < 0 || b > 2)
                                            System.out.println("HAI SELIZONATO RIGA SBAGLIATA");
                                    }


                                    if ((message1.getRow1() == b && (message1.getColorMarble1() != message1.getColorMarble2() || b == 0)) || (message1.getRow1() != b && message1.getColorMarble1() == message1.getColorMarble2())) {
                                        System.out.println("Combazione sbagliata, scegli di nuovo seconda risorsa");
                                    } else {
                                        message1.setRow2(b);
                                        i = 1;
                                    }
                                }
                        }
                        sendMessage(socketOut, message1);
                        break;
                    }
                    else
                        break;
                case ("initialResourcesSet"):
                    InitialResourcesSet initialResourcesSet=(InitialResourcesSet) message;
                    clientModel.getPlayerBoards().get(initialResourcesSet.getPlayerIndex()).getFaithTrackClient().setRedPosition(initialResourcesSet.getPosition());
                    clientModel.getPlayerBoards().get(initialResourcesSet.getPlayerIndex()).getWarehosueClient().setWarehouseRows(initialResourcesSet.getWarehouse().getRows());
                    boolean start = initialResourcesSet.getStart();
                    if(message.getPlayerIndex()==ID){

                    }
                    if (start){
                        if (ID == 0){
                            int i=0;
                            while(i>4 || i<1) {
                                MenuCli();
                                i = stdin.nextInt();
                                if (i > 4 || i < 1) {
                                    System.out.println("Inserisci un numero tra 1 e 4\n");
                                }
                                switch (i) {
                                    case 1:
                                        System.out.println("Di che giocatore vuoi vederle?\n");
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
                                                System.out.println("Inserisci un indice valido");
                                        }

                                        System.out.println(" ----STRONGBOX----\n" +
                                                "SHIELDS: " + clientModel.getPlayerBoards().get(i).getStrongBox().get(0) + "\n" +
                                                "STONES: " + clientModel.getPlayerBoards().get(i).getStrongBox().get(1) + "\n" +
                                                "SERVANTS: " + clientModel.getPlayerBoards().get(i).getStrongBox().get(2) + "\n" +
                                                "COINS: " + clientModel.getPlayerBoards().get(i).getStrongBox().get(3) + "\n\n");
                                        System.out.println(" ----WAREHOUSE----\n");
                                        int indexRow = 0;
                                        for (WarehouseRow r : clientModel.getPlayerBoards().get(i).getWarehosueClient().getWarehouseRows()
                                        ) {
                                            if(r.getMarbles()!=null && r.getMarbles().size()!=0)
                                            System.out.println("ROW " + indexRow + ":" +r.getMarbles().size() + r.getMarbles().get(0).getColorMarble());
                                            else
                                            System.out.println("ROW " + indexRow + "; empty");
                                            indexRow++;
                                        }
                                        System.out.println("-------FAITHTRACK--------");
                                        for (int a = 0; a < 24; a++) {
                                            if (clientModel.getPlayerBoards().get(i).getFaithTrackClient().getRedPosition() == a)
                                                System.out.print("[ X ]");
                                            else
                                                System.out.print("[ ]");
                                        }
                                        System.out.println("\n POPE FAVORS 1:" + clientModel.getPlayerBoards().get(i).getFaithTrackClient().getPopeFavors().get(0));
                                        System.out.println("\n POPE FAVORS 2:" + clientModel.getPlayerBoards().get(i).getFaithTrackClient().getPopeFavors().get(1));
                                        System.out.println("\n POPE FAVORS 1:" + clientModel.getPlayerBoards().get(i).getFaithTrackClient().getPopeFavors().get(2) + "\n\n");

                                        System.out.println("---------DEVELOPMENT CARDS--------");
                                        for (DevelopmentCard d : clientModel.getPlayerBoards().get(i).getDevSlotClient()
                                        ) {
                                            //Creare metodo SHOWDEVELOPMENTCARD, e stampare i vari contatori
                                        }
                                        System.out.println("ID VALE: "+ID);

                                        if (index == ID) {
                                            System.out.println("----- LEADERCARDS -----");
                                            for (LeaderCard l : clientModel.getPlayerBoards().get(i).getLeaderCards()
                                            ) {
                                                userInterface.ShowCard(l);
                                                System.out.println("------------------");

                                            }
                                        }
                                            System.out.println("------ ACTIVE LEADERCARDS -----");
                                            for (LeaderCard l : clientModel.getPlayerBoards().get(i).getLeaderCards()
                                            ) {
                                                if (l.isActivate())
                                                    userInterface.ShowCard(l);
                                                System.out.println("------------------");
                                            }

                                        System.out.println("\n ");

                                        break;
                                    case 2:
                                        break;
                                    case 3:
                                        break;
                                    case 4:
                                        break;
                                }
                                i=0;
                            }

                        }
                        else {
                            System.out.println("non è il tuo turno");
                        }

                    }

        }
    }
    public void MenuCli(){
        System.out.println("----------------Menù------------" +
            "\n [1] Visualizza plancia giocatore." +
            "\n [2] Muovi risorse." +
            "\n [3] Azione" +
            "\n [4] Azione Leader");
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

