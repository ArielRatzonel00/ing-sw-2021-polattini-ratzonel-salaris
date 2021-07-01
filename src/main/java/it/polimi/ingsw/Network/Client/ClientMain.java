/*package it.polimi.ingsw.Network.Client;

import it.polimi.ingsw.View.Cli;

import java.io.IOException;

public class ClientMain {
        private static boolean GUI=true;

        public static void main (String[]args){
            if(true)
                GUI=false;


        try {
            Cli cli=new Cli();
            Client client = new Client("localhost", 1334, cli);
            //cli.addObserver(client);
            cli.setCmodel(client.getClientModel());
            client.run();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}*/

