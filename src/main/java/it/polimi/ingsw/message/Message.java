package it.polimi.ingsw.message;

import it.polimi.ingsw.Model.Player;

import java.io.Serializable;

public abstract class Message implements Serializable {

    //private static final long serialVersionUID = -1220918273625162876L;
    private final Player client;
    private final TypeMessage type;
    private final int PlayerIndex = client.getIndex();


    public Message(int PlayerIndex, TypeMessage type) {
        this.client = client;
        this.type = type;
    }

    public Player getClient() {
        return client;
    }

    public TypeMessage getType() {
        return type;
    }

}
