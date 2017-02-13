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

    public String getCurrentQuestionStatement() {
        return questions[currentIndex].statement;
    }

    public boolean isCorrectAnswer(boolean givenAnswer) {
        return questions[currentIndex].answer == givenAnswer;
    }

    public void loadNextQuestion() {
        currentIndex = (currentIndex + 1) % questions.length;
    }

    public void loadPreviousQuestion() {
        currentIndex = currentIndex > 0 ? currentIndex - 1 : questions.length - 1;
    }
}

