package it.polimi.ingsw.Network.Client;

import java.io.IOException;

public class ClientMain {
        private static boolean GUI=true;

        public static void main (String[]args){
            if(true)
                GUI=false;

        Client client = new Client("127.0.0.1", 1336);
        try {
            client.run();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

}

