package giancarlogilos.com.guiquiz;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Gilos on 2/13/2017.
 */

public class ModuloLearningTest {

    @Ignore
    @Test
    public void AssumeThatModuloGivesAPositiveNumberWhenLHSIsNegativeWithPositiveRHS(){
        int result = Math.abs(-1 % 6);

        assertEquals(5, result);
    }
}
