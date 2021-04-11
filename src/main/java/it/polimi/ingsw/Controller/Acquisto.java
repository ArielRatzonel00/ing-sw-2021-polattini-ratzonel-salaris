package it.polimi.ingsw.Controller;
import it.polimi.ingsw.Model.*;

public class Acquisto {
}
Slots playerSlot = new Slots();
DevelopmentCard currentCard = new DevelopmentCard();



void acquireCard(Player player, DevelopmentCard card, int n){
    int costo[];
playerSlot=player.getSlots();
currentCard=playerSlot.getCard1Top();
/*Casistiche:
topCard è null -> playerslot.setCardTop(card);
topCard è di livello 3 -> "SLOT NON SELEZIONABILE"

topCard è di livello 1 o 2 ->
    se card.getlevel == currentCard.getLevel +1
            costo=currentCard.getCost()
            creo un NuovoArray in cui sommo le risorse presenti in strongbox e in warehouse
            controllo se nuovoArray[i] >= di costo[i] per ogni i ->
                se si -> card diventa topcard e modifico lista dello slot
                se no -> "NON ABBASTANZA MATERIALE"
    se no -> "CONTROLLA MEGLIO IL LIVELLO!"
 */

}
