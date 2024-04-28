package org.hangman;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private String name = "Hangman";
    private int livesRemaining = 7;
    private boolean gameInPlay = true;
    private String randomWord = "";
    private char currentGuess;
    private boolean correctGuess;
    private char[] incorrectLetters = new char[7];
    ArrayList<Character> guessedLetters = new ArrayList<>();

    private final char[] alphabet = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    public Game() {
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

    public List<Character> getGuessedLetters() {
        return this.guessedLetters;
    }

    public void setGuessedLetters(char guessedLetter) {
        this.guessedLetters.add(guessedLetter);
    }

    public char[] getIncorrectLetters() {
        return incorrectLetters;
    }

    public void setIncorrectLetters(char[] incorrectLetters) {
        this.incorrectLetters = incorrectLetters;
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

    public void playGame(Display display, WordLibrary wordLibrary, CommandPrompter commandPrompter) {
        display.printWelcomeMessage(this.getName());
        display.printLivesRemaining(this.getLivesRemaining());
        this.setRandomWord(wordLibrary.getRandomWord().toLowerCase());
        display.printUnguessedLetters(this.randomWord);

        this.setCurrentGuess(commandPrompter.getUsersGuess(this));
        boolean invalidGuess = checkIfLetterAlreadyGuessed(currentGuess);

        if (!invalidGuess) {
            boolean foundGuessedLetter = checkWordContainsGuessedLetter(getCurrentGuess());
            System.out.println("Found guessed letter: " + foundGuessedLetter);
            if (!foundGuessedLetter) {
                setLivesRemaining(getLivesRemaining() - 1);
                display.printLivesRemaining(getLivesRemaining());
                setGuessedLetters(currentGuess);
            }


//            print unguessed letters
//            display.printGuessedLetters(getGuessedLetters());

        } else {
            display.printDuplicateGuessMessage(getCurrentGuess());
        }
    }

    public String getRandomWord() {
        return this.randomWord;
    }

    public void setRandomWord(String randomWord) {
        this.randomWord = randomWord;
    }

    public boolean getCorrectGuess() {
        return correctGuess;
    }

    public void setCorrectGuess(boolean correctGuess) {
        this.correctGuess = correctGuess;
    }

    public boolean checkIfGuessIsALetter(char guessedLetter) {

        boolean isLetter = false;
        System.out.println("checking guess....");

        for (char letter : this.getAlphabet()) {

            if (letter == guessedLetter) {
                isLetter = true;
                break;
            }
        }
        return isLetter;
    }

    public boolean checkIfLetterAlreadyGuessed(Character guessedLetter) {
        return this.getGuessedLetters().contains(guessedLetter);
    }

    public boolean checkWordContainsGuessedLetter(char guessedLetter) {
        return getRandomWord().contains(Character.toString(guessedLetter));
    }


}

