package org.hangman;

public class Display {
    
    public void printWelcomeMessage(String name) {
        System.out.println("Welcome to " + name + "." + "\n" + "Choose a letter and guess the word before your lives run out.");
    }

    public void printLivesRemaining(int lives) {
        System.out.println("You have " + lives + " lives remaining.");
    }

    public void showUnguessedLetters(String word) {

        String underscoresToPrint = "";

        for (int i = 0; i < word.length(); i++) {
            underscoresToPrint += "_ ";
        }

        System.out.println(underscoresToPrint);
    }
}
