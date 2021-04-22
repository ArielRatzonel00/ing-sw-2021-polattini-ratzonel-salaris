package network.client;

        import javafx.application.Application;
        import view.cli.Cli;
        import view.gui.Gui;

public class ClientMain {
    public static void main(String[] args) {
        if (args.length > 0 && args[0].equalsIgnoreCase("CLI")) {
            new Cli().start();
        } else {
            Application.launch(Gui.class);
        }
    }
}

/*
package it.polimi.ingsw.Network.Client;

import java.io.IOException;

public class ClientMain {

    public static void main(String[] args){
        LineClient client = new LineClient("127.0.0.1", 1337);
        try{
            client.startClient();
        }catch (IOException e){
            System.err.println(e.getMessage());
        }
    }

}
 */