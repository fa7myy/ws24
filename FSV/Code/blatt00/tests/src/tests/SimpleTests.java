package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SimpleTests {
	static int a[] = { 1, 4, 2, 3, 5, 7, 4, 9, -1 };
	
	@Test
	void testMax() {
		Assertions.assertEquals(1, Simple.max(a, 0, 1));
		Assertions.assertEquals(3, Simple.max(a, 2, 4));
		Assertions.assertEquals(9, Simple.max(a, 0, a.length));
	}
	
	@Test
	void testAbs() {
	    // Edge cases
	    Assertions.assertEquals(0, Simple.abs(0));
	    Assertions.assertEquals(Integer.MAX_VALUE, Simple.abs(Integer.MAX_VALUE));
	    Assertions.assertEquals(Integer.MAX_VALUE, Simple.abs(-Integer.MAX_VALUE));
	    Assertions.assertEquals(Integer.MIN_VALUE, Simple.abs(Integer.MIN_VALUE)); // Watch for overflow

	    // General cases
	    Assertions.assertEquals(1, Simple.abs(1));
	    Assertions.assertEquals(1, Simple.abs(-1));
	    Assertions.assertEquals(999, Simple.abs(-999));
	    Assertions.assertEquals(999999, Simple.abs(999999));
	    Assertions.assertEquals(999999, Simple.abs(-999999));

	    // Random examples
	    Assertions.assertEquals(42, Simple.abs(42));
	    Assertions.assertEquals(42, Simple.abs(-42));
	    Assertions.assertEquals(123456, Simple.abs(-123456));
	    Assertions.assertEquals(123456, Simple.abs(123456));

	    // Optional: Performance testing
	    for (int i = -1000000; i <= 1000000; i++) {
	        Assertions.assertEquals(Math.abs(i), Simple.abs(i));
	    }
	}
	
	@Test
    void testFib() {
        // Base cases
        Assertions.assertEquals(0, Simple.fib(0), "fib(0) should return 0");
        Assertions.assertEquals(1, Simple.fib(1), "fib(1) should return 1");

        // Small Fibonacci numbers
        Assertions.assertEquals(1, Simple.fib(2), "fib(2) should return 1");
        Assertions.assertEquals(2, Simple.fib(3), "fib(3) should return 2");
        Assertions.assertEquals(3, Simple.fib(4), "fib(4) should return 3");
        Assertions.assertEquals(5, Simple.fib(5), "fib(5) should return 5");

        // Larger Fibonacci numbers
        Assertions.assertEquals(21, Simple.fib(8), "fib(8) should return 21");
        Assertions.assertEquals(34, Simple.fib(9), "fib(9) should return 34");
        Assertions.assertEquals(55, Simple.fib(10), "fib(10) should return 55");

        // Edge cases (optional): Ensure method works for large `n`
        Assertions.assertEquals(6765, Simple.fib(20), "fib(20) should return 6765");
    }

}
