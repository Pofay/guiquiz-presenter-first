package giancarlogilos.com.guiquiz;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;


/**
 * Created by Gilos on 2/8/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class QuizPresenterTest {

    @Test
    public void ItShouldShowTheQuestionOnInitialize(){
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
    public void InitializeOnAnotherQuestion(){
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
    public void ItShouldNotInvokeAnyOtherOperationInTheViewOnCreation(){
        // Arrange
        QuizView view = mock(QuizView.class);
        QuizModel model = new QuizModel("",true);

        // Act
        new QuizPresenter(view,model);
        // Assert
        verify(view, never()).showCorrectMessage();
    }
    @Test
    public void ItShouldShowCorrectMessageWhenAnswerIsCorrect(){
        // Arrange
        QuizView view = mock(QuizView.class);
        String question = "I am always true";
        QuizModel model = new QuizModel(question,true);
        QuizPresenter presenter = new QuizPresenter(view,model);
        // Act
        presenter.onAnswer(true);

        // Assert
        verify(view).showCorrectMessage();
    }

    @Test
    public void ItShouldShowIncorrectMessageWhenAnswerIsIncorrect(){
        QuizView view = mock(QuizView.class);
        String question = "Are you mad?";
        QuizModel model = new QuizModel(question, false);
        QuizPresenter presenter = new QuizPresenter(view, model);

        presenter.onAnswer(true);

        verify(view).showInCorrectMessage();
    }



    private class QuizModel {
        private final String questionText;

        public QuizModel(String questionText, boolean answer) {
            this.questionText = questionText;
        }

        public String getQuestionText() {
            return questionText;
        }
    }

    private class QuizPresenter {

        private final QuizView view;

        public QuizPresenter(QuizView view, QuizModel model) {
            this.view = view;
            view.setQuestionText(model.getQuestionText());
        }

        public void onAnswer(boolean b) {

            view.showInCorrectMessage();
            view.showCorrectMessage();
        }
    }
}
