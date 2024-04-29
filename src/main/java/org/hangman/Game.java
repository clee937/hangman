package org.hangman;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final char[] alphabet = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    private int livesRemaining = 7;
    private String randomWord = "";
    private String hiddenWordInPlay = "";
    private char currentGuess;
    private ArrayList<Character> guessedLetters = new ArrayList<>();

    public List<Character> getGuessedLetters() {
        return guessedLetters;
    }

    public void setGuessedLetters(char guessedLetter) {
        this.guessedLetters.add(guessedLetter);
    }

    public int getLivesRemaining() {
        return this.livesRemaining;
    }

    public void setLivesRemaining(int livesRemaining) {
        this.livesRemaining = livesRemaining;
    }

    public String getRandomWord() {
        return this.randomWord;
    }

    public void setRandomWord(String randomWord) {
        this.randomWord = randomWord;
    }

    public String getHiddenWordInPlay() {
        return hiddenWordInPlay;
    }

    public void setHiddenWordInPlay(String hiddenWord) {
        this.hiddenWordInPlay = hiddenWord;
    }

    public void playGame(Display display, WordLibrary wordLibrary, CommandPrompter commandPrompter) {
        display.printWelcomeMessage();
        randomWord = wordLibrary.getRandomWord().toLowerCase();
        hiddenWordInPlay = display.printHiddenWord(randomWord);

        while (livesRemaining > 0 && hiddenWordInPlay.contains("_")) {
            handleGuessLogic(display, commandPrompter);
        }
        checkGameState(display);
    }

    public void handleGuessLogic(Display display, CommandPrompter commandPrompter) {

        currentGuess = commandPrompter.getUsersGuess(this);
        boolean invalidGuess = checkIfLetterAlreadyGuessed(currentGuess);

        if (!invalidGuess) {
            boolean foundGuessedLetter = checkWordContainsGuessedLetter(currentGuess);

            if (foundGuessedLetter) {
                guessedLetters.add(currentGuess);
                display.printCorrectGuessFeedback();
                display.printGuessedLetters(getGuessedLetters());
                display.printLivesRemaining(getLivesRemaining());

            } else {
                display.printIncorrectGuessFeedback();
                livesRemaining -= 1;
                display.printLivesRemaining(livesRemaining);
                guessedLetters.add(currentGuess);
                display.printGuessedLetters(guessedLetters);
            }
            hiddenWordInPlay = display.printHiddenWord(randomWord, currentGuess, guessedLetters);
            return;

        } else {
            display.printDuplicateGuessMessage(currentGuess);
        }
    }

    public boolean checkIfGuessIsALetter(char guessedLetter) {

        boolean isLetter = false;

        for (char letter : alphabet) {

            if (letter == guessedLetter) {
                isLetter = true;
                break;
            }
        }
        return isLetter;
    }

    public boolean checkIfLetterAlreadyGuessed(Character guessedLetter) {
        return guessedLetters.contains(guessedLetter);
    }

    public boolean checkWordContainsGuessedLetter(char guessedLetter) {
        return getRandomWord().contains(Character.toString(guessedLetter));
    }

    public void checkGameState(Display display) {
        if (!hiddenWordInPlay.contains("_")) {
            display.printWinMessage();
        } else if (getLivesRemaining() == 0) {
            display.printGameOverMessage();
        }
    }
}


