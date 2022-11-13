package br.com.softblue.jogoforca.game;

// não obriga lancar o throws
public class GameException extends RuntimeException{

    public GameException(String message) {
        super(message);
    }
}
