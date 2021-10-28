import static org.junit.Assert.*;

import org.junit.Test;

public class Tester {
	/**
	 * JUnit Tester 1: Testing sortNames() method in NameSort.java.
	 */
	@Test
	public void testSort() {
		String[] names = {"Candy", "Snack", "Barbeque", "Apple"};
		names = NameSort.sortNames(names);

		// Apple, Barbeque, Candy, Snack
		assertEquals("Apple", names[0]);
		assertEquals("Barbeque", names[1]);
	}
}
