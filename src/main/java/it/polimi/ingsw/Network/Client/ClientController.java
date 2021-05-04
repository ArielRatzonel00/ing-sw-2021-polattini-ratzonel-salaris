package it.polimi.ingsw.Network.Client;

import it.polimi.ingsw.Model.Lobby;
import it.polimi.ingsw.Model.MultipleyerFaithTrack;
import it.polimi.ingsw.Model.Player;
import it.polimi.ingsw.View.View;
import it.polimi.ingsw.View.ViewObserver;

import java.util.Observable;
import java.util.Observer;

public class ClientController implements Observer, ViewObserver {
    private String nickname;
    private Boolean singleMulti;
    View view;
    Lobby gameLobby= Lobby.getInstance();

    public ClientController(View view){
        this.view=view;
    }


    //If the game is multiplayer check the "state" of Lobby and if there are other Players with same nickname
    @Override
    public void updateInit(String nickname,Boolean singleMulti) {
        this.singleMulti=singleMulti;
        if(singleMulti) {
            this.nickname = nickname;
            if(gameLobby.getPlayers().size()!=0) {
                for (Player a : gameLobby.getPlayers()) {
                    if (a.getNickname().equalsIgnoreCase(nickname)) {
                        //MESSAGGIO "ESISTE GIA' UN GIOCATORE CON QUESTO NICKNAME!
                        System.out.println("Questo nickname è già stato preso");
                        return;
                    }
                }
                gameLobby.getPlayers().add((new Player(nickname, new MultipleyerFaithTrack())));
                if (gameLobby.getPlayers().size() == gameLobby.getNextGameNPlayers()) {
                    //SERVER FA INIZIARE MULTIPLAYER GAME
                }
            }else{
                //SERVER CHIEDE DI IMPOSTARE NUMERO DI GIOCATORI
            }

        }else{
            //SERVER FA PARTIRE SINGLEPLAYER GAME
        }
    }


    @Override
    public void update(Observable o, Object arg) {
    }
}
