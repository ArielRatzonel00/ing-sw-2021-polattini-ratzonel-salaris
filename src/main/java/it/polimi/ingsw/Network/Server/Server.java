package it.polimi.ingsw.Network.Server;

import it.polimi.ingsw.Controller.GameManager;
import it.polimi.ingsw.Model.Model;
import it.polimi.ingsw.Network.Messages.Message;
import it.polimi.ingsw.Network.Messages.SocketMessage;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    private int port;
    private int nextID=0;
    private ArrayList<SocketClientConnection> connections;
    private ArrayList<VirtualView> virtualViews;
    private GameManager GameManager;
    private Model Model;

    ServerSocket serverSocket;
    ExecutorService executor = Executors.newCachedThreadPool();


    public Server(int port) throws IOException {
        this.port = port;
        this.serverSocket = new ServerSocket(port);
        connections=new ArrayList<>();
        virtualViews =new ArrayList<>();
        Model=new Model();
        GameManager=new GameManager(Model);

    }
    public void handleConnections(SocketClientConnection conn) throws IOException {
        if(nextID==0){
            conn.sendMessage(conn.getOut(),new SocketMessage("id:1",null));
        }
    }
    public void run() throws IOException {
        Socket socket = serverSocket.accept(); //Correggere assegnazione ID connection
        SocketClientConnection socketConnection = new SocketClientConnection(socket, this,nextID);
        nextID++;
        connections.add(socketConnection);

        VirtualView newVirtualView= new VirtualView(socketConnection);
        virtualViews.add(newVirtualView);
        newVirtualView.setGameManager(GameManager);
        socketConnection.addVirtualView(newVirtualView);
        Model.addObserver(newVirtualView);

        executor.submit(socketConnection);
    }

}
