package it.polimi.ingsw.Network.Messages;

public class TextMessage extends Message{
    String text;
    public TextMessage() {
        this.typeOfMessage = "TextMessage";
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
