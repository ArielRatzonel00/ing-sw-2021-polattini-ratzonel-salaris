package it.polimi.ingsw.Model;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.stream.Collectors;

// Method that represents a single slots where the player adds the bought cards

public class DevCardSlot  {
    private ArrayList<DevelopmentCard> cards = new ArrayList<>();


    public void addCard(DevelopmentCard card){
        if (getTopCard() != null) {

            if (card.getLevel() == getTopCard().getLevel() + 1 && cards.size() < 3)
                cards.add(card);
        }
        else {
            cards.add(card);
        }
    } //Method that adds card above the top card if it's level is higher and the Slot isn't full



    public DevelopmentCard getTopCard() {
        if (cards.size() == 0){
            return null;
        }
        else {
            return (cards.get(cards.size() - 1));
        }
    } // Method that returns the TopCard of the slot



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

    // Methods that returns the number of card that respects the parameter (the level or the color)

}
