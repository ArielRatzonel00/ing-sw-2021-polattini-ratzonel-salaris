package it.polimi.ingsw.Model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// class that represents the board of the slots. Every player has one SlotsBoard

public class SlotsBoard implements Serializable {
    private ArrayList<DevCardSlot> slots = new ArrayList<>();

    public SlotsBoard() throws NullPointerException{
        for(int i=0; i<3;i++){
            slots.add(new DevCardSlot());
        }
    } // The SlotsBoard has 3 slots

    public void setSlots(ArrayList<DevCardSlot> slots) {
        this.slots = slots;
    }

    public ArrayList<DevCardSlot> getSlots() {
        return slots;
    } // Method that returns the slots

    public int countVictoryPoints(){
        int points=0;
        for (DevCardSlot a: slots) {
            points += a.countVictoryPoints();
        }
        return points;
    } // Method that counts total victory points from the slots

    /**
     * @return the total cards that a player has, useful because if it is 7, the game ends
     */
    public int getCardsQuantity(){
        int cards=0;
        for (DevCardSlot a: slots) {
            cards += a.getCards().size();
        }
        return cards;
    }

    public int filterCount(int level){
        int total=0;
        for (DevCardSlot a: slots) {
            total += a.filterCount(level);
        }
        return total;
    }

    public int filterCount(DevelopmentCard.colorCard color){
        int total=0;
        for (DevCardSlot a: slots) {
            total += a.filterCount(color);
        }
        return total;
    }

    public int filterCount(DevelopmentCard.colorCard color, int level){
        int total=0;
        for (DevCardSlot a: slots) {
            total += a.filterCount(color,level);
        }
        return total;
    }
}