package it.polimi.ingsw.Network.Client;

import java.io.IOException;

public class ClientMain {

    public static void main(String[] args){
        if(args.length>0 && args[0].equalsIgnoreCase("CLI") || true){ // ||True l'ho messo ora solo perchè almeno per
                                                                                //ora parte sempre con la CLI
            LineClient client = new LineClient("127.0.0.1", 1337);
            try{
                client.startClient();
            }catch (IOException e){
                System.err.println(e.getMessage());
            }
        }
        else{
            //Application.launch(Gui.class);
        }
    }

}