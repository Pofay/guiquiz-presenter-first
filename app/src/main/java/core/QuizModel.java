package core;

/**
 * Created by Gilos on 2/9/2017.
 */

public class QuizModel {
    private Question[] questions;
    private String questionText;
    private boolean answer;

    public QuizModel(String questionText, boolean answer) {
        this.questionText = questionText;
        this.answer = answer;
    }

    public QuizModel(Question[] questions) {
        this.questions = questions;

    }

    public String getQuestionText() {
        if(questions != null)
            return questions[0].statement;
        return questionText;
    }

    public boolean isCorrectAnswer(boolean givenAnswer) {
        return givenAnswer == answer;
    }
}

