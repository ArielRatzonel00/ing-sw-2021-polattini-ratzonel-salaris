package it.polimi.ingsw.Model;

// class that represents the Strongbox. Every player has one Strongbox

import it.polimi.ingsw.Model.Marble.MarketMarble;

import java.io.Serializable;
import java.util.ArrayList;

public class Strongbox implements Serializable {
    private int servant;
    private int shield;
    private int coin;
    private int stone;

    public Strongbox() {
        this.servant = 0;
        this.shield = 0;
        this.coin = 0;
        this.stone = 0;
    } // Every resource is represented by a counter

    public int CountResources(MarketMarble.ColorMarble ColorOfResource) {
        switch (ColorOfResource) {
            case BLUE:
                return shield;

            case GREY:
                return stone;

            case PURPLE:
                return servant;

            case YELLOW:
                return coin;

            default:
                return 0;
        }
    } // Method that returns the number of the resources that has the color of the parameter passed

    public void AddResource(int num, MarketMarble.ColorMarble ColorOfResource){
        switch (ColorOfResource) {
            case BLUE:
                this.shield += num;

            case GREY:
                this.stone += num;

            case PURPLE:
                this.servant += num;

            case YELLOW:
                this.coin += num;

        }
    }
    // Methods that add #num Resources of colorMarble

    public void RemoveResourcesFromStrongbox(int number, MarketMarble.ColorMarble colorMarble) {
        switch (colorMarble) {
            case BLUE:
                this.shield -= number;

            case GREY:
                this.stone -= number;

            case PURPLE:
                this.servant -= number;

            case YELLOW:
                this.coin -= number;
        }
    } // Method that removes #number resouces

    public int getNumberOfTotalResoucesInStrongbox(){
        int Resources;
        Resources = servant + stone + shield + coin;
        return Resources;
    }

    public ArrayList<Integer> getResources(){
        ArrayList<Integer> resources = new ArrayList<>();
        resources.add(shield); // Posizione 0 Shield
        resources.add(stone); // Posizione 1 Stone
        resources.add(servant); //Posizione 2 Servant
        resources.add(coin); // Posizione 3 Servant
        return resources;
    }
}
/*
    public int[] getTotalResourcesStrongbox(){
        int[] total={0,0,0,0};
        total[0]=getServant();
        total[1]=getShield();
        total[2]=getCoin();
        total[3]=getStone();
      return total;

    }
} // non penso serva
*/




 /* public void RemoveServant(int num) {
        this.servant-=num;
    }

    public void RemoveShield(int num) {
        this.shield-=num;
    }

    public void RemoveCoin(int num) {
        this.coin-=num;
    }

    public void RemoveStone(int num) {
        this.stone-=num;
    } // di base non serve perchè ho remove generale

    */


 /*
    public int getShield() {
        return shield;
    }

    public int getCoin() {
        return coin;
    }

    public int getServant() {
        return servant;
    }

    public int getStone() {
        return stone;
    }
*/ // di base non servono perchè ho CountResources