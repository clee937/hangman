package org.hangman;

public class Game {

    private String name = "Hangman";
    private int livesRemaining = 7;
    private boolean gameInPlay = true;

    public Game() {
        this.name = this.getName();
        this.livesRemaining = this.getLivesRemaining();
    }

//    public Game(String name, int lives) {
//        this.setName(name);
//        this.setLivesRemaining(lives);
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isGameInPlay() {
        return gameInPlay;
    }

    public void setGameInPlay(boolean gameInPlay) {
        this.gameInPlay = gameInPlay;
    }

    public int getLivesRemaining() {
        return livesRemaining;
    }

    public void setLivesRemaining(int livesRemaining) {
        this.livesRemaining = livesRemaining;
    }

    public void startGame(Display display) {
        display.printWelcomeMessage(this.name);
        display.printLivesRemaining(this.getLivesRemaining());

    }
}

