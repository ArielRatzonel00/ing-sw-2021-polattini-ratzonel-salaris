package it.polimi.ingsw.View;

import it.polimi.ingsw.Model.Player;
import it.polimi.ingsw.Observer.Observable;

import java.io.IOException;

public abstract class View {
    private Player player;
    public View(Player player){this.player = player;}

    public Player getPlayer() {
        return player;
    }
   // protected abstract void showMessage(String message);


}

