package com.example.q213trivia;

public class Trivia {

    // variable to hold the current question
    private String question;

    // variable to hold the player's score
    private int score;

    // variable to indicate if the game is currently in progress
    private boolean gameIsOn;

    // variable to hold the correct answer for the current question
    private String answer;

    // instance of the QuestionGenerator class to generate new questions
    private final QuestionGenerator questionGenerator = new QuestionGenerator();

    // constructor to initialize a new game
    public Trivia() {
        setNewGame();
    }

    // method to set the gameIsOn variable
    public void setGameIsOn() {
        gameIsOn = !gameIsOn;
    }

    // method to check if the game is currently in progress
    public boolean isGameIsOn() {
        return gameIsOn;
    }

    // method to get the current score
    public int getScore() {
        return score;
    }

    // method to increment the score by 10 points
    public void incrementScore() {
        score += 10;
    }

    // method to decrement the score by 5 points
    public void decrementScore() {
        score -= 5;
    }

    // method to start a new game
    public void setNewGame() {
        // set the current question to a new random question
        question = questionGenerator.getRandomQuestion();
        // reset the score to 0
        score = 0;
        // set the gameIsOn variable to true
        gameIsOn = true;
        // set the correct answer for the current question
        answer = questionGenerator.getCorrectAnswer();
    }

}
