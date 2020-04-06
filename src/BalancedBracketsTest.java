import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class BalancedBracketsTest {

    private BalancedBrackets balancedBrackets;

    @Before
    public void setup() {
        balancedBrackets = new BalancedBrackets();
    }

    @Test
    public void givenNullInput_whenCheckingForBalance_shouldReturnFalse() {
        boolean result = balancedBrackets.isBalanced(null);
        assertFalse(result);
    }

    @Test
    public void givenEmptyString_whenCheckingForBalance_shouldReturnTrue() {
        boolean result = balancedBrackets.isBalanced("");
        assertTrue(result);
    }

    @Test
    public void givenInvalidCharacterString_whenCheckingForBalance_shouldReturnFalse() {
        boolean result = balancedBrackets.isBalanced("abc[](){}");
        assertFalse(result);
    }

    @Test
    public void givenOddLengthString_whenCheckingForBalance_shouldReturnFalse() {
        boolean result = balancedBrackets.isBalanced("[]{()");
        assertFalse(result);
    }

    @Test
    public void givenEvenLengthString_whenCheckingForBalance_shouldReturnFalse() {
        boolean result = balancedBrackets.isBalanced(" [{)]");
        assertFalse(result);
    }

    @Test
    public void givenEvenLengthUnbalancedString_whenCheckingForBalance_shouldReturnFalse() {
        boolean result = balancedBrackets.isBalanced("{[(])}");
        assertFalse(result);
    }

    @Test
    public void givenEvenLengthBalancedString_whenCheckingForBalance_shouldReturnTrue() {
        boolean result = balancedBrackets.isBalanced("{[()]}");
        assertTrue(result);
    }

    @Test
    public void givenBalancedString_whenCheckingForBalance_shouldReturnTrue() {
        boolean result = balancedBrackets.isBalanced("(){}[]");
        assertTrue(result);
    }

    @Test
    public void givenAnotherBalancedString_whenCheckingForBalance_shouldReturnTrue() {
        boolean result = balancedBrackets.isBalanced("[{()}](){}");
        assertTrue(result);
    }
}