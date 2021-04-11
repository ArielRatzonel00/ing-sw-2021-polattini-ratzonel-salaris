package it.polimi.ingsw.Controller;

import it.polimi.ingsw.Model.DevelopmentCard;
import it.polimi.ingsw.Model.Slots;

public class Production {
    private int Card1Production = new ;
    private DevelopmentCard Card2Production;
    private DevelopmentCard Card3Production;
    private LeaderCardController Card4Production;
    private LeaderCardController Card5Production;

    Card1Production = new DevelopmentCard(Slots.getCard1Top);

}

/*
Cose da fare:
1) controllare quali poteri di produzione ho sulla mia plancia personale (+ carte leader produzione + 2 in 1)
(solo la carta più sopra può farmi produrre -> ho al massimo 6 produzioni contemporanee)
Posso attivare una certa produzione solo una volta per turno
I poteri di produzione si attivano tutti contemporaneamente quindi la somma delle risorse di tutte le produzioni
deve essere minore della somma di tutte le risorse che ho tra magazzino, carte leader e strongbox.
 */
