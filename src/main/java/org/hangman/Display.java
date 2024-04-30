package org.hangman;

import java.util.List;

public class Display {

    public void printWelcomeMessage() {
        System.out.printf("%nLet's play Hangman.%nChoose a letter and guess the word before your lives run out.%nYou have 7 lives. Good luck.%n%n");
    }

    public void printLivesRemaining(int lives) {
        if (lives == 1) {
            System.out.printf("You have %d life remaining.%n%n", lives);
        } else {
            System.out.printf("You have %d lives remaining.%n%n", lives);
        }
    }

    public void printAsciiFeedback(int lives) {

        switch (lives) {
            case 7:
                System.out.println("   |   ");
                System.out.println("   |   ");
                System.out.println("   |   ");
                System.out.println("   |   ");
                System.out.println("   |   ");
                System.out.println("=======");
                System.out.println("");
                break;
            case 6:
                System.out.println("   _____");
                System.out.println("   |/  ");
                System.out.println("   |   ");
                System.out.println("   |   ");
                System.out.println("   |   ");
                System.out.println("   |   ");
                System.out.println("   |   ");
                System.out.println("=======");
                System.out.println("");
                break;
            case 5:
                System.out.println("   ___________");
                System.out.println("   |/        |");
                System.out.println("   |         |");
                System.out.println("   |   ");
                System.out.println("   |   ");
                System.out.println("   |   ");
                System.out.println("   |   ");
                System.out.println("=======");
                System.out.println("");
                break;
            case 4:
                System.out.println("   ___________");
                System.out.println("   |/        |");
                System.out.println("   |         |");
                System.out.println("   |         O");
                System.out.println("   |   ");
                System.out.println("   |   ");
                System.out.println("   |   ");
                System.out.println("=======");
                System.out.println("");
                break;
            case 3:
                System.out.println("   ___________");
                System.out.println("   |/        |");
                System.out.println("   |         |");
                System.out.println("   |         O");
                System.out.println("   |         |/");
                System.out.println("   |   ");
                System.out.println("   |   ");
                System.out.println("   |   ");
                System.out.println("=======");
                System.out.println("");
                break;
            case 2:
                System.out.println("   ___________");
                System.out.println("   |/        |");
                System.out.println("   |         |");
                System.out.println("   |         O");
                System.out.println("   |        \\|/");
                System.out.println("   |   ");
                System.out.println("   |   ");
                System.out.println("   |   ");
                System.out.println("=======");
                System.out.println("");
                break;
            case 1:
                System.out.println("   ___________");
                System.out.println("   |/        |");
                System.out.println("   |         |");
                System.out.println("   |         O");
                System.out.println("   |        \\|/");
                System.out.println("   |         |");
                System.out.println("   |        /");
                System.out.println("   |   ");
                System.out.println("=======");
                System.out.println("");
                break;
            case 0:
                System.out.println("   ___________");
                System.out.println("   |/        |");
                System.out.println("   |         |");
                System.out.println("   |         O");
                System.out.println("   |        /|\\");
                System.out.println("   |         |");
                System.out.println("   |        | |");
                System.out.println("   |   ");
                System.out.println("=======");
                System.out.println("");
                break;
        }
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
        System.out.printf("You guessed: %s", Character.toLowerCase(letter));
    }

    public void printDuplicateGuessMessage(char letter) {
        System.out.printf("\"%s\" has already been guessed.%n", letter);
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

    public void printWinMessage(int livesRemaining) {
        if (livesRemaining == 7) {
            System.out.printf("You win, with all %d lives remaining! Well done!", livesRemaining);
        } else {
            System.out.printf("You win, with %d lives remaining! Well done!", livesRemaining);
        }
    }

    public void printGameOverMessage(String word) {
        System.out.println("You've run out of lives. Game over.");
        System.out.println("The word was " + word);
    }

    public void printEndGameMessage() {
        System.out.println("Thanks for playing. Goodbye.");
    }


}
