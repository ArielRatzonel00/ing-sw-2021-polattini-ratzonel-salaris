package it.polimi.ingsw.Model;

public class Strongbox {
    private int servant;
    private int shield;
    private int coin;
    private int stone;
    public Strongbox() {
        this.servant = 0;
        this.shield = 0;
        this.coin = 0;
        this.stone = 0;
    }

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

    public void AddShield(int num) {
        this.shield+= num;
    }

    public void AddCoin(int num) {
        this.coin+=num;
    }

    public void AddServant(int num) {
        this.servant+=num;
    }

    public void AddStone(int num) {
        this.stone+=num;
    }

    public void RemoveServant(int num) {
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
    }
    public void RemoveResourcesFromStrongbox(int resources[]){
        RemoveServant(resources[0]);
        RemoveShield(resources[1]);
        RemoveCoin(resources[2]);
        RemoveStone(resources[3]);
    }
    public int[] getTotalResourcesStrongbox(){
        int[] total={0,0,0,0};
        total[0]=getServant();
        total[1]=getShield();
        total[2]=getCoin();
        total[3]=getStone();
      return total;

    }
}
