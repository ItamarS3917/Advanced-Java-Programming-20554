package com.example.q213trivia;

public class Trivia {

    private String question;

    private int score;

    private boolean gameIsOn;

    private String answer;

    private final QuestionGenerator questionGenerator = new QuestionGenerator();

    public Trivia() {
        setNewGame();
    }

    public void setGameIsOn() {
        gameIsOn = !gameIsOn;
    }

    public boolean isGameIsOn() {
        return gameIsOn;
    }
    public int getScore() {
        return score;
    }


    public void incrementScore() {
        score += 10;
    }

    public void decrementScore() {
        score -= 5;
    }

    public void setNewGame() {
        question = questionGenerator.getRandomQuestion();
        score = 0;
        gameIsOn = true;
        answer = questionGenerator.getCorrectAnswer();
    }

}
