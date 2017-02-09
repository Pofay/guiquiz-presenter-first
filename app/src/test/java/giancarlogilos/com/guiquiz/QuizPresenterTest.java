package giancarlogilos.com.guiquiz;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;


/**
 * Created by Gilos on 2/8/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class QuizPresenterTest {

    @Test
    public void ItShouldShowTheQuestionOnInitialize() {
        // Arrange
        QuizView view = mock(QuizView.class);
        String actual = "New Question";
        QuizModel model = new QuizModel(actual, true);

        // Act
        new QuizPresenter(view, model);

        // Assert
        verify(view).setQuestionText(actual);
    }

    @Test
    public void InitializeOnAnotherQuestion() {
        // Arrange
        QuizView view = mock(QuizView.class);
        String actual = "I am a Question";
        QuizModel model = new QuizModel(actual, true);

        // Act
        new QuizPresenter(view, model);

        // Assert
        verify(view).setQuestionText(actual);
    }


    @Test
    public void ItShouldNotInvokeAnyOtherOperationInTheViewOnCreation() {
        // Arrange
        QuizView view = mock(QuizView.class);
        QuizModel model = new QuizModel("", true);

        // Act
        new QuizPresenter(view, model);
        // Assert
        verify(view, never()).showCorrectMessage();
    }

    @Test
    public void ItShouldShowCorrectMessageWhenAnswerIsCorrect() {
        // Arrange
        QuizView view = mock(QuizView.class);
        String question = "I am always true";
        QuizModel model = new QuizModel(question, true);
        QuizPresenter presenter = new QuizPresenter(view, model);
        // Act
        presenter.onAnswer(true);

        // Assert
        verify(view).showCorrectMessage();
    }

    @Test
    public void ItShouldShowIncorrectMessageWhenAnswerIsIncorrect() {
        QuizView view = mock(QuizView.class);
        String question = "Are you mad?";
        QuizModel model = new QuizModel(question, false);
        QuizPresenter presenter = new QuizPresenter(view, model);

        presenter.onAnswer(true);

        verify(view).showIncorrectMessage();
    }

    @Test
    public void ItShouldNotShowAnIncorrectMessageWhenAnswerIsCorrect() {
        QuizView view = mock(QuizView.class);
        QuizModel model = new QuizModel("Some Question", true);
        QuizPresenter presenter = new QuizPresenter(view, model);
        presenter.onAnswer(true);
        verify(view, never()).showIncorrectMessage();
    }

    private class QuizModel {
        private final String questionText;
        private boolean answer;

        public QuizModel(String questionText, boolean answer) {
            this.questionText = questionText;
            this.answer = answer;
        }

        public String getQuestionText() {
            return questionText;
        }

        public boolean isCorrectAnswer(boolean b) {
            return b == answer;
        }
    }

    private class QuizPresenter {

        private final QuizView view;
        private final QuizModel model;

        public QuizPresenter(QuizView view, QuizModel model) {
            this.view = view;
            this.model = model;
            view.setQuestionText(model.getQuestionText());
        }

        public void onAnswer(boolean b) {
            if (model.isCorrectAnswer(b))
                view.showCorrectMessage();
            else
                view.showIncorrectMessage();
        }
    }
}
