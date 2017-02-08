package giancarlogilos.com.guiquiz;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


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



    private class QuizModel {
        public QuizModel(String questionText, boolean answer) {
        }
    }

    private class QuizPresenter {

        public QuizPresenter(QuizView view, QuizModel model) {
            view.setQuestionText("New Question");
        }

    }
}
