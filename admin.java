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
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

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
        c1.setBounds(175, 100, 200, 30);
        a.add(c1);
        c1 = new JLabel("Platform");
        c1.setBounds(300, 100, 200, 30);
        a.add(c1);
        c1 = new JLabel("Versions");
        c1.setBounds(425, 100, 200, 30);
        a.add(c1);
        c1 = new JLabel("Price");
        c1.setBounds(550, 100, 200, 30);
        a.add(c1);
        c1 = new JLabel("Category");
        c1.setBounds(675, 100, 200, 30);
        a.add(c1);
        c1 = new JLabel("Store Name");
        c1.setBounds(800, 100, 200, 30);
        a.add(c1);
        c1 = new JLabel("Store Link");
        c1.setBounds(925, 100, 200, 30);
        a.add(c1);
        JTextField name = new JTextField("Name");
        a.add(name);
        name.setBounds(50, 150, 100, 30);
        clickClear(name);
        JTextField desc = new JTextField("Description");
        a.add(desc);
        desc.setBounds(175, 150, 100, 30);
        clickClear(desc);
        JTextField plat = new JTextField("Platform");
        a.add(plat);
        plat.setBounds(300, 150, 100, 30);
        clickClear(plat);
        JTextField ver = new JTextField("Versions");
        a.add(ver);
        ver.setBounds(425, 150, 100, 30);
        clickClear(ver);
        JTextField price = new JTextField("Price");
        a.add(price);
        price.setBounds(550, 150, 100, 30);
        clickClear(price);
        JTextField cat = new JTextField("Category");
        a.add(cat);
        cat.setBounds(675, 150, 100, 30);
        clickClear(cat);
        JTextField storeName = new JTextField("Store Name");
        a.add(storeName);
        storeName.setBounds(800, 150, 100, 30);
        clickClear(storeName);
        
        JPopupMenu b13 = new JPopupMenu("Store Name");
        a.add(b13);
        // Categories: games, streaming, music, social media, education
        // Store Names: Google Play, Apple Store, Microsoft Store
        JMenuItem goog = new JMenuItem("Google Play");  
        JMenuItem appl = new JMenuItem("Apple");  
        JMenuItem micro = new JMenuItem("Microsoft");  
        b13.add(goog); b13.add(appl); b13.add(micro);        
        storeName.addMouseListener(new MouseAdapter() {  
           public void mouseClicked(MouseEvent e) {              
               b13.show(a , 800, 150);  
           }                 
        });  
        goog.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e) {              
            	storeName.setText("Google Play");
            }  
           });  
           appl.addActionListener(new ActionListener(){  
               public void actionPerformed(ActionEvent e) {              
            	   storeName.setText("Apple");  
               }  
              });  
           micro.addActionListener(new ActionListener(){  
               public void actionPerformed(ActionEvent e) {              
            	   storeName.setText("Microsoft");   
               }  
              });  
        b13.setBounds(800, 150, 100, 30);
//        clickClear(b13);
        // Categories: games, streaming, music, social media, education
        JPopupMenu b12a = new JPopupMenu("Category");
        a.add(b12a);
        JMenuItem game = new JMenuItem("Games");  
        JMenuItem stream = new JMenuItem("Streaming");  
        JMenuItem music = new JMenuItem("Music");  
        JMenuItem soc = new JMenuItem("Social Media");  
        JMenuItem edu = new JMenuItem("Education");  
        b12a.add(game); b12a.add(stream); b12a.add(music); b12a.add(soc); b12a.add(edu);        
        cat.addMouseListener(new MouseAdapter() {  
           public void mouseClicked(MouseEvent e) {              
               b12a.show(a , 675, 150);  
           }                 
        });
        game.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e) {              
            	cat.setText("Games");
            }  
           });  
           stream.addActionListener(new ActionListener(){  
               public void actionPerformed(ActionEvent e) {              
            	   cat.setText("Streaming");  
               }  
              });  
           music.addActionListener(new ActionListener(){  
               public void actionPerformed(ActionEvent e) {              
            	   cat.setText("Music");   
               }  
              });  
           soc.addActionListener(new ActionListener(){  
               public void actionPerformed(ActionEvent e) {              
            	   cat.setText("Social Media");   
               }  
              });  
           edu.addActionListener(new ActionListener(){  
               public void actionPerformed(ActionEvent e) {              
            	   cat.setText("Education");   
               }  
              });  
        
        b12a.setBounds(675, 150, 100, 30);
        
        JTextField b14 = new JTextField("Store Link");
        a.add(b14);
        b14.setBounds(925, 150, 100, 30);
        clickClear(b14);
        
        String toFile = name.getText() + "," + desc.getText() + "," + plat.getText() + "," + ver.getText() + "," +
        		price.getText() + "," + cat.getText() + "," + storeName.getText();
        

        JLabel c2;
        JButton d1 = new JButton("Approve");
        d1.setBounds(1050, 150, 100, 30);
        a.add(d1);
        

        // Add app
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
                boolean addApp = false;
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    String key = entry.getKey();
                    String value = entry.getValue();
                    if (key.compareTo(storeName.getText()) == 0) {
                        if (value.compareTo(storeName.getText().trim()) == 0) {
                            // System.out.println("Successful Login");
                            JOptionPane.showMessageDialog(null,
                                    "App Added!");
                            addApp = true;
                            // GUI gu = new GUI();
//                            GUI.logInAfter(key);
                        } else {
                            // System.out.println("Expecting: "+b8.getText()+"
                            // Got: "+value);
                            // System.out.println("Wrong Password");
                            JOptionPane.showMessageDialog(null,
                                    "App Unsuccessful");
                            addApp = true;
                        }
                    }

                    // ...
                }
                if (!addApp)
                    // System.out.println("Wrong email");
                    JOptionPane.showMessageDialog(null, "Incorrect Information");
                storeName.setText("");
                storeName.setText("");
            }

        });

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
                    "Apps.txt"));
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
