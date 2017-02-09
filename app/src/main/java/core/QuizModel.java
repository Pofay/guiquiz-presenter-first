package core;

/**
 * Created by Gilos on 2/9/2017.
 */

public class QuizModel {
    private final String questionText;
    private boolean answer;

    public QuizModel(String questionText, boolean answer) {
        this.questionText = questionText;
        this.answer = answer;
    }

    public String getQuestionText() {
        return questionText;
    }

    public boolean isCorrectAnswer(boolean givenAnswer) {
        return givenAnswer == answer;
    }
}

