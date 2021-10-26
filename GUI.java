/*
* CSE201_Group-8 Project
* Authors: Allison McWilliams, Jenn Pham, Isabel Pulte, Tanmay Bhatkar
* File-1: main file
* Date (start): 10/6/2021
*/

import java.awt.Color;
import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class GUI {

    public static void main(String args[]) {

        JFrame a = new JFrame("App Store");
        a.getContentPane().setBackground(Color.cyan);
        JLabel b1;
        b1 = new JLabel("App Store");
        b1.setBounds(125, 20, 90, 20);
        JTextField b2 = new JTextField("Search Here!");
        a.add(b2);
        b2.setBounds(50, 100, 200, 30);
        a.add(b1);
        JButton b = new JButton("The Forum");
        b.setBounds(100, 45, 100, 50);
        ;
        a.add(b);
        a.setSize(300, 250);
        a.setLayout(null);
        a.setVisible(true);

        List<App> apps = readAppsFromCSV(
                "C:/Users/tanma/Documents/Miami University/2nd year/2nd Semester/CSE274/Workspace/Scratch/src/applist.csv");

        for (App r : apps) {
            System.out.println(r);
        }

        String[] sortedApps = sort(apps);

        for (String r : sortedApps) {
            System.out.println(r);
        }

        JButton c = new JButton("Apps Info");
        c.setBounds(100, 150, 100, 50);
        ;
        a.add(c);
        a.setSize(300, 250);
        a.setLayout(null);
        a.setVisible(true);

        // needs when clicked and to go to page with apps / app info etc
        // apps / app info loads from csv file

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

        for (int x = 0; x < 10; x++) {
            for (int y = 1; y < (10 - x); y++) {
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

            for(int i = 0; i<10; i++) {

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
        String name = meta[1];
        String about = meta[2];

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
