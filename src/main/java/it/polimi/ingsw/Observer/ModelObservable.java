package it.polimi.ingsw.Observer;

import it.polimi.ingsw.Model.LeaderCard.LeaderCard;
import it.polimi.ingsw.Model.Model;
import it.polimi.ingsw.Model.Player;
import it.polimi.ingsw.Network.Messages.FourLeaderCardResponse;
import it.polimi.ingsw.Network.Server.VirtualView;

import java.util.ArrayList;
import java.util.List;

public class ModelObservable extends Observable<VirtualView> {
    private final List<VirtualView> observers = new ArrayList<>();
    public void addObserver(VirtualView observer){
        synchronized (observers) {
            observers.add(observer);
        }
    }
    public void notifyFourLeaderCards(int PlayerIndex, ArrayList<Player> players){
        FourLeaderCardResponse fourLeaderCardResponse = new FourLeaderCardResponse();
        fourLeaderCardResponse.setPlayerIndex(PlayerIndex);
        fourLeaderCardResponse.setPlayers(players);
        observers.get(0).updateFourLeaderCardsResponse(fourLeaderCardResponse);
    }

    /*protected void notify(T message, int code){
        synchronized (observers) {
            for(Observer<T> observer : observers){
                observer.update(message,code);
            }
        }
    }*/

}
