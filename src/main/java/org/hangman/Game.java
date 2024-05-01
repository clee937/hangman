package org.hangman;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final ArrayList<Character> guessedLetters = new ArrayList<>();
    private final Display display;
    private final CommandPrompter commandPrompter;
    private final WordLibrary wordLibrary;
    private int livesRemaining = 7;
    private String randomWord = "";
    private String hiddenWordInPlay = "";


    public Game(Display display, WordLibrary wordLibrary, CommandPrompter commandPrompter) {
        this.display = display;
        this.wordLibrary = wordLibrary;
        this.commandPrompter = commandPrompter;
    }

    public List<Character> getGuessedLetters() {
        return guessedLetters;
    }

    private int getLivesRemaining() {
        return this.livesRemaining;
    }

    public void start() {
        display.printWelcomeMessage();
        randomWord = wordLibrary.getRandomWord().trim().toUpperCase();
        hiddenWordInPlay = display.printHiddenWord(randomWord);

        while (livesRemaining > 0 && hiddenWordInPlay.contains("_")) {
            handleGuessLogic();
        }
        checkGameState();
        boolean playAgain = commandPrompter.askToPlayAgain();

        if (playAgain) {
            reset();
            start();
        } else {
            display.printEndGameMessage();
        }
    }

    public void handleGuessLogic() {

        char currentGuess = commandPrompter.getUsersGuess();
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

            display.printGuessedLetters(getGuessedLetters());
            display.printLivesRemaining(getLivesRemaining());
            display.printAsciiFeedback(getLivesRemaining());
            hiddenWordInPlay = display.printHiddenWord(randomWord, currentGuess, guessedLetters);

        } else {
            display.printDuplicateGuessMessage(currentGuess);
        }
    }

    public boolean checkIfLetterAlreadyGuessed(Character guessedLetter) {
        return guessedLetters.contains(guessedLetter);
    }

    public boolean checkWordContainsGuessedLetter(char guessedLetter) {
        return randomWord.contains(Character.toString(guessedLetter));
    }

    public void checkGameState() {
        if (!hiddenWordInPlay.contains("_")) {
            display.printWinMessage(livesRemaining);
        } else if (livesRemaining == 0) {
            display.printGameOverMessage(randomWord);
        }
    }

    public void reset() {
        livesRemaining = 7;
        randomWord = "";
        hiddenWordInPlay = "";
        guessedLetters.clear();
    }
}


