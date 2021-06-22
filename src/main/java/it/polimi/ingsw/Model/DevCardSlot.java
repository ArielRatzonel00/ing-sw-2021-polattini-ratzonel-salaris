package it.polimi.ingsw.Model;

import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.stream.Collectors;


public class DevCardSlot implements Serializable {
    private ArrayList<DevelopmentCard> cards = new ArrayList<>();


    public void addCard(DevelopmentCard card){
        if(CanBeAddedInTheSlot(card)) {
            cards.add(card);
        }
    }

    public boolean CanBeAddedInTheSlot(DevelopmentCard card){
        if (getTopCard() != null) {
            if (card.getLevel() == getTopCard().getLevel() + 1 && cards.size() < 3)
                return true;
            else return false;
        } else {
            return true;
        }
    }

    public DevelopmentCard getTopCard() {
        if (cards.size() == 0){
            return null;
        }
        else {
            return (cards.get(cards.size() - 1));
        }
    }

    /**
     * @return the sum of the victory points of the cards present in the slot
     */
    public int countVictoryPoints(){
        int points=0;
        for (DevelopmentCard a: cards ){
            points+=a.getVictoryPoints();
        }
        return points;
    }  // Method that returns the total victory points of the cards in the slot



    public ArrayList<DevelopmentCard> getCards(){
        return cards;
    } // Method that returns the array of cards


    /**
     * @param level level of the cards
     * @return the cards present in the slot that have the level selected
     */
    public int filterCount(int level){
        List<DevelopmentCard> cardsLevelN = cards.stream().filter(c->c.getLevel()==level).collect(Collectors.toList());
        return cardsLevelN.size();
    }

    /**
     * @param color color of the cards
     * @return the cards present in the slot that have the color selected
     */
    public int filterCount(DevelopmentCard.colorCard color){
        List<DevelopmentCard> cardsLevelN = cards.stream().filter(c->c.getColor()==color).collect(Collectors.toList());
        return cardsLevelN.size();
    }

    /**
     * @param color color of the cards
     * @param level level of the cards
     * @return the cards present in the slot that have the color and the level selected
     */
    public int filterCount(DevelopmentCard.colorCard color, int level){
        List<DevelopmentCard> cardsLevelN = cards.stream().filter(c->((c.getColor()==color)&&(c.getLevel()==level))).collect(Collectors.toList());
        return cardsLevelN.size();
    }

}
