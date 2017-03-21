package at.sw2017.calculator;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by Sandner on 15.03.2017.
 */

public class CalculatorUniTest {

    @Test
    public void testDoAddition() {
        int result = Calc.doAdd(2, 3);
        assertEquals(5, result);
    }


    @Test
    public void testDoSubtraction() {
        int result = Calc.doSub(7, 2);
        assertEquals(5, result);
    }

    @Test
    public void testDoMultiplication() {
        int result = Calc.doMult(2, 3);
        assertEquals(6, result);
    }

    @Test
    public void testDoDivision() {
        int result = Calc.doDiv(8, 4);
        assertEquals(2, result);
    }

    @Test
    public void testDoDivision1() {
        int result = Calc.doDiv(8, 0);
        assertEquals(0, result);
    }

    @Test
    public void testDoDivision2() {
        int result = Calc.doDiv(11, 4);
        assertEquals(2, result);
    }
}

