package it.polimi.ingsw.Network.Server;

import it.polimi.ingsw.Model.Player;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    private int port;
    private Lobby lobby = Lobby.getInstance();
    ServerSocket serverSocket;
    ExecutorService executor = Executors.newCachedThreadPool();
    private Map<String, ClientConnection> waitingConnection = new HashMap<>();
    private Map<ClientConnection, ClientConnection> playingConnection = new HashMap<>();

    public Server(int port) {
        this.port = port;
    }

    public synchronized void deregisterConnection(ClientConnection c) {
        ClientConnection opponent = playingConnection.get(c);
        if (opponent != null) {
            opponent.closeConnection();
        }
        playingConnection.remove(c);
        playingConnection.remove(opponent);
        Iterator<String> iterator = waitingConnection.keySet().iterator();
        while (iterator.hasNext()) {
            if (waitingConnection.get(iterator.next()) == c) {
                iterator.remove();
            }
        }
    }



    public void run() {
        while (true) {
            try {
                Socket newSocket = serverSocket.accept();
                SocketClientConnection socketConnection = new SocketClientConnection(newSocket, this);
                executor.submit(socketConnection);
            } catch (IOException e) {
                System.out.println("Connection Error!");
            }
        }
    }

}



















/*public synchronized void lobby(ClientConnection c, String name) {
        waitingConnection.put(name, c);
        if (waitingConnection.size() == 2) {
            List<String> keys = new ArrayList<>(waitingConnection.keySet());
            ClientConnection c1 = waitingConnection.get(keys.get(0));
            ClientConnection c2 = waitingConnection.get(keys.get(1));
            Player player1 = new Player(keys.get(0), Cell.X);
            Player player2 = new Player(keys.get(0), Cell.O);
            View player1View = new RemoteView(player1, keys.get(1), c1);
            View player2View = new RemoteView(player2, keys.get(0), c2);
            Model model = new Model();
            Controller controller = new Controller(model);
            model.addObserver(player1View);
            model.addObserver(player2View);
            player1View.addObserver(controller);
            player2View.addObserver(controller);
            playingConnection.put(c1, c2);
            playingConnection.put(c2, c1);
            waitingConnection.clear();

            c1.asyncSend(model.getBoardCopy());
            c2.asyncSend(model.getBoardCopy());
            if (model.isPlayerTurn(player1)) {
                c1.asyncSend(gameMessage.moveMessage);
                c2.asyncSend(gameMessage.waitMessage);
            } else {
                c2.asyncSend(gameMessage.moveMessage);
                c1.asyncSend(gameMessage.waitMessage);
            }
        }

    }

     */






    /*public void startServer() throws IOException{
        //It creates threads when necessary, otherwise it re-uses existing one when possible

        try{
            serverSocket = new ServerSocket(port);
        }catch (IOException e){
            System.err.println(e.getMessage()); //port not available
            return;
        }
        System.out.println("Server ready");

        while (true){
            try{
                Socket newsocket = serverSocket.accept();
                SocketClientConnection socketConnection = new SocketClientConnection(newsocket, this);
                executor.submit(socketConnection);
            }catch(IOException e){
                System.out.println("Conenction Error!");
            }
        }
        executor.shutdown();
        serverSocket.close();
    }

}
*/