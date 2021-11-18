import static org.junit.jupiter.api.Assertions.*;

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
class filterDriverTest {

	/**
	 * Test method for {@link filterDriver#filterCategory(java.util.List, java.lang.String)}.
	 */
	@Test
	void testFilterCategory() {
        List<App> apps = GUI.readAppsFromCSV("Application Information - Sheet1 (1).csv");
        List<App> game = filterDriver.filterCategory(apps, "Game");
        List<App> edu = filterDriver.filterCategory(apps, "Education");
        List<App> sm = filterDriver.filterCategory(apps, "Social Media");
        List<App> str = filterDriver.filterCategory(apps, "Streaming");
        List<App> music = filterDriver.filterCategory(apps, "Music");

        String[] gameArr = new String[game.size()];
        for (int i = 0; i < gameArr.length; i++) {
        	gameArr[i] = game.get(i).getName();
        }
        String[] eduArr = new String[edu.size()];
        for (int i = 0; i < eduArr.length; i++) {
        	eduArr[i] = edu.get(i).getName();
        }
        String[] smArr = new String[sm.size()];
        for (int i = 0; i < smArr.length; i++) {
        	smArr[i] = sm.get(i).getName();
        }
        String[] strArr = new String[str.size()];
        for (int i = 0; i < strArr.length; i++) {
        	strArr[i] = str.get(i).getName();
        }
        String[] muArr = new String[music.size()];
        for (int i = 0; i < muArr.length; i++) {
        	muArr[i] = music.get(i).getName();
        }
        
        assertEquals(Arrays.toString(gameArr), "[Roblox, Subway Surfers, Candy Crush]");
        assertEquals(Arrays.toString(eduArr), "[Canvas]");
        assertEquals(Arrays.toString(smArr), "[Snapchat, Instagram]");
        assertEquals(Arrays.toString(strArr), "[Youtube, Netflix]");
        assertEquals(Arrays.toString(muArr), "[Soundcloud, Spotify]");

	}

	/**
	 * Test method for {@link filterDriver#filterPrice(java.util.List, java.lang.String)}.
	 */
	@Test
	void testFilterPrice() {
		List<App> apps = GUI.readAppsFromCSV("Application Information - Sheet1 (1).csv");
        List<App> free = filterDriver.filterPrice(apps, "Free");
        List<App> paid = filterDriver.filterPrice(apps, "Paid");

        String[] name = new String[free.size()];
        for (int i = 0; i < name.length; i++) {
        	name[i] = free.get(i).getName();
        }
        String[] paidArr = new String[paid.size()];
        for (int i = 0; i < paidArr.length; i++) {
        	paidArr[i] = paid.get(i).getName();
        }
        
        assertEquals(Arrays.toString(name), "[Youtube, Subway Surfers, Candy Crush, Soundcloud, Snapchat, Instagram, Canvas]");
        assertEquals(Arrays.toString(paidArr), "[Netflix, Roblox, Spotify]");

	}

	/**
	 * Test method for {@link filterDriver#filterPlatform(java.util.List, java.lang.String)}.
	 */
	@Test
	void testFilterPlatform() {
		List<App> apps = GUI.readAppsFromCSV("Application Information - Sheet1 (1).csv");
        List<App> mobile = filterDriver.filterPlatform(apps, "Mobile Device");
        List<App> lap = filterDriver.filterPlatform(apps, "Laptop");
        List<App> game = filterDriver.filterPlatform(apps, "Game Console");
        List<App> stream = filterDriver.filterPlatform(apps, "Streaming Device");
        
        String[] name = new String[mobile.size()];
        for (int i = 0; i < name.length; i++) {
        	name[i] = mobile.get(i).getName();
        }
        String[] lapArr = new String[lap.size()];
        for (int i = 0; i < lapArr.length; i++) {
        	lapArr[i] = lap.get(i).getName();
        }
        String[] gameArr = new String[game.size()];
        for (int i = 0; i < gameArr.length; i++) {
        	gameArr[i] = game.get(i).getName();
        }
        String[] strArr = new String[stream.size()];
        for (int i = 0; i < strArr.length; i++) {
        	strArr[i] = stream.get(i).getName();
        }

        assertEquals(Arrays.toString(name), "[Youtube, Netflix, Roblox, Subway Surfers, Candy Crush, Soundcloud, Spotify, Snapchat, Instagram, Canvas]");
        assertEquals(Arrays.toString(lapArr), "[Youtube, Netflix, Candy Crush, Soundcloud, Spotify, Instagram, Canvas]");
        assertEquals(Arrays.toString(gameArr), "[Netflix, Roblox]");
        assertEquals(Arrays.toString(strArr), "[Youtube, Netflix, Roblox]");
	}

}
