import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * 
 */

/**
 * @author tanma
 * Sorted GUI. This application is already sorted when opened. Make it unsorted first.
 */
public class SortedGUI {
    static JFrame a = new JFrame("App Store");
    static JButton logIn = new JButton("Sign In/Sign up");
    static int totalApps = 0;

    /**
     * @param args
     */
    public static void main(String[] args) {

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

        // Please don't change the file path into a local file path. Keep it like this.
        List<App> apps = readAppsFromCSV(
                "Application Information - Sheet1 (1).csv");
        // Code for printing out app names.
        // for (App r : apps) {
        // System.out.println(r);
        // }

//        // Testing the sort names method
//        String[] appsSorted = sort(apps);
//        for (String r : appsSorted) {
//            System.out.println(r);
//        }

        JButton c = new JButton("Sort");
        c.setBounds(100, 150, 100, 50);
        a.add(c);
        login.clickClear(b2);
        a.setSize(1920, 1080);
        a.setLayout(null);
        a.setVisible(true);

        String[] appsSorted = sort(apps);
      for (String r : appsSorted) {
          generateApps(r, apps);
      }

        c.addActionListener((ActionListener) new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                SortedGUI.main(args);
            }

        });

        inputButton.addActionListener((ActionListener) new ActionListener() {

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

                        // Please don't change the file path into a local file path. Keep it like this.
                        String filePath = "icons/"
                                + myString + ".png";
                        Icon ico = new ImageIcon(filePath);
                        for (App a : apps) {
                            if (a.getName().compareTo(myString) == 0)
                                ans = a;
                        }
                        JOptionPane.showMessageDialog(null,
                                "Name: " + ans.getName() + "\nDescription: "
                                        + ans.getAbout() + "\nVersion: "
                                        + ans.getVersions(),
                                ans.getName(), JOptionPane.INFORMATION_MESSAGE,
                                ico);
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

    }



    private static void generateApps(String appName, List<App> appsList) {
//  int row = totalApps % 3;
//  int col = totalApps % 3;
        int x = 450;
        int y = 1;
        int width = 300;
        int height = 200;

        // Please don't change the file path into a local file path. Keep it like this.
        String filePath = "icons/"
                + appName + ".png";
        Icon ico = new ImageIcon(filePath);

        JButton app = new JButton(ico);
        app.setText(appName);
        app.setBounds(x + ((totalApps % 3) * 350),
                y + ((totalApps / 3) % 3 * 250), width, height);
        a.add(app);

        app.addActionListener((ActionListener) new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                App ans = null;
                for (App a : appsList) {
                    if (a.getName().compareTo(appName) == 0)
                        ans = a;
                }
                JOptionPane.showMessageDialog(null,
                        "Name: " + ans.getName() + "\nDescription: "
                                + ans.getAbout() + "\nVersion: "
                                + ans.getVersions(),
                        appName, JOptionPane.INFORMATION_MESSAGE, ico);
            }

        });
        ++totalApps;
    }

    private static void removeApps(String appName, List<App> appsList) {
//int row = totalApps % 3;
//int col = totalApps % 3;
    }

    /**
     * Method after logged in to create a user home page.
     * 
     * @param name
     */
    public static void logInAfter(String name) {
        logIn.setVisible(false);
        JLabel n = new JLabel("Hello, " + name);
        n.setBounds(270, 20, 150, 30);
        a.add(n);

        JTextField bx = new JTextField("Enter a request...");
        bx.setBackground(Color.white);
        bx.setForeground(Color.black);
        a.add(bx);
        bx.setBounds(50, 300, 200, 30);

        JButton send = new JButton("Send");

        a.add(send);
        send.setBounds(270, 400, 100, 30);

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
        // Arrays.sort(appsSorted);

//  for (String r : appsSorted) {
//      System.out.println(r);
//  }

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

//  for(int x = 0; x< appsSorted.length - 1; x++) {
//      for(int y = x+1; y< appsSorted.length; y++) {
//          if(appsSorted[x].compareTo(appsSorted[y]) > 0) {
//              String temp = appsSorted[x];
//              appsSorted[x] = appsSorted[y];
//              appsSorted[y] = temp;
//          }
//      }
//  }
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
        String storeLink = meta[4];
        String price = meta[5];
        String category = meta[6];
        String storeName = meta[7];

        return new App(name, about, platform, versions, storeLink, price,
                category, storeName);
    }

}