package core;

/**
 * Created by Gilos on 2/9/2017.
 */

public class QuizModel {
    private Question[] questions;
    private String questionText;
    private boolean answer;
    private int currentIndex;

    public QuizModel(String questionText, boolean answer) {
        this.questionText = questionText;
        this.answer = answer;
    }

    public QuizModel(Question[] questions) {
        this.questions = questions;

    }

    public String getQuestionText() {
        if(questions != null && currentIndex == 0)
            return questions[0].statement;
        else if(currentIndex == 1)
            return questions[1].statement;
        return questionText;
    }

    public boolean isCorrectAnswer(boolean givenAnswer) {
        if(questions != null && currentIndex == 0)
            return questions[0].answer == givenAnswer;
        else if(questions != null && currentIndex == 1)
            return questions[1].answer == givenAnswer;
        return givenAnswer == answer;
    }

    public void loadNextQuestion() {
        currentIndex++;
    }
}

