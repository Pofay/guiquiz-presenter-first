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

        public QuizPresenter(QuizView view, QuizModel model) {
            view.showCorrectMessage();
            view.setQuestionText(model.getQuestionText());
        }

        public void onAnswer(boolean b) {

        }
    }
}
