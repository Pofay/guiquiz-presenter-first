package giancarlogilos.com.guiquiz;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import core.Question;
import core.QuizModel;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

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
    }


}
