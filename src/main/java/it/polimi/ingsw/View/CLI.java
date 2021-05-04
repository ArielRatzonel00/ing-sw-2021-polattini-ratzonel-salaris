package it.polimi.ingsw.View;

import it.polimi.ingsw.Network.Client.Client;
import it.polimi.ingsw.Network.Client.ClientController;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class CLI extends ObservableView implements View{
    ClientController cLientController= new ClientController(this);
    private String nickname;
    private Boolean singleMulti=false; //False represent singlePlayer, True represent Multiplayer
    Scanner stdin = new Scanner(System.in);

    @Override
    public void init() throws IOException {
        System.out.println("\n" +
                "\t \uD835\uDD44\uD835\uDD52\uD835\uDD56\uD835\uDD64\uD835\uDD65\uD835\uDD63\uD835\uDD5A \uD835\uDD55\uD835\uDD56\uD835\uDD5D ℝ\uD835\uDD5A\uD835\uDD5F\uD835\uDD52\uD835\uDD64\uD835\uDD54\uD835\uDD5A\uD835\uDD5E\uD835\uDD56\uD835\uDD5F\uD835\uDD65\uD835\uDD60 \n");

        System.out.println("choose nickname:");
        nickname =stdin.nextLine();
        System.out.println("Welcome "+ nickname +", would you play SinglePlayer(s) or MultiPlayer(m)?");
        if(stdin.nextLine().equalsIgnoreCase("m") || stdin.nextLine().equalsIgnoreCase("multiplayer"))
            singleMulti=true;
        cLientController.updateInit(nickname,singleMulti);
    }
}
