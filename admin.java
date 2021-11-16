/*
* CSE201_Group-8 Project
* Authors: Allison McWilliams, Jenn Pham, Isabel Pulte, Tanmay Bhatkar
* File-2: Admin file
* Date (start): 10/6/2021
*/

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.swing.*;

public class admin {

    public static void main(String args[]) {

        int w = 300;
        int h = 250;

//        HashMap<String,String> map = new HashMap<String,String>();
//        map = readFromFile();
        /*
         *
         */
//        System.out.println("Iterating Hashmap...");
//        for (Map.Entry<String, String> entry : map.entrySet()) {
//            String key = entry.getKey();
//            String value = entry.getValue();
//            System.out.println(key+" "+value);
//            // ...
//        }

        JFrame a = new JFrame("Admin");
        a.getContentPane().setBackground(Color.gray);
        a.setSize(w, h);
        a.setLayout(null);
        a.setVisible(true);

        JLabel b1;
        b1 = new JLabel("Administration");
        b1.setBounds(w / 2, h / 10, 150, 20);
        a.add(b1);
        JLabel c1;
        c1 = new JLabel("Add Apps");
        c1.setBounds(50, 50, 200, 30);
        a.add(c1);
        JLabel n1;
        n1 = new JLabel("Name");
        n1.setBounds(50, 100, 200, 30);
        a.add(n1);
        c1 = new JLabel("Description");
        c1.setBounds(150, 100, 200, 30);
        a.add(c1);
        c1 = new JLabel("Platform");
        c1.setBounds(250, 100, 200, 30);
        a.add(c1);
        c1 = new JLabel("Versions");
        c1.setBounds(350, 100, 200, 30);
        a.add(c1);
        c1 = new JLabel("Store Link");
        c1.setBounds(450, 100, 200, 30);
        a.add(c1);
        c1 = new JLabel("Price");
        c1.setBounds(550, 100, 200, 30);
        a.add(c1);
        c1 = new JLabel("Category");
        c1.setBounds(650, 100, 200, 30);
        a.add(c1);
        c1 = new JLabel("Store Name");
        c1.setBounds(750, 100, 200, 30);
        a.add(c1);
        JTextField b7 = new JTextField("App 1");
        a.add(b7);
        b7.setBounds(50, 200, 200, 30);
        clickClear(b7);

        JTextField b8 = new JTextField("App 2");
        a.add(b8);
        b8.setBounds(50, 250, 200, 30);
        clickClear(b8);

        // JLabel c2;
        JButton d1 = new JButton("Approve");
        d1.setBounds(275, 200, 100, 30);
        a.add(d1);
        
        // JLabel c3;
        JButton d2 = new JButton("Approve");
        d2.setBounds(275, 250, 100, 30);
        a.add(d2);
//        c2 = new JLabel("Create Account");
//        c2.setBounds(275, 50, 200, 20);
//        a.add(c2);
//        JTextField b2 = new JTextField("First Name");
//        a.add(b2);
//        b2.setBounds(275, 100, 200, 30);
//        clickClear(b2);
//
//        JTextField b3 = new JTextField("Last Name");
//        a.add(b3);
//        b3.setBounds(275, 150, 200, 30);
//        clickClear(b3);
//
//        JTextField b4 = new JTextField("Email");
//        a.add(b4);
//        b4.setBounds(275, 200, 200, 30);
//        clickClear(b4);
//
//        JTextField b5 = new JTextField("Password");
//        a.add(b5);
//        b5.setBounds(275, 250, 200, 30);
//        clickClear(b5);
//
//        JTextField b6 = new JTextField("Re-type Password");
//        a.add(b6);
//        b6.setBounds(275, 300, 200, 30);
//        clickClear(b6);
//
//        JButton d = new JButton("Register");
//        d.setBounds(275, 350, 100, 25);
//        a.add(d);
//        a.setBounds(10, 10, 500, 500);


    } // end main

    public static void clickClear(JTextField j) {

        j.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                j.setText("");
            }
        });
    }

    private static HashMap<String, String> readFromFile() {
        HashMap<String, String> map = new HashMap<String, String>();
        try {
            Scanner sc = new Scanner(new File(
                    "Accounts.txt"));
            while (sc.hasNext()) {
                String line = sc.nextLine();
                String[] attributes = line.split(",");
                map.put(attributes[0], attributes[1]);

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return map;
    }
}
