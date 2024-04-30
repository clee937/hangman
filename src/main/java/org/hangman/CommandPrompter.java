package org.hangman;

import java.util.Scanner;

public class CommandPrompter {
    final private Scanner scanner = new Scanner(System.in);

    public char getUsersGuess(Game game) {

        System.out.println("Please guess a letter: ");

        String guessedLetter = scanner.nextLine().trim().toUpperCase();

        while (guessedLetter.isEmpty()) {
            guessedLetter = scanner.nextLine().toUpperCase();
        }

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

    public boolean askToPlayAgain() {
        System.out.println("\n" + "Play again? Y/N");
        String answer = scanner.nextLine().trim().toUpperCase();

        while (answer.isEmpty()) {
            answer = scanner.nextLine().toUpperCase();
        }

        while (!answer.equals("Y") && !answer.equals("N")) {
            answer = scanner.nextLine().toUpperCase();
        }

        return answer.equals("Y");
    }
}