import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * 
 */

/**
 * @author tanma
 * Sorted GUI class. Called by GUI.java.
 */
public class SortedGUI {
    static JFrame a = new JFrame("App Store");
    static JButton logIn = new JButton("Sign In/Sign up");
    static JPanel panel = new JPanel();
    static int totalApps = 0;

    /**
     * @param args
     */
    public static void main(String[] args) {
        a.add(panel);

        a.getContentPane().setBackground(Color.white);
        JButton inputButton = new JButton("Search");

        JLabel b1;
        b1 = new JLabel("App Store");
        b1.setBounds(125, 20, 90, 20);

        JLabel tc = new JLabel("<html>� 2021 TAJI Inc.<br><br>"
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
        JButton b = new JButton("The Forum");
        b.setBounds(100, 45, 100, 50);
        ;
        a.add(b);
        a.setSize(600, 600);
        a.setLayout(null);
        a.setVisible(true);

        // Please don't change the file path into a local file path. Keep it like this.
        List<App> apps = readAppsFromCSV(
                "Application Information - Sheet1 (1).csv");
        // Code for printing out app names.
        // for (App r : apps) {
        // System.out.println(r);
        // }

//        // Testing the sort names method
//        String[] appsSorted = sort(apps);
//        for (String r : appsSorted) {
//            System.out.println(r);
//        }

        JButton c = new JButton("UnSort");
        c.setBounds(100, 150, 100, 50);
        a.add(c);
        login.clickClear(b2);
        a.setSize(1920, 1080);
        a.setLayout(null);
        a.setVisible(true);

        String[] appsSorted = sort(apps);
        for (String r : appsSorted) {
            generateApps(r, apps);
        }

        c.addActionListener((ActionListener) new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                a.setVisible(false);
                a.dispose();
                GUI.main(args);
                GUI.totalApps = 0;
                
            }

        });

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
                    if (r.compareTo(myString) == 0) {
                        appExists = true;
                        App ans = null;

                        // Please don't change the file path into a local file path. Keep it like this.
                        String filePath = "updateIcons/"
                                + myString + ".png";
                        Icon ico = new ImageIcon(filePath);
                        for (App a : apps) {
                            if (a.getName().compareTo(myString) == 0)
                                ans = a;
                        }
                        JOptionPane.showMessageDialog(null,
                                "Name: " + ans.getName() + "\nDescription: "
                                        + ans.getAbout() + "\nVersion: "
                                        + ans.getVersions(),
                                ans.getName(), JOptionPane.INFORMATION_MESSAGE,
                                ico);
                    }
                }
                if (appExists == false) {
                    JOptionPane.showMessageDialog(null, "App Does Not Exist!");
                }

            }

        });

        logIn.addActionListener((ActionListener) new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                login.main(args);
            }

        });


       // Filter bar code
       JMenuBar jMenuBar = new JMenuBar();
       JMenu menu1 = new JMenu("Filter");

       // 3 Menus
       // Add options in Categories
       JMenu cat = new JMenu("By Categories");
       JMenuItem game = new JMenuItem("Game");
       game.addActionListener((ActionListener) new ActionListener() {

           @Override
           public void actionPerformed(ActionEvent e) {
               List<App> result = filter.filterCategory(apps, "Game");
               String message = "\n Games \n";
               for (App a : result) {
                   message += "\n\n\n" + "Name: " + a.getName() +"\nDescription: " +a.getAbout() + "\nVersion: "+a.getVersions();
               }
               JOptionPane.showMessageDialog(null, message);
           }
   
       });
       JMenuItem education = new JMenuItem("Education");
       education.addActionListener((ActionListener) new ActionListener() {

           @Override
           public void actionPerformed(ActionEvent e) {
               List<App> result = filter.filterCategory(apps, "Education");
               String message = "\n Education \n";
               for (App a : result) {
                   message += "\n\n\n" + "Name: " + a.getName() +"\nDescription: " +a.getAbout() + "\nVersion: "+a.getVersions();
               }
               JOptionPane.showMessageDialog(null, message);
           }
   
       });
       JMenuItem socialMedia = new JMenuItem("Social Media");
       socialMedia.addActionListener((ActionListener) new ActionListener() {

           @Override
           public void actionPerformed(ActionEvent e) {
               List<App> result = filter.filterCategory(apps, "Social Media");
               String message = "\n Social Media \n";
               for (App a : result) {
                   message += "\n\n\n" + "Name: " + a.getName() +"\nDescription: " +a.getAbout() + "\nVersion: "+a.getVersions();
               }
               JOptionPane.showMessageDialog(null, message);
           }
   
       });
       JMenuItem streaming = new JMenuItem("Streaming");
       streaming.addActionListener((ActionListener) new ActionListener() {

           @Override
           public void actionPerformed(ActionEvent e) {
               List<App> result = filter.filterCategory(apps, "Streaming");
               String message = "\n Streaming \n";
               for (App a : result) {
                   message += "\n\n\n" + "Name: " + a.getName() +"\nDescription: " +a.getAbout() + "\nVersion: "+a.getVersions();
               }
               JOptionPane.showMessageDialog(null, message);
           }
   
       });
       JMenuItem music = new JMenuItem("Music");
       music.addActionListener((ActionListener) new ActionListener() {

           @Override
           public void actionPerformed(ActionEvent e) {
               List<App> result = filter.filterCategory(apps, "Music");
               String message = "\n Music \n";
               for (App a : result) {
                   message += "\n\n\n" + "Name: " + a.getName() +"\nDescription: " +a.getAbout() + "\nVersion: "+a.getVersions();
               }
               JOptionPane.showMessageDialog(null, message);
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
               List<App> result = filter.filterPrice(apps, "Free");
               String message = "\n Free \n";
               for (App a : result) {
                   message += "\n\n\n" + "Name: " + a.getName() +"\nDescription: " +a.getAbout() + "\nVersion: "+a.getVersions();
               }
               JOptionPane.showMessageDialog(null, message);
           }
   
       });
       JMenuItem paid = new JMenuItem("Paid");
       paid.addActionListener((ActionListener) new ActionListener() {

           @Override
           public void actionPerformed(ActionEvent e) {
               List<App> result = filter.filterPrice(apps, "Paid");
               String message = "\n Paid \n";
               for (App a : result) {
                   message += "\n\n\n" + "Name: " + a.getName() +"\nDescription: " +a.getAbout() + "\nVersion: "+a.getVersions();
               }
               JOptionPane.showMessageDialog(null, message);
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
               List<App> result = filter.filterPlatform(apps, "Mobile Device");
               String message = "\n Mobile Device \n";
               for (App a : result) {
                   message += "\n\n\n" + "Name: " + a.getName() +"\nDescription: " +a.getAbout() + "\nVersion: "+a.getVersions();
               }
               JOptionPane.showMessageDialog(null, message);
           }
   
       });
       JMenuItem laptop = new JMenuItem("Laptop");
       laptop.addActionListener((ActionListener) new ActionListener() {

           @Override
           public void actionPerformed(ActionEvent e) {
               List<App> result = filter.filterPlatform(apps, "Laptop");
               String message = "\n Laptop \n";
               for (App a : result) {
                   message += "\n\n\n" + "Name: " + a.getName() +"\nDescription: " +a.getAbout() + "\nVersion: "+a.getVersions();
               }
               JOptionPane.showMessageDialog(null, message);
           }
   
       });
       JMenuItem gameConsole = new JMenuItem("Game Console");
       gameConsole.addActionListener((ActionListener) new ActionListener() {

           @Override
           public void actionPerformed(ActionEvent e) {
               List<App> result = filter.filterPlatform(apps, "Game Console");
               String message = "\n Game Console \n";
               for (App a : result) {
                   message += "\n\n\n" + "Name: " + a.getName() +"\nDescription: " +a.getAbout() + "\nVersion: "+a.getVersions();
               }
               JOptionPane.showMessageDialog(null, message);
           }
   
       });
       JMenuItem stream = new JMenuItem("Streaming Device");
       stream.addActionListener((ActionListener) new ActionListener() {

           @Override
           public void actionPerformed(ActionEvent e) {
               List<App> result = filter.filterPlatform(apps, "Streaming Device");
               String message = "\n Streaming Device \n";
               for (App a : result) {
                   message += "\n\n\n" + "Name: " + a.getName() +"\nDescription: " +a.getAbout() + "\nVersion: "+a.getVersions();
               }
               JOptionPane.showMessageDialog(null, message);
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
       a.setJMenuBar(jMenuBar);

       a.setVisible(true);
       a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }



    private static void generateApps(String appName, List<App> appsList) {
        int x = 450;
        int y = 1;
        int width = 250;
        int height = 150;                      
        
        String filePath = "updateIcons/"+appName+".png";
        Icon ico = new ImageIcon(filePath);               
        JButton app = new JButton(ico);
        //JPanel appPanel = new JPanel();
        
        //appPanel.setLayout(new GridLayout(3, 3));
        //appPanel.setVisible(true);
        app.setText(appName);
        app.setBounds(x + ((totalApps%4)*275), y+ ((totalApps/4)%4*175), width, height);
        a.add(app);

        app.addActionListener((ActionListener) new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                App ans = null;
                for (App a : appsList) {
                    if (a.getName().compareTo(appName) == 0)
                        ans = a;
                }
                JOptionPane.showMessageDialog(null,
                        "Name: " + ans.getName() + "\nDescription: "
                                + ans.getAbout() + "\nVersion: "
                                + ans.getVersions(),
                        appName, JOptionPane.INFORMATION_MESSAGE, ico);
            }

        });
        ++totalApps;
    }

    private static void removeApps(String appName, List<App> appsList) {
//int row = totalApps % 3;
//int col = totalApps % 3;
    }

    /**
     * Method after logged in to create a user home page.
     * 
     * @param name
     */
    public static void logInAfter(String name) {
        logIn.setVisible(false);
        JLabel n = new JLabel("Hello, " + name);
        n.setBounds(270, 20, 150, 30);
        a.add(n);

        JTextField bx = new JTextField("Enter a request...");
        bx.setBackground(Color.white);
        bx.setForeground(Color.black);
        a.add(bx);
        bx.setBounds(50, 300, 200, 30);

        JButton send = new JButton("Send");

        a.add(send);
        send.setBounds(270, 400, 100, 30);

        send.addActionListener((ActionListener) new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                FileWriter myObj;
                try {
                    myObj = new FileWriter(
                            "AdminRequests.txt",
                            true);
                    PrintWriter pr = new PrintWriter(myObj);
                    pr.write(bx.getText() + "\n");
                    // HashMap<String, String> map = new HashMap<String,
                    // String>();
                    JOptionPane.showMessageDialog(null,
                            "Successful addition to requests");
                    myObj.close();

                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                bx.setText("");
            }

        });

        a.setVisible(false);
        a.setVisible(true);

    }

    /**
     * Method to sort the apps alphabetically by names.
     * 
     * @param apps
     * @return a String array.
     */
    private static String[] sort(List<App> apps) {
        String appsSorted[] = new String[apps.size()];
        int i = 0;

        for (App r : apps) {
            appsSorted[i] = r.getName();
            i++;
        }
        // Arrays.sort(appsSorted);

//  for (String r : appsSorted) {
//      System.out.println(r);
//  }

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

//  for(int x = 0; x< appsSorted.length - 1; x++) {
//      for(int y = x+1; y< appsSorted.length; y++) {
//          if(appsSorted[x].compareTo(appsSorted[y]) > 0) {
//              String temp = appsSorted[x];
//              appsSorted[x] = appsSorted[y];
//              appsSorted[y] = temp;
//          }
//      }
//  }
        return appsSorted;

    }

    /**
     * Method to read the apps from the excel file.
     * 
     * @param fileName
     * @return a List of Apps.
     */
    public static List<App> readAppsFromCSV(String fileName) {
        List<App> apps = new ArrayList<>();
        Scanner sc;

        try {
            sc = new Scanner(new File(fileName));

            String line = sc.nextLine();            
            while (sc.hasNext()) {
                line = sc.nextLine();
                String[] attributes = line.split(",");

                App app = createApp(attributes);

                apps.add(app);

                

            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        return apps;
    }

    /**
     * Method to create an app.
     * 
     * @param meta
     * @return an App object.
     */
    private static App createApp(String[] meta) {
        String name = meta[0];
        String about = meta[1];
        String platform = meta[2];
        String versions = meta[3];
        String price = meta[4];
        String category = meta[5];
        String storeName = meta[6];
        String storeLink = meta[7];

        return new App(name, about, platform, versions, price,
                category, storeName, storeLink);
    }

}