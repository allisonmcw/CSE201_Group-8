import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Tester {
    @Test
    public void testAdd(){
        double result = 6;
        assertTrue(result == 6);
        assertFalse(result == 5);
    }

	/**
	 * JUnit Tester 1: Testing sortNames() method.
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
