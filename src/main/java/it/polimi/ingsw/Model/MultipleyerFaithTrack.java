package it.polimi.ingsw.Model;

import java.io.Serializable;
import java.util.ArrayList;

public class MultipleyerFaithTrack extends FaithTrack implements Serializable {
    private ArrayList<Player> OtherPlayers = new ArrayList<>();

    public void setOtherPlayers(ArrayList<Player> otherPlayers) {
        OtherPlayers = otherPlayers;
    }

    @Override
    public void setRedPosition(int redPosition) {
        RedPosition  += redPosition;
        if (RedPosition == 8 || RedPosition == 16 || RedPosition == 24){
            if (RedPosition == 8){
                if (popeFavor1 == popeFavorState.Unabled){
                    setPopeFavor1(popeFavorState.Activate);
                    for (Player otherPlayer : OtherPlayers){
                        otherPlayer.CheckPositionPopeFavor(RedPosition);{
                        }
                    }
                    points += 2;
                }
            }
            else if (RedPosition == 16){
                if (popeFavor2 == popeFavorState.Unabled){
                    setPopeFavor2(popeFavorState.Activate);
                    for (Player otherPlayer : OtherPlayers){
                        otherPlayer.CheckPositionPopeFavor(RedPosition);{
                        }
                    }
                }
                points += 3;
            }
            else {
                if (popeFavor3 == popeFavorState.Unabled){
                    setPopeFavor3(popeFavorState.Activate);
                    for (Player otherPlayer : OtherPlayers){
                        otherPlayer.CheckPositionPopeFavor(RedPosition);
                    }
                    points += 4;
                }

            }
        }
    }
    public Integer TotalPoints(){
        if (RedPosition >= 3 && RedPosition < 6){
            return 1;
        }
        else if (RedPosition >= 6 && RedPosition < 9){
            return 2;
        }
        else if (RedPosition >= 9 && RedPosition < 12){
            return 4;
        }
        else if (RedPosition >= 12 && RedPosition < 15){
            return 6;
        }
        else if (RedPosition >= 15 && RedPosition < 18){
            return 9;
        }
        else if (RedPosition >= 18 && RedPosition < 21){
            return 12;
        }
        else if (RedPosition >= 21 && RedPosition < 24){
            return 16;
        }
        else if (RedPosition == 24){
            return 20;
        } else {
            return 0;
        }

    }
}
