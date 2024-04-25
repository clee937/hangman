package org.hangman;

public class Display {

    private String name;
    private int livesRemaining;

    public Display(String name, int lives) {
        this.name = name;
        this.livesRemaining = lives;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLivesRemaining() {
        return livesRemaining;
    }

    public void setLivesRemaining(int livesRemaining) {
        this.livesRemaining = livesRemaining;
    }

    public void printWelcomeMessage() {
        System.out.println("Welcome to " + getName());
    }
}
