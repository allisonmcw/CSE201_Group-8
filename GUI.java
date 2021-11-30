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
import javax.swing.border.Border;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * @author Tanmay Bahtkar, Jenn Pham, Allison McWilliams, Isable Pulte Class GUI
 */
public class GUI {
	static JFrame a = new JFrame("App Store");
	static JButton logIn = new JButton("Sign In/Sign up");
	static int totalApps = 0;

	public static void main(String args[]) {

		a.getContentPane().setBackground(Color.white);
		JButton inputButton = new JButton("Search");

		JLabel b1;
		b1 = new JLabel("App Store");
		b1.setBounds(125, 20, 90, 20);

		JLabel tc = new JLabel("<html>� 2021 TAJI Inc.<br><br>"
				+ "<b>Personnel</b><br>Jenn Pham: Project Manager & Designer<br>Allison McWilliams: Technical Manager<br>"
				+ "Isabel Pulte: Developer & Documentor<br>Tanmay Bhatkar: Developer & Tester </html>");
		tc.setBounds(50, 200, 2000, 500);
		a.add(tc);

		a.add(logIn);
		logIn.setBounds(270, 20, 150, 30);

		JLabel scroll = new JLabel("This is to test scrollinh");
		scroll.setBounds(2160, 3280, 200, 200);
		a.add(scroll);

		a.add(inputButton);
		inputButton.setBounds(270, 110, 100, 30);
		Border bored = BorderFactory.createLineBorder(Color.GRAY, 1, true);
		// Create a JPanel
		JScrollPane scrollBar = new JScrollPane();

		// Create a JFrame with title ( AddScrollBarToJFrame )
		// Add JScrollPane into JFrame
		a.add(scrollBar);

		// Set close operation for JFrame
		a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JTextField b2 = new JTextField("Type something...");
		b2.setBorder(bored);
		b2.setBackground(Color.white);
		b2.setForeground(Color.black);
		a.add(b2);
		b2.setBounds(50, 110, 225, 30);
		a.add(b1);
		JButton b = new JButton("The Forum");
		b.setBounds(100, 45, 100, 50);
		;
		a.add(b);

		a.setLayout(null);
		a.setVisible(true);

		List<App> apps = readAppsFromCSV("Application Information - Sheet1 (1).csv");
		// Code for printing out app names.
		for (App r : apps) {
			// System.out.println(r.getName());
			generateApps(r.getName(), apps);
		}

		JButton c = new JButton("Sort");
		c.setBounds(100, 150, 100, 50);
		a.add(c);
		login.clickClear(b2);

		a.setLayout(null);
		a.setVisible(true);

		c.addActionListener((ActionListener) new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// String args[] = {"Sort",""};
				a.setVisible(false);
				a.dispose();
				SortedGUI.main(args);
				SortedGUI.totalApps = 0;
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
						String filePath = "icons/" + myString + ".png";
						Icon ico = new ImageIcon(filePath);
						for (App a : apps) {
							if (a.getName().compareTo(myString) == 0)
								ans = a;
						}
						JOptionPane
								.showMessageDialog(null,
										"Name: " + ans.getName() + "\nDescription: " + ans.getAbout() + "\nVersion: "
												+ ans.getVersions(),
										ans.getName(), JOptionPane.INFORMATION_MESSAGE, ico);
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
		
		// Generate Filter Menu Bar
		filterDriver filterDriver = new filterDriver();
		a.setJMenuBar(filterDriver.getJMenuBar());
        a.setTitle("MetaApp");
		a.setVisible(true);
		a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        a.setExtendedState(JFrame.MAXIMIZED_BOTH);

	} // main end

	private static JButton generateApps(String appName, List<App> appsList) {
		int x = 450;
		int y = 1;
		int width = 230;
		int height = 150;
		JButton app;
		String filePath;
		filePath = "icons/" + appName + ".png";
		
		File tempFile = new File(filePath);
		boolean exists = tempFile.exists();
		if (!exists) {
			filePath = "icons/appnotfound.png";
		}
		
		Icon ico = new ImageIcon(filePath);
		app = new JButton(ico);
		app.setText(appName);
		app.setBounds(x + ((totalApps % 4) * 230), y + ((totalApps / 4) % 4 * 175), width, height);
		a.add(app);

		JButton clear = new JButton("Clear Apps");
		clear.setBounds(250, 150, 100, 50);
		a.add(clear);
		clear.setVisible(false);

		app.addActionListener((ActionListener) new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				App ans = null;
				for (App a : appsList) {
					if (a.getName().compareTo(appName) == 0)
						ans = a;
				}
				JOptionPane.showMessageDialog(null,
						"Name: " + ans.getName() + "\nDescription: " + ans.getAbout() + "\nVersion: "
								+ ans.getVersions() + "\nPlatforms: " + ans.getPlatform(),
						appName, JOptionPane.INFORMATION_MESSAGE, ico);
			}

		});

		clear.addActionListener((ActionListener) new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// a.remove(app);
				a.setVisible(false);
				a.setVisible(true);
			}
		});
		++totalApps;
		if (totalApps == appsList.size())
			totalApps = 0;
		return app;
	}

	/**
	 * Method after logged in to create a user home page.
	 * 
	 * @param name
	 */
	public static void logInAfter(String name, String userType) {
		logIn.setVisible(false);
		JLabel n = new JLabel("Hello, " + name);
		n.setBounds(270, 20, 150, 30);
		a.add(n);

		JButton send = new JButton("All Requests");
		a.add(send);
		send.setBounds(100, 250, 100, 30);

		send.addActionListener((ActionListener) new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				admin.main(null);
			}

		});

		JButton comm = new JButton("Comment here!");
		a.add(comm);
		comm.setBounds(270, 250, 120, 30);
		comm.addActionListener((ActionListener) new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String args[] = new String[2];
				String temp;
				if (name.contains(":"))
					temp = name.substring(name.indexOf(":") + 2);
				else
					temp = name.substring(name.indexOf(":") + 1);
				args[0] = temp;
				args[1] = userType;
				commentDriver.main(args);

			}

		});
		a.setVisible(false);
		a.setVisible(true);

	}

	/**
	 * GUI after logged in as an admin.
	 * 
	 * @param name
	 * @param userType
	 */
	public static void logInAfterAdmin(String name, String userType) {
		String args[] = new String[2];
		String temp;
		if (name.contains(":"))
			temp = name.substring(name.indexOf(":") + 2);
		else
			temp = name.substring(name.indexOf(":") + 1);
		args[0] = temp;
		args[1] = userType;

		logIn.setVisible(false);
		JLabel n = new JLabel("Hello, " + name);
		n.setBounds(270, 20, 150, 30);
		a.add(n);

		JButton lo = new JButton("Log Out");
		a.add(lo);
		lo.setBounds(270, 50, 150, 30);
		lo.setVisible(false);

//        JLabel bx = new JLabel("Enter a request...");
//        bx.setBackground(Color.white);
//        bx.setForeground(Color.black);
//        a.add(bx);
//        bx.setBounds(50, 300, 200, 30);        

		JButton send = new JButton("Request an app");
		a.add(send);
		send.setBounds(270, 300, 150, 30);

		JButton appReq = new JButton("Pending requests");
		a.add(appReq);
		appReq.setVisible(true);
		appReq.setBounds(270, 350, 150, 30);

		JButton comm = new JButton("Comment here!");
		a.add(comm);
		comm.setBounds(270, 250, 150, 30);

		appReq.addActionListener((ActionListener) new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (userType.compareTo("Admin") == 0) {
//                    System.out.println("In it");
					appReqs.main(null);
				} else {
					JOptionPane.showMessageDialog(null, "You are not an admin");
				}
			}

		});

		send.addActionListener((ActionListener) new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				admin.main(null);
			}

		});

		lo.addActionListener((ActionListener) new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				lo.setVisible(false);
				n.setVisible(false);
				logIn.setVisible(true);
			}

		});

		comm.addActionListener((ActionListener) new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String args[] = new String[2];
				String temp;
				if (name.contains(":"))
					temp = name.substring(name.indexOf(":") + 2);
				else
					temp = name.substring(name.indexOf(":") + 1);
				args[0] = temp;
				args[1] = userType;
				commentDriver.main(args);

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
	public static String[] sort(List<App> apps) {
		String appsSorted[] = new String[apps.size()];
		int i = 0;

		for (App r : apps) {
			appsSorted[i] = r.getName();
			i++;
		}

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
	public static App createApp(String[] meta) {
		String name = meta[0];
		String about = meta[1];
		String platform = meta[2];
		String versions = meta[3];
		String price = meta[4];
		String category = meta[5];
		String storeName = meta[6];
		String storeLink = meta[7];

		return new App(name, about, platform, versions, price, category, storeName, storeLink);
	}

}
