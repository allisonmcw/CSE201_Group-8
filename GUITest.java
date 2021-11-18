import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

/**
 * 
 */

/**
 * @author JP
 *
 */
class GUITest {

	/**
	 * Test method for {@link GUI#sort(java.util.List)}.
	 */
	@Test
	void testSort() {
        List<App> apps = new ArrayList<>();
        App a = new App("Facebook", "Zuckerberg app", "mobile device", "1.01",
        		"0", "social media", "AppleStore", "abc.com");
        App b = new App("Instagram", "Zuckerberg app", "mobile device", "1.01",
        		"0", "social media", "AppleStore", "abc.com");
        App c = new App("Youtube", "Zuckerberg app", "mobile device", "1.01",
        		"0", "social media", "AppleStore", "abc.com");
        apps.add(a);
        apps.add(b);
        apps.add(c);
        
        String[] sort = GUI.sort(apps);
        System.out.println(Arrays.toString(sort));
        assertEquals("Facebook", sort[0]);
        assertEquals("Youtube", sort[sort.length - 1]);
	}

	/**
	 * Test method for {@link GUI#readAppsFromCSV(java.lang.String)}.
	 */
	@Test
	void testReadAppsFromCSV() {
        List<App> apps = GUI.readAppsFromCSV("Application Information - Sheet1 (1).csv");
        String str = apps.get(0).getName();
        
        assertEquals("Youtube", str);
        assertEquals("A free video sharing website that makes it easy to watch online videos.", apps.get(0).getAbout());
	}

	/**
	 * Test method for {@link GUI#createApp(java.lang.String[])}.
	 */
	@Test
	void testCreateApp() {
		String[] str = {"Facebook", "Zuckerberg app", "mobile device", "1.01",
	    		"0", "social media", "AppleStore", "abc.com"};
		App a = GUI.createApp(str);
		assertEquals("Facebook", a.getName());
		assertEquals("AppleStore", a.getStoreName());
		assertEquals("abc.com", a.getStoreLink());
	}

}
