package it.polimi.ingsw.Model;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// class that represents the board of the slots. Every player has one SlotsBoard

public class SlotsBoard {
    private ArrayList<DevCardSlot> slots = new ArrayList<>();



    public SlotsBoard() throws NullPointerException{
        for(int i=0; i<3;i++){
            slots.add(new DevCardSlot());
        }
    } // The SlotsBoard has 3 slots


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

    public int getCardsQuantity(){
        int cards=0;
        for (DevCardSlot a: slots) {
            cards += a.getCards().size();
        }
        return cards;
    } // Method that gets total number of DevelopmentCards on a player board, useful for the 7 cards ending game check



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
    // Methods filterCount receive a level, a color or a pair of level and color and return the total number of DevelopmentCards in the SlotsBoard with that attributes


}