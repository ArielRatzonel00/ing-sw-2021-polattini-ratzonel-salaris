package it.polimi.ingsw.Model;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SlotsBoard {
    private ArrayList<DevCardSlot> slots;


    // Create a SlotBoard with n (number that is set on the rules of the game) initial slots
    public SlotsBoard(int initialSlotNumber) throws NullPointerException{
        for(int i=0; i<initialSlotNumber;i++){
            slots.add(new DevCardSlot());
        }
    }

    //slots getter
    public ArrayList<DevCardSlot> getSlots() {
        return slots;
    }

    // method that adds a slot received as parameter (useful for LeaderCard)
    public void addSlot(DevCardSlot slot) {
        slots.add(slot);
    }

    //count total victory points from the slots
    public int countVictoryPoints(){
            int points=0;
        for (DevCardSlot a: slots) {
            points += a.countVictoryPoints();
        }
        return points;
    }

    //Get total number of DevelopmentCards on a player board, useful for the 7 cards ending game check
    public int getCardsQuantity(){
        int cards=0;
        for (DevCardSlot a: slots) {
            cards += a.getCards().size();
        }
        return cards;
    }

    // filterCount receive a level, a color or a pair of level and color and return the total number of DevelopmentCards in the SlotsBoard with that attributes

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