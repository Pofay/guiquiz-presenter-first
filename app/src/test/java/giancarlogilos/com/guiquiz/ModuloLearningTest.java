package giancarlogilos.com.guiquiz;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Gilos on 2/13/2017.
 */

public class ModuloLearningTest {

    @Test
    public void AssumeThatModuloGivesAPositiveNumberWhenLHSIsNegativeWithPositiveRHS(){
        int result = -1 % 6;

        assertEquals(5, result);
    }
}
