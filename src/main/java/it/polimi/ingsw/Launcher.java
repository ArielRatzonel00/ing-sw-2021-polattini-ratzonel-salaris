package it.polimi.ingsw;

import it.polimi.ingsw.Network.Client.Client;
import it.polimi.ingsw.Network.Server.Server;
import it.polimi.ingsw.View.Cli;

import java.io.IOException;

/*public class Launcher
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

*/
public class Launcher
{
    public static void main( String[] args ) {
        if (args.length == 2) {
            if (args[0].equals("-server")) {
                //read the port
                int port = 0;
                try {
                    port = Integer.parseInt(args[1]);
                } catch (NumberFormatException e) {
                    System.out.println("The second argument must be a number !");
                    printHelp();
                    return;
                }
                if (port < 1024 || port > 65535) {
                    System.out.println("The port must be a number in range [1024, 65535] !");
                    printHelp();
                    return;
                }

                //run server
                Server server;

                try {
                    server = new Server(port);
                    server.run();
                    System.out.println(port);
                } catch (IOException e) {
                    System.err.println("Impossible to initialize the server: " + e.getMessage() + "!");
                }
            } else
                printHelp();
        }else if (args.length == 6) {
                if (args[0].equals("-cli")) {
                    //read the port
                    int port = 0;
                    try {
                        port = (Integer.parseInt(args[1]));
                    } catch (NumberFormatException e) {
                        System.out.println("The second argument must be a number !");
                        printHelp();
                        return;
                    }
                    if (port < 1024 || port > 65535) {
                        System.out.println("The port must be a number in range [1024, 65535] !");
                        printHelp();
                        return;
                    }

                    //read the IPv4
                    String ip = "192.168.1.241";

                    ip = (args[2].toString() + "." + args[3].toString() + "." + args[4].toString() + "." +args[5].toString());
                    System.out.println(ip);
                    String ipv4_regex = "(([0-1]?[0-9]{1,2}\\.)|(2[0-4][0-9]\\.)|(25[0-5]\\.)){3}(([0-1]?[0-9]{1,2})|(2[0-4][0-9])|(25[0-5]))";
                    if (!ip.matches(ipv4_regex)) {
                        System.out.println("Wrong IP format!");
                        printHelp();
                        return;
                    }
                    try {
                        Cli cli = new Cli();
                        Client client = new Client(ip, port, cli);
                        //cli.addObserver(client);
                        cli.setCmodel(client.getClientModel());
                        client.run();
                    } catch (IOException e) {
                        System.err.println(e.getMessage());
                    }
                } else
                    System.out.println("Primo ARG: "+ args[0]);
                    printHelp();
            } else
                System.out.println("ARGS: " + args.length);
            printHelp();
    }

    public static void printHelp(){
        System.out.println("******MASTERS OF RENAISSANCE LAUNCHER******");
        System.out.println("server - 2 arguments \"-server\" <number of port>");
        System.out.println("cli - 3 arguments \"-cli\" <number of port> <IPv4 address>");
    }
}


