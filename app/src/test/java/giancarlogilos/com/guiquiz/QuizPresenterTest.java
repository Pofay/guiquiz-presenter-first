package giancarlogilos.com.guiquiz;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import core.Question;
import core.QuizPresenter;
import core.QuizView;

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
        String actual = "New Question";
        QuizView view = mock(QuizView.class);

        // Act
        new QuizPresenterBuilder()
                .withOneQuestion(actual, false)
                .withView(view)
                .build();

        // Assert
        verify(view).setQuestionText(actual);
    }

    @Test
    public void InitializeOnAnotherQuestion() {
        // Arrange
        QuizView view = mock(QuizView.class);
        String actual = "I am a Question";

        // Act
        new QuizPresenterBuilder()
                .withOneQuestion(actual, true)
                .withView(view)
                .build();


        // Assert
        verify(view).setQuestionText(actual);
    }


    @Test
    public void ItShouldNotInvokeAnyOtherOperationInTheViewOnCreation() {
        // Arrange
        QuizView view = mock(QuizView.class);

        // Act
        new QuizPresenterBuilder()
                .withView(view)
                .build();

        // Assert
        verify(view, never()).showCorrectMessage();
    }

    @Test
    public void ItShouldShowCorrectMessageWhenAnswerIsCorrect() {
        // Arrange
        QuizView view = mock(QuizView.class);
        QuizPresenter presenter = new QuizPresenterBuilder()
                .withView(view)
                .withOneQuestion("I am always true", true)
                .build();
        // Act
        presenter.onAnswer(true);

        // Assert
        verify(view).showCorrectMessage();
    }

    @Test
    public void ItShouldShowIncorrectMessageWhenAnswerIsIncorrect() {
        // Arrange
        QuizView view = mock(QuizView.class);
        QuizPresenter presenter = new QuizPresenterBuilder()
                .withView(view)
                .withOneQuestion("Are you mad?", false)
                .build();
        // Act
        presenter.onAnswer(true);
        // Assert

        verify(view).showIncorrectMessage();
    }

    @Test
    public void ItShouldNotShowAnIncorrectMessageWhenAnswerIsCorrect() {
        QuizView view = mock(QuizView.class);
        QuizPresenter presenter = new QuizPresenterBuilder()
                .withView(view)
                .withOneQuestion("Some Question", true)
                .build();

        presenter.onAnswer(true);

        verify(view, never()).showIncorrectMessage();
    }

    @Test
    public void ItShouldShowTheNextQuestionOnNext() {
        QuizView view = mock(QuizView.class);
        Question expected = new Question("Next Question", false);
        Question[] questions = new Question[]{
                new Question("First Question", true),
                expected
        };
        QuizPresenter presenter  = new QuizPresenterBuilder()
                .withView(view)
                .withMultipleQuestions(questions)
                .build();

        presenter.onNext();

        verify(view).setQuestionText(expected.statement);
    }


}
