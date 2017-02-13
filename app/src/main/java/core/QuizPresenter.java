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
        view.setQuestionText(model.getCurrentQuestionStatement());
    }

    public void onAnswer(boolean givenAnswer) {
        if (model.isCorrectAnswer(givenAnswer))
            view.showCorrectMessage();
        else
            view.showIncorrectMessage();
    }

    public void onNext() {
        model.loadNextQuestion();
        view.setQuestionText(model.getCurrentQuestionStatement());
    }

    public void onPrevious() {
        model.loadPreviousQuestion();
        view.setQuestionText(model.getCurrentQuestionStatement());
    }
}
