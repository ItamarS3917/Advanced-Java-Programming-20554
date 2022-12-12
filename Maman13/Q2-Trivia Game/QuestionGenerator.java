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



    public QuestionGenerator() {
        setNewList();
        update();
    }


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

        Random rnd = new Random();
        String[] data = {ans1, ans2, ans3, ans4};
        for (int i = data.length - 1; i > 0; i--)
        {
            int index = rnd.nextInt(i + 1);
            // Simple swap
            String a = data[index];
            data[index] = data[i];
            data[i] = a;
        }
        return data;
    }

    public String getRandomQuestion() {
        if(randomQuestion != null) {
            return randomQuestion;
        }
        return null;
    }

    public String getCorrectAnswer() {
        if (correctAnswer != null) {
            return correctAnswer;
        }
        return null;
    }

    public String [] getShuffeldAnswers() {
        if(shuffeldAnswers != null) {
            return shuffeldAnswers;
        }
        return null;
    }

    public int getNumberOfQuestions() {
        return numberOfQuestions;
    }


    public void setNewList() {
        dataList = getFileData();
        numberOfQuestions = dataList.size()/5;
        questionIndex = getQuestionIndex();
    }

    public void reset() {
        setNewList();
        update();
    }
}
