package org.hangman;

import java.util.List;

public class Display {

    public void printWelcomeMessage() {
        System.out.printf("%nWelcome to Hangman.%nChoose a letter and guess the word before your lives run out.%nYou have 7 lives. Good luck.%n%n");
//        System.out.println("You have 7 lives. Good luck.");
    }

    public void printLivesRemaining(int lives) {
        System.out.println("You have " + lives + " lives remaining");
    }

    public String printHiddenWord(String word) {

        String hiddenWord = "";

        for (int i = 0; i < word.length(); i++) {
            hiddenWord += "_ ";
        }

        System.out.println(hiddenWord + "\n");
        return hiddenWord;
    }

    //overloading
    public String printHiddenWord(String word, char letter, List<Character> correctLettersArray) {

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
        return hiddenWord;
    }

    public void printGuessedLetters(List<Character> guessedLetters) {

        System.out.println("Guesses so far: " + guessedLetters + "\n");
    }

    public void printSelectLetterPrompt() {
        System.out.println("Please select a letter:");
    }

    public void printPlayersGuess(Character letter) {
        System.out.println("You guessed: " + Character.toLowerCase(letter));
    }

    public void printDuplicateGuessMessage(char letter) {
        System.out.println(letter + " has already been guessed. Please guess again.");
    }

    public void printHiddenWordInPlay(String hiddenWordInPlay) {
        System.out.println(hiddenWordInPlay);
    }

    public void printIncorrectGuessFeedback() {
        System.out.println("That's an incorrect guess.");
    }

    public void printCorrectGuessFeedback() {
        System.out.println("Correct!");
    }

    public void printWinMessage() {
        System.out.println("You win! Well done!");
    }

    public void printGameOverMessage() {
        System.out.println("You've run out of lives. Game over.");
    }

}
