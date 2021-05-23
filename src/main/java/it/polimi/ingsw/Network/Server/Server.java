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
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    private int port;
    private int nextID=0;
    private ArrayList<SocketClientConnection> connections;
    private ArrayList<SocketClientConnection> waitingConnections;
    private ArrayList<VirtualView> virtualViews;
    private GameManager GameManager;
    private Model Model;
    private Player player;
    private ArrayList<Player> players = new ArrayList<>();


    ServerSocket serverSocket;
    ExecutorService executor = Executors.newCachedThreadPool();
    private int nextGameNPlayers;


    public Server(int port) throws IOException {
        this.port = port;
        this.serverSocket = new ServerSocket(port);
        connections=new ArrayList<>();
        waitingConnections=new ArrayList<>();
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
            waitingConnections.add(socketConnection);
            VirtualView newVirtualView = new VirtualView(socketConnection);
            virtualViews.add(newVirtualView);
            newVirtualView.setGameManager(GameManager);
            socketConnection.addVirtualView(newVirtualView);
            Model.addObserver(newVirtualView);
            executor.submit(socketConnection);
            System.out.println("Connessione effettuata con ID " + nextID);
        }
    }

    public synchronized boolean handleNewPlayer(boolean multiplayer, String name, SocketClientConnection socket){ //return true se è il primo giocatore, se no false

        //Singleplayer game selected
        if (multiplayer == false){
            player = new Player(name, new SinglePlayerFaithTrack());
            return false;
        }

        //Multiplayer Game Selected
        else {
            player = new Player(name, new MultipleyerFaithTrack());

            //If player is not the first to get in
            if(players!=null && players.size()!=0){
                players.add(player);
                System.out.println(name+" aggiunto alla lista d'attesa, ci sono ora "+players.size()+" Giocatori in attesa");
                //if the Lobby is full, time to start the game
                if(players.size()>=nextGameNPlayers && nextGameNPlayers!=0)
                    System.out.println("Numero di giocatori raggiunto("+nextGameNPlayers+"), inizio partita");
                List<Player> temp=new ArrayList<Player>();
                for (int i=0; i<nextGameNPlayers;i++){
                    temp.add(players.get(players.size()-1));
                    players.remove(players.size()-1);
                }
                startGame(temp);
                return false;
            }

            //If Player IS the first one to get in the Lobby
            else{
                players.add(player);
                System.out.println(name+" aggiunto alla lista d'attesa");
                return true;
            }
        }
    }


    public void setNextGameNPlayers(int nextGameNPlayers) {
        this.nextGameNPlayers = nextGameNPlayers;
        System.out.println("Numero di giocatori assegnato: "+nextGameNPlayers);
        if(players.size()>=nextGameNPlayers)
            System.out.println("Numero di giocatori raggiunto("+nextGameNPlayers+"), inizio partita");
    }

    public synchronized void startGame(List<Player> players){

    }
}
