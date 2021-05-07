package it.polimi.ingsw.View;

import java.io.IOException;
import java.util.Observer;

public interface ViewObserver extends Observer {
    void updateInit(String nickname,Boolean singleMulti) throws IOException;
}
