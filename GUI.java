
/**
 * @author tanmay bhatkar
 *
 */

import java.awt.Color;

import javax.swing.*;

public class GUI {

    public static void main(String args[]) {

        JFrame a = new JFrame("App Store");
        a.getContentPane().setBackground(Color.cyan);
        JLabel b1;
        b1 = new JLabel("App Store");
        b1.setBounds(125,20,90,20);
        JTextField b2 = new JTextField("Search Here!");
        a.add(b2);
        b2.setBounds(50,100,200,30);
        a.add(b1);
        JButton b = new JButton("The Forum");
        b.setBounds(100, 45, 100, 50);;
        a.add(b);
        a.setSize(300, 250);
        a.setLayout(null);
        a.setVisible(true);

    }

}