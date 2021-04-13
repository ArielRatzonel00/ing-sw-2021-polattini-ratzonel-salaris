package it.polimi.ingsw.Controller;

import it.polimi.ingsw.Model.DevelopmentCard;
import it.polimi.ingsw.Model.LeaderCard;
import it.polimi.ingsw.Model.Player;

public class LeaderCardController  {

    private Player player;
    public LeaderCardController(Player player) {
        this.player = player;
    }
//distribuisco 4 carte leader a ogni giocatore

    //faccio scegliere 2 leader card a ogni giocatore tra le 4 pescate precedentemente
    public LeaderCard[] ChooseLeaderCards(LeaderCard[] LeadArray) {
        //quali carte vuoi scegliere? In ingresso un array di 4, in uscita un array di 2
        return LeadArray;
    }

    // In LeaderCard1 e LeaderCard2 ho le LeaderCards scelte dal player.

    private LeaderCard LeaderCard1;
    private LeaderCard LeaderCard2;
    private int LeaderCard1Id = LeaderCard1.getId();
    private int LeaderCard2Id = LeaderCard2.getId();




    //Mettere dentro la classe player un arraylist di leadercard e inserire metodo remove leadercard in discard


    //posso scartare la mia carta leader
    public void discard(LeaderCard LeadDiscard, int num) {
        if (num == 1) {
            LeaderCard1Id = 0;
        } else {
            LeaderCard2Id = 0;
        }
        player.getFaithTrack().setRedPosition(1);
    }

    //posso attivare la carta leader
    public void activate(LeaderCard LeadCardAct) {
        if (LeadCardAct.canBeActivated(player) == true) {
            LeadCardAct.setActivate(true);
        }

        //rendo leadercard astratta e creo 4 sottoclassi per ogni tipo di leadercard che estendono leadercard e
        //ogni classe fa l'ovveride del metodo canbeactivated


    }
}






















   /* private int Cost2; // i numeri rimangono uguali a sopra, 0 se non ho un solo costo in quella carta
    private int NumberOfPurpleDevCards;
    private int NumberOfBlueDevCards;
    private int NumberOfYellowDevCards;
    private int NumberOfGreenDevCards;
    private int[] SlotCards = new int[4];*/
/*private int Cost1;
    // se TypeExtraResources 1=purple, 2=blue, 3=yellow, 4=green
    // se TypeReduceCost 1=purple, 2=blue, 3=yellow, 4=green
    // se Type ExtraWarehouse 1=purple, 2=blue, 3=yellow, 4=grey
    // se Type ConvertResources 1=purple, 2=blue, 3=yellow, 4=green*/