package org.hangman;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private String name = "Hangman";
    private int livesRemaining = 7;
    private Display display;
    private boolean gameInPlay = true;
    private String randomWord = "";
    private String hiddenWordInPlay = "";
    private char currentGuess;
    private boolean correctGuess;
    //    private char[] correctGuesses = new char[7];
    ArrayList<Character> guessedLetters = new ArrayList<>();
    ArrayList<Character> incorrectLetters = new ArrayList<>();

    private final char[] alphabet = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    public Game(Display display) {
        this.name = this.getName();
        this.livesRemaining = this.getLivesRemaining();

    }

    public char[] getAlphabet() {
        return this.alphabet;
    }

    public char getCurrentGuess() {
        return this.currentGuess;
    }

    public void setCurrentGuess(char currentGuess) {
        this.currentGuess = Character.toLowerCase(currentGuess);
    }

    public List<Character> getIncorrectLetters() {
        return this.incorrectLetters;
    }

    public void setIncorrectLetters(char guessedLetter) {
        this.incorrectLetters.add(guessedLetter);
    }

    public List<Character> getGuessedLetters() {
        return guessedLetters;
    }

    public void setGuessedLetters(char guessedLetter) {
        this.guessedLetters.add(guessedLetter);
    }

//    public Game(String name, int lives) {
//        this.setName(name);
//        this.setLivesRemaining(lives);
//    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isGameInPlay() {
        return this.gameInPlay;
    }

    public void setGameInPlay(boolean gameInPlay) {
        this.gameInPlay = gameInPlay;
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

    public boolean getCorrectGuess() {
        return correctGuess;
    }

    public void setCorrectGuess(boolean correctGuess) {
        this.correctGuess = correctGuess;
    }

    public void playGame(Display display, WordLibrary wordLibrary, CommandPrompter commandPrompter) {
        display.printWelcomeMessage(this.getName());
//        display.printLivesRemaining(this.getLivesRemaining());
        this.setRandomWord(wordLibrary.getRandomWord().toLowerCase());
        setHiddenWordInPlay(display.printHiddenWord(this.getRandomWord()));


        while (livesRemaining > 0 && hiddenWordInPlay.contains("_")) {
            handleGuessLogic(display, commandPrompter);
        }

        checkGameState(display);
    }

    public void handleGuessLogic(Display display, CommandPrompter commandPrompter) {
        this.setCurrentGuess(commandPrompter.getUsersGuess(this));


        boolean invalidGuess = checkIfLetterAlreadyGuessed(currentGuess);


        if (!invalidGuess) {
            boolean foundGuessedLetter = checkWordContainsGuessedLetter(getCurrentGuess());
//            System.out.println("Found guessed letter: " + foundGuessedLetter);
            if (!foundGuessedLetter) {
                display.printIncorrectGuessFeedback();
                setLivesRemaining(getLivesRemaining() - 1);
                display.printLivesRemaining(getLivesRemaining());
                setIncorrectLetters(currentGuess);
                this.setGuessedLetters(this.currentGuess);
                display.printGuessedLetters(getGuessedLetters());
//                display.printHiddenWord(randomWord, currentGuess, this.getGuessedLetters());
                this.setHiddenWordInPlay(display.printHiddenWord(randomWord, currentGuess, this.getGuessedLetters()));
            } else {
                setGuessedLetters(currentGuess);
                display.printCorrectGuessFeedback();

//
//                display.printHiddenWord(randomWord, currentGuess, this.getGuessedLetters());
                display.printGuessedLetters(getGuessedLetters());
                display.printLivesRemaining(getLivesRemaining());
                this.setHiddenWordInPlay(display.printHiddenWord(randomWord, currentGuess, this.getGuessedLetters()));
            }
            return;

        } else {
            display.printDuplicateGuessMessage(getCurrentGuess());
        }
    }


    public boolean checkIfGuessIsALetter(char guessedLetter) {

        boolean isLetter = false;
//        System.out.println("checking guess....");

        for (char letter : this.getAlphabet()) {

            if (letter == guessedLetter) {
                isLetter = true;
                break;
            }
        }
        return isLetter;
    }

    public boolean checkIfLetterAlreadyGuessed(Character guessedLetter) {
        return this.getIncorrectLetters().contains(guessedLetter) || this.getGuessedLetters().contains(guessedLetter);
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


