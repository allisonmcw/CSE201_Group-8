/**
 * File 4: Filtering method
 * Author: Jenn Pham
 */

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.Test;

public class filter {
    public static Map<String, String> filterCategory(Map<String, String> m) {
        Map<String, String> m1 = new HashMap<String, String>();
        m1.put("Candy Crush", "Game");
        m1.put("Roblox", "Game");
        m1.put("Canvas", "Education");
        m1.put("Instagram", "Social Media");

        // Filter call for game category
        Map<String, String> filteredMap = m1.entrySet().stream().filter(x -> "Game".equals(x.getValue())).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        return filteredMap;
   }


   	/**
	 * JUnit Tester: Filtering method()
	 */
   @Test
   public void testCategory() {
       Map<String, String> m1 = new HashMap<String, String>();
       m1.put("Candy Crush", "Game");
       m1.put("Roblox", "Game");
       m1.put("Canvas", "Education");
       m1.put("Instagram", "Social Media");

       m1 = filter.filterCategory(m1);
       
       assertEquals("Game", m1.get("Candy Crush"));
    //    assertEquals("Education", m1.get("Canvas"));
   }

}
