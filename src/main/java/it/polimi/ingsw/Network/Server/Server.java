package it.polimi.ingsw.Network.Server;

import it.polimi.ingsw.Controller.GameManager;
import it.polimi.ingsw.Model.Model;
import it.polimi.ingsw.Model.MultipleyerFaithTrack;
import it.polimi.ingsw.Model.Player;
import it.polimi.ingsw.Model.SinglePlayerFaithTrack;
import it.polimi.ingsw.Network.Messages.Message;
import it.polimi.ingsw.Network.Messages.SocketMessage;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    private int port;
    private int nextID=0;
    private ArrayList<SocketClientConnection> inGameConnections;
    private ArrayList<SocketClientConnection> waitingConnections;
    private ArrayList<VirtualView> virtualViews;
    private GameManager GameManager;
    private Model Model;
    private Player player;
    private List<Player> players = new ArrayList<>();
    private List<SocketClientConnection> temp=new ArrayList<>();



    ServerSocket serverSocket;
    ExecutorService executor = Executors.newCachedThreadPool();
    private int nextGameNPlayers;


    public Server(int port) throws IOException {
        this.port = port;
        this.serverSocket = new ServerSocket(port);
        waitingConnections=new ArrayList<>();
        inGameConnections=new ArrayList<>();
        virtualViews =new ArrayList<>();
        Model=new Model();
        GameManager=new GameManager(Model);
    }
    public void handleConnections(SocketClientConnection conn) throws IOException {
        conn.sendMessage(conn.getOut(),new SocketMessage("connected",0,null,"server"));

    }

    public void run() throws IOException {
        while(true) {
            Socket socket = serverSocket.accept(); //Correggere assegnazione ID connection
            SocketClientConnection socketConnection = new SocketClientConnection(socket, this, nextID);
            nextID++;
            VirtualView newVirtualView = new VirtualView(socketConnection);
            virtualViews.add(newVirtualView);
            newVirtualView.setGameManager(GameManager);
            socketConnection.addVirtualView(newVirtualView);
            Model.addObserver(newVirtualView);
            executor.submit(socketConnection);
            System.out.println("Connessione effettuata con ID " + nextID);
        }
    }

    public synchronized boolean handleNewPlayer(boolean multiplayer, String name, SocketClientConnection socket) throws IOException { //return true se è il primo giocatore, se no false

        //Singleplayer game selected
        if (multiplayer == false){
            player = new Player(name, new SinglePlayerFaithTrack());
            return false;
        }

        //Multiplayer Game Selected
        else {
            player = new Player(name, new MultipleyerFaithTrack());

            //If player is not the first to get in
            if(waitingConnections!=null && waitingConnections.size()!=0){
                waitingConnections.add(socket);
                System.out.println(name+" aggiunto alla lista d'attesa, ci sono ora "+waitingConnections.size()+" Giocatori in attesa");
                //if the Lobby is full, time to start the game
                if(waitingConnections.size()>=nextGameNPlayers && nextGameNPlayers!=0){
                    System.out.println("Numero di giocatori raggiunto("+nextGameNPlayers+"), inizio partita");
                    for (int i=0; i<nextGameNPlayers;i++){
                        temp.add(waitingConnections.get(waitingConnections.size()-1));
                        waitingConnections.remove(waitingConnections.size()-1);
                    }
                    startGame(temp);
                }

                return false;
            }

            //If Player IS the first one to get in the Lobby
            else{
                waitingConnections.add(socket);
                System.out.println(name+" aggiunto alla lista d'attesa");
                System.out.println("first connection, let's ask how many players");
                socket.sendMessage(socket.getOut(), new SocketMessage("numberOfPlayers", 0, Collections.singletonList(name), "server"));
                return true;
            }
        }
    }


    public boolean setNextGameNPlayers(int nextGameNPlayers) throws IOException {
        this.nextGameNPlayers = nextGameNPlayers;
        System.out.println("Numero di giocatori assegnato: "+nextGameNPlayers);

        //If there are already enough players waiting, return True (Start Game)
        if(waitingConnections.size()>=nextGameNPlayers) {
            System.out.println("Numero di giocatori raggiunto(" + nextGameNPlayers + "), inizio partita");
            for (int i=0; i<nextGameNPlayers;i++){
                temp.add(waitingConnections.get(waitingConnections.size()-1));
                waitingConnections.remove(waitingConnections.size()-1);
            }
            startGame(temp);
            return true;
        }
        return false;
    }

    public synchronized void startGame(List<SocketClientConnection> connections) throws IOException {
        List<String> names=new ArrayList<>();
        System.out.println("STARTGAME CON "+connections.size()+" PERSONE");

        for (SocketClientConnection conn:connections
             ) {
            names.add(conn.getName());
            inGameConnections.add(conn);
            conn.sendMessage(conn.getOut(),new SocketMessage("GameStarted",0,null,"server"));
        }
        connections.removeAll(connections);
    }

}
