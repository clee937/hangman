package org.hangman;

public class Main {
    public static void main(String[] args) {
        Display display = new Display();
        WordLibrary wordLibrary = new WordLibrary();
        CommandPrompter commandPrompter = new CommandPrompter();
        Game game = new Game(display, wordLibrary, commandPrompter);

        game.start();

    }
}