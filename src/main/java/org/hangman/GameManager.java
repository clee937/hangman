package org.hangman;

public class GameManager {
    public static void run() {
        Game game = new Game();
        Display display = new Display();
        WordLibrary wordLibrary = new WordLibrary();
        CommandPrompter commandPrompter = new CommandPrompter();

        game.playGame(display, wordLibrary, commandPrompter);
    }
}
