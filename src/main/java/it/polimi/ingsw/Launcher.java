package it.polimi.ingsw;

import it.polimi.ingsw.Network.Client.Client;
import it.polimi.ingsw.Network.Server.Server;
import it.polimi.ingsw.View.Cli;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class Launcher
{
    public static void main( String[] args )
    {
        if(args.length == 0){
            //no args => Client
            try {
                Cli cli=new Cli();
                Client client = new Client("127.0.0.1", 1334, cli);
                //cli.addObserver(client);
                cli.setCmodel(client.getClientModel());
                client.run();
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }

        }else if(args.length == 1){
            Server server;
            try {
                server = new Server(1334);
                server.run();
            } catch (IOException e) {
                System.err.println("Impossible to initialize the server: " + e.getMessage() + "!");
            }
            }
    }
}
