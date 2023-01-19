package com.example.q213trivia;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class QuestionGenerator {

    private String randomQuestion;
    private String correctAnswer;
    private String wrongAnswer1;
    private String wrongAnswer2;
    private String wrongAnswer3;

    private String [] shuffeldAnswers;
    private int questionIndex;

    private int numberOfQuestions;

    private ArrayList<String> dataList;

    private final int Q_N_ANSWERS_BLOCK_SIZE = 5;

    // constructor
    public QuestionGenerator() {
        setNewList();
        update();
    }

    //Read trivia.txt file and return the data as list
    public ArrayList<String> getFileData() {
        ArrayList<String> list = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File("trivia.txt"));

            while (scanner.hasNextLine()) {
                list.add(scanner.nextLine());
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }

    //Get random question number and return it to constructor
    private int getQuestionIndex() {
        Random r = new Random();
        return  r.nextInt(0 , numberOfQuestions) * 5;
    }

    //generate a new question to the caller
    public void getAnewQuestion() {
        //at the starting point the file has 190 lines
        numberOfQuestions -= 1;
        removeCurrentQuestion();
        questionIndex = getQuestionIndex();
        update();
    }

    //update the current question and answers
    private void update() {
        int tmpIndex = questionIndex;
        this.randomQuestion = dataList.get(tmpIndex++);

        this.correctAnswer = dataList.get(tmpIndex++);

        this.wrongAnswer1 = dataList.get(tmpIndex++);

        this.wrongAnswer2 = dataList.get(tmpIndex++);

        this.wrongAnswer3 = dataList.get(tmpIndex);

        this.shuffeldAnswers = shuffleArray(correctAnswer, wrongAnswer1, wrongAnswer2, wrongAnswer3);
    }

    //remove the question and answers from question bank
    private void removeCurrentQuestion() {
        int i = 0;
        while (i < Q_N_ANSWERS_BLOCK_SIZE) {
            dataList.remove(this.questionIndex);
            i++;
        }

    }


    private String [] shuffleArray(String ans1, String ans2, String ans3, String ans4){
        // create a random object to shuffle the answers
        Random rnd = new Random();
        //create an array to hold the answers
        String[] data = {ans1, ans2, ans3, ans4};
        //using Fisher-Yates shuffle algorithm to shuffle the answers
        for (int i = data.length - 1; i > 0; i--)
        {
            int index = rnd.nextInt(i + 1);
            // Simple swap
            String a = data[index];
            data[index] = data[i];
            data[i] = a;
        }
        //return the shuffled answers
        return data;
    }

    //getter for random question
    public String getRandomQuestion() {
        if(randomQuestion != null) {
            return randomQuestion;
        }
        return null;
    }

    //getter for the correct answer
    public String getCorrectAnswer() {
        if (correctAnswer != null) {
            return correctAnswer;
        }
        return null;
    }

    //getter for the shuffled answers
    public String [] getShuffeldAnswers() {
        if(shuffeldAnswers != null) {
            return shuffeldAnswers;
        }
        return null;
    }

    //getter for the number of questions
    public int getNumberOfQuestions() {
        return numberOfQuestions;
    }

    //reset the game by getting new questions
    public void setNewList() {
        dataList = getFileData();
        numberOfQuestions = dataList.size()/5;
        questionIndex = getQuestionIndex();

        /**
* setNewList method is used to set a new list of questions and answers from trivia.txt file.
* It calls getFileData() to read the file and store the data in dataList.
* It also sets the number of questions available in the file and gets a random question index.
                */
        public void setNewList() {
            dataList = getFileData();
            numberOfQuestions = dataList.size()/5;
            questionIndex = getQuestionIndex();
        }
        /**
         * reset method is used to reset the game.
         * It calls setNewList() to reset dataList, numberOfQuestions and questionIndex.
         * It also calls update() to set new random question, correct answer and shuffled answers.
         */
        public void reset() {
            setNewList();
            update();
        }

    }
