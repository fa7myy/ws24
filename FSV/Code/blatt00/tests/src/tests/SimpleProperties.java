package tests;

import java.util.Random;

import org.junit.jupiter.api.Assertions;

import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.constraints.DoubleRange;
import net.jqwik.api.constraints.IntRange;

public class SimpleProperties {
	@Property
	void inc(@ForAll int x) {
		Assertions.assertTrue(x + 1 > x);
	}
	
	
	// 	Oracle
	int fib(int x) {
		if (x <= 0)
			return 0;
		else if (x == 1)
			return 1;
		else
			return fib(x - 1) + fib(x - 2);
	}

	@Property
	void testFib(@ForAll @IntRange(min = 0, max = 10) int n) {
		int actual = Simple.fib(n);
		int expected = this.fib(n);
		Assertions.assertEquals(expected, actual);
	}
	

	@Property
	void sqrt(@ForAll @DoubleRange(min=0, max=100000) double x) {
		double y = Math.sqrt(x);
		double d = Math.abs(x - y * y);
		Assertions.assertTrue(d <= 0.0001);
	}
	
	int getSmallestInt(int[] n) {
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < n.length; i++){
			if(min > n[i]) {
				min = n[i];
			}
		}
		
		return min;
	}
	
	boolean isInArray(int[] arr, int n) {
		for (int m : arr) {
			if(m == n) return true;
		}
		return false;
	}
	
	@Property
    void testAbsProperties() {
        Random random = new Random();
        for (int i = 0; i < 1000; i++) { // Run the test for 1000 random numbers
            int x = random.nextInt();

            // Property 1: Non-negativity
            Assertions.assertTrue(Simple.abs(x) >= 0, "abs(x) should always be >= 0");

            // Property 2: Symmetry
            Assertions.assertEquals(Simple.abs(x), Simple.abs(-x), "abs(x) should equal abs(-x)");

            // Property 3: Idempotence
            Assertions.assertEquals(Simple.abs(x), Simple.abs(Simple.abs(x)), "abs(abs(x)) should equal abs(x)");
        }
    }
	
	@Property
	void testMax(int[] numbers, int left, int right) {
		Assertions.assertTrue(isInArray(numbers, Simple.max(numbers, left, right)));
		Assertions.assertTrue(getSmallestInt(numbers) <= Simple.max(numbers, left, right));
		
	}
}
