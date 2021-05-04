package it.polimi.ingsw.View;

import java.util.Observer;

public interface ViewObserver extends Observer {
    void onUpdateNickname(String nickname);
    void onUpdateSingleMulti(Boolean singleMulti);
}
