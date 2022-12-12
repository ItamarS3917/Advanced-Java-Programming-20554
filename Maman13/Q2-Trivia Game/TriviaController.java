package com.example.q213trivia;

import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;


public class TriviaController {

    @FXML
    private Text answer1;

    @FXML
    private Text answer2;

    @FXML
    private Text answer3;

    @FXML
    private Text answer4;

    @FXML
    private Text isCorrect;
    @FXML
    private RadioButton rb1;

    @FXML
    private RadioButton rb2;

    @FXML
    private RadioButton rb3;

    @FXML
    private RadioButton rb4;
    @FXML
    private Label result;


    @FXML
    private Text question;

    @FXML
    private Text score;

    private String selectedAnswer;
    QuestionGenerator questionGenerator;

    private final int FIRST_BUTTON = 1;
    private final int SECOND_BUTTON = 2;
    private final int THIRD_BUTTON = 3;
    private final int FOURTH_BUTTON = 4;

    Trivia trivia;

    @FXML
    public void answer1(ActionEvent event) {
        rb1.setSelected(false);
        userAnswer(FIRST_BUTTON);
    }

    @FXML
    void answer2(ActionEvent event) {
        rb2.setSelected(false);
        userAnswer(SECOND_BUTTON);
    }

    @FXML
    private void answer3(ActionEvent event) {
        rb3.setSelected(false);
        userAnswer(THIRD_BUTTON);
    }

    @FXML
    void answer4(ActionEvent event) {
        rb4.setSelected(false);
        userAnswer(FOURTH_BUTTON);
    }


    private void userAnswer(int option) {
        if(option == FIRST_BUTTON) {
            selectedAnswer = answer1.getText();
        }
        else if(option == SECOND_BUTTON) {
            selectedAnswer = answer2.getText();
        }
        else if(option == THIRD_BUTTON) {
            selectedAnswer = answer3.getText();
        }
        else {
            selectedAnswer = answer4.getText();
        }

        if(selectedAnswer.equals(questionGenerator.getCorrectAnswer())) {
            isCorrect.setVisible(true);
            trivia.incrementScore();
            isCorrect.setFill(Color.LIMEGREEN);
            isCorrect.setText("That's Correct!");
        }
        else {
            isCorrect.setVisible(true);
            trivia.decrementScore();
            isCorrect.setFill(Color.RED);
            isCorrect.setText("That's Wrong!");
        }
        questionGenerator.getAnewQuestion();
        setQuestionOnScreen();
        score.setText(trivia.getScore()+"");
    }

    @FXML
    void endGame() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("--T-R-I-V-I-A--");
        alert.setHeaderText("Would you like to Play again?");
        alert.setContentText("Press OK to start a new game");
        Optional<ButtonType> typeOptional = alert.showAndWait();
        if(typeOptional.isPresent() && typeOptional.get() == ButtonType.OK) {
            isCorrect.setFill(Color.LIGHTGOLDENRODYELLOW);
            isCorrect.setText("Starting a new game...");
            trivia.setNewGame();
            questionGenerator.setNewList();
            reset();

        }
        else if(typeOptional.isPresent() && typeOptional.get() == ButtonType.CANCEL) {
            System.exit(0);
        }
        questionGenerator.reset();
        trivia.setNewGame();
        reset();
    }

    public void startingGameMessage() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("--T-R-I-V-I-A--");
        alert.setHeaderText("Welcome to the TRIVIA GAME");
        alert.setContentText("WE HOPE YOU'LL ENJOY PLAYING HERE");
    }


    @FXML
    void initialize() {
        startingGameMessage();
        questionGenerator = new QuestionGenerator();
        trivia = new Trivia();
        rb1.setSelected(false);
        rb2.setSelected(false);
        rb3.setSelected(false);
        rb4.setSelected(false);
        if(questionGenerator.getNumberOfQuestions() > 3) {
            setQuestionOnScreen();
        }
    }

    public void setQuestionOnScreen() {
        if(!trivia.isGameIsOn()) {
            isCorrect.setFill(Color.LIGHTSALMON);
            isCorrect.setText("We ran out of questions! Your score is: "+trivia.getScore());
            endGame();
            reset();
            startingGameMessage();
        }
        String [] answers = questionGenerator.getShuffeldAnswers();
        question.setText(questionGenerator.getRandomQuestion());
        answer1.setText(answers[0]);
        answer2.setText(answers[1]);
        answer3.setText(answers[2]);
        answer4.setText(answers[3]);
        if(questionGenerator.getNumberOfQuestions() < 3)
            trivia.setGameIsOn();
    }

    public void reset() {
        answer1.setText("");
        answer2.setText("");
        answer3.setText("");
        answer4.setText("");
        score.setText("");
        question.setText("");
        setQuestionOnScreen();
    }


}