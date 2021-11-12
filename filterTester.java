import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
// import java.util.HashMap;
import java.util.List;
// import java.util.Map;
import java.util.Scanner;

import org.junit.Test;

public class filterTester {
    /**
	 * JUnit Tester: Filtering method()
	 */
   @Test
   public void testCategory() {
		List<App> apps = filterDriver.readAppsFromCSV("Application Information - Sheet1 (1).csv");
    	List<App> apps2 = filterDriver.filterCategory(apps, "Game");
       
    	assertEquals("[]", apps2);
    	// assertEquals("Education", apps);
   }


   /**
     * Method to read the apps from the excel file.
     * 
     * @param fileName
     * @return a List of Apps.
     */
    public static List<App> readAppsFromCSV(String fileName) {
        List<App> apps = new ArrayList<>();
        Scanner sc;

        try {
            sc = new Scanner(new File(fileName));

            String line = sc.nextLine();
            line = sc.nextLine();
            while (sc.hasNext()) {

                String[] attributes = line.split(",");

                App app = createApp(attributes);

                apps.add(app);

                line = sc.nextLine();

            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        return apps;
    }
    
    /**
     * Method to create an app.
     * 
     * @param meta
     * @return an App object.
     */
    private static App createApp(String[] meta) {
        String name = meta[0];
        String about = meta[1];
        String platform = meta[2];
        String versions = meta[3];
        String price = meta[4];
        String category = meta[5];
        String storeName = meta[6];
        String storeLink = meta[7];

        return new App(name, about, platform, versions, price,
                category, storeName, storeLink);
    }
}
