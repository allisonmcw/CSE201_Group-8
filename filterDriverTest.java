import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

/**
 * 
 */

/**
 * @author Jenn Pham
 *
 */
class filterDriverTest {

	/**
	 * Test method for {@link filterDriver#filterCategory(java.util.List, java.lang.String)}.
	 */
	@Test
	void testFilterCategory() {
        List<App> apps = GUI.readAppsFromCSV("/Users/penguinesee/Documents/201_Project/201Project/src/Textfiles/Apps.txt");
        List<App> game = filterDriver.filterCategory(apps, "Game");
        String[] name = new String[game.size()];
        for (int i = 0; i < name.length; i++) {
        	name[i] = game.get(i).getName();
        }
        
        assertEquals(Arrays.toString(name), "[Roblox, Subway Surfers, Candy Crush]");
	}

	/**
	 * Test method for {@link filterDriver#filterPrice(java.util.List, java.lang.String)}.
	 */
	@Test
	void testFilterPrice() {
		List<App> apps = GUI.readAppsFromCSV("/Users/penguinesee/Documents/201_Project/201Project/src/Textfiles/Apps.txt");
        List<App> free = filterDriver.filterPrice(apps, "Free");
        String[] name = new String[free.size()];
        for (int i = 0; i < name.length; i++) {
        	name[i] = free.get(i).getName();
        }
        
        assertEquals(Arrays.toString(name), "[Youtube, Subway Surfers, Candy Crush, Soundcloud, Snapchat, Instagram, Canvas]");
	}

	/**
	 * Test method for {@link filterDriver#filterPlatform(java.util.List, java.lang.String)}.
	 */
	@Test
	void testFilterPlatform() {
		List<App> apps = GUI.readAppsFromCSV("/Users/penguinesee/Documents/201_Project/201Project/src/Textfiles/Apps.txt");
        List<App> mobile = filterDriver.filterPlatform(apps, "Mobile Device");
        String[] name = new String[mobile.size()];
        for (int i = 0; i < name.length; i++) {
        	name[i] = mobile.get(i).getName();
        }
        System.out.println(Arrays.toString(name));
        assertEquals(Arrays.toString(name), "[Youtube, Netflix, Roblox, Subway Surfers, Candy Crush, Soundcloud, Spotify, Snapchat, Instagram, Canvas]");
	}

}
