package it.polimi.ingsw.Network.Server;

import it.polimi.ingsw.Model.LeaderCard.LeaderCard;
import it.polimi.ingsw.Network.Messages.Message;
import it.polimi.ingsw.Network.Messages.Messanger;
import it.polimi.ingsw.Network.Messages.SocketMessage;
import it.polimi.ingsw.Observer.Observer;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class SocketClientConnection extends Messanger implements Runnable, Observer{
    private Socket socket;
    protected ObjectOutputStream out;
    private ObjectInputStream in;
    private Server server;
    boolean first;
    int ID;

    public Socket getSocket() {
        return socket;
    }

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

    public ObjectOutputStream getOut() {
        return out;
    }

    @Override
    public void run(){
            String name;
            Boolean multiPlayer=false;

            try{
                in = new ObjectInputStream(socket.getInputStream());
                out = new ObjectOutputStream(socket.getOutputStream());
                server.handleConnections(this);

                SocketMessage message=(SocketMessage) in.readObject();
                receiveMessage(message);
                //virtualView.getGameManager().setA(a);
                while(true) {
                    SocketMessage messaggio = (SocketMessage) in.readObject();
                    receiveMessage(messaggio);
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
                String sender= message.getSender();
                if(message.getValue()==0) {
                    System.out.println("singleplayer chosen, start the game...");
                    server.handleNewPlayer(false, message.getSender(),this);
                }
                else {
                    System.out.println("multiplayer chosen, check lobby...");
                    server.handleNewPlayer(true, sender,this);
                    if(first) {//CASO IN CUI SI E' il primo giocatore
                        System.out.println("first connection, let's ask how many players");
                        sendMessage(getOut(), new SocketMessage("numberOfPlayers", 0, Collections.singletonList(sender), "server"));
                    }
                    sendMessage(getOut(),new SocketMessage("waiting",0,Collections.singletonList(sender),"server"));
                }
                break;
            case "numberOfPlayersReply":
                server.setNextGameNPlayers(message.getValue());
                break;
            default:
                System.out.println("errore nell'id del messaggio");
                break;

        }
    }
}

