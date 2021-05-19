package it.polimi.ingsw.Network.Server;

import it.polimi.ingsw.Controller.MultiplayerGameManager;
import it.polimi.ingsw.Controller.SinglePlayerManager;
import it.polimi.ingsw.Model.MultiplayerGame;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    private int port;
    private int nextID=0;
    private ArrayList<SocketClientConnection> connections;
    private ArrayList<VirtualView> VView;
    private MultiplayerGameManager multiplayerGameManager;
    private MultiplayerGame multiplayerGame;

    ServerSocket serverSocket;
    ExecutorService executor = Executors.newCachedThreadPool();


    public Server(int port) throws IOException {
        this.port = port;
        this.serverSocket = new ServerSocket(port);
        connections=new ArrayList<>();
        VView=new ArrayList<>();
        multiplayerGameManager=new MultiplayerGameManager();
    }
    public void run() throws IOException {
        Socket socket = serverSocket.accept();
        SocketClientConnection socketConnection = new SocketClientConnection(socket, this,nextID);
        connections.add(socketConnection);
        nextID++;
        VView.add(new VirtualView(socketConnection));
        executor.submit(socketConnection);
    }

}
