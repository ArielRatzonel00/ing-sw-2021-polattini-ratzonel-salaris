package it.polimi.ingsw.Observer;

import it.polimi.ingsw.Controller.GameManager;
import it.polimi.ingsw.Network.Messages.BuyCardMessage;
import it.polimi.ingsw.Network.Messages.FourLeaderCardsMessage;

import java.util.ArrayList;

public class VirtualViewObservable extends Observable<GameManager>{
    protected final ArrayList<GameManager> observers = new ArrayList<>();
    public void addObserver(GameManager gameManager){
        observers.add(gameManager);
    }

    public void AssignFourLeaderCard(FourLeaderCardsMessage fourLeaderCardsMessage){
        System.out.println("Dentro VVObserv");
        observers.get(0).updateAssignFourLeaderCards(fourLeaderCardsMessage);
    }
    public void notifyBuyCard(BuyCardMessage buyCardMessage) {
        observers.get(0).updateBuyCard(buyCardMessage);
    }
}
