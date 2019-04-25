import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FibonacciTest {
    Fibonacci myFibo;

    @Before
    public void setup () {
        myFibo = new Fibonacci();
    }

    @Test
    public void fiboWithReasonableNumber() {
        assertEquals(21, myFibo.fibo(0, 1, 9, 2));
    }

    @Test
    public void fiboWithFirstElement() {
        assertEquals(0, myFibo.fibo(0, 1, 1, 0)); //works but kind of stupid to use these parameters
    }
}