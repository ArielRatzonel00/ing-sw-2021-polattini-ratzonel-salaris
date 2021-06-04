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
    private int TotalResources = 0;

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

    public ArrayList<Integer> allResources(){
        ArrayList allResources = new ArrayList();
        allResources.add(shield);
        allResources.add(stone);
        allResources.add(servant);
        allResources.add(coin);
        return allResources;
    }

    public void AddResource(int num, MarketMarble.ColorMarble ColorOfResource){
        switch (ColorOfResource) {
            case BLUE:
                this.shield += num;
                break;
            case GREY:
                this.stone += num;
                break;

            case PURPLE:
                this.servant += num;
                break;

            case YELLOW:
                this.coin += num;
                break;

            default: break;

        }
    }
    // Methods that add #num Resources of colorMarble

    public void RemoveResourcesFromStrongbox(int number, MarketMarble.ColorMarble colorMarble) {
        switch (colorMarble) {
            case BLUE:
                this.shield -= number;
                break;
            case GREY:
                this.stone -= number;
                break;
            case PURPLE:
                this.servant -= number;
                break;

            case YELLOW:
                this.coin -= number;
                break;
            default:break;
        }
    } // Method that removes #number resources

    public int getNumberOfTotalResourcesInStrongbox(){
        TotalResources = 0;
        TotalResources = servant + stone + shield + coin;
        return TotalResources;
    }
/*
    public ArrayList<Integer> getResources(){
        ArrayList<Integer> resources = new ArrayList<>();
        resources.add(shield); // Posizione 0 Shield
        resources.add(stone); // Posizione 1 Stone
        resources.add(servant); //Posizione 2 Servant
        resources.add(coin); // Posizione 3 Servant
        return resources;
    }

 */
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