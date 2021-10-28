/*
* CSE201_Group-8 Project
* Authors: Allison McWilliams, Jenn Pham, Isabel Pulte, Tanmay Bhatkar
* File-1: main file
* Date (start): 10/6/2021
*/

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class GUI {
    static JFrame a = new JFrame("App Store");
    static JButton logIn = new JButton("Sign In/Sign up");

    public static void main(String args[]) {

        a.getContentPane().setBackground(Color.white);
        JButton inputButton = new JButton("Search");

        JLabel b1;
        b1 = new JLabel("App Store");
        b1.setBounds(125, 20, 90, 20);

        /*
         * Team Credits 
         * © 2021 TAJI Inc. 
         * Personnel 
         * Jenn Pham: Project Manager & Designer
         * Allison McWilliams: Technical Manager
         * Isabel Pulte: Developer & Documentor 
         * Tanmay Bhatkar: Developer & Tester
         *
         */
        JLabel tc = new JLabel(
                "<html>© 2021 TAJI Inc.<br><br>"
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
        JButton b = new JButton("THE FORUM");
        b.setFont(new Font("Monospace", Font.BOLD, 20));
        b.setBounds(50, 45, 200, 50);
        
        a.add(b);
        a.setSize(600, 600);
        a.setLayout(null);
        a.setVisible(true);

        List<App> apps = readAppsFromCSV(
                "Application Information - Sheet1 (1).csv");
      // Code for printing out app names.
       // for (App r : apps) {
       //     System.out.println(r);
       // }

      // Testing the sort names method
       String[] appsSorted = sort(apps);
       for (String r : appsSorted) {
         System.out.println(r);
       }

        JButton c = new JButton("Apps Info");
        c.setBounds(100, 150, 100, 50);
        ;
        a.add(c);
        login.clickClear(b2);
        a.setSize(450, 250);
        a.setLayout(null);
        a.setVisible(true);

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
                         if(r.compareTo(myString)==0) {
                             JOptionPane.showMessageDialog(null,
                                     "App Exists!");
                             appExists = true;
                         }
                     }
                     if(appExists == false) {
                         JOptionPane.showMessageDialog(null,
                                 "App Does Not Exist!");
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
     * Method after logged in to create a user home page.
     * @param name
     */
    public static void logInAfter(String name) {
        logIn.setVisible(false);
        JLabel n = new JLabel("Hello, " + name);
        n.setBounds(270, 20, 150, 30);
        a.add(n);
        a.setVisible(false);
        a.setVisible(true);

    }

    /**
     * Method to sort the apps alphabetically by names.
     * @param apps
     * @return a String array.
     */
    private static String[] sort(List<App> apps) {
        int i = 0;
        String appsNames[] = new String[apps.size()];
        for (App r : apps) {
            appsNames[i] = r.getName();
            i++;
        }

        String appsSorted[] = Arrays.copyOf(appsNames, appsNames.length);
        Arrays.sort(appsSorted);

        return appsSorted;

    }

    /**
     * Method to read the apps from the excel file.
     * @param fileName
     * @return a List of Apps.
     */
    private static List<App> readAppsFromCSV(String fileName) {
        List<App> apps = new ArrayList<>();
        Scanner sc;

        try {
            sc = new Scanner(new File(fileName));

            String line = sc.nextLine();

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
     * @param meta
     * @return an App object.
     */
    private static App createApp(String[] meta) {
        String name = meta[0];
        String about = meta[1];

        return new App(name, about);
    }

}

/**
 * Class App.
 */
class App {
    private String name;
    private String about;

    public App(String name, String about) {
        this.name = name;
        this.about = about;
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

    @Override
    public String toString() {
        return "Name: " + name + "\n" + "About: " + about + "\n";
    }
}
