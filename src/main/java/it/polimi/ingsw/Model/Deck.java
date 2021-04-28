package it.polimi.ingsw.Model;

import it.polimi.ingsw.Model.LeaderCard.*;
import it.polimi.ingsw.Model.Marble.MarketMarble;

// Class that contains the DevelopmentCards and the LeaderCards

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<LeaderCard> ArrLeaderCards = new ArrayList<>();

    private LeaderCard ExtraRsc1; //pallina bianca in viola
    private LeaderCard ExtraRsc2; //pallina bianca in blu
    private LeaderCard ExtraRsc3; //pallina bianca in giallo
    private LeaderCard ExtraRsc4; //pallina bianca in grigio

    private LeaderCard ReduceCost1; //meno un viola nel costo
    private LeaderCard ReduceCost2; //meno un blu nel costo
    private LeaderCard ReduceCost3; //meno un giallo nel costo
    private LeaderCard ReduceCost4; //meno un grigio nel costo

    private LeaderCard ExtraWarehouse1; //più 2 spazi viola nel warehouse
    private LeaderCard ExtraWarehouse2; //più 2 spazi blu nel warehouse
    private LeaderCard ExtraWarehouse3; //più 2 spazi gialli nel warehouse
    private LeaderCard ExtraWarehouse4; //più 2 spazi grigi nel warehouse

    private LeaderCard ConvertRsc1; //converte un viola in una risorsa a scelta e 1 punto fede
    private LeaderCard ConvertRsc2; //converte un blu in una risorsa a scelta e 1 punto fede
    private LeaderCard ConvertRsc3; //converte un giallo in una risorsa a scelta e 1 punto fede
    private LeaderCard ConvertRsc4; //converte un grigio in una risorsa a scelta e 1 punto fede
    private GridCell cell00;
    private GridCell cell01;
    private GridCell cell02;
    private GridCell cell03;
    private GridCell cell10;
    private GridCell cell11;
    private GridCell cell12;
    private GridCell cell13;
    private GridCell cell20;
    private GridCell cell21;
    private GridCell cell22;
    private GridCell cell23;
    private DevelopmentCard Green11;
    private DevelopmentCard Green12;
    private DevelopmentCard Green13;
    private DevelopmentCard Green14;

    private DevelopmentCard Blue11;

    private DevelopmentCard Green21;
    private DevelopmentCard Green31;


    public Deck() {


        ArrayList<CostOfCard> Green11Cost = new ArrayList<>();
        Green11Cost.add(new CostOfCard(2, MarketMarble.ColorMarble.BLUE));
        ArrayList<CostOfCard> Green11ProductionCost = new ArrayList<>();
        Green11ProductionCost.add(new CostOfCard(1, MarketMarble.ColorMarble.YELLOW));
        ArrayList<CostOfCard> Green11ProductionProfit = new ArrayList<>();
        Green11ProductionProfit.add(new CostOfCard(1, MarketMarble.ColorMarble.RED));
        Green11 = new DevelopmentCard(Green11Cost, new Production(Green11ProductionCost, Green11ProductionProfit), 1, DevelopmentCard.colorCard.Green, 1, 1);

        ArrayList<CostOfCard> Green12Cost = new ArrayList<>();
        Green12Cost.add(new CostOfCard(2, MarketMarble.ColorMarble.BLUE));
        Green12Cost.add(new CostOfCard(2, MarketMarble.ColorMarble.YELLOW));
        ArrayList<CostOfCard> Green12ProductionCost = new ArrayList<>();
        Green12ProductionCost.add(new CostOfCard(1, MarketMarble.ColorMarble.GREY));
        Green12ProductionCost.add(new CostOfCard(1, MarketMarble.ColorMarble.PURPLE));
        ArrayList<CostOfCard> Green12ProductionProfit = new ArrayList<>();
        Green12ProductionProfit.add(new CostOfCard(2, MarketMarble.ColorMarble.YELLOW));
        Green12ProductionProfit.add(new CostOfCard(1, MarketMarble.ColorMarble.RED));
        Green12 = new DevelopmentCard(Green12Cost, new Production(Green12ProductionCost, Green12ProductionProfit), 2, DevelopmentCard.colorCard.Green, 1, 4);


        ArrayList<CostOfCard> Green13Cost = new ArrayList<>();
        Green13Cost.add(new CostOfCard(3, MarketMarble.ColorMarble.BLUE));
        ArrayList<CostOfCard> Green13ProductionCost = new ArrayList<>();
        Green13ProductionCost.add(new CostOfCard(2, MarketMarble.ColorMarble.PURPLE));
        ArrayList<CostOfCard> Green13ProductionProfit = new ArrayList<>();
        Green13ProductionProfit.add(new CostOfCard(1, MarketMarble.ColorMarble.YELLOW));
        Green13ProductionProfit.add(new CostOfCard(1, MarketMarble.ColorMarble.BLUE));
        Green13ProductionProfit.add(new CostOfCard(1, MarketMarble.ColorMarble.GREY));
        Green13 = new DevelopmentCard(Green13Cost, new Production(Green13ProductionCost, Green13ProductionProfit), 3, DevelopmentCard.colorCard.Green, 1, 3);


        ArrayList<CostOfCard> Green14Cost = new ArrayList<>();
        Green14Cost.add(new CostOfCard(1, MarketMarble.ColorMarble.BLUE));
        Green14Cost.add(new CostOfCard(1, MarketMarble.ColorMarble.GREY));
        Green14Cost.add(new CostOfCard(1, MarketMarble.ColorMarble.PURPLE));
        ArrayList<CostOfCard> Green14ProductionCost = new ArrayList<>();
        Green14ProductionCost.add(new CostOfCard(1, MarketMarble.ColorMarble.GREY));
        ArrayList<CostOfCard> Green14ProductionProfit = new ArrayList<>();
        Green14ProductionProfit.add(new CostOfCard(1, MarketMarble.ColorMarble.PURPLE));
        Green14 = new DevelopmentCard(Green14Cost, new Production(Green14ProductionCost, Green14ProductionProfit), 4, DevelopmentCard.colorCard.Green, 1, 2);
        cell00 = new GridCell(Green11, Green12, Green13, Green14);


        ArrayList<CostOfCard> Blue11Cost = new ArrayList<>();
        Blue11Cost.add(new CostOfCard(2, MarketMarble.ColorMarble.YELLOW));
        ArrayList<CostOfCard> Blue11ProductionCost = new ArrayList<>();
        Blue11ProductionCost.add(new CostOfCard(1, MarketMarble.ColorMarble.BLUE));
        ArrayList<CostOfCard> Blue11ProductionProfit = new ArrayList<>();
        Blue11ProductionProfit.add(new CostOfCard(1, MarketMarble.ColorMarble.RED));
        Blue11 = new DevelopmentCard(Blue11Cost, new Production(Blue11ProductionCost, Blue11ProductionProfit), 5, DevelopmentCard.colorCard.Blue, 1, 1);

        ArrayList<CostOfCard> Blue12Cost = new ArrayList<>();
        Blue12Cost.add(new CostOfCard(2, MarketMarble.ColorMarble.YELLOW));
        Blue12Cost.add(new CostOfCard(2, MarketMarble.ColorMarble.PURPLE));
        ArrayList<CostOfCard> Blue12ProductionCost = new ArrayList<>();
        Blue12ProductionCost.add(new CostOfCard(1, MarketMarble.ColorMarble.BLUE));
        Blue12ProductionCost.add(new CostOfCard(1, MarketMarble.ColorMarble.GREY));
        ArrayList<CostOfCard> Blue12ProductionProfit = new ArrayList<>();
        Blue12ProductionProfit.add(new CostOfCard(2, MarketMarble.ColorMarble.PURPLE));
        Blue12ProductionProfit.add(new CostOfCard(1, MarketMarble.ColorMarble.RED));
        DevelopmentCard Blue12 = new DevelopmentCard(Blue12Cost, new Production(Blue12ProductionCost, Blue12ProductionProfit), 6, DevelopmentCard.colorCard.Blue, 1, 4);


        ArrayList<CostOfCard> Blue13Cost = new ArrayList<>();
        Blue13Cost.add(new CostOfCard(3, MarketMarble.ColorMarble.YELLOW));
        ArrayList<CostOfCard> Blue13ProductionCost = new ArrayList<>();
        Blue13ProductionCost.add(new CostOfCard(2, MarketMarble.ColorMarble.GREY));
        ArrayList<CostOfCard> Blue13ProductionProfit = new ArrayList<>();
        Blue13ProductionProfit.add(new CostOfCard(1, MarketMarble.ColorMarble.YELLOW));
        Blue13ProductionProfit.add(new CostOfCard(1, MarketMarble.ColorMarble.PURPLE));
        Blue13ProductionProfit.add(new CostOfCard(1, MarketMarble.ColorMarble.BLUE));
        DevelopmentCard Blue13 = new DevelopmentCard(Blue13Cost, new Production(Blue13ProductionCost, Blue13ProductionProfit), 7, DevelopmentCard.colorCard.Blue, 1, 3);


        ArrayList<CostOfCard> Blue14Cost = new ArrayList<>();
        Blue14Cost.add(new CostOfCard(1, MarketMarble.ColorMarble.YELLOW));
        Blue14Cost.add(new CostOfCard(1, MarketMarble.ColorMarble.GREY));
        Blue14Cost.add(new CostOfCard(1, MarketMarble.ColorMarble.PURPLE));
        ArrayList<CostOfCard> Blue14ProductionCost = new ArrayList<>();
        Blue14ProductionCost.add(new CostOfCard(1, MarketMarble.ColorMarble.PURPLE));
        ArrayList<CostOfCard> Blue14ProductionProfit = new ArrayList<>();
        Blue14ProductionProfit.add(new CostOfCard(1, MarketMarble.ColorMarble.GREY));
        DevelopmentCard Blue14 = new DevelopmentCard(Blue14Cost, new Production(Blue14ProductionCost, Blue14ProductionProfit), 8, DevelopmentCard.colorCard.Blue, 1, 2);
        cell01 = new GridCell(Blue11, Blue12, Blue13, Blue14);


        ArrayList<CostOfCard> Yellow11Cost = new ArrayList<>();
        Yellow11Cost.add(new CostOfCard(2, MarketMarble.ColorMarble.GREY));
        ArrayList<CostOfCard> Yellow11ProductionCost = new ArrayList<>();
        Yellow11ProductionCost.add(new CostOfCard(1, MarketMarble.ColorMarble.PURPLE));
        ArrayList<CostOfCard> Yellow11ProductionProfit = new ArrayList<>();
        Yellow11ProductionProfit.add(new CostOfCard(1, MarketMarble.ColorMarble.RED));
        DevelopmentCard Yellow11 = new DevelopmentCard(Yellow11Cost, new Production(Yellow11ProductionCost, Yellow11ProductionProfit), 9, DevelopmentCard.colorCard.Yellow, 1, 1);

        ArrayList<CostOfCard> Yellow12Cost = new ArrayList<>();
        Yellow12Cost.add(new CostOfCard(2, MarketMarble.ColorMarble.GREY));
        Yellow12Cost.add(new CostOfCard(2, MarketMarble.ColorMarble.BLUE));
        ArrayList<CostOfCard> Yellow12ProductionCost = new ArrayList<>();
        Yellow12ProductionCost.add(new CostOfCard(1, MarketMarble.ColorMarble.YELLOW));
        Yellow12ProductionCost.add(new CostOfCard(1, MarketMarble.ColorMarble.PURPLE));
        ArrayList<CostOfCard> Yellow12ProductionProfit = new ArrayList<>();
        Yellow12ProductionProfit.add(new CostOfCard(2, MarketMarble.ColorMarble.BLUE));
        Yellow12ProductionProfit.add(new CostOfCard(1, MarketMarble.ColorMarble.RED));
        DevelopmentCard Yellow12 = new DevelopmentCard(Yellow12Cost, new Production(Yellow12ProductionCost, Yellow12ProductionProfit), 10, DevelopmentCard.colorCard.Yellow, 1, 4);


        ArrayList<CostOfCard> Yellow13Cost = new ArrayList<>();
        Yellow13Cost.add(new CostOfCard(3, MarketMarble.ColorMarble.GREY));
        ArrayList<CostOfCard> Yellow13ProductionCost = new ArrayList<>();
        Yellow13ProductionCost.add(new CostOfCard(2, MarketMarble.ColorMarble.BLUE));
        ArrayList<CostOfCard> Yellow13ProductionProfit = new ArrayList<>();
        Yellow13ProductionProfit.add(new CostOfCard(1, MarketMarble.ColorMarble.YELLOW));
        Yellow13ProductionProfit.add(new CostOfCard(1, MarketMarble.ColorMarble.PURPLE));
        Yellow13ProductionProfit.add(new CostOfCard(1, MarketMarble.ColorMarble.GREY));
        DevelopmentCard Yellow13 = new DevelopmentCard(Yellow13Cost, new Production(Yellow13ProductionCost, Yellow13ProductionProfit), 11, DevelopmentCard.colorCard.Yellow, 1, 3);


        ArrayList<CostOfCard> Yellow14Cost = new ArrayList<>();
        Yellow14Cost.add(new CostOfCard(1, MarketMarble.ColorMarble.BLUE));
        Yellow14Cost.add(new CostOfCard(1, MarketMarble.ColorMarble.GREY));
        Yellow14Cost.add(new CostOfCard(1, MarketMarble.ColorMarble.YELLOW));
        ArrayList<CostOfCard> Yellow14ProductionCost = new ArrayList<>();
        Yellow14ProductionCost.add(new CostOfCard(1, MarketMarble.ColorMarble.BLUE));
        ArrayList<CostOfCard> Yellow14ProductionProfit = new ArrayList<>();
        Yellow14ProductionProfit.add(new CostOfCard(1, MarketMarble.ColorMarble.YELLOW));
        DevelopmentCard Yellow14 = new DevelopmentCard(Yellow14Cost, new Production(Yellow14ProductionCost, Yellow14ProductionProfit), 12, DevelopmentCard.colorCard.Yellow, 1, 2);
        cell02 = new GridCell(Yellow11, Yellow12, Yellow13, Yellow14);


        ArrayList<CostOfCard> Purple11Cost = new ArrayList<>();
        Purple11Cost.add(new CostOfCard(2, MarketMarble.ColorMarble.PURPLE));
        ArrayList<CostOfCard> Purple11ProductionCost = new ArrayList<>();
        Purple11ProductionCost.add(new CostOfCard(1, MarketMarble.ColorMarble.GREY));
        ArrayList<CostOfCard> Purple11ProductionProfit = new ArrayList<>();
        Purple11ProductionProfit.add(new CostOfCard(1, MarketMarble.ColorMarble.RED));
        DevelopmentCard Purple11 = new DevelopmentCard(Purple11Cost, new Production(Purple11ProductionCost, Purple11ProductionProfit), 13, DevelopmentCard.colorCard.Purple, 1, 1);

        ArrayList<CostOfCard> Purple12Cost = new ArrayList<>();
        Purple12Cost.add(new CostOfCard(2, MarketMarble.ColorMarble.PURPLE));
        Purple12Cost.add(new CostOfCard(2, MarketMarble.ColorMarble.GREY));
        ArrayList<CostOfCard> Purple12ProductionCost = new ArrayList<>();
        Purple12ProductionCost.add(new CostOfCard(1, MarketMarble.ColorMarble.YELLOW));
        Purple12ProductionCost.add(new CostOfCard(1, MarketMarble.ColorMarble.BLUE));
        ArrayList<CostOfCard> Purple12ProductionProfit = new ArrayList<>();
        Purple12ProductionProfit.add(new CostOfCard(2, MarketMarble.ColorMarble.GREY));
        Purple12ProductionProfit.add(new CostOfCard(1, MarketMarble.ColorMarble.RED));
        DevelopmentCard Purple12 = new DevelopmentCard(Purple12Cost, new Production(Purple12ProductionCost, Purple12ProductionProfit), 14, DevelopmentCard.colorCard.Purple, 1, 4);


        ArrayList<CostOfCard> Purple13Cost = new ArrayList<>();
        Purple13Cost.add(new CostOfCard(3, MarketMarble.ColorMarble.PURPLE));
        ArrayList<CostOfCard> Purple13ProductionCost = new ArrayList<>();
        Purple13ProductionCost.add(new CostOfCard(2, MarketMarble.ColorMarble.YELLOW));
        ArrayList<CostOfCard> Purple13ProductionProfit = new ArrayList<>();
        Purple13ProductionProfit.add(new CostOfCard(1, MarketMarble.ColorMarble.BLUE));
        Purple13ProductionProfit.add(new CostOfCard(1, MarketMarble.ColorMarble.PURPLE));
        Purple13ProductionProfit.add(new CostOfCard(1, MarketMarble.ColorMarble.GREY));
        DevelopmentCard Purple13 = new DevelopmentCard(Purple13Cost, new Production(Purple13ProductionCost, Purple13ProductionProfit), 15, DevelopmentCard.colorCard.Purple, 1, 3);


        ArrayList<CostOfCard> Purple14Cost = new ArrayList<>();
        Purple14Cost.add(new CostOfCard(1, MarketMarble.ColorMarble.BLUE));
        Purple14Cost.add(new CostOfCard(1, MarketMarble.ColorMarble.YELLOW));
        Purple14Cost.add(new CostOfCard(1, MarketMarble.ColorMarble.PURPLE));
        ArrayList<CostOfCard> Purple14ProductionCost = new ArrayList<>();
        Purple14ProductionCost.add(new CostOfCard(1, MarketMarble.ColorMarble.YELLOW));
        ArrayList<CostOfCard> Purple14ProductionProfit = new ArrayList<>();
        Purple14ProductionProfit.add(new CostOfCard(1, MarketMarble.ColorMarble.BLUE));
        DevelopmentCard Purple14 = new DevelopmentCard(Purple14Cost, new Production(Purple14ProductionCost, Purple14ProductionProfit), 16, DevelopmentCard.colorCard.Purple, 1, 2);
        cell03 = new GridCell(Purple11, Purple12, Purple13, Purple14);


        ArrayList<CostOfCard> Green21Cost = new ArrayList<>();
        Green21Cost.add(new CostOfCard(4, MarketMarble.ColorMarble.BLUE));
        ArrayList<CostOfCard> Green21ProductionCost = new ArrayList<>();
        Green21ProductionCost.add(new CostOfCard(1, MarketMarble.ColorMarble.GREY));
        ArrayList<CostOfCard> Green21ProductionProfit = new ArrayList<>();
        Green21ProductionProfit.add(new CostOfCard(2, MarketMarble.ColorMarble.RED));
        Green21 = new DevelopmentCard(Green21Cost, new Production(Green21ProductionCost, Green21ProductionProfit), 17, DevelopmentCard.colorCard.Green, 2, 5);

        ArrayList<CostOfCard> Green22Cost = new ArrayList<>();
        Green22Cost.add(new CostOfCard(5, MarketMarble.ColorMarble.BLUE));
        ArrayList<CostOfCard> Green22ProductionCost = new ArrayList<>();
        Green22ProductionCost.add(new CostOfCard(1, MarketMarble.ColorMarble.YELLOW));
        ArrayList<CostOfCard> Green22ProductionProfit = new ArrayList<>();
        Green22ProductionProfit.add(new CostOfCard(2, MarketMarble.ColorMarble.GREY));
        Green22ProductionProfit.add(new CostOfCard(2, MarketMarble.ColorMarble.RED));
        DevelopmentCard Green22 = new DevelopmentCard(Green22Cost, new Production(Green22ProductionCost, Green22ProductionProfit), 18, DevelopmentCard.colorCard.Green, 2, 7);

        ArrayList<CostOfCard> Green23Cost = new ArrayList<>();
        Green23Cost.add(new CostOfCard(3, MarketMarble.ColorMarble.BLUE));
        Green23Cost.add(new CostOfCard(2, MarketMarble.ColorMarble.PURPLE));
        ArrayList<CostOfCard> Green23ProductionCost = new ArrayList<>();
        Green23ProductionCost.add(new CostOfCard(1, MarketMarble.ColorMarble.BLUE));
        Green23ProductionCost.add(new CostOfCard(1, MarketMarble.ColorMarble.PURPLE));
        ArrayList<CostOfCard> Green23ProductionProfit = new ArrayList<>();
        Green23ProductionProfit.add(new CostOfCard(3, MarketMarble.ColorMarble.GREY));
        DevelopmentCard Green23 = new DevelopmentCard(Green23Cost, new Production(Green23ProductionCost, Green23ProductionProfit), 19, DevelopmentCard.colorCard.Green, 2, 6);

        ArrayList<CostOfCard> Green24Cost = new ArrayList<>();
        Green24Cost.add(new CostOfCard(3, MarketMarble.ColorMarble.BLUE));
        Green24Cost.add(new CostOfCard(3, MarketMarble.ColorMarble.YELLOW));
        ArrayList<CostOfCard> Green24ProductionCost = new ArrayList<>();
        Green24ProductionCost.add(new CostOfCard(1, MarketMarble.ColorMarble.YELLOW));
        ArrayList<CostOfCard> Green24ProductionProfit = new ArrayList<>();
        Green24ProductionProfit.add(new CostOfCard(2, MarketMarble.ColorMarble.BLUE));
        Green24ProductionProfit.add(new CostOfCard(1, MarketMarble.ColorMarble.RED));
        DevelopmentCard Green24 = new DevelopmentCard(Green24Cost, new Production(Green24ProductionCost, Green24ProductionProfit), 20, DevelopmentCard.colorCard.Green, 2, 8);
        cell10 = new GridCell(Green21, Green22, Green23, Green24);


        ArrayList<CostOfCard> Blue21Cost = new ArrayList<>();
        Blue21Cost.add(new CostOfCard(4, MarketMarble.ColorMarble.YELLOW));
        ArrayList<CostOfCard> Blue21ProductionCost = new ArrayList<>();
        Blue21ProductionCost.add(new CostOfCard(1, MarketMarble.ColorMarble.PURPLE));
        ArrayList<CostOfCard> Blue21ProductionProfit = new ArrayList<>();
        Blue21ProductionProfit.add(new CostOfCard(2, MarketMarble.ColorMarble.RED));
        DevelopmentCard Blue21 = new DevelopmentCard(Blue21Cost, new Production(Blue21ProductionCost, Blue21ProductionProfit), 21, DevelopmentCard.colorCard.Blue, 2, 5);

        ArrayList<CostOfCard> Blue22Cost = new ArrayList<>();
        Blue22Cost.add(new CostOfCard(5, MarketMarble.ColorMarble.YELLOW));
        ArrayList<CostOfCard> Blue22ProductionCost = new ArrayList<>();
        Blue22ProductionCost.add(new CostOfCard(2, MarketMarble.ColorMarble.PURPLE));
        ArrayList<CostOfCard> Blue22ProductionProfit = new ArrayList<>();
        Blue22ProductionProfit.add(new CostOfCard(2, MarketMarble.ColorMarble.BLUE));
        Blue22ProductionProfit.add(new CostOfCard(2, MarketMarble.ColorMarble.RED));
        DevelopmentCard Blue22 = new DevelopmentCard(Blue22Cost, new Production(Blue22ProductionCost, Blue22ProductionProfit), 22, DevelopmentCard.colorCard.Blue, 2, 7);

        ArrayList<CostOfCard> Blue23Cost = new ArrayList<>();
        Blue23Cost.add(new CostOfCard(3, MarketMarble.ColorMarble.YELLOW));
        Blue23Cost.add(new CostOfCard(2, MarketMarble.ColorMarble.GREY));
        ArrayList<CostOfCard> Blue23ProductionCost = new ArrayList<>();
        Blue23ProductionCost.add(new CostOfCard(1, MarketMarble.ColorMarble.YELLOW));
        Blue23ProductionCost.add(new CostOfCard(1, MarketMarble.ColorMarble.GREY));
        ArrayList<CostOfCard> Blue23ProductionProfit = new ArrayList<>();
        Blue23ProductionProfit.add(new CostOfCard(3, MarketMarble.ColorMarble.PURPLE));
        DevelopmentCard Blue23 = new DevelopmentCard(Blue23Cost, new Production(Blue23ProductionCost, Blue23ProductionProfit), 23, DevelopmentCard.colorCard.Blue, 2, 6);

        ArrayList<CostOfCard> Blue24Cost = new ArrayList<>();
        Blue24Cost.add(new CostOfCard(3, MarketMarble.ColorMarble.YELLOW));
        Blue24Cost.add(new CostOfCard(3, MarketMarble.ColorMarble.GREY));
        ArrayList<CostOfCard> Blue24ProductionCost = new ArrayList<>();
        Blue24ProductionCost.add(new CostOfCard(1, MarketMarble.ColorMarble.PURPLE));
        ArrayList<CostOfCard> Blue24ProductionProfit = new ArrayList<>();
        Blue24ProductionProfit.add(new CostOfCard(2, MarketMarble.ColorMarble.GREY));
        Blue24ProductionProfit.add(new CostOfCard(1, MarketMarble.ColorMarble.RED));
        DevelopmentCard Blue24 = new DevelopmentCard(Blue24Cost, new Production(Blue24ProductionCost, Blue24ProductionProfit), 24, DevelopmentCard.colorCard.Blue, 2, 8);
        cell11 = new GridCell(Blue21, Blue22, Blue23, Blue24);


        ArrayList<CostOfCard> Yellow21Cost = new ArrayList<>();
        Yellow21Cost.add(new CostOfCard(4, MarketMarble.ColorMarble.GREY));
        ArrayList<CostOfCard> Yellow21ProductionCost = new ArrayList<>();
        Yellow21ProductionCost.add(new CostOfCard(1, MarketMarble.ColorMarble.BLUE));
        ArrayList<CostOfCard> Yellow21ProductionProfit = new ArrayList<>();
        Yellow21ProductionProfit.add(new CostOfCard(2, MarketMarble.ColorMarble.RED));
        DevelopmentCard Yellow21 = new DevelopmentCard(Yellow21Cost, new Production(Yellow21ProductionCost, Yellow21ProductionProfit), 25, DevelopmentCard.colorCard.Yellow, 2, 5);

        ArrayList<CostOfCard> Yellow22Cost = new ArrayList<>();
        Yellow22Cost.add(new CostOfCard(5, MarketMarble.ColorMarble.GREY));
        ArrayList<CostOfCard> Yellow22ProductionCost = new ArrayList<>();
        Yellow22ProductionCost.add(new CostOfCard(2, MarketMarble.ColorMarble.BLUE));
        ArrayList<CostOfCard> Yellow22ProductionProfit = new ArrayList<>();
        Yellow22ProductionProfit.add(new CostOfCard(2, MarketMarble.ColorMarble.PURPLE));
        Yellow22ProductionProfit.add(new CostOfCard(2, MarketMarble.ColorMarble.RED));
        DevelopmentCard Yellow22 = new DevelopmentCard(Yellow22Cost, new Production(Yellow22ProductionCost, Yellow22ProductionProfit), 26, DevelopmentCard.colorCard.Yellow, 2, 7);

        ArrayList<CostOfCard> Yellow23Cost = new ArrayList<>();
        Yellow23Cost.add(new CostOfCard(3, MarketMarble.ColorMarble.GREY));
        Yellow23Cost.add(new CostOfCard(2, MarketMarble.ColorMarble.BLUE));
        ArrayList<CostOfCard> Yellow23ProductionCost = new ArrayList<>();
        Yellow23ProductionCost.add(new CostOfCard(1, MarketMarble.ColorMarble.GREY));
        Yellow23ProductionCost.add(new CostOfCard(1, MarketMarble.ColorMarble.BLUE));
        ArrayList<CostOfCard> Yellow23ProductionProfit = new ArrayList<>();
        Yellow23ProductionProfit.add(new CostOfCard(3, MarketMarble.ColorMarble.YELLOW));
        DevelopmentCard Yellow23 = new DevelopmentCard(Yellow23Cost, new Production(Yellow23ProductionCost, Yellow23ProductionProfit), 27, DevelopmentCard.colorCard.Yellow, 2, 6);

        ArrayList<CostOfCard> Yellow24Cost = new ArrayList<>();
        Yellow24Cost.add(new CostOfCard(3, MarketMarble.ColorMarble.GREY));
        Yellow24Cost.add(new CostOfCard(3, MarketMarble.ColorMarble.PURPLE));
        ArrayList<CostOfCard> Yellow24ProductionCost = new ArrayList<>();
        Yellow24ProductionCost.add(new CostOfCard(1, MarketMarble.ColorMarble.BLUE));
        ArrayList<CostOfCard> Yellow24ProductionProfit = new ArrayList<>();
        Yellow24ProductionProfit.add(new CostOfCard(2, MarketMarble.ColorMarble.YELLOW));
        Yellow24ProductionProfit.add(new CostOfCard(1, MarketMarble.ColorMarble.RED));
        DevelopmentCard Yellow24 = new DevelopmentCard(Yellow24Cost, new Production(Yellow24ProductionCost, Yellow24ProductionProfit), 28, DevelopmentCard.colorCard.Yellow, 2, 8);
        cell12 = new GridCell(Yellow21, Yellow22, Yellow23, Yellow24);


        ArrayList<CostOfCard> Purple21Cost = new ArrayList<>();
        Purple21Cost.add(new CostOfCard(4, MarketMarble.ColorMarble.PURPLE));
        ArrayList<CostOfCard> Purple21ProductionCost = new ArrayList<>();
        Purple21ProductionCost.add(new CostOfCard(1, MarketMarble.ColorMarble.YELLOW));
        ArrayList<CostOfCard> Purple21ProductionProfit = new ArrayList<>();
        Purple21ProductionProfit.add(new CostOfCard(2, MarketMarble.ColorMarble.RED));
        DevelopmentCard Purple21 = new DevelopmentCard(Purple21Cost, new Production(Purple21ProductionCost, Purple21ProductionProfit), 29, DevelopmentCard.colorCard.Purple, 2, 5);

        ArrayList<CostOfCard> Purple22Cost = new ArrayList<>();
        Purple22Cost.add(new CostOfCard(5, MarketMarble.ColorMarble.PURPLE));
        ArrayList<CostOfCard> Purple22ProductionCost = new ArrayList<>();
        Purple22ProductionCost.add(new CostOfCard(2, MarketMarble.ColorMarble.GREY));
        ArrayList<CostOfCard> Purple22ProductionProfit = new ArrayList<>();
        Purple22ProductionProfit.add(new CostOfCard(2, MarketMarble.ColorMarble.YELLOW));
        Purple22ProductionProfit.add(new CostOfCard(2, MarketMarble.ColorMarble.RED));
        DevelopmentCard Purple22 = new DevelopmentCard(Purple22Cost, new Production(Purple22ProductionCost, Purple22ProductionProfit), 30, DevelopmentCard.colorCard.Purple, 2, 7);

        ArrayList<CostOfCard> Purple23Cost = new ArrayList<>();
        Purple23Cost.add(new CostOfCard(3, MarketMarble.ColorMarble.PURPLE));
        Purple23Cost.add(new CostOfCard(2, MarketMarble.ColorMarble.YELLOW));
        ArrayList<CostOfCard> Purple23ProductionCost = new ArrayList<>();
        Purple23ProductionCost.add(new CostOfCard(1, MarketMarble.ColorMarble.YELLOW));
        Purple23ProductionCost.add(new CostOfCard(1, MarketMarble.ColorMarble.PURPLE));
        ArrayList<CostOfCard> Purple23ProductionProfit = new ArrayList<>();
        Purple23ProductionProfit.add(new CostOfCard(3, MarketMarble.ColorMarble.BLUE));
        DevelopmentCard Purple23 = new DevelopmentCard(Purple23Cost, new Production(Purple23ProductionCost, Purple23ProductionProfit), 31, DevelopmentCard.colorCard.Purple, 2, 6);

        ArrayList<CostOfCard> Purple24Cost = new ArrayList<>();
        Purple24Cost.add(new CostOfCard(3, MarketMarble.ColorMarble.PURPLE));
        Purple24Cost.add(new CostOfCard(3, MarketMarble.ColorMarble.BLUE));
        ArrayList<CostOfCard> Purple24ProductionCost = new ArrayList<>();
        Purple24ProductionCost.add(new CostOfCard(1, MarketMarble.ColorMarble.GREY));
        ArrayList<CostOfCard> Purple24ProductionProfit = new ArrayList<>();
        Purple24ProductionProfit.add(new CostOfCard(2, MarketMarble.ColorMarble.PURPLE));
        Purple24ProductionProfit.add(new CostOfCard(1, MarketMarble.ColorMarble.RED));
        DevelopmentCard Purple24 = new DevelopmentCard(Purple24Cost, new Production(Purple24ProductionCost, Purple24ProductionProfit), 32, DevelopmentCard.colorCard.Purple, 2, 8);
        cell13 = new GridCell(Purple21, Purple22, Purple23, Purple24);

        ArrayList<CostOfCard> Green31Cost = new ArrayList<>();
        Green31Cost.add(new CostOfCard(7, MarketMarble.ColorMarble.BLUE));
        ArrayList<CostOfCard> Green31ProductionCost = new ArrayList<>();
        Green31ProductionCost.add(new CostOfCard(1, MarketMarble.ColorMarble.PURPLE));
        ArrayList<CostOfCard> Green31ProductionProfit = new ArrayList<>();
        Green31ProductionProfit.add(new CostOfCard(1, MarketMarble.ColorMarble.YELLOW));
        Green31ProductionProfit.add(new CostOfCard(3, MarketMarble.ColorMarble.RED));
        Green31 = new DevelopmentCard(Green31Cost, new Production(Green31ProductionCost, Green31ProductionProfit), 33, DevelopmentCard.colorCard.Green, 3, 11);


        ArrayList<CostOfCard> Green32Cost = new ArrayList<>();
        Green32Cost.add(new CostOfCard(6, MarketMarble.ColorMarble.BLUE));
        ArrayList<CostOfCard> Green32ProductionCost = new ArrayList<>();
        Green32ProductionCost.add(new CostOfCard(2, MarketMarble.ColorMarble.PURPLE));
        ArrayList<CostOfCard> Green32ProductionProfit = new ArrayList<>();
        Green32ProductionProfit.add(new CostOfCard(3, MarketMarble.ColorMarble.GREY));
        Green32ProductionProfit.add(new CostOfCard(2, MarketMarble.ColorMarble.RED));
        DevelopmentCard Green32 = new DevelopmentCard(Green32Cost, new Production(Green32ProductionCost, Green32ProductionProfit), 34, DevelopmentCard.colorCard.Green, 3, 9);


        ArrayList<CostOfCard> Green33Cost = new ArrayList<>();
        Green33Cost.add(new CostOfCard(5, MarketMarble.ColorMarble.BLUE));
        Green33Cost.add(new CostOfCard(2, MarketMarble.ColorMarble.PURPLE));
        ArrayList<CostOfCard> Green33ProductionCost = new ArrayList<>();
        Green33ProductionCost.add(new CostOfCard(1, MarketMarble.ColorMarble.YELLOW));
        Green33ProductionCost.add(new CostOfCard(1, MarketMarble.ColorMarble.PURPLE));
        ArrayList<CostOfCard> Green33ProductionProfit = new ArrayList<>();
        Green33ProductionProfit.add(new CostOfCard(2, MarketMarble.ColorMarble.BLUE));
        Green33ProductionProfit.add(new CostOfCard(2, MarketMarble.ColorMarble.GREY));
        Green33ProductionProfit.add(new CostOfCard(1, MarketMarble.ColorMarble.RED));
        DevelopmentCard Green33 = new DevelopmentCard(Green33Cost, new Production(Green33ProductionCost, Green33ProductionProfit), 35, DevelopmentCard.colorCard.Green, 3, 10);


        ArrayList<CostOfCard> Green34Cost = new ArrayList<>();
        Green34Cost.add(new CostOfCard(4, MarketMarble.ColorMarble.BLUE));
        Green34Cost.add(new CostOfCard(4, MarketMarble.ColorMarble.YELLOW));
        ArrayList<CostOfCard> Green34ProductionCost = new ArrayList<>();
        Green34ProductionCost.add(new CostOfCard(1, MarketMarble.ColorMarble.GREY));
        ArrayList<CostOfCard> Green34ProductionProfit = new ArrayList<>();
        Green34ProductionProfit.add(new CostOfCard(1, MarketMarble.ColorMarble.BLUE));
        Green34ProductionProfit.add(new CostOfCard(3, MarketMarble.ColorMarble.YELLOW));
        DevelopmentCard Green34 = new DevelopmentCard(Green34Cost, new Production(Green34ProductionCost, Green34ProductionProfit), 36, DevelopmentCard.colorCard.Green, 3, 12);
        cell20 = new GridCell(Green31, Green32, Green33, Green34);


        ArrayList<CostOfCard> Blue31Cost = new ArrayList<>();
        Blue31Cost.add(new CostOfCard(7, MarketMarble.ColorMarble.YELLOW));
        ArrayList<CostOfCard> Blue31ProductionCost = new ArrayList<>();
        Blue31ProductionCost.add(new CostOfCard(1, MarketMarble.ColorMarble.GREY));
        ArrayList<CostOfCard> Blue31ProductionProfit = new ArrayList<>();
        Blue31ProductionProfit.add(new CostOfCard(1, MarketMarble.ColorMarble.BLUE));
        Blue31ProductionProfit.add(new CostOfCard(3, MarketMarble.ColorMarble.RED));
        DevelopmentCard Blue31 = new DevelopmentCard(Blue31Cost, new Production(Blue31ProductionCost, Blue31ProductionProfit), 37, DevelopmentCard.colorCard.Blue, 3, 11);


        ArrayList<CostOfCard> Blue32Cost = new ArrayList<>();
        Blue32Cost.add(new CostOfCard(6, MarketMarble.ColorMarble.YELLOW));
        ArrayList<CostOfCard> Blue32ProductionCost = new ArrayList<>();
        Blue32ProductionCost.add(new CostOfCard(2, MarketMarble.ColorMarble.PURPLE));
        ArrayList<CostOfCard> Blue32ProductionProfit = new ArrayList<>();
        Blue32ProductionProfit.add(new CostOfCard(3, MarketMarble.ColorMarble.BLUE));
        Blue32ProductionProfit.add(new CostOfCard(2, MarketMarble.ColorMarble.RED));
        DevelopmentCard Blue32 = new DevelopmentCard(Blue32Cost, new Production(Blue32ProductionCost, Blue32ProductionProfit), 38, DevelopmentCard.colorCard.Blue, 3, 9);


        ArrayList<CostOfCard> Blue33Cost = new ArrayList<>();
        Blue33Cost.add(new CostOfCard(5, MarketMarble.ColorMarble.YELLOW));
        Blue33Cost.add(new CostOfCard(2, MarketMarble.ColorMarble.GREY));
        ArrayList<CostOfCard> Blue33ProductionCost = new ArrayList<>();
        Blue33ProductionCost.add(new CostOfCard(1, MarketMarble.ColorMarble.YELLOW));
        Blue33ProductionCost.add(new CostOfCard(1, MarketMarble.ColorMarble.BLUE));
        ArrayList<CostOfCard> Blue33ProductionProfit = new ArrayList<>();
        Blue33ProductionProfit.add(new CostOfCard(2, MarketMarble.ColorMarble.PURPLE));
        Blue33ProductionProfit.add(new CostOfCard(2, MarketMarble.ColorMarble.GREY));
        Blue33ProductionProfit.add(new CostOfCard(1, MarketMarble.ColorMarble.RED));
        DevelopmentCard Blue33 = new DevelopmentCard(Blue33Cost, new Production(Blue33ProductionCost, Blue33ProductionProfit), 39, DevelopmentCard.colorCard.Blue, 3, 10);


        ArrayList<CostOfCard> Blue34Cost = new ArrayList<>();
        Blue34Cost.add(new CostOfCard(4, MarketMarble.ColorMarble.YELLOW));
        Blue34Cost.add(new CostOfCard(4, MarketMarble.ColorMarble.GREY));
        ArrayList<CostOfCard> Blue34ProductionCost = new ArrayList<>();
        Blue34ProductionCost.add(new CostOfCard(1, MarketMarble.ColorMarble.PURPLE));
        ArrayList<CostOfCard> Blue34ProductionProfit = new ArrayList<>();
        Blue34ProductionProfit.add(new CostOfCard(1, MarketMarble.ColorMarble.YELLOW));
        Blue34ProductionProfit.add(new CostOfCard(3, MarketMarble.ColorMarble.BLUE));
        DevelopmentCard Blue34 = new DevelopmentCard(Blue34Cost, new Production(Blue34ProductionCost, Blue34ProductionProfit), 40, DevelopmentCard.colorCard.Blue, 3, 12);
        cell21 = new GridCell(Blue31, Blue32, Blue33, Blue34);




        ArrayList<CostOfCard> Yellow31Cost = new ArrayList<>();
        Yellow31Cost.add(new CostOfCard(7, MarketMarble.ColorMarble.GREY));
        ArrayList<CostOfCard> Yellow31ProductionCost = new ArrayList<>();
        Yellow31ProductionCost.add(new CostOfCard(1, MarketMarble.ColorMarble.BLUE));
        ArrayList<CostOfCard> Yellow31ProductionProfit = new ArrayList<>();
        Yellow31ProductionProfit.add(new CostOfCard(1, MarketMarble.ColorMarble.PURPLE));
        Yellow31ProductionProfit.add(new CostOfCard(3, MarketMarble.ColorMarble.RED));
        DevelopmentCard Yellow31 = new DevelopmentCard(Yellow31Cost, new Production(Yellow31ProductionCost, Yellow31ProductionProfit), 41, DevelopmentCard.colorCard.Yellow, 3, 11);


        ArrayList<CostOfCard> Yellow32Cost = new ArrayList<>();
        Yellow32Cost.add(new CostOfCard(6, MarketMarble.ColorMarble.GREY));
        ArrayList<CostOfCard> Yellow32ProductionCost = new ArrayList<>();
        Yellow32ProductionCost.add(new CostOfCard(2, MarketMarble.ColorMarble.BLUE));
        ArrayList<CostOfCard> Yellow32ProductionProfit = new ArrayList<>();
        Yellow32ProductionProfit.add(new CostOfCard(3, MarketMarble.ColorMarble.PURPLE));
        Yellow32ProductionProfit.add(new CostOfCard(2, MarketMarble.ColorMarble.RED));
        DevelopmentCard Yellow32 = new DevelopmentCard(Yellow32Cost, new Production(Yellow32ProductionCost, Yellow32ProductionProfit), 42, DevelopmentCard.colorCard.Yellow, 3, 9);


        ArrayList<CostOfCard> Yellow33Cost = new ArrayList<>();
        Yellow33Cost.add(new CostOfCard(5, MarketMarble.ColorMarble.GREY));
        Yellow33Cost.add(new CostOfCard(2, MarketMarble.ColorMarble.PURPLE));
        ArrayList<CostOfCard> Yellow33ProductionCost = new ArrayList<>();
        Yellow33ProductionCost.add(new CostOfCard(1, MarketMarble.ColorMarble.GREY));
        Yellow33ProductionCost.add(new CostOfCard(1, MarketMarble.ColorMarble.YELLOW));
        ArrayList<CostOfCard> Yellow33ProductionProfit = new ArrayList<>();
        Yellow33ProductionProfit.add(new CostOfCard(2, MarketMarble.ColorMarble.YELLOW));
        Yellow33ProductionProfit.add(new CostOfCard(2, MarketMarble.ColorMarble.BLUE));
        Yellow33ProductionProfit.add(new CostOfCard(1, MarketMarble.ColorMarble.RED));
        DevelopmentCard Yellow33 = new DevelopmentCard(Yellow33Cost, new Production(Yellow33ProductionCost, Yellow33ProductionProfit), 43, DevelopmentCard.colorCard.Yellow, 3, 10);


        ArrayList<CostOfCard> Yellow34Cost = new ArrayList<>();
        Yellow34Cost.add(new CostOfCard(4, MarketMarble.ColorMarble.GREY));
        Yellow34Cost.add(new CostOfCard(4, MarketMarble.ColorMarble.PURPLE));
        ArrayList<CostOfCard> Yellow34ProductionCost = new ArrayList<>();
        Yellow34ProductionCost.add(new CostOfCard(1, MarketMarble.ColorMarble.BLUE));
        ArrayList<CostOfCard> Yellow34ProductionProfit = new ArrayList<>();
        Yellow34ProductionProfit.add(new CostOfCard(1, MarketMarble.ColorMarble.GREY));
        Yellow34ProductionProfit.add(new CostOfCard(3, MarketMarble.ColorMarble.PURPLE));
        DevelopmentCard Yellow34 = new DevelopmentCard(Yellow34Cost, new Production(Yellow34ProductionCost, Yellow34ProductionProfit), 44, DevelopmentCard.colorCard.Yellow, 3, 12);
        cell22 = new GridCell(Yellow31, Yellow32, Yellow33, Yellow34);



        ArrayList<CostOfCard> Purple31Cost = new ArrayList<>();
        Purple31Cost.add(new CostOfCard(7, MarketMarble.ColorMarble.PURPLE));
        ArrayList<CostOfCard> Purple31ProductionCost = new ArrayList<>();
        Purple31ProductionCost.add(new CostOfCard(1, MarketMarble.ColorMarble.YELLOW));
        ArrayList<CostOfCard> Purple31ProductionProfit = new ArrayList<>();
        Purple31ProductionProfit.add(new CostOfCard(1, MarketMarble.ColorMarble.GREY));
        Purple31ProductionProfit.add(new CostOfCard(3, MarketMarble.ColorMarble.RED));
        DevelopmentCard Purple31 = new DevelopmentCard(Purple31Cost, new Production(Purple31ProductionCost, Purple31ProductionProfit), 45, DevelopmentCard.colorCard.Purple, 3, 11);


        ArrayList<CostOfCard> Purple32Cost = new ArrayList<>();
        Purple32Cost.add(new CostOfCard(6, MarketMarble.ColorMarble.PURPLE));
        ArrayList<CostOfCard> Purple32ProductionCost = new ArrayList<>();
        Purple32ProductionCost.add(new CostOfCard(2, MarketMarble.ColorMarble.GREY));
        ArrayList<CostOfCard> Purple32ProductionProfit = new ArrayList<>();
        Purple32ProductionProfit.add(new CostOfCard(3, MarketMarble.ColorMarble.YELLOW));
        Purple32ProductionProfit.add(new CostOfCard(2, MarketMarble.ColorMarble.RED));
        DevelopmentCard Purple32 = new DevelopmentCard(Purple32Cost, new Production(Purple32ProductionCost, Purple32ProductionProfit), 46, DevelopmentCard.colorCard.Purple, 3, 9);


        ArrayList<CostOfCard> Purple33Cost = new ArrayList<>();
        Purple33Cost.add(new CostOfCard(5, MarketMarble.ColorMarble.PURPLE));
        Purple33Cost.add(new CostOfCard(2, MarketMarble.ColorMarble.YELLOW));
        ArrayList<CostOfCard> Purple33ProductionCost = new ArrayList<>();
        Purple33ProductionCost.add(new CostOfCard(1, MarketMarble.ColorMarble.GREY));
        Purple33ProductionCost.add(new CostOfCard(1, MarketMarble.ColorMarble.BLUE));
        ArrayList<CostOfCard> Purple33ProductionProfit = new ArrayList<>();
        Purple33ProductionProfit.add(new CostOfCard(2, MarketMarble.ColorMarble.YELLOW));
        Purple33ProductionProfit.add(new CostOfCard(2, MarketMarble.ColorMarble.PURPLE));
        Purple33ProductionProfit.add(new CostOfCard(1, MarketMarble.ColorMarble.RED));
        DevelopmentCard Purple33 = new DevelopmentCard(Purple33Cost, new Production(Purple33ProductionCost, Purple33ProductionProfit), 47, DevelopmentCard.colorCard.Purple, 3, 10);


        ArrayList<CostOfCard> Purple34Cost = new ArrayList<>();
        Purple34Cost.add(new CostOfCard(4, MarketMarble.ColorMarble.PURPLE));
        Purple34Cost.add(new CostOfCard(4, MarketMarble.ColorMarble.BLUE));
        ArrayList<CostOfCard> Purple34ProductionCost = new ArrayList<>();
        Purple34ProductionCost.add(new CostOfCard(1, MarketMarble.ColorMarble.YELLOW));
        ArrayList<CostOfCard> Purple34ProductionProfit = new ArrayList<>();
        Purple34ProductionProfit.add(new CostOfCard(1, MarketMarble.ColorMarble.GREY));
        Purple34ProductionProfit.add(new CostOfCard(3, MarketMarble.ColorMarble.PURPLE));
        DevelopmentCard Purple34 = new DevelopmentCard(Purple34Cost, new Production(Purple34ProductionCost, Purple34ProductionProfit), 48, DevelopmentCard.colorCard.Purple, 3, 12);
        cell23 = new GridCell(Purple31, Purple32, Purple33, Purple34);









        //Creazione LeaderCards

        //Array con tutte le LeaderCards posizionate in base al loro ID (la carta con ID = 1 è posta in posizione ArrayLeaderCards[0]).

        ExtraRsc1 = new LeaderCard1(1, 5, DevelopmentCard.colorCard.Blue, DevelopmentCard.colorCard.Yellow, MarketMarble.ColorMarble.PURPLE); //pallina bianca in viola
        ExtraRsc2 = new LeaderCard1(2, 5, DevelopmentCard.colorCard.Purple, DevelopmentCard.colorCard.Green, MarketMarble.ColorMarble.BLUE); //pallina bianca in blu
        ExtraRsc3 = new LeaderCard1(3, 5, DevelopmentCard.colorCard.Green, DevelopmentCard.colorCard.Purple, MarketMarble.ColorMarble.YELLOW); //pallina bianca in giallo
        ExtraRsc4 = new LeaderCard1(4, 5, DevelopmentCard.colorCard.Yellow, DevelopmentCard.colorCard.Blue, MarketMarble.ColorMarble.GREY); //pallina bianca in grigio

        ReduceCost1 = new LeaderCard2(5, 2, DevelopmentCard.colorCard.Yellow, DevelopmentCard.colorCard.Green, MarketMarble.ColorMarble.PURPLE); //meno un viola nel costo
        ReduceCost2 = new LeaderCard2(6, 2, DevelopmentCard.colorCard.Purple, DevelopmentCard.colorCard.Blue, MarketMarble.ColorMarble.BLUE); //meno un blu nel costo
        ReduceCost3 = new LeaderCard2(7, 2, DevelopmentCard.colorCard.Yellow, DevelopmentCard.colorCard.Purple, MarketMarble.ColorMarble.YELLOW); //meno un giallo nel costo
        ReduceCost4 = new LeaderCard2(8, 2, DevelopmentCard.colorCard.Green, DevelopmentCard.colorCard.Blue, MarketMarble.ColorMarble.GREY); //meno un grigio nel costo

        ExtraWarehouse1 = new LeaderCard3(9, 3, MarketMarble.ColorMarble.GREY, MarketMarble.ColorMarble.PURPLE); //più 2 spazi viola nel warehouse
        ExtraWarehouse2 = new LeaderCard3(10, 3, MarketMarble.ColorMarble.PURPLE, MarketMarble.ColorMarble.PURPLE); //più 2 spazi blu nel warehouse
        ExtraWarehouse3 = new LeaderCard3(11, 3, MarketMarble.ColorMarble.BLUE, MarketMarble.ColorMarble.YELLOW); //più 2 spazi gialli nel warehouse
        ExtraWarehouse4 = new LeaderCard3(12, 3, MarketMarble.ColorMarble.YELLOW, MarketMarble.ColorMarble.GREY); //più 2 spazi grigi nel warehouse

        ArrayList<CostOfCard> ProductionCost1 = new ArrayList<>();
        ProductionCost1.add(new CostOfCard(1, MarketMarble.ColorMarble.PURPLE));
        ArrayList<CostOfCard> ProductionProfit1 = new ArrayList<>();
        ProductionCost1.add(new CostOfCard(1, MarketMarble.ColorMarble.UNKNOWN));
        ProductionCost1.add(new CostOfCard(1, MarketMarble.ColorMarble.RED));
        ConvertRsc1 = new LeaderCard4(13, DevelopmentCard.colorCard.Blue, 4, new Production(ProductionCost1, ProductionProfit1)); //converte un viola in una risorsa a scelta e 1 punto fede

        ArrayList<CostOfCard> ProductionCost2 = new ArrayList<>();
        ProductionCost2.add(new CostOfCard(1, MarketMarble.ColorMarble.BLUE));
        ArrayList<CostOfCard> ProductionProfit2 = new ArrayList<>();
        ProductionCost2.add(new CostOfCard(1, MarketMarble.ColorMarble.UNKNOWN));
        ProductionCost2.add(new CostOfCard(1, MarketMarble.ColorMarble.RED));
        ConvertRsc2 = new LeaderCard4(14, DevelopmentCard.colorCard.Yellow, 4, new Production(ProductionCost2, ProductionProfit2)); //converte un blu in una risorsa a scelta e 1 punto fede

        ArrayList<CostOfCard> ProductionCost3 = new ArrayList<>();
        ProductionCost3.add(new CostOfCard(1, MarketMarble.ColorMarble.YELLOW));
        ArrayList<CostOfCard> ProductionProfit3 = new ArrayList<>();
        ProductionCost3.add(new CostOfCard(1, MarketMarble.ColorMarble.UNKNOWN));
        ProductionCost3.add(new CostOfCard(1, MarketMarble.ColorMarble.RED));
        ConvertRsc3 = new LeaderCard4(15,DevelopmentCard.colorCard.Green,4, new Production(ProductionCost3, ProductionProfit3)); //converte un giallo in una risorsa a scelta e 1 punto fede


        ArrayList<CostOfCard> ProductionCost4 = new ArrayList<>();
        ProductionCost4.add(new CostOfCard(1, MarketMarble.ColorMarble.GREY));
        ArrayList<CostOfCard> ProductionProfit4 = new ArrayList<>();
        ProductionCost4.add(new CostOfCard(1, MarketMarble.ColorMarble.UNKNOWN));
        ProductionCost4.add(new CostOfCard(1, MarketMarble.ColorMarble.RED));
        ConvertRsc4 = new LeaderCard4(16,  DevelopmentCard.colorCard.Purple,4, new Production(ProductionCost4, ProductionProfit4)); //converte un grigio in una risorsa a scelta e 1 punto fede
        //ArrLeaderCards = new LeaderCard[]{ExtraRsc1, ExtraRsc2, ExtraRsc3, ExtraRsc4, ReduceCost1, ReduceCost2, ReduceCost3, ReduceCost4, ExtraWarehouse1, ExtraWarehouse2, ExtraWarehouse3, ExtraWarehouse4, ConvertRsc1, ConvertRsc2, ConvertRsc3, ConvertRsc4};
        ArrLeaderCards.add(ExtraRsc1);
        ArrLeaderCards.add(ExtraRsc2);
        ArrLeaderCards.add(ExtraRsc3);
        ArrLeaderCards.add(ExtraRsc4);
        ArrLeaderCards.add(ReduceCost1);
        ArrLeaderCards.add(ReduceCost2);
        ArrLeaderCards.add(ReduceCost3);
        ArrLeaderCards.add(ReduceCost4);
        ArrLeaderCards.add(ExtraWarehouse1);
        ArrLeaderCards.add(ExtraWarehouse2);
        ArrLeaderCards.add(ExtraWarehouse3);
        ArrLeaderCards.add(ExtraWarehouse4);
        ArrLeaderCards.add(ConvertRsc1);
        ArrLeaderCards.add(ConvertRsc2);
        ArrLeaderCards.add(ConvertRsc3);
        ArrLeaderCards.add(ConvertRsc4);
        Collections.shuffle(ArrLeaderCards);

    }

    //inserisco l'id e mi ritorna la carta
    /*public LeaderCard SelectLeadFromId(int IdLead) {
        return ArrLeaderCards[IdLead - 1];
    }*/

    public GridCell getCell00() {
        return cell00;
    }


    public GridCell getCell01() {
        return cell01;
    }

    public GridCell getCell02() {
        return cell02;
    }

    public GridCell getCell03() {
        return cell03;
    }

    public GridCell getCell10() {
        return cell10;
    }

    public GridCell getCell11() {
        return cell11;
    }

    public GridCell getCell12() {
        return cell12;
    }

    public GridCell getCell13() {
        return cell13;
    }

    public GridCell getCell20() {
        return cell20;
    }

    public GridCell getCell21() {
        return cell21;
    }

    public GridCell getCell22() {
        return cell22;
    }

    public GridCell getCell23() {
        return cell23;
    }

    public DevelopmentCard getGreen11() {
        return Green11;
    }

    public DevelopmentCard getGreen12() {
        return Green12;
    }

    public DevelopmentCard getGreen13() {
        return Green13;
    }

    public DevelopmentCard getGreen14() {
        return Green14;
    }

    public DevelopmentCard getBlue11() {
        return Blue11;
    }

    public DevelopmentCard getGreen21() {
        return Green21;
    }
    public DevelopmentCard getGreen31() {
        return Green31;
    }

    public ArrayList<LeaderCard> getTopFourLeaderCard() {
        ArrayList<LeaderCard> FourLeaderCardArray  = new ArrayList<>();
        FourLeaderCardArray.add(ArrLeaderCards.get(ArrLeaderCards.size()-1));
        ArrLeaderCards.remove(ArrLeaderCards.size()-1);
        FourLeaderCardArray.add(ArrLeaderCards.get(ArrLeaderCards.size()-1));
        ArrLeaderCards.remove(ArrLeaderCards.size()-1);
        FourLeaderCardArray.add(ArrLeaderCards.get(ArrLeaderCards.size()-1));
        ArrLeaderCards.remove(ArrLeaderCards.size()-1);
        FourLeaderCardArray.add(ArrLeaderCards.get(ArrLeaderCards.size()-1));
        ArrLeaderCards.remove(ArrLeaderCards.size()-1);
        return FourLeaderCardArray;
    }
}

/*
     */





/*
        private DevelopmentCard Yellow11 = new DevelopmentCard(new int[]{0, 0, 0, 2}, new int[]{1, 0, 0, 0}, new int[]{0, 0, 0, 0, 1}, 5, DevelopmentCard.colorCard.Yellow, 1, 1);
        private DevelopmentCard Yellow12 = new DevelopmentCard(new int[]{0, 1, 1, 1}, new int[]{0, 1, 0, 1}, new int[]{0, 0, 1, 0, 0}, 6, DevelopmentCard.colorCard.Yellow, 1, 2);
        private DevelopmentCard Yellow13 = new DevelopmentCard(new int[]{0, 0, 0, 3}, new int[]{0, 2, 0, 0}, new int[]{1, 0, 1, 1, 0}, 7, DevelopmentCard.colorCard.Yellow, 1, 3);
        private DevelopmentCard Yellow14 = new DevelopmentCard(new int[]{0, 2, 0, 2}, new int[]{1, 0, 1, 0}, new int[]{0, 2, 0, 0, 1}, 8, DevelopmentCard.colorCard.Yellow, 1, 4);
        private GridCell cell01 = new GridCell(Yellow11, Yellow12, Yellow13, Yellow14);


        private DevelopmentCard Purple11 = new DevelopmentCard(new int[]{2, 0, 0, 0}, new int[]{0, 0, 0, 1}, new int[]{0, 0, 0, 0, 1}, 9, DevelopmentCard.colorCard.Purple, 1, 1);
        private DevelopmentCard Purple12 = new DevelopmentCard(new int[]{1, 1, 1, 0}, new int[]{0, 0, 1, 0}, new int[]{0, 1, 0, 0, 0}, 10, DevelopmentCard.colorCard.Purple, 1, 2);
        private DevelopmentCard Purple13 = new DevelopmentCard(new int[]{3, 0, 0, 0}, new int[]{0, 0, 2, 0}, new int[]{1, 1, 0, 1, 0}, 11, DevelopmentCard.colorCard.Purple, 1, 3);
        private DevelopmentCard Purple14 = new DevelopmentCard(new int[]{2, 0, 0, 2}, new int[]{0, 1, 1, 0}, new int[]{0, 0, 0, 2, 1}, 12, DevelopmentCard.colorCard.Purple, 1, 4);
        private GridCell cell02 = new GridCell(Purple11, Purple12, Purple13, Purple14);

        private DevelopmentCard Blue11 = new DevelopmentCard(new int[]{0, 0, 2, 0}, new int[]{0, 1, 0, 0}, new int[]{0, 0, 0, 0, 1}, 13, DevelopmentCard.colorCard.Blue, 1, 1);
        private DevelopmentCard Blue12 = new DevelopmentCard(new int[]{1, 0, 1, 1}, new int[]{1, 0, 0, 0}, new int[]{0, 0, 0, 1, 0}, 14, DevelopmentCard.colorCard.Blue, 1, 2);
        private DevelopmentCard Blue13 = new DevelopmentCard(new int[]{0, 0, 3, 0}, new int[]{0, 0, 0, 2}, new int[]{1, 1, 1, 0, 0}, 15, DevelopmentCard.colorCard.Blue, 1, 3);
        private DevelopmentCard Blue14 = new DevelopmentCard(new int[]{2, 0, 2, 0}, new int[]{0, 1, 0, 1}, new int[]{2, 0, 0, 0, 1}, 16, DevelopmentCard.colorCard.Blue, 1, 4);
        private GridCell cell03 = new GridCell(Blue11, Blue12, Blue13, Blue14);


        private DevelopmentCard Green21 = new DevelopmentCard(new int[]{0, 4, 0, 0}, new int[]{0, 0, 0, 1}, new int[]{0, 0, 0, 0, 2}, 17, DevelopmentCard.colorCard.Green, 2, 5);
        private DevelopmentCard Green22 = new DevelopmentCard(new int[]{2, 3, 0, 0}, new int[]{1, 1, 0, 0}, new int[]{0, 0, 0, 3, 0}, 18, DevelopmentCard.colorCard.Green, 2, 6);
        private DevelopmentCard Green23 = new DevelopmentCard(new int[]{0, 5, 0, 0}, new int[]{0, 0, 2, 0}, new int[]{0, 0, 0, 2, 2}, 19, DevelopmentCard.colorCard.Green, 2, 7);
        private DevelopmentCard Green24 = new DevelopmentCard(new int[]{0, 3, 3, 0}, new int[]{0, 0, 1, 0}, new int[]{0, 2, 0, 0, 1}, 20, DevelopmentCard.colorCard.Green, 2, 8);
        private GridCell cell10 = new GridCell(Green21, Green22, Green23, Green24);

        private DevelopmentCard Yellow21 = new DevelopmentCard(new int[]{0, 0, 0, 4}, new int[]{0, 1, 0, 0}, new int[]{0, 0, 0, 0, 2}, 21, DevelopmentCard.colorCard.Yellow, 2, 5);
        private DevelopmentCard Yellow22 = new DevelopmentCard(new int[]{0, 2, 0, 3}, new int[]{0, 1, 0, 1}, new int[]{0, 0, 3, 0, 0}, 22, DevelopmentCard.colorCard.Yellow, 2, 6);
        private DevelopmentCard Yellow23 = new DevelopmentCard(new int[]{0, 0, 0, 5}, new int[]{0, 2, 0, 0}, new int[]{2, 0, 0, 0, 2}, 23, DevelopmentCard.colorCard.Yellow, 2, 7);
        private DevelopmentCard Yellow24 = new DevelopmentCard(new int[]{3, 0, 0, 3}, new int[]{0, 1, 0, 0}, new int[]{0, 0, 2, 0, 1}, 24, DevelopmentCard.colorCard.Yellow, 2, 8);
        private GridCell cell11 = new GridCell(Yellow21, Yellow22, Yellow23, Yellow24);

        private DevelopmentCard Purple21 = new DevelopmentCard(new int[]{4, 0, 0, 0}, new int[]{0, 0, 1, 0}, new int[]{0, 0, 0, 0, 2}, 25, DevelopmentCard.colorCard.Purple, 2, 5);
        private DevelopmentCard Purple22 = new DevelopmentCard(new int[]{3, 0, 2, 0}, new int[]{1, 0, 1, 0}, new int[]{3, 0, 0, 0, 0}, 26, DevelopmentCard.colorCard.Purple, 2, 6);
        private DevelopmentCard Purple23 = new DevelopmentCard(new int[]{5, 0, 0, 0}, new int[]{0, 0, 0, 2}, new int[]{0, 0, 2, 0, 2}, 27, DevelopmentCard.colorCard.Purple, 2, 7);
        private DevelopmentCard Purple24 = new DevelopmentCard(new int[]{3, 3, 0, 0}, new int[]{0, 0, 0, 1}, new int[]{2, 0, 0, 0, 1}, 28, DevelopmentCard.colorCard.Purple, 2, 8);
        private GridCell cell12 = new GridCell(Purple21, Purple22, Purple23, Purple24);

        private DevelopmentCard Blue21 = new DevelopmentCard(new int[]{0, 0, 4, 0}, new int[]{1, 0, 0, 0}, new int[]{0, 0, 0, 0, 2}, 29, DevelopmentCard.colorCard.Blue, 2, 5);
        private DevelopmentCard Blue22 = new DevelopmentCard(new int[]{0, 0, 3, 2}, new int[]{0, 0, 1, 1}, new int[]{3, 0, 0, 0, 0}, 30, DevelopmentCard.colorCard.Blue, 2, 6);
        private DevelopmentCard Blue23 = new DevelopmentCard(new int[]{0, 0, 5, 0}, new int[]{2, 0, 0, 0}, new int[]{0, 2, 0, 0, 2}, 31, DevelopmentCard.colorCard.Blue, 2, 7);
        private DevelopmentCard Blue24 = new DevelopmentCard(new int[]{0, 0, 3, 3}, new int[]{1, 0, 0, 0}, new int[]{0, 0, 0, 2, 1}, 32, DevelopmentCard.colorCard.Blue, 2, 8);
        private GridCell cell13 = new GridCell(Blue21, Blue22, Blue23, Blue24);

        private DevelopmentCard Green31 = new DevelopmentCard(new int[]{0, 6, 0, 0}, new int[]{2, 0, 0, 0}, new int[]{0, 0, 0, 3, 2}, 33, DevelopmentCard.colorCard.Green, 3, 9);
        private DevelopmentCard Green32 = new DevelopmentCard(new int[]{2, 5, 0, 0}, new int[]{1, 0, 1, 0}, new int[]{0, 2, 0, 2, 1}, 34, DevelopmentCard.colorCard.Green, 3, 10);
        private DevelopmentCard Green33 = new DevelopmentCard(new int[]{0, 7, 0, 0}, new int[]{1, 0, 0, 0}, new int[]{0, 0, 1, 0, 3}, 35, DevelopmentCard.colorCard.Green, 3, 11);
        private DevelopmentCard Green34 = new DevelopmentCard(new int[]{0, 4, 4, 0}, new int[]{0, 0, 0, 1}, new int[]{0, 1, 3, 0, 0}, 36, DevelopmentCard.colorCard.Green, 3, 12);
        private GridCell cell20 = new GridCell(Green31, Green32, Green33, Green34);

        private DevelopmentCard Yellow31 = new DevelopmentCard(new int[]{0, 0, 0, 6}, new int[]{0, 2, 0, 0}, new int[]{3, 0, 0, 0, 2}, 37, DevelopmentCard.colorCard.Yellow, 3, 9);
        private DevelopmentCard Yellow32 = new DevelopmentCard(new int[]{2, 0, 0, 5}, new int[]{1, 0, 0, 1}, new int[]{0, 2, 2, 0, 1}, 38, DevelopmentCard.colorCard.Yellow, 3, 10);
        private DevelopmentCard Yellow33 = new DevelopmentCard(new int[]{0, 0, 0, 7}, new int[]{0, 1, 0, 0}, new int[]{1, 0, 0, 0, 3}, 39, DevelopmentCard.colorCard.Yellow, 3, 11);
        private DevelopmentCard Yellow34 = new DevelopmentCard(new int[]{4, 0, 0, 4}, new int[]{0, 1, 0, 0}, new int[]{3, 0, 0, 1, 0}, 40, DevelopmentCard.colorCard.Yellow, 3, 12);
        private GridCell cell21 = new GridCell(Yellow31, Yellow32, Yellow33, Yellow34);

        private DevelopmentCard Purple31 = new DevelopmentCard(new int[]{6, 0, 0, 0}, new int[]{0, 0, 0, 2}, new int[]{0, 0, 3, 0, 2}, 41, DevelopmentCard.colorCard.Purple, 3, 9);
        private DevelopmentCard Purple32 = new DevelopmentCard(new int[]{5, 0, 2, 0}, new int[]{0, 1, 0, 1}, new int[]{2, 0, 2, 0, 1}, 42, DevelopmentCard.colorCard.Purple, 3, 10);
        private DevelopmentCard Purple33 = new DevelopmentCard(new int[]{7, 0, 0, 0}, new int[]{0, 0, 1, 0}, new int[]{0, 0, 0, 1, 3}, 43, DevelopmentCard.colorCard.Purple, 3, 11);
        private DevelopmentCard Purple34 = new DevelopmentCard(new int[]{4, 4, 0, 0}, new int[]{0, 0, 1, 0}, new int[]{1, 0, 0, 3, 0}, 44, DevelopmentCard.colorCard.Purple, 3, 12);
        private GridCell cell22 = new GridCell(Purple31, Purple32, Purple33, Purple34);

        private DevelopmentCard Blue31 = new DevelopmentCard(new int[]{0, 0, 6, 0}, new int[]{2, 0, 0, 0}, new int[]{0, 3, 0, 0, 2}, 45, DevelopmentCard.colorCard.Blue, 3, 9);
        private DevelopmentCard Blue32 = new DevelopmentCard(new int[]{0, 0, 5, 2}, new int[]{0, 1, 1, 0}, new int[]{2, 0, 0, 2, 1}, 46, DevelopmentCard.colorCard.Blue, 3, 10);
        private DevelopmentCard Blue33 = new DevelopmentCard(new int[]{0, 0, 7, 0}, new int[]{0, 0, 0, 1}, new int[]{0, 1, 0, 0, 3}, 47, DevelopmentCard.colorCard.Blue, 3, 11);
        private DevelopmentCard Blue34 = new DevelopmentCard(new int[]{0, 0, 4, 4}, new int[]{1, 0, 0, 0}, new int[]{0, 3, 1, 0, 0}, 48, DevelopmentCard.colorCard.Blue, 3, 12);
        private GridCell cell23 = new GridCell(Blue31, Blue32, Blue33, Blue34);

        //Array con tutte le DevelopmentCards posizionate in base al loro ID (la carta con ID = 1 è posta in posizione ArrayDevelopmentCards[0]).
        //Ciò è fatto per sapere che quando l'ID=0 non è ancora stato modificato e non rappresenta nessuna carta.
        private DevelopmentCard[] ArrDevelopmentCards = {Green11, Green12, Green13, Green14, Yellow11, Yellow12, Yellow13, Yellow14, Purple11, Purple12, Purple13, Purple14, Blue11, Blue12, Blue13, Blue14, Green21, Green22, Green23, Green24, Yellow21, Yellow22, Yellow23, Yellow24, Purple21, Purple22, Purple23, Purple24, Blue21, Blue22, Blue23, Blue24, Green31, Green32, Green33, Green34, Yellow31, Yellow32, Yellow33, Yellow34, Purple31, Purple32, Purple33, Purple34, Blue31, Blue32, Blue33, Blue34};

        //inserisco l'id e mi ritorna la carta
        private DevelopmentCard SelectDevFromId ( int IdDev){
            return ArrDevelopmentCards[IdDev - 1];
        }
        /*
 */

