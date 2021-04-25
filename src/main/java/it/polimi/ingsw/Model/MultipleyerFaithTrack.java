package it.polimi.ingsw.Model;

import java.util.ArrayList;

public class MultipleyerFaithTrack extends FaithTrack{
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
}
