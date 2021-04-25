package it.polimi.ingsw.Model;

public class SinglePlayerFaithTrack extends FaithTrack {
    private int BlackPosition = 0;

    public void setBlackPosition(int blackPosition) {
        BlackPosition += blackPosition;
        if (BlackPosition == 8 && popeFavor1 == popeFavorState.Unabled) {
            if (RedPosition < 5) {
                setPopeFavor1(popeFavorState.Deleted);
            } else {
                setPopeFavor1(popeFavorState.Activate);
                points += 2;
            }
        }

        else if (BlackPosition == 16 && popeFavor2 == popeFavorState.Unabled) {
            if (RedPosition < 12) {
                setPopeFavor1(popeFavorState.Deleted);
            } else {
                setPopeFavor2(popeFavorState.Activate);
                points += 3;
            }
        }
        else if (BlackPosition == 20 && popeFavor3 == popeFavorState.Unabled) {
            if (RedPosition < 19) {
                setPopeFavor3(popeFavorState.Deleted);
            } else {
                setPopeFavor3(popeFavorState.Activate);
                points += 4;
            }

        }
    }
    public void setRedPosition(int redPosition) {
        RedPosition += redPosition;
        if (RedPosition == 8 && popeFavor1 == popeFavorState.Unabled){
            setPopeFavor1(popeFavorState.Activate);
            points += 2;
        }
        else if(RedPosition == 16 && popeFavor2 == popeFavorState.Unabled){
            setPopeFavor2(popeFavorState.Activate);
            points += 3;
        }
        else if (RedPosition == 20 && popeFavor3 == popeFavorState.Unabled){
            setPopeFavor3(popeFavorState.Activate);
            points += 4;
        }
    }
}
