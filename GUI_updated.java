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
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GUI_updated {

    public static void main(String args[]) throws FileNotFoundException {

        JFrame a = new JFrame("App Store");
        JButton inputButton = new JButton("Search");
        a.getContentPane().setBackground(Color.cyan);
        JLabel b1;
        b1 = new JLabel("App Store");
        b1.setBounds(125, 20, 90, 20);
        a.add(inputButton);
        inputButton.setBounds(270, 100, 100, 30);
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

        // change the file path everytime you are testing to make sure you include all of it.
        readAppsFromCSV("C:/Users/tanma/Documents/Miami University/2nd year/2nd Semester/CSE274/Workspace/CSE201_Project/src/applist.csv");
//        for (App r : apps) {
//            System.out.println(r);
//        }

        JButton c = new JButton("Apps Info");
        c.setBounds(100, 150, 100, 50);
        ;
        a.add(c);
        a.setSize(300, 250);
        a.setLayout(null);
        a.setVisible(true);

        inputButton.addActionListener((ActionListener) new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                String myString = b2.getText();

                b2.setText("");

                System.out.println(myString);
            }

        });

        // needs when clicked and to go to page with apps / app info etc
        // apps / app info loads from csv file

    }

    private static void readAppsFromCSV(String fileName) throws FileNotFoundException {        
        
        Scanner sc = new Scanner(new File(fileName));
        
        for(int i = 0; i<=10; i++) {
            System.out.println(sc.nextLine());
            System.out.println();
        }
        sc.close();
        
              
        
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
