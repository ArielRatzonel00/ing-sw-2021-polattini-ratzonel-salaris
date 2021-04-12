package it.polimi.ingsw.Controller;
import it.polimi.ingsw.Model.*;

public class Acquisto {
}
Slots playerSlot = new Slots();
DevelopmentCard currentCard = new DevelopmentCard();



void acquireCard(Player player, DevelopmentCard card, int n){
    int costo[];
playerSlot=player.getSlots();
if(n==1) {
    currentCard = playerSlot.getCard1Top();
    playerSlot.setCard1();
}
if(n==2) {
    currentCard = playerSlot.getCard2Top(); //Da riguardare questa parte
    playerSlot.setCard1();
}
if(n==3) {
    currentCard = playerSlot.getCard3Top();
    playerSlot.setCard1();
}

/*Casistiche:
topCard è null -> playerslot.setCardTop(card); //slot N

topCard è di livello 3 -> "SLOT NON SELEZIONABILE"

topCard è di livello 1 o 2 ->
    se card.getlevel == currentCard.getLevel +1
            costo=currentCard.getCost()
            creo un NuovoArray in cui sommo le risorse presenti in strongbox e in warehouse
            controllo se nuovoArray[i] >= di costo[i] per ogni i ->
                se si -> card diventa topcard, modifica lista dello slot, set warehouse, set strongbox.
                se no -> "NON ABBASTANZA MATERIALE"
    se no -> "CONTROLLA MEGLIO IL LIVELLO!"
 */

}
