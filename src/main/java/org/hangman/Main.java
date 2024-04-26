package org.hangman;

public class Main {
    public static void main(String[] args) {

        Game game = new Game();
        Display display = new Display();
        WordLibrary wordLibrary = new WordLibrary();

        game.startGame(display);
        String randomWord = wordLibrary.getRandomWord().toUpperCase();

        display.showUnguessedLetters(randomWord);

    }
}