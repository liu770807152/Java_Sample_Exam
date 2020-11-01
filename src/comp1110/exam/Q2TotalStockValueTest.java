package comp1110.exam;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import static org.junit.Assert.assertTrue;

/**
 * COMP1110 Final Exam, Question 2ii
 */
public class Q2TotalStockValueTest {
    @Rule
    public Timeout globalTimeout = Timeout.millis(500);

    // FIXME add one or more JUnit unit tests that test the totalStockValue() method of the Q2SimpleStockManager class.
    @Test
    public void testResult() {
        Q2SimpleStockManager t = new Q2SimpleStockManager();
        assertTrue ("total value expected to be 0 but got " + t.totalStockValue (), t.totalStockValue () == 0);

        t.newItem ("a", "A", 1);
        t.newItem ("b", "B", 2);
        t.newItem ("c", "C", 3);

        t.addStock ("a", 6);
        t.addStock ("b", 3);
        t.addStock ("c", 2);

        assertTrue ("total value expected to be 18 but got " + t.totalStockValue (), t.totalStockValue () == 18);
    }
}
