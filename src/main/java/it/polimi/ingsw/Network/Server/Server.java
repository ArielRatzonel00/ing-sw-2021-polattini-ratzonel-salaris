package it.polimi.ingsw.Network.Server;

import it.polimi.ingsw.Controller.SinglePlayerManager;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    private int port;

    ServerSocket serverSocket;
    ExecutorService executor = Executors.newCachedThreadPool();


    public Server(int port) throws IOException {
        this.port = port;
        this.serverSocket = new ServerSocket(port);

    }
    public void run() throws IOException {
        Socket socket = serverSocket.accept();
        SocketClientConnection socketConnection = new SocketClientConnection(socket, this);
        executor.submit(socketConnection);
    }

}
