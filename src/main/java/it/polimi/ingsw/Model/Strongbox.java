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

    /**
     * @param ColorOfResource color of the marble
     * @return the number of the resources that has the color of the parameter passed
     */
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
    }

    /**
     * @return an array that contains the amount of every resource in the strongbox
     */
    public ArrayList<Integer> allResources() {
        ArrayList<Integer> allResources = new ArrayList<>();
        allResources.add(shield);
        allResources.add(stone);
        allResources.add(servant);
        allResources.add(coin);
        return allResources;
    }

    /**
     * Adds num resources of ColorOfResource color
     * @param num number of resources to add
     * @param ColorOfResource color of the resources to add
     */
    public void AddResource(int num, MarketMarble.ColorMarble ColorOfResource) {
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
        }
    }
    // Methods that add #num Resources of colorMarble

    /**
     * Removes number resources of colorMarble
     * @param number number of resources to remove
     * @param colorMarble color of resourcrs to remove
     */
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
            default:
                break;
        }
    }

    /**
     * @return the number of total resources in the strongbox
     */
    public int getNumberOfTotalResourcesInStrongbox() {
        TotalResources = 0;
        TotalResources = servant + stone + shield + coin;
        return TotalResources;
    }
}