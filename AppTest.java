import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * 
 */

/**
 * @author JP
 *
 */
class AppTest {

	/**
	 * Test method for {@link App#App(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	void testApp() {
		App a = new App("Facebook", "Zuckerberg app", "mobile device", "1.01",
    		"0", "social media", "AppleStore", "abc.com");
		assertEquals("Facebook", a.getName());
		assertEquals("AppleStore", a.getStoreName());
		assertEquals("abc.com", a.getStoreLink());
	}

	/**
	 * Test method for {@link App#getName()}.
	 */
	@Test
	void testGetName() {
		App a = new App("Facebook", "Zuckerberg app", "mobile device", "1.01",
	    		"0", "social media", "AppleStore", "abc.com");
		assertEquals("Facebook", a.getName());
		assertNotEquals("Jam", a.getName());
	}

	/**
	 * Test method for {@link App#setName(java.lang.String)}.
	 */
	@Test
	void testSetName() {
		App a = new App("Facebook", "Zuckerberg app", "mobile device", "1.01",
	    		"0", "social media", "AppleStore", "abc.com");
		assertEquals("Facebook", a.getName());
		assertNotEquals("Jam", a.getName());
		a.setName("Meta");
		assertEquals("Meta", a.getName());
	}

	/**
	 * Test method for {@link App#getAbout()}.
	 */
	@Test
	void testGetAbout() {
		App a = new App("Facebook", "Zuckerberg app", "mobile device", "1.01",
	    		"0", "social media", "AppleStore", "abc.com");
		assertEquals("Zuckerberg app", a.getAbout());
		assertNotEquals("haha", a.getAbout());
	}

	/**
	 * Test method for {@link App#setAbout(java.lang.String)}.
	 */
	@Test
	void testSetAbout() {
		App a = new App("Facebook", "Zuckerberg app", "mobile device", "1.01",
	    		"0", "social media", "AppleStore", "abc.com");
		assertEquals("Zuckerberg app", a.getAbout());
		assertNotEquals("haha", a.getAbout());
		a.setAbout("ABC");
		assertEquals("ABC", a.getAbout());
	}

	/**
	 * Test method for {@link App#getPlatform()}.
	 */
	@Test
	void testGetPlatform() {
		App a = new App("Facebook", "Zuckerberg app", "mobile device", "1.01",
	    		"0", "social media", "AppleStore", "abc.com");
		assertEquals("mobile device", a.getPlatform());
		assertNotEquals("car", a.getPlatform());
	}

	/**
	 * Test method for {@link App#setPlatform(java.lang.String)}.
	 */
	@Test
	void testSetPlatform() {
		App a = new App("Facebook", "Zuckerberg app", "mobile device", "1.01",
	    		"0", "social media", "AppleStore", "abc.com");
		assertEquals("mobile device", a.getPlatform());
		assertNotEquals("car", a.getPlatform());
		a.setPlatform("laptop");
		assertEquals("laptop", a.getPlatform());
	}

	/**
	 * Test method for {@link App#getVersions()}.
	 */
	@Test
	void testGetVersions() {
		App a = new App("Facebook", "Zuckerberg app", "mobile device", "1.01",
	    		"0", "social media", "AppleStore", "abc.com");
		assertEquals("1.01", a.getVersions());
		assertNotEquals("1.23", a.getVersions());
	}

	/**
	 * Test method for {@link App#setVersions(java.lang.String)}.
	 */
	@Test
	void testSetVersions() {
		App a = new App("Facebook", "Zuckerberg app", "mobile device", "1.01",
	    		"0", "social media", "AppleStore", "abc.com");
		assertEquals("1.01", a.getVersions());
		assertNotEquals("1.23", a.getVersions());
		a.setVersions("1.05");
		assertEquals("1.05", a.getVersions());
	}

	/**
	 * Test method for {@link App#getStoreLink()}.
	 */
	@Test
	void testGetStoreLink() {
		App a = new App("Facebook", "Zuckerberg app", "mobile device", "1.01",
	    		"0", "social media", "AppleStore", "abc.com");
		assertEquals("abc.com", a.getStoreLink());
		assertNotEquals("123.com", a.getStoreLink());
	}

	/**
	 * Test method for {@link App#setStoreLink(java.lang.String)}.
	 */
	@Test
	void testSetStoreLink() {
		App a = new App("Facebook", "Zuckerberg app", "mobile device", "1.01",
	    		"0", "social media", "AppleStore", "abc.com");
		assertEquals("abc.com", a.getStoreLink());
		assertNotEquals("123.com", a.getStoreLink());
		a.setStoreLink("facebook.com");
		assertEquals("facebook.com", a.getStoreLink());
	}

	/**
	 * Test method for {@link App#getPrice()}.
	 */
	@Test
	void testGetPrice() {
		App a = new App("Facebook", "Zuckerberg app", "mobile device", "1.01",
	    		"0", "social media", "AppleStore", "abc.com");
		assertEquals("0", a.getPrice());
		assertNotEquals("1", a.getPrice());
	}

	/**
	 * Test method for {@link App#setPrice(java.lang.String)}.
	 */
	@Test
	void testSetPrice() {
		App a = new App("Facebook", "Zuckerberg app", "mobile device", "1.01",
	    		"0", "social media", "AppleStore", "abc.com");
		assertEquals("0", a.getPrice());
		assertNotEquals("1", a.getPrice());
		a.setPrice("2");
		assertEquals("2", a.getPrice());
	}

	/**
	 * Test method for {@link App#getCategory()}.
	 */
	@Test
	void testGetCategory() {
		App a = new App("Facebook", "Zuckerberg app", "mobile device", "1.01",
	    		"0", "social media", "AppleStore", "abc.com");
		assertEquals("social media", a.getCategory());
		assertNotEquals("game", a.getCategory());
	}

	/**
	 * Test method for {@link App#setCategory(java.lang.String)}.
	 */
	@Test
	void testSetCategory() {
		App a = new App("Facebook", "Zuckerberg app", "mobile device", "1.01",
	    		"0", "social media", "AppleStore", "abc.com");
		assertEquals("social media", a.getCategory());
		assertNotEquals("game", a.getCategory());
		a.setCategory("streaming");
		assertEquals("streaming", a.getCategory());
	}

	/**
	 * Test method for {@link App#getStoreName()}.
	 */
	@Test
	void testGetStoreName() {
		App a = new App("Facebook", "Zuckerberg app", "mobile device", "1.01",
	    		"0", "social media", "AppleStore", "abc.com");
		assertEquals("AppleStore", a.getStoreName());
		assertNotEquals("GooglePlay", a.getStoreName());
	}

	/**
	 * Test method for {@link App#setStoreName(java.lang.String)}.
	 */
	@Test
	void testSetStoreName() {
		App a = new App("Facebook", "Zuckerberg app", "mobile device", "1.01",
	    		"0", "social media", "AppleStore", "abc.com");
		assertEquals("AppleStore", a.getStoreName());
		assertNotEquals("GooglePlay", a.getStoreName());
		a.setStoreName("GooglePlay");
		assertEquals("GooglePlay", a.getStoreName());
	}

	/**
	 * Test method for {@link App#toString()}.
	 */
	@Test
	void testToString() {
		App a = new App("Facebook", "Zuckerberg app", "mobile device", "1.01",
	    		"0", "social media", "AppleStore", "abc.com");
		assertEquals("App [name=Facebook, about=Zuckerberg app, platform=mobile device, versions=1.01, "
				+ "storeLink=abc.com, price=0, category=social media, storeName=AppleStore]", a.toString());
	}

}
