package it.polimi.ingsw.Network.Server;

import it.polimi.ingsw.Model.LeaderCard.LeaderCard;
import it.polimi.ingsw.Model.Player;
import it.polimi.ingsw.Network.Messages.*;
import it.polimi.ingsw.Observer.Observer;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class SocketClientConnection extends Messanger implements Runnable, Observer{
    private Socket socket;
    protected ObjectOutputStream out;
    private ObjectInputStream in;
    private Server server;
    boolean startGame;
    int ID;
    private Player player;

    public Socket getSocket() {
        return socket;
    }
    private String name;
    private VirtualView virtualView;

    public SocketClientConnection(Socket socket, Server server, int ID) {
        this.socket = socket;
        this.server = server;
        this.ID=ID;
    }
    public synchronized void send(Object message) {
        try {
            out.reset();
            out.writeObject(message);
            out.flush();
        } catch(IOException e){
            System.err.println(e.getMessage());
        }
    }
    public void addVirtualView(VirtualView vv){
        virtualView=vv;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }

    public ObjectOutputStream getOut() {
        return out;
    }

    @Override
    public void run(){
            Boolean multiPlayer=false;

            try{
                in = new ObjectInputStream(socket.getInputStream());
                out = new ObjectOutputStream(socket.getOutputStream());
                server.handleConnections(this);

                SocketMessage message=(SocketMessage) in.readObject();
                receiveMessage(message);
                //virtualView.getGameManager().setA(a);
                while(!message.getID().equalsIgnoreCase("Fine")) {
                    message = (SocketMessage) in.readObject();
                    receiveMessage(message);
                }
                while(true){
                    Message playerMessage=(Message) in.readObject();
                    receiveMessageFromPlayer(playerMessage);
                }

            } catch (IOException | NoSuchElementException | ClassNotFoundException e) {
                System.err.println("Error!" + e.getMessage());
            }finally{

                try {
                    socket.close();
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }

    @Override
    public void update(Object message, int codice) {
        ArrayList<LeaderCard> L = (ArrayList<LeaderCard>) message;
        if (codice == 0){
            send("These are the 4 leader cards assigned to you, select two of them to discard by passing the number (0-3");
            for (LeaderCard l : L){
                send(l.StampaCarta());
            }
        }

    }

  /*  @Override
    public void updateTest(Message message) throws IOException {
    }
*/
    @Override
    public void receiveMessage(SocketMessage message) throws IOException {
        switch (message.getID()){
            case "newMulti":
                name= message.getSender();
                player=new Player(name);
                if(message.getValue()==0) {
                    System.out.println("singleplayer chosen, start the game...");
                    server.handleNewPlayer(false, message.getSender(),this);
                }
                else {
                    System.out.println("multiplayer chosen, check lobby...");
                    server.handleNewPlayer(true, name,this);
                    //sendMessage(getOut(),new SocketMessage("waiting",0,Collections.singletonList(name),"server"));
                }
                break;
            case "numberOfPlayersReply":
                server.setNextGameNPlayers(message.getValue());
                break;
            case "Fine":
                break;
            default:
                System.out.println("errore nell'id del messaggio");
                break;

        }
    }
    public void receiveMessageFromPlayer(Message message){
        switch (message.getTypeOfMessage()){
            case "Four Leader Cards":
                System.out.println("Ricevuto FourLeaderCardsMessage");
                virtualView.notifyObserver(obs->obs.updateAssignFourLeaderCards((FourLeaderCardsMessage) message));
                //virtualView.AssignFourLeaderCard((FourLeaderCardsMessage) message);
                break;

            case "DiscardInitialLeaderCardsMessage":
                System.out.println("Ricevuto DiscardInitialLeaderCardsMessage");
               virtualView.notifyObserver(obs->obs.updateDiscardLeaderCards((DiscardInitialLeaderCardsMessage)message));
               break;

            case "InitialResourcesMessage":
                System.out.println("Ricevuto InitialResources");
                virtualView.notifyObserver(obs->obs.updateInitialResource((InitialResourcesMessage)message));
                break;
            case "MarketTrayActionMessage":
                virtualView.notifyObserver(obs->obs.updateMarketTrayAction((MarketTrayActionMessage) message));
                break;
            case "DealWithResourcesFromMarketTrayMessage":
                virtualView.notifyObserver(obs->obs.updateDealWithAResourceFromMarketTray((DealWithResourcesFromMarketTrayMessage) message));
            break;
            case "WantToBuyCardMessage":
                virtualView.notifyObserver(obs->obs.updateWantToBuyCard((WantToBuyCardMessage) message));
                break;
            case "MoveResourcesMessage":
                virtualView.notifyObserver(obs->obs.updateMoveResources((MoveResourcesMessage) message));
                break;
            case "WantActivateProductionMessage":
                virtualView.notifyObserver(obs->obs.updateWantActivateProduction((WantActivateProductionMessage) message));
                break;
            case "EndOfTurnMessage":
                virtualView.notifyObserver(obs->obs.updateEndOfTurn((EndOfTurnMessage) message));
                break;
            case "ActivateLeaderCardActionMessage":
                virtualView.notifyObserver(obs->obs.updateActivateLeaderCardAction((ActivateLeaderCardActionMessage) message));
                break;
            case "DiscardLeaderCardActionMessage":
                virtualView.notifyObserver(obs->obs.updateDiscardLeaderCardAction((DiscardLeaderCardActionMessage) message));
                break;
            case "BuyCardMessage":
                virtualView.notifyObserver(obs->obs.updateBuyCard((BuyCardMessage) message));
                break;
        }
    }

    public String getName() {
        return name;
    }

    public Player getPlayer() {
        return player;
    }

    public VirtualView getVirtualView() {
        return virtualView;
    }
}

