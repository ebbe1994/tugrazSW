package at.sw2017.calculator;

import org.junit.Test;

import static java.util.regex.Pattern.matches;
import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void testInputField(){
        for(int i = 9; i >=0; i--)
        {
            onView(withText(Integer.toString(i))).perform(click());
        }
        onView(withText("9876543210").check(matches(isDisplay()));
    }

    private void isDisplay() {
    }

    private void withText(String s) {
    }

    
}