/**
 * File: Filtering method: Platform, Categories, and Price.
 * Author: JP
 */

import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * Class filterDriver.
 * @author Jenn Pham
 *
 */
public class filterDriver {
    /**
     * This method creates a JMenuBar called Filter with expandable menus.
     * Filter has 3 types: By Categories, By Price, and By Platform.
     * 
     * @return a JMenuBar.
     */
    public JMenuBar getJMenuBar() {
        List<App> apps = GUI.readAppsFromCSV("Application Information - Sheet1 (1).csv");
       
        JMenuBar jMenuBar = new JMenuBar();
        // Filter bar code
        JMenu menu1 = new JMenu("Filter");
        // 3 Menus
        // Add options in Categories
        JMenu cat = new JMenu("By Categories");
        JMenuItem game = new JMenuItem("Game");
        game.addActionListener((ActionListener) new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                List<App> result = filterCategory(apps, "Game");
                JLabel[] arrJLabels = new JLabel[result.size()];
                int i = 0;
                for (App a : result) {
                    String filePath = "icons/"+a.getName()+".png";
                    Icon ico = new ImageIcon(filePath);
                    JLabel aJLabel = new JLabel(a.getName(), ico, SwingConstants.LEFT);
                    arrJLabels[i] = aJLabel; 
                    i++;               
                }
                JOptionPane.showMessageDialog(null, arrJLabels, "GAME", JOptionPane.INFORMATION_MESSAGE);
            }
    
        });
        JMenuItem education = new JMenuItem("Education");
        education.addActionListener((ActionListener) new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                List<App> result = filterCategory(apps, "Education");
                JLabel[] arrJLabels = new JLabel[result.size()];
                int i = 0;
                for (App a : result) {
                    String filePath = "icons/"+a.getName()+".png";
                    Icon ico = new ImageIcon(filePath);
                    JLabel aJLabel = new JLabel(a.getName(), ico, SwingConstants.LEFT);
                    arrJLabels[i] = aJLabel; 
                    i++;               
                }
                JOptionPane.showMessageDialog(null, arrJLabels, "EDUCATION", JOptionPane.INFORMATION_MESSAGE);
            }
    
        });
        JMenuItem socialMedia = new JMenuItem("Social Media");
        socialMedia.addActionListener((ActionListener) new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                List<App> result = filterCategory(apps, "Social Media");
                JLabel[] arrJLabels = new JLabel[result.size()];
                int i = 0;
                for (App a : result) {
                    String filePath = "icons/"+a.getName()+".png";
                    Icon ico = new ImageIcon(filePath);
                    JLabel aJLabel = new JLabel(a.getName(), ico, SwingConstants.LEFT);
                    arrJLabels[i] = aJLabel; 
                    i++;               
                }
                JOptionPane.showMessageDialog(null, arrJLabels, "SOCIAL MEDIA", JOptionPane.INFORMATION_MESSAGE);
            }
    
        });
        JMenuItem streaming = new JMenuItem("Streaming");
        streaming.addActionListener((ActionListener) new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                List<App> result = filterCategory(apps, "Streaming");
                JLabel[] arrJLabels = new JLabel[result.size()];
                int i = 0;
                for (App a : result) {
                    String filePath = "icons/"+a.getName()+".png";
                    Icon ico = new ImageIcon(filePath);
                    JLabel aJLabel = new JLabel(a.getName(), ico, SwingConstants.LEFT);
                    arrJLabels[i] = aJLabel; 
                    i++;               
                }
                JOptionPane.showMessageDialog(null, arrJLabels, "STREAMING", JOptionPane.INFORMATION_MESSAGE);
            }
    
        });
        JMenuItem music = new JMenuItem("Music");
        music.addActionListener((ActionListener) new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                List<App> result = filterCategory(apps, "Music");
                JLabel[] arrJLabels = new JLabel[result.size()];
                int i = 0;
                for (App a : result) {
                    String filePath = "icons/"+a.getName()+".png";
                    Icon ico = new ImageIcon(filePath);
                    JLabel aJLabel = new JLabel(a.getName(), ico, SwingConstants.LEFT);
                    arrJLabels[i] = aJLabel; 
                    i++;               
                }
                JOptionPane.showMessageDialog(null, arrJLabels, "MUSIC", JOptionPane.INFORMATION_MESSAGE);
            }
    
        });
        cat.add(game);
        cat.add(education);
        cat.add(socialMedia);
        cat.add(streaming);
        cat.add(music);

        // Add options in Price
        JMenu price = new JMenu("By Price");
        JMenuItem free = new JMenuItem("Free");
        free.addActionListener((ActionListener) new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                List<App> result = filterPrice(apps, "Free");
                JLabel[] arrJLabels = new JLabel[result.size()];
                int i = 0;
                for (App a : result) {
                    String filePath = "icons/"+a.getName()+".png";
                    Icon ico = new ImageIcon(filePath);
                    JLabel aJLabel = new JLabel(a.getName(), ico, SwingConstants.LEFT);
                    arrJLabels[i] = aJLabel; 
                    i++;               
                }
                JOptionPane.showMessageDialog(null, arrJLabels, "FREE", JOptionPane.INFORMATION_MESSAGE);
            }
    
        });
        JMenuItem paid = new JMenuItem("Paid");
        paid.addActionListener((ActionListener) new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                List<App> result = filterPrice(apps, "Paid");
                JLabel[] arrJLabels = new JLabel[result.size()];
                int i = 0;
                for (App a : result) {
                    String filePath = "icons/"+a.getName()+".png";
                    Icon ico = new ImageIcon(filePath);
                    JLabel aJLabel = new JLabel(a.getName(), ico, SwingConstants.LEFT);
                    arrJLabels[i] = aJLabel; 
                    i++;               
                }
                JOptionPane.showMessageDialog(null, arrJLabels, "PAID", JOptionPane.INFORMATION_MESSAGE);
            }
    
        });
        price.add(free);
        price.add(paid);

        // Add options in Platform
        JMenu pf = new JMenu("By Platform");
        JMenuItem mobile = new JMenuItem("Mobile Device");
        mobile.addActionListener((ActionListener) new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                List<App> result = filterPlatform(apps, "Mobile Device");
                JLabel[] arrJLabels = new JLabel[result.size()];
                int i = 0;
                for (App a : result) {
                    String filePath = "icons/"+a.getName()+".png";
                    Icon ico = new ImageIcon(filePath);
                    JLabel aJLabel = new JLabel(a.getName(), ico, SwingConstants.LEFT);
                    arrJLabels[i] = aJLabel; 
                    i++;               
                }
                JOptionPane.showMessageDialog(null, arrJLabels, "MOBILE DEVICE", JOptionPane.INFORMATION_MESSAGE);
            }
    
        });
        JMenuItem laptop = new JMenuItem("Laptop");
        laptop.addActionListener((ActionListener) new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                List<App> result = filterPlatform(apps, "Laptop");
                JLabel[] arrJLabels = new JLabel[result.size()];
                int i = 0;
                for (App a : result) {
                    String filePath = "icons/"+a.getName()+".png";
                    Icon ico = new ImageIcon(filePath);
                    JLabel aJLabel = new JLabel(a.getName(), ico, SwingConstants.LEFT);
                    arrJLabels[i] = aJLabel; 
                    i++;               
                }
                JOptionPane.showMessageDialog(null, arrJLabels, "LAPTOP", JOptionPane.INFORMATION_MESSAGE);
            }
    
        });
        JMenuItem gameConsole = new JMenuItem("Game Console");
        gameConsole.addActionListener((ActionListener) new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                List<App> result = filterPlatform(apps, "Game Console");
                JLabel[] arrJLabels = new JLabel[result.size()];
                int i = 0;
                for (App a : result) {
                    String filePath = "icons/"+a.getName()+".png";
                    Icon ico = new ImageIcon(filePath);
                    JLabel aJLabel = new JLabel(a.getName(), ico, SwingConstants.LEFT);
                    arrJLabels[i] = aJLabel; 
                    i++;               
                }
                JOptionPane.showMessageDialog(null, arrJLabels, "GAME CONSOLE", JOptionPane.INFORMATION_MESSAGE);
            }
    
        });
        JMenuItem stream = new JMenuItem("Streaming Device");
        stream.addActionListener((ActionListener) new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                List<App> result = filterPlatform(apps, "Streaming Device");
                JLabel[] arrJLabels = new JLabel[result.size()];
                int i = 0;
                for (App a : result) {
                    String filePath = "icons/"+a.getName()+".png";
                    Icon ico = new ImageIcon(filePath);
                    JLabel aJLabel = new JLabel(a.getName(), ico, SwingConstants.LEFT);
                    arrJLabels[i] = aJLabel; 
                    i++;               
                }
                JOptionPane.showMessageDialog(null, arrJLabels, "STREAMING DEVICE", JOptionPane.INFORMATION_MESSAGE);
            }
    
        });
        pf.add(mobile);
        pf.add(laptop);
        pf.add(gameConsole);
        pf.add(stream);
        // Add menus into main menu.
        menu1.add(cat);
        menu1.add(price);
        menu1.add(pf);
        // Add menu into menu bar.
        jMenuBar.add(menu1);

        return jMenuBar;
    }

    /**
     * This method filter apps category: Game, Education, Social Media, Streaming, and Music.
     * @param m
     * @return a List of Apps with the indicated categories.
     */ 
    public static List<App> filterCategory(List<App> apps, String choice) {
        List<App> result = new ArrayList<App>();
        for (App r : apps) {
            if(r.getCategory().equalsIgnoreCase(choice)) {
                result.add(r);
            }
        }

        return result;
    }

    /**
     * This method filter by price: Free or Paid
     * @param m
     * @return a List of Apps with the indicated categories.
     */ 
    public static List<App> filterPrice(List<App> apps, String choice) {
        List<App> result = new ArrayList<App>();
        if (choice.equalsIgnoreCase("Free")) {
            for (App r : apps) {
                if(r.getPrice().equals("0")) {
                    result.add(r);
                }
            }
        } else if (choice.equalsIgnoreCase("Paid")) {
            for (App r : apps) {
                if(!r.getPrice().equals("0")) {
                    result.add(r);
                }
            }
        }

        return result;
    }

    /**
     * This method filter apps platform: Mobile Device, Streaming Device, Laptop, Game Console.
     * @param m
     * @return a List of Apps with the indicated categories.
     */ 
    public static List<App> filterPlatform(List<App> apps, String choice) {
        List<App> result = new ArrayList<App>();
        for (App r : apps) {
            if(r.getPlatform().contains(choice.toLowerCase())) {
                result.add(r);
            }
        }

        return result;
    }
    
}
