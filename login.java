/*
* CSE201_Group-8 Project
* Authors: Allison McWilliams, Jenn Pham, Isabel Pulte, Tanmay Bhatkar
* File-1: main file
* Date (start): 10/6/2021
*/

import java.awt.Color;
import javax.swing.*;



public class Login {

    public static void main(String args[]) {
    	
    	int w = 300;
    	int h = 250;

        JFrame a = new JFrame("Login");
        a.getContentPane().setBackground(Color.gray);
        a.setSize(w, h);
        a.setLayout(null);
        a.setVisible(true);
        
        JLabel b1;
        b1 = new JLabel("Login or Create Account");
        b1.setBounds(w/2,h/10,150,20);
        a.add(b1);
        JLabel c1;
        c1 = new JLabel("Login");
        c1.setBounds(50,50,200,30);
        a.add(c1);
        JTextField b7 = new JTextField("Email");
        a.add(b7);
        b7.setBounds(50,100,200,30);
        JTextField b8 = new JTextField("Password");
        a.add(b8);
        b8.setBounds(50,150,200,30);
        JLabel c2;
        JButton d1 = new JButton("Login");
        d1.setBounds(50, 200, 100, 25);
        a.add(d1);
        c2 = new JLabel("Create Account");
        c2.setBounds(275,50,200,20);
        a.add(c2);
        JTextField b2 = new JTextField("First Name");
        a.add(b2);
        b2.setBounds(275,100,200,30);
        JTextField b3 = new JTextField("Last Name");
        a.add(b3);
        b3.setBounds(275,150,200,30);
        JTextField b4 = new JTextField("Email");
        a.add(b4);
        b4.setBounds(275,200,200,30);
        JTextField b5 = new JTextField("Password");
        a.add(b5);
        b5.setBounds(275,250,200,30);
        JTextField b6 = new JTextField("Re-type Password");
        a.add(b6);
        b6.setBounds(275,300,200,30);
        JButton d = new JButton("Register");
        d.setBounds(275, 350, 100, 25);
        a.add(d);
    
        // needs when clicked and to go to page with apps / app info etc 
        		// apps / app info loads from csv file
        
//        JButton d = new JButton("Google Chrome");
//        d.setBounds(400, 45, 200, 75);
//        a.add(d);
//        a.setSize(300, 250);
//        a.setLayout(null);
//        a.setVisible(true);
    }
}
