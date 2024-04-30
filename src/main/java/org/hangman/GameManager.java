package org.hangman;

public class GameManager {
    public static void run() {
        Display display = new Display();
        WordLibrary wordLibrary = new WordLibrary();
        CommandPrompter commandPrompter = new CommandPrompter();
        Game game = new Game(display, wordLibrary, commandPrompter);

        game.play();
    }
}
