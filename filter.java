/**
 * File 4: Filtering method: Platform, Categories, and Price.
 * Author: Jenn Pham
 */

import java.io.*;
import java.util.*;

public class filter {
    public static void main(String[] args) {
        List<App> apps = readAppsFromCSV("Application Information - Sheet1 (1).csv");
        System.out.println(apps.get(9).getName());
        // List<App> apps2 = filterCategory(apps, "Game");
        // List<App> apps2 = filterPrice(apps, "Free");
        List<App> apps2 = filterPlatform(apps, "smartphone");
        for (App a : apps2) {
            System.out.println(a.getName());
        }
    }

    /**
     * This method filter apps category: Game, Education, Social Media, and Streaming.
     * @param m
     * @return a List of Apps with the indicated categories.
     */ 
    public static List<App> filterCategory(List<App> apps, String choice) {
        // choice = choice.toLowerCase();
        List<App> result = new ArrayList<App>();
        for (App r : apps) {
            if(r.getCategory().equalsIgnoreCase(choice)) {
                result.add(r);
            }
        }

        return result;
    }

    /**
     * This method filter by price: Free or Paid
     * @param m
     * @return a List of Apps with the indicated categories.
     */ 
    public static List<App> filterPrice(List<App> apps, String choice) {
        List<App> result = new ArrayList<App>();
        if (choice.equalsIgnoreCase("Free")) {
            for (App r : apps) {
                if(r.getPrice().equals("0")) {
                    result.add(r);
                }
            }
        } else if (choice.equalsIgnoreCase("Paid")) {
            for (App r : apps) {
                if(!(r.getPrice().equals("0"))) {
                    result.add(r);
                }
            }
        }

        return result;
    }

    /**
     * This method filter apps platform: Mobile Device, Streaming Device, Laptop, Game Console.
     * @param m
     * @return a List of Apps with the indicated categories.
     */ 
    public static List<App> filterPlatform(List<App> apps, String choice) {
        List<App> result = new ArrayList<App>();
        for (App r : apps) {
            if(r.getPlatform().contains(choice)) {
                result.add(r);
            }
        }

        return result;
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
            
            while (sc.hasNext()) {
                line = sc.nextLine();

                String[] attributes = line.split(",");

                App app = createApp(attributes);

                apps.add(app);
                

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
