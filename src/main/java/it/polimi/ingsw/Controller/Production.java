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

    private int[] temp;
    private int[] temp1;
    private boolean activate=true;
    private boolean removeSuccess;


    private int[] TotalResourcesNeed = {0, 0, 0, 0}; //0=purple, 1=blue, 2=yellow, 3=grey
    private int[] TotalResourcesPoss = {0, 0, 0, 0}; //0=purple, 1=blue, 2=yellow, 3=grey
    private int[] TotalResourcesNew = {0, 0, 0, 0}; //0=purple, 1=blue, 2=yellow, 3=grey 4=faith
    private int[] HowMuchTot = {0, 0, 0, 0}; //0=purple, 1=blue, 2=yellow, 3=grey


    public void activateProduction(int[] WhatCards, int Cost12in1, int Cost22in1, int Prod2in1, int ProdLead1, int ProdLead2, int[] HowMuchFromStrong, int[] HowMuchFromWare, int[] HowMuchFromLead){ //0 in tutti non attivo la 2in1, 1=purple, 2=blue, 3=yellow, 4=grey
        //HowMuch: 0=purple, 1=blue, 2=yellow, 3=grey
        //gli int 2in1: 0 in tutti non attivo la 2in1, 1=purple, 2=blue, 3=yellow, 4=grey
        //ProdLead1 e 2: 0=purple, 1=blue, 2=yellow, 3=grey
        // WhatCards 0=slot1Top 1=slot2Top 2=slot3Top 3=Lead1 4=Lead2 5=2in1
        // Se nella casella tot c'è 1 vuol dire che il giocatore vuole attivare quella produzione.
        // mi faccio quindi passare l'insieme di tutte le produzioni che vuole attivare. Verifico singolarmente che le carte passate
        //siano in una posizione che può essere attivata e poi verifico di avere tutte le risorse per svolgere la produzione di tutte le carte
        //in modo simultaneo.

        if(WhatCards[0]==1){
            temp = player.getSlots().getCard1Top().getProductionCost();
            temp1 = player.getSlots().getCard1Top().getProductionProfit();

            for(int c=0; c<5; c++) {
                TotalResourcesNew[c] += temp1[c];
            }

            for(int c=0; c<4; c++) {
                TotalResourcesNeed[c] += temp[c];
            }
        }

        if(WhatCards[1]==1){
            temp = player.getSlots().getCard2Top().getProductionCost();
            temp1 = player.getSlots().getCard2Top().getProductionProfit();

            for(int c=0; c<5; c++) {
                TotalResourcesNew[c] += temp1[c];
            }

            for(int c=0; c<4; c++) {
                TotalResourcesNeed[c] += temp[c];
            }
        }

        if(WhatCards[2]==1){
            temp = player.getSlots().getCard3Top().getProductionCost();
            temp1 = player.getSlots().getCard3Top().getProductionProfit();

            for(int c=0; c<5; c++) {
                TotalResourcesNew[c] += temp1[c];
            }


            for(int c=0; c<4; c++) {
                TotalResourcesNeed[c] += temp[c];
            }
        }

        if(WhatCards[3]==1){
            if((player.getLeaderCards(1).isActivate()==true) &&
                    ((player.getLeaderCards(1).getId()==13) ||
                            (player.getLeaderCards(1).getId()==14) ||
                            (player.getLeaderCards(1).getId()==15) ||
                            (player.getLeaderCards(1).getId()==16))) {
                TotalResourcesNeed[player.getLeaderCards(1).getSpecialAbilityColor() - 1] += 1;
                TotalResourcesNew[4]+=1;
                TotalResourcesNew[ProdLead1]+=1; //controllare che ProdLead1 sia tra 0 e 3, non 4 se no mi crea punti fede con la pallina nera sulla carta
            }
        }

        if(WhatCards[4]==1){
            if((player.getLeaderCards(2).isActivate()==true) &&
                    ((player.getLeaderCards(2).getId()==13) ||
                            (player.getLeaderCards(2).getId()==14) ||
                            (player.getLeaderCards(2).getId()==15) ||
                            (player.getLeaderCards(2).getId()==16)) &&
                    (player.getLeaderCards(1).getId() != player.getLeaderCards(2).getId())) {
                TotalResourcesNeed[player.getLeaderCards(2).getSpecialAbilityColor() - 1] += 1;
                TotalResourcesNew[4]+=1;
                TotalResourcesNew[ProdLead2]+=1;//controllare che ProdLead2 sia tra 0 e 3, non 4 se no mi crea punti fede con la pallina nera sulla carta
            }
        }

        if(WhatCards[5]==1){
            TotalResourcesNeed[Cost12in1-1]+=1;
            TotalResourcesNeed[Cost22in1-1]+=1;
            TotalResourcesNew[Prod2in1-1]+=1;
        }

        TotalResourcesPoss = player.getWarehouse().getTotalMaterials();

        TotalResourcesPoss[0] += player.getStrongbox().getServant();
        TotalResourcesPoss[1] += player.getStrongbox().getShield();
        TotalResourcesPoss[2] += player.getStrongbox().getCoin();
        TotalResourcesPoss[3] += player.getStrongbox().getStone();

        for(int c=0; c<4; c++){
            HowMuchTot[c] += HowMuchFromLead[c];
            HowMuchTot[c] += HowMuchFromStrong[c];
            HowMuchTot[c] += HowMuchFromWare[c];
        }

        for(int c=0; c<4; c++){
            if(HowMuchTot[c] != TotalResourcesNeed[c]){
                activate = false;
                //non mi hai passato da dove prendere le risorse necessarie in modo corretto
            }
        }

        for(int c=0; c<4;c++){
            if(TotalResourcesPoss[c]<TotalResourcesNeed[c]){
                activate = false;
                //non hai abbastanza risorse per fare le produzioni che hai selezionato.
            }
        }

        if(activate == true)
        {
            //tolgo le risorse dal magazzino
            removeSuccess = player.getWarehouse().RemoveResourcesFromWare(HowMuchFromWare);
            if(removeSuccess == true){
                //rimozione avvenuta con successo
            }
            else{
                //rimozione avvenuta senza successo
            }

            //tolgo le risorse dalle Leader
            removeSuccess = player.getWarehouse().RemoveResourcesFromLead(HowMuchFromLead);
            if(removeSuccess == true){
                //rimozione avvenuta con successo
            }
            else{
                //rimozione avvenuta senza successo
            }


            //tolgo le risorse dallo strongbox
            player.getStrongbox().RemoveServant(HowMuchFromStrong[0]);
            player.getStrongbox().RemoveShield(HowMuchFromStrong[1]);
            player.getStrongbox().RemoveCoin(HowMuchFromStrong[2]);
            player.getStrongbox().RemoveStone(HowMuchFromStrong[3]);

            //aggiungo le risorse create nello strongbox
            player.getStrongbox().AddServant(TotalResourcesNew[0]);
            player.getStrongbox().AddShield(TotalResourcesNew[1]);
            player.getStrongbox().AddCoin(TotalResourcesNew[2]);
            player.getStrongbox().AddStone(TotalResourcesNew[3]);
            player.getFaithTrack().setRedPosition(TotalResourcesNew[4]);
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

Mancano le risorse prodotte.
 */
