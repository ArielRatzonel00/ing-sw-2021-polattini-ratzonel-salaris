package it.polimi.ingsw.Network.Messages;

    /**
     * Enum that contains all the possible types of message present
     * */
    public enum TypeMessage {
        //Used in lobby
        NICKNAME, IS_THREE_PLAYERS_GAME,
        //Used in setup
        GODLIKE_CHOOSE_CARDS, SELECT_CARD, SELECT_WORKER,
        MOVE, USE_POWER, BUILD, BUILD_POWER, GODLIKE_CHOOSE_FIRST_PLAYER, PUT_WORKER, END_TURN,

        //Used in turn
        ACTION_MESSAGE,
        //Management message
        ERROR, ALREADY_SET_NICKNAME, CANT_CHOOSE_PLAYERS_NUMBER,
        NOT_BE_GOD_LIKE, WRONG_NUMBER_CARDS, NOT_YOUR_TURN, CELL_OCCUPIED,
        OK, WRONG_GAME_STATE, UPDATE_STATE, WRONG_GOD_NAME, WINNER, LOSER, END_GAME, CURRENT_PLAYER, PLAYERINDEX_CONNECTION,

        //Management connection
        PING, CLOSE_CONNECTION, PONG,

        POSITION;
    }
