import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class SumTest {
    Sum mySum;
    ArrayList<Integer> testNumbers;

    @Before
    public void setup() {
        mySum = new Sum();
        testNumbers = new ArrayList<>();
    }

    @Test
    public void sumWithEmptyList() {
        assertEquals(0, mySum.sum(testNumbers));
    }

    @Test
    public void sumWithOneElement() {
        testNumbers.add(9);
        assertEquals(9, mySum.sum(testNumbers));
    }

    @Test
    public void sumWithMultipleElements() {
        testNumbers.add(9);
        testNumbers.add(2);
        testNumbers.add(-5);
        assertEquals(6, mySum.sum(testNumbers));
    }

    @Test
    public void sumWithNull() {
        testNumbers.add(null);
        assertEquals(null, mySum.sum(testNumbers));
    }
}