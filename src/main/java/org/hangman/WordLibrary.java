package org.hangman;

import java.util.Random;

public class WordLibrary {

//    private final String[] words = {"elephant", "wizard", "super", "jazz", "nology", "polymorphism", "inheritance", "abstraction", "encapsulation", "react", "hangman", "array", "overload", "override", "object", "class", "method", "instance", "variable", "private", "protected", "parent", "child", "extends", "reusability", "interface"};

    private final String[] words = {"object", "class", "variable", "interface"};


    protected String getRandomWord() {
        if (words.length == 0) {
            return null;
        }
        Random random = new Random();
        return words[random.nextInt(words.length)];
    }
}