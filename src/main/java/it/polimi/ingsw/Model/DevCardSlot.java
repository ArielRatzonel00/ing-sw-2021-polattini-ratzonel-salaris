package it.polimi.ingsw.Model;

import java.util.ArrayList;

public class DevCardSlot {
    private ArrayList<DevelopmentCard> cards;

    public void addCard(DevelopmentCard card){
        if (card.getLevel() > getTopCard().getLevel())
            cards.add(card);
    }
    public DevelopmentCard getTopCard(){
        return (cards.get(cards.size() - 1));
    }

}
