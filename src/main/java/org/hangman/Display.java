package org.hangman;

import java.util.List;

public class Display {

    public void printWelcomeMessage(String name) {
        System.out.println("Welcome to " + name + "." + "\n" + "Choose a letter and guess the word before your lives run out.");
    }

    public void printLivesRemaining(int lives) {
        System.out.println("You have " + lives + " lives remaining.");
    }

    public void printUnguessedLetters(String word) {

        String underscoresToPrint = "";

        for (int i = 0; i < word.length(); i++) {
            underscoresToPrint += "_ ";
        }

        System.out.println(underscoresToPrint + "\n");
    }

    //overloading
    public void printUnguessedLetters(String word, char letter, List<Character> correctLettersArray) {

        String hiddenWord = "";

        for (int i = 0; i < word.length(); i++) {

            if (word.toCharArray()[i] == letter) {
                hiddenWord += letter + " ";
            } else if (correctLettersArray.contains(word.toCharArray()[i])) {
                hiddenWord += word.toCharArray()[i] + " ";
            } else {
                hiddenWord += "_ ";
            }
        }
        System.out.println(hiddenWord + "\n");
    }

    public void printGuessedLetters(List<Character> guessedLetters) {

        System.out.println("Guesses so far: " + guessedLetters);
    }

    public void printSelectLetterPrompt() {
        System.out.println("Please select a letter:");
    }

    public void printPlayersGuess(Character letter) {
        System.out.println("You guessed: " + Character.toLowerCase(letter));
    }

    public void printDuplicateGuessMessage(char letter) {
        System.out.println(letter + " has already been guessed. Please guess again" + Character.toLowerCase(letter));
    }
}
