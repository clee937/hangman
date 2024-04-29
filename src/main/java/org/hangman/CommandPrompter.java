package org.hangman;

import java.util.Scanner;

public class CommandPrompter {
    final private Scanner scanner = new Scanner(System.in);

    public char getUsersGuess(Game game) {

        System.out.println("Please guess a letter: ");

        String guessedLetter = scanner.nextLine().toLowerCase();

        boolean IsGuessALetter = game.checkIfGuessIsALetter(guessedLetter.charAt(0));

        if (!IsGuessALetter) {
            System.out.println("Not a valid guess.");
            return this.getUsersGuess(game);
        } else if (guessedLetter.length() > 1) {
            System.out.println("Only one letter allowed. Please guess again: ");
            return this.getUsersGuess(game);
        }

        System.out.println("You guessed: " + guessedLetter);
        return guessedLetter.charAt(0);
    }

    public void askUserToPlayAgain() {
        System.out.println("Would you like to play again?");
        String answer = scanner.nextLine().toLowerCase();
        //
    }
}



