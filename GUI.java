/*
* CSE201_Group-8 Project
* @author Allison McWilliams, Jenn Pham, Isabel Pulte, Tanmay Bhatkar
* File-1: main file
* Date (start): 10/6/2021
*/

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Public Class GUI. Start GUI.
 */
public class GUI {
    static JFrame a = new JFrame("App Store");
    static JButton logIn = new JButton("Sign In/Sign up");
    static int totalApps = 0;

    public static void main(String args[]) {

        a.getContentPane().setBackground(Color.white);
        JButton inputButton = new JButton("Search");

        JLabel b1;
        b1 = new JLabel("App Store");
        b1.setBounds(125, 20, 90, 20);


        JLabel tc = new JLabel("<html>© 2021 TAJI Inc.<br><br>"
                + "Personnel<br>Jenn Pham: Project Manager & Designer<br>Allison McWilliams: Technical Manager<br>"
                + "Isabel Pulte: Developer & Documentor<br>Tanmay Bhatkar: Developer & Tester </html>");
        tc.setBounds(50, 200, 2000, 500);
        a.add(tc);

        a.add(logIn);
        logIn.setBounds(270, 20, 150, 30);

        a.add(inputButton);
        inputButton.setBounds(270, 100, 100, 30);

        JTextField b2 = new JTextField("Type something...");
        b2.setBackground(Color.white);
        b2.setForeground(Color.black);
        a.add(b2);
        b2.setBounds(50, 100, 200, 30);
        a.add(b1);
        JButton b = new JButton("The Forum");
        b.setBounds(100, 45, 100, 50);
        ;
        a.add(b);
        a.setSize(600, 600);
        a.setLayout(null);
        a.setVisible(true);

        List<App> apps = readAppsFromCSV("Application Information - Sheet1 (1).csv");

        // Sort button
        JButton c = new JButton("Sort");
        c.setBounds(100, 150, 100, 50);        
        a.add(c);
        login.clickClear(b2);
        a.setSize(1920, 1080);
        a.setLayout(null);
        a.setVisible(true);
        
        if(args.length != 0) {
            System.out.println("In sort");
            String[] appsSorted = sort(apps);
          for (String r : appsSorted) {
              System.out.println(r);
              generateApps(r, apps);
          }
        }
        else {
            for(App a : apps) {            
                generateApps(a.getName(), apps);
            }
        }
        
        
        c.addActionListener((ActionListener) new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
              //String args[] = {"Sort",""}; 
              a.setVisible(false);
              SortedGUI.main(args);
            }

        });

        

        inputButton.addActionListener((ActionListener) new ActionListener() {

            /**
             * Override method actionPerformed().
             * This method checks whether the app exists or not.
             * @param ActionEvent
             */
            @Override
            public void actionPerformed(ActionEvent e) {


                String myString = b2.getText();

                b2.setText("");
                boolean appExists = false;
                // System.out.println(myString);
                String[] sortedApps = sort(apps);
                // Code for printing out sorted apps
                for (String r : sortedApps) {
                    if (r.compareTo(myString) == 0) {
                        appExists = true;
                        App ans = null;
                        String filePath = "icons/"+myString+".png";
                        Icon ico = new ImageIcon(filePath);
                        for(App a : apps) {
                            if(a.getName().compareTo(myString) == 0)
                                ans = a;
                        }
                        JOptionPane.showMessageDialog(null,
                                "Name: " + ans.getName() +"\nDescription: " +ans.getAbout() + "\nVersion: "+ans.getVersions(), ans.getName(), JOptionPane.INFORMATION_MESSAGE, ico);
                    }
                }
                if (appExists == false) {
                    JOptionPane.showMessageDialog(null, "App Does Not Exist!");
                }

            }

        });

        logIn.addActionListener((ActionListener) new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                login.main(args);
            }

        });

        // needs when clicked and to go to page with apps / app info etc
        // apps / app info loads from csv file

    } // main end

    /**
     * This method generates Apps'icon and information from the CSV file.
     * 
     * @param appName a String value
     * @param appsList a List of Apps
     */
    private static void generateApps(String appName, List<App> appsList) {    
//        int row = totalApps % 3;
//        int col = totalApps % 3;
        int x = 450;
        int y = 1;
        int width = 300;
        int height = 200;                      
        
        String filePath = "icons/"+appName+".png";
        Icon ico = new ImageIcon(filePath);
        
        JButton app = new JButton(ico);
        app.setText(appName);
        app.setBounds(x + ((totalApps%3)*350), y+ ((totalApps/3)%3*250), width, height);
        a.add(app);         
        
        
        app.addActionListener((ActionListener) new ActionListener() {

            /**
             * Override method actionPerformed().
             * This method generates the app MessageDialog consisting of Name and Description.
             * @param ActionEvent
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                App ans = null;
                for(App a : appsList) {
                    if(a.getName().compareTo(appName) == 0)
                        ans = a;
                }
                JOptionPane.showMessageDialog(null,
                        "Name: " + ans.getName() +"\nDescription: " +ans.getAbout() + "\nVersion: "+ans.getVersions(), appName, JOptionPane.INFORMATION_MESSAGE, ico);
            }

        });
        ++totalApps;
        
    }

    /**
     * Method after logged in to create a user home page.
     * 
     * @param name a String value
     */
    public static void logInAfter(String name) {
        logIn.setVisible(false);
        JLabel n = new JLabel("Hello, " + name);
        n.setBounds(270, 20, 150, 30);
        a.add(n);

        // Create a request field
        JTextField bx = new JTextField("Enter a request...");
        bx.setBackground(Color.white);
        bx.setForeground(Color.black);
        a.add(bx);
        bx.setBounds(50, 300, 200, 30);

        // Create a send button
        JButton send = new JButton("Send");
        send.setBorderPainted(true);
        a.add(send);
        send.setBounds(270, 300, 100, 30);

        send.addActionListener((ActionListener) new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                FileWriter myObj;
                try {
                    myObj = new FileWriter(
                            "AdminRequests.txt",
                            true);
                    PrintWriter pr = new PrintWriter(myObj);
                    pr.write(bx.getText() + "\n");
                    // HashMap<String, String> map = new HashMap<String,
                    // String>();
                    JOptionPane.showMessageDialog(null,
                            "Successful addition to requests");
                    myObj.close();

                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                bx.setText("");
            }

        });

        a.setVisible(false);
        a.setVisible(true);

    }

    /**
     * Method to sort the apps alphabetically by names.
     * 
     * @param apps
     * @return a String array.
     */
    private static String[] sort(List<App> apps) {
        String appsSorted[] = new String[apps.size()];
        int i = 0;

        for (App r : apps) {
            appsSorted[i] = r.getName();
            i++;
        }

        for (int x = 0; x < apps.size(); x++) {
            for (int y = 1; y < (apps.size() - x); y++) {
                if (appsSorted[y - 1].compareTo(appsSorted[y]) > 0) {
                    // swap elements
                    String temp = appsSorted[y - 1];
                    appsSorted[y - 1] = appsSorted[y];
                    appsSorted[y] = temp;
                }
            }
        }

        return appsSorted;
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

/**
 * Class App.
 */
class App {
    private String name;
    private String about;
    private String platform;
    private String versions;
    private String price;
    private String category;
    private String storeName;
    private String storeLink;

    public App(String name, String about, String platform, String versions,
            String price, String category, String storeName, String storeLink) {
        this.name = name;
        this.about = about;
        this.platform = platform;
        this.versions = versions;
        this.price = price;
        this.category = category;
        this.storeName = storeName;
        this.storeLink = storeLink;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    /**
     * @return the platform
     */
    public String getPlatform() {
        return platform;
    }

    /**
     * @param platform the platform to set
     */
    public void setPlatform(String platform) {
        this.platform = platform;
    }

    /**
     * @return the versions
     */
    public String getVersions() {
        return versions;
    }

    /**
     * @param versions the versions to set
     */
    public void setVersions(String versions) {
        this.versions = versions;
    }

    /**
     * @return the storeLink
     */
    public String getStoreLink() {
        return storeLink;
    }

    /**
     * @param storeLink the storeLink to set
     */
    public void setStoreLink(String storeLink) {
        this.storeLink = storeLink;
    }

    /**
     * @return the price
     */
    public String getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(String price) {
        this.price = price;
    }

    /**
     * @return the category
     */
    public String getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * @return the storeName
     */
    public String getStoreName() {
        return storeName;
    }

    /**
     * @param storeName the storeName to set
     */
    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    @Override
    public String toString() {
        return "App [name=" + name + ", about=" + about + ", platform="
                + platform + ", versions=" + versions + ", price=" + price + ", category=" + category
                + ", storeName=" + storeName + ", storeLink="
                + storeLink + "]";
    }
}
