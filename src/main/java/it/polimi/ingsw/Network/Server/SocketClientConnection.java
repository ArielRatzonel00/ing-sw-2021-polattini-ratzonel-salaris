package it.polimi.ingsw.Network.Server;

import it.polimi.ingsw.Model.LeaderCard.LeaderCard;
import it.polimi.ingsw.Observer.Observer;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class SocketClientConnection implements Runnable, Observer{
    private Socket socket;
    private ObjectOutputStream out;
    private Server server;
    int ID;
    private VirtualView virtualView;

    public SocketClientConnection(Socket socket, Server server, int ID) {
        this.socket = socket;
        this.server = server;
        this.ID=ID;
    }
    private synchronized void send(Object message) {
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
    @Override
    public void run(){
            Scanner in;
            String name;
            Boolean multiPlayer=false;
            Lobby lobby = Lobby.getInstance();
            try{
                in = new Scanner(socket.getInputStream());
                out = new ObjectOutputStream(socket.getOutputStream());

                send("Welcome!\nWhat is your name?");
                String read = in.nextLine().toString();
                name = read;
                send("Do you want to play SinglePlayerGame(S) or MultiplayerGame(M)?");
                read = in.nextLine();

                if (read.equalsIgnoreCase("S")){
                    multiPlayer = false;
                }
                lobby.ManageNewPlayer(multiPlayer,name);

            } catch (IOException | NoSuchElementException e) {
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
}

