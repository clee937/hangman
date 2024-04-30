package org.hangman;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final char[] alphabet = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    private int livesRemaining = 7;
    private String randomWord = "";
    private String hiddenWordInPlay = "";
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
        randomWord = wordLibrary.getRandomWord().toUpperCase();
        hiddenWordInPlay = display.printHiddenWord(randomWord);

        while (livesRemaining > 0 && hiddenWordInPlay.contains("_")) {
            handleGuessLogic(display, commandPrompter);
        }
        checkGameState(display);
        boolean playAgain = commandPrompter.askToPlayAgain();

        if (playAgain) {
            resetGame();
            playGame(display, wordLibrary, commandPrompter);
        } else {
            display.printEndGameMessage();
        }
    }

    public void handleGuessLogic(Display display, CommandPrompter commandPrompter) {

        char currentGuess = commandPrompter.getUsersGuess(this);
        boolean invalidGuess = checkIfLetterAlreadyGuessed(currentGuess);

        if (!invalidGuess) {
            guessedLetters.add(currentGuess);
            boolean foundGuessedLetter = checkWordContainsGuessedLetter(currentGuess);

            if (foundGuessedLetter) {
                display.printCorrectGuessFeedback();
            } else {
                display.printIncorrectGuessFeedback();
                livesRemaining -= 1;
            }

            display.printGuessedLetters(guessedLetters);
            display.printLivesRemaining(livesRemaining);
            hiddenWordInPlay = display.printHiddenWord(randomWord, currentGuess, guessedLetters);

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
        return randomWord.contains(Character.toString(guessedLetter));
    }

    public void checkGameState(Display display) {
        if (!hiddenWordInPlay.contains("_")) {
            display.printWinMessage(livesRemaining);
        } else if (livesRemaining == 0) {
            display.printGameOverMessage();
        }
    }

    public void resetGame() {
        livesRemaining = 7;
        randomWord = "";
        hiddenWordInPlay = "";
        guessedLetters = new ArrayList<>();

    }
}


