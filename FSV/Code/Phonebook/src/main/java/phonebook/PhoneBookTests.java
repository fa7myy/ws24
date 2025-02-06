package phonebook;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PhoneBookTests {
	
	private IPhoneBook book;
	
	@BeforeEach
	void setup() {
		// Initialization
		book = new PhoneBook();
	}
	
	@Test
	void addEntry_addTwoNumbersToSameKey_bothAreStored() {
		// Run method to be tested
		book.addEntry("Hilbert", 1234);
		book.addEntry("Hilbert", 7777);

		// Check result
		int[] numbers = book.lookupName("Hilbert");
		assertElements(numbers, 1234, 7777);
	}

	void assertElements(int[] array, int... elements) {
		Assertions.assertArrayEquals(array, elements);
	}
}
