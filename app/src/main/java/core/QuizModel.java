package core;

/**
 * Created by Gilos on 2/9/2017.
 */

public class QuizModel {
    private Question[] questions;
    private int currentIndex;


    public QuizModel(Question[] questions) {
        this.questions = questions;

    }

    public String getQuestionText() {
        if (questions != null && currentIndex == 0)
            return questions[0].statement;
        return questions[1].statement;
    }

    public boolean isCorrectAnswer(boolean givenAnswer) {
        if (questions != null && currentIndex == 0)
            return questions[0].answer == givenAnswer;
        return questions[1].answer == givenAnswer;
    }

    public void loadNextQuestion() {
        currentIndex++;
    }
}

