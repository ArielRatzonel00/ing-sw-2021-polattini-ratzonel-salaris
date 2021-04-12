package it.polimi.ingsw.Controller;
import it.polimi.ingsw.Model.*;


public class Acquisto {
}
Slots playerSlot = new Slots();
DevelopmentCard currentCard = new DevelopmentCard();



void acquireCard(Player player, DevelopmentCard card, int n, int resoucesFromStrongox[], int resourcesFromWarehouse[]){
    int selectedResources[4]=somma(resourcesFromWarehouse,resoucesFromStrongox);
    //controllo che player abbia effettivamente le risorse in strongbox e Warehouse.
playerSlot=player.getSlots();
if(n==1) {
    currentCard = playerSlot.getCard1Top();
    playerSlot.addSlot1(card);
}
if(n==2) {
    currentCard = playerSlot.getCard2Top(); //Da riguardare questa parte
    playerSlot.addSlot2(card);
}
if(n==3) {
    currentCard = playerSlot.getCard3Top();
    playerSlot.addSlot2(card);
}


}
