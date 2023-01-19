package com.example.q113hangman;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Optional;


public class HangManController  {

    private final StringBuilder secretWord = new StringBuilder(); // StringBuilder that will hold the secret word with *
    private final LinkedList<String> gameData = new LinkedList<String>(); // linkedlist to hold the guesses made by the user
    @FXML
    private Text gameHistory; // text field to display the guesses made by the user
    @FXML
    private TextField guess; // text field for the user to enter their guesses
    @FXML
    private Text hangmanLivesArea; // text field to display the hangman image
    @FXML
    private Text startEndGame; // text field to display the start and end of the game
    @FXML
    private Text textForWords; // text field to display the secret word
    private HangMan hangMan; // instance of the HangMan class

    private String word; // variable to hold the word

    @FXML
    public void initialize() {

        hangMan = new HangMan(); // creating a new instance of the HangMan class
        hangmanLivesArea.setText(hangMan.setScreenLives(0)); // setting the hangman image to the first image
        getInput();
    }

    @FXML
    public void getInput() {
        if(word == null) { // if the word is null, set the startEndGame text to ""
            startEndGame.setText("");
            word = hangMan.getWord(); // get the word from the HangMan class
            setupWord(); // call the setupWord method
        }
        else {
            playTurn(); // play the turn
        }
    }

    public void setupWord() {

        secretWord.append("*".repeat(hangMan.getWordLength())); // append * to the secretWord stringbuilder
        textForWords.setText(String.valueOf(secretWord)); // set the text of the textForWords to the secretWord
    }

    public void playTurn() {

        String guess = this.guess.getText();
        startEndGame.setText("");

        // check if the user enter valid input
        if (hangMan.validInput(guess) && !gameData.contains(guess)) {
            ArrayList<Integer> positions = new ArrayList<Integer>();
            char[] wordChars = hangMan.getWord().toCharArray();
            char letterGuess = guess.charAt(0);

            // check if the word contains the guessed letter
            if (hangMan.getWord().contains(guess)) {
                // find all the positions of the guessed letter
                for (int i = 0; i < hangMan.getWordLength(); i++) {
                    if (wordChars[i] == letterGuess) {
                        positions.add(i);
                    }
                }
                // replace the * with the guessed letter in the secret word
                positions.forEach(pos -> secretWord.setCharAt(pos, letterGuess));
                System.out.println(secretWord);
                textForWords.setText(String.valueOf(secretWord));
                // check if the secret word is equal to the actual word
                if (hangMan.getWord().equals(String.valueOf(secretWord))) {
                    startEndGame.setText("You won!!");
                    gameOver();
                }
            }
            // if the word does not contain the guessed letter
            else {
                setGameHistory();
                hangMan.setLives();
                hangmanLivesArea.setText(hangMan.setScreenLives(hangMan.getLives()));
                if (!hangMan.gameIsOn()) {
                    startEndGame.setText("You Lost..The Secret word was: "+hangMan.getWord().toUpperCase());
                    gameOver();
                }
            }

        }
        else if(!hangMan.validInput(guess)) {
            startEndGame.setText("Invalid input!");

        }
        else {
            startEndGame.setText("You've already guessed this letter");
        }

        this.guess.clear();
    }


    public void gameOver() {
        // Create an alert dialog box
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        // Set the title of the dialog box
        alert.setTitle("HangManNN-!_!-");
        // Set the header text of the dialog box
        alert.setHeaderText("Would you like to Play again?");
        // Set the content text of the dialog box
        alert.setContentText("Press OK to start a new game");
        // Show the dialog box and wait for a response
        Optional <ButtonType> typeOptional = alert.showAndWait();
        // Check if the user clicked the OK button
        if(typeOptional.isPresent() && typeOptional.get() == ButtonType.OK) {
            // Reset the game
            hangMan.reset();
            reset();
        }
        // Check if the user clicked the Cancel button
        else if(typeOptional.isPresent() && typeOptional.get() == ButtonType.CANCEL) {
            // Exit the game
            System.exit(0);
        }
    }

    public void setGameHistory() {
        // Add the current guess to the game history
        gameData.add(guess.getText());
        // Set the game history text
        gameHistory.setText(gameData.toString());
    }

    @FXML
    void reset() {
        // Reset the word
        word = null;
        // Clear the secret word
        secretWord.setLength(0);
        // Update the hangman lives area
        hangmanLivesArea.setText(hangMan.setScreenLives(0));
        hangMan.reset();
        gameData.clear();
        gameHistory.setText("");
        getInput();
    }
}
