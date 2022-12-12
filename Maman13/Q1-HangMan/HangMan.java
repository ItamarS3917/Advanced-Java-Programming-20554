package com.example.q113hangman;


import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.*;
import static java.lang.System.exit;

public class HangMan {

    private String word;
    private int wordLength;
    private int lives;



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
            |      |
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

    public HangMan() {
        this.word = getFileData();
        this.wordLength = word.length();
        this.lives = 0;
    }

    public String getWord() {
        return this.word;
    }

    public int getWordLength() {
        return this.wordLength;
    }

    public boolean gameIsOn() {
        return this.lives < 6;
    }

    public String setScreenLives(int lives) {
        if(this.lives < 7)
            return hangManLives.get(this.lives);
        return null;
    }

    public int getLives() {
        return this.lives;
    }

    public void setLives() {
        this.lives += 1;
    }

    public boolean validInput(String s) {
        return s.matches("[a-zA-Z]+") && s.length() == 1;
    }

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


    public void reset() {
        this.lives = 0;
        this.setScreenLives(0);
        this.word = getFileData();
        this.wordLength = word.length();
    }

}
