import static org.junit.Assert.assertEquals;

// import java.util.HashMap;
import java.util.List;
// import java.util.Map;

import org.junit.Test;

public class filterTester {
    /**
	 * JUnit Tester: Filtering method()
	 */
   @Test
   public void testCategory() {
		List<App> apps = filter.readAppsFromCSV("Application Information - Sheet1 (1).csv");

    	apps = filter.filterCategory(apps, "Game");
       
    	assertEquals("[]", apps);
    	// assertEquals("Education", apps);
   }
}
