package it.polimi.ingsw.Controller;

import it.polimi.ingsw.Model.LeaderCard;
import it.polimi.ingsw.Model.Player;

public class LeaderCardController (Player player){
    //distribuisco 4 carte leader a ogni giocatore

    //faccio scegliere 2 leader card a ogni giocatore tra le 4 pescate precedentemente
    public LeaderCard[] ChooseLeaderCards(LeaderCard[] LeadArray){
        //quali carte vuoi scegliere? In ingresso un array di 4, in uscita un array di 2
        return LeadArray;
    }

    // In LeaderCard1 e LeaderCard2 ho le LeaderCards scelte dal player.
    private LeaderCard LeaderCard1;
    private LeaderCard LeaderCard2;
    private int LeaderCard1Id;
    private int LeaderCard2Id;

    //posso scartare la mia carta leader
    public void discard(int LeadDiscardId){
        if(LeadDiscardId == LeaderCard1Id) {
            LeaderCard1Id = 0;
        }
        else {
            LeaderCard2Id = 0;
        }
        player.getFaithTrack().setRedPosition(1);
    }

    //posso attivare la carta leader
    public void activate(int LeadCardActId){
        player.

    }



}
