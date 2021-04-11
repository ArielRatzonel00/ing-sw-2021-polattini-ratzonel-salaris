package it.polimi.ingsw.Controller;

import it.polimi.ingsw.Model.DevelopmentCard;

public class Production {
    private DevelopmentCard card1Production;
    private DevelopmentCard card2Production;
    private DevelopmentCard card3Production;
    private LeaderCardController card4Production;
    private LeaderCardController card5Production;


}

/*
Cose da fare:
1) controllare quali poteri di produzione ho sulla mia plancia personale (+ carte leader produzione + 2 in 1)
(solo la carta più sopra può farmi produrre -> ho al massimo 6 produzioni contemporanee)
Posso attivare una certa produzione solo una volta per turno
I poteri di produzione si attivano tutti contemporaneamente quindi la somma delle risorse di tutte le produzioni
deve essere minore della somma di tutte le risorse che ho tra magazzino, carte leader e strongbox.

 */
