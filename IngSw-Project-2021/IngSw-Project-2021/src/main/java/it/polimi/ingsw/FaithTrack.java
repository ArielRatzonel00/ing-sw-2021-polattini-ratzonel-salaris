package it.polimi.ingsw;

public class FaithTrack {
    private int PopeFavorTiles;
    private boolean Multiplayer;
    private int RedPosition;
    private int BlackPosition;
    private int points;

    public void moveForwardRed(){
        RedPosition++;
        //if RedPosition = casella in cui c'è qualcosa di speciale, fai la cosa speciale chiamando pope space action
        // if RedPosition = Numero, Points = points + valore casella
    }
    public void moveForwardBlack(){
        BlackPosition++;
        //if BlackPosition = casella in cui c'è qualcosa di speciale, fai la cosa speciale

    }
    public int getRedPosition(){
        return RedPosition;
    } // get posizione pedina rossa
    public int getBlackPosition(){
        return BlackPosition;
    } // get posizione pedina nera
    public int getPoints(){
        return points;
    } // get punti totalizzati
    public void PopeSpaceAction(){
        // cosa speciale
    } // fai l'azione speciale

}
