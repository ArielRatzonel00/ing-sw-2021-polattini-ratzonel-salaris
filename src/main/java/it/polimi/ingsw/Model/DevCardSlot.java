package it.polimi.ingsw.Model;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.stream.Collectors;

public class DevCardSlot {
    private ArrayList<DevelopmentCard> cards;

    //add card above the top card if its level is higher
    public void addCard(DevelopmentCard card){
        if (card.getLevel() > getTopCard().getLevel())
            cards.add(card);
    }

    //get the "active" card, the one on top of the slot
    public DevelopmentCard getTopCard(){
        return (cards.get(cards.size() - 1));
    }

    //Count the total victory points of the cards in the slot
    public int countVictoryPoints(){
        int points=0;
        for (DevelopmentCard a: cards ){
            points+=a.getVictoryPoints();
        }
        return points;
    }

    //return the array of cards
    public ArrayList<DevelopmentCard> getCards(){
        return cards;
    }

    public int filterCount(int level){
        List<DevelopmentCard> cardsLevelN = cards.stream().filter(c->c.getLevel()==level).collect(Collectors.toList());
        return cardsLevelN.size();
    }
    public int filterCount(DevelopmentCard.colorCard color){
        List<DevelopmentCard> cardsLevelN = cards.stream().filter(c->c.getColor()==color).collect(Collectors.toList());
        return cardsLevelN.size();
    }
    public int filterCount(DevelopmentCard.colorCard color, int level){
        List<DevelopmentCard> cardsLevelN = cards.stream().filter(c->((c.getColor()==color)&&(c.getLevel()==level))).collect(Collectors.toList());
        return cardsLevelN.size();
    }

}
