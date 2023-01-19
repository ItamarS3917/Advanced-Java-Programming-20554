package com.example.q113hangman;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.*;
import static java.lang.System.exit;

public class HangMan {

    // String variable to store the word to be guessed
    private String word;
    // Integer variable to store the length of the word
    private int wordLength;
    // Integer variable to store the number of lives remaining
    private int lives;

    // ArrayList to store the different stages of the hangman game
    ArrayList<String> hangManLives = new ArrayList<>(Arrays.asList(
            """
            +---+
            |     |
                  |
                  |
                  |
                  |
          =========""",
            """
            +---+
            |     |
            O    |
                  |
                  |
                  |
          =========""",
            """
            +---+
            |      |
            O     |
                  |
                  |
                  |
          =========""",
            """
            +---+
            |      |
            O     |
           /|      |
                   |
                   |
          =========""",
            """
            +---+
            |     |
            O     |
           /|\\   |
                  |
                  |
          =========""",
            """
            +---+
            |     |
            O     |
           /|\\   |
           /      |
                  | 
          =========""",
            """
            +---+
            |      |
            O     |
           /|\\    |
           / \\    |
                   |
          ========="""
    ));

    // constructor
    public HangMan() {
        // initialize the word variable with the data from the file
        this.word = getFileData();
        // set the length of the word
        this.wordLength = word.length();
        // set the number of lives to 0
        this.lives = 0;
    }

    // getter for the word
    public String getWord() {
        return this.word;
    }

    // getter for the word length
    public int getWordLength() {
        return this.wordLength;
    }

    // check if the game is still ongoing

        public boolean gameIsOn() {
        return this.lives < 6;
    }
    //returns the lives as a string
    public String setScreenLives(int lives) {
        if(this.lives < 7)
            return hangManLives.get(this.lives);
        return null;
    }

    //getter method to get the lives
    public int getLives() {
        return this.lives;
    }
    //increment the lives by 1
    public void setLives() {
        this.lives += 1;
    }
    //check if the input is valid
    public boolean validInput(String s) {
        return s.matches("[a-zA-Z]+") && s.length() == 1;
    }

    //get the data from the file
    public String getFileData() {
        try {
            List <String> dataList = Files.readAllLines(new File("data.txt").toPath(), Charset.defaultCharset());
            Collections.shuffle(dataList);
            return dataList.get(0);
        }
        catch (IOException e) {
            System.out.println("Error");
            exit(0);
        }
        return "";
    }

    //reset the game
    public void reset() {
        this.lives = 0;
        this.setScreenLives(0);
        this.word = getFileData();
        this.wordLength = word.length();
    }

}
