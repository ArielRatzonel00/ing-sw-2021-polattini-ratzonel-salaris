package it.polimi.ingsw.Controller;

import it.polimi.ingsw.Model.DevelopmentCard;
import it.polimi.ingsw.Model.LeaderCard;
import it.polimi.ingsw.Model.Player;
import it.polimi.ingsw.Model.Slots;

public class Production {

    private Player player;

    public Production(Player player) {
        this.player = player;
    }

    private boolean act1 =false;
    private boolean act2 =false;
    private boolean act3 =false;
    private boolean act4 =false;
    private boolean act5 =false;

    private int[] TotalResourcesNeed = {0, 0, 0, 0}; //0=purple, 1=blue, 2=yellow, 3=grey
    private int[] TotalResourcesPoss = {0, 0, 0, 0}; //0=purple, 1=blue, 2=yellow, 3=grey


    public void activateProductionDev(int[] WhatCards){
    // WhatCards 0=slot1Top 1=slot2Top 2=slot3Top 3=Lead1 4=Lead2. Se nella casella tot c'è 1 vuol dire che devo
        // attivare quella produzione
        if(WhatCards[0]==1){

        }


    }




}

/*
Cose da fare:
1) controllare quali poteri di produzione ho sulla mia plancia personale (+ carte leader produzione + 2 in 1)
(solo la carta più sopra può farmi produrre -> ho al massimo 6 produzioni contemporanee)
Posso attivare una certa produzione solo una volta per turno
I poteri di produzione si attivano tutti contemporaneamente quindi la somma delle risorse di tutte le produzioni
deve essere minore della somma di tutte le risorse che ho tra magazzino, carte leader e strongbox.
 */
