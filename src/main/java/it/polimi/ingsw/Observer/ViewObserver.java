package it.polimi.ingsw.Observer;

import java.io.IOException;
import java.net.Socket;

public interface ViewObserver {
    void updateOnline(boolean Online) throws IOException;
    void updateMultiplayer(boolean multiplayer) throws IOException;
    void updateNickname(String nickname);
    void updateNumberOfPlayers(int numberOfPlayers) throws IOException;
}
