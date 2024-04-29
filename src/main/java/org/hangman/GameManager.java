package org.hangman;

public class GameManager {
    public static void run() {
        Display display = new Display();
        Game game = new Game(display);
        WordLibrary wordLibrary = new WordLibrary();
        CommandPrompter commandPrompter = new CommandPrompter();

        game.playGame(display, wordLibrary, commandPrompter);
    }
}
