package core;

/**
 * Created by Gilos on 2/9/2017.
 */

public class QuizPresenter {

    private final QuizView view;
    private final QuizModel model;

    public QuizPresenter(QuizView view, QuizModel model) {
        this.view = view;
        this.model = model;
        view.setQuestionText(model.getQuestionText());
    }

    public void onAnswer(boolean givenAnswer) {
        if (model.isCorrectAnswer(givenAnswer))
            view.showCorrectMessage();
        else
            view.showIncorrectMessage();
    }
}
