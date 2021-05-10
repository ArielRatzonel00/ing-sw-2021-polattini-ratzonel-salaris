package it.polimi.ingsw.View;

import it.polimi.ingsw.Model.Player;
import it.polimi.ingsw.Observer.Observable;

import java.io.IOException;

public abstract class View extends Observable<PlayerAction> implements Observer<Message>{
    private Player player;
    protected View(Player player){this.player = player};

    protected Player getPlayer() {
        return player;
    }
    protected abstract void showMessage(Object message);
    void

} {

    public void run() throws IOException;
}
