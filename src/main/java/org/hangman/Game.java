package org.hangman;

public class Game {

    private int livesRemaining = 7;

    public Game(int lives) {
        this.livesRemaining = lives;
    }

    public int getLivesRemaining() {
        return livesRemaining;
    }

    public void setLivesRemaining(int livesRemaining) {
        this.livesRemaining = livesRemaining;
    }

    public void startGame(Display display) {
        display.printWelcomeMessage();
    }
}
