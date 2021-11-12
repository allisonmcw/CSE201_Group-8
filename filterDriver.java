/**
 * File 4: Filtering method: Platform, Categories, and Price.
 * Author: Jenn Pham
 */

import java.io.*;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class filterDriver {
    /**
     * This method creates a JMenuBar called Filter with expandable menus.
     * Filter has 3 types: By Categories, By Price, and By Platform.
     * 
     * @return a JMenuBar.
     */
    public JMenuBar getJMenuBar() {
        List<App> apps = readAppsFromCSV("Application Information - Sheet1 (1).csv");

        JMenuBar jMenuBar = new JMenuBar();
        // Filter bar code
        JMenu menu1 = new JMenu("Filter");
        // 3 Menus
        // Add options in Categories
        JMenu cat = new JMenu("By Categories");
        JMenuItem game = new JMenuItem("Game");
        game.addActionListener((ActionListener) new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                List<App> result = filterCategory(apps, "Game");
                String message = "\n Games \n";
                for (App a : result) {
                    message += "\n\n\n" + "Name: " + a.getName() +"\nDescription: " +a.getAbout() + "\nVersion: "+a.getVersions();
                }
                JOptionPane.showMessageDialog(null, message);
            }
    
        });
        JMenuItem education = new JMenuItem("Education");
        education.addActionListener((ActionListener) new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                List<App> result = filterCategory(apps, "Education");
                String message = "\n Education \n";
                for (App a : result) {
                    message += "\n\n\n" + "Name: " + a.getName() +"\nDescription: " +a.getAbout() + "\nVersion: "+a.getVersions();
                }
                JOptionPane.showMessageDialog(null, message);
            }
    
        });
        JMenuItem socialMedia = new JMenuItem("Social Media");
        socialMedia.addActionListener((ActionListener) new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                List<App> result = filterCategory(apps, "Social Media");
                String message = "\n Social Media \n";
                for (App a : result) {
                    message += "\n\n\n" + "Name: " + a.getName() +"\nDescription: " +a.getAbout() + "\nVersion: "+a.getVersions();
                }
                JOptionPane.showMessageDialog(null, message);
            }
    
        });
        JMenuItem streaming = new JMenuItem("Streaming");
        streaming.addActionListener((ActionListener) new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                List<App> result = filterCategory(apps, "Streaming");
                String message = "\n Streaming \n";
                for (App a : result) {
                    message += "\n\n\n" + "Name: " + a.getName() +"\nDescription: " +a.getAbout() + "\nVersion: "+a.getVersions();
                }
                JOptionPane.showMessageDialog(null, message);
            }
    
        });
        JMenuItem music = new JMenuItem("Music");
        music.addActionListener((ActionListener) new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                List<App> result = filterCategory(apps, "Music");
                String message = "\n Music \n";
                for (App a : result) {
                    message += "\n\n\n" + "Name: " + a.getName() +"\nDescription: " +a.getAbout() + "\nVersion: "+a.getVersions();
                }
                JOptionPane.showMessageDialog(null, message);
            }
    
        });
        cat.add(game);
        cat.add(education);
        cat.add(socialMedia);
        cat.add(streaming);
        cat.add(music);

        // Add options in Price
        JMenu price = new JMenu("By Price");
        JMenuItem free = new JMenuItem("Free");
        free.addActionListener((ActionListener) new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                List<App> result = filterPrice(apps, "Free");
                String message = "\n Free \n";
                for (App a : result) {
                    message += "\n\n\n" + "Name: " + a.getName() +"\nDescription: " +a.getAbout() + "\nVersion: "+a.getVersions();
                }
                JOptionPane.showMessageDialog(null, message);
            }
    
        });
        JMenuItem paid = new JMenuItem("Paid");
        paid.addActionListener((ActionListener) new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                List<App> result = filterPrice(apps, "Paid");
                String message = "\n Paid \n";
                for (App a : result) {
                    message += "\n\n\n" + "Name: " + a.getName() +"\nDescription: " +a.getAbout() + "\nVersion: "+a.getVersions();
                }
                JOptionPane.showMessageDialog(null, message);
            }
    
        });
        price.add(free);
        price.add(paid);

        // Add options in Platform
        JMenu pf = new JMenu("By Platform");
        JMenuItem mobile = new JMenuItem("Mobile Device");
        mobile.addActionListener((ActionListener) new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                List<App> result = filterPlatform(apps, "Mobile Device");
                String message = "\n Mobile Device \n";
                for (App a : result) {
                    message += "\n\n\n" + "Name: " + a.getName() +"\nDescription: " +a.getAbout() + "\nVersion: "+a.getVersions();
                }
                JOptionPane.showMessageDialog(null, message);
            }
    
        });
        JMenuItem laptop = new JMenuItem("Laptop");
        laptop.addActionListener((ActionListener) new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                List<App> result = filterPlatform(apps, "Laptop");
                String message = "\n Laptop \n";
                for (App a : result) {
                    message += "\n\n\n" + "Name: " + a.getName() +"\nDescription: " +a.getAbout() + "\nVersion: "+a.getVersions();
                }
                JOptionPane.showMessageDialog(null, message);
            }
    
        });
        JMenuItem gameConsole = new JMenuItem("Game Console");
        gameConsole.addActionListener((ActionListener) new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                List<App> result = filterPlatform(apps, "Game Console");
                String message = "\n Game Console \n";
                for (App a : result) {
                    message += "\n\n\n" + "Name: " + a.getName() +"\nDescription: " +a.getAbout() + "\nVersion: "+a.getVersions();
                }
                JOptionPane.showMessageDialog(null, message);
            }
    
        });
        JMenuItem stream = new JMenuItem("Streaming Device");
        stream.addActionListener((ActionListener) new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                List<App> result = filterPlatform(apps, "Streaming Device");
                String message = "\n Streaming Device \n";
                for (App a : result) {
                    message += "\n\n\n" + "Name: " + a.getName() +"\nDescription: " +a.getAbout() + "\nVersion: "+a.getVersions();
                }
                JOptionPane.showMessageDialog(null, message);
            }
    
        });
        pf.add(mobile);
        pf.add(laptop);
        pf.add(gameConsole);
        pf.add(stream);
        // Add menus into main menu.
        menu1.add(cat);
        menu1.add(price);
        menu1.add(pf);
        // Add menu into menu bar.
        jMenuBar.add(menu1);

        return jMenuBar;
    }

    public static void main(String[] args) {
        // List<App> apps = readAppsFromCSV("Application Information - Sheet1 (1).csv");
        // // System.out.println(apps.get(9).getName());
        // // List<App> apps2 = filterCategory(apps, "Game");
        // List<App> apps2 = filterPrice(apps, "Paid");
        // // List<App> apps2 = filterPlatform(apps, "smartphone");
        // for (App a : apps2) {
        //     System.out.println(a.getName());
        // }
    }

    /**
     * This method filter apps category: Game, Education, Social Media, Streaming, and Music.
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
                if(!r.getPrice().equals("0")) {
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
            if(r.getPlatform().contains(choice.toLowerCase())) {
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
