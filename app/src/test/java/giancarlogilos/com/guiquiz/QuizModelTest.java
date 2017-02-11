package giancarlogilos.com.guiquiz;

import org.junit.Test;

import core.Question;
import core.QuizModel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
        String actual = sut.getQuestionText();
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
        String actual = sut.getQuestionText();
        // Assert
        assertEquals(expected.statement, actual);
        assertTrue(sut.isCorrectAnswer(false));
    }


}
