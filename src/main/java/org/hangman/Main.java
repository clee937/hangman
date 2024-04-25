package org.hangman;

public class Main {
    public static void main(String[] args) {

        Game game = new Game(7);
        Display display = new Display("Hangman", 7);
        WordLibrary wordLibrary = new WordLibrary();

        game.startGame(display);
        String randomWord = wordLibrary.getRandomWord().toUpperCase();

        display.showUnguessedLetters(randomWord);

    }
}