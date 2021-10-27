/*
* CSE201_Group-8 Project
* Authors: Allison McWilliams, Jenn Pham, Isabel Pulte, Tanmay Bhatkar
* File-1: main file
* Date (start): 10/6/2021
*/

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
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

        JTextField b2 = new JTextField("Search Here!");
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
                                     "App you're searching exists");
                             appExists = true;
                         }
                     }
                     if(appExists == false) {
                         JOptionPane.showMessageDialog(null,
                                 "App does not exist");
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

    public static void logInAfter(String name) {
        logIn.setVisible(false);
        JLabel n = new JLabel("Hello, " + name);
        n.setBounds(270, 20, 150, 30);
        a.add(n);
        a.setVisible(false);
        a.setVisible(true);

    }

    private static String[] sort(List<App> apps) {
        String appsSorted[] = new String[apps.size()];
        int i = 0;

        for (App r : apps) {
            appsSorted[i] = r.getName();
            i++;
        }
        // Arrays.sort(appsSorted);

//        for (String r : appsSorted) {
//            System.out.println(r);
//        }

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

//        for(int x = 0; x< appsSorted.length - 1; x++) {
//            for(int y = x+1; y< appsSorted.length; y++) {
//                if(appsSorted[x].compareTo(appsSorted[y]) > 0) {
//                    String temp = appsSorted[x];
//                    appsSorted[x] = appsSorted[y];
//                    appsSorted[y] = temp;
//                }
//            }
//        }
        return appsSorted;

    }

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

    private static App createApp(String[] meta) {
        String name = meta[0];
        String about = meta[1];

        return new App(name, about);
    }

}

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
