/*
* CSE201_Group-8 Project
* Authors: Allison McWilliams, Jenn Pham, Isabel Pulte, Tanmay Bhatkar
* File-1: main file
* Date (start): 10/6/2021
*/

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.swing.*;

public class login {

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

        JFrame a = new JFrame("Login");
        a.getContentPane().setBackground(Color.gray);
        a.setSize(w, h);
        a.setLayout(null);
        a.setVisible(true);

        JLabel b1;
        b1 = new JLabel("Login or Create Account");
        b1.setBounds(w / 2, h / 10, 150, 20);
        a.add(b1);
        JLabel c1;
        c1 = new JLabel("Login");
        c1.setBounds(50, 50, 200, 30);
        a.add(c1);
        JTextField b7 = new JTextField("Email");
        a.add(b7);
        b7.setBounds(50, 100, 200, 30);
        clickClear(b7);

        JTextField b8 = new JTextField("Password");
        a.add(b8);
        b8.setBounds(50, 150, 200, 30);
        clickClear(b8);

        JLabel c2;
        JButton d1 = new JButton("Login");
        d1.setBounds(50, 200, 100, 25);
        a.add(d1);
        c2 = new JLabel("Create Account");
        c2.setBounds(275, 50, 200, 20);
        a.add(c2);
        JTextField b2 = new JTextField("First Name");
        a.add(b2);
        b2.setBounds(275, 100, 200, 30);
        clickClear(b2);

        JTextField b3 = new JTextField("Last Name");
        a.add(b3);
        b3.setBounds(275, 150, 200, 30);
        clickClear(b3);

        JTextField b4 = new JTextField("Email");
        a.add(b4);
        b4.setBounds(275, 200, 200, 30);
        clickClear(b4);

        JTextField b5 = new JTextField("Password");
        a.add(b5);
        b5.setBounds(275, 250, 200, 30);
        clickClear(b5);

        JTextField b6 = new JTextField("Re-type Password");
        a.add(b6);
        b6.setBounds(275, 300, 200, 30);
        clickClear(b6);

        JButton d = new JButton("Register");
        d.setBounds(275, 350, 100, 25);
        a.add(d);
        a.setBounds(10, 10, 500, 500);

        // Login
        d1.addActionListener((ActionListener) new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                HashMap<String, String> map = new HashMap<String, String>();
                map = readFromFile();

//                System.out.println("Iterating Hashmap...");
//                for (Map.Entry<String, String> entry : map.entrySet()) {
//                    String key = entry.getKey();
//                    String value = entry.getValue();
//                    System.out.println(key+" "+value);
//                    // ...
//                }
                boolean logIn = false;
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    String key = entry.getKey();
                    String value = entry.getValue();
                    if (key.compareTo(b7.getText()) == 0) {
                        if (value.compareTo(b8.getText().trim()) == 0) {
                            // System.out.println("Successful Login");
                            JOptionPane.showMessageDialog(null,
                                    "Successful login!");
                            logIn = true;
                            // GUI gu = new GUI();
                            GUI.logInAfter(key);
                        } else {
                            // System.out.println("Expecting: "+b8.getText()+"
                            // Got: "+value);
                            // System.out.println("Wrong Password");
                            JOptionPane.showMessageDialog(null,
                                    "Wrong password");
                            logIn = true;
                        }
                    }

                    // ...
                }
                if (!logIn)
                    // System.out.println("Wrong email");
                    JOptionPane.showMessageDialog(null, "Wrong Email");
                b7.setText("");
                b8.setText("");
            }

        });

        // Register
        d.addActionListener((ActionListener) new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                FileWriter myObj;
                try {
                    myObj = new FileWriter(
                            "Accounts.txt",
                            true);
                    PrintWriter pr = new PrintWriter(myObj);
                    HashMap<String, String> map = new HashMap<String, String>();
                    map = readFromFile();
                    boolean alreadyExists = false;

                    if (b5.getText().compareTo(b6.getText()) == 0) {
                        for (Map.Entry<String, String> entry : map.entrySet()) {
                            String key = entry.getKey();
                            // String value = entry.getValue();
                            if (key.compareTo(b4.getText()) == 0) {
                                alreadyExists = true;
                                break;
                            }
                        }
                        if (alreadyExists == false) {
                            // System.out.println("Successful registration");
                            JOptionPane.showMessageDialog(null,
                                    "Successful registration");
                            pr.write(b4.getText() + "," + b5.getText() + "\n");
                        } else {
                            JOptionPane.showMessageDialog(null,
                                    "Already registered");
                            // System.out.println("already registered!");
                        }

                    } else {
                        // System.out.println("Repeat the password correctly");
                        JOptionPane.showMessageDialog(null,
                                "Repeat the password correctly");
                    }
                    myObj.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                b4.setText("");
                b5.setText("");
                b6.setText("");

            }

        });

        // needs when clicked and to go to page with apps / app info etc
        // apps / app info loads from csv file

//        JButton d = new JButton("Google Chrome");
//        d.setBounds(400, 45, 200, 75);
//        a.add(d);
//        a.setSize(300, 250);
//        a.setLayout(null);
//        a.setVisible(true);
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
