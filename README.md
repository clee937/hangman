# Hangman

## About

This project is an object-oriented application of the classic Hangman game. It is built in Java and uses multiple
classes that interact with each other to run the game in the console.

## Classes

The game has 4 classes, each with their own role:

- **WordLibrary** - responsible for storing words and a method to randomly select a word.
- **Display** - responsible for printing user feedback and displaying the results of the guess.
- **CommandPrompter** - responsible for interacting with the player and capturing their input.
- **Game** - for connecting the classes together and running the game.

## Features

- Randomly selects a word and prints the word to the display in the form of underscores.
- Commands to prompt user for an input.
- Displays letters guessed so far after every turn.
- Displays number of lives remaining after every turn.
- Feedback messages and ascii art hangman displayed after each turn.
- Win/lose feedback when the game ends, showing the number of lives remaining.
- Option to play again.

## Preview

![hangman](/hangman.png "image of hangman game")

## How to run the game

- Clone the repository to your local machine: ```git clone https://github.com/clee937/hangman```
- Open the project in Intellij IDEA (or text editor of choice)
- Then open and run the ```Main.java``` class by clicking on the green triangular play button (Intellij IDEA).

## Technologies used

- Java
- Intellij IDEA
- Git/Github



