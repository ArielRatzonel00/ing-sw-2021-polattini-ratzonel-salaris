package it.polimi.ingsw.Network.Client;

import it.polimi.ingsw.View.ObservableView;
import it.polimi.ingsw.View.View;
import it.polimi.ingsw.View.ViewObserver;

import java.util.Observable;
import java.util.Observer;

public class CLientController implements Observer, ViewObserver {
    private String nickname;
    private Boolean singleMulti;
    View view;

    public CLientController(View view){
        this.view=view;
    }

    @Override
    public void onUpdateNickname(String nickname) {
        this.nickname=nickname;
    }

    @Override
    public void onUpdateSingleMulti(Boolean singleMulti) {
        this.singleMulti=singleMulti;
    }

    @Override
    public void update(Observable o, Object arg) {
    }
}
