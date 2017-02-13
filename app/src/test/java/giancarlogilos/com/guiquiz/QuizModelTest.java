package giancarlogilos.com.guiquiz;

import org.junit.Test;

import core.Question;
import core.QuizModel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * Created by Gilos on 2/10/2017.
 */


public class QuizModelTest {

    @Test
    public void ItShouldGetTheFirstQuestionOnGettingAQuestion() {
        Question expected = new Question("Previous Question", true);
        QuizModel sut = new QuizModel(new Question[]{
                expected,
                new Question("Next Question", false)
        });
        String actual = sut.getCurrentQuestionStatement();
        // Assert
        assertEquals(expected.statement, actual);
        assertTrue(sut.isCorrectAnswer(true));
    }

    @Test
    public void ItShouldProperlyLoadTheNextQuestion() {
        Question expected = new Question("Next Question", false);
        QuizModel sut = new QuizModel(new Question[]{
                new Question("Previous Question", true),
                expected
        });

        sut.loadNextQuestion();
        String actual = sut.getCurrentQuestionStatement();
        // Assert
        assertEquals(expected.statement, actual);
        assertTrue(sut.isCorrectAnswer(false));
    }

    @Test
    public void ItShouldCylceBackToTheFirstQuestionWhenGoingNextQuestionAtLastQuestion() {
        Question expected = new Question("I am First!", true);
        QuizModel sut = new QuizModel(new Question[]{
                expected,
                new Question("I am Second!", true),
                new Question("I am Last!", true)
        });

        sut.loadNextQuestion();
        sut.loadNextQuestion();
        sut.loadNextQuestion();

        String actual = sut.getCurrentQuestionStatement();
        // Assert
        assertEquals(expected.statement, actual);
        assertTrue(sut.isCorrectAnswer(true));
    }

    @Test
    public void ItJustLoadsTheSameQuestionWhenThereIsOnlyOneQuestion() {
        Question expected = new Question("I am First!", true);
        QuizModel sut = new QuizModel(new Question[]{
                expected
        });

        sut.loadNextQuestion();

        String actual = sut.getCurrentQuestionStatement();
        // Assert
        assertEquals(expected.statement, actual);
        assertTrue(sut.isCorrectAnswer(true));
    }


    @Test
    public void ItJustLoadsTheSameQuestionOnLoadingThePreviousQuestionWhenThereIsOnlyOneQuestion() {
        Question expected = new Question("I am First!", true);
        QuizModel sut = new QuizModel(new Question[]{
                expected
        });

        sut.loadPreviousQuestion();


        String actual = sut.getCurrentQuestionStatement();
        // Assert
        assertEquals(expected.statement, actual);
        assertTrue(sut.isCorrectAnswer(true));
    }

    @Test
    public void ItShouldBeAbleToCycleBackToThePreviousQuestion() {

        Question expected = new Question("Q2", false);
        QuizModel sut = new QuizModel(new Question[]{
                new Question("Q1", true),
                expected,
                new Question("Q3", false)
        });


        sut.loadNextQuestion();
        sut.loadNextQuestion();
        sut.loadPreviousQuestion();

        String actual = sut.getCurrentQuestionStatement();

        assertEquals(expected.statement, actual);
        assertTrue(sut.isCorrectAnswer(false));
    }

    @Test
    public void ItShouldGoToTheLastQuestionWhenLoadingPreviousQuestion() {
        Question expected = new Question("Last", false);
        QuizModel sut = new QuizModel(new Question[]{
                new Question("Q1", true),
                new Question("Q3", false),
                expected
        });


        sut.loadPreviousQuestion();

        String actual = sut.getCurrentQuestionStatement();

        assertEquals(expected.statement, actual);
        assertTrue(sut.isCorrectAnswer(false));
    }

}
