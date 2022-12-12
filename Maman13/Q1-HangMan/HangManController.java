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

    private final StringBuilder secretWord = new StringBuilder();
    private final LinkedList<String> gameData = new LinkedList<String>();
    @FXML
    private Text gameHistory;
    @FXML
    private TextField guess;
    @FXML
    private Text hangmanLivesArea;
    @FXML
    private Text startEndGame;
    @FXML
    private Text textForWords;
    private HangMan hangMan;

    private String word;

    @FXML
    public void initialize() {

        hangMan = new HangMan();
        hangmanLivesArea.setText(hangMan.setScreenLives(0));
        getInput();
    }

    @FXML
    public void getInput() {
        if(word == null) {
            startEndGame.setText("");
            word = hangMan.getWord();
            setupWord();
        }
        else {
            playTurn();
        }
    }

    public void setupWord() {

        secretWord.append("*".repeat(hangMan.getWordLength()));
        textForWords.setText(String.valueOf(secretWord));
    }



    public void playTurn() {

        String guess = this.guess.getText();
        startEndGame.setText("");

        if (hangMan.validInput(guess) && !gameData.contains(guess)) { //check if the user enter valid input
            ArrayList<Integer> positions = new ArrayList<Integer>();
            char[] wordChars = hangMan.getWord().toCharArray();
            char letterGuess = guess.charAt(0);

            if (hangMan.getWord().contains(guess)) {
                for (int i = 0; i < hangMan.getWordLength(); i++) {
                    if (wordChars[i] == letterGuess) {
                        positions.add(i);
                    }
                }
                positions.forEach(pos -> secretWord.setCharAt(pos, letterGuess));
                System.out.println(secretWord);
                textForWords.setText(String.valueOf(secretWord));
                if (hangMan.getWord().equals(String.valueOf(secretWord))) {
                    startEndGame.setText("You won!!");
                    gameOver();
                }
            }
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

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("HangManNN-!_!-");
        alert.setHeaderText("Would you like to Play again?");
        alert.setContentText("Press OK to start a new game");
        Optional <ButtonType> typeOptional = alert.showAndWait();
        if(typeOptional.isPresent() && typeOptional.get() == ButtonType.OK) {
            hangMan.reset();
            reset();
        }
        else if(typeOptional.isPresent() && typeOptional.get() == ButtonType.CANCEL) {
            System.exit(0);
        }
    }

    public void setGameHistory() {

        gameData.add(guess.getText());
        gameHistory.setText(gameData.toString());
    }

    @FXML
    void reset() {
        word = null;
        secretWord.setLength(0);
        hangmanLivesArea.setText(hangMan.setScreenLives(0));
        hangMan.reset();
        gameData.clear();
        gameHistory.setText("");
        getInput();
    }
}
