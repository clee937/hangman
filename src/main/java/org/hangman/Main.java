package org.hangman;

public class Main {
    public static void main(String[] args) {
        
        Game game = new Game(7);
        Display display = new Display("Hangman", 7);

        game.startGame(display);

    }
}