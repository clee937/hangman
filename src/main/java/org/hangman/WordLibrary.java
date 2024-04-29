package org.hangman;

public class WordLibrary {

    private String[] words = {"elephant", "wizard", "super"};

    //    private ArrayList<String> words = new ArrayList<>();

    public String[] getWords() {
        return words;
    }

    public void setWords(String[] words) {
        this.words = words;
    }

    public String getRandomWord() {
        return words[(int) Math.floor(Math.random() * words.length)];
    }
}
//private static final Random RANDOM = new Random();