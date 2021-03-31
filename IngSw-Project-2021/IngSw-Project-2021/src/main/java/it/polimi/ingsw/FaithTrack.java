package it.polimi.ingsw;

public class FaithTrack {
    private int PopeFavorTiles;
    private boolean Multiplayer;
    private int RedPosition;
    private int BlackPosition;
    private int points;

    public void moveForwardRed(){
        RedPosition++;

    }
    public void moveForwardBlack(){
        BlackPosition++;

    }
    public int getRedPosition(){
        return RedPosition;
    }
    public int getBlackPosition(){
        return BlackPosition;
    }
    public int getPoints(){
        return points;
    }
    public void PopeSpaceAction(){
        //
    }

}
